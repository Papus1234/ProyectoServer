package org.rest.ProyectoServer.models;

public class Cliente {
	String nombre;
	int Mesa;
	String Prioridad;
	public Cliente (){
		
		
	}
	
	public Cliente(String nombre, int mesa, String prioridad) {
		super();
		this.nombre = nombre;
		Mesa = mesa;
		Prioridad = prioridad;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getMesa() {
		return Mesa;
	}
	public void setMesa(int mesa) {
		Mesa = mesa;
	}
	public String getPrioridad() {
		return Prioridad;
	}
	public void setPrioridad(String prioridad) {
		Prioridad = prioridad;
	}
	
}
