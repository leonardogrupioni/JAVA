import java.util.Random;
import javax.swing.JOptionPane;

/**
 * Escreva uma descrição da classe EnigmaDaChave aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class EnigmaDaChave
{
    public static boolean enigma(){
        boolean retorno = false;
        Random gerador = new Random();
        int nAleatorio = gerador.nextInt(100) + 1;
        System.out.println(nAleatorio);
        int erros = 0;
        boolean sent = true;
        int n = 0;
        
        while(erros < 3){
            
            do{
                sent = true; 
                try{
                    n = Integer.parseInt(JOptionPane.showInputDialog("Numero "));
                    
                    if(n < 1 || n > 100){
                        JOptionPane.showMessageDialog(null,"Numero Invalido!!! Apenas de 1 a 100!!!");
                        sent = false;
                    }
                }
                //verifica exeções
                catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null,"\nDigite numeros de 1 a 100!!");
                    sent = false;
                }
            }
            while(!sent);
            
            if(n == nAleatorio){
                JOptionPane.showMessageDialog(null, "Existe uma chave a cinco passos do baú...");
                retorno = true;
                break;
            }
            
            JOptionPane.showMessageDialog(null, "Tente novamente!!");
            erros++;
        }
        
        return retorno;
    }
}
