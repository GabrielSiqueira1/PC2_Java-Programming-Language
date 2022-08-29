/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.Scanner;

/**
 *
 * @author Gabriel
 */
public class CallCenter {
    static SuporteTecnico sup;
    static Interpretadora inter;
    static String buffer;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String correspondência;
        System.out.println("Bem-vindo ao sistema de Suporte Técnico");
        correspondência = new String();
        do{
            System.out.println("Pressione <enter> para continuar ou digite 'sair' para sair do sistema.");
            correspondência = input.nextLine();
            if(!"sair".equals(correspondência)){
                sup = new SuporteTecnico();
                inter = new Interpretadora();
                System.out.println("Descreva seu problema de maneira objetiva: ");
                
                String problema = new String();
                problema = input.nextLine();
        
                System.out.println(sup.buscaSolucao(inter.preenchimento(problema)));
            }
        }while(!"sair".equals(correspondência));
    }
}
