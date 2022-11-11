package EL_MAIA;
import java.util.Scanner;

public class Mesa 
{
    Scanner esc = new Scanner(System.in);
    private int numero_mesa;
    public int getNumero_mesa() {
        return numero_mesa;
    }
    public void setNumero_mesa(int numero_mesa) {
        this.numero_mesa = numero_mesa;
    }
    private String data;
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    private boolean reserva;
    public boolean isReserva() {
        return reserva;
    }
    public void setReserva(boolean reserva) {
        this.reserva = reserva;
    }

    public boolean reservar()
    {
        System.out.printf("Deseja fazer uma reserva? \n[0] Não\t[1] Sim\t: ");
        int res = esc.nextInt();
        if (res == 1)
        {
            this.reserva = true;
            return(true);
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
}
