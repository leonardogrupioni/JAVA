
/**
 * Representa uma equacao do 2o grau.
 * 
 * @author Julio Arakaki 
 * @version 20/03/2023
 */
public class Eq2g {
    // Atributos (parametros da equacao)
    private double a, b, c;
    
    // Contrutor
    /**
     * Eq2g constroi uma equacao do 2o grau
     *
     * @param a - double parametro a
     * @param b - double parametro a
     * @param c - double parametro a
     */
    Eq2g(double a, double b, double c) {
        // Atribuir os parametros para as variaveis de instanciaset
        setA(a);
        setB(b);
        setC(c);
    }
    
    /**
     * setA - altera o valor de a
     *
     * @param a - double, valor de a
     */
    private void setA(double a){
        this.a = a;
    }

    /**
     * setB - altera o valor de b
     *
     * @param b - double, valor de b
     */
    private void setB(double b){
        this.b = b;
    }
    
    /**
     * setC - altera o valor de c
     *
     * @param c - double, valor de c
     */
    private void setC(double c){
        this.c = c;
    }
    
    /**
     * getA - retorna o valor de a
     *
     * @return a, double valor de a
     */
    public double getA() {
        return this.a;
    }
    /**
     * getB - retorna o valor de b
     *
     * @return b, double valor de b
     */
    private double getB() {
        return this.b;
    }
    /**
     * getC - retorna o valor de c
     *
     * @return c, double valor de c
     */
    private double getC() {
        return this.c;
    }
    
    /**
     * calcularDelta - calcula o valor de delta
     *
     * @return delta - double valor de delta
     */
    private double calcularDelta(){
        double delta = Math.pow(getB(), 2) - 4 * getA() * getC();
        return delta;
    }
    
    /**
     * temRaizes - verifica se tem raizes reais
     *
     * @return boolean - true: tem raizes reais 
     *                   false: nao tem raizes reais
     */
    public boolean temRaizes(){
        double d = calcularDelta();
        if( d >= 0) return true;
        else return false;
    }
    
    /**
     * toString - metodo para imprimir uma eq2g
     *
     * @return s - String formatado
     */
    public String toString(){
        String s = getA() + "x2 + " + getB() + "x + " + getC();
        return s;
    }
}
