#!/bin/bash

term_handler(){
    echo "Stopping server(s)..."

    PIDS=$(ps ax | grep java | grep -v grep | awk '{print $1}')

    if [ -z "$PIDS" ]; then
        echo "No zookeeper/kafka servers to stop"
    else
        kill -s TERM $PIDS
    fi

    exit 0
}

trap 'term_handler' SIGTERM SIGINT

echo "sedding ADVERTISED_HOST with ${1}"

sed -i -e 's|$ADVERTISED_HOST|'"${1}"'|g' config/server.properties

echo "Launching Zookeeper and Kafka"

sh start-zookeeper.sh
sh start-kafka.sh
echo "Launched"

sleep 1
tail -f logs/server.log logs/zookeeper.out &

wait
