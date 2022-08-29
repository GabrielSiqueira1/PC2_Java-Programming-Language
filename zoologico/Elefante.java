//Grupo: Arthur Fernandes Thimotti, Gabriel Siqueira Silva

package principal;

public class Elefante extends Animal{

    public Elefante(ItemOrcamentoComplexo meuOrcamentoMensal) {
        super(meuOrcamentoMensal);
    }
    
    @Override
    public ItemOrcamentoComplexo OrcamentoGastoAnimal(String descricao, double valor) {
        ItemOrcamentoComplexo custoElefante = new ItemOrcamentoComplexo();
        custoElefante.addGastosItem(descricao, valor);
        return custoElefante;
    }
}
