/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.*;
import java.net.*;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 *
 * @author Virginia
 */
public class Cliente {
   public static void main(String[] args) throws UnknownHostException, IOException {
     // dispara cliente

     Scanner scanf = new Scanner(System.in);
     String nome;
     System.out.printf("Por favor, digite seu nome de usuário: ");
     nome = scanf.nextLine();
     new Cliente("10.0.0.19", 12399, nome).executa();
   }
   
   private String host;
   private int porta;
   private String nome;
   
   public String getNome() {
    return nome;
  }

  public Cliente (String host, int porta, String nome) {
     this.host = host;
     this.porta = porta;
     this.nome = nome;
   }
   
   public void executa() throws UnknownHostException, IOException {
     Socket cliente = new Socket(this.host, this.porta);
     System.out.println("O cliente se conectou ao servidor!");
 
     // thread para receber mensagens do servidor
     Recebedor r = new Recebedor(cliente.getInputStream(), this.nome);
     new Thread(r).start();
     
     // lê msgs do teclado e manda pro servidor
     Scanner teclado = new Scanner(System.in);
     PrintStream saida = new PrintStream(cliente.getOutputStream());
     while (teclado.hasNextLine()) 
     {
      String newText = JOptionPane.showInputDialog("");
      saida.println(this.nome + ": " + teclado.nextLine());
     }
     
     saida.close();
     teclado.close();
     cliente.close();    
   }
 }