# integration-camel-restlet
An example how to intercommunicate with two services over HTTP:
One of it is an integration service which is using Camel and Restlet and packing into JAR archive. So we can add this project like a maven dependency.
The seconde one is an external independent Rest service which is based on CXF JAX-RS an packaging as WAR archive + delivered to start on Jetty server with port 9094.

