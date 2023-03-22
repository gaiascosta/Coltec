/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.InputStream;
import java.util.Scanner;

// Interface Gráfica
import javax.swing.JOptionPane;

/**
 *
 * @author Virginia
 */
public class Recebedor implements Runnable {
 
   private InputStream servidor;
   private String nome;
 
   public Recebedor(InputStream servidor, String nome) {
     this.servidor = servidor;
     this.nome = nome;
   }
 
   @Override
   public void run() {
     // recebe msgs do servidor e imprime na tela
     Scanner s = new Scanner(this.servidor);

     System.out.printf(this.nome + ": ");
     while (s.hasNextLine()) 
     {
      String teste = s.nextLine();
      JOptionPane.showMessageDialog(null, teste);
      if (!teste.contains(this.nome + ": "))
      {
        System.out.println(teste);
      }
      
       System.out.printf(this.nome + ": ");
     }
   }
 }