/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.develop.store.model;

/**
 * 
 * @author Humberto
 */
public enum TipoProducto {

	PLAYERA("Playera"), PANTALON("Pantalon"), BLUSA("Blusa"), CAMISA("Pantalón");

	private String titulo;

	private TipoProducto(String tipo) {
		this.titulo = tipo;
	}

	public String getTitulo() {
		return titulo;
	}
}
