# main/resources package
This package contains the server setup information required for setup of the embedded Apache Tomcat server.
- ## Contents
  - ### application.properties
    This files is created by default and as such is manditory. Listed are all the setttings and their purpose:
    
    |Setting|Purpose|
    |:---:|:---:|
    |`server.port=8081`|Configures the Tomcat server to run on port 8081, can be used to prevent port conflicts|
    |`spring.application.name=GatewayApi`|Sets the name of the application, for use in conjunction with the eureka discovery service|
    |`spring.data.mongodb.host=localhost`|Denotes the "ip" address the database is located on, in this case localhost represents `127.0.0.1`|
    |`spring.data.mongodb.port=27017`|Determines which port the service will attempt to connect to in order to establish connection with the database|
    |`spring.data.mongodb.database=ApartmentManager`|Sets the name of the database to create for the application within the mongoDB system|
    
  - ### data.sql
    This file is a leftover from a previous iteration of the system, which was designed to run with SQL. Has not been removed for posterity's sake.
    Should someone wish to swap database, this information will provide an idea of how it might run however, this is not a perfect example.
