package com.qa.roomGateway.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.qa.roomGateway.entity.Apartment;


@Repository
public interface ApartmentRepo extends MongoRepository<Apartment, String>{
	public List<Apartment> findByTitle(String title);

	public List<Apartment> findByBuilding(String building);
	
	public List<Apartment> getApartmentsByLandlord(String request);
	public List<Apartment> getApartmentsByLandlord();
	public void delete(Apartment apartment);

	public Apartment getApartmentsByBuildingAndTitle(String building, String title);
	
	
}
