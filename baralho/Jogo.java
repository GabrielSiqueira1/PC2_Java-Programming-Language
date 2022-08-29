package principal;

import java.util.Scanner;

/**
 *
 * @author Gabriel
 */
public class Jogo {
    private static Baralho baralho;
    private static Jogador player1, player2;

    public static void main(String[] args) {
        int logica = 0;
        System.out.println("Bem-Vindos, esse jogo não tem volta, assentem-se...");
        while (logica == 0){ //Loop infinito, mentira rs, loop até um jogador ganhar
            Carta maior1,maior2;
            baralho = new Baralho();
            System.out.println("O Dealer está embaralhando o baralho...");
            baralho.embaralhar();
            System.out.println("Os jogadores se assentaram...");
            player1 = new Jogador();
            player2 = new Jogador();
            
            Scanner input = new Scanner(System.in);
            System.out.println("Quantas cartas vocês querem que sejam distribuidas para cada um dos jogadores?");
            int quantidade = input.nextInt();
            
            System.out.println("O Dealer vai distribuir as cartas...");
         
            player1.receberCartas(baralho.distribuir(quantidade));
            player2.receberCartas(baralho.distribuir(quantidade));
            
            System.out.println("O Dealer distribuiu "+quantidade+" cartas para cada jogador");

            System.out.println("Por favor não fiquem tensos, sua vida está em jogo, JOGUE SUA MAIOR CARTA!");

            maior1 = player1.jogar();
            maior2 = player2.jogar();

            switch (maior1.compararValor(maior2)) {
                case 1:
                    System.out.println("O jogador 1 coloca na mesa sua carta... Um "+maior1.getValor()+" de "+maior1.getNaipe()+" e já sem esperanças o jogador 2 lança sua carta de "+maior2.getValor()+" de "+maior2.getNaipe());
                    System.out.println("O jogador 1 ganhou!");
                    logica++;
                    break;
                case -1:
                    System.out.println("O jogador 1 coloca na mesa sua carta... Um "+maior1.getValor()+" de "+maior1.getNaipe()+" com a convícção que já venceu e porém o jogador 2 surpreende com um "+maior2.getValor()+" de "+maior2.getNaipe());
                    System.out.println("O jogador 2 ganhou!");
                    logica++;
                    break;
                default:
                    System.out.println("A batalha está tensa, ambos tem o mesmo valor de carta, um "+maior1.getValor()+", então essa competição será decidida no poder dos naipes!");
                    if("Ouros".equals(maior1.getNaipe())){
                        System.out.println("O jogador 1 demonstrou ter sorte por isso é o vencedor com o seu "+maior1.getValor()+" de "+maior1.getNaipe()+"!");
                        logica++;
                    }
                    else if("Ouros".equals(maior2.getNaipe())){
                        System.out.println("O jogador 2 se mostrou mais confiante e por isso é o vencedor dessa partida com o seu "+maior2.getValor()+" de "+maior2.getNaipe()+"!");
                        logica++;
                    }
                    else{
                        System.out.println("UM EMPATE!! Vocês querem jogar novamente? >:)... Não importa");
                    }   break;
            }
        } 
    }
}
