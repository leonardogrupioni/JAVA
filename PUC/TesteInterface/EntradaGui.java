import javax.swing.JOptionPane;

/**
 * Entrada de dados (grafica).
 * 
 * @author Julio Arakaki
 * @version 03/04/2023
 */
public class EntradaGui implements IEntrada {
    /**
     * lerNome - entrada de nome (grafica)
     *
     * @return String, nome fornecido
     */
    public String lerNome() { 
        String nome = JOptionPane.showInputDialog("Forneca nome");

        return(nome);
    }

    /**
     * lerIdade - entrada de idade (grafica)
     *
     * @return int, idade fornecida
     */
    public int lerIdade(){ 
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Forneca idade: "));
        return idade;
    }

    /**
     * lerNota - entrada de nota (grafica)
     *
     * @return float, nota fornecida
     */
    public float lerNota(){ 
        float nota = Float.parseFloat(JOptionPane.showInputDialog("Forneca nota: "));
        return nota;
    }
}
