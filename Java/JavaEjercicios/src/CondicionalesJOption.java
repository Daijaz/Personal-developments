package fundamentosjava;

/**
 *
 * @author migue
 * 
 */

import javax.swing.JOptionPane;

public class CondicionalesJOption {
    
    public static void main (String [] args){
        
        int dato = 5, numeroUsuario;
        
        numeroUsuario = Integer.parseInt(JOptionPane.showInputDialog("Digite el número a condicionar..."));
        
        if (numeroUsuario == dato){
            
            JOptionPane.showMessageDialog(null, "El número suministrado concuerda, bienvenido. ");
            
        } else {
            
            JOptionPane.showMessageDialog(null, "El número suministrado no concuerda, adiós. ");
            
        } 
    }   
}
