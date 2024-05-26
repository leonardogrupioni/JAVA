
/**
 * Aplicativo para testar as classes.
 * 
 * @author Prof. Julio Arakaki
 * @version 1.0
 */
public class AplicacaoCalculadora {
    
    //instancia a entrada por interface
    IEntrada ent = new EntradaGUI();
    //IEntrada ent = new EntradaConsole();

    Utils util = new Utils();
    
    
    
    
    public void EntradaDados(){
        int opnd1 = 0;
        int opnd2 = 0;
        String operador = "";
        double result1 = 0;

        int sent = 0;
        
        int sair = 1;
        String aux;
        int sentinela = 0;
        int op = 0;
        
        String s = "Operações Realizadas: \n";
        
        
        //instancia os armazenadores
        
        IArmazenador armSoma = new VetDin();
        //IArmazenador armSoma = new ListaArray();
        
        IArmazenador armSub = new VetDin();
        //IArmazenador armSub = new ListaArray();
        
        
        IArmazenador armMul = new VetDin();
        //IArmazenador armMul = new ListaArray();
        
        
        IArmazenador armDiv = new VetDin();
        //IArmazenador armDiv = new ListaArray();
        
        
        String resultado = "";
        
    
        do{
            sair = 1;
            op = 0;
            
            
            aux = "";
            do{
                sentinela = 0;
                try{
                    //a variavel aux recebe uma entrada de dados
                    aux = ent.receberString(
                        "\n============ Menu ============\n" +
                        "   1. Usar Calculador Basica\n"+
                        "   2. Mostrar Relatório\n" +
                        "   3. Sair\n" +
                        "Escolha uma das opções anteriores: ");
                    op = Integer.parseInt(aux); //op recebe aux transformado de String para int
                    if(op < 1 || op > 3){
                        ent.imprimirMsg("\nDigite numeros de 1 a 3!!");
                        sentinela = 1;
                    }
                }
                catch (NumberFormatException e){
                    //verifica se o usuario entrou com um valor invalido ou clicou em cancell
                    if(aux == null){//verifica se o usuario clicou para cancelar e sai do programa
                        ent.imprimirMsg("\nSaindo do programa...");
                        System.exit(0);
                    }
                    else{
                        ent.imprimirMsg("\nDigite numeros de 1 a 3!!");
                        sentinela = 1;
                    }
                }
            }while(sentinela != 0);
            
            switch (op){
                case 1:
                    // Declaracao de variaveis
                    opnd1 = 0;
                    opnd2 = 0;
                    operador = "";
                    result1 = 0;
                    
                    sent = 0;
                    aux = "";
                    do{
                        try{
                            sent = 0;
                            aux = ent.receberString("Digite o primero valor: ");
                            opnd1 = Integer.parseInt(aux);
                        } catch(NumberFormatException e){ 
                            sent = 1;
                            ent.imprimirMsg("\nDigite um numero inteiro");
                        }
                        
                    }while(sent != 0);
                    
                    do{
                        sent = 0;
                        operador = ent.receberString("Digite o operador: (+) (-) (*) (/)");
                        String copy = operador;
                        if(util.validarOperador(operador)){
                            sent = 0;
                        } else{
                            sent = 1;
                            ent.imprimirMsg("Operador Invalido");
                        }
                    }while(sent !=0);
                    
                    aux = "";
                    do{
                        try{
                            sent = 0;
                            aux = ent.receberString("Digite o segundo valor: ");
                            opnd2 = Integer.parseInt(aux);
                        } catch(NumberFormatException e){ 
                            sent = 1;
                            ent.imprimirMsg("\nDigite um numero inteiro");
                        }
                        
                    }while(sent != 0);
                    
                    
                    // Instanciacao de objeto da classe (criacao de objeto)
                    CalculadoraBasica cb = new CalculadoraBasica(opnd1, operador, opnd2);
                    
                    // Aciona metodo 
                    result1 = cb.calcular();
            
                    // Mostra resultado
                    
                    resultado = "Resultado da Operação:" + cb + "=" + result1 + "\n";
                    ent.imprimirMsg(resultado);
                    
                    //guardar no armazenador adequado ao operador                  
                    if(operador.equals("+"))armSoma.adicionar(resultado);
                    else if(operador.equals("-")) armSub.adicionar(resultado);
                    else if(operador.equals("*")) armMul.adicionar(resultado);
                    else if(operador.equals("/")) armDiv.adicionar(resultado);
                    
                    break;
                case 2:
                    //mostrar resultados
                    s = ("\nOperações realizadas de Soma: \n" + (armSoma) +
                         "\nOperações realizadas de Subtração: \n" + (armSub) + 
                         "\nOperações realizadas de Multiplição: \n" + (armMul) + 
                         "\nOperações realizadas de Divisão: \n" + (armDiv));
                    ent.imprimirRelatorio(s);
                    break;
                case 3:
                    sair = 0;
                    break;
            }
            
        }while(sair != 0 );
    }
}