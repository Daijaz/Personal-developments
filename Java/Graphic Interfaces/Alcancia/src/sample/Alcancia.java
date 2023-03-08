package sample;

public class Alcancia {
    private int numeroMoneda50;
    private int numeroMoneda100;
    private int numeroMoneda200;
    private int numeroMoneda500;
    private int numeroMoneda1000;
    private int estado;
    private double intereses1000;
    private double intereses50;


    public Alcancia() {
        numeroMoneda50 = 0;
        numeroMoneda100 = 0;
        numeroMoneda200 = 0;
        numeroMoneda500 = 0;
        numeroMoneda1000 = 0;
        intereses1000 = 0;
        intereses50 = 0;

    }

    public int darNumeroMonedas50() {
        return numeroMoneda50;
    }

    public int darNumeroMonedas100() {
        return numeroMoneda100;
    }

    public int darNumeroMonedas200() {
        return numeroMoneda200;
    }

    public int darNumeroMonedas500() {
        return numeroMoneda500;
    }

    public int darNumeroMonedas1000() {
        return numeroMoneda1000;
    }

    public int darEstado() {
        return estado;
    }

    public void agregarMoneda50() {
        numeroMoneda50 = numeroMoneda50 + 1;
        intereses50 = intereses50+ ((numeroMoneda50 * 50)*0.001);
    }

    public void agregarMoneda100() {
        numeroMoneda100 = numeroMoneda100 + 1;
    }

    public void agregarMoneda200() {
        numeroMoneda200 = numeroMoneda200 + 1;
    }

    public void agregarMoneda500() {
        numeroMoneda500 = numeroMoneda500 + 1;
    }

    public void agregarMoneda1000() {
        numeroMoneda1000 = numeroMoneda1000 + 1;
        intereses1000 = intereses1000+((numeroMoneda1000 * 1000)*0.3);





    }

    public double calcularTotalDinero() {

        return numeroMoneda1000 * 1000 + numeroMoneda500 * 500 + numeroMoneda200 * 200 + numeroMoneda100 * 100 + numeroMoneda50 * 50;
    }

    public String valorTotalIntereses (){
        double valor = intereses1000 + intereses50;
        return "EL total de los intereses \n " + " es igual a "+valor;
    }
    public String valorTotalAhorrado (){
        double valor2 = numeroMoneda1000 * 1000 +intereses1000  + numeroMoneda500 * 500 + numeroMoneda200 * 200 + numeroMoneda100 * 100 + numeroMoneda50 * 50 - intereses50;
        return "El total de dinero ahorrado en \n" + " la alcancia es igual a "+valor2;
    }

    public String darEstadoAlcancia(){
        double totalDinero = calcularTotalDinero();
        return "La alcancia tenia: \n " + numeroMoneda50 + " monedas de $50 \n " + numeroMoneda100 + " monedas de $100 \n "+ numeroMoneda200 + " monedas de $200 \n " + numeroMoneda500 + " monedas de $500 \n" + numeroMoneda1000 + " monedas de $1000 \n" + " Para un total de $" +totalDinero+ " pesos.";
    }


    public void romperAlcancia() {
        estado=1;
    }


}
