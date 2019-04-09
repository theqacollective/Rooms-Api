package com.qa.roomGateway.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.qa.roomGateway.entity.Apartment;
import com.qa.roomGateway.entity.Event;
import com.qa.roomGateway.entity.Room;
import com.qa.roomGateway.repository.ApartmentRepo;

@Service
public class ApartmentService {

	public ApartmentService(ApartmentRepo repo) {
		this.repo = repo;
	}

	private ApartmentRepo repo;

	public String addApartment(Apartment apartment) {
		if (this.repo.getApartmentsByBuildingAndTitle(apartment.getBuilding(), apartment.getTitle()) != null) {
			return "Apartment Already Exists";
		}
		repo.save(apartment);
		return "Apartment Added";
	}

	public Room findRoomByTitle(String title) {
		return this.repo.findRoomByTitle(title);
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

	public List<Apartment> getApartmentsByCurrentState(String currentState) {
		return this.repo.getApartmentsByCurrentState(currentState);
	}

	public Apartment getApartmentsByBuildingAndApartmentNumber(String building, String apartmentNumber) {
		return this.repo.getApartmentsByBuildingAndTitle(building, apartmentNumber);
	}

	public String deleteApartment(String building, String apartmentNumber) {
		if (repo.getApartmentsByBuildingAndTitle(building, apartmentNumber) == null) {
			return "Requested Apartment Does Not Exist";
		}
		this.repo.delete(repo.getApartmentsByBuildingAndTitle(building, apartmentNumber));
		return "Deleted Successfully";
	}

	public String updateApartment(String building, String apartmentNumber, Apartment updatedApartment) {
		Apartment currentDetails = this.repo.getApartmentsByBuildingAndTitle(building, apartmentNumber);
		currentDetails.update(updatedApartment);
		this.repo.save(updatedApartment);
		this.repo.delete(updatedApartment);
		return "Apartment Updated";
	}

	public String addRoom(String building, String apartmentNumber, Room room) {
		Apartment newDetails = new Apartment();
		Apartment currentDetails = this.repo.getApartmentsByBuildingAndTitle(building, apartmentNumber);
		List<Room> currentRooms = new ArrayList<>();
		currentRooms.addAll(currentDetails.getTracks());
		currentRooms.add(room);
		newDetails.setTracks(new HashSet<Room>(currentRooms));
		currentDetails.update(newDetails);
		this.repo.delete(currentDetails);
		this.repo.save(currentDetails);
		return "Room Updated";

	}

	public String deleteEvent(String building, String apartmentNumber, String room, String title) {
		Apartment newDetails = new Apartment();
		Apartment currentDetails = this.repo.getApartmentsByBuildingAndTitle(building, apartmentNumber);
		List<Room> currentRooms = new ArrayList<>();
		currentRooms.addAll(currentDetails.getTracks());
		for (int i = 0; i < currentRooms.size(); i++) {
			if (currentRooms.get(i).getTitle().equals(room)) {
				List<Event> newEvents = new ArrayList<>();
				List<Event> removedEventList = new ArrayList<>();
				newEvents.addAll(currentRooms.get(i).getElements());
				for (int j = 0; j < newEvents.size(); j++) {
					if (newEvents.get(j).getTitle().equals(title)) {
						j++;
					} else {
						removedEventList.add(newEvents.get(j));
					}

				}
				currentRooms.get(i).setElements(new HashSet<Event>(removedEventList));
				newDetails.setTracks(new HashSet<Room>(currentRooms));
				currentDetails.update(newDetails);
				this.repo.delete(currentDetails);
				this.repo.save(currentDetails);
				return "Assignment Deleted";
			}
		}
		return "Error: Invalid Input!";
	}

	public String addEvent(String building, String apartmentNumber, String room, Event event) {
		Apartment newDetails = new Apartment();
		Apartment currentDetails = this.repo.getApartmentsByBuildingAndTitle(building, apartmentNumber);
		List<Room> currentRooms = new ArrayList<>();
		currentRooms.addAll(currentDetails.getTracks());
		for (int i = 0; i < currentRooms.size(); i++) {
			if (currentRooms.get(i).getTitle().equals(room)) {
				List<Event> newEvents = new ArrayList<>();
				newEvents.addAll(currentRooms.get(i).getElements());
				newEvents.add(event);
				currentRooms.get(i).setElements(new HashSet<Event>(newEvents));
				newDetails.setTracks(new HashSet<Room>(currentRooms));
				currentDetails.update(newDetails);
				this.repo.delete(currentDetails);
				this.repo.save(currentDetails);
				return "Asssignment Added";
			}
		}
		return "Error: Invalid Input!";
	}
}