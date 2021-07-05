#!/usr/bin/expect -f
set user xiaobobo
set host 182.92.98.57
set password a994301552@
set timeout -1

spawn ssh $user@$host
expect "*assword:*"
send "$password\r"
interact
