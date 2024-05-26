import java.util.Scanner;
public class LifeText extends Life {
    Scanner sc = new Scanner(System.in);
    //Keyboard kbd = Console.getInput();
    //Screen scr = Console.getOutput();

    LifeText(int linhas, int colunas){
        super (linhas, colunas);
    }
    
    //
    // entrarDados
    //
    // parametros:
    //  entrada:
    //  saida:
    //
    // retorno:
    //
    public void entrarDados(){
        int x=0, y=0;
        while (x!=-1) {
            //x=Keyboard.readInt("Forneca x: ");
            System.out.print("\nForneca x (-1 para encerrar, max: " + getLinhas() + "): ");
            x = sc.nextInt();
            //y=Keyboard.readInt("Forneca y: ");
            System.out.print("\nForneca y (-1 para encerrar): , max: " + getColunas() + "): ");
            y = sc.nextInt();
            
            if (x != -1 && y != -1)
                getAmbiente()[x][y].setValorCelula(true); // Altera celula para Viva
        }
    }
    //
    // imprimirAmbiente
    //
    // parametros:
    //  entrada:
    //  saida:
    //
    // retorno:
    //
    void imprimirAmbiente() {
        for(int i=0; i < getAmbiente().length; i++){
            for (int j=0; j < getAmbiente()[i].length; j++){
                if(getAmbiente()[i][j].getValorCelula() == false){ // Se a celula for Morta
                    //scr.print("-");
                    System.out.print("-");
                }
                else{                       // Se a celula for Viva
                    //scr.print("*");
                    System.out.print("*");
                }
            }
            //scr.print("\n");
            System.out.println();
        }
    }
    
    
}
