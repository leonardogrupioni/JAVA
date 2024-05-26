import java.util.Scanner;
/**
 * Escreva uma descrição da classe RunLifeText aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class RunLifeText
{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        LifeText life = new LifeText(20, 20); // define dimensoes do ambiente
        String continua = "";
        life.entrarDados(); 
        do {
            life.imprimirAmbiente();// Mostra ambiente
            life.calcularProximaGeracao(); // calcula proxima geracao
            System.out.println("\nMostra Proxima geracao? (s/n)");
            continua = sc.nextLine();
        } while(!continua.equals("n"));

    }
}
