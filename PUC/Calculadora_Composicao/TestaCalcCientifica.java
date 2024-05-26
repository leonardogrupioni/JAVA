import javax.swing.JOptionPane;
/**
 * Escreva a descrição da classe TestaCalcCientifica aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class TestaCalcCientifica
{
    public static void main(String args[]){
        
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Forneca valor:"));
        // Todas operacoes com a calculadora cientifica
        CalculadoraCientifica cc1 = new CalculadoraCientifica(3, "+", valor);
        CalculadoraCientifica cc2 = new CalculadoraCientifica(3, "-", valor);
        CalculadoraCientifica cc3 = new CalculadoraCientifica(3, "*", valor);
        CalculadoraCientifica cc4 = new CalculadoraCientifica(3, "/", valor);
        CalculadoraCientifica cc5 = new CalculadoraCientifica(33, "%", valor);
        CalculadoraCientifica cc6 = new CalculadoraCientifica("sqrt", 9);
        CalculadoraCientifica cc7 = new CalculadoraCientifica("seno", 30);
        CalculadoraCientifica cc8 = new CalculadoraCientifica("inverso", 2);
        CalculadoraCientifica cc9 = new CalculadoraCientifica("fatorial", 5);

        System.out.println("Operacoes com a Calculadora Cientifica:");       
        System.out.println(cc1 + " = " + cc1.calcular());
        System.out.println(cc2 + " = " + cc2.calcular());
        System.out.println(cc3.toString() + " = " + cc3.calcular());
        System.out.println(cc4.toString() + " = " + cc4.calcular());
        System.out.println(cc5.toString() + " = " + cc5.calcular());
        System.out.println(cc6.toString() + " = " + cc6.calcular());
        System.out.println(cc7.toString() + " = " + cc7.calcular());
        System.out.println(cc8.toString() + " = " + cc8.calcular());
        System.out.println(cc9.toString() + " = " + cc9.calcular());
    }
}
