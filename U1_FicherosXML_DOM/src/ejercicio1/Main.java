package ejercicio1;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {

	public static void main(String[] args) {
		File file = new File("peliculas.xml");
		
		try {
			  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			  Document doc = dBuilder.parse(file);
			  
			  doc.getDocumentElement().normalize();
			  
			  NodeList listaPeliculas = doc.getElementsByTagName("Pelicula");
			  System.out.println("Número de Películas: " + listaPeliculas.getLength());
			  
			  for(int i = 0; i < listaPeliculas.getLength(); i++) {
				  Node nodePeliculas = listaPeliculas.item(i);
				  if(nodePeliculas.getNodeType() == Node.ELEMENT_NODE) {
				    Element eElement = (Element) nodePeliculas;				    
				    
				    System.out.println("\nPelícula: " + i);
				    
				    // LEER TITULO
				    // ---------------------------------------------------------------------------------------------
				    System.out.println("Título: "
				                + eElement.getElementsByTagName("Titulo").item(0).getTextContent());
				    
				    // LEER FECHA
				    // ---------------------------------------------------------------------------------------------
				    
				    if (eElement.getElementsByTagName("Fecha").item(0).getTextContent().equals("0")) {
				        System.out.println("Año: Fecha no especificada");
				    } else {
				        System.out.println("Año: " + eElement.getElementsByTagName("Fecha").item(0).getTextContent());
				    }
				    
				    // LEER DIRECTOR
				    // ---------------------------------------------------------------------------------------------
				    
				    System.out.println("Director: "
			                + eElement.getElementsByTagName("Director").item(0).getTextContent());
				    
				    // LEER ACTORES
				    // ---------------------------------------------------------------------------------------------
				    
				    System.out.println("Actores: ");
				    NodeList listaActores = eElement.getElementsByTagName("Actor");
				    for (int j = 0; j < listaActores.getLength(); j++) {
				        Node nodeActores = listaActores.item(j);
				        
				        if (nodeActores.getNodeType() == Node.ELEMENT_NODE) {
				            System.out.println("   Actor " + j + ": " + nodeActores.getTextContent());
				        }
				    }
				    
				    // ---------------------------------------------------------------------------------------------				    
				   
				  }
				}
			  
			} catch(Exception e) {
			  e.printStackTrace();
			}
		
		
	}

}