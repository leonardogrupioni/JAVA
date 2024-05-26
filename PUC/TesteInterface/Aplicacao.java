
/**
 * APplicacao para testar interface.
 * 
 * @author Julio Arakaki
 * @version 03/04/2023
 */
public class Aplicacao {
    public static void main(String args[]){
        
        // Instancia objeto
        IEntrada ent = new EntradaConsole(); // Para entradas em modo texto
        //IEntrada ent = new EntradaGui(); // Para entradas em modo grafico

        // Chama metodos a partir do objeto
        String nome = ent.lerNome();
        int idade = ent.lerIdade();
        float nota = ent.lerNota();
        
        // Imprime dados lidos pelo teclado
        System.out.println("Nome : " + nome);
        System.out.println("Idade : " + idade);
        System.out.println("Nota : " + nota);
    }
}
