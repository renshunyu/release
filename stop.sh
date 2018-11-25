#!/bin/bash
PID=$(cat ./release.pid)
echo $PID
kill -9 $PID