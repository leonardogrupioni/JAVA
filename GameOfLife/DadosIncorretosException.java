public class DadosIncorretosException extends Exception {
    /**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	DadosIncorretosException() {
        super("Arquivo texto com dados incorretos.");
    }
    DadosIncorretosException(String msg) {
        super(msg);
    }
}
