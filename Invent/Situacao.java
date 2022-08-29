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
public class Situacao {
    private ArrayList <Bem> bens;
    
    public Situacao(){
        bens = new ArrayList<>();
    }
    public void adcionarBens(Bem bem){
        bens.add(bem);
    }
    public double calcularTotalInventario(){
        //Cotação dia 25/02/2021 R$5.51
        double total = 0;
        for (Bem bem: bens){
            total = total + bem.converterParaDolar(5.51);
        }
        return total;
    }
}
