package fundamentosjava;

import java.util.Scanner;

/**
 *
 * @author migue
 */

public class Condicionales {
    
    public static void main (String [] args){
    
        // Instanciamiento de la clase Scanner por medio del objeto entrada
        Scanner entrada = new Scanner (System.in);
      
        // Definición de variables
        int numero1, numero2;
        
        // Impresión y lectura de números
        System.out.print("Digite el numero 1: ");
        numero1 = entrada.nextInt();
        System.out.println("el numero 1 es: "+ numero1);
       
        System.out.print("Digite el numero 2: ");
        numero2 = entrada.nextInt();
        System.out.println("el numero 2 es: "+numero2);
        
        // Impresión y lectura de operación
        System.out.println("Por favor escriba una de las siguientes operaciones matematicas: suma o resta...");
        String operacion = entrada.next();
        System.out.println("La operacion ingresada es "+operacion);
        
        // Impresión de resultados, condicionado al valor de la variable operacion
        if (operacion.equals("suma")){
            System.out.print("La suma será igual a: ");
            System.out.println(numero1+numero2);
        } 
        else if (operacion.equals("resta")){
            System.out.print("La resta es igual a: ");
            System.out.println(numero1-numero2);   
        } else {
            System.out.println("La operación ingresada no es correcta");
        }
    }
}
