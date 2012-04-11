#!/bin/sh

export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:.
# we add '.' for the gstreamer symbolik link because the ubuntu package does not provide the .so file (just a .so.0 one)


java -cp 'lib/*' fr.prima.gsp.Launcher "$@"
