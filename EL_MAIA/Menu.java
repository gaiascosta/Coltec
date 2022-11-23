package EL_MAIA;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

public class Menu 
{
    // Variáveis
    Scanner esc = new Scanner(System.in);
    Restaurante restaurante = new Restaurante();

    // Funções
    void imprime_menu()
    {
        System.out.println("\nDigite [0] para SAIR");
        System.out.println("Digite [1] para RESERVAR UMA MESA");
        System.out.println("Digite [2] para FAZER UM PEDIDO");
        System.out.println("Digite [3] para CADASTRAR UM CLIENTE");
        System.out.println("Digite [4] para DIVIDIR A CONTA");
        System.out.println("Digite [5] para CALCULAR 10% DA CONTA");
        System.out.println("Digite [6] para LISTA O CONSUMO DA MESA\n");
    }
    void opcoes()
    {
        this.restaurante.inicializar_mesas();
        imprime_menu();
        String escolha = esc.next();
        int escolinha = Integer.parseInt(escolha);
        while(escolinha != 0)
        {
            switch(escolinha)
            {
                case 1:
                break;
            }
            imprime_menu();
            escolha = esc.next();
            escolinha = Integer.parseInt(escolha);
        }
    }

    public void menu_reservar (int res)
    {
        Mesa mesa = new Mesa();
        mesa.reservar(res);
    }
    public void menu_Cardapio(int res)
    {
        
        if (res == 1)
        {
            System.out.printf("\n- - - - CARDÁPIO - - - -\n");
            System.out.printf("\nBebidas");
            System.out.printf("\n[1] Água Atômica 500ml................................R$ 2,00\n[2] Limonada Suína....................................R$ 4,50");
            System.out.printf("\n[3] Coca..............................................R$ 5,50\n[4] Leite com Polvo Maltino...........................R$ 4,90");
            System.out.printf("\n[5] Suco de Abaxaqui..................................R$ 3,00\n[6] Suco de Frutas Críticas 300ml.....................R$ 4,50");
            System.out.printf("\n[7] Leite de Amnésia..................................R$ 16,00\n");

            System.out.printf("\nPratos");
            System.out.printf("\n[8] Filé Miau.........................................R$ 28,00\n[9] Batata com molho Barbie Kill.....................R$ 11,50");
            System.out.printf("\n[10] Bife alí namesa..................................R$ 27,00\n[11] Macarrão ao alho e ódio.........................R$ 15,50");
            System.out.printf("\n[12] Feijão Torpedo...................................R$ 10,00\n[13] Arroz com carne morrida.........................R$ 10,00\n");

            System.out.printf("\nSobremesas");
            System.out.printf("\n[14] X & Queique......................................R$ 8,00\n[15] Tiramisu da Engenharia (esgotado)................R$ 6,50");
            System.out.printf("\n[16] Pudim de Leite Condenado.........................R$ 4,00\n[17] Pácomê...........................................R$ 13,00");
            System.out.printf("\n[18] Sonho de Falsa...................................R$ 2,50\n[*] Especialidade do Chef.............................R$ 34,69\n[0] Fim do Pedido\n");

            System.out.printf("\n\nPor favor, digite o número da sua mesa: ");
            String mesa = esc.next();
            int mesinha =  Integer.parseInt(mesa);
            fazer_pedido(mesinha);
        }
    }
    public void fazer_pedido(int n_mesa)
    {
        String pedido = esc.next(); int i = 0;
        int pedidinho = Integer.parseInt(pedido);
        if (!(this.restaurante.mesa_existe(n_mesa)))
        {
            return;
        }
        

        while (pedidinho != 0)
        {
            switch(pedidinho)
            {
                case 1:
                restaurante.mesa.get(i).getComanda().valor += 2.00;
                restaurante.mesa.get(i).getComanda().consumo.add("Água Atômica 500ml");
                break;

                case 2:
                restaurante.mesa.get(i).getComanda().valor += 4.50;
                restaurante.mesa.get(i).getComanda().consumo.add("Limonada Suína");
                break;

                case 3:
                restaurante.mesa.get(i).getComanda().valor += 5.50;
                restaurante.mesa.get(i).getComanda().consumo.add("Coca");
                break;

                case 4:
                restaurante.mesa.get(i).getComanda().valor += 4.90;
                restaurante.mesa.get(i).getComanda().consumo.add("Leite com Polvo Maltino");
                break;

                case 5:
                restaurante.mesa.get(i).getComanda().valor += 3.00;
                restaurante.mesa.get(i).getComanda().consumo.add("Suco de Abaxaqui");
                break;

                case 6:
                restaurante.mesa.get(i).getComanda().valor += 4.50;
                restaurante.mesa.get(i).getComanda().consumo.add("Suco de Frutas Críticas 300ml");
                break;

                case 7:
                restaurante.mesa.get(i).getComanda().valor += 16.00;
                restaurante.mesa.get(i).getComanda().consumo.add("Leite de Amnésia");
                break;

                case 8:
                restaurante.mesa.get(i).getComanda().valor += 28.00;
                restaurante.mesa.get(i).getComanda().consumo.add("Filé Miau");
                break;

                case 9:
                restaurante.mesa.get(i).getComanda().valor += 11.50;
                restaurante.mesa.get(i).getComanda().consumo.add("Batata com molho Barbie Kill");
                break;

                case 10:
                restaurante.mesa.get(i).getComanda().valor += 27.00;
                restaurante.mesa.get(i).getComanda().consumo.add("Bife alí namesa");
                break;

                case 11:
                restaurante.mesa.get(i).getComanda().valor += 15.50;
                restaurante.mesa.get(i).getComanda().consumo.add("Macarrão ao alho e ódio");
                break;

                case 12:
                restaurante.mesa.get(i).getComanda().valor += 10.00;
                restaurante.mesa.get(i).getComanda().consumo.add("Feijão Torpedo");
                break;

                case 13:
                restaurante.mesa.get(i).getComanda().valor += 10.00;
                restaurante.mesa.get(i).getComanda().consumo.add("Arroz com carne morrida");
                break;

                case 14:
                restaurante.mesa.get(i).getComanda().valor += 8.00;
                restaurante.mesa.get(i).getComanda().consumo.add("X & Queique");
                break;

                case 15:
                System.out.println("*** Esgotado ***");
                break;

                case 16:
                restaurante.mesa.get(i).getComanda().valor += 4.00;
                restaurante.mesa.get(i).getComanda().consumo.add("Pudim de Leite Condenado");
                break;

                case 17:
                restaurante.mesa.get(i).getComanda().valor += 13.00;
                restaurante.mesa.get(i).getComanda().consumo.add("Pácomê");
                break;

                case 18:
                restaurante.mesa.get(i).getComanda().valor += 2.50;
                restaurante.mesa.get(i).getComanda().consumo.add("Sonho de Falsa");
                break;

                default:
                restaurante.mesa.get(i).getComanda().valor += 34.69;
                restaurante.mesa.get(i).getComanda().consumo.add("Especialidade do Chef");
                

            }
            pedido = esc.next();
            pedidinho = Integer.parseInt(pedido);
            
        }
        System.out.println("Obrigada por comprar no Buchinho Cheio");
    }
    void menu_dividir(Mesa mesa)
    {
        System.out.printf("\nPor favor, digite o número da sua mesa: ");
        String mesa_numero = esc.next();
        int mesinha =  Integer.parseInt(mesa_numero);
        while(!this.restaurante.mesa_existe(mesinha))
        {
            if (this.restaurante.mesa_existe(mesinha))
            {
                fazer_pedido(mesinha);
            }
            else
            {
                System.out.printf("\nPor favor, digite o número da sua mesa: ");
                mesa_numero = esc.next();
                mesinha =  Integer.parseInt(mesa_numero);
            }
        }
    }
    void menu_10per()
    {
        System.out.printf("\nPor favor, digite o número da sua mesa: ");
        String mesa_numero = esc.next();
        int mesinha =  Integer.parseInt(mesa_numero);
        while(!this.restaurante.mesa_existe(mesinha))
        {
            if (this.restaurante.mesa_existe(mesinha))
            {
                System.out.println("Cada cliente da mesa deverá pagar " + restaurante.mesa.get(mesinha).getComanda().calcular10Porcento());
            }
            else
            {
                System.out.printf("\nPor favor, digite o número da sua mesa: ");
                mesa_numero = esc.next();
                mesinha =  Integer.parseInt(mesa_numero);
            }
        }
    }
    void menu_cadastra_cliente()
    {
        System.out.printf("\nPor favor, digite o número em que o cliente deve ser cadastrado: ");
        String mesa_numero = esc.next();
        int mesinha =  Integer.parseInt(mesa_numero);

    }
    void menu_listar()
    {
        System.out.printf("\nPor favor, digite o número da sua mesa: ");
        String mesa_numero = esc.next();
        int mesinha =  Integer.parseInt(mesa_numero);
        this.restaurante.mesa_existe(mesinha);
        if (this.restaurante.mesa_existe(mesinha))
        {
            restaurante.mesa.get(mesinha).getComanda().listarConsumo();
        }
    }

}

