/*       ==================================================================

         -------------- PROJETO FINAL: LOCADORA DE FILMES -----------------

         Laboratório de Programação de Computadores II

         Grupo: Arthur Thimotti, Emilio Canton, Fernando Garamvolgyi, 
                Gabriel Siqueira e Vitório Marcos
         Data:  13/04/21    Professora: Luciana Campos

         ==================================================================*/

package model;

import java.util.HashMap;

public class Estoque {
    private HashMap<Filme, Integer> estoque;
    
    public Estoque(){
        estoque = new HashMap<>();
    }
    
    public void addFilme(Filme f, int copias){
        estoque.put(f, copias);
    }
    
    public Filme verificaExistencia(String nome){
        for(Filme f: estoque.keySet()){
            if(nome.equalsIgnoreCase(f.getTitulo())){
                return f;
            }
        }
        return null;
    }
    
    public int verificaDiponibilidade(Filme f){
        return estoque.get(f);
    }
    
    public String listaFilmes(){
        String lista = new String();
        for(Filme f: estoque.keySet()){
            lista = lista.concat(f.getTitulo()+";"+f.getCategoria()+
                    ";"+f.getValor()+";"+f.getAno()+";"+estoque.get(f)+"\n");
        }
        return lista;
    } 
    
    public String listaCatalogo(){
        String catalogo = new String("Lista de Filmes: \n");
        for(Filme f: estoque.keySet()){
            catalogo = catalogo.concat("-"+f.getTitulo()+"\n");
        }
        return catalogo;
    }
    
    public String listaCategoria(String categoria){
        int controle = 0;
        String listaCat = new String("Filmes da categoria "+categoria+":\n");
        for(Filme f: estoque.keySet()){
            if(f.getCategoria().equalsIgnoreCase(categoria)){
                listaCat = listaCat.concat("-"+f.getTitulo()+"\n");
                controle = 1;
            }
        }
        if(controle == 0){
            return "";
        }
        return listaCat;
    }

    public HashMap<Filme, Integer> getEstoque() {
        return estoque;
    }
     
    public String exibeFilme(Filme f){
        String filme = new String("Informações do Filme: \n");
        filme = filme.concat("-Título: "+f.getTitulo()+"\n"
                + "-Categoria: "+f.getCategoria()+"\n"
                + "-Ano de lançamento: "+f.getAno()+"\n"
                + "-Cópias disponíveis: "+estoque.get(f)+"\n"
                + "-Valor: R$ "+f.getValor());
        return filme;
    }
    public void originalEstoque(){
        
        Filme filme = new Filme("Godzilla vs Kong", "Ação" ,"120.00", "2021");            
        estoque.put(filme, 3);
        filme = new Filme("Jurassic Park - Parque dos dinossauros","Ficção"
                + " Científica","89.00","1993");
        estoque.put(filme, 3);
        filme = new Filme("Massacre da Serra Elétrica","Terror","67.00","1974");
        estoque.put(filme, 3);
        filme = new Filme("Harry Potter e as Relíquias da Morte - Parte 2",
                "Fantasia","103.00", "2011");
        estoque.put(filme, 3);
        filme = new Filme("Como treinar seu dragão","Aventura","345.00","2010");
        estoque.put(filme, 3);
        filme = new Filme("Viúva Negra","Ação","60.00","2021");
        estoque.put(filme, 3);
        filme = new Filme("Django Livre","Faroeste","89.00","2012");
        estoque.put(filme, 3);
        filme = new Filme("A vida é bela","Drama","80.00","1997");
        estoque.put(filme, 3);
        filme = new Filme("Procurando Nemo","Aventura","14.00","2003");
        estoque.put(filme, 3);
        filme = new Filme("Garota exemplar","Suspense","73.00","2014");
        estoque.put(filme, 3);
        filme = new Filme("As aventuras de Pi","Aventura","93.00","2012");
        estoque.put(filme, 3);
        filme = new Filme("Corra!","Suspense","29.00","2017");
        estoque.put(filme, 3);
        filme = new Filme("Your name","Romance","52.00","2016");
        estoque.put(filme, 3);
        filme = new Filme("Como eu era antes de você","Romance","32.00","2016");
        estoque.put(filme, 3);
        filme = new Filme("O Exorcista","Terror","84.00","1973");
        estoque.put(filme, 3);
        filme = new Filme("Matrix 4","Ficção Científica","60.00","2021");
        estoque.put(filme, 3);
        filme = new Filme("Intocáveis","Drama","35.00","2011");
        estoque.put(filme, 3);
        filme = new Filme("Liga da Justiça","Ação","60.00","2021");
        estoque.put(filme, 3);
        filme = new Filme("Cantando na chuva","Musical","1067.00","1952");
        estoque.put(filme, 3);
        filme = new Filme("Um sonho de liberdade","Drama","40.00","1994");
        estoque.put(filme, 3);
        filme = new Filme("Escola de Rock","Comédia","92.00","2003");
        estoque.put(filme, 3);
        filme = new Filme("La la land: Cantando Estações","Musical",
                "69.00","2016");
        estoque.put(filme, 3);
        filme = new Filme("Pulp Fiction","Comédia","92.00","1994");
        estoque.put(filme, 3);
        filme = new Filme("Blade Runner 2049","Ficção Científica",
                "102.00","2017");
        estoque.put(filme, 3);
        filme = new Filme("O auto da compadecida","Comédia","95.00","2000");
        estoque.put(filme, 3);
        filme = new Filme("Parasita","Suspense","46.00","2019");
        estoque.put(filme, 3);
        filme = new Filme("A Silent Voice","Romance","24.00","2016");
        estoque.put(filme, 3);
        filme = new Filme("A noviça rebelde","Musical","78.00","1965");
        estoque.put(filme, 3);
        filme = new Filme("O senhor dos Anéis: A Sociedade do anel",
                "Fantasia","87.00","2001");
        estoque.put(filme, 3);
        filme = new Filme("007 Cassino Royale","Espionagem","90.00","2006");
        estoque.put(filme, 3);
        filme = new Filme("Suspiria","Terror","73.00","2018");
        estoque.put(filme, 3);
        
    }

}
