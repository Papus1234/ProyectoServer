package org.rest.ProyectoServer.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.rest.ProyectoServer.manejoXml.ManagerXml;
import org.rest.ProyectoServer.models.Cheff;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.rest.ProyectoServer.service.CheffService;

import Objetos.Persona;

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
	@Path("xmlEscribir")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cheff> escribirXml(Cheff cheff){
		String a=xml.getXstream().toXML(cheff);
		System.out.println(a+"paso por aqui");
		try {
			xml.guardar("primerCheffs.xml",a);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cheffS.getAllCheffs();
		
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
	public Cheff buscarCheff(@PathParam("edad")int edad){
		
			return cheffS.searchCheff(edad);
	}
	@Path("xml")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String guardarxml(){
		try {
			xml.guardar("esto.xml", "Esto es aquello ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "si sirvio"+xml.getTexto();
	}
	
	
}
