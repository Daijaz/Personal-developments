package sample;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    //TextField para Candidato 1
    public TextField txtnombre1;
    public TextField txtedad1;
    public TextField txtpartido1;
    public TextField txtcampanha1;
    public TextField txtvotos1;
    public TextField txtporcentaje1;
    public TextField txtrango1;

    //TextField para Candidato 2
    public TextField txtnombre2;
    public TextField txtedad2;
    public TextField txtpartido2;
    public TextField txtcampanha2;
    public TextField txtvotos2;
    public TextField txtporcentaje2;
    public TextField txtrango2;

    //TextField para Candidato 3
    public TextField txtnombre3;
    public TextField txtedad3;
    public TextField txtpartido3;
    public TextField txtcampanha3;
    public TextField txtvotos3;
    public TextField txtporcentaje3;
    public TextField txtrango3;

    // Panes de los candidatos

    public Pane Pane_1;
    public Pane Pane_2;
    public Pane Pane_3;
    public Pane Pane_4;
    

    public CategoryAxis xGenero = new CategoryAxis() ;
    public NumberAxis xRango = new NumberAxis();
    public BarChart <String,Number>Votacion_genero = new BarChart<String, Number>(xGenero,xRango);



    //Botones para el candidato 1
    //Botones para el candidato 2
    //Botones para el candidato 1



    //Clase principal del mundo
    private Urna urna;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("¡Ya puede ver la interfaz!");
        inicializar();
    }

    public void inicializar() {
        urna = new Urna();

        //Textos para el candidato 1
        txtnombre1.setText(urna.darCandidato1().darNombre()+" "+urna.darCandidato1().darApellido());
        txtedad1.setText(""+urna.darCandidato1().darEdad());
        txtpartido1.setText(urna.darCandidato1().darPartidoPolitico());
        txtcampanha1.setText(""+urna.darCandidato1().darCostoCampanha());
        txtvotos1.setText(urna.darCandidato1().darCantidadTotalVotos()+"");
        txtporcentaje1.setText(""+urna.calcularPorcentajeVotosCandidato(1));
        txtrango1.setText(""+urna.darCandidato1().darVotosRango1());


        //Textos para el candidato 2
        txtnombre2.setText(urna.darCandidato2().darNombre()+" "+urna.darCandidato2().darApellido());
        txtedad2.setText(""+urna.darCandidato2().darEdad());
        txtpartido2.setText(urna.darCandidato2().darPartidoPolitico());
        txtcampanha2.setText(""+urna.darCandidato2().darCostoCampanha());
        txtvotos2.setText(""+urna.darCandidato2().darCantidadTotalVotos());
        txtporcentaje2.setText(""+urna.calcularPorcentajeVotosCandidato(2));
        txtrango2.setText(""+urna.darCandidato2().darVotosRango2());


        //Textos para el candidato 3
        txtnombre3.setText(urna.darCandidato3().darNombre()+" "+urna.darCandidato3().darApellido());
        txtedad3.setText(""+urna.darCandidato3().darEdad());
        txtpartido3.setText(urna.darCandidato3().darPartidoPolitico());
        txtcampanha3.setText(""+urna.darCandidato3().darCostoCampanha());
        txtvotos3.setText(""+urna.darCandidato3().darCantidadTotalVotos());
        txtporcentaje3.setText(""+urna.calcularPorcentajeVotosCandidato(3));
        txtrango3.setText(""+urna.darCandidato3().darVotosRango3());
    }


    public void btn_votar1_click(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(null,"Este botón le mostrará unos campos para rellenar, los cuales son: Su edad, género y medio donde vió el candidato.\n Cada palabra que usted escriba deberá empezar con letra mayúscula. Ejemplos: Masculino, Femenino, Television, Internet, Radio.","Instrucciones",JOptionPane.INFORMATION_MESSAGE);
        String strEdad = JOptionPane.showInputDialog(null,"Digite su edad","Edad",JOptionPane.QUESTION_MESSAGE);
        String strGenero = JOptionPane.showInputDialog(null,"¿Cuál es su género?","Genero",JOptionPane.QUESTION_MESSAGE);
        String strMedio = JOptionPane.showInputDialog(null,"¿En qué medio vió al candidato?","Medio",JOptionPane.QUESTION_MESSAGE);

        if ( strEdad != null && strGenero != null && strMedio != null){

            int edad = Integer.parseInt(strEdad);

            if (edad >= 0 && edad <=17){

                if (strGenero.equals("Masculino")){

                    if (strMedio.equals("Television")){
                        urna.registrarVoto(1, VotosRangoEdad.Edad.EDAD_JOVEN, VotosRangoEdad.Genero.MASCULINO, Candidato.Medio.TELEVISION);
                        txtvotos1.setText(urna.darCandidato1().darCantidadTotalVotos()+"");
                        txtcampanha1.setText(""+urna.darCandidato1().darCostoCampanha());
                        txtporcentaje1.setText(""+urna.calcularPorcentajeVotosCandidato(1));
                        txtrango1.setText(""+urna.darCandidato1().darVotosRango1());
                    }else{
                        if (strMedio.equals("Radio")){
                            urna.registrarVoto(1, VotosRangoEdad.Edad.EDAD_JOVEN, VotosRangoEdad.Genero.MASCULINO, Candidato.Medio.RADIO);
                            txtvotos1.setText(urna.darCandidato1().darCantidadTotalVotos()+"");
                            txtcampanha1.setText(""+urna.darCandidato1().darCostoCampanha());
                            txtporcentaje1.setText(""+urna.calcularPorcentajeVotosCandidato(1));
                            txtrango1.setText(""+urna.darCandidato1().darVotosRango1());
                        }else{
                            if (strMedio.equals("Internet")){
                                urna.registrarVoto(1, VotosRangoEdad.Edad.EDAD_JOVEN, VotosRangoEdad.Genero.MASCULINO, Candidato.Medio.INTERNET);
                                txtvotos1.setText(urna.darCandidato1().darCantidadTotalVotos()+"");
                                txtcampanha1.setText(""+urna.darCandidato1().darCostoCampanha());
                                txtporcentaje1.setText(""+urna.calcularPorcentajeVotosCandidato(1));
                                txtrango1.setText(""+urna.darCandidato1().darVotosRango1());
                            }else{
                                JOptionPane.showMessageDialog(null,"La palabra ingresada no es válida");
                                System.exit(0);
                            }
                        }

                    }
                }else{
                    if (strGenero.equals("Femenino")){
                        if (strMedio.equals("Television")){
                            urna.registrarVoto(1, VotosRangoEdad.Edad.EDAD_JOVEN, VotosRangoEdad.Genero.FEMENINO, Candidato.Medio.TELEVISION);
                            txtvotos1.setText(urna.darCandidato1().darCantidadTotalVotos()+"");
                            txtcampanha1.setText(""+urna.darCandidato1().darCostoCampanha());
                            txtporcentaje1.setText(""+urna.calcularPorcentajeVotosCandidato(1));
                            txtrango1.setText(""+urna.darCandidato1().darVotosRango1());
                        }else{
                            if (strMedio.equals("Radio")){
                                urna.registrarVoto(1, VotosRangoEdad.Edad.EDAD_JOVEN, VotosRangoEdad.Genero.FEMENINO, Candidato.Medio.RADIO);
                                txtvotos1.setText(urna.darCandidato1().darCantidadTotalVotos()+"");
                                txtcampanha1.setText(""+urna.darCandidato1().darCostoCampanha());
                                txtporcentaje1.setText(""+urna.calcularPorcentajeVotosCandidato(1));
                                txtrango1.setText(""+urna.darCandidato1().darVotosRango1());
                            }else{
                                if (strMedio.equals("Internet")){
                                    urna.registrarVoto(1, VotosRangoEdad.Edad.EDAD_JOVEN, VotosRangoEdad.Genero.FEMENINO, Candidato.Medio.INTERNET);
                                    txtvotos1.setText(urna.darCandidato1().darCantidadTotalVotos()+"");
                                    txtcampanha1.setText(""+urna.darCandidato1().darCostoCampanha());
                                    txtporcentaje1.setText(""+urna.calcularPorcentajeVotosCandidato(1));
                                    txtrango1.setText(""+urna.darCandidato1().darVotosRango1());
                                }else{
                                    JOptionPane.showMessageDialog(null,"La palabra ingresada no es válida");
                                    System.exit(0);

                                }

                            }

                        }

                    }

                }

            }else{
                if (edad >= 18 && edad <=55) {

                    if (strGenero.equals("Masculino")) {

                        if (strMedio.equals("Television")) {
                            urna.registrarVoto(1, VotosRangoEdad.Edad.EDAD_MEDIA, VotosRangoEdad.Genero.MASCULINO, Candidato.Medio.TELEVISION);
                            txtvotos1.setText(urna.darCandidato1().darCantidadTotalVotos() + "");
                            txtcampanha1.setText("" + urna.darCandidato1().darCostoCampanha());
                            txtporcentaje1.setText("" + urna.calcularPorcentajeVotosCandidato(1));
                            txtrango1.setText(""+urna.darCandidato1().darVotosRango1());
                        } else {
                            if (strMedio.equals("Radio")) {
                                urna.registrarVoto(1, VotosRangoEdad.Edad.EDAD_MEDIA, VotosRangoEdad.Genero.MASCULINO, Candidato.Medio.RADIO);
                                txtvotos1.setText(urna.darCandidato1().darCantidadTotalVotos() + "");
                                txtcampanha1.setText("" + urna.darCandidato1().darCostoCampanha());
                                txtporcentaje1.setText("" + urna.calcularPorcentajeVotosCandidato(1));
                                txtrango1.setText(""+urna.darCandidato1().darVotosRango1());
                            } else {
                                if (strMedio.equals("Internet")) {
                                    urna.registrarVoto(1, VotosRangoEdad.Edad.EDAD_MEDIA, VotosRangoEdad.Genero.MASCULINO, Candidato.Medio.INTERNET);
                                    txtvotos1.setText(urna.darCandidato1().darCantidadTotalVotos() + "");
                                    txtcampanha1.setText("" + urna.darCandidato1().darCostoCampanha());
                                    txtporcentaje1.setText("" + urna.calcularPorcentajeVotosCandidato(1));
                                    txtrango1.setText(""+urna.darCandidato1().darVotosRango1());
                                } else {
                                    JOptionPane.showMessageDialog(null, "La palabra ingresada no es válida");
                                    System.exit(0);
                                }
                            }

                        }
                    } else {
                        if (strGenero.equals("Femenino")) {
                            if (strMedio.equals("Television")) {
                                urna.registrarVoto(1, VotosRangoEdad.Edad.EDAD_MEDIA, VotosRangoEdad.Genero.FEMENINO, Candidato.Medio.TELEVISION);
                                txtvotos1.setText(urna.darCandidato1().darCantidadTotalVotos() + "");
                                txtcampanha1.setText("" + urna.darCandidato1().darCostoCampanha());
                                txtporcentaje1.setText("" + urna.calcularPorcentajeVotosCandidato(1));
                                txtrango1.setText(""+urna.darCandidato1().darVotosRango1());
                            } else {
                                if (strMedio.equals("Radio")) {
                                    urna.registrarVoto(1, VotosRangoEdad.Edad.EDAD_MEDIA, VotosRangoEdad.Genero.FEMENINO, Candidato.Medio.RADIO);
                                    txtvotos1.setText(urna.darCandidato1().darCantidadTotalVotos() + "");
                                    txtcampanha1.setText("" + urna.darCandidato1().darCostoCampanha());
                                    txtporcentaje1.setText("" + urna.calcularPorcentajeVotosCandidato(1));
                                    txtrango1.setText(""+urna.darCandidato1().darVotosRango1());
                                } else {
                                    if (strMedio.equals("Internet")) {
                                        urna.registrarVoto(1, VotosRangoEdad.Edad.EDAD_MEDIA, VotosRangoEdad.Genero.FEMENINO, Candidato.Medio.INTERNET);
                                        txtvotos1.setText(urna.darCandidato1().darCantidadTotalVotos() + "");
                                        txtcampanha1.setText("" + urna.darCandidato1().darCostoCampanha());
                                        txtporcentaje1.setText("" + urna.calcularPorcentajeVotosCandidato(1));
                                        txtrango1.setText(""+urna.darCandidato1().darVotosRango1());
                                    } else {
                                        JOptionPane.showMessageDialog(null, "La palabra ingresada no es válida");
                                        System.exit(0);

                                    }

                                }

                            }

                        }

                    }
                }else{
                    if (edad >= 56 && edad <=150) {

                        if (strGenero.equals("Masculino")) {

                            if (strMedio.equals("Television")) {
                                urna.registrarVoto(1, VotosRangoEdad.Edad.EDAD_MAYOR, VotosRangoEdad.Genero.MASCULINO, Candidato.Medio.TELEVISION);
                                txtvotos1.setText(urna.darCandidato1().darCantidadTotalVotos() + "");
                                txtcampanha1.setText("" + urna.darCandidato1().darCostoCampanha());
                                txtporcentaje1.setText("" + urna.calcularPorcentajeVotosCandidato(1));
                                txtrango1.setText(""+urna.darCandidato1().darVotosRango1());
                            } else {
                                if (strMedio.equals("Radio")) {
                                    urna.registrarVoto(1, VotosRangoEdad.Edad.EDAD_MAYOR, VotosRangoEdad.Genero.MASCULINO, Candidato.Medio.RADIO);
                                    txtvotos1.setText(urna.darCandidato1().darCantidadTotalVotos() + "");
                                    txtcampanha1.setText("" + urna.darCandidato1().darCostoCampanha());
                                    txtporcentaje1.setText("" + urna.calcularPorcentajeVotosCandidato(1));
                                    txtrango1.setText(""+urna.darCandidato1().darVotosRango1());
                                } else {
                                    if (strMedio.equals("Internet")) {
                                        urna.registrarVoto(1, VotosRangoEdad.Edad.EDAD_MAYOR, VotosRangoEdad.Genero.MASCULINO, Candidato.Medio.INTERNET);
                                        txtvotos1.setText(urna.darCandidato1().darCantidadTotalVotos() + "");
                                        txtcampanha1.setText("" + urna.darCandidato1().darCostoCampanha());
                                        txtporcentaje1.setText("" + urna.calcularPorcentajeVotosCandidato(1));
                                        txtrango1.setText(""+urna.darCandidato1().darVotosRango1());
                                    } else {
                                        JOptionPane.showMessageDialog(null, "La palabra ingresada no es válida");
                                        System.exit(0);
                                    }
                                }

                            }
                        } else {
                            if (strGenero.equals("Femenino")) {
                                if (strMedio.equals("Television")) {
                                    urna.registrarVoto(1, VotosRangoEdad.Edad.EDAD_MAYOR, VotosRangoEdad.Genero.FEMENINO, Candidato.Medio.TELEVISION);
                                    txtvotos1.setText(urna.darCandidato1().darCantidadTotalVotos() + "");
                                    txtcampanha1.setText("" + urna.darCandidato1().darCostoCampanha());
                                    txtporcentaje1.setText("" + urna.calcularPorcentajeVotosCandidato(1));
                                    txtrango1.setText(""+urna.darCandidato1().darVotosRango1());
                                } else {
                                    if (strMedio.equals("Radio")) {
                                        urna.registrarVoto(1, VotosRangoEdad.Edad.EDAD_MAYOR, VotosRangoEdad.Genero.FEMENINO, Candidato.Medio.RADIO);
                                        txtvotos1.setText(urna.darCandidato1().darCantidadTotalVotos() + "");
                                        txtcampanha1.setText("" + urna.darCandidato1().darCostoCampanha());
                                        txtporcentaje1.setText("" + urna.calcularPorcentajeVotosCandidato(1));
                                        txtrango1.setText(""+urna.darCandidato1().darVotosRango1());
                                    } else {
                                        if (strMedio.equals("Internet")) {
                                            urna.registrarVoto(1, VotosRangoEdad.Edad.EDAD_MAYOR, VotosRangoEdad.Genero.FEMENINO, Candidato.Medio.INTERNET);
                                            txtvotos1.setText(urna.darCandidato1().darCantidadTotalVotos() + "");
                                            txtcampanha1.setText("" + urna.darCandidato1().darCostoCampanha());
                                            txtporcentaje1.setText("" + urna.calcularPorcentajeVotosCandidato(1));
                                            txtrango1.setText(""+urna.darCandidato1().darVotosRango1());
                                        } else {
                                            JOptionPane.showMessageDialog(null, "La palabra ingresada no es válida");
                                            System.exit(0);

                                        }

                                    }

                                }

                            }

                        }
                    }
                }
            }

        }else{
            JOptionPane.showMessageDialog(null, "La palabra ingresada no es válida");
            System.exit(0);
        }

    }

    public void btn_votar2_click(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(null,"Este botón le mostrará unos campos para rellenar, los cuales son: Su edad, género y medio donde vió el candidato.\n Cada palabra que usted escriba deberá empezar con letra mayúscula. Ejemplos: Masculino, Femenino, Television, Internet, Radio.","Instrucciones",JOptionPane.INFORMATION_MESSAGE);
        String strEdad = JOptionPane.showInputDialog(null,"Digite su edad","Edad",JOptionPane.QUESTION_MESSAGE);
        String strGenero = JOptionPane.showInputDialog(null,"¿Cuál es su género?","Genero",JOptionPane.QUESTION_MESSAGE);
        String strMedio = JOptionPane.showInputDialog(null,"¿En qué medio vió al candidato?","Medio",JOptionPane.QUESTION_MESSAGE);

        if ( strEdad != null && strGenero != null && strMedio != null){

            int edad = Integer.parseInt(strEdad);

            if (edad >= 0 && edad <=17){

                if (strGenero.equals("Masculino")){

                    if (strMedio.equals("Television")){
                        urna.registrarVoto(2, VotosRangoEdad.Edad.EDAD_JOVEN, VotosRangoEdad.Genero.MASCULINO, Candidato.Medio.TELEVISION);
                        txtvotos2.setText(urna.darCandidato2().darCantidadTotalVotos()+"");
                        txtcampanha2.setText(""+urna.darCandidato2().darCostoCampanha());
                        txtporcentaje2.setText(""+urna.calcularPorcentajeVotosCandidato(2));
                        txtrango2.setText(""+urna.darCandidato2().darVotosRango2());
                    }else{
                        if (strMedio.equals("Radio")){
                            urna.registrarVoto(2, VotosRangoEdad.Edad.EDAD_JOVEN, VotosRangoEdad.Genero.MASCULINO, Candidato.Medio.RADIO);
                            txtvotos2.setText(urna.darCandidato2().darCantidadTotalVotos()+"");
                            txtcampanha2.setText(""+urna.darCandidato2().darCostoCampanha());
                            txtporcentaje2.setText(""+urna.calcularPorcentajeVotosCandidato(2));
                            txtrango2.setText(""+urna.darCandidato2().darVotosRango2());
                        }else{
                            if (strMedio.equals("Internet")){
                                urna.registrarVoto(2, VotosRangoEdad.Edad.EDAD_JOVEN, VotosRangoEdad.Genero.MASCULINO, Candidato.Medio.INTERNET);
                                txtvotos2.setText(urna.darCandidato2().darCantidadTotalVotos()+"");
                                txtcampanha2.setText(""+urna.darCandidato2().darCostoCampanha());
                                txtporcentaje2.setText(""+urna.calcularPorcentajeVotosCandidato(2));
                                txtrango2.setText(""+urna.darCandidato2().darVotosRango2());
                            }else{
                                JOptionPane.showMessageDialog(null,"La palabra ingresada no es válida");
                                System.exit(0);
                            }
                        }

                    }
                }else{
                    if (strGenero.equals("Femenino")){
                        if (strMedio.equals("Television")){
                            urna.registrarVoto(2, VotosRangoEdad.Edad.EDAD_JOVEN, VotosRangoEdad.Genero.FEMENINO, Candidato.Medio.TELEVISION);
                            txtvotos2.setText(urna.darCandidato2().darCantidadTotalVotos()+"");
                            txtcampanha2.setText(""+urna.darCandidato2().darCostoCampanha());
                            txtporcentaje2.setText(""+urna.calcularPorcentajeVotosCandidato(2));
                            txtrango2.setText(""+urna.darCandidato2().darVotosRango2());
                        }else{
                            if (strMedio.equals("Radio")){
                                urna.registrarVoto(2, VotosRangoEdad.Edad.EDAD_JOVEN, VotosRangoEdad.Genero.FEMENINO, Candidato.Medio.RADIO);
                                txtvotos2.setText(urna.darCandidato2().darCantidadTotalVotos()+"");
                                txtcampanha2.setText(""+urna.darCandidato2().darCostoCampanha());
                                txtporcentaje2.setText(""+urna.calcularPorcentajeVotosCandidato(2));
                                txtrango2.setText(""+urna.darCandidato2().darVotosRango2());
                            }else{
                                if (strMedio.equals("Internet")){
                                    urna.registrarVoto(2, VotosRangoEdad.Edad.EDAD_JOVEN, VotosRangoEdad.Genero.FEMENINO, Candidato.Medio.INTERNET);
                                    txtvotos2.setText(urna.darCandidato2().darCantidadTotalVotos()+"");
                                    txtcampanha2.setText(""+urna.darCandidato2().darCostoCampanha());
                                    txtporcentaje2.setText(""+urna.calcularPorcentajeVotosCandidato(2));
                                    txtrango2.setText(""+urna.darCandidato2().darVotosRango2());
                                }else{
                                    JOptionPane.showMessageDialog(null,"La palabra ingresada no es válida");
                                    System.exit(0);

                                }

                            }

                        }

                    }

                }

            }else{
                if (edad >= 18 && edad <=55) {

                    if (strGenero.equals("Masculino")) {

                        if (strMedio.equals("Television")) {
                            urna.registrarVoto(2, VotosRangoEdad.Edad.EDAD_MEDIA, VotosRangoEdad.Genero.MASCULINO, Candidato.Medio.TELEVISION);
                            txtvotos2.setText(urna.darCandidato2().darCantidadTotalVotos() + "");
                            txtcampanha2.setText("" + urna.darCandidato2().darCostoCampanha());
                            txtporcentaje2.setText("" + urna.calcularPorcentajeVotosCandidato(2));
                            txtrango2.setText(""+urna.darCandidato2().darVotosRango2());
                        } else {
                            if (strMedio.equals("Radio")) {
                                urna.registrarVoto(2, VotosRangoEdad.Edad.EDAD_MEDIA, VotosRangoEdad.Genero.MASCULINO, Candidato.Medio.RADIO);
                                txtvotos2.setText(urna.darCandidato2().darCantidadTotalVotos() + "");
                                txtcampanha2.setText("" + urna.darCandidato2().darCostoCampanha());
                                txtporcentaje2.setText("" + urna.calcularPorcentajeVotosCandidato(2));
                                txtrango2.setText(""+urna.darCandidato2().darVotosRango2());
                            } else {
                                if (strMedio.equals("Internet")) {
                                    urna.registrarVoto(2, VotosRangoEdad.Edad.EDAD_MEDIA, VotosRangoEdad.Genero.MASCULINO, Candidato.Medio.INTERNET);
                                    txtvotos2.setText(urna.darCandidato2().darCantidadTotalVotos() + "");
                                    txtcampanha2.setText("" + urna.darCandidato2().darCostoCampanha());
                                    txtporcentaje2.setText("" + urna.calcularPorcentajeVotosCandidato(2));
                                    txtrango2.setText(""+urna.darCandidato2().darVotosRango2());
                                } else {
                                    JOptionPane.showMessageDialog(null, "La palabra ingresada no es válida");
                                    System.exit(0);
                                }
                            }

                        }
                    } else {
                        if (strGenero.equals("Femenino")) {
                            if (strMedio.equals("Television")) {
                                urna.registrarVoto(2, VotosRangoEdad.Edad.EDAD_MEDIA, VotosRangoEdad.Genero.FEMENINO, Candidato.Medio.TELEVISION);
                                txtvotos2.setText(urna.darCandidato2().darCantidadTotalVotos() + "");
                                txtcampanha2.setText("" + urna.darCandidato2().darCostoCampanha());
                                txtporcentaje2.setText("" + urna.calcularPorcentajeVotosCandidato(2));
                                txtrango2.setText(""+urna.darCandidato2().darVotosRango2());
                            } else {
                                if (strMedio.equals("Radio")) {
                                    urna.registrarVoto(2, VotosRangoEdad.Edad.EDAD_MEDIA, VotosRangoEdad.Genero.FEMENINO, Candidato.Medio.RADIO);
                                    txtvotos2.setText(urna.darCandidato2().darCantidadTotalVotos() + "");
                                    txtcampanha2.setText("" + urna.darCandidato2().darCostoCampanha());
                                    txtporcentaje2.setText("" + urna.calcularPorcentajeVotosCandidato(2));
                                    txtrango2.setText(""+urna.darCandidato2().darVotosRango2());
                                } else {
                                    if (strMedio.equals("Internet")) {
                                        urna.registrarVoto(2, VotosRangoEdad.Edad.EDAD_MEDIA, VotosRangoEdad.Genero.FEMENINO, Candidato.Medio.INTERNET);
                                        txtvotos2.setText(urna.darCandidato2().darCantidadTotalVotos() + "");
                                        txtcampanha2.setText("" + urna.darCandidato2().darCostoCampanha());
                                        txtporcentaje2.setText("" + urna.calcularPorcentajeVotosCandidato(2));
                                        txtrango2.setText(""+urna.darCandidato2().darVotosRango2());
                                    } else {
                                        JOptionPane.showMessageDialog(null, "La palabra ingresada no es válida");
                                        System.exit(0);

                                    }

                                }

                            }

                        }

                    }
                }else{
                    if (edad >= 56 && edad <=150) {

                        if (strGenero.equals("Masculino")) {

                            if (strMedio.equals("Television")) {
                                urna.registrarVoto(2, VotosRangoEdad.Edad.EDAD_MAYOR, VotosRangoEdad.Genero.MASCULINO, Candidato.Medio.TELEVISION);
                                txtvotos2.setText(urna.darCandidato2().darCantidadTotalVotos() + "");
                                txtcampanha2.setText("" + urna.darCandidato2().darCostoCampanha());
                                txtporcentaje2.setText("" + urna.calcularPorcentajeVotosCandidato(2));
                                txtrango2.setText(""+urna.darCandidato2().darVotosRango2());
                            } else {
                                if (strMedio.equals("Radio")) {
                                    urna.registrarVoto(2, VotosRangoEdad.Edad.EDAD_MAYOR, VotosRangoEdad.Genero.MASCULINO, Candidato.Medio.RADIO);
                                    txtvotos2.setText(urna.darCandidato2().darCantidadTotalVotos() + "");
                                    txtcampanha2.setText("" + urna.darCandidato2().darCostoCampanha());
                                    txtporcentaje2.setText("" + urna.calcularPorcentajeVotosCandidato(2));
                                    txtrango2.setText(""+urna.darCandidato2().darVotosRango2());
                                } else {
                                    if (strMedio.equals("Internet")) {
                                        urna.registrarVoto(2, VotosRangoEdad.Edad.EDAD_MAYOR, VotosRangoEdad.Genero.MASCULINO, Candidato.Medio.INTERNET);
                                        txtvotos2.setText(urna.darCandidato2().darCantidadTotalVotos() + "");
                                        txtcampanha2.setText("" + urna.darCandidato2().darCostoCampanha());
                                        txtporcentaje2.setText("" + urna.calcularPorcentajeVotosCandidato(2));
                                        txtrango2.setText(""+urna.darCandidato2().darVotosRango2());
                                    } else {
                                        JOptionPane.showMessageDialog(null, "La palabra ingresada no es válida");
                                        System.exit(0);
                                    }
                                }

                            }
                        } else {
                            if (strGenero.equals("Femenino")) {
                                if (strMedio.equals("Television")) {
                                    urna.registrarVoto(2, VotosRangoEdad.Edad.EDAD_MAYOR, VotosRangoEdad.Genero.FEMENINO, Candidato.Medio.TELEVISION);
                                    txtvotos2.setText(urna.darCandidato2().darCantidadTotalVotos() + "");
                                    txtcampanha2.setText("" + urna.darCandidato2().darCostoCampanha());
                                    txtporcentaje2.setText("" + urna.calcularPorcentajeVotosCandidato(2));
                                    txtrango2.setText(""+urna.darCandidato2().darVotosRango2());
                                } else {
                                    if (strMedio.equals("Radio")) {
                                        urna.registrarVoto(2, VotosRangoEdad.Edad.EDAD_MAYOR, VotosRangoEdad.Genero.FEMENINO, Candidato.Medio.RADIO);
                                        txtvotos2.setText(urna.darCandidato2().darCantidadTotalVotos() + "");
                                        txtcampanha2.setText("" + urna.darCandidato2().darCostoCampanha());
                                        txtporcentaje2.setText("" + urna.calcularPorcentajeVotosCandidato(2));
                                        txtrango2.setText(""+urna.darCandidato2().darVotosRango2());
                                    } else {
                                        if (strMedio.equals("Internet")) {
                                            urna.registrarVoto(2, VotosRangoEdad.Edad.EDAD_MAYOR, VotosRangoEdad.Genero.FEMENINO, Candidato.Medio.INTERNET);
                                            txtvotos2.setText(urna.darCandidato2().darCantidadTotalVotos() + "");
                                            txtcampanha2.setText("" + urna.darCandidato2().darCostoCampanha());
                                            txtporcentaje2.setText("" + urna.calcularPorcentajeVotosCandidato(2));
                                            txtrango2.setText(""+urna.darCandidato2().darVotosRango2());
                                        } else {
                                            JOptionPane.showMessageDialog(null, "La palabra ingresada no es válida");
                                            System.exit(0);

                                        }

                                    }

                                }

                            }

                        }
                    }
                }
            }

        }else{
            JOptionPane.showMessageDialog(null, "La palabra ingresada no es válida");
            System.exit(0);
        }
    }

    public void btn_votar3_click(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(null,"Este botón le mostrará unos campos para rellenar, los cuales son: Su edad, género y medio donde vió el candidato.\n Cada palabra que usted escriba deberá empezar con letra mayúscula. Ejemplos: Masculino, Femenino, Television, Internet, Radio.","Instrucciones",JOptionPane.INFORMATION_MESSAGE);
        String strEdad = JOptionPane.showInputDialog(null,"Digite su edad","Edad",JOptionPane.QUESTION_MESSAGE);
        String strGenero = JOptionPane.showInputDialog(null,"¿Cuál es su género?","Genero",JOptionPane.QUESTION_MESSAGE);
        String strMedio = JOptionPane.showInputDialog(null,"¿En qué medio vió al candidato?","Medio",JOptionPane.QUESTION_MESSAGE);

        if ( strEdad != null && strGenero != null && strMedio != null){

            int edad = Integer.parseInt(strEdad);

            if (edad >= 0 && edad <=17){

                if (strGenero.equals("Masculino")){

                    if (strMedio.equals("Television")){
                        urna.registrarVoto(3, VotosRangoEdad.Edad.EDAD_JOVEN, VotosRangoEdad.Genero.MASCULINO, Candidato.Medio.TELEVISION);
                        txtvotos3.setText(urna.darCandidato3().darCantidadTotalVotos()+"");
                        txtcampanha3.setText(""+urna.darCandidato3().darCostoCampanha());
                        txtporcentaje3.setText(""+urna.calcularPorcentajeVotosCandidato(3));
                        txtrango3.setText(""+urna.darCandidato3().darVotosRango3());
                    }else{
                        if (strMedio.equals("Radio")){
                            urna.registrarVoto(3, VotosRangoEdad.Edad.EDAD_JOVEN, VotosRangoEdad.Genero.MASCULINO, Candidato.Medio.RADIO);
                            txtvotos3.setText(urna.darCandidato3().darCantidadTotalVotos()+"");
                            txtcampanha3.setText(""+urna.darCandidato3().darCostoCampanha());
                            txtporcentaje3.setText(""+urna.calcularPorcentajeVotosCandidato(3));
                            txtrango3.setText(""+urna.darCandidato3().darVotosRango3());
                        }else{
                            if (strMedio.equals("Internet")){
                                urna.registrarVoto(3, VotosRangoEdad.Edad.EDAD_JOVEN, VotosRangoEdad.Genero.MASCULINO, Candidato.Medio.INTERNET);
                                txtvotos3.setText(urna.darCandidato3().darCantidadTotalVotos()+"");
                                txtcampanha3.setText(""+urna.darCandidato3().darCostoCampanha());
                                txtporcentaje3.setText(""+urna.calcularPorcentajeVotosCandidato(3));
                                txtrango3.setText(""+urna.darCandidato3().darVotosRango3());
                            }else{
                                JOptionPane.showMessageDialog(null,"La palabra ingresada no es válida");
                                System.exit(0);
                            }
                        }

                    }
                }else{
                    if (strGenero.equals("Femenino")){
                        if (strMedio.equals("Television")){
                            urna.registrarVoto(3, VotosRangoEdad.Edad.EDAD_JOVEN, VotosRangoEdad.Genero.FEMENINO, Candidato.Medio.TELEVISION);
                            txtvotos3.setText(urna.darCandidato3().darCantidadTotalVotos()+"");
                            txtcampanha3.setText(""+urna.darCandidato3().darCostoCampanha());
                            txtporcentaje3.setText(""+urna.calcularPorcentajeVotosCandidato(3));
                            txtrango3.setText(""+urna.darCandidato3().darVotosRango3());
                        }else{
                            if (strMedio.equals("Radio")){
                                urna.registrarVoto(3, VotosRangoEdad.Edad.EDAD_JOVEN, VotosRangoEdad.Genero.FEMENINO, Candidato.Medio.RADIO);
                                txtvotos3.setText(urna.darCandidato3().darCantidadTotalVotos()+"");
                                txtcampanha3.setText(""+urna.darCandidato3().darCostoCampanha());
                                txtporcentaje3.setText(""+urna.calcularPorcentajeVotosCandidato(3));
                                txtrango3.setText(""+urna.darCandidato3().darVotosRango3());
                            }else{
                                if (strMedio.equals("Internet")){
                                    urna.registrarVoto(3, VotosRangoEdad.Edad.EDAD_JOVEN, VotosRangoEdad.Genero.FEMENINO, Candidato.Medio.INTERNET);
                                    txtvotos3.setText(urna.darCandidato3().darCantidadTotalVotos()+"");
                                    txtcampanha3.setText(""+urna.darCandidato3().darCostoCampanha());
                                    txtporcentaje3.setText(""+urna.calcularPorcentajeVotosCandidato(3));
                                    txtrango3.setText(""+urna.darCandidato3().darVotosRango3());
                                }else{
                                    JOptionPane.showMessageDialog(null,"La palabra ingresada no es válida");
                                    System.exit(0);

                                }

                            }

                        }

                    }

                }

            }else{
                if (edad >= 18 && edad <=55) {

                    if (strGenero.equals("Masculino")) {

                        if (strMedio.equals("Television")) {
                            urna.registrarVoto(3, VotosRangoEdad.Edad.EDAD_MEDIA, VotosRangoEdad.Genero.MASCULINO, Candidato.Medio.TELEVISION);
                            txtvotos3.setText(urna.darCandidato3().darCantidadTotalVotos() + "");
                            txtcampanha3.setText("" + urna.darCandidato3().darCostoCampanha());
                            txtporcentaje3.setText("" + urna.calcularPorcentajeVotosCandidato(3));
                            txtrango3.setText(""+urna.darCandidato3().darVotosRango3());
                        } else {
                            if (strMedio.equals("Radio")) {
                                urna.registrarVoto(3, VotosRangoEdad.Edad.EDAD_MEDIA, VotosRangoEdad.Genero.MASCULINO, Candidato.Medio.RADIO);
                                txtvotos3.setText(urna.darCandidato3().darCantidadTotalVotos() + "");
                                txtcampanha3.setText("" + urna.darCandidato3().darCostoCampanha());
                                txtporcentaje3.setText("" + urna.calcularPorcentajeVotosCandidato(3));
                                txtrango3.setText(""+urna.darCandidato3().darVotosRango3());
                            } else {
                                if (strMedio.equals("Internet")) {
                                    urna.registrarVoto(3, VotosRangoEdad.Edad.EDAD_MEDIA, VotosRangoEdad.Genero.MASCULINO, Candidato.Medio.INTERNET);
                                    txtvotos3.setText(urna.darCandidato3().darCantidadTotalVotos() + "");
                                    txtcampanha3.setText("" + urna.darCandidato3().darCostoCampanha());
                                    txtporcentaje3.setText("" + urna.calcularPorcentajeVotosCandidato(3));
                                    txtrango3.setText(""+urna.darCandidato3().darVotosRango3());
                                } else {
                                    JOptionPane.showMessageDialog(null, "La palabra ingresada no es válida");
                                    System.exit(0);
                                }
                            }

                        }
                    } else {
                        if (strGenero.equals("Femenino")) {
                            if (strMedio.equals("Television")) {
                                urna.registrarVoto(3, VotosRangoEdad.Edad.EDAD_MEDIA, VotosRangoEdad.Genero.FEMENINO, Candidato.Medio.TELEVISION);
                                txtvotos3.setText(urna.darCandidato3().darCantidadTotalVotos() + "");
                                txtcampanha3.setText("" + urna.darCandidato3().darCostoCampanha());
                                txtporcentaje3.setText("" + urna.calcularPorcentajeVotosCandidato(3));
                                txtrango3.setText(""+urna.darCandidato3().darVotosRango3());
                            } else {
                                if (strMedio.equals("Radio")) {
                                    urna.registrarVoto(3, VotosRangoEdad.Edad.EDAD_MEDIA, VotosRangoEdad.Genero.FEMENINO, Candidato.Medio.RADIO);
                                    txtvotos3.setText(urna.darCandidato3().darCantidadTotalVotos() + "");
                                    txtcampanha3.setText("" + urna.darCandidato3().darCostoCampanha());
                                    txtporcentaje3.setText("" + urna.calcularPorcentajeVotosCandidato(3));
                                    txtrango3.setText(""+urna.darCandidato3().darVotosRango3());
                                } else {
                                    if (strMedio.equals("Internet")) {
                                        urna.registrarVoto(3, VotosRangoEdad.Edad.EDAD_MEDIA, VotosRangoEdad.Genero.FEMENINO, Candidato.Medio.INTERNET);
                                        txtvotos3.setText(urna.darCandidato3().darCantidadTotalVotos() + "");
                                        txtcampanha3.setText("" + urna.darCandidato3().darCostoCampanha());
                                        txtporcentaje3.setText("" + urna.calcularPorcentajeVotosCandidato(3));
                                        txtrango3.setText(""+urna.darCandidato3().darVotosRango3());
                                    } else {
                                        JOptionPane.showMessageDialog(null, "La palabra ingresada no es válida");
                                        System.exit(0);

                                    }

                                }

                            }

                        }

                    }
                }else{
                    if (edad >= 56 && edad <=150) {

                        if (strGenero.equals("Masculino")) {

                            if (strMedio.equals("Television")) {
                                urna.registrarVoto(3, VotosRangoEdad.Edad.EDAD_MAYOR, VotosRangoEdad.Genero.MASCULINO, Candidato.Medio.TELEVISION);
                                txtvotos3.setText(urna.darCandidato3().darCantidadTotalVotos() + "");
                                txtcampanha3.setText("" + urna.darCandidato3().darCostoCampanha());
                                txtporcentaje3.setText("" + urna.calcularPorcentajeVotosCandidato(3));
                                txtrango3.setText(""+urna.darCandidato3().darVotosRango3());
                            } else {
                                if (strMedio.equals("Radio")) {
                                    urna.registrarVoto(3, VotosRangoEdad.Edad.EDAD_MAYOR, VotosRangoEdad.Genero.MASCULINO, Candidato.Medio.RADIO);
                                    txtvotos3.setText(urna.darCandidato3().darCantidadTotalVotos() + "");
                                    txtcampanha3.setText("" + urna.darCandidato3().darCostoCampanha());
                                    txtporcentaje3.setText("" + urna.calcularPorcentajeVotosCandidato(3));
                                    txtrango3.setText(""+urna.darCandidato3().darVotosRango3());
                                } else {
                                    if (strMedio.equals("Internet")) {
                                        urna.registrarVoto(3, VotosRangoEdad.Edad.EDAD_MAYOR, VotosRangoEdad.Genero.MASCULINO, Candidato.Medio.INTERNET);
                                        txtvotos3.setText(urna.darCandidato3().darCantidadTotalVotos() + "");
                                        txtcampanha3.setText("" + urna.darCandidato3().darCostoCampanha());
                                        txtporcentaje3.setText("" + urna.calcularPorcentajeVotosCandidato(3));
                                        txtrango3.setText(""+urna.darCandidato3().darVotosRango3());
                                    } else {
                                        JOptionPane.showMessageDialog(null, "La palabra ingresada no es válida");
                                        System.exit(0);
                                    }
                                }

                            }
                        } else {
                            if (strGenero.equals("Femenino")) {
                                if (strMedio.equals("Television")) {
                                    urna.registrarVoto(3, VotosRangoEdad.Edad.EDAD_MAYOR, VotosRangoEdad.Genero.FEMENINO, Candidato.Medio.TELEVISION);
                                    txtvotos3.setText(urna.darCandidato3().darCantidadTotalVotos() + "");
                                    txtcampanha3.setText("" + urna.darCandidato3().darCostoCampanha());
                                    txtporcentaje3.setText("" + urna.calcularPorcentajeVotosCandidato(3));
                                    txtrango3.setText(""+urna.darCandidato3().darVotosRango3());
                                } else {
                                    if (strMedio.equals("Radio")) {
                                        urna.registrarVoto(3, VotosRangoEdad.Edad.EDAD_MAYOR, VotosRangoEdad.Genero.FEMENINO, Candidato.Medio.RADIO);
                                        txtvotos3.setText(urna.darCandidato3().darCantidadTotalVotos() + "");
                                        txtcampanha3.setText("" + urna.darCandidato3().darCostoCampanha());
                                        txtporcentaje3.setText("" + urna.calcularPorcentajeVotosCandidato(3));
                                        txtrango3.setText(""+urna.darCandidato3().darVotosRango3());
                                    } else {
                                        if (strMedio.equals("Internet")) {
                                            urna.registrarVoto(3, VotosRangoEdad.Edad.EDAD_MAYOR, VotosRangoEdad.Genero.FEMENINO, Candidato.Medio.INTERNET);
                                            txtvotos3.setText(urna.darCandidato3().darCantidadTotalVotos() + "");
                                            txtcampanha3.setText("" + urna.darCandidato3().darCostoCampanha());
                                            txtporcentaje3.setText("" + urna.calcularPorcentajeVotosCandidato(3));
                                            txtrango3.setText(""+urna.darCandidato3().darVotosRango3());
                                        } else {
                                            JOptionPane.showMessageDialog(null, "La palabra ingresada no es válida");
                                            System.exit(0);

                                        }

                                    }

                                }

                            }

                        }
                    }
                }
            }

        }else{
            JOptionPane.showMessageDialog(null, "La palabra ingresada no es válida");
            System.exit(0);
        }
    }

    public void btn_estadisticas_click(ActionEvent actionEvent) {
        Pane_1.setVisible(false);
        Pane_2.setVisible(false);
        Pane_3.setVisible(false);
        Pane_4.setVisible(true);

    }
    public void btn_vaciar_click(ActionEvent actionEvent) {
        urna.reiniciar();
        //Reinicio para candidato 1
        txtvotos1.setText("0");
        txtcampanha1.setText("0");
        txtporcentaje1.setText("0");
        txtrango1.setText("0");
        //Reinicio para candidato 2
        txtvotos2.setText("0");
        txtcampanha2.setText("0");
        txtporcentaje2.setText("0");
        txtrango2.setText("0");
        //Reinicio para candidato 3
        txtvotos3.setText("0");
        txtcampanha3.setText("0");
        txtporcentaje3.setText("0");
        txtrango3.setText("0");


    }
    public void btn_regresar_click(ActionEvent actionEvent) {
        Pane_1.setVisible(true);
        Pane_2.setVisible(true);
        Pane_3.setVisible(true);
        Pane_4.setVisible(false);
    }

    public void btn_consultar_click(ActionEvent actionEvent) {
        graficar();
    }

    public void graficar(){
        double resultado;
        XYChart.Series set10 = new XYChart.Series<>();
        XYChart.Series set11 = new XYChart.Series<>();



        resultado = urna.calcularTotalVotosGeneroMasculino();
        set10.getData().add(new XYChart.Data("Masculinos",resultado));

        resultado = urna.calcularTotalVotosGeneroFemenino();
        set11.getData().add(new XYChart.Data("Femeninos",resultado));


        Votacion_genero.getData().addAll(set10,set11);


    }




}
