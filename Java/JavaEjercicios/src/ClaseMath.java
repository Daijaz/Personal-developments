package fundamentosjava;

import java.util.Scanner;

/**
 *
 * @author migue
 */

public class ClaseMath {
    
    public static void main (String[]args){
        
        // Raices cuadradas
        double raiz = Math.sqrt(9);  
        System.out.println("El resultado de la raiz de 9 es: "+raiz);
        
        // Potenciación
        double base = 23, exponente = 2;
        double resultado = Math.pow(base, exponente);
        System.out.println("El resultado de 23 ^ 2. =  "+resultado);
        
        // Método Round para redondear el número
        long resultado2 = Math.round(resultado);
        System.out.println(resultado);
        
        // Método Round con Foat
        float resultadoConFloat = 34.34f;
        int resultadoConInt = Math.round(resultadoConFloat);
        System.out.println(resultadoConInt);
        
        // Método randmom
        double numeroAleatorio = Math.random();
        System.out.println(numeroAleatorio);

        
    }
}
