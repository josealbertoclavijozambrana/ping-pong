/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author jose clavijo
 */
public class Barra {
   
    boolean isUpPressed, isDownPressed;
    private int barraposX = 200, barraposY = 100, barraancho = 20, barraalto = 100;
    private Color color_barra = Color.RED;
    // es la proxima lugar que se va a redibujar
    private int velocidadBarra=1;
    private boolean bajar = true, derecha = true;

    public int getVelocidadBarra() {
        return velocidadBarra;
    }

    public void setVelocidadBarra(int velocidadBarra) {
        this.velocidadBarra = velocidadBarra;
    }

    public int getBarraancho() {
        return barraancho;
    }

    public void setBarraancho(int barraancho) {
        this.barraancho = barraancho;
    }

    public int getBarraalto() {
        return barraalto;
    }

    public void setBarraalto(int barraalto) {
        this.barraalto = barraalto;
    }

    public Color getColor_barra() {
        return color_barra;
    }

    public void setColor_barra(Color color_barra) {
        this.color_barra = color_barra;
    }

    public boolean isIsUpPressed() {
        return isUpPressed;
    }

    public void setIsUpPressed(boolean isUpPressed) {
        this.isUpPressed = isUpPressed;
    }

    public boolean isIsDownPressed() {
        return isDownPressed;
    }

    public void setIsDownPressed(boolean isDownPressed) {
        this.isDownPressed = isDownPressed;
    }

    public void dibujar(Graphics g) {
        g.setColor(color_barra);
        g.fillRect(barraposX, barraposY, barraancho, barraalto);
        // g.fillRect(barraposX - 296, barraposY, barraancho, barraalto);
    }
      public void sicolisiona(){
      derecha=!derecha;
      bajar=!bajar; 
    
    }

    public void setColor_pelota(Color color_barra) {
        this.color_barra = color_barra;
    }

    public int getBarraposY() {
        return barraposY;
    }

    public void setBarraposY(int barraposY) {
        this.barraposY = barraposY;
    }

    public int getBarraposX() {
        return barraposX;
    }

    public void setBarraposX(int barraposX) {
        this.barraposX = barraposX;
    }
    
     public void arriba() {
        barraposY -= velocidadBarra;
    }
 

    public void abajo() {
        barraposY += velocidadBarra;
    }
        public boolean mover(int ancho, int alto) {

      
        
           if (barraposX  >= ancho) {
            derecha=false;
            
            return true;
        }
        if (barraposY >= alto) {
            bajar=false;
            
            return true;
        }
        return false;
    }
    
}
