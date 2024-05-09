package modelo;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    @Id
    @GenericGenerator(name="incrementId",strategy="increment") @GeneratedValue(generator="incrementId")
    @Column(name = "cliente_id") private int codigo;
    @Column(name = "nombre") private String nombre;
    @Column(name = "nif") private String nif;
    @Column(name = "direccion") private String direccion;

    /* Como es autoincremental no asignamos codigo para persistir en Hibernate */
    public Cliente(String nombre, String nif, String direccion) {
        this.nombre = nombre;
        this.nif = nif;
        this.direccion = direccion;
    }

    /* Constructor vacío necesario para realizar consultas en Hibernate */
    public Cliente(){}

    /* Necesitamos este constructor para leer del XML */
    public Cliente(int codigo, String nombre, double precio, String categoria, int unidades) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nif = nif;
        this.direccion = direccion;
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

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
