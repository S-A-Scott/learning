#!/usr/bin/fish

# Backs up all files in current directory modified within last 24 hours

# if no backup archive filename specified on command-line,
# it will default to "backup-MM-DD-YYYY.tar.gz"
if test -z $argv[1]
	set archive "backup-"(data +%m-%d-%Y)
else
	set archive $argv[1]
end

tar zcvf $archive.tar.gz (find . -mtime -1 -type f -print)
echo "Directory (pwd) backed up in archive file $archive.tar.gz"

