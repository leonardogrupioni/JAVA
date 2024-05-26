import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 * Converte temp C em F
 * 
 * @author Julio Arakaki 
 * @version 1.0 2023/04/11
 */
public class ConversorCF extends JFrame implements ActionListener {
    // // Atributos
    private JLabel entrada;
    private JLabel tempFahr;
    private JButton converter;
    private JTextField tempCelcius;

    /**
     * ConversorCF Construtor
     *
     * @param titulo String, nome da janela
     */
    ConversorCF(String titulo){
        // Criando a janela
        super (titulo);
        setSize(650, 140);
        setLocation(800, 100);

        //`Pega e Define atributos do container
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2,2));

        // Adiciona Label 1
        entrada = new JLabel("Forneca a temperatura em Celcius");
        cp.add(entrada, JLabel.CENTER);
        
        tempCelcius = new JTextField();
        tempCelcius.addActionListener(this);
        tempCelcius.setToolTipText("Temperatura em Celcius");
        tempCelcius.setBackground(Color.BLACK);
        tempCelcius.setForeground(Color.WHITE);
        // Adiciona caixa de texto
        cp.add(tempCelcius);

        // cria botao
        converter = new JButton("Converter"); 
        // Adiciona botao
        cp.add(converter);
        //converter.setBackground(Color.CYAN);
        //converter.setForeground(Color.RED);
        converter.addActionListener(this);
        converter.setToolTipText("Ccnverte Celcius em Fahrenheit");

        // Adiciona label 2
        tempFahr = new JLabel("Fahrenheit", JLabel.CENTER);
        tempFahr.setBackground(Color.WHITE);
        tempFahr.setForeground(Color.BLACK);
        tempFahr.setToolTipText("Resultado da conversao");
        cp.add(tempFahr);
    }

    /**
     * actionPerformed - realiza o evento
     *
     * @param ae evento gerado
     */
    public void actionPerformed(ActionEvent ae) {
        try{
            System.out.println(ae.getActionCommand());
            double t = (9./5.)*Double.parseDouble(tempCelcius.getText())+32.;
            tempFahr.setText(t+" F");
        }catch(Exception e){
            tempFahr.setText("Valor invalido!");
        }
    }
}
