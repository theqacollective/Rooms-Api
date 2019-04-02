package com.qa.roomGateway.repositoryTests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.roomGateway.GatewayConstants;
import com.qa.roomGateway.repository.ApartmentRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApartmentRepositoryTest {
	@Autowired
	ApartmentRepo repo;
//	@Autowired
//	GatewayConstants constants;
	@Test
	public void contextLoads() {
		assertThat(repo).isNotNull();
		}
/*	
	@Test
	public void testFindByNumber() {
		
		Mockito.when(repo.findByRoomNumber(constants.getTestRoomNumber())).thenReturn(constants);
	}*/
}
