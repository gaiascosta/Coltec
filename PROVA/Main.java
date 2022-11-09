// Nome: Gabriela Souza Gomes da Costa
// Data: 26/10/2022
// PROVA AEDS

package PROVA;
import java.util.Scanner;


public class Main 
{
    public static void main (String[] args)
    {
        InstaPet insta = new InstaPet();
        int escolha = 1;
        Scanner esc = new Scanner(System.in);
        Menu menu = new Menu();

        while (escolha != 0)
        {
            menu.imprime_menu(); 
            escolha = esc.nextInt();
            menu.opcoes(escolha, insta);
        }
        esc.close();
        
    }
}
