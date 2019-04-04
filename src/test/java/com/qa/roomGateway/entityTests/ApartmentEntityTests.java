package com.qa.roomGateway.entityTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.roomGateway.Constants;
import com.qa.roomGateway.entity.Apartment;
import com.qa.roomGateway.entity.Event;
import com.qa.roomGateway.entity.Room;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApartmentEntityTests {
	@Test
	public void apartmentSuperConstructorTest() {
		Apartment apartment = new Apartment();
		assertThat(apartment).isNotNull();
	}
	@Ignore
	@Test
	public void apartmentGetterTest(){
		assertNull(Constants.getNullApartment().getBuilding());
		assertNull(Constants.getNullApartment().getTitle());
		assertNull(Constants.getNullApartment().getTracks());
		assertNull(Constants.getNullApartment().getCurrentState());
		assertNull(Constants.getNullApartment().getLandlord());
	}
	@Test
	public void apartmentSettterTest() {
		Apartment testApartment = Constants.getNullApartment();
		testApartment.setBuilding(Constants.getNaString());
		testApartment.setTitle("1301");
		testApartment.setTracks(null);
		testApartment.setCurrentState(Constants.getNaString());
		testApartment.setLandlord(Constants.getNaString());
	}
	@Test
	public void roomSuperConstructorTest() {
		Room room = new Room();
		assertThat(room).isNotNull();
	}
	@Test
	public void roomSetterTest() {
		Room testRoom = Constants.getNullRoom();
		testRoom.setTitle(Constants.getNaString());
		testRoom.setElements(null);
	}
	
	@Ignore
	@Test
	public void roomGetterTest() {
		assertNull(Constants.getNullRoom().getElements());
		assertNull(Constants.getNullRoom().getTitle());
	}
	@Test
	public void eventSetterTest() {
		Event testEvent = Constants.getNullEvent();
		testEvent.setTitle(Constants.getNaString());
//		testEvent.setEndDate(GatewayConstants.getNaString());
//		testEvent.setStartDate(GatewayConstants.getNaString());
	}
	@Test
	public void eventGetterTest() {
		assertNull(Constants.getNullEvent().getEnd());
		assertNull(Constants.getNullEvent().getStart());
		assertEquals(Constants.getNaString(),Constants.getNullEvent().getTitle());
	}
}
