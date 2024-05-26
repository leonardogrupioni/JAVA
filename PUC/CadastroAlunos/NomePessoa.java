/**
 * Classe para armazenar o nome de uma pessoa. Possibilita inverter nome e limpar
 * espaços extras (operaçoes da classe Texto).
 * Retorna o nome da pessoa em formato de bibliografia
 * 
 * @author Julio Arakaki 
 * @version 1.0 2019/02/29
 */
public class NomePessoa {
    // Atributos
    private Texto nome;

    // Construtores
    public NomePessoa(String nome){
        setNome(nome);
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return this.nome.getTxt();
    }

    /**
     * @param nome the nome to set
     */
    private void setNome(String nome) {
        this.nome = new Texto(nome);
    }

    /**
     * Retorna quantidade de palavras do nome
     * @return qtd numero de palavras
     */
    public int getQtdePalavras(){
        return this.nome.getQtdePalavras();
    }
    
    /**
     * Retorna nome invertido
     * @return sInv nome invertido
     */
    public String getNomeInvertido(){
        return this.nome.inverterTexto();
    }

    /**
     * Retorna nome bibliografico
     * @return sBib nome bibliografico
     */
    public String getNomeBiblio(){

        // Separa as palavras
        String vts[] = this.nome.getTxt().split(" ");
        int qtd = vts.length;

        String sBib = vts[qtd-1] + ", "; // ultimo nome + a virgula
        // Monta o texto
        for (int i=0; i < (qtd-1); i++){
            String pal = vts[i].toLowerCase(); // pega palavra
            if(!verificaStr(pal)){ // Se nao for preposicao concatena
                sBib = sBib + vts[i].toUpperCase().charAt(0) + ". ";
            }
        }
        return sBib;
    }

    /**
     * Verifica se string eh uma string a ser retirada
     * @param s string a ser retirada
     * @return true eh string a ser retirada false nao string a ser retirada
     */
    private boolean verificaStr(String s){
        // Vetor de strings a serem retiradas
        final String sRet[]={"da", "de", "do", "di", "das", "dos", "e",};

        for (int i = 0; i < sRet.length; i++){
            if(sRet[i].equals(s)){
                return true;
            }
        }
        return false;
    }

    /**
     * Retorna os atributos como string
     */
    public String toString(){
        return this.nome.toString();
    }
}

