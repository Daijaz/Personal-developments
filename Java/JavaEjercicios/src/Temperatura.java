import java.util.Scanner;

public class Temperatura{

    public static void main (String [] args){

        Scanner sc = new Scanner (System.in);

        int temp = sc.nextInt();

        if (temp >= 100){
            System.out.println("Boiling");
        }else{
            System.out.println("Not boiling");
        }

    }

}
