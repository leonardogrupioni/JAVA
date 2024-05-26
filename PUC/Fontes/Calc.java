class Calc {
	public static void main(String args[]){
		double operando1 = Double.parseDouble(args[0]);
		double operando2 = Double.parseDouble(args[2]);
		double resultado;
		
		char operador = args[1].charAt(0);
		
		if (operador == '+'){
			resultado = operando1 + operando2;
			System.out.println("Resultado = " + resultado);
		} else {
			System.out.println("Invalido");
			
		}
		
	}
}
