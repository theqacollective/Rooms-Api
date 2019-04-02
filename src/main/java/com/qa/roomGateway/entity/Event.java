package com.qa.roomGateway.entity;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Event {
	@Id
	private String id;
	private String title;
	private Date start;
	private Date end;

	public Event() {
	}

	public Event(String title, Date start, Date end) {
		this.title = title;
		this.start = start;
		this.end = end;
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

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

}
