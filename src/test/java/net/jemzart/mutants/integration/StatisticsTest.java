package net.jemzart.mutants.integration;

import io.restassured.RestAssured;
import net.jemzart.mutants.MutantsApplication;
import net.jemzart.mutants.repositories.DNARepository;
import net.jemzart.mutants.responses.StatisticsResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static javax.servlet.http.HttpServletResponse.SC_OK;
import static org.junit.Assert.assertEquals;

@SpringBootTest(classes = {MutantsApplication.class}, webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Component
public class StatisticsTest {
	@Autowired
	private DNARepository dnaRepository;

	@LocalServerPort
	private int port = 0;

	@Before
	public void setUp() {
		RestAssured.port = port;
		dnaRepository.deleteAll();
	}

	@Test
	public void mutant(){
		create("{\"dna\":[\"CCTT\",\"CCTT\",\"AAGG\",\"AAGG\"]}");//non mutant
		create("{\"dna\":[\"TTTT\",\"TTTT\",\"TTTT\",\"TTTT\"]}");//mutant
		create("{\"dna\":[\"AAAA\",\"AAAA\",\"AAAA\",\"AAAA\"]}");//mutant
		create("{\"dna\":[\"CCCC\",\"CCCC\",\"CCCC\",\"CCCC\"]}");//mutant
		create("{\"dna\":[\"GGGG\",\"GGGG\",\"GGGG\",\"GGGG\"]}");//mutant

		StatisticsResponse stats = given().
			when().get("stats").
			then().statusCode(SC_OK).
			extract().response().as(StatisticsResponse.class);

		assertEquals(stats.getCount_human_dna(), 1, 0);
		assertEquals(stats.getCount_mutant_dna(), 4, 0);
		assertEquals(stats.getRatio(), 4, 0);
	}

	private void create(String request){
		given().contentType(JSON).
			body(request).
			when().post("mutant");
	}
}
