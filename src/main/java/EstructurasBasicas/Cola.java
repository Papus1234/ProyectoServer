package EstructurasBasicas;

import java.util.ArrayList;
import java.util.List;

import org.rest.ProyectoServer.models.Cliente;
import org.rest.ProyectoServer.models.Orden;
public class Cola {
	List<Cliente> clientes;
        
        public List<Cliente> getClientes() {
		return clientes;
	}



	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}



		public Cola(){
            clientes= new ArrayList<Cliente>();
        }
	
	
	
    public void prioridad(Cliente dato){
        if("Gold".compareTo(dato.getPrioridad())==0){
            
            if(this.clientes.isEmpty()){
                this.clientes.add(0, dato);
                
            }
            else{
                for(int i = 0;i<=clientes.size(); i++){
                    if(i==clientes.size()){
                        clientes.add(dato);
                        break;
                    }
                    if("Gold".compareTo(this.clientes.get(i).getPrioridad())!=0){
                      this.clientes.add(i, dato);
                      break;
                    }
                }      
            }
        }
        else if("Plata".compareTo(dato.getPrioridad())==0){
            if(this.clientes.isEmpty()){
                this.clientes.add(0,dato); 
            }
            else{
                for(int i = 0;i<=clientes.size(); i++){
                    if(i==clientes.size()){
                        clientes.add(dato);
                        break;
                    }
                    if("Gold".compareTo(this.clientes.get(i).getPrioridad())!=0&&"Plata".compareTo(this.clientes.get(i).getPrioridad())!=0) {
                        this.clientes.add(i, dato);
                      break;
                    }
                }      
            }
            
        }
        else{
            clientes.add(dato);
        }
}
}
