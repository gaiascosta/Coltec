package EL_MAIA;

public class Restaurante 
{
    //Lista de Mesas
    ArrayList<Mesa> mesa = new ArrayList<Mesa>();

    // Variáveis
    private String nome;
    private String esdereco;
    
    // Getters and Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEsdereco() {
        return esdereco;
    }
    public void setEndereco(String esdereco) {
        this.esdereco = esdereco;
    }
}
