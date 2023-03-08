
package fundamentosjava;

/**
 *
 * @author migue
 */

public class JOptionPane {
    
        public static void main(String[] args) {
        
            String nombreUsuario = javax.swing.JOptionPane.showInputDialog("Ingrese su nombre:");
            int edadUsuario = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Ingrese su edad:"));
            char sexoUsuario = javax.swing.JOptionPane.showInputDialog("Digite su sexo, H o M:").charAt(0);
            double estaturaUsuario = Double.parseDouble(javax.swing.JOptionPane.showInputDialog("Ingresa tu estatura: "));

            javax.swing.JOptionPane.showMessageDialog(null, "El nombre del usuario es "+nombreUsuario);
            javax.swing.JOptionPane.showMessageDialog(null, "La edad del usuario es "+edadUsuario);
            javax.swing.JOptionPane.showMessageDialog(null, "El sexo del usuario es "+sexoUsuario);
            javax.swing.JOptionPane.showMessageDialog(null, "La estatura del usuairio es "+estaturaUsuario);
       } 
}
