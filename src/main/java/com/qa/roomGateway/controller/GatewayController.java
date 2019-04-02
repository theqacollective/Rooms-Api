package com.qa.roomGateway.controller;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;
import com.qa.roomGateway.entity.Apartment;
import com.qa.roomGateway.service.ApartmentService;

@CrossOrigin(origins = "localhost:3000")
@RestController
public class GatewayController {

	public GatewayController(EurekaClient client, ApartmentService service, RestTemplateBuilder rtb) {
		this.client = client;
		this.service = service;
		this.rtb = rtb;
	}

	private EurekaClient client;

	private ApartmentService service;

	private RestTemplateBuilder rtb;

	@PostMapping("/createApartment")
	public String addApartment(@RequestBody Apartment apartment) {
		return service.addApartment(apartment);
	}

	@GetMapping("/getAllApartments")

	public List<Apartment> getAllApartments() {
		return this.service.getAllApartments();
	}

	@GetMapping("/getApartmentByNumber/{request}")
	public List<Apartment> getApartmentsByNumber(@PathVariable("request") String request) {
		return service.getApartmentsByNumber(request);
	}

	@GetMapping("/getApartmentByBuilding/{request}")
	public List<Apartment> getApartmentsByBuilding(@PathVariable("request") String request) {
		return service.getApartmentsByBuilding(request);
	}

	@GetMapping("/getApartmentByLandlord/{request}")
	public List<Apartment> getApartmentsByLandlord(@PathVariable("request") String request) {
		return service.getApartmentsByLandlord(request);
	}

	@DeleteMapping("/deleteApartment/{requestString}/{requestInt}")
	public String deleteApartment(@PathVariable("requestString") String building,
			@PathVariable("requestInt") String apartmentNumber) {
		return service.deleteApartment(building, apartmentNumber);
	}

//  @PathVariable ("parameter")String parameter, 
//	@PutMapping("/updateApartment/{apartmentReference}")
//	public String updateApartment(@PathVariable("apartmentReference")String apartmentReference, @RequestBody Apartment updatedApartment) {
//		return service.updateApartment(apartmentReference, updatedApartment);
//	}

	// send to microservices
	@GetMapping("/getAllBuildings")
	public String getBuildings() {
		return this.rtb.build().exchange(client.getNextServerFromEureka("BuildingAPI", false).getHomePageUrl()+"getAllBuildings", 
				HttpMethod.GET, null, String.class).getBody();
	}
	
	@GetMapping("/buildingSearch")
	public String buildingSearch(@RequestBody Object entity) {
		return this.rtb.build().exchange(client.getNextServerFromEureka("BuildingAPI", false).getHomePageUrl()+"buildingSearch", 
				HttpMethod.GET, new HttpEntity<Object>(entity), String.class).getBody();
	}
	
	@DeleteMapping("/deleteBuilding")
	public String deleteBuilding(@RequestBody Object entity) {
		return this.rtb.build().exchange(client.getNextServerFromEureka("BuildingAPI", false).getHomePageUrl()+"deleteBuilding", 
				HttpMethod.DELETE, new HttpEntity<Object>(entity), String.class).getBody();
	}

	@PostMapping("/createBuilding")
	public String createBuilding(@RequestBody Object entity) {
//		HttpEntity<String> entity = new HttpEntity<>(@RequestBody, requestHeaders);
		return this.rtb.build().exchange(client.getNextServerFromEureka("BuildingAPI", false).getHomePageUrl()+"createBuilding", 
				HttpMethod.POST, new HttpEntity<Object>(entity), String.class).getBody();
	}
	// get tenants

	// add tenants

	// update tenants

	// delete tenants
}
