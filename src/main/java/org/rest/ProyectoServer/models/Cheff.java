package org.rest.ProyectoServer.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class Cheff {
	private String id;
	private int edad;
	
	
	public Cheff() {
		
	}

	public Cheff(String id, int edad) {
		this.id = id;
		this.edad = edad;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
}
