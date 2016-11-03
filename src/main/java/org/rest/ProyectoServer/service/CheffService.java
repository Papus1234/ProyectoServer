package org.rest.ProyectoServer.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.parsers.ParserConfigurationException;

import org.rest.ProyectoServer.manejoXml.ManagerXml;
import org.rest.ProyectoServer.models.Cheff;
import org.rest.ProyectoServer.models.Platillo;
import org.rest.ProyectoServer.models.Receta;
import org.xml.sax.SAXException;


	
public class CheffService {
	List<Cheff> a=new ArrayList<>();
	String archivoIngredientes;
	public ManagerXml xml;
	public CheffService(){
		xml=new ManagerXml();
		archivoIngredientes="ingredientes";
		a.add(new Cheff("Carlos", 12));
		a.add(new Cheff("Alfonso", 32));
		a.add(new Cheff("Nacho", 31));
			
		
	}
	public List<Platillo>getAllPlatillos() throws ParserConfigurationException, SAXException, IOException{
		
		return xml.listaasobtenerCheff("Platillos");
		
		
	}
	
	public List<Cheff> getAllCheffs(){
		return a;
		
	}
	
	public void guardarReceta(Platillo receta){
		
		//xml.GuardarFichero("receta",xml.getXstream().toXML(receta) );
		
	}
	
	public void addCheff(Cheff c){
		a.add(c);
	}
	public void GuardarCheffxml(Cheff c) throws IOException{
		String aux=xml.getXstream().toXML(c);
		
		//xml.GuardarFichero("ccc",aux);
		
	}

	public String LeerCheff (){
	//	return xml.LeerFichero("ccc");
		return "";
	}
	
	public Cheff searchCheff(List <Cheff>lisCheff,String busqueda){
		for (int i=0;i<lisCheff.size();i++){
			if (lisCheff.get(i).getId()==busqueda){
				
				return lisCheff.get(i);
				
			}
			
		}
		return null;
		
	}
	
}
