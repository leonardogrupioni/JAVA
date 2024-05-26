import java.util.Scanner;
//import javax.swing.JOptionPane;

public class TestaNomePessoa {
    public static void main(String[] args) {
        // cria objeto para entrada pelo teclado (standard input) 
        Scanner sc = new Scanner(System.in); 
  
        System.out.println("Forneca um nome: ");
        String nome = sc.nextLine(); 
         
        // Entrada de um nome (atraves do teclado)
        //String nome = JOptionPane.showInputDialog("Forneça o nome de uma pessoa: ");

        // Criacao de uma instancia da classe nome (criacao do objeto)
        NomePessoa nm = new NomePessoa(nome); // Chama o metodo construtor com o nome fornecido

        // Mostra os dados
        System.out.println("Nome              : " + nm.getNome() + " (" + nm.getQtdePalavras()+ " palavras)");
        System.out.println("Nome invertido    : " + nm.inverterTexto());
        System.out.println("Nome bibliografia : " + nm.getNomeBiblio());
    }
}
