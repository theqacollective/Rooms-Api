# RoomGateway Package
This folder is the container for the java code required to run the project below is an over view of the contents;

- ## Constants.java
	Contains all the constants that are used, mostly endpoints and test data examples designed to be used with JUnit
- #### **Examples**
	- Test Data:  
	`private  static  final  String  APARTMENT_ID  =  "TestFirst";`
	-  Gateway Endpoint:
	`private  static  final  String  UPDATE_URL  =  "/updateApartment/{roomReference}";`
	
- ## RoomsGatewayApiApplication.java
	This is the main application file for the repository, this runs the project. This file also contains a CORS Filter designed to circumvent the Cross-Origin Resource Sharing policy which prevents requests between two different domains, of which two applications on the same computer, that use different ports are treated as two domains. This is a fix to prevent an error from being thrown.
