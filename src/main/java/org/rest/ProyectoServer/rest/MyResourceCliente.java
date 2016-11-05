package org.rest.ProyectoServer.rest;

	import java.io.IOException;
import java.util.ArrayList;
	import java.util.List;

	import javax.ws.rs.GET;
	import javax.ws.rs.Path;
	import javax.ws.rs.Produces;
	import javax.ws.rs.core.MediaType;
import javax.xml.parsers.ParserConfigurationException;

import org.rest.ProyectoServer.manejoXml.ManagerXml;
	import org.rest.ProyectoServer.models.Platillo;
import org.rest.ProyectoServer.models.Receta;
import org.rest.ProyectoServer.service.CheffService;
import org.xml.sax.SAXException;

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
			@Produces(MediaType.APPLICATION_JSON)
			public List<Platillo> getallChefs(){
				System.out.println("Paso por acaaaa , esto mola papu ");
				try {
					return cheffS.getAllPlatillos();
				} catch (ParserConfigurationException | SAXException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				return cheffS.getAllCheffs();
//				
				return null;
			}
			
			@Path("Receta")
			@GET
			@Produces(MediaType.APPLICATION_JSON)
			public List<Receta> getallRecetas (){
				List<Receta>a=new ArrayList<>();
				a.add(new Receta("sdfsdfsdfsdfs"));
				a.add(new Receta("ssdgbbbbbb"));
				
				return a ;
			}
	}

	

