import java.util.Scanner;

/**
 * EntradaConsole para entrada de dados via painel de (Texto)
 * 
 * @author João Pedro Figols, Julia Schmidt, Igor Matos, Leonardo Grupioni 
 * @version v2.0 11/04/2023
 */
public class EntradaConsole implements IEntrada {
    //entrada pelo teclado(console)
    Scanner scanner = new Scanner(System.in);
    
    /**
     * Método receberString - entrada console
     *
     * @param msg String, mensagem que aparece na interface
     * @return entrada String, os dados fornecidos pelo usuario (entrada) 
     */
    public String receberString(String msg){
        System.out.print(msg); //imprime uma mensagem no console
        String entrada = scanner.nextLine(); //cria uma variavel do tipo string que recebe um input no console
        return entrada; //retorna uma string
    }

    /**
     * Método imprimirMsg - saida console
     *
     * @param msg String, mensagem que aparece no console
     */
    public void imprimirMsg(String msg){
        System.out.println(msg); //imprime a msg passada
        System.out.println(); //passa para a linha de baixo do console
    }  
    
    public void imprimirRelatorio(String relatorio){
        System.out.println(relatorio); //imprime a msg passada
        System.out.println(); //passa para a linha de baixo do console
    }  

}
