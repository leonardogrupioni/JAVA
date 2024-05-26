
/**
 * Calculadora de 4 operacoes basicas.
 * 
 * @author Julio Arakaki
 * @version 05/03/2023
 */
public class CalculadoraBasica {
    /**
     * Método calcular
     *
     * @param opnd1 double operando1
     * @param oper String operador
     * @param opnd2 double operando2
     * @return double valor da operacao
     */
    public double calcular(String opnd1, String oper, String opnd2) {
        double operando1 = Double.parseDouble(opnd1);
        double operando2 = Double.parseDouble(opnd2);

        double result = 0;
        
        switch(oper) {
            case "+": 
                result = operando1 + operando2;
                break;
            case "-": 
                result = operando1 - operando2;
                break;
            case "/": 
                result = operando1 / operando2;
                break;
            case "x": 
                result = operando1 * operando2;
                break;
        }
        
        return result;
        
    }
}