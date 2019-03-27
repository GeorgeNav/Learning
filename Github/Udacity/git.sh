# Comparing two files
# + means line was added
# - means line was removed
    diff -u file1.extension file2.extension
    diff --staged; # compares staged files to latest commit?
# Add changes to future commit
    git add -A;
    git add .;
# Commit changes with message
    git commit -m "hello world";
# Reset commit
    git reset;
# Checks for changes
    git status
# Fetches and merges from/to
# the remote repository (origin)
# and branch (master)
    git pull origin master;
    git pull origin master --allow-unrelated-histories;
# Push the committed changes
    git push -u origin master # sets this remote (origin) and branch (master) as default when pushing
    git push; # after default is set, this will push changes to default remote and branch
# Revert changes to a file to a previous commit
    git log; git log --staged; # git history of commits, copy SHA key
    git revert <SHA key>; # revert changes of a specified commit
    git revert HEAD; # revert changes of the lastest commit
