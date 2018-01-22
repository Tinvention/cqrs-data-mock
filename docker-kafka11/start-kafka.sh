#!/bin/bash

echo "starting kafka"

bin/kafka-server-start.sh -daemon config/server.properties
