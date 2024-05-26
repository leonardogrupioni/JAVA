package ex1;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Aluno aluno = new Aluno();
		
		aluno.setRA("00666777");
		aluno.setNome("Wladimir Corno");
		aluno.setNota1(1.2);
		aluno.setNota2(2.2);
		aluno.setNotaTrab(3.3);
		
		double media = aluno.Media(aluno.getNota1(), aluno.getNota2(), aluno.getNotaTrab());
		System.out.println(" A media do aluno eh " + String.format("%.2f", media));
		double provaFinal = aluno.Final(media);
		if(provaFinal != 0) {
			System.out.println(" O aluno precisa tirar " + String.format("%.2f", provaFinal) + " na prova final");
		} else {
			System.out.println(" O aluno não precisa fazer a prova final, pois já possuí a média necessária");
		}
		
	}

}
