package org.example;
// Java Program to Illustrate App File

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

// Main class
public class AppCRUD {

    //  Ejemplo de diferentes operaciones crud
    public static void crud()
    {
        // Create Configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Producto.class);

        // Create Session Factory and auto-close with try-with-resources.
        try (SessionFactory sessionFactory
                     = configuration.buildSessionFactory()) {

            // Initialize Session Object
            Session session = sessionFactory.openSession();

            // Insertar un producto en la base de datos - Create
            Producto producto = new Producto("Pera",1.0,"fruta",10);
            session.beginTransaction();

            // Here we have used
            // persist() method of JPA
            session.persist(producto);

            session.getTransaction().commit();

            Transaction t = session.beginTransaction();

            // Seleccionar un producto de la base de datos - Retrieve
            Producto p1 = session.get(Producto.class,1);
            System.out.println(p1.getNombre());
            System.out.println(p1.getPrecio());

            // Modificar en la base de datos - Update
            p1.setPrecio(1.1);
            session.save(p1);
            t.commit();

            // Eliminar en la base de datos - Delete
            Transaction t2=session.beginTransaction();

            Producto s=session.get(Producto.class, 15);
            session.delete(s);
            t2.commit();

        }
    }
}