/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author jose clavijo
 */
public class Pelota {

    private int posX = 50, posY = 50, ancho = 30, alto = 30;
    private Color color = Color.RED;
    private boolean bajar = true, subir = true, derecha = true;
    private int velocidadPelota = 1;

    public int getVelocidadPelota() {
        return velocidadPelota;
    }

    public void setVelocidadPelota(int velocidadPelota) {
        this.velocidadPelota = velocidadPelota;
    }

    //dibujar la pelota
    public void dibujar(Graphics g) {
        g.setColor(color);
        g.fillOval(posX, posY, ancho, alto);
    }

    public void derecha() {
        posX += velocidadPelota;
    }

    public void izquierda() {
        posX -= velocidadPelota;
    }

    public void arriba() {
        posY -= velocidadPelota;
    }

    public void abajo() {
        posY += velocidadPelota;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getTamaño() {
        return ancho;
    }

    public void setTamaño(int tamaño) {
        this.ancho = tamaño;
    }

    public void sicolisiona() {
        double rand = Math.random();
        if (rand < 0.5) {
            bajar = !bajar;
        } else {
            subir = !subir;
        }

        derecha = !derecha;

    }

    public boolean mover(int ancho, int alto) {
        if (bajar) {
            abajo();
        } else {
            arriba();
        }
        if (derecha) {
            derecha();
        } else {
            izquierda();
        }
        if (posX + this.ancho >= ancho) {
            derecha = false;
            return true;
        }
        if (posY + this.alto >= alto) {
            bajar = false;

            return true;
        }
        if (posX <= 0) {
            derecha = true;

            return true;
        }
        if (posY <= 0) {
            bajar = true;

            return true;
        }
        return false;
    }
}
