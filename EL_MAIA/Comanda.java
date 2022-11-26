////// NÃO USE ESSA COMANDA ////////////

import java.util.ArrayList;

public class Comanda 
{
    // Variáveis
    private double valor;
    ArrayList<String> consumo = new ArrayList<String>();

    //Getters & Setters
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    // ----- Funções ------

    // Imprime os itens da lista de consumo
    public void listarConsumo()
    {
        int i = 0;
        while (i < this.consumo.size())
        {
            System.out.println(i+1 + "° - " + this.consumo.get(i));
            i++;
        }
    }

    // Calcula 10% das comanda
    public double calcular10Porcento()
    {
        return(this.valor*0.10);
    }

    // Divide o valor da conta pelo número de pessoas
    public double dividirConta(int nPessoas)
    {
        return(this.valor/nPessoas);
    }

    //Adiciona um item na lista de consumo
    public void addItem(String Item){
        this.consumo.add(Item);
    }

}

