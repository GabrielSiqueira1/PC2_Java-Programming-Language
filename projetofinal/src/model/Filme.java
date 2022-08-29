/*       ==================================================================

         -------------- PROJETO FINAL: LOCADORA DE FILMES -----------------

         Laboratório de Programação de Computadores II

         Grupo: Arthur Thimotti, Emilio Canton, Fernando Garamvolgyi, 
                Gabriel Siqueira e Vitório Marcos
         Data:  13/04/21    Professora: Luciana Campos

         ==================================================================*/

package model;

public class Filme {
    private String titulo;
    private String categoria;
    private String valor;
    private String ano;

    public Filme(String titulo, String categoria, String valor, String ano) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.valor = valor;
        this.ano = ano;
    }

    public Filme() {
        
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
