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
public class Tetraedro extends Tridimensional{
    private double lado; //Triângulo equilátero
    
    public Tetraedro(double lado){
        this.lado = lado;
    }
    //Os cálculos são baseados em tetraedros regulares
    @Override
    public double obterVolume() {
        double volume = (Math.pow(lado, 3)*Math.sqrt(2))/12;
        return volume;
    }

    @Override
    public double obterArea() {
        double area = (Math.pow(lado, 2)*Math.sqrt(3));
        return area;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }
    
    
    
}
