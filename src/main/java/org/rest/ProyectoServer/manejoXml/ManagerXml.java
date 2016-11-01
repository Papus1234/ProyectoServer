package org.rest.ProyectoServer.manejoXml;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.rest.ProyectoServer.models.Cheff;
import org.rest.ProyectoServer.models.Ingrediente;
import org.w3c.dom.Attr;
import org.w3c.dom.Node;

import com.thoughtworks.xstream.XStream;

import Objetos.Persona;

public class ManagerXml {
	XStream xstream = new XStream();
	
	String texto;
		//XStream x = new XStream();
		String path="C:/Users/Roberto/OneDrive/ProyectosProgra/ProyectoServer/";
		String tipo=".xml";
		
		public ManagerXml(){
			
			
		}
		public String AgregarEtiquetas(){
			return "";
			
			
		}
		public String QuitarEtiquetaPrincipal(String EtiquetaF,String contenido){
			String aux=contenido.substring(7);
			String aux2=aux.split(EtiquetaF)[0];
			return aux2;
		}
		public void AgregarCheff(Cheff c,String ruta){
			String rC=path+ruta+tipo;
			String contenido=this.LeerFichero(rC);
			String aux=getXstream().toXML(c);
			String guardar=this.QuitarEtiquetaPrincipal("</ListaCheff>",aux);
			
		}
		/*Este codigo no es de mi pertenencia fue sacado de esta pagina por su buena implementacion
		 * http://todoelmed.blogspot.com/2012/05/manejo-de-archivos-o-ficheros-en.html
		 */
		
		public void GuardarFichero(String ruta,String SCadena){
			  try {
				  File Ffichero=new File(path+ruta+".xml");
			        //Si no Existe el fichero lo crea
			         if(!Ffichero.exists()){
			            Ffichero.createNewFile();
			         }
		         /*Abre un Flujo de escritura,sobre el fichero con codificacion utf-8. 
	           *Además  en el pedazo de sentencia "FileOutputStream(Ffichero,true)",
	           *true es por si existe el fichero seguir añadiendo texto y no borrar lo que tenia*/
	          BufferedWriter Fescribe=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Ffichero,true), "utf-8"));
		          /*Escribe en el fichero la cadena que recibe la función. 
		           *el string "\r\n" significa salto de linea*/
		          Fescribe.write(SCadena + "\r\n");
		          //Cierra el flujo de escritura
		          Fescribe.close();
		       } catch (Exception ex) {
		          //Captura un posible error le imprime en pantalla 
		          System.out.println(ex.getMessage());
		        } 
			}
		
		public String LeerFichero(String ruta){
			File Ffichero=new File(path+ruta+".xml");   
			String aux="";
			       
			try {
				   /*Si existe el fichero*/
			       if(Ffichero.exists()){
			           /*Abre un flujo de lectura a el fichero*/
			           BufferedReader Flee= new BufferedReader(new FileReader(Ffichero));
			           String Slinea;
			           System.out.println("**********Leyendo Fichero***********");
			           /*Lee el fichero linea a linea hasta llegar a la ultima*/
			           
			           while((Slinea=Flee.readLine())!=null) {
			           /*Imprime la linea leida*/    
			           System.out.println(Slinea);  
			           aux+=Slinea;
			           }
			           System.out.println("*********Fin Leer Fichero**********");
			           /*Cierra el flujo*/
			           Flee.close();
			         }else{
			           System.out.println("Fichero No Existe");
			       
			         }
			   } catch (Exception ex) {
			       /*Captura un posible error y le imprime en pantalla*/ 
			        System.out.println(ex.getMessage());
			   }
			return aux;
			 }
		 
	//	
//		public void guardarxml (Object ob,String ruta) throws IOException{
//	    // Grabar
//			
//			this.texto=x.toXML(new Cheff("david", "43"));
//			System.out.println(texto+"Esta por aca ");
//			
//			 x.toXML(ob, new FileOutputStream(ruta));
//			 guardar("esto.txt", texto);
//		}
//		public  Object leerXml(String ruta) throws FileNotFoundException{
//	    // Recuperar
//	     return  x.fromXML(new FileInputStream(ruta));
	//
	//	
//		}
	
		 	public XStream getXstream() {
				return xstream;
			}
			public void setXstream(XStream xstream) {
				this.xstream = xstream;
			}
			public String getPath() {
				return path;
			}
			public void setPath(String path) {
				this.path = path;
			}

			public String getTexto() {
				return texto;
			}
			public void setTexto(String texto) {
				this.texto = texto;
			}
			
}