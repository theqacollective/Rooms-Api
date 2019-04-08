# Service Package
This is the package for the service layer of the application, Contained Files:
- ## ApartmentService.java
	Designed to hide all the implantation of functions. Any functions created in the repository layer will be implemented here to allow usee of them.
- #### **Examples**
	- Below is the service layer implementation of the addApartment Method, when called this function calls to the repository and passes through the `Apartment`, that it is handed, to the repository layer, which will in turn handle the information.
	```
	public String addApartment(Apartment apartment) {
		System.out.println(apartment.getTracks());
		repo.save(apartment);
		return "Apartment Added";
	}
	```
