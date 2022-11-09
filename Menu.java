package PROVA;

import java.util.Scanner;

public class Menu 
{

    void imprime_menu()
    {
        System.out.println("\nDigite [0] para SAIR");
        System.out.println("Digite [1] para CADASTRAR USUARIO");
        System.out.println("Digite [2] para CADASTRAR FOTO");
        System.out.println("Digite [3] para LISTAR USUARIOS");
        System.out.println("Digite [4] para LISTAR PETS");
        System.out.println("Digite [5] para VER A QUANTIDADE DE USUARIOS CADASTRADOS");
        System.out.println("Digite [6] para VER A QUANTIDADE DE PETS CADASTRADOS");
        System.out.println("Digite [7] para ALTERAR A DESCRICAO DE UMA FOTO\n");
    }

    void opcoes(int escolha, InstaPet insta)
    {
        Scanner esquilo = new Scanner(System.in);

        if (escolha == 0)
        {
            System.exit(1);
        }

        else if(escolha == 1)
        {
            String nome, email;
            System.out.printf("> CADASTRAR USUARIO ");
            nome = esquilo.next();
            email = esquilo.next();
            insta.cadastra_usuario(nome, email);
        }

        else if(escolha == 2)
        {
            String email, link, desc;
            System.out.printf("> CADASTRAR FOTO ");
            email = esquilo.next();
            link = esquilo.next();
            desc = esquilo.next();

            insta.cadastra_foto(email, link, desc);
            
        }

        else if(escolha == 3)
        {
            System.out.printf("> LISTAR USUARIOS \n");
            insta.listar_usuarios();
        }

        else if(escolha == 4)
        {
            System.out.printf("> LISTAR PETS ");
            String email;
            email = esquilo.next();
            insta.listar_pets(email);
        }

        else if(escolha == 5)
        {
            System.out.printf("> QUANTIDADE USUARIOS \n");
            System.out.println(insta.qnt_usuario());
        }

        else if(escolha == 6)
        {
            String email;
            System.out.printf("> QUANTIDADE PETS ");
            email = esquilo.next();
            insta.qnt_pets(email);
        }

        else if(escolha == 7)
        {
            String email, desc;
            int n;
            System.out.printf("> ALTERAR DESCRICAO ");
            email = esquilo.next();
            n = esquilo.nextInt();
            desc = esquilo.next();
            insta.altera_descricao(email, n, desc);
        }

        else 
        {
            System.out.println("*** Entrada Invalida ***");
        }
    }

}
