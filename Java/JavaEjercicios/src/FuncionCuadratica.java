package fundamentosjava;

import java.util.Scanner;

/**
 *
 * @author migue
 */

public class FuncionCuadratica {

    public static void main (String[]args){
        
        Scanner entrada = new Scanner (System.in);
           
        System.out.print("Digite el coeficiente a: ");
        double a = entrada.nextInt();
        
        System.out.print("Digite el coeficiente b: ");
        double b = entrada.nextInt();
        
        System.out.print("Digite el coeficiente c: ");
        double c = entrada.nextInt();
        
        double x1 = (-b + Math.sqrt((Math.pow(b, 2) - 4 * a * c)))/2*a;
        
        double x2 = (-b - Math.sqrt((Math.pow(b, 2) - 4 * a * c)))/2*a;
        
        System.out.println("El resultado de la raiz uno es; "+x1);
        
        System.out.println("El resultado de la raiz dos es; "+x2);
    
    }
}
