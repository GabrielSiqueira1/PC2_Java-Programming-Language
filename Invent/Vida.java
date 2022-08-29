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
public class Vida extends Bem{
    private String validaAte;
    
    public Vida(){
       validaAte = " ";
    }
    public Vida(int quantidade, String validaAte){
        super(quantidade);
        this.validaAte = validaAte;
    }
    
    @Override
    public double converterParaDolar(double dolarComercial)     {
        double valor;
        valor = dolarComercial * 0.2 * super.getQuantidade() * converterValidade(validaAte);
        return valor;
    }
    
    private double converterValidade(String validacao){
        //Considerando o dia de 25/02/2021
        double conversor = 0;
        String[] comparadores = validacao.split("/");
        Integer[] numeros = new Integer[3];
        for (int i = 0; i<comparadores.length; i++){
            numeros[i] = Integer.parseInt(comparadores[i]);
        }
        if (numeros[2] == 2021){
            if(numeros[1] == 2){
                if(numeros[0] > 25){
                    conversor = numeros[0]-25;
                }
                else
                    conversor = 0;
            }
            else if (numeros[1] > 2){
                conversor = (numeros[1]-2)*30+numeros[0]-25;
            }
            else
                conversor = 0;
        }
        else if(numeros[2] > 2021){
            conversor = 360+(numeros[1]*30+numeros[0]-85);
        }
        else
            conversor = 0;
        return conversor;
    }

    public String getValidaAte() {
        return validaAte;
    }

    public void setValidaAte(String validaAte) {
        this.validaAte = validaAte;
    }
    
    
}
