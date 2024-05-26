// Celula basica
public class Celula {

    boolean _valorCelula;
    

    Celula(){
        _valorCelula = false;
    }

    public boolean getValorCelula() {
       return _valorCelula;
    }

    /**
     * setValorCelula
     *
     * parametros:
     *  entrada:    int valorCelula: false - Morta, true - Viva
     *  saida:
     *
     * retorno:
     */
    public void setValorCelula(boolean valorCelula) {
       _valorCelula = valorCelula;
    }

}
