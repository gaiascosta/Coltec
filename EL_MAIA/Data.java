import java.util.ArrayList;

public class Data 
{
    private boolean reserva;
    public boolean isReserva() {
        return reserva;
    }
    public void setReserva(boolean reserva) {
        this.reserva = reserva;
    }
    private String dataReserva;
    public String getDataReserva() {
        return dataReserva;
    }
    public void setDataReserva(String dataReserva) {
        this.dataReserva = dataReserva;
    }
    Comanda comanda = new Comanda();
}
