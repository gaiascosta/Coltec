import java.util.Random;
import java.lang.Thread;

public class CorridaDeSapos {
    public static void main(String[] args) {
        int numSapos = 5; // número de sapos na corrida
        int distanciaCorrida = 100; // distância total da corrida em metros

        Sapo[] sapos = new Sapo[numSapos]; // array de sapos
        for (int i = 0; i < numSapos; i++) {
            sapos[i] = new Sapo("Sapo " + (i+1), distanciaCorrida); // criar novo sapo
            sapos[i].start(); // iniciar thread do sapo
        }

        // esperar até que todos os sapos tenham terminado a corrida
        for (int i = 0; i < numSapos; i++) {
            try {
                sapos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // imprimir resultado da corrida
        System.out.println("Resultado da corrida:");
        for (int i = 0; i < numSapos; i++) {
            System.out.println(sapos[i].getNome() + " chegou em " + sapos[i].getPosicao() + "º lugar");
        }
    }
}

class Sapo extends Thread {
    private String nome;
    private int distanciaCorrida;
    private int posicao;

    public Sapo(String nome, int distanciaCorrida) {
        this.nome = nome;
        this.distanciaCorrida = distanciaCorrida;
        this.posicao = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getPosicao() {
        return posicao;
    }

    public void run() {
        Random random = new Random();
        while (posicao < distanciaCorrida) {
            int salto = random.nextInt(10); // saltar entre 0 e 9 metros
            posicao += salto;
            System.out.println(nome + " saltou " + salto + " metros e está na posição " + posicao);
            try {
                Thread.sleep(100); // esperar um pouco entre saltos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}