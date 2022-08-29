/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class Bag{
    private ArrayList<Items> backpack = new ArrayList<>();
    private Items axe = new Items("Axe");
    
    public Bag(){
        backpack.add(axe);
    }
    
    public Bag(Items item){
        backpack.add(item);
    }

    public ArrayList<Items> getBackpack() {
        return backpack;
    }

    public void setBackpack(Items backpack) {
        this.backpack.add(backpack);
    }
}
