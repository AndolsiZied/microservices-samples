#!/bin/sh
echo "-----------------------------"
echo "Starting Establishment Server"
echo "-----------------------------"
s=20
echo "Waiting $s for configuration server"
sleep $s
java -jar /usr/local/services/@project.build.finalName@.jar