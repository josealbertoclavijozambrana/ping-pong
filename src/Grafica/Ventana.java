/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafica;

import Logica.Jugador;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

/**
 *
 * @author jose clavijo
 */
public class Ventana extends JFrame implements KeyListener, MouseListener {
    
    private Dibujo panel = new Dibujo();
    private JPanel arriba = new JPanel();
    private Thread hilo;
   

   
    
    
    public Ventana() throws InterruptedException {
        this.setTitle("PRO-2 Proyecto");
     
        
      
        
        panel.p1.setNombreJugador(JOptionPane.showInputDialog(null, "Ingrese el nombre del Jugador 1: "));
        panel.p2.setNombreJugador(JOptionPane.showInputDialog(null, "Ingrese el nombre del Jugador 2: "));
        
        this.setSize(900, 500);
        arriba.setPreferredSize(new Dimension(100, 30));
        arriba.setLayout(new BorderLayout());
        this.setBounds(0, 0, 900, 500);
  
//        puntos.setText(jugador1.getPuntos() + "");
//        puntos2.setText(jugador2.getPuntos() + "");
        
        this.setLayout(new BorderLayout());
     

        //this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
        
        this.addKeyListener(this);
        panel.getPelota().setVelocidadPelota(3);
        panel.getBarrasDerecha().setVelocidadBarra(3);
        panel.getBarrasIzquierda().setVelocidadBarra(3);
        this.hilo = new Thread(panel);
        hilo.start();
        // this.add(fondo);

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        // throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                panel.getBarrasDerecha().setIsUpPressed(true);
                break;
            case KeyEvent.VK_DOWN:
                panel.getBarrasDerecha().setIsDownPressed(true);
                break;
            case KeyEvent.VK_W:
                panel.getBarrasIzquierda().setIsUpPressed(true);
                break;
            case KeyEvent.VK_S:
                panel.getBarrasIzquierda().setIsDownPressed(true);
                break;
            
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                panel.getBarrasDerecha().setIsUpPressed(false);
                break;
            case KeyEvent.VK_DOWN:
                panel.getBarrasDerecha().setIsDownPressed(false);
                break;
            case KeyEvent.VK_W:
                panel.getBarrasIzquierda().setIsUpPressed(false);
                break;
            case KeyEvent.VK_S:
                panel.getBarrasIzquierda().setIsDownPressed(false);
                break;
            
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
    }
//    @Override
//    public void run() {
//         public void run() {
//        while (true) {
//            try {
//                if (isUpPressed) {
//                    if (panel.getPosY() > 0) {
//                        panel.arriba();
//                    }
//                }
//                if (isDownPressed) {
//                    if (panel.getPosY() + panel.getTamaño() < this.getHeight() - 150) {
//                        panel.abajo();
//                    }
//                }
//                //----
//                if (isWPressed) {
//                    if (panel.getPosY2() > 0) {
//                        panel.arriba2();
//                    }
//                }
//                if (isSPressed) {
//                    if (panel.getPosY2() + panel.getTamaño() < this.getHeight() - 150 ) {
//                        panel.abajo2();
//                    }
//                 
//               
//                }
//                
//                Thread.sleep(20);
//            } catch (Exception exc) {
//                exc.printStackTrace();
//                break;
//            }
//        }
//    }
}
