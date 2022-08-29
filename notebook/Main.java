/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda;

import java.util.Scanner;

/**
 *
 * @author Gabriel
 */
public class Main {
    private Agenda agenda;
    private Contatos contato, copia;
    private String buffer;
    
    public static void main(String[] args) {
        int verificador;
        Scanner input = new Scanner(System.in);
        Agenda agenda = new Agenda();
        Contatos copia = new Contatos();
        String buffer = new String();
        
        do{
            System.out.println("Selecione a opção desejada:");
            System.out.println("(1) - Insere um novo contato na agenda");
            System.out.println("(2) - Exibe o número total de contatos da agenda");
            System.out.println("(3) - Exibe um contato (pesquisa pelo nome)");
            System.out.println("(4) - Exclui um contato (pesquisa pelo nome)");
            System.out.println("(5) - Exibe todos os contatos da agenda");
            System.out.println("(0) - Sair");
            verificador = input.nextInt();
            buffer = input.nextLine();
            if(verificador != 0){
                switch (verificador){
                    case 1: System.out.println("Insira o nome, telefone e e-mail:");
                    Contatos contato = new Contatos();
                    contato.setNome(input.nextLine());
                    contato.setTelefone(input.nextLine());
                    contato.setEmail(input.nextLine());
                    agenda.inserirContato(contato); break;
                    case 2: System.out.println("O número total de contatos na agenda é: "+agenda.getSize()); break;
                    case 3: System.out.println("Qual o nome do contato que você deseja achar?");copia.setNome(input.nextLine());agenda.pesquisarContatos(copia.getNome()); break;
                    case 4: System.out.println("Qual o nome do contato que você deseja achar?");copia.setNome(input.nextLine()); 
                    if (agenda.excluirContato(copia.getNome()) == true){
                        System.out.println("Contato excluido com sucesso!");
                    }
                    else{
                        System.out.println("Erro, não é possível concluir a ação!");
                    }; break;
                    case 5: agenda.listarContatos(); break;
                    default: System.out.println("Operação impossível!");
                }
            }
        }while(verificador!=0);
    }
}
