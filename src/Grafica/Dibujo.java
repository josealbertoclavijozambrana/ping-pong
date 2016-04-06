/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafica;

import Logica.Barra;
import Logica.Jugador;
import Logica.Pelota;
import Logica.Poderes;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * PARA EL DIA MARTES 14/10/2014 AUMENTAR Y REDUCIR EN ANCHO Y ALTO LA FIGURA
 * CAMBIAR LA FORMA DE LA FIGURA DE OVALO O ESFERA A RECTANGULO Y VICEVERSA!!
 *
 * @author jose clavijo
 */
public class Dibujo extends JPanel implements Runnable {

    private Color color_fondo = Color.WHITE;
    private int contador = 0;
    private int precontador = 0;
    private int tiempo = 0;
    private Pelota pelota = new Pelota();
    private Barra barrasIzquierda = new Barra();
    private Barra barrasDerecha = new Barra();
    private boolean bajar = true;
    private boolean subir = false;
    private boolean cuadrado = false;
    public Jugador p1 = new Jugador("", 0);
    public Jugador p2 = new Jugador("", 0);
    int punt1 = 0;
    int punt2 = 0;
    private Poderes poderesbarrasIzquierda = new Poderes();
    private Poderes poderesbarrasDerecha = new Poderes();

    public Dibujo() {
        //  pelotas.add(new Pelota());
        barrasDerecha = new Barra();
        barrasDerecha.setColor_pelota(Color.BLACK);
        barrasDerecha.setBarraposX(850);
        barrasIzquierda = new Barra();
        barrasIzquierda.setColor_pelota(Color.BLUE);
        barrasIzquierda.setBarraposX(10);





    }

    public Barra getBarrasIzquierda() {
        return barrasIzquierda;
    }

    public void setBarrasIzquierda(Barra barrasIzquierda) {
        this.barrasIzquierda = barrasIzquierda;
    }

    public Barra getBarrasDerecha() {
        return barrasDerecha;
    }

    public void setBarrasDerecha(Barra barrasDerecha) {
        this.barrasDerecha = barrasDerecha;
    }

    public Pelota getPelota() {
        return pelota;
    }

    public void setPelota(Pelota pelota) {
        this.pelota = pelota;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(color_fondo);
        g.fillRect(0, 0, 900, 500);
        // for (Pelota pelota : pelotas) {
        pelota.dibujar(g);
        // }
        barrasIzquierda.dibujar(g);
        barrasDerecha.dibujar(g);
        g.drawString(p1.getNombreJugador(), 2, 20);
        g.drawString(p2.getNombreJugador(), 845, 20);
        g.drawString(punt1 + "  !!  " + punt2, 425, 20);


    }

    public void cambiarFigura() {
        cuadrado = !cuadrado;
        this.repaint();
    }

    public boolean isBajar() {
        return bajar;
    }

    public void setBajar(boolean bajar) {
        this.bajar = bajar;
    }

    public boolean isSubir() {
        return subir;
    }

    public void setSubir(boolean subir) {
        this.subir = subir;
    }

    public void siColisionan() {
        Rectangle area1 = new Rectangle(pelota.getPosX(), pelota.getPosY(), pelota.getTamaño() - 5, pelota.getTamaño() - 10);
        Rectangle area2 = new Rectangle(barrasIzquierda.getBarraposX(), barrasIzquierda.getBarraposY(), barrasIzquierda.getBarraancho() + 10, barrasIzquierda.getBarraalto() + 20);
        Rectangle area3 = new Rectangle(barrasDerecha.getBarraposX(), barrasDerecha.getBarraposY(), barrasDerecha.getBarraancho() + 20, barrasDerecha.getBarraalto() + 20);

        if (area1.intersects(area3)) {
            pelota.sicolisiona();
            barrasDerecha.sicolisiona();
        }
        if (area1.intersects(area2)) {
            pelota.sicolisiona();
            barrasIzquierda.sicolisiona();
        }


    }

    public int siColisionaPared() {
        Rectangle area1 = new Rectangle(pelota.getPosX(), pelota.getPosY(), pelota.getTamaño() - 5, pelota.getTamaño() - 10);
        Rectangle paredderecha = new Rectangle(878, 0, 1, 500);
        Rectangle paredizquierda = new Rectangle(0, 0, 1, 500);

        if (area1.intersects(paredderecha)) {
            return 1;
        }
        if (area1.intersects(paredizquierda)) {
            return 2;
        }
        return 0;
    }

    @Override
    public void run() {
        boolean finish = true;
        while (finish) {
            if (punt1 == 2) {
                JOptionPane.showMessageDialog(null, "fin1");
                finish = false;
            }
            if (punt2 == 2) {
                JOptionPane.showMessageDialog(null, "fin2");
                finish = false;
            }
            //for (Pelota pelota : pelotas) {

            //  contador++;
            // }
            //}
            pelota.mover(this.getWidth(), this.getHeight());
            barrasIzquierda.mover(this.getHeight(), this.getWidth());
            barrasDerecha.mover(this.getWidth(), this.getHeight());
            siColisionan();
            if (siColisionaPared() == 1) {
                p1.setPuntos(p1.getPuntos() + 1);
                punt1 = p1.getPuntos();

            }
            if (siColisionaPared() == 2) {
                p2.setPuntos(p2.getPuntos() + 1);
                punt2 = p2.getPuntos();
            }

            if (barrasDerecha.isIsUpPressed()) {
                if (barrasDerecha.getBarraposY() > 0) {
                    barrasDerecha.arriba();
                }
            }
            if (barrasDerecha.isIsDownPressed()) {
                if (barrasDerecha.getBarraposY() + barrasDerecha.getBarraancho() < this.getHeight() - 79) {
                    barrasDerecha.abajo();
                }
            }
            //----
            if (barrasIzquierda.isIsUpPressed()) {
                if (barrasIzquierda.getBarraposY() > 0) {
                    barrasIzquierda.arriba();
                }
            }
            if (barrasIzquierda.isIsDownPressed()) {
                if (barrasIzquierda.getBarraposY() + barrasIzquierda.getBarraancho() < this.getHeight() - 79) {
                    barrasIzquierda.abajo();
                }
            }


            this.repaint();
            try {
                // es el tiempo del juego.
                contador++;
                precontador = contador / 200;
                if (precontador != tiempo) {
                    tiempo = precontador;
                    System.out.println(tiempo);
                    // poderes barra grande por 5 puntos
                    int r = punt1 % 5;
                    if (r == 0) {
                        System.out.println("multiplo de 5");
                        if (punt1 != 0) {

                            List<Integer> multiplos = poderesbarrasIzquierda.getMultiplos();
                            if (!multiplos.contains(punt1)) {
                                poderesbarrasIzquierda.setDuracion(tiempo + poderesbarrasIzquierda.getDuracionPoder());
                                System.out.println("agrandar barra");
                                multiplos.add(punt1);
                                poderesbarrasIzquierda.setMultiplos(multiplos);
                                poderesbarrasIzquierda.setPod(barrasIzquierda);
                                poderesbarrasIzquierda.agrandarBarra();
                            }
                        }
                        if (poderesbarrasIzquierda.getDuracion() == tiempo) {
                            poderesbarrasIzquierda.achicarBarra();
                            System.out.println("achicar barra");
                            poderesbarrasIzquierda.setDuracion(0);
                        }
                    }
                    /*if (punt2 != 0) {
                     int r = punt2 % 5;
                     if (r == 0) {
                     System.out.println("sip barra 2");
                     barrasDerecha.setBarraalto(barrasDerecha.getBarraalto() * 2);
                     }
                     }*/

                    r = tiempo % 2;
                    if (r == 0) {
                        // cada 5 segundos
                        double velo;
                        velo = Math.random();
                        if (velo > 0.5) {
                            pelota.setVelocidadPelota(pelota.getVelocidadPelota() * 2);
                        } else {
                            pelota.setVelocidadPelota(pelota.getVelocidadPelota() / 2);
                        }
                    }
                }
                /* System.out.println(contador);
                 System.out.println(precontador);
                 System.out.println(tiempo);*/
                // velocidad del juego
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(Dibujo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // throw new UnsupportedOperationException("Not supported yet.");
    }
}
