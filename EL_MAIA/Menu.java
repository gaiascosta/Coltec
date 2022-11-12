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
    public void menu_Cardapio()
    {
        Mesa mesa = new Mesa();
        System.out.printf("Deseja fazer uma pedido? \n[0] Não\t[1] Sim\t: ");
        int res = esc.nextInt();
        if (res == 1)
        {
            System.out.printf("\n- - - - CARDÁPIO - - - -\n");
            System.out.printf("\nBebidas");
            System.out.printf("\n[1] Água 500ml...................................R$ 2,00\n[2] Cerveja 500ml................................R$ 4,50");
            System.out.printf("\n[3] Coca Cola 1L.................................R$ 5,50\n[4] Suco de Laranja 300ml........................R$ 3,50");
            System.out.printf("\n[5] Suco de Abacaxi..............................R$ 3,50\n[6] Suco de Uva 300ml............................R$ 3,50");
            System.out.printf("\n[7] Garrafa de Vinho Tinto.......................R$ 79,90\n");
            System.out.printf("\nPratos");
            System.out.printf("\n[11] Filé Miau...................................R$ 2,00\n");
            System.out.printf("\nSobremesas");
            System.out.printf("\n[21] Brisadeiro..................................R$ 8,00\n[22] Tiramisu da Engenharia (esgotado)...........R$ 6,50");
        }
    }
}
