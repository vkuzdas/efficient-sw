protobuf_dep = dependency('protobuf')
  add_project_arguments('-O2',  language : 'cpp')

srcs = [
'kdtree.cpp',
'epoll/server.cpp',
'main.cpp',
'proto/messages.pb.cc',
'epoll/instance.cpp',
'epoll/binder.cpp',
'epoll/fd.cpp'
]

executable('main', srcs,
  dependencies: [protobuf_dep]
  )
