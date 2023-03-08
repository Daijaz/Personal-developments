import javax.swing.JOptionPane;
public class CuadradoNumero {

    public static void main (String [] args){
        
        double numero, resultado;
        
         do {
               numero = Double.parseDouble(JOptionPane.showInputDialog("Digite el número el cual quiere elevar al cudrado"));

               if (numero > 0){

                   resultado = Math.pow(numero,2);

                   JOptionPane.showMessageDialog(null,"El resultado es = "+resultado);

               } else {

                   JOptionPane.showMessageDialog(null,"Digitó un número negativo, el programa finalizó con éxito");

                   break;

               }

        }while(numero > 0);

    }

}
