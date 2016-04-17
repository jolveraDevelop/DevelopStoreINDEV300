/*
 * Cliente.java
 * 
 * Creada el May 24, 2014, 2:00:41 PM
 * 
 * Clase Java desarrollada por Humberto BanueloS para la empresa Develop el día May 24, 2014
 * 
 * Para informacion sobre el uso de esta clase, asi como bugs, actualizaciones, o mejoras enviar un mail a
 * hbanuelos@7i.com.mx
 */
package mx.com.develop.store.model;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * 
 * @author Humberto BanueloS
 * @version 1.0
 * @author-mail hbanuelos@7i.com.mx
 * @creation-date May 24, 2014
 */
public class Cliente implements HttpSessionBindingListener{

	private String nombre;
	private int edad;
	private String direccion;
	private String telefono;
	private String usuario;
	private String contrasenia;
        
        public static Integer COUNT = 0;

	public Cliente() {
	}

    public Cliente(String nombre, String usuario, String contrasenia) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }
        
        

	public Cliente(String nombre, int edad, String direccion, String telefono, String usuario, String contrasenia) {
		this.nombre = nombre;
		this.edad = edad;
		this.direccion = direccion;
		this.telefono = telefono;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        Cliente.COUNT++;
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        Cliente.COUNT--;
    }

}
