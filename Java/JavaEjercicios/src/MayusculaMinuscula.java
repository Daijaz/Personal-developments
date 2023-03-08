import javax.swing.JOptionPane;

public class MayusculaMinuscula {

    public static void main (String [] args){

        char letra;

        letra = JOptionPane.showInputDialog("Digite la letra a evaluar...").charAt(0);

        if (Character.isUpperCase(letra)){
            JOptionPane.showMessageDialog(null,"La letra digita es mayúscula");
        } else {
            JOptionPane.showMessageDialog(null,"La letra digita es minúscula");
        }
    }
}
