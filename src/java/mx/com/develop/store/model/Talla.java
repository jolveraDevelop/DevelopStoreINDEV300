/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.develop.store.model;

/**
 * 
 * @author Humberto
 */
public enum Talla {
	CHICA("Chica"), MEDIANA("Mediana"), GRANDE("Grande"), EXTRA_GRANDE("Extra Grande");

   

    private Talla(String titulo) {
        this.titulo = titulo;
    }
    
     private String titulo;

    public String getTitulo() {
        return titulo;
    }
     
}
