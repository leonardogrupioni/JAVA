/**
 * class NumeroNegativoException - exemplo de criação de exception
 */
public class NumeroNegativoException extends Exception{
    /**
     * NumeroNegativoException Construtor
     *
     */
    NumeroNegativoException(){
        super("Numero Negativo.");
    }

    /**
     * NumeroNegativoException Construtor
     *
     * @param msg, String mensagem a ser emitida
     */
    NumeroNegativoException(String msg){
        super(msg);
    }
}
