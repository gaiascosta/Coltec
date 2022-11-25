public class Data 
{
    //Variáveis
    private boolean reserva;
    private int dia;
    private int mes;
    Comanda comanda_bebida = new Comanda();
    Comanda comanda_comida = new Comanda();

    //Getters and Setters
    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }
    public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }
    public boolean isReserva() {
        return reserva;
    }
    public void setReserva(boolean reserva) {
        this.reserva = reserva;
    }
}
