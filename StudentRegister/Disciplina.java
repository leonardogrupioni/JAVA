
/**
 * representa um disciplina.
 * 
 * @author Julio Arakaki
 * @version 27/03/2023
 */
public class Disciplina {
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private Texto NomeDisc;
    private float nota;


	/**
	 * @param nomeDisc
	 * @param nota
	 */
	public Disciplina(String nomeDisc, float nota) {
		NomeDisc = new Texto(nomeDisc);
		this.nota = nota;
	}

	/**
	 * @return the nomeDisc
	 */
	private Texto getNomeDisc() {
		return NomeDisc;
	}

	/**
	 * @param nomeDisc the nomeDisc to set
	 */
	private void setNomeDisc(Texto nomeDisc) {
		NomeDisc = nomeDisc;
	}

	/**
	 * @return the nota
	 */
	private float getNota() {
		return nota;
	}

	/**
	 * @param nota the nota to set
	 */
	private void setNota(float nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Disciplina [NomeDisc=" + getNomeDisc() + ", nota=" + getNota() + "]";
	}
}
