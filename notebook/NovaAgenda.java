/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Map;

import java.util.HashMap;

/**
 *
 * @author Gabriel
 */
public class NovaAgenda {
    private HashMap <String,Contatos> id;
    public NovaAgenda(){
        id = new HashMap <>();
    }
    public void inserirContato(Contatos contato){
        id.put(contato.getNome(),contato);
    }
    public int getSize(){
        return id.size();
    }
    public void pesquisarContatos(String nome){
        System.out.println("----------------------");
        System.out.println(id.get(nome));
        System.out.println("----------------------");
    }
    public boolean excluirContato(String nome){
        id.remove(nome);
        if(id.get(nome) == null){
            return true;
        }
        return false;
    }
    public void listarContatos(){
        for (String key : id.keySet()) {
            Contatos value = id.get(key);
            System.out.println(key + " = " + value.getEmail() +","+ value.getTelefone());
       }
    }
}
