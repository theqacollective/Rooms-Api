

# Entity Package
This is the package for the Entity layer of the application, Contained Files:
- ## Apartment.java
	The main class containing all pertinent information for the apartment entity and subsequent column properties.
	
	|Variable|Coverage|
	|:---:|:---:|
	|building|Defines the building to which the apartment belongs|
	|isIsOpen| Used for the timeline, contains duplicate "is" as a result of the first "being" removed for being a boolean|
	|title|Used as the apartment Number variable, called "title" so the Timeline component can use it without the difficulty of recursively changing the name in the Front end|
	| elements| An array of events (Which are tenant assignments) that correspond to the Apartment track, designed to be empty as no tenant can be assigned to an entire apartment |
	|roomNumber| More accurately "Maximum Occupancy"|
	|tracks|An Array containing all the subsequent information on every room within the apartment, once again, named as such for ease of use in the Front End|
	|currentState|A variable used to track the current cleanliness level of a room|
	|landlord|The name of the Landlord responsible for the apartment|
	
- ## Room.java
The entity class for each individual room, which are embedded as a list in the Apartment class:

|Variable| Coverage|
|:---:|:---:|
|title| Primarily set to "Room x" by the Front End, designed to denote the name of each room|
|elements| Similar to the Apartment variable of the same name, this column contains the tenant assignments relevant to the room|

- ## Event.java
The entity class for the events, used to denote the room assignments. Called as such for ease of use in the Front End.

|Variable|Coverage|
|:---:|:---:|
|title| The name of the tenant being assigned, once again named for Front End use|
|start|Beginning date for tenancy|
|end|Last date of tenancy|
		
- #### **Example**
	Structure of singular apartment entity:
	- Apartment:
		- id
		- building
		- isOpen
		- title
		- elements
			- (Typically Blank, neccesary for functionality)
		- roomNumber
		- tracks
			- id
			- title
			- elements
				- id
				- title
				- start
				- end
		- currentState
		- landlord
