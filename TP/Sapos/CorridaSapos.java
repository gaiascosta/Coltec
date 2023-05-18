public class CorridaSapos 
{
    public static void main(String[]args)
    {
        int distancia_corrida = 100, num_sapos = 5;
        Sapos[] sapo = new Sapos[num_sapos];

        for(int i = 0; i < num_sapos; i++)
        {
            sapo[i].getTamanho_Corrida(distancia_corrida);
            sapo[i].start();
        }

    }
}


