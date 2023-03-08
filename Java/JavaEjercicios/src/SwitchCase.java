
package fundamentosjava;

import javax.swing.JOptionPane;

/**
 *
 * @author migue
 */
public class SwitchCase {
    
    public static void main (String [] args) {
        
        int dato = Integer.parseInt(JOptionPane.showInputDialog("Digite un número entre 1 y 5..."));
        
        switch (dato){
            case 1: JOptionPane.showMessageDialog(null, "Este es el número 1");
                    break;
            case 2: JOptionPane.showMessageDialog(null, "Este es el número 2");
                    break;
            case 3: JOptionPane.showMessageDialog(null, "Este es el número 3");
                    break;
            case 4: JOptionPane.showMessageDialog(null, "Este es el número 4");
                    break;
            case 5: JOptionPane.showMessageDialog(null, "Este es el número 5");
                    break;
            default: JOptionPane.showMessageDialog(null, "Ningún número seleccionado es ");        
                   
        }
        
    }
    
}
