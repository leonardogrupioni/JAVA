package ex2;

public class Voo {
	    public int max = 100;
	    private int numeroVoo;
	    Data data;
	    public int[] cadeiras = new int[max];

	    public Voo(int numeroVoo,int dia,int mes,int ano,int cadeira) {
	        setNumeroVoo(numeroVoo);
	        data = new Data(dia,mes,ano);
	        setData(data);
	        inicializaCadeiras();
	        
	        ocupa(cadeira);
	        
	    }

	    public int getVoo() {
	        return numeroVoo;
	    }

	    public void setNumeroVoo(int numeroVoo) {
	        this.numeroVoo = numeroVoo;
	    }

	    public Data getData() {
	        return data;
	    }

	    public void setData(Data data) {
	        this.data = data;
	    }

	    public int proximoLivre() {
	        int livre = -1;
	        int i = 0;
	        while(livre != -1 && i < max) {
	        	if(cadeiras[i] == 0) {
	        		livre = i;
	        	}
	        	i++;
	        }
	        return livre; //se retornar -1 (fantasma) o voo esta lotado 
	    }
	    
	    public boolean verifica(int cadeira) {
	        if(cadeiras[cadeira] == 1) {
	        	return true; //ocupada
	        }
	        return false; //descoupada
	    }
	    public void inicializaCadeiras() {
	    	for(int i = 0; i < max; i++) {
	    		this.cadeiras[i] = 0;
	    	}
	    }
	    public boolean ocupa(int cadeira) {
	    	if(!verifica(cadeira)) {
	    		this.cadeiras[cadeira] = 1;
	    		return true;
	        } 
	    	return false;
	    }
	    
	    public int vagas() {
	    	int vagasLivres = 0;
	    	for(int i = 0; i < max; i++) {
	    		if(this.cadeiras[i] == 0) {
	    			vagasLivres++;
	    		}
	    	}	    	
	    	return vagasLivres;
	    }
	    
	    public Voo clone(int numeroVoo,int dia,int mes,int ano,int cadeira) {
			Voo vooClone = new Voo(numeroVoo, dia, mes, ano, cadeira);
			return vooClone;
		}   
	
}
