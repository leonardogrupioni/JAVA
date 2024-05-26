//DEPENDENCIAS EXTERNAS
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

//DEFINICAO DE CLASSE
public class TesouroPirata{
    //VARIAVEIS DE INSTANCIA
    List<String> c; //representa a caverna do jogo
    Explorador e; //representa o inventario do explorador
    
    //CONSTRUTOR
    TesouroPirata(){
        c = new ArrayList<>();
        c.add("CHA");
        c.add("BAÚ");
        e = new Explorador();
    }
    
    //METODOS
    void jogar(){
        boolean sent = true;
        String cmd = null;
        while(true){
            
            do{
                sent = true;    
                try{
                    cmd = JOptionPane.showInputDialog("Comando? ");
                }catch(NullPointerException e){
                    JOptionPane.showMessageDialog(null,"Comando Invalido");
                    sent = false;
                }
            }while(!sent);
    
            if(cmd.equals("t CHA")){
                e.tocar("CHA");
                System.out.println(e.s);
            }
            if(cmd.equals("t BAÚ")){
                e.tocar("BAÚ");
                System.out.println(e.s);
            }
            if(c.equals(e.s)){
                System.out.println(e.s);
                System.out.println("Fim");
                break;
            }
        }
    }
}
