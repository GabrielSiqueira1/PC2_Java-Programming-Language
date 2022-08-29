//Grupo: Arthur Fernandes Thimotti, Gabriel Siqueira Silva

package principal;

public class Girafa extends Animal{

    public Girafa(ItemOrcamentoComplexo meuOrcamentoMensal) {
        super(meuOrcamentoMensal);
    }
    
    @Override
    public ItemOrcamentoComplexo OrcamentoGastoAnimal(String descricao, double valor) {
        ItemOrcamentoComplexo custoGirafa = new ItemOrcamentoComplexo();
        custoGirafa.addGastosItem(descricao, valor);
        return custoGirafa;
    }
}