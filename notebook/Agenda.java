/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda;

import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class Agenda {
    private ArrayList <Contatos> id;
    public Agenda(){
        id = new ArrayList <>();
    }
    public void inserirContato(Contatos contato){
        id.add(contato);
    }
    public int getSize(){
        int contador = 0;
        for(Contatos c:id){
            contador++;
        }
        return contador;
    }
    public void pesquisarContatos(String nome){
        int i;
        for (i=0;i<id.size();i++){
            if(nome.equals(id.get(i).getNome())){
                System.out.println("----------------------");
                System.out.println("Nome: "+id.get(i).getNome());
                System.out.println("Telefone: "+id.get(i).getTelefone());
                System.out.println("Email: "+id.get(i).getEmail());
                System.out.println("----------------------");
            }
        }
    }
    public boolean excluirContato(String nome){
        int i;
        for (i=0;i<id.size();i++){
            if(nome.equals(id.get(i).getNome())){
                id.remove(i);
                return true;
            }
        }
        return false;
    }
    public void listarContatos(){
        int i;
        for (i=0;i<id.size();i++){
            pesquisarContatos(id.get(i).getNome());
        }
    }
}
