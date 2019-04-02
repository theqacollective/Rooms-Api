package com.qa.roomGateway.entity;

import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Room {
	@Id
	private String id;
	private String title;
	private Set<Event> elements;

	public Room() {
	}

	public Room(String roomName, Set<Event> elements) {
		this.title = roomName;
		this.elements = elements;
		this.id= ObjectId.get().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String roomName) {
		this.title = roomName;
	}

	public Set<Event> getElements() {
		return elements;
	}

	public void setElements(Set<Event> elements) {
		this.elements = elements;
	}

}
