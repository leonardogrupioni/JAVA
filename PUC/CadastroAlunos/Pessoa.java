
/**
 * Representa um,a pessoa.
 * 
 * @author Julio Arakaki
 * @version 27/03/2023
 */
public class Pessoa {
    // variaveis de instancia 
    private int idade;
    private NomePessoa nome;
    
    /**
     * Pessoa chamado para instanciar uma pessoa
     *
     * @param nome String, nome da pessoa
     * @param idade int, idade da pessoa
     */
    public Pessoa(String nome, int idade) {
        setNome(new NomePessoa(nome)); 
        setIdade(idade);
    }

    /**
     * setNome - atualiza nome
     *
     * @param nome NomePessoa, objeto da classe NomePessoa
     */
    private void setNome(NomePessoa nome){
        this.nome = nome;
    }

    /**
     * setIdade - atualiza idade
     *
     * @param idade int, idade da pessoa
     */
    private void setIdade(int idade){
        this.idade = idade;
    }

    /**
     * getNome - retorna nome
     *
     * @return nome da pessoa, Objeto da classe NomePessoa
     */
    private NomePessoa getNome(){
        return this.nome;
    }
    
    /**
     * getIdade - retorna a idade
     *
     * @return int, idade da pessoas
     */
    private int getIdade(){
        return this.idade;
    }
    
    /**
     * toString - imprime os dados da pessoa
     *
     * @return String, dados da pessoa
     */
    public String toString(){
        return ("Nome: " + getNome() + "\nIdade: " + getIdade());
    }   
}
