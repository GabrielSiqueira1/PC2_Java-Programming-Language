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
public class Cenario extends Bem {
    private int tamanho;
    private int nivel;
    
    public Cenario(){
        tamanho = 0;
        nivel = 0;
    }
    public Cenario(int quantidade, int tamanho, int nivel){
        super(quantidade);
        this.tamanho = tamanho;
        this.nivel = nivel;
    }

    @Override
    public double converterParaDolar(double dolarComercial) {
        double valor;
        valor = super.getQuantidade() * tamanho * nivel * fator;
        return valor;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    
}
