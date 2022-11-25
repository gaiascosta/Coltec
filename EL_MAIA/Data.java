public class Data 
{   
    private Comanda comanda = new Comanda();
    private boolean reserva;
    private String dataReserva;

    //Getters & Setters
    public boolean isReserva() {
        return reserva;
    }
    public void setReserva(boolean reserva) {
        this.reserva = reserva;
    }
    public String getDataReserva() {
        return dataReserva;
    }
    public void setDataReserva(String dataReserva) {
        this.dataReserva = dataReserva;
    }
    public Comanda getComanda(){
        return comanda;
    }
}
