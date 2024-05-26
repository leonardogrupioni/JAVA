import javax.swing.JOptionPane;

/**
 * Testa a classe NomePessoa.
 * 
 * @author Julio Arakaki
 * @version 20230313
 */
public class TestaNomePessoa {
    public static void main(String[] args) {
        // Entrada de um nome (atraves do teclado)
        String nomePessoa = JOptionPane.showInputDialog("Forneça um nome: ");

        // Criacao de uma instancia da classe nome (criacao do objeto)
        NomePessoa nome = new NomePessoa(nomePessoa); // Chama o metodo construtor com o texto fornecido

        // Mostra os dados
        System.out.println("Nome              : " + nome.getNome() + " (" + nome.getQtdePalavras()+ " palavras)");
        System.out.println("Nome invertido    : " + nome.getNomeInvertido());
        System.out.println("Nome bibliografico: " + nome.getNomeBiblio());
    }
}
