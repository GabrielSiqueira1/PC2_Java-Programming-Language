/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

/**
 *
 * @author Gabriel
 */
public class Teste {
    private static Forma matemagica;
    private static CaixaDeBrinquedo caixinha;
    public static void main(String[] args) {
        caixinha = new CaixaDeBrinquedo();
        matemagica = new Circulo(5);
        caixinha.adcionarFormas(matemagica);
        matemagica = new Triangulo(1,4);
        caixinha.adcionarFormas(matemagica);
        matemagica = new Quadrado(5);
        caixinha.adcionarFormas(matemagica);
        matemagica = new Cubo(3);
        caixinha.adcionarFormas(matemagica);
        matemagica = new Esfera(3);
        caixinha.adcionarFormas(matemagica);
        matemagica = new Tetraedro(5);
        caixinha.adcionarFormas(matemagica);
    }
}
