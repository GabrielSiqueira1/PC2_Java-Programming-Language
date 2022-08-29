/*       ==================================================================

         -------------- PROJETO FINAL: LOCADORA DE FILMES -----------------

         Laboratório de Programação de Computadores II

         Grupo: Arthur Thimotti, Emilio Canton, Fernando Garamvolgyi, 
                Gabriel Siqueira e Vitório Marcos
         Data:  13/04/21    Professora: Luciana Campos

         ==================================================================*/

package services;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import model.Estoque;

/**
 *
 * @author Admin
 */
public class CreateTextFile {
    private static Formatter output; // outputs text to a file
 
    public CreateTextFile(){
        
    }

   // open file clients.txt
   public static void openFile()
   {
      try
      {
         output = new Formatter("locadora.txt"); // open the file
      }
      catch (SecurityException securityException)
      {
         System.err.println("Write permission denied. Terminating.");
         System.exit(1); // terminate the program
      } 
      catch (FileNotFoundException fileNotFoundException)
      {
         System.err.println("Error opening file. Terminating.");
         System.exit(1); // terminate the program
      } 
   } 

   // add records to file
   public static void addRecords(Estoque estoque)
   {     
       //output.format("Nome;Telefone;Email\n");
     try
     {
        // output new record to file; assumes valid input
        output.format(estoque.listaFilmes());                             
     } 
     catch (FormatterClosedException formatterClosedException)
     {
        System.err.println("Error writing to file. Terminating.");

     } 
     catch (NoSuchElementException elementException)
     {
        System.err.println("Invalid input. Please try again.");
     } 

     System.out.print("? ");
   }

   // close file
   public static void closeFile()
   {
      if (output != null)
         output.close();
   }
}
