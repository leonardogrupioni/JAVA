package ex2;

public class Data {
	//data = "dd/mm/aaaa" = ddmmaaaa
	private int dia = 0;
	private int mes = 0;
	private int ano = 0;
	
	public Data(int dia, int mes, int ano) {
		setDia(dia);
		setMes(mes);
		setAno(ano);
		
		if(!verificaData(dia, mes, ano)) {
			formata(dia, mes, ano);
		}
	}
	
	public boolean verificaData(int dia, int mes, int ano) {
		if(mes > 0 && mes < 13) {
			if(ano > 0) {
				switch(mes) {
					case 4, 6, 9, 11: //30 dias
						if(dia > 0 && dia < 31) {
							return true;
						} 
						break;
					case 1, 3, 5, 7, 8, 10, 12://31 dia	
						if(dia > 0 && dia < 32){
							return true;
						} 
						break;
					case 2:  //fevereiro
						if(isBissexto(ano)) {
							if(dia > 0 && dia < 30) {
								return true;
							} 
							break;
						} else {
							if (dia > 0 && dia < 29) {
								return true;
							} 
							break;
						}
				}			
			}
		} return false;
	}
	
	public boolean isBissexto(int ano) {
		int aux = 0;
		aux = ano % 4;
		if(aux == 0) {
			return true;
		}
		return false;
	}
	
	public void formata(int dia, int mes, int ano) {
		dia = 1;
		mes = 1;
		ano = 1;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public String getMesExtenso(int mes) {
	    String mesExtenso = "";
	    switch (mes) {
	        case 1:
	            mesExtenso = "Janeiro";
	            break;
	        case 2:
	            mesExtenso = "Fevereiro";
	            break;
	        case 3:
	            mesExtenso = "Março";
	            break;
	        case 4:
	            mesExtenso = "Abril";
	            break;
	        case 5:
	            mesExtenso = "Maio";
	            break;
	        case 6:
	            mesExtenso = "Junho";
	            break;
	        case 7:
	            mesExtenso = "Julho";
	            break;
	        case 8:
	            mesExtenso = "Agosto";
	            break;
	        case 9:
	            mesExtenso = "Setembro";
	            break;
	        case 10:
	            mesExtenso = "Outubro";
	            break;
	        case 11:
	            mesExtenso = "Novembro";
	            break;
	        case 12:
	            mesExtenso = "Dezembro";
	            break;
	    }
	    return mesExtenso;
	}
	
	public int compara(Data data2) {
		int totalData1 = 0;
		int totalData2 = 0;
		totalData1 = this.ano + this.mes + this.dia; 
		totalData2 = data2.ano + data2.mes + data2.dia;
		if(totalData1 < totalData2) {
			return -1;
		} else if(totalData1 > totalData2) {
			return 1;
		} 
		return 0;
	}

	public Data clone() {
		Data dataClone = new Data(this.dia, this.mes, this.ano);
		return dataClone;
	}

}
