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
public class Moeda extends Bem{
    private int nivel;

    public Moeda(){
        nivel = 0;
    }
    public Moeda(int quantidade, int nivel){
        super(quantidade);
        this.nivel = nivel;
    }
    
    @Override
    public double converterParaDolar(double dolarComercial) {
        double valor;
        valor = dolarComercial * fator * nivel * super.getQuantidade();
        return valor;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    
}
