package org.rest.ProyectoServer.models;

import java.util.ArrayList;
import java.util.List;

public class Receta {
	String [] Pasos;
	String textoPasos;
	
	public Receta(String txt){
		this.textoPasos=txt;
	}
	public Receta(){
		
	}
		public String[] hacerPasos(){
		return this.textoPasos.split(".");
		
	}

		public String[] getPasos() {
			return Pasos;
		}
		public void setPasos(String[] pasos) {
			Pasos = pasos;
		}
		public String getTextoPasos() {
			return textoPasos;
		}
		public void setTextoPasos(String textoPasos) {
			this.textoPasos = textoPasos;
		}
		
	
}
 