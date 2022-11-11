package EL_MAIA;
import java.util.ArrayList;

public class Mesa 
{
    // Lista de Clientes
    ArrayList<Cliente> cliente = new ArrayList<Cliente>();

    // Variáveis
    private int numero_mesa;

    // Getters and Setters
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

    // Funções
    public boolean reservar(int res)
    {
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
            this.reserva = false;
            System.out.println("\n*** INVALIDO ***\n");
            return(false);
        }
    }
    
}
