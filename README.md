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
**1. V0-configuration-server-fs:**

This version contains a sample crud webapp that allows you to make reservations in restaurants.
Spring Cloud configuration server with file systeme backend is used to centralize configuration files.

**2. V0-configuration-server-git:**

The difference with the previous version is at the server configuration. In fact, the server looks for profile
 files from git.
 
**3. V0-configuration-server-git-refresh:** 
 
In this version, a refresh scope was added to update some beans when related properties changed. To see new values, à
 `curl -d {} service-host:8080/refresh` must be invoked.
 
**4. V0-configuration-server-git-encrypt:** 
 
In this tag, I  use symmetric cryptography to encrypt property values in a symmetric way. For this, I define an environment variable 
`ENCRYPT_KEY` in server-side (configuration server) and client-side (services server).

To get encrypted property, you can call encrypt configuration serevr endpoint : 
`export ENCRYPTED='curl config-server/encrypt -d ms-password'`

**5. V1-discovery-server-discovery-client:**

The purpose of this release is to show how a micro-service looks for another micro service using the discovery client.

The use case is simple: Save a reservation and update the reservation list of the establishment.

POST /api/establishments/

`{"name":"Establishment test", "stars":5, "tables": [{"code":"1", "places":2, "bookings":[]}]}`

POST /api/bookings/

`{
 	"bookingTime": "2017-12-29T20:00:00",
 	"reservationFor":"5a4b5dd530c49e00065c6f2a",
 	"reservationBy":"test-user",
 	"table":"1"
 }`
 
 **6. V1-discovery-server-ribbon:**
 
 This time, rather than using the url of the service we want to call, we're going to use instance ID in the URL with 
 `Ribbon-backed RestTempalte`. 
 
  **7. V1-discovery-server-feign-client:**
  In this version, we use another alternative based on Netflix’s Feign client library.

