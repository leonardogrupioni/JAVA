
import java.util.Scanner;

public class CalculadoraBasica{
    public static void main(String args[]){
        System.out.println("Testando...");
        double operando1 = 0;
        double operando2 = 0;
        String operador = "";
        double result = 0;

        int tam = args.length;

        // Verifica a qtde de parametros
        if (tam == 3) {
            System.out.println("Parametro1: " + args[0]);
            System.out.println("Parametro2: " + args[1]);
            System.out.println("Parametro3: " + args[2]);

            /*
                Declaracao de variaveis e
                Converte os parametros
            */
            operando1 = Double.parseDouble(args[0]);
            operando2 = Double.parseDouble(args[2]);
            operador = args[1];
            result = 0;
            if (operador.equals("+")){

                result = operando1 + operando2;

                System.out.println("Soma: " + result);

            } else if (operador.equals("-")){
                result = operando1 - operando2;

                System.out.println("Subtracao: " + result);
            } else if (operador.equals("/")){
                result = operando1 / operando2;

                System.out.println("Divisao: " + result);
            } else if (operador.equals("x")){
                result = operando1 * operando2;

                System.out.println("Multiplicacao: " + result);
            } else {
                System.out.println("Operador invalido!!");                
            }

        } else if (tam == 0){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Forneca operando1: ");
            operando1 = scanner.nextDouble();
            System.out.print("Forneca operador: ");
            operador = scanner.next();
            System.out.print("Forneca operando2: ");
            operando2 = scanner.nextDouble();
            
            if (operador.equals("+")){

                result = operando1 + operando2;

                System.out.println("Soma: " + result);

            } else if (operador.equals("-")){
                result = operando1 - operando2;

                System.out.println("Subtracao: " + result);
            } else if (operador.equals("/")){
                result = operando1 / operando2;

                System.out.println("Divisao: " + result);
            } else if (operador.equals("x")){
                result = operando1 * operando2;

                System.out.println("Multiplicacao: " + result);
            } else {
                System.out.println("Operador invalido!!");                
            }
        } 
        else {
            System.out.println("Parametros invalidos!!");
        }      
    }
}
