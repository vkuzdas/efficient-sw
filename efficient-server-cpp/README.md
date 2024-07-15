1) enter nix-shell
    > nix-shell
2) generate proto classes
    > protoc --cpp_out=src proto/messages.proto
3) turn on server:
    > meson setup builddir
    
    > meson compile -C builddir
    
    > ./builddir/src/main <port_number>
