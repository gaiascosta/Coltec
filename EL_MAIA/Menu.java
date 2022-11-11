package EL_MAIA;
import java.util.Scanner;

public class Menu 
{
    // Variáveis
    Scanner esc = new Scanner(System.in);

    // Funções
    public void menu_reservar ()
    {
        Mesa mesa = new Mesa();
        System.out.printf("Deseja fazer uma reserva? \n[0] Não\t[1] Sim\t: ");
        int res = esc.nextInt();
        mesa.reservar(res);
    }
}
