/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

/**
 *
 * @author Gabriel
 */
public class Esfera extends Tridimensional{
    private double raio;
    
    public Esfera(double raio){
        this.raio = raio;
    }

    @Override
    public double obterVolume() {
        double volume = 4/3*Math.PI*Math.pow(raio, 3);
        return volume;
    }

    @Override
    public double obterArea() {
        double area = 4*Math.PI*Math.pow(raio, 2);
        return area;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }
    
    
    
}
