package fundamentosjava;

public class DineroTres {
    
    /*
     Juan tiene N dolares, Luis tiene la mitad de lo que tiene Juan, Guillermo tiene la mitad de 
     lo que posee Juan y Luis juntos, imprimir la cantidad de dinero que tiene los tres...
    */
    
    public static void main (String[]aargs){
        double DineroJuan = 10000;
        double DineroLuis = DineroJuan / 2;
        double DineroGuillermo = ((DineroJuan + DineroLuis)/2);
        
        System.out.println("Juan tiene "+DineroJuan+", Luis tiene "+DineroLuis+", Guillermo tiene "+DineroGuillermo+".");
        
    }
    
}
