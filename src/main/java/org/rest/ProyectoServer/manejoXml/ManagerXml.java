package org.rest.ProyectoServer.manejoXml;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.rest.ProyectoServer.models.Cheff;
import org.rest.ProyectoServer.models.Platillo;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.thoughtworks.xstream.XStream;

import Objetos.Persona;

public class ManagerXml {
	XStream xstream = new XStream();
	String SCheff="Cheff";
	String SPlatillo="Platillo";
	String SIngredientes="Ingredientes";
	String texto;
	public String rutaCheff="Cheffs";
	
	public String rutaIngrediente="Ingredientes";
	public String rutaPlatillos="Platillos";
	
		//XStream x = new XStream();
		String path="C:/Users/Roberto/OneDrive/ProyectosProgra/ProyectoServer/Data/";
		String tipo=".xml";
		
		public ManagerXml(){
			
			
		}
		public String obtenerNodoValor(String strTag,Element ePersona){
		    Node nValor=(Node)ePersona.getElementsByTagName(strTag).item(0).getFirstChild();
		    return nValor.getNodeValue();
		    }
		protected String getString(String tagName, Element element) {
	        NodeList list = element.getElementsByTagName(tagName);
	        if (list != null && list.getLength() > 0) {
	            NodeList subList = list.item(0).getChildNodes();

	            if (subList != null && subList.getLength() > 0) {
	                return subList.item(0).getNodeValue();
	            }
	        }

	        return null;
	    }
		    public ArrayList<Cheff>listaasobtenerCheff (String ruta)throws ParserConfigurationException, SAXException, IOException{
		    ArrayList<Cheff>listaPersonas=new ArrayList<>();
		        
		    DocumentBuilderFactory docFactory=DocumentBuilderFactory.newInstance();
		    DocumentBuilder docBuilder=docFactory.newDocumentBuilder();
		        
		    org.w3c.dom.Document doc=docBuilder.parse(new File(path+ruta+".xml"));
		        doc.getDocumentElement().normalize();
		        NodeList nodoPersonas=doc.getElementsByTagName(SCheff);
		        for (int i=0;i<nodoPersonas.getLength();i++){
		            Node persona=nodoPersonas.item(i);
		            if (persona.getNodeType()==Node.ELEMENT_NODE){
		                
		                Element unElement=(Element) persona;
		                Cheff objCheff=new Cheff();
		                objCheff.setId(obtenerNodoValor("id", unElement));
		                objCheff.setEdad(Integer.parseInt(obtenerNodoValor("edad", unElement)));
		                
		                listaPersonas.add(objCheff);
		            }
		        }
		        
		        
		        return listaPersonas;
		        }
		    /*
		    *Este metodo es de https://www.youtube.com/watch?v=eJrlE_03VPQ
		    *fue escogido por su buena implementacion
		    */
		    public void agregarCheff(Cheff persona,String ruta) throws SAXException, IOException, ParserConfigurationException, TransformerConfigurationException, TransformerException{
		        
		        DocumentBuilderFactory docFactory=DocumentBuilderFactory.newInstance();
		     
		        DocumentBuilder docBuilder=docFactory.newDocumentBuilder();
		        ruta+=".xml";
		        File file=new File(path+ruta);
		         if(!file.exists()){
		             file.createNewFile();
		            }
		         
		        Document doc=docBuilder.parse(new File(path+ruta));
		        doc.getDocumentElement().normalize();
		        Node nodoRaiz=doc.getDocumentElement();
		        Element nuevaPersona=doc.createElement(SCheff);
		        
		        Element nuevaoNombre=doc.createElement("id");
		        nuevaoNombre.setTextContent(persona.getId());
		        
		        Element nuevaoApellido=doc.createElement("edad");
		        nuevaoApellido.setTextContent(""+persona.getEdad());
		        
		        nuevaPersona.appendChild(nuevaoNombre);
		        nuevaPersona.appendChild(nuevaoApellido);
		        
		        
		        nodoRaiz.appendChild(nuevaPersona);
		        
		        TransformerFactory transFactory=TransformerFactory.newInstance();

		        Transformer transformer=transFactory.newTransformer();
		        DOMSource source=new DOMSource(doc);
		        StreamResult result=new StreamResult(new File(path+ruta));
		        transformer.transform(source, result);
		    }
		    public ArrayList<Platillo>listaobtenerPlatillo (String ruta)throws ParserConfigurationException, SAXException, IOException{
			    ArrayList<Platillo>listaPersonas=new ArrayList<>();
			        
			    DocumentBuilderFactory docFactory=DocumentBuilderFactory.newInstance();
			    DocumentBuilder docBuilder=docFactory.newDocumentBuilder();
			        
			    org.w3c.dom.Document doc=docBuilder.parse(new File(path+ruta+".xml"));
			        doc.getDocumentElement().normalize();
			        NodeList nodoPersonas=doc.getElementsByTagName(this.SPlatillo);
			        for (int i=0;i<nodoPersonas.getLength();i++){
			            Node persona=nodoPersonas.item(i);
			            if (persona.getNodeType()==Node.ELEMENT_NODE){
			                
			                Element unElement=(Element) persona;
			                Platillo objCheff=new Platillo();
//			                		obtenerNodoValor("nombre", unElement),
//			                		obtenerNodoValor("ingredientes", unElement), 
//			                		obtenerNodoValor("informacionNutricional", unElement),
//			                		
//			                		Integer.parseInt(obtenerNodoValor("precio", unElement)), 
//			                		
//			                				obtenerNodoValor("tiempo_de_preparacion", unElement),
//			                		obtenerNodoValor("receta", unElement);
//			                
			                
			                listaPersonas.add(objCheff);
			            }
			        }
			        
			        
			        return listaPersonas;
			        }
		    public void agregarPlatillo(Platillo platillo,String ruta) throws SAXException, IOException, ParserConfigurationException, TransformerConfigurationException, TransformerException{
		        
		        DocumentBuilderFactory docFactory=DocumentBuilderFactory.newInstance();
		     
		        DocumentBuilder docBuilder=docFactory.newDocumentBuilder();
		        ruta+=".xml";
		        File file=new File(path+ruta);
		         if(!file.exists()){
		             file.createNewFile();
		            }
		         
		        Document doc=docBuilder.parse(new File(path+ruta));
		        doc.getDocumentElement().normalize();
		        Node nodoRaiz=doc.getDocumentElement();
		        Element nuevaPersona=doc.createElement(SPlatillo);
		        
		        Element nuevaoNombre=doc.createElement("nombre");
		        nuevaoNombre.setTextContent(platillo.getNombre());
		        
		        Element nuevaoApellido=doc.createElement("precio");
		        nuevaoApellido.setTextContent(""+platillo.getPrecio());
		        
		        Element nuevaoIngredientes=doc.createElement("Ingredientes");
		        nuevaoIngredientes.setTextContent(this.xstream.toXML(platillo.getIngredientes()));
		        
		        
			        
		        		
		        nuevaPersona.appendChild(nuevaoNombre);
		        nuevaPersona.appendChild(nuevaoApellido);
		        
		        
		        nodoRaiz.appendChild(nuevaPersona);
		        
		        TransformerFactory transFactory=TransformerFactory.newInstance();

		        Transformer transformer=transFactory.newTransformer();
		        DOMSource source=new DOMSource(doc);
		        StreamResult result=new StreamResult(new File(path+ruta));
		        transformer.transform(source, result);
		    }

//		public String AgregarEtiquetas(String EtiquetaI,String EtiquetaF,String txt){
//			EtiquetaI = txt;
//			txt+=EtiquetaF;
//			return txt;
//			
//			
//		}
//		public String QuitarEtiquetaPrincipal(String EtiquetaF,String contenido){
//			String aux=contenido.substring(7);
//			String aux2=aux.split(EtiquetaF)[0];
//			return aux2;
//		}
//		public void AgregarCheff(Cheff c,String ruta){
//			String rC=path+ruta+tipo;
//			String contenido=this.LeerFichero(rC);
//			String aux=getXstream().toXML(c);
//			String guardar=this.QuitarEtiquetaPrincipal("</ListaCheff>",aux);
//			guardar+=aux;
//			
//			
//		}
//		/*Este codigo no es de mi pertenencia fue sacado de esta pagina por su buena implementacion
//		 * http://todoelmed.blogspot.com/2012/05/manejo-de-archivos-o-ficheros-en.html
//		 */
//		
//		public void GuardarFichero(String ruta,String SCadena){
//			  try {
//				  
//				  File Ffichero=new File(path+ruta+".xml");
//			        //Si no Existe el fichero lo crea
//			         if(!Ffichero.exists()){
//			            Ffichero.createNewFile();
//			         }
//		         /*Abre un Flujo de escritura,sobre el fichero con codificacion utf-8. 
//	           *Además  en el pedazo de sentencia "FileOutputStream(Ffichero,true)",
//	           *true es por si existe el fichero seguir añadiendo texto y no borrar lo que tenia*/
//			         BufferedWriter Fescribe=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Ffichero,true), "utf-8"));
//		          /*Escribe en el fichero la cadena que recibe la función. 
//		           *el string "\r\n" significa salto de linea*/
//		          Fescribe.write(SCadena + "\r\n");
//		          //Cierra el flujo de escritura
//		          Fescribe.close();
//		       } catch (Exception ex) {
//		          //Captura un posible error le imprime en pantalla 
//		          System.out.println(ex.getMessage());
//		        } 
//			}
//		
//		public String LeerFichero(String ruta){
//			File Ffichero=new File(path+ruta+".xml");   
//			String aux="";
//			       
//			try {
//				   /*Si existe el fichero*/
//			       if(Ffichero.exists()){
//			           /*Abre un flujo de lectura a el fichero*/
//			           BufferedReader Flee= new BufferedReader(new FileReader(Ffichero));
//			           String Slinea;
//			           System.out.println("**********Leyendo Fichero***********");
//			           /*Lee el fichero linea a linea hasta llegar a la ultima*/
//			           
//			           while((Slinea=Flee.readLine())!=null) {
//			           /*Imprime la linea leida*/    
//			           System.out.println(Slinea);  
//			           aux+=Slinea;
//			           }
//			           System.out.println("*********Fin Leer Fichero**********");
//			           /*Cierra el flujo*/
//			           Flee.close();
//			         }else{
//			           System.out.println("Fichero No Existe");
//			       
//			         }
//			   } catch (Exception ex) {
//			       /*Captura un posible error y le imprime en pantalla*/ 
//			        System.out.println(ex.getMessage());
//			   }
//			return aux;
//			 }
		 
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
			public String getSCheff() {
				return SCheff;
			}
			public void setSCheff(String sCheff) {
				SCheff = sCheff;
			}
			public String getSPlatillo() {
				return SPlatillo;
			}
			public void setSPlatillo(String sPlatillo) {
				SPlatillo = sPlatillo;
			}
			public String getSIngredientes() {
				return SIngredientes;
			}
			public void setSIngredientes(String sIngredientes) {
				SIngredientes = sIngredientes;
			}
			public String getRutaCheff() {
				return rutaCheff;
			}
			public void setRutaCheff(String rutaCheff) {
				this.rutaCheff = rutaCheff;
			}
			public String getRutaIngrediente() {
				return rutaIngrediente;
			}
			public void setRutaIngrediente(String rutaIngrediente) {
				this.rutaIngrediente = rutaIngrediente;
			}
			public String getRutaPlatillos() {
				return rutaPlatillos;
			}
			public void setRutaPlatillos(String rutaPlatillos) {
				this.rutaPlatillos = rutaPlatillos;
			}
			public String getTipo() {
				return tipo;
			}
			public void setTipo(String tipo) {
				this.tipo = tipo;
			}
			
}