//Grupo: Arthur Fernandes Thimotti, Gabriel Siqueira Silva

package principal;

public class Macaco extends Animal{

    public Macaco(ItemOrcamentoComplexo meuOrcamentoMensal) {
        super(meuOrcamentoMensal);
    }
    
    @Override
    public ItemOrcamentoComplexo OrcamentoGastoAnimal(String descricao, double valor) {
        ItemOrcamentoComplexo custoMacaco = new ItemOrcamentoComplexo();
        custoMacaco.addGastosItem(descricao, valor);
        return custoMacaco;
    }
}
