/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

/**
 *
 * @author Gabriel
 */
public class Inventario {
    private static Situacao pessoa1;
    private static Situacao pessoa2;
    public static void main(String[] args) {
        Bem geral;
        pessoa1 = new Situacao();
        pessoa2 = new Situacao();
        
        geral = new Seguidor(1000,58000); //quantidade, fatorImpacto
        pessoa1.adcionarBens(geral);
        geral = new Moeda(200,3); //quantidade, nível
        pessoa1.adcionarBens(geral);
        geral = new Vida(300,"28/02/2021"); //quantidade, data
        pessoa1.adcionarBens(geral);
        geral = new Recurso(31,1); //quantidade, tipo
        pessoa1.adcionarBens(geral);
        geral = new Ferramenta("escudo",20); //ação, quantidade
        pessoa1.adcionarBens(geral);
        geral = new Cenario(100,50,30); //quantidade, tamanho, nível
        pessoa1.adcionarBens(geral);
        
        System.out.println("O valor total da primeira pessoa é: "+pessoa1.calcularTotalInventario()+" dolares");
     
        geral = new Seguidor(598,1023);
        pessoa2.adcionarBens(geral);
        geral = new Moeda(50,1);
        pessoa2.adcionarBens(geral);
        geral = new Vida(300,"31/03/2022");
        pessoa2.adcionarBens(geral);
        geral = new Recurso(8,500);
        pessoa2.adcionarBens(geral);
        geral = new Ferramenta("desativação",90);
        pessoa2.adcionarBens(geral);
        geral = new Cenario(200,10,100);
        pessoa2.adcionarBens(geral);
        
        System.out.println("O valor total da segunda pessoa é: "+pessoa2.calcularTotalInventario()+" dolares");
    }
}
