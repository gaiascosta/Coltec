public class CorridaDeSapos 
{
    public static void main(String[]args)
    {
        int distancia_corrida = 100, num_sapos = 5;
        Sapos[] sapo = new Sapos[num_sapos];

        for(int i = 0; i < num_sapos; i++)
        {
            sapo[i] = new Sapos();
            sapo[i].setNome("Sapo " + (i+1));
            sapo[i].getTamanho_Corrida(distancia_corrida);
            sapo[i].start();
        }
        int i = 0;
        while(i < num_sapos)
        {
            System.out.println("O " + sapo[i].getNome() + "percorreu " + sapo.[i].getPosicao + " metros");
            if (sapo[i].isAlive() == false)
            {
                i++;
            }
        }
        
    }
}

