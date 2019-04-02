package com.qa.roomGateway.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.roomGateway.entity.Apartment;
import com.qa.roomGateway.repository.ApartmentRepo;

@Service
public class ApartmentService {

	public ApartmentService(ApartmentRepo repo) {
		this.repo = repo;
	}

	private ApartmentRepo repo;

	public String addApartment(Apartment apartment) {
		System.out.println(apartment.getTracks());
		repo.save(apartment);
		return "{\"message\":\"apartment added\"}";
	}

	public List<Apartment> getAllApartments() {
		return this.repo.findAll();
	}

	public List<Apartment> getApartmentsByNumber(String request) {
		return this.repo.findByTitle(request);
	}

	public List<Apartment> getApartmentsByBuilding(String request) {
		return this.repo.findByBuilding(request);
	}

	public List<Apartment> getApartmentsByLandlord(String request) {
		return this.repo.getApartmentsByLandlord(request);
	}
	public Apartment getApartmentsByBuildingAndApartmentNumber(String building, String apartmentNumber)
	{
		return this.repo.getApartmentsByBuildingAndTitle(building,apartmentNumber);
	}
	public String deleteApartment(String building, String apartmentNumber){
		this.repo.delete(repo.getApartmentsByBuildingAndTitle(building,apartmentNumber));
		return "Deleted Successfully";
	}

//	public String updateApartment(String apartmentReference, Apartment updatedApartment) {
//		Apartment currentDetails = this.repo.getApartmentByApartmentId(updatedApartment.getApartmentId());
//		currentDetails.setCurrentState(updatedApartment.getCurrentState());
//		currentDetails.setLandlord(updatedApartment.getLandlord());
//		repo.save(currentDetails);
//		return "{\"message\":\"apartment updated\"}";
//	}
//	public ResponseEntity<List<Apartment>> deleteApartment(Integer apartmentNumber) {
//		List<Apartment> apartment = repo.delete(repo.findByApartmentNumber(apartmentNumber));
//		return new ResponseEntity<List<Apartment>>(apartment, HttpStatus.OK);
//	}
}
