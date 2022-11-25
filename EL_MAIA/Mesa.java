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

    // Funções
    public boolean data_existe(int dia, int mes)
    {
        for(int i = 0; i < this.data.size(); i++)
        {
            if ((dia == this.data.get(i).getDia()) && (mes == this.data.get(i).getMes()))
            {
                return true;
            }
        }

        System.out.println("Mesa inexistente ou não reservada; (Nosso restaurante é muito chique, só trabalhamos com reservas)");
        return false;
    }
    public boolean reservar(int dia, int mes)
    {

        int nClientes;

        //Inicializa o Scanner
        Scanner esc = new Scanner(System.in);

        System.out.printf("\nPor favor, digite a data para reserva da mesa " + this.numero_mesa + ": " );

        //Verifica se a mesa ja foi reservada para aquela data
        if (data_existe(dia, mes) == true)
        {
            esc.close();
            return false;
        }

        //Se a mesa não foi reservada:
        Data darita = new Data();
        darita.setDia(dia);
        darita.setMes(mes);

        System.out.printf("\nPor favor, digite o numero de clientes: ");
        nClientes = esc.nextInt();

        for(int i = 0; i<nClientes; i++){

            darita.setReserva(true);
            Cliente cl = new Cliente();
            System.out.printf("\nPor favor, digite o nome do cliente: ");
            cl.setNome(esc.next());
            System.out.printf("\nPor favor, digite o email do cliente: ");
            cl.setEmail(esc.next());
            this.cliente.add(cl);
                
        }

        this.data.add(darita);

        //Fecha o Scanner :)
        esc.close();
        return true;
    }

}

