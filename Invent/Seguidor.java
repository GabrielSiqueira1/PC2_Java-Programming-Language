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
public class Seguidor extends Bem {
    private int fatorImpacto;
    
    public Seguidor(){
        fatorImpacto = 0;
    }
    public Seguidor(int quantidade, int fatorImpacto){
        super(quantidade);
        this.fatorImpacto = fatorImpacto;
    }

    @Override
    public double converterParaDolar(double dolarComercial) {
        double valor;
        valor = dolarComercial * fator * fatorImpacto * super.getQuantidade();
        return valor;
    }

    public int getFatorImpacto() {
        return fatorImpacto;
    }

    public void setFatorImpacto(int fatorImpacto) {
        this.fatorImpacto = fatorImpacto;
    }
    
    
}
