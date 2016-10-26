package org.rest.ProyectoServer.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.rest.ProyectoServer.models.Cheff;
import java.util.List;
import org.rest.ProyectoServer.service.CheffService;

@Path("Cheff")
public class MyResourseCheff {
	CheffService cheffS=new CheffService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cheff> getallChefs(){
		System.out.println("Paso por aca ");
		return cheffS.getAllCheffs();
		
	}
}
