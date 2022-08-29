/*       ==================================================================

         -------------- PROJETO FINAL: LOCADORA DE FILMES -----------------

         Laboratório de Programação de Computadores II

         Grupo: Arthur Thimotti, Emilio Canton, Fernando Garamvolgyi, 
                Gabriel Siqueira e Vitório Marcos
         Data:  13/04/21    Professora: Luciana Campos

         ==================================================================*/

package services;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;
import model.Estoque;
import model.Filme;

/**
 *
 * @author Admin
 */
public class ReadTextFile {
    private static Scanner input;

    public ReadTextFile(){
        
    }

   // open file clients.txt
   public static void openFile()
   {
      try
      {
         input = new Scanner(Paths.get("locadora.txt")); 
      } 
      catch (IOException ioException)
      {
         System.err.println("Error opening file. Terminating.");
         System.exit(1);
      } 
   }

   // read record from file
   public static Estoque readRecords()
   {
       Estoque estoque = new Estoque();
       String sc1;

      try 
      {
         while (input.hasNextLine()) // while there is more to read
         {
            sc1 = input.nextLine();
            String[] atributos = sc1.split(";");
            Filme filme = new Filme(atributos[0], atributos[1], atributos[2], atributos[3]);            
            estoque.addFilme(filme, Integer.parseInt(atributos[4]));
         }
      } 
      catch (NoSuchElementException elementException)
      {
         System.err.println("File improperly formed. Terminating.");
      } 
      catch (IllegalStateException stateException)
      {
         System.err.println("Error reading from file. Terminating.");
      } 
      return estoque;
   } // end method readRecords

   // close file and terminate application
   public static void closeFile()
   {
      if (input != null)
         input.close();
   }
}
