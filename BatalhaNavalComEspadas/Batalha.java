// Grupo: Gabriel Siqueira Silva
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Batalha {
    public static void main(String[] args) {
        // Suportes
        Scanner input = new Scanner(System.in);
        HashMap<Integer, Integer> repetidas1 = new HashMap<>();
        HashMap<Integer, Integer> repetidas2 = new HashMap<>();
        HashMap<Espada, Jogada> rastreamento1 = new HashMap<>();
        HashMap<Espada, Jogada> rastreamento2 = new HashMap<>();
        
        // Pontuação inicial
        int pts1 = 0; 
        int pts2 = 0;
        
        // Inicialização das espadas, descrição e valores
        Espada espadaOuro = new Espada("Espada de Ouro", 50);
        Espada espadaBronze = new Espada("Espada de Bronze", 40);
        Espada espadaPlatina = new Espada("Espada de Platina", 30);
        Espada espadaGelo = new Espada("Espada de Gelo", 20);
        Espada espadaAlum = new Espada("Espada de Alumínio", 10);
        Espada espadaMadeira = new Espada("Espada de Madeira", 5);
        
        // Facilita na distruição de espadas na matriz disposta
        Espada[] arsenal = {espadaOuro, espadaBronze, espadaPlatina, espadaGelo, espadaAlum, espadaMadeira};
        
        // Inicialização dos jogadores, um tabuleiro e as jogadas
        Jogador jogador1 = new Jogador();
        Jogador jogador2 = new Jogador();
        Jogada analisador = new Jogada();
        System.out.println("Bem-vindo(a)! Esta é uma batalha naval com espadas!");
        // Inicialização do tabuleiro dos jogadores
        for (int i = 0; i<6; i++){
            int linha, conversor;
            String coluna;
            System.out.println("Ao jogador 1: Deseja adicionar qual posição à "+arsenal[i].getDesc()+"?");
            System.out.println("Qual linha?");
            linha = input.nextInt();
            while(linha <= 0 || linha >= 14){ //Impede a utilização de um sistema de matrizes maior do que o determinado
                System.out.println("Valor incompatível, digite outro no intervalo fechado de 1 a 13");
                linha = input.nextInt();
            }
            System.out.println("Qual coluna?");
            try{ // Utilizado para as palavras após a letra M, que caso sejam digitadas impedirão o funcionamento da lógica, dessa forma, o sistema se encerra
                coluna = input.next();
                conversor = analisador.eColuna(coluna); // Verifica se a String abrange os limites determinados
                while (conversor <= 0 || conversor >= 14) { // Loop para digitação de inteiros e strings limitadas
                        System.out.println("Valor incompatível, digite outro no intervalo fechado de 1 a 13, ou digite um valor entre A e M");
                        coluna = input.next();
                        conversor = analisador.eColuna(coluna);
                    }
                Jogada j1 = new Jogada(linha,conversor);
                while(repetidas1.containsValue(j1.getColuna()) && repetidas1.containsKey(j1.getLinha())){ // Verifica ocupação, caso já exista uma espada especial no lugar
                    System.out.println("Ao jogador 1: Deseja adicionar qual posição à " + arsenal[i].getDesc() + "?");
                    System.out.println("Qual linha?");
                    linha = input.nextInt();
                    while (linha <= 0 || linha >= 14) {
                        System.out.println("Valor incompatível, digite outro no intervalo fechado de 1 a 13");
                        linha = input.nextInt();
                    }
                    System.out.println("Qual coluna?");
                    coluna = input.next();
                    conversor = analisador.eColuna(coluna);
                    j1 = new Jogada(linha, conversor);
                }
                repetidas1.put(j1.getLinha(),j1.getColuna()); // Adiciona a posição estabelecida a fim de não haver repetições de espadas em uma mesma posição
                rastreamento1.put(arsenal[i], j1);
            }
            catch (InvalidPositionException ex){
                System.out.println("Essa posição é inexistente... Terminando.");
                System.exit(0); // Termina a aplicação
            }
        }
        jogador1.addPosicoesTabuleiro(rastreamento1); // Adiciona a posição no tabuleiro
        
        for (int i = 0; i<6; i++){
            int linha, conversor;
            String coluna;
            System.out.println("Ao jogador 2: Deseja adicionar qual posição à "+arsenal[i].getDesc()+"?");
            System.out.println("Qual linha?");
            linha = input.nextInt();
            while(linha <= 0 || linha >= 14){
                System.out.println("Valor incompatível, digite outro no intervalo fechado de 1 a 13");
                linha = input.nextInt();
            }
            System.out.println("Qual coluna?");
            try{
                coluna = input.next();
                conversor = analisador.eColuna(coluna);
                while (conversor <= 0 || conversor >= 14) {
                        System.out.println("Valor incompatível, digite outro no intervalo fechado de 1 a 13, ou digite um valor entre A e M");
                        coluna = input.next();
                        conversor = analisador.eColuna(coluna);
                    }
                Jogada j2 = new Jogada(linha,conversor);
                while(repetidas2.containsValue(j2.getColuna()) && repetidas2.containsKey(j2.getLinha())){
                    System.out.println("Ao jogador 2: Deseja adicionar qual posição à " + arsenal[i].getDesc() + "?");
                    System.out.println("Qual linha?");
                    linha = input.nextInt();
                    while (linha <= 0 || linha >= 14) {
                        System.out.println("Valor incompatível, digite outro no intervalo fechado de 1 a 13");
                        linha = input.nextInt();
                    }
                    System.out.println("Qual coluna?");
                    coluna = input.next();
                    conversor = analisador.eColuna(coluna);
                    j2 = new Jogada(linha, conversor);
                }
                repetidas2.put(j2.getLinha(),j2.getColuna());
                rastreamento2.put(arsenal[i], j2);
            }
            catch (InvalidPositionException ex){
                System.out.println("Essa posição é inexistente... Terminando.");
                System.exit(0);
            }
        }
        jogador2.addPosicoesTabuleiro(rastreamento2);
        
        // Gameplay
        // O jogador 1 é o primeiro, ou seja, ele deve "chutar" linha e coluna
        while(pts1 != 155 && pts2 != 155){ // Loop até alguém atingir esse valor, ou seja, terá que descobrir todas as espadas
            int linhaTentativa, conversor; 
            String colunaTentativa;
            Jogada jogada1, jogada2;
            System.out.println("Jogador 1,faça sua jogada!");
            System.out.println("Qual linha?");
            linhaTentativa = input.nextInt();
            while(linhaTentativa <= 0 || linhaTentativa >= 14){
                System.out.println("Valor incompatível, digite outro no intervalo fechado de 1 a 13");
                linhaTentativa = input.nextInt();
            }
            System.out.println("Qual coluna?");
            try{
                colunaTentativa = input.next();
                conversor = analisador.eColuna(colunaTentativa);
                while (conversor <= 0 || conversor >= 14) {
                        System.out.println("Valor incompatível, digite outro no intervalo fechado de 1 a 13, ou digite um valor entre A e M");
                        colunaTentativa = input.next();
                        conversor = analisador.eColuna(colunaTentativa);
                    }
                jogada1 = new Jogada(linhaTentativa,conversor);
                jogador1.addJogadas(jogada1);
                System.out.println("O chute foi realizado na coluna: " + jogada1.conversor(jogada1.getColuna()) + " e na linha: " + jogada1.getLinha());
                System.out.println("A espada encontrada era uma: " + jogador2.getMeuTabuleiro().obterDescEspadaPosicionada(jogada1) + " e valia: " + jogador2.getMeuTabuleiro().obterValorEspadaPosicionada(jogada1));
                if (jogador2.getMeuTabuleiro().obterJogadasPreenchidas(jogada1)) {
                    jogador1.setPontos(jogador2.getMeuTabuleiro().obterValorEspadaPosicionada(jogada1));
                    pts1 = pts1 + jogador1.getPontos();
                    jogador2.getMeuTabuleiro().removerEspadaEncontrada(jogada1);
                }
            }
            catch (InvalidPositionException ex){
                System.out.println("Essa posição é inexistente... Terminando.");
                System.exit(0);
            }
            
            System.out.println("Jogador 2, faça sua jogada!");
            System.out.println("Qual linha?");
            linhaTentativa = input.nextInt();
            while(linhaTentativa <= 0 || linhaTentativa >= 14){
                System.out.println("Valor incompatível, digite outro no intervalo fechado de 1 a 13");
                linhaTentativa = input.nextInt();
            }
            System.out.println("Qual coluna?");
            try{
                colunaTentativa = input.next();
                conversor = analisador.eColuna(colunaTentativa);
                while (conversor <= 0 || conversor >= 14) {
                        System.out.println("Valor incompatível, digite outro no intervalo fechado de 1 a 13, ou digite um valor entre A e M");
                        colunaTentativa = input.next();
                        conversor = analisador.eColuna(colunaTentativa);
                    }
                jogada2 = new Jogada(linhaTentativa, conversor);
                jogador2.addJogadas(jogada2);
                System.out.println("O chute foi realizado na coluna: " + jogada2.conversor(jogada2.getColuna()) + " e na linha: " + jogada2.getLinha()); // Exibe na tela o que o jogador adquiriu
                System.out.println("A espada encontrada era uma: " + jogador1.getMeuTabuleiro().obterDescEspadaPosicionada(jogada2) + " e valia: " + jogador1.getMeuTabuleiro().obterValorEspadaPosicionada(jogada2));
                if (jogador1.getMeuTabuleiro().obterJogadasPreenchidas(jogada2)) { // Sempre irá existir uma espada, então devemos contabilizar o seu valor
                    jogador2.setPontos(jogador1.getMeuTabuleiro().obterValorEspadaPosicionada(jogada2)); // Obtenção dos pontos
                    pts2 = pts2 + jogador2.getPontos(); // Atualização da pontuação
                    jogador1.getMeuTabuleiro().removerEspadaEncontrada(jogada2); // Ocorre a substituição por uma espada sem valor, como se estivesse vazio
                }
            }
            catch (InvalidPositionException ex){
                System.out.println("Essa posição é inexistente... Terminando.");
                System.exit(0);
            }
        }
        if(pts1 == 155){
            System.out.println("O jogador 1 ganhou chutando os seguintes valores: ");
            ArrayList<Jogada> chutes = jogador1.getMinhasJogadas();
            for(Jogada c: chutes){
                System.out.println("Linha: "+c.getLinha()+", Coluna: "+c.getColuna());
            }
        }
        else if(pts2 == 155){ // Exibe o vencedor e todas as suas tentativas em um array de tentativas
            System.out.println("O jogador 2 ganhou chutando os seguintes valores: ");
            ArrayList<Jogada> chutes = jogador2.getMinhasJogadas();
            for (Jogada c : chutes) {
                System.out.println("Linha: " + c.getLinha() + ", Coluna: " + c.getColuna());
            }
        }
    }
}