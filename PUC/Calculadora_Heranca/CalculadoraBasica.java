/**
 * Calculadora que implementa as 5 operaçoes basicas (+, -, *, /, %).
 * 
 * @author Prof. Julio Arakaki 
 * @version 1.0 (20190301)
 */
public class CalculadoraBasica {
    
    // Atributos (variaveis de instancia)
    private double operando1;
    private String operador;
    private double operando2;
        
    /**
     * CalculadoraBasica Construtor
     *
     * @param op1 double operando1
     * @param op String operador
     * @param op2 double operando2
     */
   CalculadoraBasica(double operando1, String operador, double operando2){
        setOperando1(operando1);
        setOperador(operador);
        setOperando2(operando2);
    }

    // Setters e Getters
    protected void setOperando1(double operando1){
        this.operando1 = operando1;
    }
    protected void setOperador(String operador){
        this.operador = operador;
    }
    protected void setOperando2(double operando2){
        this.operando2 = operando2;
    }

    protected double getOperando1(){
        return this.operando1;
    }
    protected String getOperador(){
        return this.operador;
    }
    protected double getOperando2(){
        return this.operando2;
    }

    
   // operacoes básicas    
    private double adicao(double a, double b){
        return (a + b);
    }

    private double subtracao(double a, double b){
        return (a - b);
    }

    protected double multiplicacao(double a, double b){
        return (a * b);
    }

    protected double divisao(double a, double b){
        return (a / b);
    }

    private double resto(double a, double b){
        return (a % b);
    }

    /**
     * Método calcular
     *
     * @return double resultado da operação
     */
    public double calcular(){
        double res=0;

        switch (getOperador()) {
            case "+":
                res = adicao(getOperando1(), getOperando2());
                break;
            case "-":
                res = subtracao(getOperando1(), getOperando2());
                break;
            case "*":
                res = multiplicacao(getOperando1(), getOperando2());
                break;
            case "/":
                res = divisao(getOperando1(), getOperando2());
                break;
            case "%":
                res = resto(getOperando1(), getOperando2());
                break;
        }
        return res;
    }
    
    /**
     * Método toString
     *
     * @return String representando a expressao
     */
    public String toString(){
        return("(" + getOperando1() + " " + getOperador() + " " + getOperando2() + ")");
    }
}
