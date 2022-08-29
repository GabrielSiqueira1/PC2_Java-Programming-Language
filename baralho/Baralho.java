package principal;

import java.security.SecureRandom;

/**
 *
 * @author Gabriel
 */
public class Baralho {
    private final Carta[] baralho; //final está neste dois casos pois são quantidades que não serão alteradas, nesse jogo
    private final String[] naipes;
    private SecureRandom aleatoriedade;

    public Baralho() {
        this.naipes = new String[]{"Ouros","Paus","Copas","Espadas"};
        int i,count = 0;
        baralho = new Carta[52];
        for (String naipe: naipes){
            for (i=1;i<14;i++){
                baralho[count] = new Carta(naipe,i);
                count++;
            }
        }
    }
    public int embaralhar(){ //Embaralha as 52 posições do vetor
        this.aleatoriedade = new SecureRandom();
        int j,localizacao = 0;
        Carta receptor_de_valor;
        for (j=0;j<52;j++){
            localizacao = aleatoriedade.nextInt(51);
            receptor_de_valor = baralho[j];
            baralho[j] = baralho [localizacao];
            baralho [localizacao] = receptor_de_valor;
        }
        return 1;
    }
    public Carta[] distribuir(int quant){ //distribuição de cartas, dependendente da chamada pelo Jogo.java
        int z;
        Carta[] distribuicao;
        
        distribuicao = new Carta[quant];
        
        for (z=0;z<distribuicao.length;z++){
            distribuicao[z] = baralho[z];
            baralho[z] = null; //Retirar as cartas do início colocando o endereço vazio
        }
        
        for (z=0;z<baralho.length;z++){ //Empurra o baralho quantidades quant para frente
            if(z<baralho.length-quant-1){
                baralho[z] = baralho[z+quant];
            }
            else{
                baralho[z] = null; //Retirar as cartas do final colocando o endereço vazio
            }            
        }
        return distribuicao; 
    }
}
