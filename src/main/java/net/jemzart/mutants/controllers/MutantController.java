package net.jemzart.mutants.controllers;

import net.jemzart.mutants.domain.MutantIdentifier;
import net.jemzart.mutants.requests.DNARequest;
import org.springframework.stereotype.Controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.servlet.http.HttpServletResponse.*;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Controller
@Path("mutant")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class MutantController {

	@POST
	public Response isMutant(DNARequest request){
		boolean isMutant = MutantIdentifier.isMutant(request.getDna());
		return Response.status(isMutant ? SC_OK : SC_FORBIDDEN).entity("").build();
	}
}
