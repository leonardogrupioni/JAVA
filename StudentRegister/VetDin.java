
/**
 * "simula" um array dinamico.
 * 
 * @author Julio Arakaki
 * @version 12/04/2023
 */
public class VetDin implements IArmazenador {

    // Atributos
    // array para armazenar qquer objeto
    private Object array[]; 
    // quantidade de objetos no vetor
    private int qtd;

    /**
     * VetDin Construtor - inicia um array e seta a quantidade
     *
     */
    public VetDin(){
        setArray(null);
        setQtd(0);
    }

    /**
     * retorna array de Object
     * 
     * @return vetor de Object
     */
    private Object[] getArray() {
        return array;
    }

    /**
     * Retorna a quntidade
     * 
     * @return int, quantidade de elementos no array
     */
    public int getQtd() {
        return qtd;
    }

    /**
     * @param vet the vet to set
     */
    private void setArray(Object[] array) {
        this.array = array;
    }

    /**
     * @param qtd the qtd to set
     */
    private void setQtd(int qtd) {
        this.qtd = qtd;
    }

    /**
     * adicionar adiciona um objeto
     *
     * @param obj objeto a ser adicionado
     */
    public void adicionar(Object obj){
        if (array == null){ // se for o primeiro elemento          
            setArray(new Object[1]);
            array[0] = obj; 
            setQtd(getQtd()+1);
        }
        else { // outros elementos
            // cria vetor auxiliar com mais um elemento
            Object aux[] = new Object[array.length+1];

            // copia todos elementos de vet para aux
            copiar(array, aux);

            // insere elemento novo
            aux[aux.length-1] = obj;

            // Transforma vetor auxiliar no atual
            setArray(aux);

            // incrementa contador de elementos    
            setQtd(getQtd()+1);

        }
    }

    /**
     * remover o objeto da posicao i
     *
     * @param i int, posicao do objeto
     */
    public Object remover(int i) {
        Object ret = null;
        if(buscar(i) != null){
            ret = array[i];
            // Libera elemento da sua posicao
            array[i] = null;

            if(getQtd() > 1){
                // cria vetor auxiliar com mes um elemento
                Object aux[] = new Object[array.length-1];

                // copia todos elementos de vet para aux
                copiar(array, aux);

                // Transforma vetor auxiliar no atual
                setArray(aux);
                // decrementa contador de elementos    
                setQtd(getQtd() - 1);
            } else {
                // acabou os elementos
                setArray(null);
                // decrementa contador de elementos    
                setQtd(0);

            }

        }
        return ret;
    }

    /**
     * buscar - retorna o objeto da posicao i
     *
     * @param i posicao onde esta o objeto
     * @return null se nao achar e endereco do objeto se achar
     */
    public Object buscar (int i){
        Object ret = null;
        if(array != null && (i >= 0 && i < getQtd())) {
            ret = array[i];
        }
        return ret;
    }

    /**
     * estaVazia - verifica se o array esta vazia
     *
     * @return true se estiver vazia e false se nao estiver vazia
     */
    public boolean estaVazia(){
        return (getQtd()==0 && getArray() == null);
    }

    /**
     * copiar - copia os objetos da origem para o destino
     *
     * @param origem array de Object
     * @param destino array de Object
     */
    private void copiar(Object origem[], Object destino[]){
        // copia todos
        int i, k = 0;
        for (i = 0; i < origem.length; i++){
            if (origem[i] != null) {
                destino[k] = origem[i];
                k++;
            }
        }       
    }

    /**
     * toString retorna um string com os dados
     *
     * @return string com os dados
     */
    public String toString(){
        String s = "[";
        if(array != null){
            for (int i = 0; i < array.length; i++){
                s += array[i].toString() + " ";
            }
        }
        s = s + "]";
        return s;
    }
}
