package org.rest.ProyectoServer.rest;

	import java.io.IOException;
import java.util.ArrayList;
	import java.util.List;

import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
	import javax.ws.rs.Produces;
	import javax.ws.rs.core.MediaType;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONException;
import org.json.JSONObject;
import org.rest.ProyectoServer.manejoXml.ManagerXml;
import org.rest.ProyectoServer.models.Cliente;
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
				System.out.println("Paso por acaaaa , esto mola papu james se la puede ir a jalar ");
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
		
//////////////////////////		ORDEN///////////////777	
		@Path("HacerOrden")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public String setOrden(JsonObject ob){
			String nombco=ob.getString("nombrePlatillo");
			String clienNomb=ob.getString("clienteNombre");
			String priori=ob.getString("priori");
		//	int eti=ob.getInt("Mesa");
			//cheffS.getCola().prioridad(new Cliente(clienNomb, eti, priori,nombco));
			
		//	System.out.println("Mesa"+eti+"    "+clienNomb);
			return "e";
		}
		@Path("DarOrden")
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Platillo getOrdenes(){
			Cliente aux=cheffS.getCola().getClientes().get(0);
			cheffS.getCola().getClientes().remove(0);
			
			return cheffS.busquedaBinaria(cheffS.getPlat(),aux.getNombrePlatillo());
		}
		@Path("Pagar")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public String paga(JSONObject ob){
			
			System.out.println("sdfsdfsdf");
			return "Ha pagado !!";
		} 
		@Path("Comentario")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public String pcoment(JSONObject ob) throws JSONException{
			//String come=ob.getString("Coment");
			
			return "Ha pagado !!";
		}

}