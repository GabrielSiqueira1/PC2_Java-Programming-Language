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
public class Triangulo extends Bidimensional {
    private double altura;
    private double base;
    
    public Triangulo(double altura, double base){
        this.altura = altura;
        this.base = base;
    }
    
    @Override
    public double obterArea() {
        double area = (base*altura)/2;
        return area;
    }   

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }
    
    
}
