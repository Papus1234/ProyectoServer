package org.rest.ProyectoServer.models;

public class Cliente {
	String nombre;
	int Mesa;
	String Prioridad;
	String nombrePlatillo;
	public Cliente (){
		
		
	}
	
	public String getNombrePlatillo() {
		return nombrePlatillo;
	}

	public void setNombrePlatillo(String nombrePlatillo) {
		this.nombrePlatillo = nombrePlatillo;
	}

	public Cliente(String nombre, int mesa, String prioridad,String nombrePlatillo) {
		super();
		this.nombre = nombre;
		Mesa = mesa;
		Prioridad = prioridad;
		this.nombrePlatillo=nombrePlatillo;
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
