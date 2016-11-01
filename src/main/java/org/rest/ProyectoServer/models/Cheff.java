package org.rest.ProyectoServer.models;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XmlRootElement(name="Cheff")
@XStreamAlias("Cheff")
public class Cheff implements Serializable{
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
