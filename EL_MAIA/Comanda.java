package EL_MAIA;
import java.util.ArrayList;

public class Comanda {

    private double valor;

    // Lista de consumo
    ArrayList<String> consumo = new ArrayList<>();

    // Funções
    void listarConsumo(String consumo){

        System.out.println(" --- Lista de Consumo --- ");

        System.out.println(consumo);


    }

    double calcular10Porcento(double valor){
        return(valor*0.10);
    }

    double dividirConta(double valor, int nPessoas){
        return(valor/nPessoas);
    }

    //Getters & Setters
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public void addItem(String Item){
        this.consumo.add(Item);
    }

}

