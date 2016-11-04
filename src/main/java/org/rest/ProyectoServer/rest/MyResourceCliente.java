package org.rest.ProyectoServer.rest;

	import java.util.ArrayList;
	import java.util.List;

	import javax.ws.rs.GET;
	import javax.ws.rs.Path;
	import javax.ws.rs.Produces;
	import javax.ws.rs.core.MediaType;

	import org.rest.ProyectoServer.manejoXml.ManagerXml;
	import org.rest.ProyectoServer.models.Platillo;
import org.rest.ProyectoServer.service.CheffService;

import Objetos.Persona;
	@Path("Cliente")
	public class MyResourceCliente {
			CheffService cheffS=new CheffService();
			ManagerXml xml=new ManagerXml();
			public MyResourceCliente() {
				
				// TODO Auto-generated constructor stub
			}
			
			@Path("Platillos")
			@GET		
			@Produces(MediaType.TEXT_PLAIN)
			public List<Platillo> getallChefs(){
				System.out.println("Paso por acaaaa , esto mola papu ");
				return cheffS.plat;
//				return cheffS.getAllCheffs();
//				
			}
			
	}

	

