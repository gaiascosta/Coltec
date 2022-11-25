import java.util.Scanner;

public class Menu 
{
    // Variáveis
    Scanner esc = new Scanner(System.in);
    Restaurante restaurante = new Restaurante();
    int dia;
    int mes;

    // Funções
    public int scanf()
    {
        while(true)
        {
            try
            {
                int valor = esc.nextInt();
                return valor;
            }
            catch (Exception e)
            {
                System.out.println("\n*** INVÁLIDO ***");
                System.out.printf("\n Tente novamente: ");
                esc.next();
            }
        }
    }

    void imprime_menu()
    {
        System.out.println("\nDigite [0] para SAIR");
        System.out.println("Digite [1] para RESERVAR UMA MESA");
        System.out.println("Digite [2] para FAZER UM PEDIDO");
        System.out.println("Digite [3] para CADASTRAR UM CLIENTE");
        System.out.println("Digite [4] para DIVIDIR A CONTA");
        System.out.println("Digite [5] para CALCULAR 10% DA CONTA");
        System.out.println("Digite [6] para LISTAR O CONSUMO DA MESA\n");
    }
    void opcoes()
    {
        this.restaurante.inicializar_mesas();
        System.out.printf("\nPor favor, digite o dia de hoje: ");
        this.dia = scanf();
        System.out.printf("\nPor favor, digite o mes de hoje: ");
        this.mes = scanf();
        while((dia > 31) || (mes > 12) || (dia <= 0) || (mes <= 0))
        {
            System.out.println("\n**Data invalida, tente novamente**\n");
            System.out.printf("\nPor favor, digite o dia de hoje: ");
            this.dia = scanf();
            System.out.printf("\nPor favor, digite o mes de hoje: ");
            this.mes = scanf();
        }
        imprime_menu();
        int escolinha = scanf();
        while(escolinha != 0)
        {
            switch(escolinha)
            {
                case 1:
                this.menu_reservar();
                break;

                case 2:
                this.menu_Cardapio();
                break;

                case 3:
                this.menu_cadastra_cliente();
                break;

                case 4:
                this.menu_dividir();
                break;

                case 5:
                this.menu_10per();
                break;

                case 6:
                this.menu_listar();
                break;
            }
            imprime_menu();
            escolinha = scanf();
        }
    }

    public void menu_reservar ()
    {
        System.out.printf("\nPor favor, digite o número da sua mesa: ");
        int mesinha =  scanf();
        System.out.println("\nPor favor, digite o dia desejado para a reserva: ");
        int ditito = scanf();
        System.out.println("\nPor favor, digite o mes desejado para a reserva: ");
        int mesito = scanf();
        if (this.restaurante.mesa.get(mesinha).reservar(ditito, mesito) == true)
        {
            System.out.println("\nMesa reservada com sucesso!");
        }
        else
        {
            System.out.println("\nMesa desejada já está reservada;");
        }
    }
    public void menu_Cardapio()
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
            int mesinha =  scanf();
            if (this.restaurante.mesa_existe(mesinha, dia, mes) == true)
            {
                fazer_pedido(mesinha, dia, mes);
            }
    }
    public void fazer_pedido(int i, int dia, int mes)
    {
        int j = 0;
        while((this.restaurante.mesa.get(i).data.get(j).getDia() != dia) || (this.restaurante.mesa.get(i).data.get(j).getMes() != mes))
        {
            j++;
        }
        System.out.printf("\n\nPor favor, digite o código dos itens desejados: ");
        int pedidinho = scanf();

        while (pedidinho != 0)
        {
            switch(pedidinho)
            {
                case 1:
                restaurante.mesa.get(i).data.get(j).comanda_bebida.valor += 2.00;
                restaurante.mesa.get(i).data.get(j).comanda_bebida.consumo.add("Água Atômica 500ml");
                break;

                case 2:
                restaurante.mesa.get(i).data.get(j).comanda_bebida.valor += 4.50;
                restaurante.mesa.get(i).data.get(j).comanda_bebida.consumo.add("Limonada Suína");
                break;

                case 3:
                restaurante.mesa.get(i).data.get(j).comanda_bebida.valor += 5.50;
                restaurante.mesa.get(i).data.get(j).comanda_bebida.consumo.add("Coca");
                break;

                case 4:
                restaurante.mesa.get(i).data.get(j).comanda_bebida.valor += 4.90;
                restaurante.mesa.get(i).data.get(j).comanda_bebida.consumo.add("Leite com Polvo Maltino");
                break;

                case 5:
                restaurante.mesa.get(i).data.get(j).comanda_bebida.valor += 3.00;
                restaurante.mesa.get(i).data.get(j).comanda_bebida.consumo.add("Suco de Abaxaqui");
                break;

                case 6:
                restaurante.mesa.get(i).data.get(j).comanda_bebida.valor += 4.50;
                restaurante.mesa.get(i).data.get(j).comanda_bebida.consumo.add("Suco de Frutas Críticas 300ml");
                break;

                case 7:
                restaurante.mesa.get(i).data.get(j).comanda_bebida.valor += 16.00;
                restaurante.mesa.get(i).data.get(j).comanda_bebida.consumo.add("Leite de Amnésia");
                break;

                case 8:
                restaurante.mesa.get(i).data.get(j).comanda_comida.valor += 28.00;
                restaurante.mesa.get(i).data.get(j).comanda_comida.consumo.add("Filé Miau");
                break;

                case 9:
                restaurante.mesa.get(i).data.get(j).comanda_comida.valor += 11.50;
                restaurante.mesa.get(i).data.get(j).comanda_comida.consumo.add("Batata com molho Barbie Kill");
                break;

                case 10:
                restaurante.mesa.get(i).data.get(j).comanda_comida.valor += 27.00;
                restaurante.mesa.get(i).data.get(j).comanda_comida.consumo.add("Bife alí namesa");
                break;

                case 11:
                restaurante.mesa.get(i).data.get(j).comanda_comida.valor += 15.50;
                restaurante.mesa.get(i).data.get(j).comanda_comida.consumo.add("Macarrão ao alho e ódio");
                break;

                case 12:
                restaurante.mesa.get(i).data.get(j).comanda_comida.valor += 10.00;
                restaurante.mesa.get(i).data.get(j).comanda_comida.consumo.add("Feijão Torpedo");
                break;

                case 13:
                restaurante.mesa.get(i).data.get(j).comanda_comida.valor += 10.00;
                restaurante.mesa.get(i).data.get(j).comanda_comida.consumo.add("Arroz com carne morrida");
                break;

                case 14:
                restaurante.mesa.get(i).data.get(j).comanda_comida.valor += 8.00;
                restaurante.mesa.get(i).data.get(j).comanda_comida.consumo.add("X & Queique");
                break;

                case 15:
                System.out.println("*** Esgotado ***");
                break;

                case 16:
                restaurante.mesa.get(i).data.get(j).comanda_comida.valor += 4.00;
                restaurante.mesa.get(i).data.get(j).comanda_comida.consumo.add("Pudim de Leite Condenado");
                break;

                case 17:
                restaurante.mesa.get(i).data.get(j).comanda_comida.valor += 13.00;
                restaurante.mesa.get(i).data.get(j).comanda_comida.consumo.add("Pácomê");
                break;

                case 18:
                restaurante.mesa.get(i).data.get(j).comanda_comida.valor += 2.50;
                restaurante.mesa.get(i).data.get(j).comanda_comida.consumo.add("Sonho de Falsa");
                break;

                default:
                restaurante.mesa.get(i).data.get(j).comanda_comida.valor += 34.69;
                restaurante.mesa.get(i).data.get(j).comanda_comida.consumo.add("Especialidade do Chef");
                

            }
            pedidinho = scanf();
            
        }
        System.out.println("\nObrigada por comprar no Buchinho Cheio!");
    }
    public void menu_dividir()
    {
        System.out.printf("\nPor favor, digite o número da sua mesa: ");
        int mesinha =  scanf();
        int j = 0;
        if (this.restaurante.mesa_existe(mesinha, dia, mes))
        {
            while((this.restaurante.mesa.get(mesinha).data.get(j).getDia() != dia) || (this.restaurante.mesa.get(mesinha).data.get(j).getMes() != mes))
            {
                j++;
            }
            System.out.println("Cada cliente da mesa deverá pagar R$" + ( this.restaurante.mesa.get(mesinha).data.get(j).comanda_bebida.dividirConta(this.restaurante.mesa.get(mesinha).cliente.size()) + this.restaurante.mesa.get(mesinha).data.get(j).comanda_comida.dividirConta(this.restaurante.mesa.get(mesinha).cliente.size()) ) + "0");
        }
    }
    public void menu_10per()
    {
        System.out.printf("\nPor favor, digite o número da sua mesa: ");
        int mesinha = scanf();
        if (this.restaurante.mesa_existe(mesinha, dia, mes))
        {
            int j = 0;
            while((this.restaurante.mesa.get(mesinha).data.get(j).getDia() != dia) || (this.restaurante.mesa.get(mesinha).data.get(j).getMes() != mes))
            {
                j++;
            }
            System.out.println("A gorjeta estimada é de R$" + ( restaurante.mesa.get(mesinha).data.get(j).comanda_bebida.calcular10Porcento() + restaurante.mesa.get(mesinha).data.get(j).comanda_comida.calcular10Porcento() ) + "0");
        }
    }
    void menu_cadastra_cliente()
    {
        System.out.printf("\nPor favor, digite a mesa em que o cliente deve ser cadastrado: ");
        int mesinha = scanf();
        if (this.restaurante.mesa_existe(mesinha, dia, mes))
        {
            Cliente cl = new Cliente();
            System.out.printf("\nPor favor, digite o nome do cliente: ");
            cl.setNome(esc.next());
            System.out.printf("\nPor favor, digite o email do cliente: ");
            cl.setEmail(esc.next());
            this.restaurante.mesa.get(mesinha).cliente.add(cl);
        }

    }
    void menu_listar()
    {
        System.out.printf("\nPor favor, digite o número da sua mesa: ");
        int mesinha =  scanf();
        if (this.restaurante.mesa_existe(mesinha, dia, mes))
        {
            System.out.println("teste" + mesinha);
            int j = 0;
            while((this.restaurante.mesa.get(mesinha).data.get(j).getDia() != dia) || (this.restaurante.mesa.get(mesinha).data.get(j).getMes() != mes))
            {
                j++;
            }
            System.out.println("----Lista de Bebidas----");
            restaurante.mesa.get(mesinha).data.get(j).comanda_bebida.listarConsumo();
            System.out.println("----Lista de Comidas----");
            restaurante.mesa.get(mesinha).data.get(j).comanda_comida.listarConsumo();
            System.out.println("O valor a ser pago é R$" + ( restaurante.mesa.get(mesinha).data.get(j).comanda_bebida.getValor() + restaurante.mesa.get(mesinha).data.get(j).comanda_comida.getValor() ) + "0");
        }
    }

}
