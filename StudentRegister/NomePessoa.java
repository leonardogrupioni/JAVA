 
/**
 * Armazena o nome de uma pessoa. Inverte nome e limpa espaços extras 
 * (operaçoes herdados da classe pai).
 * Retorna o nome da pessoa em formato de bibliografia
 * 
 * @author Julio Arakaki 
 * @version 1.0 2019/02/29
 */
public class NomePessoa extends Texto{
	// Atributos
	private String nome;
	

	// Construtores
	public NomePessoa(String nome){
		super(nome);
		setNome(super.getTxt());
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	/**
	 * Retorna nome invertido
	 * @return sInv nome invertido
	 */
	public String getNomeInvertido(){
		return inverteTexto();
	}
	
	/**
	 * Retorna nome bibliografico
	 * @return sBib nome bibliografico
	 */
	public String getNomeBiblio(){
		
		// Separa as palavras
		String vts[] = getNome().split(" ");
		int qtd = vts.length;
		
		String sBib = vts[qtd-1] + ", "; // ultimo nome + a virgula
		// Monta o texto
		for (int i=0; i < (qtd-1); i++){
			String pal = vts[i].toLowerCase(); // pega palavra
			if(!ePreposicao(pal)){ // Se nao for preposicao concatena
				sBib = sBib + vts[i].toUpperCase().charAt(0) + ". ";
			}
		}
		return sBib;
	}
	
	/**
	 * Verifica se string eh uma "preposicao"
	 * @param s string a ser verificada
	 * @return true eh preposicao false nao eh preposicao
	 */
	private boolean ePreposicao(String s){
		// Vetor de "preposicoes"
		final String prep[]={"da", "de", "do", "di", "das", "dos", "e",};
		
		for (int i = 0; i < prep.length; i++){
			if(prep[i].equals(s)){
				return true;
			}
		}
		return false;
	}

}

