import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.StringTokenizer;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * Implementa o ambiente grafico para o Jogo da Vida
 */
public class LifeGraf extends Life implements MouseListener, 
ActionListener, MouseMotionListener {

    Simulacao _simular;
    //Janela principal.
    JFrame _jframe = null; 

    // Componentes para o ambiente
    Container _pAmbiente = null; // container do Ambiente (celulas)
    JLabel [][]_labels = null;  // matriz de labels 

    Color _corCelulas = null;
    Color _corFundo = null;
    Color _corBorda = null;

    // Componentes para os botoes
    Container _pBotoes = null;   // container dos botoes 
    JButton _jbProx = null;
    JButton _jbLimpar = null;
    JButton _jbSair = null;
    JButton _jbIniciar = null;
    JButton _jbFinalizar = null;
    JButton _jbSalvar = null;
    JButton _jbLer = null;

    // Componentes para menu
    JMenuBar _menuBar;
    JMenu _menuArquivo, _menuOpcoes, _menuOpcoesCores, _menuOpcoesTipoJanela,_menuAjuda;
    JMenuItem _menuArquivoSalvar, _menuArquivoLer, _menuArquivoSair, _menuAjudaSobre, _menuOpcoesCoresCelula, 
    _menuOpcoesCoresFundo, _menuOpcoesCoresOriginais;
    JRadioButtonMenuItem _rbMenuItem;

    /**
     * @return Returns the _corBorda.
     */
    protected Color getCorBorda() {
        return _corBorda;
    }

    /**
     * @param borda The _corBorda to set.
     */
    protected void setCorBorda(Color borda) {
        _corBorda = borda;
    }

    /**
     * @return Returns the _corCelulas.
     */
    protected Color getCorCelulas() {
        return _corCelulas;
    }

    /**
     * @param celulas The _corCelulas to set.
     */
    protected void setCorCelulas(Color celulas) {
        _corCelulas = celulas;
    }

    /**
     * @return Returns the _corFundo.
     */
    protected Color getCorFundo() {
        return _corFundo;
    }

    /**
     * @param fundo The _corFundo to set.
     */
    protected void setCorFundo(Color fundo) {
        _corFundo = fundo;
    }

    /**
     * Construtor - inicia o ambiente (matriz) para o jogo da vida
     * @param linhas linhas para o ambiente
     * @param colunas colunas para o ambiente
     */
    LifeGraf (int linhas, int colunas) {

        // Ativa construtor pai e Cria o ambiente (matriz)
        super(linhas, colunas);

        _jframe = new JFrame("Jogo da Vida");
        _jframe.setSize(500, 500);
        _jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // painel de ambiente
        _pAmbiente = new JPanel(); // cria painel
        _pAmbiente.setLayout(new GridLayout(linhas, colunas)); // define layout
        _labels = new JLabel [linhas][colunas]; // cria array de jpanels
        setCorCelulas(Color.BLUE);
        setCorFundo(Color.BLACK);
        setCorBorda(Color.GRAY);

        // painel de botoes
        _pBotoes = new JPanel();
        // Define layout dos botoes
        _pBotoes.setLayout (new FlowLayout ());

        // Menu bar
        _menuBar = new JMenuBar();
    }

    /**
     * Adiciona os componentes na janela
     * @param frame janela principal (JFrame)
     */
    public void adicionaComponentes() {

        // Pega o container da janela principal
        Container pane = _jframe.getContentPane();

        // Insere painel de ambiente e as celulas(jlabels)
        inserePainelAmbiente(pane);

        // Insere painel de botoes e os botoes 
        inserePainelBotoes(pane);

        // Insere opcoes de menu
        insereMenu();
    }

    /**
     * Trata evento mouse pressionado
     * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
     */
    public void mousePressed(MouseEvent e) {
        Component c = e.getComponent();

        // Se for pressionado um JLabel
        if (c instanceof JLabel) {
            JLabel jl = (JLabel)c;
            StringTokenizer st = new StringTokenizer (jl.getText(), ",");
            int linha = Integer.parseInt(st.nextToken());
            int coluna = Integer.parseInt(st.nextToken());
            // Toggle
            if (getAmbiente()[linha][coluna].getValorCelula() == false ){
                jl.setBackground(getCorCelulas());
                jl.setForeground(getCorCelulas());
                getAmbiente()[linha][coluna].setValorCelula(true);
            } else {
                jl.setBackground(getCorFundo());
                jl.setForeground(getCorFundo());
                getAmbiente()[linha][coluna].setValorCelula(false);
            }
        }
        // Se for pressionado um JButton
        else if (c instanceof JButton) {
            JButton jb = (JButton)c;
            if(jb.getText().equals("Proxima geracao")){
                calcularProximaGeracao();
                desenhaAmbiente(); 
            }
            else if(jb.getText().equals("Limpar")){
                limparAmbiente();
                desenhaAmbiente(); 
            }
            else if(jb.getText().equals("Iniciar")){
                iniciarAnimacao();
            }
            else if(jb.getText().equals("Finalizar")){
                finalizarAnimacao();
            }
            else if(jb.getText().equals("Salvar")){
                salvarEstado();
            }
            else if(jb.getText().equals("Ler")){
                lerEstado();
                desenhaAmbiente(); 
            }
            else if(jb.getText().equals("Sair")){
                System.exit(0);
            }
        }
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
     */
    public void mouseDragged(MouseEvent e) {
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
     */
    public void mouseMoved(MouseEvent e) {
    }

    /**
     * Trata eventos de opcoes de menu
     * @param e comando correspondente a opcao
     */
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.equals("Sair")){
            System.exit(0);
        } else if (comando.equals("Salvar")){
            salvarEstado();
        } else if (comando.equals("Ler")){
            lerEstado();
            desenhaAmbiente(); 
        } else if (comando.equals("Sobre")){
            sobre();
        } else if (comando.equals("Motif")){
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                SwingUtilities.updateComponentTreeUI(_jframe);
                _jframe.pack();
            } catch (Exception ex){

            }
        } else if (comando.equals("Windows")){
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                SwingUtilities.updateComponentTreeUI(_jframe);
                _jframe.pack();
            } catch (Exception ex){

            }
        } else if (comando.equals("Metal")){
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                SwingUtilities.updateComponentTreeUI(_jframe);
                _jframe.pack();
            } catch (Exception ex){

            }
        } else if(comando.equals("Cor da Celula")) {
            Color corAux = JColorChooser.showDialog(_menuOpcoesCoresCelula, "Seleciona Cor das Celulas", getCorCelulas());
            if (corAux != null){
                setCorCelulas(corAux);
                desenhaAmbiente();
                _menuOpcoesCoresOriginais.setEnabled(true);
            }
        } else if(comando.equals("Cor de Fundo da Celula")) {
            Color corAux = JColorChooser.showDialog(_menuOpcoesCoresCelula, "Seleciona Cor de Fundo das Celulas", getCorCelulas());
            if (corAux != null){
                setCorFundo(corAux);
                desenhaAmbiente();
                _menuOpcoesCoresOriginais.setEnabled(true);
            }
        } else if(comando.equals("Restaura Cores Originais")) {
            setCorCelulas(Color.BLUE);
            setCorFundo(Color.BLACK);
            desenhaAmbiente();
            _menuOpcoesCoresOriginais.setEnabled(false);
        }
    }

    private void desenhaAmbiente(){
        for (int i = 0; i < getAmbiente().length; i++) {
            for (int j = 0; j < getAmbiente()[i].length; j++) {
                if (getAmbiente()[i][j].getValorCelula() == true) {
                    _labels[i][j].setBackground(getCorCelulas());
                    _labels[i][j].setForeground(getCorCelulas());
                }
                else {
                    _labels[i][j].setBackground(getCorFundo());
                    _labels[i][j].setForeground(getCorFundo());
                }
            }
        }
    }

    private class Simulacao extends Thread {
        public boolean continuar = true;

        public void run() {
            try {
                while (continuar) {
                    calcularProximaGeracao();
                    desenhaAmbiente(); 
                    sleep(300);
                }	
            } catch (InterruptedException e) {
                System.out.println("ERRO INESPERADO");
                System.exit(0);
            }	
        }
    }

    public void iniciarAnimacao() {
        _simular = new Simulacao();
        _simular.start();
        _jbIniciar.setEnabled(false);
        _jbFinalizar.setEnabled(true);
    }

    public void finalizarAnimacao() {
        _simular.continuar = false;
        _jbIniciar.setEnabled(true);
        _jbFinalizar.setEnabled(false);
        _simular = null;
    }

    /**
     * Mostra a interface com os componentes
     */
    public void mostraAmbienteGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true); // Estilo Java (default)

        //Define a janela e adiciona os componentes.
        adicionaComponentes();

        //Mostra a janela.
        _jframe.pack();
        _jframe.setVisible(true);
    }

    private void inserePainelAmbiente(Container pane){

        // Cria e define os jlabels para o ambiente
        for (int i = 0; i < _labels.length; i++) {
            for (int j = 0; j < _labels[i].length; j++) {
                // Cria o jlabel de define os atributos
                _labels[i][j] =  new JLabel (""+ i +","+ j);
                _labels[i][j].setPreferredSize(new Dimension (15, 15));
                _labels[i][j].setMaximumSize(new Dimension (15, 15));
                _labels[i][j].setMinimumSize(new Dimension (15, 15));
                _labels[i][j].setToolTipText("(" + (39-i) + "," + (39-j) + ")");
                _labels[i][j].setOpaque(true);
                _labels[i][j].setForeground(getCorFundo());
                _labels[i][j].setBorder(BorderFactory.createLineBorder(getCorBorda()));
                _labels[i][j].setBackground(getCorFundo());
                _labels[i][j].addMouseListener(this);
                _labels[i][j].addMouseMotionListener(this);

                // Adiciona o jlabel para o painel de ambiente
                _pAmbiente.add(_labels[i][j], 0);
            }
        }
        // Adiciona o painel de jlabels na posicao norte da janela principal 
        pane.add ("North", _pAmbiente);
    }

    private void inserePainelBotoes(Container pane){
        // Cria os botoes
        _jbProx = new JButton ("Proxima geracao");
        _jbProx.setToolTipText("Mostra proxima geracao");
        _jbProx.addMouseListener(this);

        _jbLimpar = new JButton ("Limpar");
        _jbLimpar.setToolTipText("Limpa ambiente");
        _jbLimpar.addMouseListener(this);

        _jbIniciar = new JButton ("Iniciar");
        _jbIniciar.setToolTipText("Inicia Simulacao");
        _jbIniciar.addMouseListener(this);

        _jbFinalizar = new JButton ("Finalizar");
        _jbFinalizar.setToolTipText("Finaliza Simulacao");
        _jbFinalizar.addMouseListener(this);
        _jbFinalizar.setEnabled(false);

        _jbSalvar = new JButton ("Salvar");
        _jbSalvar.setToolTipText("Salvar estado...");
        _jbSalvar.addMouseListener(this);

        _jbLer = new JButton ("Ler");
        _jbLer.setToolTipText("Carregar estado...");
        _jbLer.addMouseListener(this);

        _jbSair = new JButton ("Sair");
        _jbSair.setToolTipText("Termina programa");
        _jbSair.addMouseListener(this);

        // adiciona os botoes
        _pBotoes.add (_jbProx);
        _pBotoes.add (_jbLimpar);
        _pBotoes.add (_jbIniciar);
        _pBotoes.add (_jbFinalizar);
        _pBotoes.add (_jbSalvar);
        _pBotoes.add (_jbLer);
        _pBotoes.add (_jbSair);

        //adiciona o painel de botoes na posi��o sul da janela principal
        pane.add ("South", _pBotoes);
    }

    private void insereMenu(){
        // Menu
        // Arquivo
        _menuArquivo = new JMenu("Arquivo");
        _menuArquivo.setMnemonic(KeyEvent.VK_A);
        _menuBar.add(_menuArquivo);

        // Arquivo item Salvar
        _menuArquivoSalvar = new JMenuItem("Salvar", KeyEvent.VK_G);
        _menuArquivoSalvar.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_G, ActionEvent.ALT_MASK));
        _menuArquivoSalvar.getAccessibleContext().setAccessibleDescription(
            "This doesn't really do anything");
        _menuArquivoSalvar.addActionListener(this);
        _menuArquivo.add(_menuArquivoSalvar);

        // Arquivo item Salvar
        _menuArquivoLer = new JMenuItem("Ler", KeyEvent.VK_L);
        _menuArquivoLer.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_L, ActionEvent.ALT_MASK));
        _menuArquivoLer.getAccessibleContext().setAccessibleDescription(
            "This doesn't really do anything");
        _menuArquivoLer.addActionListener(this);
        _menuArquivo.add(_menuArquivoLer);

        // Arquivo item Sair
        _menuArquivoSair = new JMenuItem("Sair", KeyEvent.VK_S);
        _menuArquivoSair.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.ALT_MASK));
        _menuArquivoSair.getAccessibleContext().setAccessibleDescription(
            "This doesn't really do anything");
        _menuArquivoSair.addActionListener(this);
        _menuArquivo.add(_menuArquivoSair);

        // Opcoes
        _menuOpcoes = new JMenu("Opcoes");
        _menuOpcoes.setMnemonic(KeyEvent.VK_O);
        _menuBar.add(_menuOpcoes);

        // Tipo Janela submenu de Opcoes
        _menuOpcoesTipoJanela = new JMenu("Tipos de Janela");
        _menuOpcoesTipoJanela.setMnemonic(KeyEvent.VK_C);
        _menuOpcoes.add(_menuOpcoesTipoJanela);

        ButtonGroup group = new ButtonGroup();
        _rbMenuItem = new JRadioButtonMenuItem("Windows");
        _rbMenuItem.setSelected(true);
        _rbMenuItem.setMnemonic(KeyEvent.VK_W);
        _rbMenuItem.addActionListener(this);
        group.add(_rbMenuItem);
        _menuOpcoesTipoJanela.add(_rbMenuItem);

        _rbMenuItem = new JRadioButtonMenuItem("Motif");
        _rbMenuItem.setMnemonic(KeyEvent.VK_M);
        _rbMenuItem.addActionListener(this);
        group.add(_rbMenuItem);
        _menuOpcoesTipoJanela.add(_rbMenuItem);

        _rbMenuItem = new JRadioButtonMenuItem("Metal");
        _rbMenuItem.setMnemonic(KeyEvent.VK_T);
        _rbMenuItem.addActionListener(this);
        group.add(_rbMenuItem);
        _menuOpcoesTipoJanela.add(_rbMenuItem);

        // Adiciona separador
        //_menuOpcoesTipoJanela.addSeparator();

        // Cores submenu de Opcoes
        _menuOpcoesCores = new JMenu("Cores");
        _menuOpcoesCores.setMnemonic(KeyEvent.VK_C);
        _menuOpcoes.add(_menuOpcoesCores);
        // Cores item Cor Celula
        _menuOpcoesCoresCelula = new JMenuItem("Cor da Celula", KeyEvent.VK_C);
        _menuOpcoesCoresCelula.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_C, ActionEvent.ALT_MASK));
        _menuOpcoesCoresCelula.getAccessibleContext().setAccessibleDescription(
            "This doesn't really do anything");
        _menuOpcoesCoresCelula.addActionListener(this);
        _menuOpcoesCores.add(_menuOpcoesCoresCelula);
        // Cores item Cor Fundo
        _menuOpcoesCoresFundo = new JMenuItem("Cor de Fundo da Celula", KeyEvent.VK_F);
        _menuOpcoesCoresFundo.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_F, ActionEvent.ALT_MASK));
        _menuOpcoesCoresFundo.getAccessibleContext().setAccessibleDescription(
            "This doesn't really do anything");
        _menuOpcoesCoresFundo.addActionListener(this);
        _menuOpcoesCores.add(_menuOpcoesCoresFundo);

        // Adiciona separador
        _menuOpcoesCores.addSeparator();
        // Cores item Cor Borda
        _menuOpcoesCoresOriginais = new JMenuItem("Restaura Cores Originais", KeyEvent.VK_R);
        _menuOpcoesCoresOriginais.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_R, ActionEvent.ALT_MASK));
        _menuOpcoesCoresOriginais.getAccessibleContext().setAccessibleDescription(
            "This doesn't really do anything");
        _menuOpcoesCoresOriginais.addActionListener(this);
        _menuOpcoesCoresOriginais.setEnabled(false);
        _menuOpcoesCores.add(_menuOpcoesCoresOriginais);

        // Ajuda
        _menuAjuda = new JMenu("Ajuda");
        _menuAjuda.setMnemonic(KeyEvent.VK_J);
        _menuBar.add(_menuAjuda);

        // Ajuda item Sobre
        _menuAjudaSobre = new JMenuItem("Sobre", KeyEvent.VK_S);
        _menuAjudaSobre.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.ALT_MASK));
        _menuAjudaSobre.getAccessibleContext().setAccessibleDescription(
            "This doesn't really do anything");
        _menuAjudaSobre.addActionListener(this);
        _menuAjuda.add(_menuAjudaSobre);

        _jframe.setJMenuBar(_menuBar);

    }

    private void sobre(){
        String texto = "Jogo da Vida\nVersao 1.0\n\n"
            + "(c) Copyright 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016. Todos os direitos reservados.\n\n"
            + "LED - Laboratorio de Estruturas Dinamicas\n"
            + "Prof. Dr. Julio Arakaki\nCiencia da Computacao - PUCSP";

        JOptionPane.showMessageDialog(null, texto, "Sobre Jogo da Vida", JOptionPane.INFORMATION_MESSAGE);
    }
}

