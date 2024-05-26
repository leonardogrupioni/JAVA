import javax.swing.JOptionPane;

/**
 * testa a classe Eq2g.
 * 
 * @author Julio Arakaki
 * @version 20/03/2023
 */
public class TestaEq2g {
    public static void main (String args[]){
        // Leitura de 3 valores double
        double a = Double.parseDouble(JOptionPane.showInputDialog("Forneca a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Forneca b:"));
        double c = Double.parseDouble(JOptionPane.showInputDialog("Forneca c:"));

        // Instancia uma eq2g
        Eq2g eq1 = new Eq2g(a, b, c);
        Eq2g eq2 = new Eq2g(33,4, 2);
        
        // Imprime a equacao
        System.out.println(eq1);
 
        System.out.println(eq2);
        
        System.out.println(eq1.getA());
    
        
        
        if(eq1.temRaizes() == false) {
            System.out.println("Nao existem raizes reais!!");
        } else{
            System.out.println("Raizes: ");
        }
        
    }
}
