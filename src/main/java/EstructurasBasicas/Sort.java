package EstructurasBasicas;

import java.awt.List;

import org.rest.ProyectoServer.models.Ingrediente;



public class Sort {

	 public Lista bubble(Lista<Ingrediente> lista){
	        boolean swapped=true;
	        int j=0;
	        while(swapped){
	            swapped=false;
	            j++;
	            for(int i=0;i<lista.cuantosElementos()-j;i++){
	                if(lista.devolverDato(i).getNombre().compareTo(lista.devolverDato(i+1).getNombre())>0){
	                    lista.intercambiar(i, i+1);
	                    swapped=true;
	                }
	            }
	        }
	        return lista;
	    }
	 
	 
	 public static Lista insertion(Lista<Ingrediente> lista){
	        for(int i=1;i<lista.cuantosElementos();i++){
	            for(int j=i;j>0;j--){
	                if(lista.devolverDato(j).getNombre().compareTo(lista.devolverDato(j-1).getNombre())<0){
	                    lista.intercambiar(j-1, j);
	                }
	            } 
	        }
	        return lista;
	    }
	 
	 public Lista quick(Lista<Ingrediente> lista){
         if (lista == null || lista.cuantosElementos()== 0) {
             return null;
         }
         return quickSort(lista,0, lista.cuantosElementos() - 1);
 }
 
 private  Lista quickSort(Lista<Ingrediente> lista,int lowerIndex, int higherIndex){
     int i=lowerIndex;
     int j=higherIndex;
     String pivot = lista.devolverDato(lowerIndex+(higherIndex-lowerIndex)/2).getNombre();
     while(i<=j){
         while(lista.devolverDato(i).getNombre().compareTo(pivot)<0){
             i++;
         }
         while(lista.devolverDato(j).getNombre().compareTo(pivot)>0){
             j--;
         }
         if(i<=j){
             lista.intercambiar(i, j);
             i++;
             j--;
         }
     }
     if(lowerIndex<j){
         quickSort(lista, lowerIndex, j);
     }
     if(i<higherIndex){
         quickSort(lista, i, higherIndex);
     }
     return lista;
 }
 
 public void shell(Lista<Ingrediente> v) {
     final int N = v.cuantosElementos();
     int incremento = N;
     
         incremento = incremento / 2;
         for (int k = 0; k < incremento; k++) {
             for (int i = incremento + k; i < N; i += incremento) {
                 int j = i;
                 while (j - incremento >= 0 && v.devolverDato(j).getNombre().compareTo(v.devolverDato(j - incremento).getNombre())<0) {
                     v.intercambiar(j, j - incremento);
                     j -= incremento;
                 }
             }
         }
  }
	 
 
}

