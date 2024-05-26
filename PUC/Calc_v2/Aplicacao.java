import java.util.Scanner;

public class Aplicacao{
    public static void main(String args[]){

        String opnd1 = "";
        String opnd2 = "";
        String operador = "";
        double result = 0;

        // armazena o tamanho do vetor de string (args) - qtde de parametros
        int tam = args.length; 

        // Verifica a qtde de parametros
        if (tam == 3) { // entrada pela linha de comando
            opnd1 = args[0];
            operador = args[1];
            opnd2 = args[2];
            // verifica operador
            if(!Utils.validarOperador(operador)) {
                System.out.println("Operador invalido!!");
                return;
            }
            // verifica operando 1
            if(!(Utils.validarOperando(opnd1))) {
                System.out.println("Operando 1 invalido!!");
                return;
            }
            
            if(!(Utils.validarOperando(opnd2))) {
                System.out.println("Operando 2 invalido!!");
                return;
            }

        } else if (tam == 0){ 
            
            // Entrada pelo teclado (console)
            Scanner scanner = new Scanner(System.in);
            System.out.print("Forneca operando1: ");
            opnd1 = scanner.next();
            
            // verifica operando 1
            if(!(Utils.validarOperando(opnd1))) {
                System.out.println("Operando 1 invalido!!");
                return;
            }
            
            System.out.print("Forneca operador: ");
            operador = scanner.next();
            // verifica operador
            if(!Utils.validarOperador(operador)) {
                System.out.println("Operador invalido!!");
                return;
            }
            
            System.out.print("Forneca operando2: ");
            opnd2 = scanner.next();
            
            // verifica operando2           
            if(!(Utils.validarOperando(opnd2))) {
                System.out.println("Operando 2 invalido!!");
                return;
            }
            

        } else {
            System.out.println("Parametros invalidos!!");
            return;
        }   
        
        // Instancia (cria) objeto da classe Calculadora
        CalculadoraBasica calc = new CalculadoraBasica();
        
        
        System.out.print ("("+opnd1 + " " + operador + " " + opnd2 + ") = ");
        System.out.println (calc.calcular(opnd1, operador, opnd2));
    }
}
