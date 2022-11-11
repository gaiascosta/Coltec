package EL_MAIA;

public class Mesa 
{
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

    public boolean reservar(boolean res)
    {
        if (res == true)
        {
            this.reserva = true;
            return (true);
        }
        else
        {
            this.reserva = false;
            return (false);
        }
    }
}
