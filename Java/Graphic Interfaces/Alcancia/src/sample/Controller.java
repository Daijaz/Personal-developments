package sample;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javax.swing.*;

public class Controller {


    public Label lbl50;
    public Label lbl100;
    public Label lbl200;
    public Label lbl500;
    public Label lbl1000;
    public Button btn50;
    public Button btn100;
    public Button btn200;
    public Button btn500;
    public Button btn1000;
    public Label lbl_estado;
    public Pane panel_alcancia;
    public Pane panel_alcanciarota;
    public Button btnnueva;
    public Button btn_martillo;


    private Alcancia alcancia;

    public Controller() {


    }

    public void btn_nueva_click(ActionEvent actionEvent) {
        inicializar();
    }
    public void inicializar(){
        //instancia la clase
        alcancia = new Alcancia();
        lbl50.setText("" + alcancia.darNumeroMonedas50());
        lbl100.setText("" + alcancia.darNumeroMonedas100());
        lbl200.setText("" + alcancia.darNumeroMonedas200());
        lbl500.setText("" + alcancia.darNumeroMonedas500());
        lbl1000.setText("" + alcancia.darNumeroMonedas1000());
        panel_alcancia.setVisible(true);
        panel_alcanciarota.setVisible(false);
        lbl_estado.setText("Alcancia Vacia");
        btnnueva.setDisable(true);
        btn_martillo.setDisable(false);
        habilitar_monedas();

    }

    public void btn50_click(ActionEvent actionEvent) {
        alcancia.agregarMoneda50();
        lbl50.setText("" + alcancia.darNumeroMonedas50());
        lbl_estado.setText("Alcancia Llena");
        alcancia.romperAlcancia();

    }

    public void btn100_click(ActionEvent actionEvent) {
        alcancia.agregarMoneda100();
        lbl100.setText("" + alcancia.darNumeroMonedas100());
        lbl_estado.setText("Alcancia Llena");
        alcancia.romperAlcancia();

    }

    public void btn200_click(ActionEvent actionEvent) {
        alcancia.agregarMoneda200();
        lbl200.setText("" + alcancia.darNumeroMonedas200());
        lbl_estado.setText("Alcancia Llena");
        alcancia.romperAlcancia();
    }

    public void btn500_click(ActionEvent actionEvent) {
        alcancia.agregarMoneda500();
        lbl500.setText("" + alcancia.darNumeroMonedas500());
        lbl_estado.setText("Alcancia Llena");
        alcancia.romperAlcancia();

    }

    public void btn1000_click(ActionEvent actionEvent) {
        alcancia.agregarMoneda1000();
        lbl1000.setText("" + alcancia.darNumeroMonedas1000());
        lbl_estado.setText("Alcancia Llena");
        alcancia.romperAlcancia();
    }

    public void habilitar_monedas() {
        btn50.setDisable(false);
        btn100.setDisable(false);
        btn200.setDisable(false);
        btn500.setDisable(false);
        btn1000.setDisable(false);
    }

    public void btn_martillo_click(ActionEvent actionEvent) {
        if (alcancia.darEstado()==0){
            panel_alcancia.setVisible(true);
            panel_alcanciarota.setVisible(false);
            lbl_estado.setText("Alcancia Vacia");
        }else{
            panel_alcancia.setVisible(false);
            panel_alcanciarota.setVisible(true);
            lbl_estado.setText("Alcancia Rota");
            String mensaje = alcancia.darEstadoAlcancia();
            JOptionPane.showMessageDialog(null,mensaje, "Ahorro", JOptionPane.INFORMATION_MESSAGE);
            btnnueva.setDisable(false);


        }
    }

    public void btn_metodo1_click(ActionEvent actionEvent) {
        String mensaje = alcancia.valorTotalIntereses();
        JOptionPane.showMessageDialog(null,mensaje, "Interes", JOptionPane.INFORMATION_MESSAGE);

    }

    public void btn_metodo2_click(ActionEvent actionEvent) {
        String mensaje = alcancia.valorTotalAhorrado();
        JOptionPane.showMessageDialog(null,mensaje, "Ahorro", JOptionPane.INFORMATION_MESSAGE);

    }
}