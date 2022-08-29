package principal; /*Pacote que armazenará todos os arquivos .java 
que utilizaremos neste projeto
*/

/**
 *
 * @author Gabriel
 */
public class Carta {
    /*
    private - Tem por objetivo tornar a variável acessível apenas na class 
    Carta, sem um metodo public, outro arquivo .java, como é o caso do 
    Teste.java, não terá acesso a essas variáveis

    String - por estar com letra inicial maiúscula, esta é classificada como 
    class
    */
    private int valor; 
    private String naipe;
    
    public Carta(){
        valor = 0; //Inicialização de um inteiro
        naipe = " "; //Inicialização de um string
    }
    
    public Carta(String naipe, int valor){
        /*
        this serve para referenciar o objeto da classe que está sendo executado. 
        O valor que this.valor recebe é passado para variável privada
        Obs: Evita sobrecarga de nome para as atribuições
        */
        this.valor = valor; 
        this.naipe = naipe;
    }
    
    public int compararValor(Carta carta){
        /*
        Método que comparará o valor das cartas dispostas. Retornará 1 caso
        this.valor tenha um valor maior do que a carta passada como parâmetro.
        Esse this refere-se a carta que está utilizando a notação de ponto, dessa
        forma, cartaA.compararValor, tem como this a cartaA e suas informações e
        a carta passada como parâmetro é a cartaB.
        */
        if(this.valor > carta.getValor()){
            return 1;
        }
        else if(this.valor < carta.getValor()){
            return -1;
        }
        return 0; /*Não há necessidade de realizar uma condição para valores iguais
        já que a IDE sempre alerta para um retono, então a condição igual funciona
        como um default na lógica do switch*/
    }
    
    public int compararNaipe(Carta carta){
        /*
        Classes em java são projetos de um objeto, dessa forma, para uma comparação
        entre classes, ocorre uma comparação em sua referência, ou seja, para onde
        a classe está apontando. Isso é necessário neste momento pois String é uma
        classe
        */
        if(this.naipe.equals(carta.getNaipe())){
            return 1;
        }
        return 0;
    }
    
    /*
    Funções gets e sets: São funções públicas que auxiliam na acesso e edição,
    respectivamentedos atributos fora da classe principal, pois, neste caso, 
    estas estão privadas
    */
    public int getValor(){
        return valor;
    }
    
    public void setValor(int valor){
        if(valor >= 14){ /*Evita que números maiores que 13 causem erros nos 
valores das cartas*/
            this.valor = valor%14;
        }
        else if (valor == 0){
            System.out.println("Valor inválido!");
        }
        this.valor = valor;
    }
    
    public String getNaipe(){
        return naipe;
    }
    
    public void setNaipe(String naipe){
        this.naipe = naipe;
    }
}