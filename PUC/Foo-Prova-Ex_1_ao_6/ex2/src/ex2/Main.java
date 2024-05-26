package ex2;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);


	        System.out.println("Digite o numero do voo: ");
	        int numero = scanner.nextInt();

	        System.out.println("Digite a data do voo ");
	        System.out.println("Dia: ");
	        int dia = scanner.nextInt();

	        System.out.println("Mes: ");
	        int mes = scanner.nextInt();

	        System.out.println("Ano: ");
	        int ano = scanner.nextInt();

	        System.out.println("DIgite o assento desejado: ");
	        int cadeira = scanner.nextInt();

	        Voo voo = new Voo(numero,dia,mes,ano,cadeira);

	}

}
