//Grupo: Arthur Fernandes Thimotti, Gabriel Siqueira Silva

package principal;

public abstract class Animal implements AnimalOrcamento{
    private ItemOrcamentoComplexo meuOrcamentoMensal;

    public Animal(ItemOrcamentoComplexo meuOrcamentoMensal) {
        this.meuOrcamentoMensal = meuOrcamentoMensal;
    }
    
    public ItemOrcamentoComplexo getMeuOrcamentoMensal() {
        return meuOrcamentoMensal;
    }

    public void setMeuOrcamentoMensal(ItemOrcamentoComplexo meuOrcamentoMensal) {
        this.meuOrcamentoMensal = meuOrcamentoMensal;
    }
}
