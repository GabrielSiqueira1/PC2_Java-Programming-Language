// Arthur Thimotti e Gabriel Siqueira
package principal;

import java.util.ArrayList;

public class Regras {
    private String respostaAoUsuario;
    
    public Regras(){
        respostaAoUsuario = " ";
    }

    public String respostaAdivinho(Desafiador a, Adivinho b){
        int contadorIgual = 0;
        int contadorDiferente = 0;
        int contadorNumerosDiferentes = 0;
        ArrayList <Integer> numeroDesafiador = new ArrayList<>();
        ArrayList <Integer> numeroAdivinho = new ArrayList<>();
        for(int i = 0; i < 2 ; i++){
            numeroDesafiador.add(a.getValorEscolhido()%10);
            numeroAdivinho.add(b.getChute()%10);
            a.setValorEscolhido(a.getValorEscolhido()/10);
            b.setChute(b.getChute()/10);
        }
        numeroDesafiador.add(a.getValorEscolhido());
        numeroAdivinho.add(b.getChute());
              
        for (int j = 0; j < 3; j++){
            for (int z = 0; z < 3; z++){
                if(numeroDesafiador.get(j) == numeroAdivinho.get(z)){
                    if(z == j){
                        contadorIgual++;
                    }
                    else{
                        contadorDiferente++;
                    }
                }
                else{
                    contadorNumerosDiferentes++;
                }
            }
        }
        if(contadorNumerosDiferentes == 9){
            respostaAoUsuario = ("Bagels (nenhum dos digitos confere)");
        }
        else if(contadorDiferente == 1 && contadorNumerosDiferentes == 8){
            respostaAoUsuario = ("Pico (um dígito confere, mas no lugar errado)");
        }
        else if (contadorDiferente == 2 && contadorNumerosDiferentes == 7){
            respostaAoUsuario = ("Pico Pico (dois dígitos conferem, mas ambos no lugar errado)");
        }
        else if (contadorDiferente == 3 && contadorNumerosDiferentes == 6){
            respostaAoUsuario = ("Pico Pico Pico (três dígitos conferem, mas todos no lugar errado)");
        }
        else if(contadorIgual == 1 && contadorNumerosDiferentes == 8){
            respostaAoUsuario = ("Fermi (um dígito confere e está no lugar certo)");
        }
        else if (contadorIgual == 2 && contadorNumerosDiferentes == 7){
            respostaAoUsuario = ("Fermi Fermi (dois dígitos conferem – no lugar certo)");
        }
        else if (contadorIgual == 3 && contadorNumerosDiferentes == 6){
            respostaAoUsuario = ("Fermi Fermi Fermi (correto – fim de jogo)");
        }
        else if(contadorIgual == 1 && contadorDiferente == 2 && contadorNumerosDiferentes == 6){
            respostaAoUsuario = ("Pico Pico Fermi (dois dígitos conferem – no lugar errado, um dígito confere – no lugar certo)");
        }
        else if (contadorIgual == 2 && contadorNumerosDiferentes == 6 && contadorDiferente == 1){
            respostaAoUsuario = ("Pico Fermi Fermi (dois dígitos conferem, mas um não)");
        }
        else if (contadorIgual == 1 && contadorDiferente == 1 && contadorNumerosDiferentes == 7){
            respostaAoUsuario = ("Pico Fermi (um digito confere, mas não está na posição e outro digito está correto na posição certa)");
        }
        return respostaAoUsuario;
    }    
}