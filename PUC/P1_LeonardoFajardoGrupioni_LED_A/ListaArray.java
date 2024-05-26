import java.util.ArrayList;
/**
 * Escreva a descrição da classe Lista aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class ListaArray implements IArmazenador {

    private ArrayList <Object> lista;

    public ListaArray(){
        setLista(new <Object>ArrayList());
    }

    /**
     * getLista
     * 
     * @return the vet
     */
    private ArrayList <Object> getLista() {
        return lista;
    }

    /**
     * getQtd
     * 
     * @return the qtd
     */
    public int getQtd() {
        return lista.size();
    }

    /**
     * setLista
     * 
     * @param vet the vet to set
     */
    private void setLista(ArrayList <Object>lista) {
        this.lista = lista;
    }

    /**
     * adicionar
     *
     * @param obj Um parâmetro
     */
    public void adicionar(Object obj){
        lista.add(obj);
    }

    /**
     * remover
     *
     * @param i Um parâmetro
     */
    public Object remover(int i) {
        Object ret = null;

        if (buscar(i) != null){
            ret = lista.get(i);
            lista.remove(i);
        }
        return ret;
    }

    /**
     * buscar
     *
     * @param i Um parâmetro
     * @return O valor de retorno
     */
    public Object buscar (int i){
        Object ret = null;
        if(!lista.isEmpty()&& (i >= 0 && i < getQtd())){
            ret = lista.get(i);
        }
        return ret;
    }

    /**
     * estaVazia
     *
     * @return O valor de retorno
     */
    public boolean estaVazia(){
        return (lista.isEmpty());
    }

    /**
     * toString
     *
     * @return O valor de retorno
     */
    public String toString(){
        String s = "[ ";
        for (int i = 0; i < lista.size(); i++){
            s += lista.get(i).toString() + " ";
        }
        s = s + "]";
        return s;
    }
}

