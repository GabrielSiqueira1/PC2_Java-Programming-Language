/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.HashSet;

/**
 *
 * @author Gabriel
 */
public class Interpretadora {
    private HashSet<String> palavraChave;
    
    public Interpretadora(){
        palavraChave = new HashSet<>();
    }
    
    public HashSet<String> preenchimento(String problema){
        
        String[] palavras = problema.split(" ");
        
        for (String palavra : palavras){
            palavraChave.add(palavra);
        }
        
        return palavraChave;
    }
    
}
