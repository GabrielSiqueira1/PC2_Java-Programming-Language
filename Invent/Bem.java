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
public abstract class Bem {
    private int quantidade;
    protected static double fator = 0.05;
    
    public Bem(){
        quantidade = 0;
    }
    public Bem(int quantidade){
       this.quantidade = quantidade;
    }
    public abstract double converterParaDolar(double dolarComercial);
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
