import java.util.ArrayList;
import java.util.Scanner;

public class Mesa 
{
    // Lista de Clientes
    ArrayList<Cliente> cliente = new ArrayList<Cliente>();
    //Lista de Datas para a reserva de uma mesa
    ArrayList<Data> data = new ArrayList<Data>();

    // Variáveis
    private int numero_mesa;
    // Getters and Setters

    public int getNumero_mesa() {
        return numero_mesa;
    }
    public void setNumero_mesa(int numero_mesa) {
        this.numero_mesa = numero_mesa;
    }


    //Verifica se a mesa foi reservada para uma determinada data
    public boolean isReserva(String dataReserva) {

        for(int i = 0; i<data.size(); i++){
            if(this.data.get(i).getDataReserva() == dataReserva){
                return true;
            }
        }
        return false;
    }
    // Funções
    public boolean reservar()
    {

        int nClientes;

        //Inicializa o Scanner
        Scanner esc = new Scanner(System.in);

        System.out.printf("\nPor favor, digite a data para reserva da mesa " + this.numero_mesa + ": " );

        String dataReserva = esc.next();
        int j;

        //Verifica se a mesa ja foi reservada para aquela data
        for(int i = 0; i<data.size(); i++){
            if(this.data.get(i).getDataReserva() == dataReserva){
                esc.close();
                return false;
            }
            j = i;
        }

        //Se a mesa não foi reservada:
        this.data.get(j).setDataReserva(dataReserva);

        System.out.printf("\nPor favor, digite o numero de clientes: ");
        nClientes = esc.nextInt();

        for(int i = 0; i<nClientes; i++){

            this.data.get(j).setReserva(true);
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

