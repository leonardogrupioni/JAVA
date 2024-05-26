import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

//Estrutura de dados do jogo da vida
public class Life {
    Celula _ambiente[][];
    int linhas, colunas;

    Life(int linhas, int colunas){
        setAmbiente(new Celula[linhas][colunas]);
        iniciarAmbiente();
        setLinhas(linhas);
        setColunas(colunas);
    }

    private void setLinhas(int linhas){
        this.linhas = linhas;
    }
    
    private void setColunas(int colunas){
        this.colunas = colunas;
    }
    
    public int getLinhas(){
        return this.linhas;
    }

    public int getColunas(){
        return this.colunas;
    }

    Celula [][]getAmbiente(){
        return _ambiente;
    }

    void setAmbiente(Celula [][]ambiente){
        _ambiente=ambiente;
    }

    //
    // inicializarGrade
    //
    // parametros:
    //  entrada:
    //  saida:
    //
    // retorno:
    //
    public void iniciarAmbiente() {
        for(int i=0; i < getAmbiente().length; i++){
            for (int j=0; j < getAmbiente()[i].length; j++){
                //    scr.println("["+i+"]"+"["+j+"]");

                getAmbiente()[i][j] = new Celula(); // Inicia todas as celulas como Morta
            }
        }
    }

    //
    // devolverValor
    //
    // parametros:
    //  entrada: int Linha
    //       int Coluna
    //  saida:
    //
    // retorno: int  0 - morta, 1 - viva
    //
    boolean devolverValor(int linha, int coluna) {
        return (getAmbiente()[linha][coluna].getValorCelula());
    }

    //
    // calcularVizinhos
    //
    // parametros:
    //  entrada: int Linha
    //       int Coluna
    //  saida:
    //
    // retorno: int
    //
    int calcularVizinhos(int linha, int coluna) {
        int numVizinhos=0, i, j;

        // Varre todos os vizinhos
        for(i = linha-1; i <= linha+1; i++){
            for (j = coluna-1; j <= coluna+1; j++){
                // Verifica os limites
                if(i>0 && i < getAmbiente().length && j > 0 && j < _ambiente[i].length) {
                    if(getAmbiente()[i][j].getValorCelula() == true) // se for celula Viva
                        numVizinhos++;
                }
            }
        }

        // Se a propria celula for VIVA
        if (getAmbiente()[linha][coluna].getValorCelula() == true){
            numVizinhos--;
        }

        return numVizinhos;
    }

    void calcularProximaGeracao() {
        int numVizinhos=0;
        Life novoMapa = new Life(getAmbiente().length, getAmbiente()[0].length);

        for(int i=0; i < getAmbiente().length; i++){
            for (int j=0; j < getAmbiente()[i].length; j++){
                // Calcular numero de vizinhos da celula i,j
                numVizinhos = calcularVizinhos(i,j);
                switch (numVizinhos){
                    case 0:
                    case 1:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    // Marca celula i,j como MORTA=0
                    novoMapa.getAmbiente()[i][j].setValorCelula(false);
                    break;
                    case 2:
                    // Mantem o mesmo valor da celula i,j
                    novoMapa.getAmbiente()[i][j].setValorCelula(devolverValor(i, j));
                    break;
                    case 3:
                    // Marca celula i,j como VIVA=1
                    novoMapa.getAmbiente()[i][j].setValorCelula(true);
                    break;
                }
            }
        }
        copiarMapa(novoMapa);
    }

    public void copiarMapa(Life novoMapa) {
        for(int i=0; i < getAmbiente().length; i++){
            for (int j=0; j < getAmbiente()[i].length; j++){
                getAmbiente()[i][j].setValorCelula(novoMapa.devolverValor(i, j));
            }
        }
    }

    public void limparAmbiente() {
        for(int i=0; i < getAmbiente().length; i++){
            for (int j=0; j < getAmbiente()[i].length; j++){
                getAmbiente()[i][j].setValorCelula(false);
            }
        }
    }

    public void lerEstado(){
        File file = null;
        String arquivo = null;
        String sn = null;;
        boolean repetir = false;
        do {
            try{
                repetir = false;
                arquivo = JOptionPane.showInputDialog("Arquivo: ");
                file = new File(arquivo);
                if (!file.exists()) {
                    sn = JOptionPane.showInputDialog("Arquivo:" + arquivo + " inexistente, deseja tentar de novo?(s/n): ");
                    if (sn.toUpperCase().charAt(0) == 'S') {
                        repetir = true;
                    } else {
                        System.exit(0);
                    }
                }
            }catch(Exception e){
                return;
            }

        } while(repetir);
        BufferedReader br = null;
        FileReader fr = null;

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
        } catch(FileNotFoundException ex) {
            System.out.println("Arquivo inexistente: " + arquivo);
            return;
        } catch(Exception ex) {
            System.out.println("Erro inesperado ao tentar abrir o arquivo: " + arquivo);
            ex.printStackTrace();
            return;
        }

        try {
            String line = br.readLine();
            int linha = 0;
            while(line != null) { // Fim do arquivo ?
                // Carrega no ambiente
                for (int coluna = 0; coluna < line.length(); coluna++){
                    if (line.charAt(coluna) == '0'){
                        getAmbiente()[linha][coluna].setValorCelula(false);
                    }else{
                        getAmbiente()[linha][coluna].setValorCelula(true);                    
                    }
                }
                linha ++;

                // Le proxima linha
                line = br.readLine();
            }
        } catch(EOFException ex) {
            System.out.println("Atingiu prematuramente o final do arquivo: " + arquivo);
            return;
        } catch(IOException ex) {
            System.out.println("Nao conseguiu ler do arquivo: " + arquivo);
            return;
        } catch(Exception ex) {
            System.out.println("Erro inesperado ao tentar ler o arquivo: " + arquivo);
            ex.printStackTrace();
            return;
        } finally {
            try {
                br.close();
            } catch(Exception ex) {
                // Nao faz nada !
            }
            try {
                fr.close();
            } catch(Exception ex) {
                // Nao faz nada !
            }
        }
    }

    public void salvarEstado(){
        File file = null;
        String arquivo = null;
        String sn = null;;
        do {
            try{
                sn = "S";
                arquivo = JOptionPane.showInputDialog("Arquivo: ");
                file = new File(arquivo);
                if (file.exists()) {
                    sn = JOptionPane.showInputDialog("Arquivo: " + arquivo + " ja existe, pode sobrescreve-lo?(s/n): ");
                }
            }catch(Exception e){
                return;
            }

        } while(sn.toUpperCase().charAt(0) == 'N');
        PrintWriter pw = null;
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(file);
            pw = new PrintWriter(fos);
        } catch(IOException ex) {
            System.out.println("Nao conseguiu abrir o arquivo: " + arquivo);
            return;
        } catch(Exception ex) {
            System.out.println("Erro inesperado ao tentar abrir o arquivo: " + arquivo);
            return;
        }

        try {
            for(int i=0; i < getAmbiente().length; i++){
                for (int j=0; j < getAmbiente()[i].length; j++){
                    if (getAmbiente()[i][j].getValorCelula() == true){
                        pw.print("1");
                    } else {
                        pw.print("0");
                    }
                }
                pw.println();
            }

        } catch(Exception ex) {
            System.out.println("Erro inesperado ao tentar escrever no arquivo: " + arquivo);
            return;
        } finally {
            try {
                pw.close();
            } catch(Exception ex) { 
                // Nao faz nada!
            }
            try {
                fos.close();
            } catch(Exception ex) { 
                // Nao faz nada!
            }
        }

    }
}
