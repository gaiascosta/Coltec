package Elmaia;

public class Comanda {

    private String consumo;
    private double valor;


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
    public String getConsumo() {
        return consumo;
    }
    
    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }
    
}
