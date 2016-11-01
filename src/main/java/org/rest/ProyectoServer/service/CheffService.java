package org.rest.ProyectoServer.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.rest.ProyectoServer.manejoXml.ManagerXml;
import org.rest.ProyectoServer.models.Cheff;


	
public class CheffService {
	List<Cheff> a=new ArrayList<>();
	String archivoIngredientes;
	ManagerXml xml;
	public CheffService(){
		xml=new ManagerXml();
		archivoIngredientes="ingredientes";
		a.add(new Cheff("Carlos", 12));
		a.add(new Cheff("Alfonso", 32));
		a.add(new Cheff("Nacho", 31));
			
		
	}
	
	public List<Cheff> getAllCheffs(){
		return a;
		
	}
	public void addCheff(Cheff c){
		a.add(c);
	}
	public void GuardarCheffxml(Cheff c) throws IOException{
		String aux=xml.getXstream().toXML(c);
		
		xml.GuardarFichero("ccc",aux);
		
	}
	public Cheff searchCheff(String id){
		for (int i=0;i<a.size();i++){
			if (a.get(i).getId()==id){
				return a.get(i);
				
			}
			
		}
		return null;
		
	}
	
}
