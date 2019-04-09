package com.qa.roomGateway.entity;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.qa.roomGateway.Constants;

public class Apartment {
	@Id
	private String id;
	private String building;
	private boolean isIsOpen = false;
	private String title;
	private Set<Event> elements = new HashSet<>();
	private Integer roomNumber;
	private Set<Room> tracks;
	private String currentState;
	private String landlord;
	public Apartment() {
	}

	public Apartment( String building, String title, Integer roomNumber, Set<Room> tracks,
			String currentState, String landlord) {
		this.building = building;
		this.title = title;
		this.roomNumber = roomNumber;
		this.tracks = tracks;
		this.currentState = currentState;
		this.landlord = landlord;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Set<Room> getTracks() {
		return tracks;
	}
	public void setTracks(Set<Room> tracks) {
		this.tracks = tracks;
	}
	public String getCurrentState() {
		return currentState;
	}
	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}
	public String getLandlord() {
		return landlord;
	}
	public void setLandlord(String landlord) {
		this.landlord = landlord;
	}
	@Override
    public String toString() {
    	ObjectMapper mapper = new ObjectMapper();
    	
    	String jsonString = "";
		try {
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			jsonString = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
    	return jsonString;
    }
	public boolean getIsOpen() {
		return isIsOpen;
	}
	public void setIsOpen(boolean isIsOpen) {
		this.isIsOpen = isIsOpen;
	}
	public Set<Event> getElements() {
		return elements;
	}
	public void setElements(Set<Event> elements) {
		this.elements = elements;
	}
	
	public void update(Apartment updatedApartment) {
		this.setId(Optional.ofNullable(updatedApartment.getId()).orElse(Optional.ofNullable(this.getId()).orElse(Constants.getNaString())));
		this.setBuilding(Optional.ofNullable(updatedApartment.getBuilding()).orElse(Optional.ofNullable(this.getBuilding()).orElse(Constants.getNaString())));
		this.setTitle(Optional.ofNullable(updatedApartment.getTitle()).orElse(Optional.ofNullable(this.getTitle()).orElse(Constants.getNaString())));
		
		this.setRoomNumber(Optional.ofNullable(updatedApartment.getRoomNumber()).orElse(Optional.ofNullable(this.getRoomNumber()).orElse(0)));
		this.setTracks(Optional.ofNullable(updatedApartment.getTracks()).orElse(Optional.ofNullable(this.getTracks()).orElse(null)));
		
		this.setCurrentState(Optional.ofNullable(updatedApartment.getCurrentState()).orElse(Optional.ofNullable(this.getCurrentState()).orElse(Constants.getNaString())));
		this.setLandlord(Optional.ofNullable(updatedApartment.getLandlord()).orElse(Optional.ofNullable(this.getLandlord()).orElse(Constants.getNaString())));
		
		this.setIsOpen(Optional.ofNullable(updatedApartment.getIsOpen()).orElse(Optional.ofNullable(this.getIsOpen()).orElse(null)));
		this.setElements(Optional.ofNullable(updatedApartment.getElements()).orElse(Optional.ofNullable(this.getElements()).orElse(null)));
	}

}
