
/**
 * Aplicativo para testar as classes.
 * 
 * @author Prof. Julio Arakaki
 * @version 1.0
 */
public class TestaCalc {

    public static void main(String args[]){
        // Declaracao de variaveis
        double result1;

        // Instanciacao de objeto da classe (criacao de objeto)
        CalculadoraBasica cb = new CalculadoraBasica(45, "/", 12);
        
        // Aciona metodo 
        result1 = cb.calcular();

        // Mostra resultado
        System.out.println(cb + "=" + result1);
    }
}