package com.qa.roomGateway.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.qa.roomGateway.entity.Apartment;
import com.qa.roomGateway.entity.Room;

@Repository
public interface ApartmentRepo extends MongoRepository<Apartment, String> {
	public List<Apartment> findByTitle(String title);

	public List<Apartment> findByBuilding(String building);

	public Room findRoomByTitle(String title);

	public List<Apartment> getApartmentsByLandlord(String landlord);

	public List<Apartment> getApartmentsByCurrentState(String currentState);

	public Apartment getApartmentsByBuildingAndTitle(String building, String title);

	public void delete(Apartment apartment);
}
