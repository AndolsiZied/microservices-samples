microservices-samples
=================

## Overview
The objective of this project is to propose a simplified microservices architecture based on spring-boot and spring-cloud.
The project is organized as follows:

**1. ms-domain :** Regroups the business microservices.

**2. ms-technical-platform :** Regroups the technical microservices.

**3. ms-technical-devops :** Regroups files used in the deployment.
       


## Build Requirements

1. Java 8
2. Apache Maven 3
 
## Runtime Requirements
 
1. Docker
2. Docker compose


## Versions
1. V0-configuration-server-fs:

This version contains a sample crud webapp that allows you to make reservations in restaurants.
Spring Cloud configuration server with file systeme backend is used to centralize configuration files.

2. V0-configuration-server-git: 

The difference with the previous version is at the server configuration. In fact, the server looks for profile
 files from git.
 
3. V0-configuration-server-git-refresh: 
 
In this version, a refresh scope was added to update some beans when related properties changed. To see new values, à
 ` curl -d {} service-host:8080/refresh` must be invoked.
