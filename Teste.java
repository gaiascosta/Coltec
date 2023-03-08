class Programa implements Runnable {

    private int id ;
    // colocar getter e setter pro atributo id
    public void run () {
        for (int i = 0; i < 10; i ++) 
        {
            System . out . println (" Programa " + id + " valor : " + i);
        }
    }

    public void setId(int newId)
    {
        this.id = newId;
    }
}

public class Teste {
    public static void main ( String [] args ) {
    
    Programa p1 = new Programa () ;
    p1 . setId (1) ;
    
    Thread t1 = new Thread ( p1 );
    t1 . start () ;
    
    Programa p2 = new Programa () ;
    p2 . setId (2) ;
    
    Thread t2 = new Thread ( p2 );
    t2 . start () ;
    
    }
}
