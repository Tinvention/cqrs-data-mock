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
 
### Maven unit tests
     
As usual...

> mvn clean test
    
### Eclipse unit tests

  Run any test placed in the src/test/java source folder


### REQUIREMENTS
* java 8
* maven
* docker and docker-compose

