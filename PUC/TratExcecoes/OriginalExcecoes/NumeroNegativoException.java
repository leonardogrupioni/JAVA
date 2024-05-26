
public class NumeroNegativoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	NumeroNegativoException(){
		super("Numero Negativo.");
	}
	NumeroNegativoException(String msg){
		super(msg);
	}
}
