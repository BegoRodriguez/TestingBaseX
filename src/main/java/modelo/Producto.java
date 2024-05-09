package modelo;

import java.io.Serializable;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    @Id
    @GenericGenerator(name="incrementId",strategy="increment") @GeneratedValue(generator="incrementId")
    @Column(name = "producto_id") private int codigo;
    @Column(name = "nombre") private String nombre;
    @Column(name = "precio") private double precio;
    @Column(name = "categoria") private String categoria;
    @Column(name = "unidades") private int unidades;

    /* Como es autoincremental no asignamos codigo para persistir en Hibernate */
    public Producto(String nombre, double precio, String categoria, int unidades) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.unidades = unidades;
    }

    /* Constructor vacío necesario para realizar consultas en Hibernate */
    public Producto(){}

    /* Necesitamos este constructor para leer del XML */
    public Producto(int codigo, String nombre, double precio, String categoria, int unidades) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.unidades = unidades;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

}
