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
public class Recurso extends Bem{
    private int tipo;
    
    public Recurso(){
        tipo = 0;
    }
    public Recurso(int quantidade, int tipo){
        super(quantidade);
    }

    @Override
    public double converterParaDolar(double dolarComercial) {
        double valor;
        valor = dolarComercial * fator * tipo * super.getQuantidade();
        return valor;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    
}
