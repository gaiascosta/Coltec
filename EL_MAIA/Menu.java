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
            System.out.printf("\n[1] Água Atômica 500ml................................R$ 2,00\n[2] Limonada Suína....................................R$ 4,50");
            System.out.printf("\n[3] Garrafa Bete de Caco Cola.........................R$ 5,50\n[4] Leite com Polvo Maltino...........................R$ 3,50");
            System.out.printf("\n[5] Suco de Abaxaqui..................................R$ 3,50\n[6] Suco de Frutas Críticas 300ml.....................R$ 3,50");
            System.out.printf("\n[7] Leite de Amnésia..................................R$ 79,90\n");

            System.out.printf("\nPratos");
            System.out.printf("\n[11] Filé Miau........................................R$ 2,00\n[12] Batata com molho Barbie Kill.....................R$ 6,50");
            System.out.printf("\n[11] Bife alí namesa...................................R$ 2,00\n[12] Macarrão a alho e ódio...........................R$ 6,50");
            System.out.printf("\n[11] Feijão Torpedo...................................R$ 2,00\n[12] Arroz com carne morrida..........................R$ 6,50\n");

            System.out.printf("\nSobremesas");
            System.out.printf("\n[21] X & Queique......................................R$ 8,00\n[22] Tiramisu da Engenharia (esgotado)................R$ 6,50");
            System.out.printf("\n[21] Pudim de Leite Condenado.........................R$ 8,00\n[22] Pácomê...........................................R$ 6,50");
            System.out.printf("\n[21] Sonho de Falsa...................................R$ 8,00\n");
        }
    }
}
