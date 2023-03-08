
package fundamentosjava;

/**
 *
 * @author migue
 */

import java.util.Scanner;

public class Operadores {
    
    public static void main (String [] args){
        
        // Instanciamiento de objeto entrada de tipo Scanner para la lectura de datos
        Scanner entrada = new Scanner (System.in);
        
        // Impresión y lectura de datos por consola
        System.out.println("Digite dos números para realizarle operaciones aritméticas: ");
        
        System.out.print("Digite el primer número: ");
        float numeroUno = entrada.nextFloat();
        
        System.out.print("Digite el segundo número: ");
        float numeroDos = entrada.nextFloat();
        
        // Impresión de resultados de operaciones aritméticas con ambos números.
        System.out.print("El resultado de la operación: "+numeroUno+" + "+numeroDos+" = ");
        System.out.println(numeroUno+numeroDos);
        
        System.out.print("El resultado de la operación: "+numeroUno+" - "+numeroDos+" = ");
        System.out.println(numeroUno-numeroDos);
        
        System.out.print("El resultado de la operación: "+numeroUno+" * "+numeroDos+" = ");
        System.out.println(numeroUno*numeroDos);
        
        System.out.print("El resultado de la operación: "+numeroUno+" / "+numeroDos+" = ");
        System.out.println(numeroUno/numeroDos);
        
        System.out.print("El resultado de la operación: "+numeroUno+" % "+numeroDos+" = ");
        System.out.println(numeroUno%numeroDos);

        
    }// Final del método Main
    
}// Fin de la clase Operadores
