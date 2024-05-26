
/**
 * Calculadora cientifica composta por Calculadora basica
 * Implementa novas operações e as 5 operaçoes basicas 
 * (+, -, *, /, %).
 * 
 * @author Prof. Julio Arakaki 
 * @version 1.0 (20190301)
 */
public class CalculadoraCientifica {
    // Atributos
    CalculadoraBasica cb;    
    
    // Construtor 
    /**
     * CalculadorCientifica 
     *      construtor para as operacoes avancadas
     *
     * @param operador String: "sqrt", "inverso", "seno", "fatorial"
     * @param operando double: valor onde o operador sera aplicado
     */
    CalculadoraCientifica(String operador, double operando){
        cb = new CalculadoraBasica(operando, operador, 0);
    }

    /**
     * CalculadorCientifica 
     *      construtor para as operacoes basicas
     *
     * @param operando1 double: operando 1
     * @param operador String: "+", "-", "*", "/", "%"
     * @param operando2 double: operando 2
     */
    CalculadoraCientifica(double operando1, String operador, double operando2){
        cb = new CalculadoraBasica(operando1, operador, operando2);
    }

    /**
     * Método calcular 
     *      Calcula o resultado das operacoes da calculadora
     *
     * @return O resultado da expressao
     */
    public double calcular(){

        double res=0;

        switch(cb.getOperador()) {
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
                res = cb.calcular();
            break;    
            case "sqrt":
                res = Math.sqrt(cb.getOperando1());
            break;
            case "inverso":
                res = cb.divisao(1.0, cb.getOperando1());
            break;
            case "seno":
                res = Math.sin(Math.toRadians(cb.getOperando1()));
            break;
            case "fatorial":
                res = fatorial((long)cb.getOperando1());
            break;
        }

        return res;
    }

    /**
     * Método fatorial: calcula o fatorial de um numero (parametro)
     *
     * @param n long numero no qual sera calculado o fatorial
     * @return r long fatorial do numero (parametro)
     */
    private long fatorial(long n){
        long r = 1, i;
        if (n >= 1){
            for(i = n; i > 0; i--){
                r = (long)cb.multiplicacao((double)r, (double)i);
            }           
        }
        else{
            r = 0;
        }
        return r;
            
    }

    /**
     * Método toString
     *
     * @return String representando uma operaçao basica ou uma operacao avancada
     */
    public String toString(){
        String expr = "" + cb.getOperador() + "(" + cb.getOperando1() + ")";
        
        switch(cb.getOperador()) {
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
            expr = cb.toString();
            break;    
        }
        
        return(expr);
    }
}
