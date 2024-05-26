import javax.swing.JOptionPane;
//import java.util.Scanner;

/**
 * Escreva a descrição da classe TestaTexto aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class TestaTexto {
    public static void main(String[] args) {
        // cria objeto para entrada pelo teclado (standard input) 
        //Scanner sc = new Scanner(System.in); 
  
        //System.out.println("Forneca um texto: ");
        //String texto = sc.nextLine(); 
         
        // Entrada de um nome (atraves do teclado)
        String texto = JOptionPane.showInputDialog("Forneça um texto: ");

        // Criacao de uma instancia da classe nome (criacao do objeto)
        Texto txt = new Texto(texto); // Chama o metodo construtor com o texto fornecido

        // Mostra os dados
        System.out.println("Texto              : " + txt.getTxt() + " (" + txt.getQtdePalavras()+ " palavras)");
        System.out.println("Texto invertido    : " + txt.inverterTexto());
    }
}
