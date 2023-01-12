git reflog |  awk '{ print $1 }' | xargs gitk
git rev-parse --abbrev-ref HEAD
