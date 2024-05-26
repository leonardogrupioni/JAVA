
import java.util.Scanner;
/**
 * Aplicativo para testar as classes.
 * 
 * @author Prof. Julio Arakaki
 * @version 1.0
 */
public class TestaCalcBasica {
    public static void main(String args[]){

        Scanner scan = new Scanner( System.in );

        System.out.print("Forneca um valor:");
        double valor = scan.nextDouble();

        // Todas operacoes com a calculadora Basica
        CalculadoraBasica cb1 = new CalculadoraBasica(3, "+", valor);
        CalculadoraBasica cb2 = new CalculadoraBasica(3, "-", valor);
        CalculadoraBasica cb3 = new CalculadoraBasica(3, "*", valor);
        CalculadoraBasica cb4 = new CalculadoraBasica(3, "/", valor);
        CalculadoraBasica cb5 = new CalculadoraBasica(33, "%", valor);

        System.out.println("Operacoes com a Calculadora Basica:");       
        System.out.println(cb1 + " = " + cb1.calcular());
        System.out.println(cb2 + " = " + cb2.calcular());
        System.out.println(cb3 + " = " + cb3.calcular());
        System.out.println(cb4 + " = " + cb4.calcular());
        System.out.println(cb5 + " = " + cb5.calcular());

    }
}