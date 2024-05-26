package ex5;

public class VetorOrdenado {
	public int tamanhoMaximo;
    public String[] vet;
    public int nElementos = 0;

    public VetorOrdenado(int tamanhoMaximo){
        this.vet = new String[tamanhoMaximo];
        setQtdElementos(nElementos);
    }
    
	public int getQtdElementos() {
		return nElementos;
	}

	public void setQtdElementos(int nElementos) {
		this.nElementos = nElementos;
	}

	public void insert(String item) {
		if(this.nElementos == this.tamanhoMaximo) {
			String[] vet_aux = new String[this.tamanhoMaximo + 1]; //vetor auxiliar com 1 a mais
            for (int i = 0; i < this.tamanhoMaximo; i++){
                vet_aux[i] = this.vet[i]; //passa tudo para o vetor auxiliar
            }
            this.vet = vet_aux; //vetor recebe o vetor auxiliar
            this.tamanhoMaximo++; 
            this.nElementos++; 
            this.vet[this.nElementos] = item;
		} else {
			this.vet[this.nElementos] = item;
			this.nElementos ++;
		}
		this.vet = merge(this.vet); //apos inserir um item, executa o merge para deixar em Ordem Alfabética
	}
	
	public String get(int posicao){
        if (posicao < 0 || posicao > this.nElementos){
            return null;
        }
        return this.vet[posicao];
    }
	
	public int size() {
		return this.nElementos;
	}
	// RE-Fazer
	public String[] merge(String[] vet) {
		if(this.nElementos <= 1) return this.vet;
		
		int meio = this.nElementos / 2;
		
		Vetor esquerda = new Vetor(meio);
		Vetor direita = new Vetor(meio);
		esquerda.nElementos = 0;
		direita.nElementos = 0;
		
		
		//vetor esquerda
		for(int i = 0; i < meio; i++) {
			esquerda.vet[i] = this.vet[i];
			esquerda.nElementos++;
		}
		//vetor direita
		for(int i = meio; i < this.nElementos; i++) {
			direita.vet[i] = this.vet[i];
			direita.nElementos++;
		}
		
		//incializando indices para os subvetores e adicao de elemento
		int i = 0; int j = 0; int k = 0;
		
		Vetor vetorOrdenado = new Vetor(this.nElementos);
		
		while(i < esquerda.nElementos && j < direita.nElementos) {
			if(esquerda.vet[i].compareTo(direita.vet[j]) < 0) {
				vetorOrdenado.vet[k] = esquerda.vet[i];
				k++; i++;
			} else {
				vetorOrdenado.vet[k] = direita.vet[j];
				k++; j++;
			}
		}
		
		while(i < esquerda.nElementos) {
			vetorOrdenado.vet[k] = esquerda.vet[i];
			k++; i++;
		}
		
		while(j < esquerda.nElementos) {
			vetorOrdenado.vet[k] = direita.vet[j];
			k++; j++;
		}
		
		return vetorOrdenado.vet;
	}
	
}
