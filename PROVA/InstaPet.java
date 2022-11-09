// Nome: Gabriela Souza Gomes da Costa
// Data: 26/10/2022
// PROVA AEDS

package PROVA;

public class InstaPet 
{

    Usuario usr[] = new Usuario[20];
    private static int quantidade_usu = 0;
   
    public static int getQuantidade_usu() {
        return quantidade_usu;
    }
    public static void setQuantidade_usu(int quantidade_usu) {
        InstaPet.quantidade_usu = quantidade_usu;
    }
    void cadastra_usuario(String nome, String email)
    {
        Usuario novoUsr = new Usuario();
        novoUsr.setNome(nome);
        novoUsr.setEmail(email);
        this.usr[InstaPet.quantidade_usu] = novoUsr;
        InstaPet.quantidade_usu++;
    }
    void cadastra_foto(String email, String link, String desc)
    {
        int j; Boolean existe = false;
        for (j = 0; j < InstaPet.getQuantidade_usu(); j++)
        {
            if(this.usr[j].getEmail().equals(email))
            {
                this.usr[j].cadastra_foto(link, desc);
                existe = true;
            }
        }
        if ((j == InstaPet.getQuantidade_usu()) && (existe == false))
        {
            System.out.println("Email Inexistente;");
        }
    }

    // Quantidade
    
    int qnt_pets(String email)
    {
        int j = 0;
        for (j = 0; j < InstaPet.quantidade_usu; j++)
        {
            if (this.usr[j].getEmail().equals(email))
            {
                System.out.println(this.usr[j].getQuantidade_pet());
                return this.usr[j].getQuantidade_pet();
            }
            
        }
        if (j == InstaPet.quantidade_usu)
        {
            System.out.println("Email Inexistente;");
        }
        return 0;
    }
    int qnt_usuario()
    {
        return InstaPet.quantidade_usu;
    }

    // Tudo certo até aqui


    
    void listar_pets(String email)
    {
        int j = 0, i = 0; boolean existe = false;
        System.out.printf("\n");
        for (j = 0; j < InstaPet.quantidade_usu; j++)
        {
            if (this.usr[j].getEmail().equals(email))
            {
                for (i = 0; i < this.usr[j].getQuantidade_pet(); i++)
                {
                    System.out.println(this.usr[j].ftt[i].getUrl() + " - " + this.usr[j].ftt[i].getDescricao());
                }
                existe = true;
            }
        }
        if ((j == InstaPet.quantidade_usu) && (i == 0) && (existe == false))
        {
            System.out.println("Email Inexistente;");
            
        }
        else if ((j == InstaPet.quantidade_usu) && (i == 0) && (existe = true))
        {
            System.out.println("Nenhuma foto cadastrada;");
            
        }
    }

    Usuario[] listar_usuarios()
    {
        for (int i = 0; i < InstaPet.quantidade_usu; i++)
        {
            System.out.println(this.usr[i].getNome() + " - " + this.usr[i].getEmail());
        }

        return this.usr;
    }

    // Deu certo esse de baixo também

    void altera_descricao(String email, int n, String desc)
    {
        int j = 0; boolean existe = false;
        for (j = 0; j < InstaPet.quantidade_usu; j++)
        {
            if (this.usr[j].getEmail().equals(email))
            {
                this.usr[j].altera_descricao(n, desc);
                existe = true;
            }
            
        }
        if ((j == InstaPet.quantidade_usu) && (existe == false))
        {
            System.out.println("Email Inexistente;");
        }
    }
    
}
