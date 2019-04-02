package com.qa.roomGateway.controllerTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.qa.roomGateway.GatewayConstants;
import com.qa.roomGateway.controller.GatewayController;
import com.qa.roomGateway.entity.Apartment;
import com.qa.roomGateway.service.ApartmentService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApartmentGatewayTests {
	@Autowired
	private MockMvc mvc;

	@MockBean
	ApartmentService service;
	@MockBean
	RestTemplateBuilder rtb;
	
	GatewayController controller = new GatewayController(null, service, rtb);
	
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	private List<Apartment> roomList = new ArrayList<Apartment>();
	private Apartment testApartment;
	private String postContent;
	private ObjectWriter ow;

	@Before
	public void setUp() throws JsonProcessingException {
		roomList.add(GatewayConstants.getConstructedApartment());
		testApartment = GatewayConstants.getConstructedApartment();
		OBJECT_MAPPER.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ow = OBJECT_MAPPER.writer().withDefaultPrettyPrinter();
		postContent= ow.writeValueAsString(testApartment);

//		
	}
	@Test
	public void addApartmentTest() throws Exception {
		OBJECT_MAPPER.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = OBJECT_MAPPER.writer().withDefaultPrettyPrinter();
		String postContent = ow.writeValueAsString(testApartment);
		Mockito.when(service.addApartment((Apartment)notNull())).thenReturn("{\"message\":\"room added\"}");
		MvcResult result = mvc.perform(post("/createApartment").contentType(APPLICATION_JSON_UTF8)
				.content(postContent)).andReturn();
		assertThat(result.getResponse().getContentAsString()).contains("{\"message\":\"room added\"}");
	}

	@Test
	public void getAllTest() throws Exception {
		when(service.getAllApartments()).thenReturn(roomList);
		assertThat(mvc.perform(get("/getAllApartments").accept(MediaType.APPLICATION_JSON))
				.andExpect(content().string(containsString("numberOne"))));
	}

	@Test
	public void getApartmentsByNumberTest() throws Exception {
		roomList.add(GatewayConstants.getConstructedApartment());
		when(service.getApartmentsByNumber("0")).thenReturn(roomList);
		assertThat(mvc.perform(get("/getApartmentByNumber/").param("request", "1301").accept(MediaType.APPLICATION_JSON))
				.andExpect(content().string("")));
	}

	@Test
	public void getApartmentByBuildingTest() throws Exception {
		roomList.add(GatewayConstants.getConstructedApartment());
		when(service.getApartmentsByBuilding("numberOne")).thenReturn(roomList);
		assertThat(
				mvc.perform(get("/getApartmentByBuilding/").param("request", "numberOne").accept(MediaType.APPLICATION_JSON))
						.andExpect(content().string("")));
	}

	@Test
	public void getApartmentByLandlordTest() throws Exception {
		roomList.add(GatewayConstants.getConstructedApartment());
		when(service.getApartmentsByLandlord("Jason Joans")).thenReturn(roomList);
		assertThat(mvc
				.perform(get("/getApartmentByLandlord/").param("request", "Jason Joans").accept(MediaType.APPLICATION_JSON))
				.andExpect(content().string("")));
	}
//	@Test
//	public void deleteApartmentTest() throws Exception {
//		List<Apartment> MOCKED_ROOM_LIST = new ArrayList<Apartment>();
//		MOCKED_ROOM_LIST.add(testApartment);
//		Mockito.when(service.deleteApartment(GatewayConstants.getApartmentNumber())).thenAnswer((Answer<?>) invocation -> {
//			MOCKED_ROOM_LIST.remove(testApartment);
//			return GatewayConstants.getNaString();
//		});
//		this.mvc.perform(MockMvcRequestBuilders
//				.post(GatewayConstants.getDeletionUrl())
//				.contentType(MediaType.APPLICATION_JSON)
//				.content(postContent))
//		.andExpect(status().isOk());
//		assertThat(MOCKED_ROOM_LIST.size()).isEqualTo(0);
//	}
}
