package principal;

/**
 *
 * @author Gabriel
 */
public class Jogador {
    private Carta[] mao;
   
    public void receberCartas(Carta[] cartas){
        int i;
        mao = cartas;
        System.out.println("Mão do jogador");
        for (i=0;i<mao.length;i++){ //Exibe a mão dos dois jogadores
            System.out.println("{"+mao[i].getValor()+" de "+mao[i].getNaipe()+"}");
        }
    }
    
    public Carta jogar(){ //Retorna a maior carta da mão do jogador
        int j;
        Carta auxiliar = mao[0];
        for (j=0;j<mao.length;j++){
            if(auxiliar.getValor()<mao[j].getValor()){
                auxiliar = mao[j];
            }
        }
        return auxiliar;
    }
}
