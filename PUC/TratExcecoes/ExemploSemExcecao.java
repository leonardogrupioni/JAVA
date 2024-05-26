import javax.swing.JOptionPane;

public class ExemploSemExcecao {
    public static void main(String[] args) {

        // Declaracao de variaveis
        String aux = null; 
        int x = 10, y = 0; 
        int vet_i[] = new int[1]; // Criacao de um array de tamanho 1
        
        // Preenchimento do array    
        vet_i[0] = 20;
        //vet[1] = 20; // 

        // Leitura do teclado
        aux = JOptionPane.showInputDialog("Forneça um inteiro: ");

        // Conversao para inteiro
        y = Integer.parseInt(aux);

        // Calculo com divisao por zero
        System.out.println("x/y = " + x/y);
    }
}
