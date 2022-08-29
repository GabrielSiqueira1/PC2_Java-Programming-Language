/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class CaixaDeBrinquedo{
    private ArrayList <Forma> formas;
    private Tridimensional conversor;
    
    public CaixaDeBrinquedo(){
        formas = new ArrayList<>();  //forminha.getClass().getSimpleName().equals("Circulo") || forminha.getClass().getSimpleName().equals("Triangulo") || forminha.getClass().getSimpleName().equals("Quadrado")
    }
    public void adcionarFormas(Forma forminha){
        formas.add(forminha);
        if((forminha.getClass().getSuperclass().getSimpleName()).equals("Bidimensional")){
            System.out.println("Eu sou um "+forminha.getClass().getSimpleName()+" e tenho área igual a: "+forminha.obterArea());
        }
        else if((forminha.getClass().getSuperclass().getSimpleName()).equals("Tridimensional")){
            conversor = ((Tridimensional)forminha);
            System.out.println("Eu sou um "+forminha.getClass().getSimpleName()+" e tenho área igual a: "+forminha.obterArea()+" e volume igual a: "+conversor.obterVolume());
        }
    }
}
