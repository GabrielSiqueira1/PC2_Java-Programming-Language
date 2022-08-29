// Grupo: Gabriel Siqueira Silva
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Jogador {
    private Tabuleiro meuTabuleiro;
    private ArrayList<Jogada> minhasJogadas;
    private int pontos;

    public Jogador() {
        meuTabuleiro = new Tabuleiro(); // Inicia com espadas já posicionadas, essas espadas não tem valor
        minhasJogadas = new ArrayList<>();
        pontos = 0; // Recebe a pontuação de cada espada
    }
    
    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
    
    // Adiciona ao tabuleiro, as espadas especiais 
    public void addPosicoesTabuleiro(HashMap<Espada,Jogada> tabuleiro){
        Set<Espada> sword = tabuleiro.keySet();
        for(Espada sd: sword){
            meuTabuleiro.setTabuleiro(sd, tabuleiro.get(sd));
        }
    }
    
    // Adiciona as tentativas para serem exibidas no final
    public void addJogadas(Jogada jogada){
        minhasJogadas.add(jogada);
    }

    public Tabuleiro getMeuTabuleiro() {
        return meuTabuleiro;
    }

    public void setMeuTabuleiro(Tabuleiro meuTabuleiro) {
        this.meuTabuleiro = meuTabuleiro;
    }

    public ArrayList<Jogada> getMinhasJogadas() {
        return minhasJogadas;
    }

    public void setMinhasJogadas(ArrayList<Jogada> minhasJogadas) {
        this.minhasJogadas = minhasJogadas;
    }
}
