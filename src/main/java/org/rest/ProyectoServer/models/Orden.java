package org.rest.ProyectoServer.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
@XmlSeeAlso(Platillo.class)
@XmlRootElement
public class Orden {
	Platillo platillo;
	Cliente cliente;
	public Orden(){
		
		
	}
	public Orden(Platillo platillo, Cliente cliente){
		this.platillo=platillo;
		this.cliente=cliente; 
		
	}
	@XmlElement
	public Platillo getPlatillo() {
		return platillo;
	}
	public void setPlatillo(Platillo platillo) {
		this.platillo = platillo;
	}
	@XmlElement
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
