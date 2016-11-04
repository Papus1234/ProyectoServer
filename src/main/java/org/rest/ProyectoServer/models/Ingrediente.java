package org.rest.ProyectoServer.models;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement


public class Ingrediente {
	String nombre;
	

	int cantidad;
	String tipo ; 
	public Ingrediente(String tipo,String nombre){
	this.tipo=tipo;
	this.nombre=nombre; 
		
	}
	public Ingrediente(){
		
	}
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Ingrediente(String n){
		cantidad=1;
		nombre=n;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}

