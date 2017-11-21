#!/bin/sh
echo "-----------------------------"
echo "Starting Configuration Server"
echo "-----------------------------"
fileName=@project.build.finalName@
#uncomment this lines if you launch docker behind proxy
#proxyHost="-Dhttps.proxyHost=server_ip"
#proxyPort="-Dhttps.proxyPort=server_port"
#proxyUser="-Dhttps.proxyUser=user"
#proxyPassword="-Dhttps.proxyPassword=password"
java $proxyHost $proxyPort $proxyUser $proxyPassword -jar /usr/local/services/$fileName.jar