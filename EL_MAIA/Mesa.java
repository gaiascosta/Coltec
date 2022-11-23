package EL_MAIA;
import java.util.Scanner;
import java.util.ArrayList;

public class Mesa 
{
    // Lista de Clientes
    ArrayList<Cliente> cliente = new ArrayList<Cliente>();

    // Variáveis
    private int numero_mesa;
    private String data;
    private boolean reserva = false;

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
    public boolean reservar(int res)
    {
        Scanner esc = new Scanner(System.in);
        System.out.println("Digite o numero de pessoas: ");
        int nPessoas = esc.nextInt();
        Cliente cliente = new Cliente();

        if (res == 1)
        {
            this.reserva = true;
    
            for(int i = 0; i<nPessoas; i++){
                System.out.println("Digite o nome do" + (i+1) + "º cliente");
                cliente.setNome(esc.next());
                cliente.setEmail(esc.next());
                this.cliente.add(cliente);
            }
        return(true);

        }
        else if (res == 0)
        {
            this.reserva = false;
            return(false);
        }
        else 
        {
            this.reserva = false;
            System.out.println("\n*** INVALIDO ***\n");
            return(false);
        }
    }
    
}

