#!/bin/bash
cd ${0%/*}
set -eu

gradle build
docker build --rm -t orders-es:1 .
docker run --rm --name orders -p 8001:8080 orders-es:1