//package cz.cvut.fel.esw.nonblock.map;
//
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
//import java.util.concurrent.atomic.AtomicReferenceArray;
//
//public class Counter {
//
//    private int counter;
//
//    public void increment() {
//        counter++;
//    }
//
//
//
//
//
//
//    public class SyncCounter {
//
//        private volatile int counter;
//
//        // zamkne, vytvori zamek na objektu
//        // ekvivalentni jako
//        // synchronized(this) {
//        //     counter++;
//        // }
//        public synchronized void increment() {
//            counter++;
//        }
//
//    }
//
//    public class AtomicCounter {
//
//        private final AtomicInteger counter = new AtomicInteger();
//
//        public void increment() {
//            counter.incrementAndGet();
//        }
//
//    }
//
//    public class AtomicCounter {
//
//        private static final AtomicIntegerFieldUpdater<AtomicCounter> fu =
//                AtomicIntegerFieldUpdater.newUpdater(AtomicCounter.class, "counter");
//        private final AtomicInteger counter = new AtomicInteger();
//
//        public void increment() {
//            counter.incrementAndGet();
//        }
//
////        public void add(int value) {
////            int i = counter.get();
////            i += value;
////
////            // setneme zpet, fungovat to ale nebude => CAS
//////            counter.set(i);
////
////            counter.compareAndSet(i);
////
////        }
//
//        public void add(int value) {
//            int exp;
//            int sum;
//            do {
//                exp = counter.get();
//                sum = exp + value;
//
//
//                // assumption: counter is not changed by other threads
//                // overujeme zda plati, pokud jo je to v pohode, ulozime a vratime true
//                // pokud je hodnota jina, nic se nestane a CAS vrati false
////                counter.compareAndSet(exp, sum);
//
//            } while (!counter.compareAndSet(exp, sum));
//
//        }
//        public void add2(int value) {
////            AtomicReferenceArray<Integer> array = new AtomicReferenceArray<>(10);
////            array.compareAndSet()
//
//
//            int exp;
//            int sum;
//            do {
//                exp = counter.get();
//                sum = exp + value;
//
//
//                // assumption: counter is not changed by other threads
//                // overujeme zda plati, pokud jo je to v pohode, ulozime a vratime true
//                // pokud je hodnota jina, nic se nestane a CAS vrati false
////                counter.compareAndSet(exp, sum);
//
//            } while (!counter.compareAndSet(exp, sum));
//
//        }
//
//        public void add3(int value) {
////            AtomicReferenceArray<Integer> array = new AtomicReferenceArray<>(10);
////            array.compareAndSet()
//
//
//            int exp;
//            int sum;
//            do {
//                exp = counter.get();
//                sum = exp + value;
//
//
//                // assumption: counter is not changed by other threads
//                // overujeme zda plati, pokud jo je to v pohode, ulozime a vratime true
//                // pokud je hodnota jina, nic se nestane a CAS vrati false
////                counter.compareAndSet(exp, sum);
//
//            } while (!counter.compareAndSet(exp, sum));
//
//        }
//
//
//
//
//    }
//
//
//
//}
//
//
