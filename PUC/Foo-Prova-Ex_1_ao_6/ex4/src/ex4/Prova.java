package ex4;

public class Prova {
	public static int nQuestao = 0;
	public char respostaDoAluno;
	public int crivo[] = new int[15];
	
	public Prova(Gabarito gabarito) {
		gabarito = new Gabarito();
		
	}
	
	public boolean respostaAluno(char respostaDoAluno) {
		boolean retorno = false;
		char respQuestao = gabarito.respostaQuestao(nQuestao);
		if(respostaDoAluno == respQuestao) {
			crivo[nQuestao] = 1;
			retorno = true;
		} else crivo[nQuestao] = 0;
		nQuestao++;
		return retorno;
	}
	
	public int acertos() {
		int acertos = 0;
		for(int i = 0; i < 15; i++) {
			if(crivo[i] == 1) {
				acertos++;
			}
		}
		return acertos;
	}
	
	public double nota() {
		double nota = 0;
		for(int i = 0; i < 15; i++) {
			if(crivo[i] == 1) {
				if(i < 10) {
					nota = nota + 0.5;
				} else {
					nota = nota + 1;
				}
			} 
			
		}
		return nota;
	}
	
	public double maior(Prova prova) {
		if(this.acertos() < prova.acertos()) {
			return prova.nota();
		} else if (this.acertos() > prova.acertos()) {
			return this.nota();
		} else {
			if(this.nota() < prova.nota()) {
				return prova.nota();
			} else if (this.nota() > prova.nota()) {
				return this.nota();
			} else {
				return this.nota();
			}
		}
		
	}

} 	
