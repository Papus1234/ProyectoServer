package org.rest.ProyectoServer.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import org.rest.ProyectoServer.manejoXml.ManagerXml;
import org.rest.ProyectoServer.models.Cheff;
import org.rest.ProyectoServer.models.Ingrediente;
import org.rest.ProyectoServer.models.Ingredientes;
import org.rest.ProyectoServer.models.Platillo;
import org.rest.ProyectoServer.models.Receta;
import org.xml.sax.SAXException;


	
public class CheffService {
	public List<Platillo>plat=new ArrayList<>();
	
	List<Cheff> a=new ArrayList<>();
	String archivoIngredientes;
	public ManagerXml xml;
	public CheffService(){
		
		xml=new ManagerXml();
		archivoIngredientes="ingredientes";
		a.add(new Cheff("Carlos", 12));
		a.add(new Cheff("Alfonso", 32));
		a.add(new Cheff("Nacho", 31));
		List<Ingrediente>ing=new ArrayList<>();
		ing.add(new Ingrediente("arroz"));
		ing.add(new Ingrediente("pollo"));
		ing.add(new Ingrediente("lomito"));
		ing.add(new Ingrediente("frijoles"));
		plat.add(new Platillo("Paella",new Ingredientes(ing), 
				"es muy bueno", 2500, 15,
				new Receta("se cocina el arroz y se le pone pollo.")));
		
		ing=new ArrayList<>();
		
		ing.add(new Ingrediente("arroz"));
		ing.add(new Ingrediente("paella"));
		ing.add(new Ingrediente("ensalada"));
		ing.add(new Ingrediente("frijoles"));
		
		plat.add(new Platillo("Pealla",new Ingredientes(ing), 
				"excelente", 3000, 15,
				new Receta("Se pone en arroz en la paella estos se conbinan por hidrolisis. Frijoles se ponen a sofreir . ")));
		
		ing=new ArrayList<>();
		
		ing.add(new Ingrediente("arroz"));
		ing.add(new Ingrediente("pollo"));
		ing.add(new Ingrediente("caldo"));
		ing.add(new Ingrediente("frijoles"));
		plat.add(new Platillo("Caldo de pollo",new Ingredientes(ing), 
				"es muy bueno", 2750, 15,
				new Receta("Se hace el pollo.Se pone en la cazuela .Se hace el caldo .se mezcla el caldo con el pollo")));
			
	}
	public void guardarPlatillo(Platillo platillo) throws TransformerConfigurationException, SAXException, IOException, ParserConfigurationException, TransformerException{
		xml.agregarPlatillo(platillo, "Platillos");
		
	}
	public List<Platillo>getAllPlatillos() throws ParserConfigurationException, SAXException, IOException{
		System.out.println(plat.toString()+"esto parsa por iiii");
		return this.plat;
		
		
	}
	
	public List<Cheff> getAllCheffs(){
		return a;
		
	}
	
	public void guardarReceta(Platillo receta){
		
		//xml.GuardarFichero("receta",xml.getXstream().toXML(receta) );
		
	}
	
	public void addCheff(Cheff c){
		a.add(c);
	}
	public void GuardarCheffxml(Cheff c) throws IOException{
		String aux=xml.getXstream().toXML(c);
		
		//xml.GuardarFichero("ccc",aux);
		
	}

	public String LeerCheff (){
	//	return xml.LeerFichero("ccc");
		return "";
	}
	
	public Cheff searchCheff(List <Cheff>lisCheff,String busqueda){
		for (int i=0;i<lisCheff.size();i++){
			if (lisCheff.get(i).getId()==busqueda){
				
				return lisCheff.get(i);
				
			}
			
		}
		return null;
		
	}
	
}
