# Comparing two files
# + means line was added
# - means line was removed
    diff -u file1.extension file2.extension
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
    git push;
