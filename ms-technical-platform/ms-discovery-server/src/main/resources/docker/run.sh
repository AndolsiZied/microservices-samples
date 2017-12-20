#!/bin/sh
echo "-----------------------------"
echo "Starting Discovery Server"
echo "-----------------------------"
fileName=@project.build.finalName@
#uncomment this lines if you launch docker behind proxy
proxyHost="-Dhttps.proxyHost=192.168.102.78"
proxyPort="-Dhttps.proxyPort=9707"
proxyUser="-Dhttps.proxyUser=8003119"
proxyPassword="-Dhttps.proxyPassword=@ndolsI1"
java $proxyHost $proxyPort $proxyUser $proxyPassword -jar /usr/local/services/$fileName.jar