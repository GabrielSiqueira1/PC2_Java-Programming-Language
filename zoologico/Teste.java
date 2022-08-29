//Grupo: Arthur Fernandes Thimotti, Gabriel Siqueira Silva

package principal;

import java.util.ArrayList;

public class Teste {
    public static void main(String[] args) {
        ArrayList<AnimalOrcamento> financeiro;
        financeiro = new ArrayList<>();
        
        ItemOrcamentoComplexo elefantinho = new ItemOrcamentoComplexo();
        elefantinho.addGastosItem("Vacina W, Ração, Água, Remédio", 16000);
        AnimalOrcamento orcamento1 = new Elefante(elefantinho);
        
        ItemOrcamentoComplexo macaquinho = new ItemOrcamentoComplexo();
        macaquinho.addGastosItem("Manutenção, Água, Remédio, Vacina W", 7000);
        AnimalOrcamento orcamento2 = new Macaco(macaquinho);
        
        ItemOrcamentoComplexo girafinha = new ItemOrcamentoComplexo();
        girafinha.addGastosItem("Ração, Água, Remédio, Manutenção, Vacina W", 24000);
        AnimalOrcamento orcamento3 = new Girafa(girafinha);
        
        financeiro.add(orcamento1);
        financeiro.add(orcamento2);
        financeiro.add(orcamento3);
        
        Zoologico zoologico = new Zoologico();
        
        financeiro = zoologico.AnimaisVacinados(financeiro);
        
        System.out.println("Os animais que tem a vacina prevista no orçamento são: ");
        for(AnimalOrcamento c: financeiro){
            Animal a = ((Animal) c);
            System.out.println(a.getClass().getSimpleName());
        }
        System.out.println("E os seus respectivos valores são: ");
        for(AnimalOrcamento c: financeiro){
            Animal a = ((Animal) c);
            System.out.println(a.getMeuOrcamentoMensal().getValorTotal()+" reais");
        }
    }
}
