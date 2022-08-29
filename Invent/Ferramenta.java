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
public class Ferramenta extends Bem{
    private String acao;
    
    public Ferramenta(){
        acao = " ";
    }
    public Ferramenta(String acao, int quantidade){
        super(quantidade);
        this.acao = acao;
    }
    
    @Override
    public double converterParaDolar(double dolarComercial) {
        double valor;
        valor = fator * conversorAcao(acao) * super.getQuantidade();
        return valor;
    }
    
    private double conversorAcao(String acao){
        double conversor = 0;
        switch (acao) {
            case "escudo":
            case "bloqueio":
                //Defesa
                conversor = 0.3;
                break;
            case "desativação":
            case "inativação":
                //Destruição
                conversor = 0.2;
                break;
            case "auto-desativação":
                //Invisibilidade
                conversor = 0.1;
                break;
            default:
                conversor = 0;
                break;
        }
        return conversor;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }
    
    
}
