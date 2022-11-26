import java.util.ArrayList;
import java.util.Scanner;

public class Mesa 
{
    // Variáveis
    private int numero_mesa;
    ArrayList<Cliente> cliente = new ArrayList<Cliente>();
    ArrayList<Data> data = new ArrayList<Data>();
    Menu menu = new Menu();

    // Getters and Setters
    public int getNumero_mesa() {
        return numero_mesa;
    }
    public void setNumero_mesa(int numero_mesa) {
        this.numero_mesa = numero_mesa;
    }

    // ----- Funções -----

    // Verifica se a data foi reservada 
    public boolean data_existe(int dia, int mes)
    {
        for(int i = 0; i < this.data.size(); i++) // Enquanto a lista de datas não chegar ao final, procura pela data
        {
            if ((dia == this.data.get(i).getDia()) && (mes == this.data.get(i).getMes()))
            {
                return true; // Se a data existir, retorna true
            }
        }
        return false; // Se a não data existir, retorna false
    }

    // Tenta reservar uma mesa
    public boolean reservar(int dia, int mes)
    {

        int nClientes;
        Scanner esc = new Scanner(System.in); // O Scanner não pode ser fechado

        //Verifica se a mesa ja foi reservada para aquela data
        if (data_existe(dia, mes) == true)
        {
            return false;
        }

        //Se a mesa não foi reservada:
        Data darita = new Data();
        darita.setDia(dia); // Reserva a mesa para o dia escolhido
        darita.setMes(mes); // Reserva a mesa para o mes escolhido
        darita.setReserva(true); // Cria um objeto

        System.out.printf("\nPor favor, digite o numero de clientes: ");
        nClientes = this.menu.scanf(); // Escaneia o número de clientes que a mesa terá

        while(nClientes == 0) // A mesa precisa ter pelo menos 1 cliente, então enquanto o numero de clientes for 0, continua com o scan
        {
            System.out.printf("\nUma mesa de cliente não pode ter 0 indivíduos, tente novamente;\n");
            System.out.printf("\nPor favor, digite o numero de clientes: ");
            nClientes = this.menu.scanf();
        }

        for(int i = 0; i<nClientes; i++)
        {
            Cliente cl = new Cliente(); // Cria outro objeto
            System.out.printf("\nPor favor, digite o nome do cliente: ");
            cl.setNome(esc.next()); // Escaneia o nome do cliente
            System.out.printf("\nPor favor, digite o email do cliente: ");
            cl.setEmail(esc.next()); // Escaneia o email do cliente
            this.cliente.add(cl); // Adiciona o objeto no cliente
        }

        this.data.add(darita); // // Adiciona o objeto em data

        return true;
    }

}

