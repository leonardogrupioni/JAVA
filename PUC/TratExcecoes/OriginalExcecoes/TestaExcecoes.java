import javax.swing.JOptionPane;


public class TestaExcecoes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String aux = null;

		try{
			int x = 10, y = 0, vet[] = new int[1];
			vet[0] = 10;
			vet[1] = 20;
			aux = JOptionPane.showInputDialog("Forneça um inteiro: ");
			y = Integer.parseInt(aux);
			calculaAlgo(y);
			System.out.println(x/y);

		}catch(ArithmeticException e){
			System.out.println(e.getMessage());
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Estouro de array!");
		}catch(NumberFormatException e){
			if (aux == null){
				System.out.println("Foi cancelado!");
			}else{
				System.out.println("Erro de formato do numero!");
			}
		}catch (NumeroNegativoException e){
			System.out.println(e.getMessage());
		}catch(Exception e){
			System.out.println("Outra excecao!");
		}

	}

	static void calculaAlgo(int x)throws NumeroNegativoException, ArithmeticException {
		if (x == 0){
			throw new ArithmeticException("Valor zerado!");
		}
		else if(x < 0){
			throw new NumeroNegativoException("Erro: numero negativo");
		}

	}

}
