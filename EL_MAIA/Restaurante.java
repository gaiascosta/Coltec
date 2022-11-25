import java.util.ArrayList;

public class Restaurante 
{
    //Lista de Mesas
    ArrayList<Mesa> mesa = new ArrayList<Mesa>();

    // Variáveis
    private String nome = "Buchinho Cheio";
    private String endereco = "Rua das Borboletas Psicodélicas";
    private int numero_mesas = 20;

    //Inicializando as Mesas
    public void inicializar_mesas()
    {
        for(int i = 0; i<this.numero_mesas; i++)
        {
            Mesa mesita = new Mesa();
            mesita.setNumero_mesa(i);
            this.mesa.add(mesita);
        }
    }
    
    // Getters and Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEsdereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // Funções
    boolean mesa_existe(int n_mesa, int dia, int mes)
    {

        for(int i = 0; i<mesa.size(); i++)
        {
            if ((this.mesa.get(i).getNumero_mesa() == n_mesa)&&(mesa.get(i).data_existe(dia, mes) == false))
            {
                return true;
            }
        }
        System.out.println("Mesa Inexistente ou sem reserva");
        return false;

    }
}

