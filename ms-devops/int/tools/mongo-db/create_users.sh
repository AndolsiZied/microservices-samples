#!/usr/bin/env bash
echo "Creating mongo users..."
mongo admin --host localhost -u ms-username-int -p ms-username-int --eval "db = db.getSiblingDB('test');db.createUser({user: 'msApp', pwd: 'msApp', roles: [{role: 'readWrite', db: 'test'}]});"
echo "Mongo users created."