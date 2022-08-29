//Grupo: Arthur Fernandes Thimotti, Gabriel Siqueira Silva

package principal;

import java.util.ArrayList;

public class ItemOrcamentoComplexo {
    private ArrayList<String> descricaoGastos;
    private double valorTotal;
    
    public ItemOrcamentoComplexo(){
        descricaoGastos = new ArrayList<>();
        valorTotal = 0;
    }
    
    public void addGastosItem(String evento, double valorDescrito){
        descricaoGastos.add(evento);
        valorTotal = valorDescrito;
    }
    
    public ArrayList<String> getDescricaoGastos() {
        return descricaoGastos;
    }

    public void setDescricaoGastos(ArrayList<String> descricaoGastos) {
        this.descricaoGastos = descricaoGastos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
