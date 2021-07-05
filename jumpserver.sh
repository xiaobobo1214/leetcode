#!/usr/bin/expect -f
set user wangbo16
set host jumpserver.baijia.com
set password xiaobobo@@1
set timeout -1

spawn ssh $user@$host
expect "*assword:*"
send "$password\r"
interact
