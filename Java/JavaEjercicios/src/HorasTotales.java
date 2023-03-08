package fundamentosjava;

import java.util.Scanner;

/**
 *
 * @author migue
 */

public class HorasTotales {
    
    public static void main (String [] args){
        
        Scanner entrada = new Scanner (System.in);
        int horasTotales, horas, dias, semanas;
        
        System.out.println("Ingrese el número total de horas.");
        horasTotales = entrada.nextInt();
        
        dias = (horasTotales%168) / 24;
        semanas = horasTotales / 168;
        horas = (horasTotales%168) % 24;
        
        System.out.printf("El número total de horas equivalen a: %d semanas, %d dias y %d horas...",semanas,dias,horas);
        
    }// Final del método Main
    
}// Final de la clase HorasTotales
