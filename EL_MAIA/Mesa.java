package EL_MAIA;
import java.util.ArrayList;
import java.util.Scanner;

public class Mesa 
{
    // Lista de Clientes
    ArrayList<Cliente> cliente = new ArrayList<Cliente>();
    //Lista de Datas para a reserva de uma mesa
    ArrayList<String> data = new ArrayList<String>();

    // Variáveis
    private int numero_mesa;
    private Comanda comanda = new Comanda();
    private boolean reserva = false;

    // Getters and Setters

    public Comanda getComanda() {
        return comanda;
    }
    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }
    public int getNumero_mesa() {
        return numero_mesa;
    }
    public void setNumero_mesa(int numero_mesa) {
        this.numero_mesa = numero_mesa;
    }


    //Verifica se a mesa foi reservada para uma determinada data
    public boolean isReserva(String dataReserva) {

        for(int i = 0; i<data.size(); i++){
            if(this.data.get(i) == dataReserva){
                return true;
            }
        }
        return false;
    }


    public void setReserva(boolean reserva) {
        this.reserva = reserva;
    }

    // Funções
    public boolean reservar()
    {

        int nClientes;

        //Inicializa o Scanner
        Scanner esc = new Scanner(System.in);

        System.out.printf("\nPor favor, digite a data para reserva da mesa " + this.numero_mesa + ": " );

        String dataReserva = esc.next();

        //Verifica se a mesa ja foi reservada para aquela data
        for(int i = 0; i<data.size(); i++){
            if(this.data.get(i) == dataReserva){
                esc.close();
                return false;
            }
        }

        //Se a mesa não foi reservada:
        this.data.add(dataReserva);

        System.out.printf("\nPor favor, digite o numero de clientes: ");
        nClientes = esc.nextInt();

        for(int i = 0; i<nClientes; i++){

            this.reserva = true;
            Cliente cl = new Cliente();
            System.out.printf("\nPor favor, digite o nome do cliente: ");
            cl.setNome(esc.next());
            System.out.printf("\nPor favor, digite o email do cliente: ");
            cl.setEmail(esc.next());
            this.cliente.add(cl);
                
        }

        //Fecha o Scanner :)
        esc.close();
        return true;
    }

}

