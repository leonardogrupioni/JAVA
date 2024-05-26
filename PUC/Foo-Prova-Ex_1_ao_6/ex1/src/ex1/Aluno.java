package ex1;

public class Aluno {
	
	private String RA = "";
	private String nome = "";
	private double nota1 = 0;
	private double nota2 = 0;
	private double notaTrab = 0;
	
	public Aluno(){
		setRA(RA); //matricula
		setNome(nome);
		setNota1(nota1);
		setNota2(nota2);
		setNotaTrab(notaTrab);
	}
	
	//setters and getters
	public String getRA() {
		return RA;
	}

	public void setRA(String rA) {
		RA = rA;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getNota1() {
		return nota1;
	}

	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}
	
	public double getNota2() {
		return nota2;
	}

	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}

	public double getNotaTrab() {
		return notaTrab;
	}

	public void setNotaTrab(double notaTrab) {
		this.notaTrab = notaTrab;
	}
	
	/* Objetivo: Calcula a media aritimetica das 2 provas com peso 2.5 e trabalho com peso 2
	 * 
	 * 
	 */
	public double Media(double nota1, double nota2, double notaTrab) {
		double media = 2.5 * nota1 + 2.5 * nota2 + 2 * notaTrab; //soma as notas
		media = media / 7; //divide por 7 para calcular a media aritimética
		return media;
	}
	
	public double Final(double media) {
		double notaFinal = 0;
		if(media < 5) {
			notaFinal = 5 - media;
		} else {
			notaFinal = 0.0; //o aluno ja possui a media minima
		}
			
		return notaFinal; 
	}
	
}
