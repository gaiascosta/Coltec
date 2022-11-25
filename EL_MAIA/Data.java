public class Data 
{
    private boolean datinha;
    public boolean isDatinha() {
        return datinha;
    }
    public void setDatinha(boolean datinha) {
        this.datinha = datinha;
    }
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
