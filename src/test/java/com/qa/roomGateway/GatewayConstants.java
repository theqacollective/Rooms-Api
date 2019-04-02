package com.qa.roomGateway;

import com.qa.roomGateway.entity.Apartment;
import com.qa.roomGateway.entity.Event;
import com.qa.roomGateway.entity.Room;


public class GatewayConstants {
	private static final String APARTMENT_ID = "TestFirst";
	private static final String BUILDING = "numberOne";
	private static final String APARTMENT_NUMBER = "1301";
	private static final int OCCUPANTS = 5;
	private static final String CURRENT_STATE = "TestQaEmail";
	private static final String LANDLORD = "TestApartmentReference";
	private static final String NA_STRING = "N/A";
	private static final String DELETE_BUILDING = "numberOne";
	private static final Integer DELETE_APARTMENT_NUM = 1301;
	private static final Apartment CONSTRUCTED_APARTMENT = new Apartment(BUILDING, APARTMENT_NUMBER, OCCUPANTS, null, CURRENT_STATE, LANDLORD);
	private static final Apartment NULL_APARTMENT = new Apartment();
	private static final Room NULL_ROOM = new Room();
	private static final Event NULL_EVENT = new Event();
	private static final String UPDATE_URL = "/updateApartment/{roomReference}";
	private static final String DELETION_URL = "/removeApartment";
	
	public static Room getNullRoom() {
		return NULL_ROOM;
	}

	public static Event getNullEvent() {
		return NULL_EVENT;
	}

	public static String getApartmentNumber() {
		return APARTMENT_NUMBER;
	}

	public static String getApartmentId() {
		return APARTMENT_ID;
	}

	public static String getBuilding() {
		return BUILDING;
	}

	public static int getOccupants() {
		return OCCUPANTS;
	}

	public static String getCurrentState() {
		return CURRENT_STATE;
	}

	public static String getLandlord() {
		return LANDLORD;
	}

	public static String getNaString() {
		return NA_STRING;
	}

	public static Apartment getConstructedApartment() {
		return CONSTRUCTED_APARTMENT;
	}

//	public static ResponseEntity<List<Apartment>> getMockDeleteResponse() {
//		return MOCK_DELETE_RESPONSE;
//	}

	public static String getDeleteBuilding() {
		return DELETE_BUILDING;
	}

	public static Integer getDeleteApartmentNum() {
		return DELETE_APARTMENT_NUM;
	}

	public static Apartment getNullApartment() {
		return NULL_APARTMENT;
	}

	public static String getUpdateUrl() {
		return UPDATE_URL;
	}

	public static String getDeletionUrl() {
		return DELETION_URL;
	}

}
