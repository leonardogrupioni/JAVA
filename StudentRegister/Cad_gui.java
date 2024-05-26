
/**
 * Interface grafica para entrada de dados da pessoa.
 * 
 * @author Julio Arakaki
 * @version 04/05/2023
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Cad_gui extends JFrame implements ActionListener {
    // botoes para menu inicial
    private JButton btnCadastrar, btnListar, btnSair;

    // componentes para dados do cliente
    private JLabel lblNome, lblIdade, lblRg, lblRa, lblCurso, lblDisciplinas;
    private JTextField txfNome, txfIdade, txfRg, txfRa, txfCurso, txfDisciplinas;
    private JButton btnInserir, btnNovo;
    private JComboBox cbQtdDisc;

    // armazenador
    CadastroAlunos cad;

    /**
     * Cad_gui Construtor
     *
     */
    public Cad_gui(String titulo) {

        super(titulo);
        setSize(300, 84);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inicia armazenador de clientes
        cad = new CadastroAlunos();

        // Painel inicial
        JPanel pnMenu = new JPanel();
        // Botoes iniciais
        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(this);
        btnSair = new JButton("Sair");
        btnSair.addActionListener(this);
        btnListar = new JButton("Listar");
        btnListar.addActionListener(this);

        // Insere botoes no painel inicial
        pnMenu.add(btnCadastrar);
        pnMenu.add(btnListar); 
        pnMenu.add(btnSair); 

        // Paine de cadastro
        JPanel pnEntDados = new JPanel();
        pnEntDados.setLayout(new GridLayout(8, 2));

        // labels
        lblNome = new JLabel("Nome ", JLabel.RIGHT);
        lblIdade = new JLabel("Idade ", JLabel.RIGHT);
        lblRg = new JLabel("RG ", JLabel.RIGHT);
        lblRa = new JLabel("Ra ", JLabel.RIGHT);
        lblCurso = new JLabel("Curso ", JLabel.RIGHT);
        lblDisciplinas = new JLabel("Qtde. de disciplinas ", JLabel.RIGHT);

        // TextFields
        txfNome = new JTextField(10);
        txfIdade = new JTextField(10);
        txfRg = new JTextField(10);
        txfRa = new JTextField(10);
        txfCurso = new JTextField(10);
        txfCurso.addActionListener(this);
        String qtde[] = {"0","1","2","3","4","5","6","7"};
        cbQtdDisc = new JComboBox(qtde);
        cbQtdDisc.addActionListener(this);

        txfDisciplinas = new JTextField(10);
        txfDisciplinas.setEditable(false);

        // botoes
        btnInserir = new JButton("Inserir");
        btnInserir.addActionListener(this);
        btnNovo = new JButton("Novo Aluno");
        btnNovo.addActionListener(this);
        btnNovo.setEnabled(false);

        // Adiciona os componentes
        pnEntDados.add(lblNome);
        pnEntDados.add(txfNome);

        pnEntDados.add(lblIdade);
        pnEntDados.add(txfIdade);

        pnEntDados.add(lblRg);
        pnEntDados.add(txfRg);

        pnEntDados.add(lblRa);
        pnEntDados.add(txfRa);

        pnEntDados.add(lblCurso);
        pnEntDados.add(txfCurso);

        pnEntDados.add(lblDisciplinas);
        pnEntDados.add(cbQtdDisc);

        pnEntDados.add(btnInserir);
        pnEntDados.add(btnNovo);

        // Painel principal
        JPanel pnPrincipal = new JPanel();
        // adiciona os dois paineis de componentes no pinel principal
        pnPrincipal.add(pnMenu);
        pnPrincipal.add(pnEntDados);
        setContentPane(pnPrincipal);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    /**
     * actionPerformed, processa os eventos
     *
     * @param e ActionEvent, armazena eventos
     */
    public void actionPerformed(ActionEvent e) {
        if ((e.getSource() == btnInserir) || (e.getSource() == txfCurso)) {
            try{
                String nome = txfNome.getText();
                int idade = Integer.parseInt(txfIdade.getText());
                String rg = txfRg.getText();
                String ra = txfRg.getText();
                String curso = txfCurso.getText();

                // Cria cliente
                Aluno a = new Aluno(nome, idade, rg, ra, curso, null);

                // Armazena em memoria
                cad.adicionarAluno(a);
                btnNovo.setEnabled(true);

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Dados invalidos!!");

            }
        } else if(e.getSource() == btnNovo){
            limparCampos();
            btnNovo.setEnabled(false);
        } else if(e.getSource() == btnCadastrar){
            setSize(300, 300);
            btnCadastrar.setEnabled(false);
        } else if(e.getSource() == btnListar){
            if(cad.getQtd() > 0){
                JOptionPane.showMessageDialog(null, cad);
            } else {
                JOptionPane.showMessageDialog(null, "Cadastro vazio.");
            }

        } else if(e.getSource() == cbQtdDisc){
            String item = ""+cbQtdDisc.getItemAt(cbQtdDisc.getSelectedIndex());
            int qtde = Integer.parseInt(item);
            for (int i = 0; i < qtde; i++){
                
            }
            
            System.out.println(item);
        } else if(e.getSource() == btnSair){
            System.exit(0);
        }
    }

    /**
     * limparCampos
     *
     */
    public void limparCampos(){
        txfNome.setText("");
        txfIdade.setText("");
        txfRg.setText("");
        txfRa.setText("");
        txfCurso.setText("");
        txfDisciplinas.setText("");
    }
}
