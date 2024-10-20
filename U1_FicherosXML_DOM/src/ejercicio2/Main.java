package ejercicio2;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {

	public static void main(String[] args) {
		
		File file = new File("Productos.xml");
		
		try {
			  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			  Document doc = dBuilder.parse(file);
			  
			  doc.getDocumentElement().normalize();
			  
			  NodeList listaProductos = doc.getElementsByTagName("Producto");
			  System.out.println("Número de Productos: " + listaProductos.getLength());
			  
			  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			  DocumentBuilder db = dbf.newDocumentBuilder();
			  Document doc2 = db.newDocument();
			  
			  Element eRaiz = doc2.createElement("ListaProductos");
			  doc2.appendChild(eRaiz);
			  
			  int id = 1;
			  
			  for(int i = 0; i < listaProductos.getLength(); i++) {
				  Node nodeProductos = listaProductos.item(i);  	  	
				  
				    
				  
				  if(nodeProductos.getNodeType() == Node.ELEMENT_NODE) {
				    Element eElement = (Element) nodeProductos;			
				    
				    // definimos el nodo que contendrá los elementos
				    Element eProducto= doc2.createElement("Producto");
				    eRaiz.appendChild(eProducto);

				    
				    // atributo id para los nodos productos
				    Attr attr_id = doc2.createAttribute("id");
				    attr_id.setValue(i + id + "");
				    eProducto.setAttributeNode(attr_id);

				    
				    // convertimos Stock en Int para hacer la condicion del atributo
				    int stockInt = Integer.parseInt(eElement.getElementsByTagName("Stock").item(0).getTextContent().trim());

				    if (stockInt <= 5) {
				        Attr attr_aLaVenta = doc2.createAttribute("aLaVenta");
				        attr_aLaVenta.setValue("false");
				        eProducto.setAttributeNode(attr_aLaVenta);		
				    } else {
				        Attr attr_aLaVenta = doc2.createAttribute("aLaVenta");
				        attr_aLaVenta.setValue("true");
				        eProducto.setAttributeNode(attr_aLaVenta);		
				    }	    
				    
				    
				    // definimos cada uno de los elementos y le asignamos un valor
				    Element eNombre = doc2.createElement("Nombre");
				    eNombre.appendChild(doc2.createTextNode(eElement.getElementsByTagName("Nombre").item(0).getTextContent()));
				    eProducto.appendChild(eNombre);
				    
				    // definimos cada uno de los elementos y le asignamos un valor
				    Element ePrecio = doc2.createElement("Precio");
				    ePrecio.appendChild(doc2.createTextNode(eElement.getElementsByTagName("Precio").item(0).getTextContent()));
				    eProducto.appendChild(ePrecio);
				    
				    // definimos cada uno de los elementos y le asignamos un valor
				    Element eStock = doc2.createElement("Stock");
				    eStock.appendChild(doc2.createTextNode(eElement.getElementsByTagName("Stock").item(0).getTextContent()));
				    eProducto.appendChild(eStock);
				    
				    
				    // LEER (NO ES DE ESTE) -----------------------------------------------------------------------------------------------------
				    System.out.println("\n");	
				    
				    System.out.println("Nombre: "
			                + eElement.getElementsByTagName("Nombre").item(0).getTextContent());
				    
				    System.out.println("Precio: "
			                + eElement.getElementsByTagName("Precio").item(0).getTextContent());
				    
				    System.out.println("Stock: "
			                + eElement.getElementsByTagName("Stock").item(0).getTextContent());		   
			    	// LEER (NO ES DE ESTE) -----------------------------------------------------------------------------------------------------
				   
				  }
				}
			  
			// clases necesarias finalizar la creación del archivo XML
		    TransformerFactory transformerFactory = TransformerFactory.newInstance();
		    Transformer transformer = transformerFactory.newTransformer();
		    DOMSource source = new DOMSource(doc2);
		    StreamResult result = new StreamResult(new File("NuevoDOC.xml"));

		    transformer.transform(source, result);
			    
			} catch(Exception e) {
			  e.printStackTrace();
			}
		
		
		
		
		
		
		
		
	}

}
