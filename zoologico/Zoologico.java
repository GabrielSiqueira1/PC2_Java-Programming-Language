//Grupo: Arthur Fernandes Thimotti, Gabriel Siqueira Silva

package principal;

import java.util.ArrayList;

public class Zoologico {
    private ArrayList<AnimalOrcamento> orcamentoAnimalVacina;

    public Zoologico() {
        orcamentoAnimalVacina = new ArrayList<>();
    }
    
    public ArrayList<AnimalOrcamento> AnimaisVacinados(ArrayList<AnimalOrcamento> orcamento){
        int i = 0;
        for(AnimalOrcamento c: orcamento){
            Animal a = ((Animal) c);
            String [] b = a.getMeuOrcamentoMensal().getDescricaoGastos().get(0).split(", ");
            for(String palavras: b){
                if(palavras.equals("Vacina W")){
                     orcamentoAnimalVacina.add(orcamento.get(i));
                    }
                }
            i++;
        }
       return orcamentoAnimalVacina;
    }
}
