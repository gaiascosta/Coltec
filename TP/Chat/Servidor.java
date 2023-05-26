/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Virginia
 */
public class Servidor {
 
   public static void main(String[] args) throws IOException {
     // inicia o servidor
     new Servidor(12399).executa();
   }
   
   private int porta;
   private List<PrintStream> clientes;
   
   public Servidor (int porta) {
     this.porta = porta;
     this.clientes = new ArrayList<>();
   }
   
   public void executa () throws IOException {
     ServerSocket servidor = new ServerSocket(this.porta);
     System.out.println("Porta 12345 aberta!");
     
     while (true) {
       // aceita um cliente
       Socket cliente = servidor.accept();
       System.out.println("Nova conexão com o cliente " +   
         cliente.getInetAddress().getHostAddress()
       );
       
       // adiciona saida do cliente à lista
       PrintStream ps = new PrintStream(cliente.getOutputStream());
       this.clientes.add(ps);
       
       // cria tratador de cliente numa nova thread
       TrataCliente tc = new TrataCliente(cliente.getInputStream(), this);
       new Thread(tc).start();
     }
 
   }
 
   public void distribuiMensagem(String msg) {
     // envia msg para todo mundo
     for (PrintStream cliente : this.clientes) 
     {
       cliente.println(msg);
     }
   }
 }