package ex5;

public class Vetor{
	public int tamanhoMaximo;
    public String[] vet;
    public int nElementos = 0;

    public Vetor(int tamanhoMaximo){
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

}