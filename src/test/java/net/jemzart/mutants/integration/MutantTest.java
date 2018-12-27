package net.jemzart.mutants.integration;

import io.restassured.RestAssured;
import net.jemzart.mutants.MutantsApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static javax.servlet.http.HttpServletResponse.SC_FORBIDDEN;
import static javax.servlet.http.HttpServletResponse.SC_OK;

@SpringBootTest(classes = {MutantsApplication.class}, webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Component
public class MutantTest {
	@LocalServerPort
	private int port = 0;

	@Before
	public void setUp() {
		RestAssured.port = port;
	}
	@Test
	public void mutant(){
		given().contentType(JSON).body(
			"{" +
				"\"dna\":[" +
				"\"ATGCGA\"," +
				"\"CAGTGC\"," +
				"\"AGAAGG\"," +
				"\"AGAAGG\"," +
				"\"CCCCTA\"," +
				"\"TCACTG\"]}").
			when().post("mutant").
			then().statusCode(SC_OK);
	}

	@Test
	public void nonMutant(){
		given().contentType(JSON).body(
			"{" +
				"\"dna\":[" +
				"\"ATGCGA\"," +
				"\"CAGTGC\"," +
				"\"TTATTT\"," +
				"\"AGACGG\"," +
				"\"GCGTCA\"," +
				"\"TCACTG\"]}").
			when().post("mutant").
			then().statusCode(SC_FORBIDDEN);
	}
}
