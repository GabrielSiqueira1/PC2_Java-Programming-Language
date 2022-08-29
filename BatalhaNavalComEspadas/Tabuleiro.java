// Grupo: Gabriel Siqueira Silva
package model;

public class Tabuleiro { // Tabuleiro 13x13
    private Espada[][] tabuleiro;
    private Espada espadaSimples;

    public Tabuleiro() {
        espadaSimples = new Espada("Espada simples, não é o que você procura", 0);
        tabuleiro = new Espada[13][13];
        for (int i=0; i<13; i++){
            for (int j=0; j<13; j++){
                tabuleiro[i][j] = espadaSimples; // Para evitar o NullPointer, inicia-se com um certo valor que não irá alterar a lógica... nesse caso uma espada com valor zerado
            }
        }
    }

    public Espada[][] getTabuleiro() {
        return tabuleiro;
    }
    
    // O -1 funciona como um adaptador pois os vetores se iniciam em 0 e a tabela inicia em 1
    // Portanto se um jogador escolhe a posição 1, ela equivale a 0
    
    // Verifica o valor da espada encontrada
    public int obterValorEspadaPosicionada(Jogada jogada){
        return tabuleiro[jogada.getLinha()-1][jogada.getColuna()-1].getValor();
    }
    
    // Verifica a descrição da espada encontrada
    public String obterDescEspadaPosicionada(Jogada jogada){
        return tabuleiro[jogada.getLinha()-1][jogada.getColuna()-1].getDesc();
    }
    
    // Ajuda a verificar se uma posição já está ocupada por uma espada especial
    public boolean obterJogadasPreenchidas(Jogada jogada){
        return (tabuleiro[jogada.getLinha()-1][jogada.getColuna()-1] != espadaSimples);
    }

    // Posiciona a espada
    public void setTabuleiro(Espada espada, Jogada jogada) {
        tabuleiro[jogada.getLinha()-1][jogada.getColuna()-1] = espada;
    }
    
    // Troca a espada especial por uma com valor zerado
    public void removerEspadaEncontrada(Jogada jogada){
        tabuleiro[jogada.getLinha()-1][jogada.getColuna()-1] = espadaSimples;
    }
}
