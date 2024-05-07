package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class CrearXML {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            // Crear elementos y atributos según tus necesidades
            Element rootElement = document.createElement("Catalogo");

            for (int i=1;i<20;i++) {
                Element productoElement = document.createElement("Producto");
                String numero = ""+i;
                productoElement.setAttribute("id", numero);
                productoElement.setTextContent("Producto" + numero);

                rootElement.appendChild(productoElement);
                //Element br = document.createElement("br");
                //rootElement.appendChild(br);
            }
            document.appendChild(rootElement);

            // Guardar el archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult("./src/main/resources/xml/catalogo.xml");
            transformer.transform(source, result);

            System.out.println("Archivo XML creado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
