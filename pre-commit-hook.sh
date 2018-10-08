#!/bin/bash

set -ex

pdd --file=/dev/null

mvn clean
mvn install -Pqulice