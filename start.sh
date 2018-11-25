#!/bin/bash
nohup java -classpath ".:./lib/*"  com.asiainfo.release.Issue> stdout.log &
echo $! > ./release.pid