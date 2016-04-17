/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.develop.store.model;

/**
 * 
 * @author Humberto
 */
public enum Color {

	ROJO("Rojo"), AZUL("Azul"), VERDE("Verde"), MORADO("Morado"), NARANJA("Naranja"), CAFE("Café"), NEGRO("Negro"), AMARILLO("Amarillo"), VIOLETA("Violeta"), BLANCO("Blanco");

	private String titulo;

	private Color(String color) {
		this.titulo = color;
	}

	public String getTitulo() {
		return titulo;
	}

    @Override
    public String toString() {
        return titulo;
    }
        
        
}
