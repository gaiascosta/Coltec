import java.util.Random;

public class Sapos extends Thread
{
    private String nome;
    public String getNome() 
    {
        return nome;
    }
    public void setNome(String nome) 
    {
        this.nome = nome;
    }


    private int distancia_percorrida;
    private int tamanho_corrida;
    private int max_pulo = 10;

    public void getTamanho_Corrida(int Tamanho_Corrida)
    {
        this.tamanho_corrida = Tamanho_Corrida;
    }


    public void run()
    {
        Random rand = new Random();
        while(distancia_percorrida < tamanho_corrida)
        {
            int tamanho_pulo = rand.nextInt(max_pulo);
            distancia_percorrida += tamanho_pulo;
            System.out.println("O " + nome + " pulou " + tamanho_pulo + " metros e chegou na posição " + distancia_percorrida);
            try{
                Thread.sleep(200); // esperar um pouco entre saltos
            } catch (InterruptedException e) {}
        }
    }
}
