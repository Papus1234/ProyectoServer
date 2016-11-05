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
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import org.rest.ProyectoServer.manejoXml.ManagerXml;
import org.rest.ProyectoServer.models.Cheff;
import org.rest.ProyectoServer.models.Cliente;
import org.rest.ProyectoServer.models.Ingrediente;
import org.rest.ProyectoServer.models.Message;
import org.rest.ProyectoServer.models.Orden;
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

import EstructurasBasicas.ListaEnlazada;
import Objetos.Persona;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
@Path("Cheff")
public class MyResourseCheff {
	public CheffService cheffS=new CheffService();
	
	public CheffService getCheffS() {
		return cheffS;
	}


	public void setCheffS(CheffService cheffS) {
		this.cheffS = cheffS;
	}


	public ManagerXml getXml() {
		return xml;
	}


	public void setXml(ManagerXml xml) {
		this.xml = xml;
	}



	ManagerXml xml=new ManagerXml();
	
	@Path("Platillos")
	@GET		
	@Produces(MediaType.APPLICATION_JSON)
	public List<Platillo> getallPlatillos(){
		System.out.println("Paso por acaaaa , esto mola papu ");
		return cheffS.plat;
//		return cheffS.getAllCheffs();
//		
	}
	
	
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
	public Platillo guardarReceta(Platillo platillo) throws ParserConfigurationException, SAXException, IOException{
		String xml=this.cheffS.xml.getXstream().toXML(platillo);
		//cheffS.guardarReceta(receta);
		this.cheffS.getAllPlatillos().add(platillo);
		System.out.println(xml);
		
		return platillo;
		
	}
	
	@Path("TodosLosPlatillos")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Platillo>getAllPlatillos() throws ParserConfigurationException, SAXException, IOException{
		
		return cheffS.getAllPlatillos();
	}
	
	@Path("xmlEscribir")
	@POST
	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cheff> escribirXml(Cheff cheff){
		
		
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
	public Platillo buscarCheff(@PathParam("edad")String edad) {
			
			return cheffS.busquedaBinaria(cheffS.ordenar(cheffS.getPlat()),edad);
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
		Receta aux=new Receta("");;
		return aux;
	
	}
	
	@Path("Chat")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message postearComentarios(Message msj) throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException{
		cheffS.getMsjList().add(msj);
		xml.agregarMessage(msj, "mensajes");
		System.out.println(msj.getMessage()+"pasa por chat");
		String aux="";
		for (int i=0;i<cheffS.getMsjList().size();i++){
			aux+=cheffS.getMsjList().get(i);
			
		}
		System.out.println(aux);
		return new Message(aux, "este");
	}
	
	
	///////////////////////////ACA EMPIEZA ORDEN //////////////////////////////////////
	@Path("Orden")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Platillo getOrdenes(){
		Cliente aux=cheffS.getCola().getClientes().get(0);
		cheffS.getCola().getClientes().remove(0);
		
		return cheffS.busquedaBinaria(cheffS.getPlat(),aux.getNombrePlatillo());
	}
	
	
	
	//////////INGREDIENTES///
	@Path("Ingredientes")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ingrediente> getAllingredientes(){
		System.out.println("siiiiii");
		List<Ingrediente>aux=cheffS.darTodosLosIngredientes(cheffS.getPlat());
		
		return cheffS.ordenarIngrediente(aux);
		
	}
	/////////////
}
