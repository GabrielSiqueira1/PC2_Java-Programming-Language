// Arthur Thimotti e Gabriel Siqueira
package principal;

import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {
        int controlador;
        int analisador;
        int contador = 0;
        int vitoria = 0;
        ArrayList <Integer> tentativas = new ArrayList<>();
        ArrayList <Integer> verificacao = new ArrayList<>();
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Digite um número a ser advinhado (Desafiador): ");
        Desafiador player1 = new Desafiador(scanner1.nextInt());
        controlador = player1.getValorEscolhido();
        analisador = player1.getValorEscolhido();
        if(player1.getValorEscolhido() > 1000 || player1.getValorEscolhido() < 100){
            System.out.println("Valor inválido!");
            vitoria = 1;
        }
        else{
            for (int i = 0; i<3 ; i++){
                verificacao.add(analisador%10);
                analisador = analisador/10;
            }
            analisador = 0;
            for (int j = 0; j<3; j++){
                for (int z = 0; z<3; z++){
                    if(verificacao.get(z) == verificacao.get(j)){
                        analisador++;
                    }
                }
            }
            if (analisador > 3){
                System.out.println("Valor inválido!");
                vitoria = 1;
            }
        }
        do{
            if(vitoria != 1){
                String resposta;
                Regras rodada = new Regras();
                System.out.println("Digite sua tentativa (Adivinho): ");
                Scanner scanner2 = new Scanner(System.in);
                Adivinho player2 = new Adivinho(scanner2.nextInt());

                if(player2.getChute() > 1000 || player2.getChute() <100){
                    System.out.println("Valor inválido! Escreva outro por favor... ");
                }
                else{
                    tentativas.add(player2.getChute());

                    resposta = rodada.respostaAdivinho(player1, player2);
                    player1.setValorEscolhido(controlador);
                    contador++;
                    System.out.println("E foi sua "+contador+"ª tentativa(s)");
                    System.out.println("E a resposta é: "+resposta);
                    if("Fermi Fermi Fermi (correto – fim de jogo)".equals(resposta)){
                        System.out.println("Foram necessárias "+contador+" rodadas e foram utilizados os valores: ");
                        for (Integer valores : tentativas){
                            System.out.println(valores);
                        }
                        vitoria = 1;
                    }
                }
            } 
        }while(vitoria != 1);
        
        System.out.println("Obrigado por jogar!");
        
    }
}