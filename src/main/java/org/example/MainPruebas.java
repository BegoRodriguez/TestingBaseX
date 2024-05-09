package org.example;

import dao.DAOGenerico;
import dao.DAOProducto;
import modelo.Cliente;
import modelo.Producto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static xml.ParseadorProductos.*;

public class MainPruebas {

    public static void main(String[] args) {
        ArrayList<Producto> productos = leerXMLConDOM();
        escribirXMLconDOM(productos);
        //persistirenBD(productos); //No quiero hacerlo cada vez

        DAOProducto daoProducto = new DAOProducto();
        System.out.println(daoProducto.findById(1).getNombre());
        System.out.println(daoProducto.findById(2).getNombre());

        //daoProducto.save(new Producto("Camiseta de manga larga",29.99,"Ropa",8));
        Producto pu = daoProducto.findById(6);
        pu.setUnidades(6);
        daoProducto.update(pu);

        List<Producto> listaProductos = daoProducto.findAll();
        Iterator<Producto> it = listaProductos.iterator();
        while (it.hasNext()) {
            Producto p = it.next();
            System.out.println(p.getCodigo()+ " "+ p.getNombre());
        }

        DAOGenerico daoEjProducto = new DAOGenerico(Producto.class);
        Producto pg = (Producto) daoEjProducto.findById(Producto.class,1);
        System.out.println("Con genericos :" + pg.getNombre());

        DAOGenerico daoEjCliente = new DAOGenerico(Cliente.class);
        daoEjCliente.save(new Cliente("Paco Pérez","12345678A","Jose Luis Arrese, 8"));


    }


}
