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
public class Items {
    private String item;
    
    public Items(){
        this.item = " ";
    }
    public Items(String collection){
        this.item = collection;
    }

    public String getItens() {
        return item;
    }

    public void setItens(String itens) {
        this.item = itens;
    }
}
