package EstructurasBasicas;

import java.util.List;

import org.rest.ProyectoServer.models.Cliente;
import org.rest.ProyectoServer.models.Orden;

public class Cola {
	ListaEnlazada<Orden>colaOrdenes;
	
	public ListaEnlazada<Orden> getColaOrdenes() {
		return colaOrdenes;
	}
	public void setColaOrdenes(ListaEnlazada<Orden> colaOrdenes) {
		this.colaOrdenes = colaOrdenes;
	}
	public Cola(){
		
		
	}
	public void InsertarCliente(Orden cliente){
		if (cliente.getCliente().getPrioridad()=="Bronce"){
			this.insertarBronce(cliente);
			
		}
		if (cliente.getCliente().getPrioridad()=="Platino"){
			this.insertarBronce(cliente);
			
		}
		if(cliente.getCliente().getPrioridad()=="Oro"){
			this.insertarOro(cliente);
		}
		
	}
	public void insertarInicio(Orden cliente){
		colaOrdenes.introducirDato(0, cliente);
		
	}
	public Orden PopFinal(){
		
		return colaOrdenes.devolverDato((colaOrdenes.cuantosElementos()-1));
		
	}
	public void insertarBronce(Orden cliente){
		this.insertarInicio(cliente);
		
	}
	public void insertarPlatino(Orden cliente){
		for (int i=0;i<colaOrdenes.cuantosElementos();i++){
			if (colaOrdenes.devolverDato(i).getCliente().getPrioridad()!="Bronce"){
				colaOrdenes.introducirDato(i,cliente);
				
			}
		}
	}
	
	public int insertarOro(Orden cliente){
		for (int i=0;i<colaOrdenes.cuantosElementos();i++){
			if (colaOrdenes.devolverDato(i).getCliente().getPrioridad()!="Platino" && colaOrdenes.devolverDato(i).getCliente().getPrioridad()!="Bronce" ){
				colaOrdenes.introducirDato(i,cliente);
				return i;
			}
		}
		this.colaOrdenes.introducirDato(colaOrdenes.cuantosElementos()-1, cliente);
		return 0;
		
	}
	
			
		
		
	
	
}
