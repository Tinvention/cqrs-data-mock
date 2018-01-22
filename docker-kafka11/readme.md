Docker - Kafka 0.11
==========

A container that runs zookeeper and Kafka v0.11. 

The only configuration available is the ADVERTISED_HOST: if you run linux the default value (172.17.0.1) should be fine.This is the host address for the docker0 network. If, for any reason, your docker0 network is on a different address, please change it.

Ports are fixed to the default ones (2181 and 9092)

Build the image with `docker build .` and then run it: `docker run  -p2181:2181 -p9092:9092 -it --rm --hostname localhost <image_id>`

To run with docker compose the configuration should be similar to:
```
  kafka11-mock:
    build:
       context: docker-kafka11
    environment:
     - ADVERTISED_HOST=172.17.0.1
    ports:
     - "2181:2181"
     - "9092:9092" 
```