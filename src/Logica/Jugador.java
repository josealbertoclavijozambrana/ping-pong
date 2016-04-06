/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author jose clavijo
 */
public class Jugador {
    private String nombreJugador;
    private int puntos= 0;
   

    public Jugador(String nombreJugador, int puntos) {
        this.nombreJugador = nombreJugador;
        this.puntos = puntos;
    }

 

    public String getNombreJugador() {
        
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getPuntos() {
        
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
}
