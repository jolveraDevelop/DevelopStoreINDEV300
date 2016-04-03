package mx.com.develop.store.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Humberto
 */
@Entity
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
            generator = "SEQUENCE_PRODUCTOS")
    private Integer id;
    private Color color;
    @Column
    private double precio;
    private Talla talla;
    @Column
    private String descripcion;
    private TipoProducto tipo;
    @Column
    private Integer disponibles;

    public Producto() {
    }

    public Producto(Integer id, Color color, double precio, Talla talla, String descripcion, TipoProducto tipo) {
        this.id = id;
        this.color = color;
        this.precio = precio;
        this.talla = talla;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.setDisponibles(10);
    }

    public Producto(Color color, double precio, Talla talla, String descripcion, TipoProducto tipo) {
        this.color = color;
        this.precio = precio;
        this.talla = talla;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public TipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Talla getTalla() {
        return talla;
    }

    public void setTalla(Talla talla) {
        this.talla = talla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(Integer disponibles) {
        this.disponibles = disponibles;
    }

}
