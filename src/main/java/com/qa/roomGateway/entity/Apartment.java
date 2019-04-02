package com.qa.roomGateway.entity;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Apartment {
	@Id
	private String id;
	private String building;
	private boolean isIsOpen = true;
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

}
