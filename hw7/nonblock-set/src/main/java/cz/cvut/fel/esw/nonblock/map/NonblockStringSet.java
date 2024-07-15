package cz.cvut.fel.esw.nonblock.map;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class NonblockStringSet implements StringSet {

    private final int mask;
    private final AtomicInteger size = new AtomicInteger(0);
    private final AtomicReferenceArray<Node> bins;


    public NonblockStringSet(int minSize) {
        if (minSize <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }
        int binsLength = Utils.smallestGreaterPowerOfTwo(minSize);
        this.mask = binsLength - 1;
        this.bins = new AtomicReferenceArray<>(binsLength);
    }

    @Override
    public void add(String word) {
        int binIndex = getBinIndex(word);

        if (bins.compareAndSet(binIndex, null, new Node(word))) {
            size.incrementAndGet();
            return;
        }

        Node bin = bins.get(binIndex);
        while (true) {
            if (bin.word.equals(word)) {
                return;
            } else {
                if (Node.nextUpdater.compareAndSet(bin, null, new Node(word))) {
                    size.incrementAndGet();
                    return;
                }
                bin = bin.next;
            }
        }
    }

    @Override
    public boolean contains(String word) {
        int binIndex = getBinIndex(word);
        if (this.bins.compareAndSet(binIndex, null, null)) {
            return false;
        }
        Node bin = this.bins.get(binIndex);
        while (true) {
            if (bin.word.equals(word)) {
                return true;
            } else {
                if (bin.compareAndSetNext(null, null)) {
                    return false;
                }
                bin = bin.next;
            }
        }
    }

    @Override
    public int size() {
        return this.size.get();
//        return calculateSize();
    }

    private int calculateSize() {
        //calculate size by walking through the set
        int size = 0;

        // pro kazdej Node
        for (int i = 0; i < bins.length(); i++) {
            Node curr = bins.get(i);
            if (curr != null) {
                size++;
                curr = bins.get(i).next;

                // pro kazdej clen v linked listu
                while (curr != null) {
                    size++;
                    curr = curr.next;
                }
            }
        }
        return size;
    }

    private int getBinIndex(String word) {
        return word.hashCode() & mask;
    }

    private static class Node {

        private final String word;
        private volatile Node next;
        static final AtomicReferenceFieldUpdater<Node, Node> nextUpdater =
                AtomicReferenceFieldUpdater.newUpdater(Node.class, Node.class, "next");

        public Node(String word) {
            this(word, null);
        }

        public Node(String word, Node next) {
            this.word = word;
            this.next = next;
        }

        public boolean compareAndSetNext(Node expect, Node update) {
           return  nextUpdater.compareAndSet(this, expect, update);
        }

    }
}
