/**
 * Metodos utilitarios.
 * 
 * @author Julio Arakaki
 * @version 05/03/2023
 */
public class Utils {
    /**
     * Método validarOperando - verifica se a string de entrada eh numerica
     *
     * @param str string de entrada
     * @return false se existir algum caracter diferente de numeros e 
     *         true se for somente numeros
     */
    public static boolean validarOperando(String str){
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) 
                return false;
        }
        return true;
    }
    /**
     * Método validarOperador - verifica se o operadoe e valido
     *
     * @param op String contendo o operador
     * @return false se for diferente de (+,-,x,/) e true caso contrario
     */
    public static boolean validarOperador(String op){
        
        if (!(op.equals("+") || op.equals("-") || op.equals("x") || op.equals("/"))) 
            return false;
        return true;
    }
}
