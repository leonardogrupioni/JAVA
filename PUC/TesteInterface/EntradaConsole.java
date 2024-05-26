import java.util.Scanner;

/**
 * Entrada de dados (texto).
 * 
 * @author Julio Arakaki
 * @version 03/04/2023
 */public class EntradaConsole implements IEntrada {
    Scanner scan = new Scanner( System.in );

    /**
     * lerIdade - entrada de idade (texto)
     *
     * @return int, idade fornecida
     */    
    public String lerNome(){ 
        System.out.println("Forneca nome: ");
        String nome = scan.nextLine();
        return nome;
    }

    /**
     * lerIdade - entrada de idade (texto)
     *
     * @return int, idade fornecida
     */
    public int lerIdade(){ 
        System.out.println("Forneca idade: ");
        int idade = scan.nextInt();
        return idade;
    }

    /**
     * lerNota - entrada de nota (texto)
     *
     * @return float, nota fornecida
     */
    public float lerNota(){ 
        System.out.println("Forneca nota: ");
        float nota = scan.nextFloat();
        return nota;
    }
}
