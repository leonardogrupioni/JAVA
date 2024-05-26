import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Dimension;

/**
 * EntradaGUI para entrada de dados (grafica), com JOptionPane
 * 
 * @author João Pedro Figols, Julia Schmidt, Igor Matos, Leonardo Grupioni 
 * @version v2.0 11/04/2023
 */
public class EntradaGUI implements IEntrada
{
    /**
     * Método receberString - Entrada grafica
     *
     * @param msg String, mensagem que aparece na interface
     * @return d_string, os dados fornecidos
     */
    public String receberString(String msg){
        String d_string = "-"; //cria uma variavel do tipo String 
        d_string = JOptionPane.showInputDialog(msg); //envia a mensagem para o painel e recebe uma string na variavel d_string
        return d_string; //retorna uma string
    }

    /**
     * Método imprimirMsg - Saida grafica 
     *
     * @param msg String, mensagem que aparece na interface
     */
    public void imprimirMsg(String msg){
        JOptionPane.showMessageDialog(null, msg); //imprime no painel uma mensagem passada pelo parametro
    }
    
    public void imprimirRelatorio(String relatorio){
        String texto = relatorio; //texto recebe uma string que possui os dados dos alunos registrados
        //instancia objetos para definir o que tem dentro do panel e adiciona o scroll bar
        JTextArea textArea = new JTextArea(texto);
        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        textArea.setEditable(false);  //quando false nao permite escrever/editar a area do painel
        //quando true faz quebra de linha e de palavra de acordo com a area do painel
        textArea.setLineWrap(true);   
        textArea.setWrapStyleWord(true);  
        
        textArea.setCaretPosition(0);   //definir a posicao do cursor

        String titulo = "Relatorio"; //define o titulo da janela

        //Instancia objeto e define as dimensões da janela em pixels
        Dimension tamanho = new Dimension(500, 250);
        scrollPane.setPreferredSize(tamanho); 

        //imprime no painel os alunos em formato de lista, juntamente com o titulo do painel e o scroll bar
        JOptionPane.showMessageDialog(null, scrollPane, titulo, JOptionPane.PLAIN_MESSAGE); 
    }
}
