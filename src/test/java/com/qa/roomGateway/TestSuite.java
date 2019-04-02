  package com.qa.roomGateway;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.roomGateway.controllerTests.ApartmentGatewayTests;
import com.qa.roomGateway.entityTests.ApartmentEntityTests;
import com.qa.roomGateway.repositoryTests.ApartmentRepositoryTest;
import com.qa.roomGateway.serviceTests.ApartmentServiceTests;
import com.qa.roomGateway.smokeTests.ApartmentsGatewayApiApplicationTests;

@RunWith(Suite.class)

@SuiteClasses({ApartmentRepositoryTest.class, ApartmentServiceTests.class,ApartmentGatewayTests.class,ApartmentsGatewayApiApplicationTests.class, ApartmentEntityTests.class})

@SpringBootTest
public class TestSuite {

}
