
/**
 * Armazenador - classe para implementar operacoes de persistencia 
 * em memoria.
 *
 * @author Julio Arakaki
 * @version 05/2023
 */
public class CadastroAlunos {
    
    // Armazenador de clientes
    IArmazenador cad;

    /**
     * CadastroClientes Construtor para armazenar objetos em memoria
     *
     */
    CadastroAlunos(){
        // a implementacao do armazenador pode ser trocado
        this.cad = new VetDin();   // em VetDin
        //this.cad = new ListaArray(); // em ArrayList
    }

    /**
     * cadastrarAluno em memoria
     *
     * @param aluno Aluno a ser adicionada no armazenador
     */
    public void adicionarAluno(Aluno aluno){
        cad.adicionar(aluno);
    }


    /**
     * Mé remover
     *
     * @param ra Um parâmetro
     * @return O valor de retorno
     */
    public boolean removerAluno(String ra){
        return true;
    }

    /**
     * getQtd
     *
     * @return int, quantidade de alunos cadastrados
     */
    public int getQtd(){
        return cad.getQtd();
    }
    
    /**
     * toString imprime dados do cadastro
     *
     * @return String com os alunos
     */
    public String toString(){
        String s = "";
        if(cad != null){
            s = "Alunos: " + cad;
        }
        return s;
    }
}
