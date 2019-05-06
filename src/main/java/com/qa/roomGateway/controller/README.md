

# Controller Package
This is the package for the Controller layer of the application, Contained Files:
- ## Controller.java
	This file is the endpoint for the application, as this repository acts as the gateway API for the apartment management system there are references to the different APIs that connect to this one.
	
	|Mapping |Function|Purpose|
	|:---:|:---:|:---:|
	|POST|addApartment|Creates an apartment, calls to the service layer|
	|GET|getAllApartments|Returns a **list** of every apartment in the database|
	|GET|getApartmentsByNumber|Currently *unused* function it finds a **list** of apartments based on the maximum capacity of a room|
	|GET|getApartmentsByBuilding|Used to return a **list** of apartments filtered by which **building** they belong to|
	|GET|getApartmentsByLandlord|Returns a **list** of apartments based on which landlord they belong to|
	|GET|getApartmentsByCurrentState|Filters apartments to return a **list** including only a particular state|
	|DELETE|deleteApartment|Matches the given apartment and deletes it, returns a **string** response|
	|PUT|updateApartment|Takes in information on an apartment applies it to an existing apartment based on **building** name and **title**|
	|PUT|addEvent|Requires **building** name, **title** and **roomNumber**, to specify where to add the event, attaches it to the **elements** column of the specified apartment|
	|DELETE|deleteEvent|Takes 4 parameters (**building**,**apartmentNumber**,**title** and **roomNumber**) which specify the target event, then deleted it|
	|PUT|addRoom|Creates a room and attaches it to the specified apartment, selected by **building** and **apartmentNumber**|

	- The next section is dedicated to the micro-service links:
	
	|API|Mapping|Function|
	|:---:|:---:|:---:|
	|Building|GET|getBuildings|
	|Building|GET|buildingSearch|
	|Building|DELETE|deleteBuilding|
	|Building|POST|createBuilding|
	|Tenant|POST|createTenant|
	|Tenant|GET|getAllTenants|
	|Tenant|GET|tenantSearch|
	|Tenant|GET|findTenantByFirstName|
	|Tenant|GET|findTenantByLastName|
	|Tenant|GET|findTenantByGroupName|
	|Tenant|DELETE|deleteAllTenants|
	|Tenant|DELETE|deleteTenantGroup|
	|Tenant|DELETE|deleteTenant|
	|Tenant|PUT|updateTenant|
	|Tenant|PUT|updateTenantGroup|
	|Landlord|POST|createLandlord|
	|Landlord|GET|getAllLandlords|
	|Landlord|GET|landlordSearch|
	|Landlord|DELETE|deleteLandlord|
	|Landlord|PUT|updateLandlord|
	|Maintenance|POST|createMaintenance|
	|Maintenance|GET|getAllMaintenance|
	|Maintenance|GET|maintenanceSearch|
	|Maintenance|DELETE|deleteMaintenance|
	|Maintenance|PUT|updateMaintenance|
	
