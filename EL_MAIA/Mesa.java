package EL_MAIA;
import java.util.ArrayList;
import java.util.Scanner;

public class Mesa 
{
    // Lista de Clientes
    ArrayList<Cliente> cliente = new ArrayList<Cliente>();

    // Variáveis
    private int numero_mesa;
    private String data;
    private Comanda comanda = new Comanda();
    private boolean reserva;

    public Comanda getComanda() {
        return comanda;
    }
    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }
    // Getters and Setters
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

    // Funções
    public boolean reservar()
    {
        if (this.reserva == true)
        {
            return false;
        }
        else
        {
            this.reserva = true;
            return true;
        }
    }
}

