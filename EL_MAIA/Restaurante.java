import java.util.ArrayList;

public class Restaurante 
{
    // Variáveis
    private String nome = "Buchinho Cheio";
    private String endereco = "Rua das Borboletas Psicodélicas";
    private int numero_mesas = 20;
    ArrayList<Mesa> mesa = new ArrayList<Mesa>();

    // Getters & Setters
    public int getNumero_mesas() {
        return numero_mesas;
    }
    public void setNumero_mesas(int numero_mesas) {
        this.numero_mesas = numero_mesas;
    }
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

    // ----- Funções -----

    //Inicializando as Mesas
    public void inicializar_mesas()
    {
        // Inicializando a data 0
        Data darita = new Data();
        darita.setDia(0);
        darita.setMes(0);

        for(int i = 0; i<this.numero_mesas; i++) // Continua enquanto i for menor que o número de mesas do restaurante
        {
            Mesa mesita = new Mesa(); // Cria um objeto
            mesita.setNumero_mesa(i);
            mesita.data.add(darita);
            this.mesa.add(mesita); // Adiciona o objeto em mesa
        }
    }
    
    public boolean mesa_existe(int n_mesa, int dia, int mes) // Verifica se a mesa existe
    {
        for(int i = 0; i<mesa.size(); i++) // Continua enquanto i for menor que o número de mesas da lista
        {
            // O código abaixo anda pelas mesas verificando se elas existem e se tem reserva na data
            if ((this.mesa.get(i).getNumero_mesa() == n_mesa)&&(mesa.get(i).data_existe(dia, mes) == true)) 
            {
                return true; // Caso a mesa exista e tenha reserva no dia, retorna true
            }
        }
        System.out.println("Mesa Inexistente ou sem reserva");
        return false; // Caso a mesa não exista ou nõa tenha reserva no dia, retorna false

    }
}

