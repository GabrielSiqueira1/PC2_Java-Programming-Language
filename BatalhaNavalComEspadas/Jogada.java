// Grupo: Gabriel Siqueira Silva
package model;

public class Jogada {
    private final String[] nomeColuna = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M"};
    private int linha;
    private int coluna;

    public Jogada() {
        this.linha = 0;
        this.coluna = 0;
    }
    
    public Jogada(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }
    
    public String conversor(int col) throws InvalidPositionException{
        if(col>=14 || col<=0)
            throw new InvalidPositionException();
        else
            return nomeColuna[col-1];
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }
    
    public int eColuna(String verificacaoColuna) throws InvalidPositionException{
        int determinante;
        for (int i = 0; i<nomeColuna.length; i++){
            if(nomeColuna[i].equals(verificacaoColuna)){
                return i+1;
            }
        }
        try{
            return determinante = Integer.parseInt(verificacaoColuna);
        }
        catch (NumberFormatException ex){ // Caso seja uma palavra ou letra que não corresponda ao padrão
            throw new InvalidPositionException();
        }
    }
    
}
