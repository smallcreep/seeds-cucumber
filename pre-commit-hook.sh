#!/bin/bash

set -ex
set JAVA_HOME=/usr/lib/jvm/java-8-oracle
mvn clean
pdd --file=/dev/null
mvn install -Pqulice -Pintegration -Pcucumber