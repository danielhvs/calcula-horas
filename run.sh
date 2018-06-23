#!/bin/sh
# Execute lein uberjar para criar o jar primeiro
java -jar target/uberjar/calculadora-1.0-SNAPSHOT-standalone.jar $*
