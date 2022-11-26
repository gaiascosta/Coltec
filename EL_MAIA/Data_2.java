public class Data 
{
    //Variáveis
    private boolean reserva;
    private int dia;
    private int mes;
    private Comanda comanda_bebida = new Comanda();
    private Comanda comanda_comida = new Comanda();

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
    public Comanda getComanda_bebida() {
        return comanda_bebida;
    }
    public void setComanda_bebida(Comanda comanda_bebida) {
        this.comanda_bebida = comanda_bebida;
    }
    public Comanda getComanda_comida() {
        return comanda_comida;
    }
    public void setComanda_comida(Comanda comanda_comida) {
        this.comanda_comida = comanda_comida;
    }
}
