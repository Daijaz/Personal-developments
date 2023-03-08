import java.util.Scanner;

import java.util.Arrays;
public class LlenandoArreglo {

    public static void main (String [] args){

        Scanner entrada = new Scanner(System.in);

        int [] simpleArray = new int[5];

        for (int i = 0; i <= 4; i++){

            System.out.print("Digite el valor que quieres asignar al índice "+i+" del arreglo: ");
            simpleArray[i] = entrada.nextInt();

        }

        System.out.println(Arrays.toString(simpleArray));

    }
}
