class Trabalhador extends Thread 
{
    String produto;
    int tempo;
    public Trabalhador ( String produto , int tempo ) {
        this . produto = produto ;
        this . tempo = tempo ;
    }

    public void run () {
        for (int i = 0; i < 50; i ++) 
        {
            System . out . println (i + " " + produto );
            try 
            {
                sleep (( long ) ( Math . random () * tempo )) ;
            } 
            catch ( InterruptedException e) {}
        }
        System . out . println (" Terminei " + produto ) ;
    }
}
