package org.example;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;

public class LeerXMLConDOM {
    public static void main(String[] args) {
        try {
            File file = new File("./src/main/resources/xml/productos.xml"); // Ruta al archivo XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            // Normalizar el documento (opcional)
            doc.getDocumentElement().normalize();

            // Obtener el nodo raíz
            Element root = doc.getDocumentElement();

            /* Estructura de la tienda
            <tienda>
                <producto codigo="P001">
                    <nombre>Camiseta de manga corta</nombre>
                    <descripcion>Camiseta de algodón para hombre, color negro</descripcion>
                    <precio>19.99</precio>
                    <categoria>Ropa</categoria>
                    <disponibilidad>En stock</disponibilidad>
                    <unidades>10</unidades>
                    <imagen>https://ejemplo.com/imagen1.jpg</imagen>
                </producto>
              </tienda> */



            // Obtener los nodos "productos"
            NodeList nodeList = root.getElementsByTagName("producto");
            System.out.println("Número de productos: " + nodeList.getLength());

            // Definimos un array de productos por si queremos trabajar con ellos en nuestra app
            ArrayList<Producto> productos = new ArrayList<Producto>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) { // Comprobamos que el nodo sea un elemento
                    Element producto = (Element) node;

                    System.out.println("\nProducto id: " + producto.getAttribute("codigo"));
                    System.out.println("Nombre: " + producto.getElementsByTagName("nombre").item(0).getTextContent());
                    System.out.println("Precio: " + producto.getElementsByTagName("precio").item(0).getTextContent());
                    System.out.println("Categoria: " + producto.getElementsByTagName("categoria").item(0).getTextContent());
                    System.out.println("Unidades: " + producto.getElementsByTagName("unidades").item(0).getTextContent());

                    /* Si queremos guardar los productos en una clase en nuestro programa */
                    String codigo = producto.getAttribute("codigo");
                    String nombre = producto.getElementsByTagName("nombre").item(0).getTextContent();
                    double precio = Double.parseDouble(producto.getElementsByTagName("precio").item(0).getTextContent());
                    String categoria = producto.getElementsByTagName("categoria").item(0).getTextContent();
                    int unidades = Integer.parseInt(producto.getElementsByTagName("unidades").item(0).getTextContent());
                    productos.add(new Producto(codigo,nombre,precio,categoria,unidades));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
