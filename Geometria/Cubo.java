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
public class Cubo extends Tridimensional{
    private double lado; 
    
    public Cubo(double lado){
        this.lado = lado;
    }

    @Override
    public double obterVolume() {
        double volume = Math.pow(lado, 3);
        return volume;
    }

    @Override
    public double obterArea() {
        double area = 6*Math.pow(lado, 2);
        return area;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }
    
    
    
}
