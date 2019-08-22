#!/bin/bash
sh print.sh ./docs/markdown
git add --all
if [ ! -n "$1"  ] ;then
    git commit -am "new commit"
else
    git commit -am "$1"
fi
git push