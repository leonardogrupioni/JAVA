
/**
 * Escreva uma descri��o da classe App aqui.
 * 
 * @author (seu nome) 
 * @version (um n�mero da vers�o ou uma data)
 */
public class App {
    public static void main(String args[]){
        //IArmazenador arm = new ListaArray();
        IArmazenador arm = new VetDin();
        
        String s1 = "Ze";
        String s2 = "Maria";
        String s3 = "Joao";
        //Integer i = 100;
        int i = 222;
        
        
        arm.adicionar(s1);
        arm.adicionar(s2);
        arm.adicionar(s3);        
        arm.adicionar(i);
        
        System.out.println(arm);
    }
}
