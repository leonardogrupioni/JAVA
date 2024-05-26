/**
 * IEntrada é a interface para entrada e saida de dados, que contem a 
 * assinatura dos metodos contidos nos modelos de Console ou GUI
 * 
 * @author João Pedro Figols, Julia Schmidt, Igor Matos, Leonardo Grupioni 
 * @version v2.0 11/04/2023
 */

public interface IEntrada
{ 
    //interface ou assinaturas dos metodos
    public String receberString(String msg);
    public void imprimirMsg(String msg);
    public void imprimirRelatorio(String relatorio);
}