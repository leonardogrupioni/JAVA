
/**
 * Representa um aluno.
 * 
 * @author Julio Arakaki 
 * @version 27/03/2023
 */
public class Aluno extends Pessoa {
    // Atributos
    String ra;
    int serie;
    Disciplina disc[];
    
    /**
     * Aluno Construtor para iniciar dados do aluno
     *
     * @param nome String, nome do aluno
     * @param idade int, idade do aluno
     * @param ra String, ra do aluno
     * @param serie int, serie do aluno
     * @param disc array de Disciplinas
     */
    Aluno(String nome, int idade, String ra, int serie, Disciplina disc[]){
        super (nome, idade);
        setRa(ra);
        setSerie(serie);
        setDisc(disc);
    }
    
    private void setRa(String ra){
        this.ra = ra;
    }
    
    private void setSerie(int serie){
        this.serie = serie;
    }
    
    private void setDisc(Disciplina disc[]){
        this.disc = disc;
    }
}
