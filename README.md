cqrs-mock-data-generator
==========
A mock data generator: emulates the samples flow coming from an industrial plant. Events are published to a kafka queue as json.

### Build and Start

* Edit the docker-compose-dev.example.yml
     - If you use Windows put your ip address in ADVERTISED_HOST (line 12)
		 - If you use linux you're fine
	 - Configure the mock server parameters:
	     - producer.sleep.ms=100 The number of ms to wait between the generation of a sample and the next one
    	 - main=SingleRunSampleProducer 
			- SingleRunSampleProducer if you want the mock to generate a set of singlerun.numitems samples
	     	- InfiniteSampleProducer if you want the server to continuously generate samples

* cd to the java project directory "mock-data-generator" and run

    > mvn clean package docker:build -Dmock.skip=false


* > cd ..

* from your shell run:

	>	docker-compose -f docker-compose-dev.example.yml up

* now you're ready to code: 
	- you have a kafka broker running on port 2181
	- you have a samples generator that writes fake data to the "cqrs-mock-plant" topic
    - every sample is a simple json like:
```
{
	"source":"VPLQDTB15BHH",
	"timestamp":1513788705689,
	"value":-11.500964
}
```
### Test it
You can connect to the topic with the standard CLI kafka consumer: download kafka_2.11-0.11.0.2.tgz and unzip it, then run (from the bin directory):

`./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic cqrs-mock-plant -from-beginning`

you should be able to see the messages flowing.
```
{"source":"TEMPERATURE_HDVAM78","timestamp":1516721388421,"value":36.78537}
{"source":"TEMPERATURE_HDVAM78","timestamp":1516721388521,"value":36.505203}
{"source":"TEMPERATURE_HDVAM78","timestamp":1516721388622,"value":37.034294}
{"source":"IN_VOLTAGE","timestamp":1516721388722,"value":27.547136}
{"source":"PRESSURE_KJYTD25ZAA","timestamp":1516721388822,"value":-26.187601}
```


### Maven unit tests
     
As usual...

> mvn clean test
    
### Eclipse unit tests

  Run any test placed in the src/test/java source folder


### REQUIREMENTS
* java 8
* maven
* docker and docker-compose

