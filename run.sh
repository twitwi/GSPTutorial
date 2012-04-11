#!/bin/sh

export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:.
# we add '.' for the gstreamer symbolik link because the ubuntu package does not provide the .so file (just a .so.0 one)

MOREOPT="-Djna.nosys=true"

java -cp 'lib/*:.' $MOREOPT fr.prima.gsp.Launcher "$@"

