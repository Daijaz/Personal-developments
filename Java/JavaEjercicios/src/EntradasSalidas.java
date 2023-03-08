

import java.util.Scanner;

/**
 *
 * @author migue
 */
public class EntradasSalidas {
    
    public static void main (String [] args){
        
        // Instanciamiento del objeto entrada para la lectura de datos
        Scanner entrada = new Scanner (System.in);
    
        // Salidas y entradas de datos
        System.out.println("Por favor ingrese un número entero: ");
        int variableInt = entrada.nextInt();
        
        System.out.println("Por favor ingrese un número decimal: ");
        float variableFloat = entrada.nextFloat();
        
        System.out.println("Por favor ingrese un número decimal: ");
        double variableDouble = entrada.nextDouble();
        
        System.out.println("Por favor ingrese una cadena de caracteres: ");
        String variableString = entrada.next();
        
        boolean miguelEsGay = false;
    
        // Aquí se imprimirán todos los datos ingresados
        System.out.printf("La variable int es: %d, la variable float es: %f, la variable double es: %E la cadena de caracteres es: %s. ¿Miguel es gay? la rspuesta es %b",variableInt,variableFloat,variableDouble,variableString,miguelEsGay,".");    
                
    }// Fin del método Main
    
}// Fin de la clase Entradas y Salidas
