package org.rest.ProyectoServer.rest;
import javax.json.JsonArray;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.rest.ProyectoServer.manejoXml.ManagerXml;
import org.rest.ProyectoServer.models.Cheff;
import org.rest.ProyectoServer.models.Platillo;
import org.rest.ProyectoServer.models.Receta;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.rest.ProyectoServer.service.CheffService;
import org.xml.sax.SAXException;

import com.sun.research.ws.wadl.Application;

import Objetos.Persona;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
@Path("Cheff")
public class MyResourseCheff {
	CheffService cheffS=new CheffService();
	ManagerXml xml=new ManagerXml();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Persona> getallChefs(){
		System.out.println("Paso por aca1");
		Persona p=new Persona("es", "dsd");
		Persona p2 =new Persona("sdfsd", "34");
		List<Persona> a=new ArrayList<Persona>();
		a.add(p);
		a.add(p2);
		return a;
//		return cheffS.getAllCheffs();
//		
	}
	
	@Path("GuardarPlatillo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Platillo guardarReceta(Platillo platillo){
		//cheffS.guardarReceta(receta);
		return platillo;
		
	}
	@Path("TodosLosPlatillos")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Platillo>getAllPlatillos(){
		
		return cheffS.get
	}
	
	@Path("xmlEscribir")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cheff> escribirXml(Cheff cheff){
		
			try {
				xml.agregarCheff(cheff, xml.getRutaCheff());
			} catch (SAXException | IOException | ParserConfigurationException | TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		try {
			return xml.listaasobtenerCheff(xml.getRutaCheff());
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
//		try {
//			xml.guardar("estoo.xml", txt);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			return xml.muestraContenido("estoo.xml");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return "No se pudo encontrar el archivo"; 
	}
	@Path("{edad}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Cheff buscarCheff(@PathParam("edad")String edad){
		
			return cheffS.searchCheff(edad);
	}
	@Path("xml")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String guardarxml(){
		
		String text=xml.getTexto();
		try {
			System.out.println(text);
			return XML.toJSONObject(text).toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Path("ObtenerReceta")
	@GET 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Receta RecetabuscarReceta(String Nombre){
		Receta aux=new Receta();
		return aux;
	
	}
	
	@Path("/Chat")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String postearComentarios(){
		return "Fue comentado";
		
	}
	
	
	
}
