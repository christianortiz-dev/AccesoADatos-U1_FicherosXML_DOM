package ejercicio3;

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

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Receta receta1 = new Receta("Pollo al chilindrón", "Pollo", "750gr", "Especias", "una pizca",
				"Asar el pollo y echarle especias", "30 min");

//		System.out.println(receta1.getCantidad1());

		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();

			// definimos el elemento raíz del documento (Receta)
			Element eRaiz = doc.createElement("Receta");
			doc.appendChild(eRaiz);

			// definimos titulo
			Element eTitulo = doc.createElement("titulo");
			eTitulo.appendChild(doc.createTextNode(receta1.getTitulo()));
			eRaiz.appendChild(eTitulo);

			// definimos el nodo que contendrá los elementos (Ingredientes)
			Element eIngredientes = doc.createElement("ingredientes");
			eRaiz.appendChild(eIngredientes);

			// definimos Ingrediente1
			Element eIngrediente1 = doc.createElement("ingrediente");
			eIngrediente1.appendChild(doc.createTextNode(receta1.getIngrediente1()));
			eIngredientes.appendChild(eIngrediente1);

			// atributo para el nodo Ingrediente1
			Attr attrIngr1 = doc.createAttribute("cantidad");
			attrIngr1.setValue(receta1.getCantidad1());
			eIngrediente1.setAttributeNode(attrIngr1);

			// definimos Ingrediente2
			Element eIngrediente2 = doc.createElement("ingrediente");
			eIngrediente2.appendChild(doc.createTextNode(receta1.getIngrediente2()));
			eIngredientes.appendChild(eIngrediente2);

			// atributo para el nodo Ingrediente2
			Attr attrIngr2 = doc.createAttribute("cantidad");
			attrIngr2.setValue(receta1.getCantidad2());
			eIngrediente2.setAttributeNode(attrIngr2);

			// definimos Procemientos
			Element eProcedimiento = doc.createElement("procedimiento");
			eProcedimiento.appendChild(doc.createTextNode(receta1.getProcedimiento()));
			eRaiz.appendChild(eProcedimiento);

			// definimos Tiempo
			Element eTiempo = doc.createElement("tiempo");
			eTiempo.appendChild(doc.createTextNode(receta1.getTiempo()));
			eRaiz.appendChild(eTiempo);

			// clases necesarias finalizar la creación del archivo XML
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("RecetaDOM2.xml"));

			transformer.transform(source, result);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
