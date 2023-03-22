/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.InputStream;
import java.util.Scanner;

// Interface Gráfica
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
     
     // Frame
      JFrame nomeDoJFrame = new JFrame("oi");
      nomeDoJFrame.setSize(300, 500);
      nomeDoJFrame.setVisible(true);
      JPanel nomeDoJPanel = new JPanel();
      nomeDoJPanel.setSize(300, 300);
     // Fim Frame

     System.out.printf(this.nome + ": ");
     while (s.hasNextLine()) 
     {
      // JLabel
        JLabel nomeDoJLabel = new JLabel();
        
        nomeDoJPanel.add(nomeDoJLabel);
        nomeDoJFrame.add(nomeDoJPanel);
      // Fim JLabel
      
      String teste = s.nextLine();

      // Outro
      nomeDoJLabel.setText(teste);
      // Fim

      if (!teste.contains(this.nome + ": "))
      {
        System.out.println(teste);
        
      }
       System.out.printf(this.nome + ": ");
     }
   }
 }
