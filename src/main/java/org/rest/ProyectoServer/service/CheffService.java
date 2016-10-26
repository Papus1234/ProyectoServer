package org.rest.ProyectoServer.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.rest.ProyectoServer.models.Cheff;


	
public class CheffService {
	
	public CheffService(){
		
		
	}
	public List<Cheff> getAllCheffs(){
		List<Cheff> a=new ArrayList<>();
		a.add(new Cheff("Carlos", 12));
		a.add(new Cheff("Alfonso", 32));
		a.add(new Cheff("Nacho", 31));
		return a;
		
	}
	
}
