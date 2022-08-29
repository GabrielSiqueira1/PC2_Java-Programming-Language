/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Gabriel
 */
public class SuporteTecnico {
    private HashMap <String,String> bancoSolucao;
    private ArrayList <String> respostaPadrao;
    
    public SuporteTecnico(){
        bancoSolucao = new HashMap<>();
        respostaPadrao = new ArrayList<>();
        preenchimentoBanco();
        preenchimentoPadrao();
    }
    
    private void preenchimentoBanco(){
        bancoSolucao.put("lento", "Penso que o problema está relacionado com o hardware. Fazer um upgrade\n do seu processador deve resolver o problema de performance. Você tem algum\n problema com o software?");
        bancoSolucao.put("performance", "A performance está próxima do esperado nos testes que realizamos. Você está\n executando algum outro processo em paralelo?");
        bancoSolucao.put("bug", "Bom, você sabe, todo software pode ter algum problema. Mas nossos engenheiros de software\n já estão atuando no problema para solucioná-lo. Você poderia descrever seu problema\n com mais detalhes?");
        bancoSolucao.put("buggy", "Bom, você sabe, todo software pode ter algum problema. Mas nossos engenheiros de software\n já estão atuando no problema para solucioná-lo. Você poderia descrever seu problema\n com mais detalhes?");
        bancoSolucao.put("windows", "Este é um problema do sistema operacional Windows. Por favor, \n entre em contato com a Microsoft. Não há nada que possamos fazer neste caso.");
        bancoSolucao.put("macintosh", "Este é um problema do sistema operacional Mac. Por favor, \n entre em contato com a Apple. Não há nada que possamos fazer neste caso.");
        bancoSolucao.put("caro", "O preço do nosso produto é competitivo. Você já fez uma pesquisa de mercado\n e comparou todas as características do nosso software com outras ofertas de mercado?");
        bancoSolucao.put("instalação","A instalação é simples e direta. Nós temos programas de instalação previamente configurados\n que farão todo o trabalho para você. Você já leu as instruções\n de instalação?");
        bancoSolucao.put("memória", "Se você observar detalhadamente os requisitos mínimos de sistema, você verá que\n a memória requerida é 1.5 giga byte. Você deverá adquirir\n mais memória. Mais alguma coisa que deseja saber?");
        bancoSolucao.put("linux", "Nós consideramos seriamente o suporte Linux. Mas existem muitos problemas.\n Muitos deles dizem respeito a versões incompatíveis. Você poderia ser\n mais preciso?");
        bancoSolucao.put("danificaram", "Bom, nosso software não danificaria seu sistema. Deve ser algo específico\n no seu sistema. Diga-me sobre sua configuração.");
        bancoSolucao.put("danificou",  "Bom, nosso software não danificaria seu sistema. Deve ser algo específico\n no seu sistema. Diga-me sobre sua configuração.");
    }
    
    private void preenchimentoPadrao(){
        respostaPadrao.add("Sua descrição não foi satisfatória. Você já procurou um técnico que poderia detalhar melhor este problema?");
    }
    
    public String buscaSolucao(HashSet<String> palavras){
        int contador = 0;
        String a;
        a = new String();
        for (String y: palavras){
            for(String x: bancoSolucao.keySet()){
                if(x.equals(y)){
                    a = (bancoSolucao.get(x));
                    contador++;
                }
            }
            if (contador == 0){
                a = solucaoPadrao();
            }
        }
        return a;
    }
    
    private String solucaoPadrao(){
        return respostaPadrao.get(0);
    }
}
    