#!/bin/bash
# get all filename in specified path
SAVEIFS=$IFS
IFS=$'\n' # make newlines the only separator
path=$1
files=$(ls $path)
echo "" >./docs/_sidebar.md
for j in $files; do
  name=${j:0:$((${#j} - 0 - 3))}
  url=${name// /%20}
  printf "* [$name](markdown/%s)\n" "$url" >>./docs/_sidebar.md
done
IFS=$SAVEIFS
