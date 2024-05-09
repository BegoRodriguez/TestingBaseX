package dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import modelo.Producto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class DAOProducto {

    SessionFactory sessionFactory;
    Configuration configuration;

    public DAOProducto(){

        // Create Configuration
        configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Producto.class);
        sessionFactory = configuration.buildSessionFactory();

    }

    public Producto findById(int id) {
        // Create Session Factory and auto-close with try-with-resources.

        // Inicializamos Objecto Sesión
        Session session = sessionFactory.openSession();
        return session.get(Producto.class, id);

    }

    public void save(Producto producto) {

        // Inicializamos Objecto Sesión
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(producto);
        tx1.commit();
        session.close();

    }

    public void update(Producto producto) {

        // Inicializamos Objecto Sesión
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(producto);
        tx1.commit();
        session.close();

    }

    public void delete(Producto producto) {

        // Inicializamos Objecto Sesión
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(producto);
        tx1.commit();
        session.close();

    }

    public List<Producto> findAll() {

        // Inicializamos Objecto Sesión
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Producto> criteria = builder.createQuery(Producto.class);
        criteria.from(Producto.class);

        List<Producto> listaProductos = (List<Producto>) session.createQuery(criteria).getResultList();

        return listaProductos;

    }
}
