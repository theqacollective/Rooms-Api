package com.qa.roomGateway.serviceTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.roomGateway.GatewayConstants;
import com.qa.roomGateway.entity.Apartment;
import com.qa.roomGateway.repository.ApartmentRepo;
import com.qa.roomGateway.service.ApartmentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApartmentServiceTests {
	
	@InjectMocks
	ApartmentService service;
	@Mock
	ApartmentRepo repo;
	private List<Apartment> roomList = new ArrayList<Apartment>();

	@Before
	public void setup() {
		roomList.add(GatewayConstants.getConstructedApartment());
	}
	@After
	public void tearDown() {
		roomList.clear();
	}
	@Test
	public void createApartmentTest() {
		Apartment mockedApartment = GatewayConstants.getConstructedApartment();
		Mockito.when(repo.save((Apartment)notNull())).thenAnswer((Answer<?>) invocation -> {
			roomList.add(mockedApartment);
			return GatewayConstants.getConstructedApartment();
		});
		assertThat(roomList.size()).isEqualTo(1);
	}
	
	@Test
	public void getAllTest() {
		Mockito.when(repo.findAll()).thenReturn(roomList);
		List<Apartment> returnList = service.getAllApartments();
		assertThat(returnList.size()).isEqualTo(1);
		
	}
	
	@Test
	public void getByNumberTest() {
		Mockito.when(repo.findByTitle(GatewayConstants.getApartmentNumber())).thenReturn(roomList);
		List<Apartment> returnList = service.getApartmentsByNumber(GatewayConstants.getApartmentNumber());

		assertThat(returnList.size()).isEqualTo(1);		
	}
	
	@Test
	public void getByBuildingTest() {
		Mockito.when(repo.findByBuilding(GatewayConstants.getBuilding())).thenReturn(roomList);
		List<Apartment> returnList = service.getApartmentsByBuilding(GatewayConstants.getBuilding());

		assertThat(returnList.size()).isEqualTo(1);
	}
	
	@Test
	public void getByLandlordTest() {
		Mockito.when(repo.getApartmentsByLandlord(GatewayConstants.getLandlord())).thenReturn(roomList);
		List<Apartment> returnList = service.getApartmentsByLandlord(GatewayConstants.getLandlord());

		assertThat(returnList.size()).isEqualTo(1);
	}
		
	@Test
	public void updateApartmentTest() {
		
	}
	
//	@Test
//	public void deleteApartmentTest() {
//		Mockito.when(this.tenantService.deleteTenant((Tenant)notNull())).thenAnswer((Answer<?>) invocation -> {
//			this.roomList.remove(GatewayConstants.getConstructedApartment());
//			return Constants.getDeletionMessage();
//		});
//		Apartment toDelete = (Apartment) Mockito.when(repo.getApartmentsByBuildingAndTitle(GatewayConstants.getBuilding(), GatewayConstants.getApartmentNumber())).thenReturn(GatewayConstants.getConstructedApartment());
//		Mockito.when(repo.delete((Apartment)notNull())).thenAnswer((Answer<?>) invocation -> {
//			returnList.remove(GatewayConstants.getConstructedApartment());
//			return "did it work";
//		});
//	}
}
