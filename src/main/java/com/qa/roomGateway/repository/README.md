
# Repository Package
This is the package for the repository layer of the application, Contained Files:
- ## ApartmentRepo.java
	The interface by which all communication with the database is done.
- #### **Examples**
	- Below is a list of functions and their uses:
		(All requisites for a function are written in bold)
	
		| Function|Use|
		|----------|---|
		| findByTitle| Uses the **Title** column to produce a **list** of Apartments that match
		| findByBuilding| Uses the **Building** column to produce a **list** of Apartments that match|
		| findRoomByTitle| Uses the **Title** column to produce a **singular** Room, from within an apartment|
		| getApartmentsByLandlord| Uses the **Landlord** column to produce a **list** of Apartments|
		| getApartmentsByCurrentState|Uses the **Current State** column to produce a **list** of apartments|
		| getApartmentsByBuildingAndTitle|Uses a combination of the **Building** and **Title** columns to produce a **list** of apartments|
		| delete| Requires an **Apartment** to match an entry in the database, which will be deleted|
