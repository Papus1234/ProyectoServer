package org.rest.ProyectoServer.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.rest.ProyectoServer.models.Cheff;


	
public class CheffService {
	List<Cheff> a=new ArrayList<>();
	
	public CheffService(){
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
	public Cheff searchCheff(int edad){
		for (int i=0;i<a.size();i++){
			if (a.get(i).getEdad()==edad){
				return a.get(i);
				
			}
			
		}
		return null;
		
	}
	
}
