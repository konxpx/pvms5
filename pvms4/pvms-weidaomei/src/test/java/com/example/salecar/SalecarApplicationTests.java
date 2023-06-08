package com.example.salecar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

// @RunWith(SpringRunner.class)
@SpringBootTest
class SalecarApplicationTests {

	@Autowired
	private WebApplicationContext context;
	private MockMvc mockMvc;

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void testGetCarList() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/buyCar/getCarList")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void testPreBook() throws Exception {
		String request = "{\"cus_id\":1,\"car_id\":1,\"s_id\":1,\"book_time\":\"2023/5/1\",\"book_addr\":\"天津\"}";
		mockMvc.perform(MockMvcRequestBuilders.post("/buyCar/preBook")
				.contentType(MediaType.APPLICATION_JSON)
				.content(request)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void testDeleteCar() throws Exception {
		String req = "{\"id\":0}";
		mockMvc.perform(MockMvcRequestBuilders.post("/car/deleteCar")
				.contentType(MediaType.APPLICATION_JSON)
				.content(req)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void testAddCar() throws Exception {
		String req = "{\"goodss_id\":0}";
		mockMvc.perform(MockMvcRequestBuilders.post("/car/addCar")
				.contentType(MediaType.APPLICATION_JSON)
				.content(req)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void testUpdateCar() throws Exception {
		String req = "{\"goodss_id\":0}";
		mockMvc.perform(MockMvcRequestBuilders.post("/car/updateCar")
				.contentType(MediaType.APPLICATION_JSON)
				.content(req)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}

}
