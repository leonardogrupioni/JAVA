import javax.swing.JOptionPane;

/**
 * Escreva uma descrição da classe Jogo aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Jogo
{
    public static void main(){
        int estado = 1;
        boolean fimDoJogo = false;
        boolean retorno;

        while(!fimDoJogo){
            switch(estado){
                case 1:{
                        Inicio();
                        estado = 2;
                        break;
                    }
                case 2:{
                        retorno = EnigmaDaChave.enigma();    
                        if(retorno) estado = 3;
                        else estado = 1;
                        break;
                    }
                case 3:{
                        TesouroPirata ts = new TesouroPirata();
                        ts.jogar();
                        fimDoJogo = true;
                        break;
                    }
            }
        }
    }
    
    static void Inicio(){
        String cmd = null;
        boolean sent = true;
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
            if(cmd.equals("t BAÚ")) break;
        }    
    }
}
