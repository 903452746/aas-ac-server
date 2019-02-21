#!/bin/bash

# 创建logs文件夹
path=`pwd`/logs

if [ ! -d $path ]; then
 mkdir -p $path
 echo $path is created!!!
fi

# 执行jar
nohup java -jar aas-ac-server.jar >/dev/null 2>&1 &

echo starting
