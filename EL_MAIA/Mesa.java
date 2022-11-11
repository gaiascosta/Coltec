package EL_MAIA;
import java.util.Scanner;

public class Mesa 
{
    Scanner esc = new Scanner(System.in);
    private int numero_mesa;
    private String data;
    private boolean reserva;
    
    public boolean reservar()
    {
        System.out.printf("Deseja reservar a mesa " + numero_mesa + "? \n[0] Não\t[1] Sim\t: ");
        int res = esc.nextInt();
        
        if (res == 1)
        {
            if(this.reserva != true){
                this.reserva = true;
                return(true);
            } else{
                System.out.println("Esta mesa ja foi reservada :(");
                return(false);
            }
        }
        else if (res == 0)
        {
            this.reserva = false;
            return(false);
        }
        else 
        {
            System.out.println("\nINVALIDO\n");
            return(false);
        }
    }

    //Getters & Setters
    public int getNumero_mesa() {
        return numero_mesa;
    }
    public void setNumero_mesa(int numero_mesa) {
        this.numero_mesa = numero_mesa;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public boolean isReserva() {
        return reserva;
    }
    public void setReserva(boolean reserva) {
        this.reserva = reserva;
    }

}
