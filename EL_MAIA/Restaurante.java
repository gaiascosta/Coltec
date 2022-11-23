package EL_MAIA;
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
            Mesa mesa = new Mesa();
            mesa.setNumero_mesa(i);
            this.mesa.add(mesa);
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
    boolean mesa_existe(int n_mesa)
    {
        int i = 0;
        while(i < this.mesa.size())
        {
            if (this.mesa.get(i).getNumero_mesa() == n_mesa)
            {
                break;
            }
            i++;
        }
        if (i == this.mesa.size())
        {
            System.out.println("Mesa Inexistente");
            return false;
        }
        else 
        {
            return true;
        }
    }
}
