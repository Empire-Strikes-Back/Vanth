#!/bin/bash

shadow(){

  npm i --no-package-lock
  clj -A:dev -M -m shadow.cljs.devtools.cli "$@"

}

watch(){
  mkdir -p out
  cp src/Vanth/index.html out
  cp src/Vanth/style.css out
  shadow watch :main :ui-main
}

repl(){
  shadow clj-repl
  # (shadow/watch :main)
  # (shadow/repl :ui-main)
  # :repl/quit
}

compile(){
    rm -rf out
    npm i
    mkdir -p out
    cp src/Vanth/index.html out
    cp src/Vanth/style.css out
    shadow release :main :ui-main
}

release(){
  rm -rf out/bin
  npx electron-packager . "Boimler-$(git rev-parse --short HEAD)" --out=./out/bin --all --asar
}

cljs_compile(){
    clj -m cljs.main -co cljs-build.edn -c
    #  clj -A:dev -m cljs.main -co cljs-build.edn -v -c # -r
}

"$@"