// Nome: Gabriela Souza Gomes da Costa
// Data: 26/10/2022
// PROVA AEDS

package PROVA;

public class Usuario 
{
    private int quantidade_pet = 0;
    public int getQuantidade_pet() {
        return this.quantidade_pet;
    }
    public void setQuantidade_pet(int quantidade_pet) {
        this.quantidade_pet = quantidade_pet;
    }


    private String nome;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }


    private String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    Fotos[] ftt = new Fotos[5];


    void cadastra_foto(String link, String desc)
    {
        Fotos foto = new Fotos();
        foto.setUrl(link);
        foto.setDescricao(desc);
        this.ftt[this.quantidade_pet] = foto;
        this.quantidade_pet++;
    }

    void altera_descricao(int n, String desc)
    {
        if (n < this.quantidade_pet)
        {
            this.ftt[n].setDescricao(desc);
        }
        else
        {
            System.out.println("Numero Invalido;");
        }
    }
}
