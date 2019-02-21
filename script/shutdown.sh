#!/bin/bash

findstr=`echo "java -jar aas-ac-server.jar"`
echo "$findstr"
#echo "ps -ef|grep '$findstr' |grep -v 'grep'"
pid=$(ps -ef|grep "$findstr" |grep -v "grep" | awk '{print $2}')

if [ ! -n "${pid}" ]; then
	echo "pid ЮЊПе"
else
	echo "$pid"
	kill -9 ${pid}
fi
