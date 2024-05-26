 

/**
 * @author julio
 * Classe para representar uma pessos
 */
public class Pessoa {
   
    private NomePessoa nome;
    private int idade;
    private String rg;

    public Pessoa(String nome, int idade, String rg) {
        this.nome = new NomePessoa(nome);
        this.idade = idade;
        this.rg = rg;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome.getNome();
    }
    /**
     * @param _nome the nome to set
     */
    protected void setNome(String nome) {
        this.nome.setNome(nome);
    }
    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }
    /**
     * @param idade the idade to set
     */
    protected void setIdade(int idade) {
        this.idade = idade;
    }
    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }
    /**
     * @param rg the rg to set
     */
    protected void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * Retorna os dados como string
     */
    public String toString(){
        return("\n\nNome: " + getNome() + "\nIdade: " + getIdade()+ "\nRg: " + getRg());
    }
    
}
