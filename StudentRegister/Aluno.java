
/**
 * Escreva uma descrição da classe Aluno aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Aluno extends Pessoa {
    // atributos (variaveis de instancia)
    private String ra;
	private String curso; 
    private IArmazenador disciplinas;

    /**
     * Construtor para objetos da classe Aluno
     * @param nome
     * @param idade
     * @param rg
     * @param ra
     * @param curso
     * @param disciplinas
     */
    public Aluno(String nome, int idade, String rg, String ra, String curso, IArmazenador disciplinas) {
        // inicializa variáveis de instância
        super(nome, idade, rg);
        setRa(ra);
        setCurso(curso); 
        setDisciplinas(disciplinas);
    }
    
    /**
	 * @return the ra
	 */
	private String getRa() {
		return ra;
	}

	/**
	 * @param ra the ra to set
	 */
	private void setRa(String ra) {
		this.ra = ra;
	}

	/**
	 * @return the curso
	 */
	private String getCurso() {
		return curso;
	}

	/**
	 * @param curso the curso to set
	 */
	private void setCurso(String curso) {
		this.curso = curso;
	}

	/**
	 * @return the disciplinas
	 */
	private IArmazenador getDisciplinas() {
		return disciplinas;
	}

	/**
	 * @param disciplinas the disciplinas to set
	 */
	private void setDisciplinas(IArmazenador disciplinas) {
		this.disciplinas = disciplinas;
	}

    
    /**
     * toString
     *
     * @return String, dados de uma pessoa (incluindo altura, peso e imc)
     */
    public String toString(){
        return (super.toString() + "\nRA: " + getRa()  + "\nCurso: " + getCurso()+ "\nDisciplinas: " + getDisciplinas());
    }
}
