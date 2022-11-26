import java.util.Scanner;

public class Menu 
{
    // Variáveis
    Scanner esc = new Scanner(System.in);
    private Restaurante restaurante = new Restaurante();
    private int dia;
    private int mes;

    // ----- Funções -----

    // Tenta ler um int, caso não consiga, pede para o usuário digitar novamente
    public int scanf()
    {
        while(true) // Enquanto o usuário não digitar um int
        {
            try
            {
                int valor  = esc.nextInt();
                return valor; // Retorna o valor digitado
            }
            catch (Exception e)
            {
                System.out.println("\n*** INVÁLIDO ***");
                System.out.printf("\n Tente novamente: ");
                esc.next(); // Limpa o Scanner
            }
        }
    }

    // Imprime o menu de opções do usuário
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

    // Função que imprime o menu de opções do usuário
    void opcoes()
    {
        this.restaurante.inicializar_mesas(); // Inicializa as mesas
        System.out.printf("\nPor favor, digite o dia de hoje: ");
        this.dia = scanf(); 
        System.out.printf("\nPor favor, digite o mes de hoje: ");
        this.mes = scanf();
        // Scanners para saber o dia de hoje, já que não foi possível usar a biblioteca Java Joda

        while((this.dia > 31) || (this.mes > 12) || (this.dia <= 0) || (this.mes <= 0)) // Verifica se o dia existe
        {
            System.out.println("\n**Data invalida, tente novamente**\n");
            System.out.printf("\nPor favor, digite o dia de hoje: ");
            this.dia = scanf();
            System.out.printf("\nPor favor, digite o mes de hoje: ");
            this.mes = scanf();
        }

        imprime_menu(); // Imprime as opções

        int escolinha = scanf(); // Lê a escolha feita pelo usuário
        while(escolinha != 0) // Se o usuário não escolher sair, cada um vai para uma função diferente
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
            // Imprime as opções novamente e pergunta ao usuário a opção desejada
            imprime_menu();
            escolinha = scanf();
        }
    }

    //Reserva uma mesa
    public void menu_reservar ()
    {
        System.out.printf("\nPor favor, digite o número da sua mesa: ");
        int mesinha =  scanf();
        System.out.println("\nPor favor, digite o dia desejado para a reserva: ");
        int ditito = scanf();
        System.out.println("\nPor favor, digite o mes desejado para a reserva: ");
        int mesito = scanf();
        // Pergunta a mesa, o dia e o mês desejado para a reserva

        if (this.restaurante.mesa.get(mesinha).reservar(ditito, mesito) == true) // Se a mesa estiver disponível no dia, reserva
        {
            System.out.println("\nMesa reservada com sucesso!");
        }
        else // Se a mesa não estiver disponível no dia ou não existir, não reserva
        {
            System.out.println("\nMesa desejada já está reservada;");
        }
    }

    // Imprime o Cardápio
    public void menu_Cardapio()
    {
        System.out.printf("\n- - - - CARDÁPIO - - - -\n");
            System.out.printf("\nBebidas");
            System.out.printf("\n[1] Água Atômica 500ml................................R$ 2,00\n[2] Limonada Suína....................................R$ 4,50");
            System.out.printf("\n[3] Coca A-Normal.....................................R$ 5,50\n[4] Leite com Polvo Maltino...........................R$ 4,90");
            System.out.printf("\n[5] Suco de Abaxaqui..................................R$ 3,00\n[6] Suco de Frutas Críticas 300ml.....................R$ 4,50");
            System.out.printf("\n[7] Leite de Amnésia..................................R$ 16,00\n");

            System.out.printf("\nPratos");
            System.out.printf("\n[8] Filé Miau.........................................R$ 28,00\n[9] Batata com molho Barbie Kill....................R$ 11,50");
            System.out.printf("\n[10] Bife alí namesa..................................R$ 27,00\n[11] Macarrão ao alho e ódio........................R$ 15,50");
            System.out.printf("\n[12] Feijão Torpedo...................................R$ 10,00\n[13] Arroz com carne morrida........................R$ 10,00\n");

            System.out.printf("\nSobremesas");
            System.out.printf("\n[14] X & Queique......................................R$ 8,00\n[15] Tiramisu da Engenharia (esgotado)................R$ 6,50");
            System.out.printf("\n[16] Pudim de Leite Condenado.........................R$ 4,00\n[17] Pácomê...........................................R$ 13,00");
            System.out.printf("\n[18] Sonho de Falsa...................................R$ 2,50\n[*] Especialidade do Chef.............................R$ 34,69\n[0] Fim do Pedido\n");

            System.out.printf("\n\nPor favor, digite o número da sua mesa: ");
            int mesinha =  scanf(); // Escanei o número da mesa em que o usuário fará o pedido
            if (this.restaurante.mesa_existe(mesinha, this.dia, this.mes) == true) // O pedido só poderá ser feito se a mesa estiver reservada para o dia de hoje
            {
                fazer_pedido(mesinha, this.dia, this.mes); // Vai para a função fazer pedido
            }
    }

    // Escaneia e guarda as informações
    public void fazer_pedido(int i, int dia, int mes)
    {
        int j = 0;
        while((this.restaurante.mesa.get(i).data.get(j).getDia() != dia) || (this.restaurante.mesa.get(i).data.get(j).getMes() != mes))
        {
            j++;
        }
        // O código acima procura na lista de datas, o dia de hoje

        System.out.printf("\n\nPor favor, digite o código dos itens desejados: ");
        int pedidinho = scanf(); // Escaneia o item escolhido pelo cliente

        while (pedidinho != 0) // Enquanto o usuário não digitar 0, escaneia os itens escolhidos
        {
            // Switch que verifica o número digitado pelo usuário e para cada caso:
            // 1° - adiciona o valor do item ao valor na comanda
            // 2° - adiciona o nome do item ao consumo na comanda
            switch(pedidinho)
            {
                case 1:
                restaurante.mesa.get(i).data.get(j).getComanda_bebida().setValor(restaurante.mesa.get(i).data.get(j).getComanda_bebida().getValor() + 2.00);
                restaurante.mesa.get(i).data.get(j).getComanda_bebida().consumo.add("Água Atômica 500ml");
                break;

                case 2:
                restaurante.mesa.get(i).data.get(j).getComanda_bebida().setValor(restaurante.mesa.get(i).data.get(j).getComanda_bebida().getValor()  + 4.50);
                restaurante.mesa.get(i).data.get(j).getComanda_bebida().consumo.add("Limonada Suína");
                break;

                case 3:
                restaurante.mesa.get(i).data.get(j).getComanda_bebida().setValor(restaurante.mesa.get(i).data.get(j).getComanda_bebida().getValor()  + 5.50);
                restaurante.mesa.get(i).data.get(j).getComanda_bebida().consumo.add("Coca A-Normal");
                break;

                case 4:
                restaurante.mesa.get(i).data.get(j).getComanda_bebida().setValor(restaurante.mesa.get(i).data.get(j).getComanda_bebida().getValor()  + 4.90);
                restaurante.mesa.get(i).data.get(j).getComanda_bebida().consumo.add("Leite com Polvo Maltino");
                break;

                case 5:
                restaurante.mesa.get(i).data.get(j).getComanda_bebida().setValor(restaurante.mesa.get(i).data.get(j).getComanda_bebida().getValor()  + 3.00);
                restaurante.mesa.get(i).data.get(j).getComanda_bebida().consumo.add("Suco de Abaxaqui");
                break;

                case 6:
                restaurante.mesa.get(i).data.get(j).getComanda_bebida().setValor(restaurante.mesa.get(i).data.get(j).getComanda_bebida().getValor()  + 4.50);
                restaurante.mesa.get(i).data.get(j).getComanda_bebida().consumo.add("Suco de Frutas Críticas 300ml");
                break;

                case 7:
                restaurante.mesa.get(i).data.get(j).getComanda_bebida().setValor(restaurante.mesa.get(i).data.get(j).getComanda_bebida().getValor()  + 16.00);
                restaurante.mesa.get(i).data.get(j).getComanda_bebida().consumo.add("Leite de Amnésia");
                break;

                case 8:
                restaurante.mesa.get(i).data.get(j).getComanda_comida().setValor(restaurante.mesa.get(i).data.get(j).getComanda_comida().getValor()  + 28.00);
                restaurante.mesa.get(i).data.get(j).getComanda_comida().consumo.add("Filé Miau");
                break;

                case 9:
                restaurante.mesa.get(i).data.get(j).getComanda_comida().setValor(restaurante.mesa.get(i).data.get(j).getComanda_comida().getValor()  + 11.50);
                restaurante.mesa.get(i).data.get(j).getComanda_comida().consumo.add("Batata com molho Barbie Kill");
                break;

                case 10:
                restaurante.mesa.get(i).data.get(j).getComanda_comida().setValor(restaurante.mesa.get(i).data.get(j).getComanda_comida().getValor()  + 27.00);
                restaurante.mesa.get(i).data.get(j).getComanda_comida().consumo.add("Bife alí namesa");
                break;

                case 11:
                restaurante.mesa.get(i).data.get(j).getComanda_comida().setValor(restaurante.mesa.get(i).data.get(j).getComanda_comida().getValor()  + 15.50);
                restaurante.mesa.get(i).data.get(j).getComanda_comida().consumo.add("Macarrão ao alho e ódio");
                break;

                case 12:
                restaurante.mesa.get(i).data.get(j).getComanda_comida().setValor(restaurante.mesa.get(i).data.get(j).getComanda_comida().getValor()  + 10.00);
                restaurante.mesa.get(i).data.get(j).getComanda_comida().consumo.add("Feijão Torpedo");
                break;

                case 13:
                restaurante.mesa.get(i).data.get(j).getComanda_comida().setValor(restaurante.mesa.get(i).data.get(j).getComanda_comida().getValor()  + 10.00);
                restaurante.mesa.get(i).data.get(j).getComanda_comida().consumo.add("Arroz com carne morrida");
                break;

                case 14:
                restaurante.mesa.get(i).data.get(j).getComanda_comida().setValor(restaurante.mesa.get(i).data.get(j).getComanda_comida().getValor()  + 8.00);
                restaurante.mesa.get(i).data.get(j).getComanda_comida().consumo.add("X & Queique");
                break;

                case 15:
                System.out.println("*** Esgotado ***");
                break;

                case 16:
                restaurante.mesa.get(i).data.get(j).getComanda_comida().setValor(restaurante.mesa.get(i).data.get(j).getComanda_comida().getValor()  + 4.00);
                restaurante.mesa.get(i).data.get(j).getComanda_comida().consumo.add("Pudim de Leite Condenado");
                break;

                case 17:
                restaurante.mesa.get(i).data.get(j).getComanda_comida().setValor(restaurante.mesa.get(i).data.get(j).getComanda_comida().getValor()  + 13.00);
                restaurante.mesa.get(i).data.get(j).getComanda_comida().consumo.add("Pácomê");
                break;

                case 18:
                restaurante.mesa.get(i).data.get(j).getComanda_comida().setValor(restaurante.mesa.get(i).data.get(j).getComanda_comida().getValor()  + 2.50);
                restaurante.mesa.get(i).data.get(j).getComanda_comida().consumo.add("Sonho de Falsa");
                break;

                default:
                restaurante.mesa.get(i).data.get(j).getComanda_comida().setValor(restaurante.mesa.get(i).data.get(j).getComanda_comida().getValor()  + 34.69);
                restaurante.mesa.get(i).data.get(j).getComanda_comida().consumo.add("Especialidade do Chef");
                

            }
            pedidinho = scanf(); // // Escaneia novamente o item escolhido pelo cliente
            
        }
        System.out.println("\nObrigada por comprar no Buchinho Cheio!"); // Ao fim do pedido, agradece o cliente
    }

    // Divide a conta
    public void menu_dividir()
    {
        System.out.printf("\nPor favor, digite o número da sua mesa: ");
        int mesinha =  scanf(); // Escaneia a mesa do cliente
        int j = 0;
        if (this.restaurante.mesa_existe(mesinha, this.dia, this.mes)) // Se a mesa existir no dia de hoje, imprime o valor
        {
            while((this.restaurante.mesa.get(mesinha).data.get(j).getDia() != this.dia) || (this.restaurante.mesa.get(mesinha).data.get(j).getMes() != this.mes))
            {
                j++;
            }
            // O código acima procura na lista de datas, o dia de hoje
            System.out.println("Cada cliente da mesa deverá pagar R$" + ( this.restaurante.mesa.get(mesinha).data.get(j).getComanda_bebida().dividirConta(this.restaurante.mesa.get(mesinha).cliente.size()) + this.restaurante.mesa.get(mesinha).data.get(j).getComanda_comida().dividirConta(this.restaurante.mesa.get(mesinha).cliente.size()) ) + "0");
            // O código acima pega o valor da comanda de comida e bebida e divide pelo número de pessoas na mesa
        }
    }

    // Imprime a gorjeta estimada
    public void menu_10per()
    {
        System.out.printf("\nPor favor, digite o número da sua mesa: ");
        int mesinha = scanf(); // Escaneia a mesa do cliente
        if (this.restaurante.mesa_existe(mesinha, this.dia, this.mes))
        {
            int j = 0;
            while((this.restaurante.mesa.get(mesinha).data.get(j).getDia() != this.dia) || (this.restaurante.mesa.get(mesinha).data.get(j).getMes() != this.mes))
            {
                j++;
            }
            // O código acima procura na lista de datas, o dia de hoje
            System.out.println("A gorjeta estimada é de R$" + ( restaurante.mesa.get(mesinha).data.get(j).getComanda_bebida().calcular10Porcento() + restaurante.mesa.get(mesinha).data.get(j).getComanda_comida().calcular10Porcento() ) + "0");
             // O código acima pega 10% do valor da comanda de comida e soma com 10% do valor da comanda de bebida
        }
    }

    // Cadastra um cliente em uma mesa
    void menu_cadastra_cliente()
    {
        System.out.printf("\nPor favor, digite a mesa em que o cliente deve ser cadastrado: ");
        int mesinha = scanf(); // Escaneia a mesa do novo cliente
        if ((this.restaurante.getNumero_mesas() >= mesinha) && (mesinha > 0)) // Se a mesa existir no restaurante, cadastra o cliente
        {
            Cliente cl = new Cliente(); // Cria um novo objeto
            System.out.printf("\nPor favor, digite o nome do cliente: ");
            cl.setNome(esc.next()); // Escanei o nome do cliente
            System.out.printf("\nPor favor, digite o email do cliente: ");
            cl.setEmail(esc.next()); // Escaneia o email do cliente
            this.restaurante.mesa.get(mesinha).cliente.add(cl); // Faz com que o cliente da mesa aponte para o objeto criado
        }
        else
        {
            System.out.printf("\nMesa Inexistente;");
        }

    }

    // Lista o consumo da mesa
    void menu_listar()
    {
        System.out.printf("\nPor favor, digite o número da sua mesa: ");
        int mesinha =  scanf(); // Escaneia a mesa do novo cliente
        if (this.restaurante.mesa_existe(mesinha, this.dia, this.mes)) // Se a mesa existir no dia de hoje, imprime o consumo
        {
            int j = 0;
            while((this.restaurante.mesa.get(mesinha).data.get(j).getDia() != this.dia) || (this.restaurante.mesa.get(mesinha).data.get(j).getMes() != this.mes))
            {
                j++;
            }
            // O código acima procura na lista de datas, o dia de hoje
            System.out.println("----Lista de Bebidas----");
            restaurante.mesa.get(mesinha).data.get(j).getComanda_bebida().listarConsumo(); // Lista as bebidas escolhidas
            System.out.println("----Lista de Comidas----");
            restaurante.mesa.get(mesinha).data.get(j).getComanda_comida().listarConsumo(); // Lista as comidas escolhidas
            System.out.println("O valor a ser pago é R$" + ( restaurante.mesa.get(mesinha).data.get(j).getComanda_bebida().getValor() + restaurante.mesa.get(mesinha).data.get(j).getComanda_comida().getValor() ) + "0");
            // O código acima imprime o valor das comandas de bebida e comida somados
        }
    }

}

