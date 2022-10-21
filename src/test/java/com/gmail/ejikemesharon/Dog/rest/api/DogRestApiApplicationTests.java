package com.gmail.ejikemesharon.Dog.rest.api;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class DogRestApiApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void setup() {
		mvc = MockMvcBuilders
				.webAppContextSetup(context)
				.apply(springSecurity())
				 .build();
	}

	@Autowired
	private TestRestTemplate testRestTemplate;

	@WithMockUser(username = "admin")
	@Test
	public void getAllDogs() {
		ResponseEntity<List> response = testRestTemplate.getForEntity("http://localhost:" + port + "/dogs", List.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.UNAUTHORIZED));
	}

	@WithMockUser(username = "admin")
	@Test
	public void getDogBreeds() {
		ResponseEntity<List> response = this.testRestTemplate.getForEntity("http://localhost:" + port + "/dogs/breed", List.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.UNAUTHORIZED));
	}

}
