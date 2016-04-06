/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose clavijo
 */
public class Poderes {

    private Barra pod = new Barra();
    private Pelota pelo = new Pelota();
    private List<Integer> multiplos = new ArrayList<Integer>();
    // duaricion del poder
    private int duracion = 0;
    private int duracionPoder = 2;

    public int getDuracionPoder() {
        return duracionPoder;
    }

    public void setDuracionPoder(int duracionPoder) {
        this.duracionPoder = duracionPoder;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public List<Integer> getMultiplos() {
        return multiplos;
    }

    public void setMultiplos(List<Integer> multiplos) {
        this.multiplos = multiplos;
    }

    public Barra getPod() {
        return pod;
    }

    public void setPod(Barra pod) {
        this.pod = pod;
    }

    public Pelota getPelo() {
        return pelo;
    }

    public void setPelo(Pelota pelo) {
        this.pelo = pelo;
    }

    public void achicarBarra() {
        pod.setBarraalto(pod.getBarraalto() / 2);

    }

    public void agrandarBarra() {
        pod.setBarraalto(pod.getBarraalto() * 2);
    }
}
