package net.jemzart.mutants.controllers;

import net.jemzart.mutants.domain.ratio.MutantStatistics;
import net.jemzart.mutants.requests.DNARequest;
import net.jemzart.mutants.responses.StatisticsResponse;
import net.jemzart.mutants.services.DNAService;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.servlet.http.HttpServletResponse.*;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Controller
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@Path("")
public class MainController {
	private DNAService dnaService;

	public MainController(DNAService dnaService){
		this.dnaService = dnaService;
	}

	@POST
	@Path("mutant")
	public Response isMutant(DNARequest request){
		boolean isMutant = dnaService.isMutant(request.getDna());
		return Response.status(isMutant ? SC_OK : SC_FORBIDDEN).entity("{}").build();
	}

	@GET
	@Path("stats")
	public StatisticsResponse getStatistics(){
		MutantStatistics mutantStatistics = dnaService.getStatistics();
		StatisticsResponse response = new StatisticsResponse();
		response.setCount_human_dna(mutantStatistics.getHumanCount());
		response.setCount_mutant_dna(mutantStatistics.getMutantCount());
		response.setRatio(mutantStatistics.getMutantsRatio());
		return response;
	}
}
