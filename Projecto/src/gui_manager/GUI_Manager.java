/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GUI_Manager.java
 *
 * Created on 11/Nov/2010, 17:49:28
 */

package gui_manager;

import com.toedter.calendar.JCalendar;
import gestores.*;
import gestores_manager.GestorUtilizadores;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.SpinnerNumberModel;
import outros.Consts;
import outros.Filme;
import outros.OurListModel;
import outros.Utils;

/**
 *
 * @author Daniela
 */
public class GUI_Manager extends javax.swing.JFrame implements PropertyChangeListener {
    //Gestores
    private GestorUtilizadores gestorUtilizadores;
    private GestorFilmes gestorFilmes;
    private GestorClientes gestorClientes;
    private GestorEmpregados gestorEmpregados ;
    private GestorMaquinas gestorMaquinas ;
    private GestorEstatisticas gestorEstatisticas;

    //Variaveis adicionais
    private String filePath;
    private GregorianCalendar calendarBegin;
    private GregorianCalendar calendarEnd;
    private JCalendar jCalendarBegin;
    private JCalendar jCalendarEnd;
    
    
    
    
    public static void main(String args[]) {
    	Utils.dbg("Here");
        new GUI_Manager().setVisible(true);
        //adds the panels to the interface

        Scanner sc = new Scanner(System.in);
        sc.next();
    }
    
    
    
    
    /** Creates new form GUI_Manager */
    public GUI_Manager() {

        filePath="";
        gestorUtilizadores=new GestorUtilizadores();
        gestorMaquinas =new GestorMaquinas();
        gestorEmpregados =new GestorEmpregados();
        gestorClientes=new GestorClientes();
        gestorFilmes=new GestorFilmes();
        gestorEstatisticas=new GestorEstatisticas();

        initComponents();
    //initializes all the componentes needed in the GUI

        setSize(800, 600);
	setTitle("Manager");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
        add(mainPanel);
        
        mainPanel.setVisible(true);
        init();

        //Cria um button Group para 2 radio buttons
        bgroup=new ButtonGroup();
        
        bgroup.add(adminRadio);
        bgroup.add(opRadio);

    }

      public void init(){

        mainPanel.setLayout(null);
        
        
        mainPanel.add(jLoginPanel);
        
        mainPanel.add(jMenuAdministradorPanel);
        mainPanel.add(jMenuOperatorPanel);
        
        //Set panel's visibility
        
        
        jLoginPanel.setVisible(true);
       
        jMenuOperatorPanel.setVisible(false);
        jMenuAdministradorPanel.setVisible(false);
       
        //Alignes the panels in the frame

        jAdicionarFilmePanel.setBounds(0, -1, 800, 600);
        jEliminarFilmePanel.setBounds(0, -1, 800, 600);
        jLoginPanel.setBounds(0, -1, 800, 600);
        jGenerosPanel.setBounds(0, -1, 800, 600);
        jMenuOperatorPanel.setBounds(0, -1, 800, 600);
        jMenuAdministradorPanel.setBounds(0, -1, 800, 600);
        jResultadosFilmePanel.setBounds(0, -1, 800, 600);
        jPesqisaFilmesPanel.setBounds(0, -1, 800, 600);
        jAdicionarClientePanel.setBounds(0, -1, 800, 600);
        jEliminarClientePanel.setBounds(0, -1, 800, 600);
        jNotificarClientePanel.setBounds(0, -1, 800, 600);
        jPesquisarClientePanel.setBounds(0, -1, 800, 600);

    }

      //Datas

      private void resetDatas(){
                                calendarEnd = null;
				calendarBegin = null;
				dateBegin.setText("00/00/00");
				dateEnd.setText("00/00/00");
       }


      /* Every time the user selects a new date, an event is generated */
		public void propertyChange(PropertyChangeEvent evt) {
			Object source = evt.getSource();
			Calendar cal;
			if (source == jCalendarEnd) {
				cal = jCalendarEnd.getCalendar();
				calendarEnd = new GregorianCalendar(cal.get(Calendar.YEAR),
						cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
				dateEnd.setText(calendarEnd.get(Calendar.DAY_OF_MONTH) + "/"
						+ calendarEnd.get(Calendar.MONTH) + "/"
						+ calendarEnd.get(Calendar.YEAR));

			} else {
				cal = jCalendarBegin.getCalendar();
				calendarBegin = new GregorianCalendar(cal.get(Calendar.YEAR),
						cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
				dateBegin.setText(calendarBegin.get(Calendar.DAY_OF_MONTH)
						+ "/" + calendarBegin.get(Calendar.MONTH) + "/"
						+ calendarBegin.get(Calendar.YEAR));
			}

		}


      //




    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLoginPanel = new javax.swing.JPanel();
        jLoginButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jUsernameField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jMenuAdministradorPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jATMManagerPanel = new javax.swing.JPanel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaMaquinas = new javax.swing.JList();
        jVenderATMButton = new javax.swing.JButton();
        jAdicionarATMButton = new javax.swing.JButton();
        javax.swing.JLabel jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        outMaquinas = new javax.swing.JTextArea();
        jSpinner6 = new javax.swing.JSpinner();
        jSpinner6.setModel(new SpinnerNumberModel(2000.00,0.00,10000.00,0.50));
        javax.swing.JLabel jLabel97 = new javax.swing.JLabel();
        actualizarListaMaquinas = new javax.swing.JButton();
        jEstatisticasPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        javax.swing.JLabel jLabel9 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        javax.swing.JLabel jLabel10 = new javax.swing.JLabel();
        dateBegin = new javax.swing.JTextField();
        javax.swing.JLabel jLabel11 = new javax.swing.JLabel();
        dateEnd = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        dataInit = new javax.swing.JButton();
        dataEnd = new javax.swing.JButton();
        jCheckBox5 = new javax.swing.JCheckBox();
        jButton6 = new javax.swing.JButton();
        jClientesManagerPanel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        pagamentosAtraso = new javax.swing.JList();
        jLabel23 = new javax.swing.JLabel();
        jPesquisarClientesButton = new javax.swing.JToggleButton();
        jAdicionarClientesButton = new javax.swing.JToggleButton();
        jEliminarClientesButton = new javax.swing.JButton();
        jNotificarClientesButton = new javax.swing.JButton();
        jVerificarPagamentosAtrasoButton = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        verificarRequesicoes = new javax.swing.JButton();
        jEmpregadosManagerPanel = new javax.swing.JPanel();
        javax.swing.JLabel jLabel12 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel13 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaEmpregados = new javax.swing.JList();
        jDespedirEmpregadoButton = new javax.swing.JToggleButton();
        javax.swing.JLabel jLabel14 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel15 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel16 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel17 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel18 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel19 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel20 = new javax.swing.JLabel();
        adminRadio = new javax.swing.JRadioButton();
        opRadio = new javax.swing.JRadioButton();
        javax.swing.JLabel jLabel21 = new javax.swing.JLabel();
        nomeEmpregados = new javax.swing.JTextField();
        passwordEmpregados = new javax.swing.JPasswordField();
        emailEmpregados = new javax.swing.JTextField();
        moradaEmpregados = new javax.swing.JTextField();
        javax.swing.JLabel jLabel22 = new javax.swing.JLabel();
        passwordEmpregados2 = new javax.swing.JPasswordField();
        jAdicionarEmpregadoButton = new javax.swing.JToggleButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        outEmpregados = new javax.swing.JTextArea();
        actualzarListaEmpregados = new javax.swing.JButton();
        telefoneEmpregados = new javax.swing.JFormattedTextField(NumberFormat.getNumberInstance());
        salarioEmpregados = new javax.swing.JFormattedTextField(NumberFormat.getNumberInstance());
        biEmpregados = new javax.swing.JFormattedTextField(NumberFormat.getNumberInstance());
        obterDadosEmpregadoActualizacao = new javax.swing.JButton();
        jFilmesManagerPanel = new javax.swing.JPanel();
        jAdicionarFilmesToggleButton = new javax.swing.JToggleButton();
        jActualizarStockButton = new javax.swing.JToggleButton();
        jEliminarFilmeButton = new javax.swing.JToggleButton();
        jPesquisarButton = new javax.swing.JToggleButton();
        jGeneroButton = new javax.swing.JToggleButton();
        jFormatosFrameButton = new javax.swing.JButton();
        jSairButton = new javax.swing.JButton();
        jMenuOperatorPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jClientesManagerPanel1 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jList6 = new javax.swing.JList();
        javax.swing.JLabel jLabel41 = new javax.swing.JLabel();
        pesquisarClientes = new javax.swing.JToggleButton();
        adicionarClientes = new javax.swing.JToggleButton();
        eliminarClientes = new javax.swing.JButton();
        notificarClientes = new javax.swing.JButton();
        jVerificarPagamentosAtrasoButton1 = new javax.swing.JButton();
        verificarRequesicoes1 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jFilmesManagerPanel1 = new javax.swing.JPanel();
        jToggleButton17 = new javax.swing.JToggleButton();
        jToggleButton18 = new javax.swing.JToggleButton();
        eliminaFilmes2 = new javax.swing.JToggleButton();
        pesquisarFilmes2 = new javax.swing.JToggleButton();
        adicionaGenero2 = new javax.swing.JToggleButton();
        jFormatosFrameButton1 = new javax.swing.JButton();
        jSairButton2 = new javax.swing.JButton();
        ficheirosFrame = new javax.swing.JFrame();
        jFileChooser1 = new javax.swing.JFileChooser();
        adicionarFilmeFrame = new javax.swing.JFrame();
        jAdicionarFilmePanel = new javax.swing.JPanel();
        javax.swing.JLabel jLabel53 = new javax.swing.JLabel();
        listaGenerosAdicionaFilmes = new javax.swing.JComboBox();
        jSpinner2 = new javax.swing.JSpinner();
        jSpinner2.setModel(new SpinnerNumberModel(5.0,1,10,0.1));
        textTituloAdicionaFilme = new javax.swing.JTextField();
        anoAdicionaFilmeSpinner = new javax.swing.JSpinner();
        anoAdicionaFilmeSpinner.setModel(new SpinnerNumberModel(2010,1917,2300,1));
        javax.swing.JLabel jLabel55 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel56 = new javax.swing.JLabel();
        textRealizadorAdicionaFilme = new javax.swing.JTextField();
        javax.swing.JLabel jLabel57 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel58 = new javax.swing.JLabel();
        textProdutorAdicionaFilme = new javax.swing.JTextField();
        javax.swing.JLabel jLabel60 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel61 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel54 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        textDescricaoAdicionaFilme = new javax.swing.JTextArea();
        javax.swing.JLabel jLabel59 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel62 = new javax.swing.JLabel();
        jEscolherFicheiroButton = new javax.swing.JToggleButton();
        adicionarFilme = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        javax.swing.JLabel jLabel63 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTextArea11 = new javax.swing.JTextArea();
        javax.swing.JLabel jLabel64 = new javax.swing.JLabel();
        jTextField32 = new javax.swing.JTextField();
        listaFormatosAdicionaFilme = new javax.swing.JComboBox();
        javax.swing.JLabel jLabel65 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel66 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel67 = new javax.swing.JLabel();
        jTextField33 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        adicionarStock = new javax.swing.JToggleButton();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTextArea12 = new javax.swing.JTextArea();
        voltarAdcionaFilmes = new javax.swing.JToggleButton();
        countriesList = new javax.swing.JComboBox();
        eliminarFilmesFrame = new javax.swing.JFrame();
        jEliminarFilmePanel = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        textEliminaFilmes = new javax.swing.JTextArea();
        eliminaFilmes = new javax.swing.JToggleButton();
        idEliminaFilmes = new javax.swing.JTextField();
        listaFormatos = new javax.swing.JComboBox();
        javax.swing.JLabel jLabel68 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel72 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel69 = new javax.swing.JLabel();
        eliminaSpinner = new javax.swing.JSpinner();
        eliminaSpinner.setModel(new SpinnerNumberModel(0,0,100,1));
        voltarEliminaFilmes = new javax.swing.JToggleButton();
        listarFormatoEliminar = new javax.swing.JButton();
        pesquisarFilmesFrame = new javax.swing.JFrame();
        jPesqisaFilmesPanel = new javax.swing.JPanel();
        javax.swing.JLabel jLabel85 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel86 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel87 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel88 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel89 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel90 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel91 = new javax.swing.JLabel();
        jSpinner4 = new javax.swing.JSpinner();
        jSpinner4.setModel(new SpinnerNumberModel(1.0,1,10,0.1));
        jSpinner5 = new javax.swing.JSpinner();
        jSpinner5.setModel(new SpinnerNumberModel(10.0,1,10,0.1));
        javax.swing.JLabel jLabel92 = new javax.swing.JLabel();
        textRealizadorPesquisaFilmes = new javax.swing.JTextField();
        textIdPesquisaFilmes = new javax.swing.JTextField();
        textTituloPesquisaFilmes = new javax.swing.JTextField();
        textProdutorPesquisaFilmes = new javax.swing.JTextField();
        pesquisarFilme = new javax.swing.JToggleButton();
        voltarPesquisarFilmes = new javax.swing.JToggleButton();
        countriesList1 = new javax.swing.JComboBox();
        jLabel94 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel95 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner1.setModel(new SpinnerNumberModel(2010,1917,2300,1));
        jSpinner3 = new javax.swing.JSpinner();
        jSpinner3.setModel(new SpinnerNumberModel(2010,1917,2300,1));
        generosFrame = new javax.swing.JFrame();
        jGenerosPanel = new javax.swing.JPanel();
        jScrollPane21 = new javax.swing.JScrollPane();
        listaGeneros = new javax.swing.JList();
        javax.swing.JLabel jLabel71 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel73 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel93 = new javax.swing.JLabel();
        textGenero = new javax.swing.JTextField();
        adicionaGenero = new javax.swing.JButton();
        voltarGeneros = new javax.swing.JButton();
        eliminaGenero = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        outGenero = new javax.swing.JTextArea();
        resultadosFrame = new javax.swing.JFrame();
        jResultadosFilmePanel = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        paisResultadosFilme = new javax.swing.JTextField();
        javax.swing.JLabel jLabel74 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        jTextArea14 = new javax.swing.JTextArea();
        javax.swing.JLabel jLabel75 = new javax.swing.JLabel();
        imdbResultadosFilme = new javax.swing.JTextField();
        anoResultadosFilme = new javax.swing.JTextField();
        javax.swing.JLabel jLabel77 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList();
        jButton15 = new javax.swing.JButton();
        jLabel78 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel79 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel80 = new javax.swing.JLabel();
        tituloResultadosFilme = new javax.swing.JTextField();
        javax.swing.JLabel jLabel81 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel82 = new javax.swing.JLabel();
        realizadorResultadosFilme = new javax.swing.JTextField();
        javax.swing.JLabel jLabel83 = new javax.swing.JLabel();
        produtorResultadosFilme = new javax.swing.JTextField();
        javax.swing.JLabel jLabel84 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        jList5 = new javax.swing.JList();
        jLabel76 = new javax.swing.JLabel();
        listaFormatosResultadosFilmes = new javax.swing.JComboBox();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jFormattedTextField4 = new javax.swing.JFormattedTextField(NumberFormat.getNumberInstance());
        alugar = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        adicionarClienteFrame = new javax.swing.JFrame();
        jAdicionarClientePanel = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        moradaAdicionaClientes = new javax.swing.JTextField();
        passwordAdicionaClientes2 = new javax.swing.JPasswordField();
        jLabel29 = new javax.swing.JLabel();
        nomeAdicionaClientes = new javax.swing.JTextField();
        passwordAdicionaClientes = new javax.swing.JPasswordField();
        emailAdicionaClientes = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        outputAdicionaClientes = new javax.swing.JTextArea();
        jVoltarACFButton = new javax.swing.JButton();
        biAdicionaClientes = new javax.swing.JFormattedTextField(NumberFormat.getNumberInstance());
        telefoneAdicionaClientes = new javax.swing.JFormattedTextField(NumberFormat.getNumberInstance());
        adicionarCliente = new javax.swing.JButton();
        obterDadosAdicionarClientes = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        eliminarClienteFrame = new javax.swing.JFrame();
        jEliminarClientePanel = new javax.swing.JPanel();
        javax.swing.JLabel jLabel50 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel51 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        outEliminaClientes = new javax.swing.JTextArea();
        jButton14 = new javax.swing.JButton();
        eliminarClienteBI = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        listaEliminarClientes = new javax.swing.JList();
        eliminarClientesLista = new javax.swing.JButton();
        biEliminaClientes = new javax.swing.JFormattedTextField(NumberFormat.getIntegerInstance());
        notificarClientesFrame = new javax.swing.JFrame();
        jNotificarClientePanel = new javax.swing.JPanel();
        javax.swing.JLabel jLabel35 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel42 = new javax.swing.JLabel();
        biNotificarClientes = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        mensagem = new javax.swing.JTextArea();
        javax.swing.JLabel jLabel52 = new javax.swing.JLabel();
        jToggleButton34 = new javax.swing.JToggleButton();
        enviarEmail = new javax.swing.JButton();
        pesquisarClienteFrame = new javax.swing.JFrame();
        jPesquisarClientePanel = new javax.swing.JPanel();
        javax.swing.JLabel jLabel43 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel44 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel45 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel46 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel47 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel48 = new javax.swing.JLabel();
        telefonePesquisarClientes = new javax.swing.JTextField();
        biPesquisarClientes = new javax.swing.JTextField();
        nomePesquisarClientes = new javax.swing.JTextField();
        emailPesquisarClientes = new javax.swing.JTextField();
        moradaPesquisarClientes = new javax.swing.JTextField();
        idPesquisarClientes = new javax.swing.JTextField();
        javax.swing.JLabel jLabel49 = new javax.swing.JLabel();
        pesquisarClientesButton = new javax.swing.JToggleButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        jList7 = new javax.swing.JList();
        jScrollPane22 = new javax.swing.JScrollPane();
        outPesquisarClientes = new javax.swing.JTextArea();
        voltarPesquisarCliente = new javax.swing.JToggleButton();
        javax.swing.JLabel jLabel96 = new javax.swing.JLabel();
        pesquisarPorBI = new javax.swing.JButton();
        pesquisarPorID = new javax.swing.JButton();
        formatosFrame = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane23 = new javax.swing.JScrollPane();
        listaFormato = new javax.swing.JList();
        jLabel34 = new javax.swing.JLabel();
        textFormato = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        adicionarFormato = new javax.swing.JButton();
        voltarFormatos = new javax.swing.JButton();
        eliminarFormato = new javax.swing.JButton();
        jScrollPane24 = new javax.swing.JScrollPane();
        outFormato = new javax.swing.JTextArea();
        mainPanel = new javax.swing.JPanel();

        jLoginButton.setText("Login");
        jLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLoginButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Username:");

        jLabel2.setText("Password:");

        jUsernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUsernameFieldActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 24));
        jLabel5.setText("[NOME DO VIDEOCLUBE]");

        javax.swing.GroupLayout jLoginPanelLayout = new javax.swing.GroupLayout(jLoginPanel);
        jLoginPanel.setLayout(jLoginPanelLayout);
        jLoginPanelLayout.setHorizontalGroup(
            jLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLoginPanelLayout.createSequentialGroup()
                .addGroup(jLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLoginPanelLayout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addGroup(jLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jUsernameField)
                            .addComponent(jPasswordField)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jLoginPanelLayout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(jLoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jLoginPanelLayout.setVerticalGroup(
            jLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLoginPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel5)
                .addGap(95, 95, 95)
                .addGroup(jLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 24));
        jLabel6.setText("Administrador");

        jLabel3.setText("Adicionar Máquina:");

        jLabel4.setText("Vender Máquina:");

        listaMaquinas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(listaMaquinas);

        jVenderATMButton.setText("Vender");
        jVenderATMButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVenderATMButtonActionPerformed(evt);
            }
        });

        jAdicionarATMButton.setText("Adicionar");
        jAdicionarATMButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAdicionarATMButtonActionPerformed(evt);
            }
        });

        jLabel8.setText("Custo:");

        outMaquinas.setColumns(20);
        outMaquinas.setEditable(false);
        outMaquinas.setRows(5);
        jScrollPane2.setViewportView(outMaquinas);

        jLabel97.setText("€");

        actualizarListaMaquinas.setText("Actualizar");
        actualizarListaMaquinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarListaMaquinasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jATMManagerPanelLayout = new javax.swing.GroupLayout(jATMManagerPanel);
        jATMManagerPanel.setLayout(jATMManagerPanelLayout);
        jATMManagerPanelLayout.setHorizontalGroup(
            jATMManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jATMManagerPanelLayout.createSequentialGroup()
                .addGroup(jATMManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jATMManagerPanelLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jATMManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jATMManagerPanelLayout.createSequentialGroup()
                                .addGroup(jATMManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addComponent(jSpinner6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel97))))
                    .addGroup(jATMManagerPanelLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jATMManagerPanelLayout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(actualizarListaMaquinas)
                        .addGap(18, 18, 18)
                        .addComponent(jVenderATMButton))
                    .addGroup(jATMManagerPanelLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jATMManagerPanelLayout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jAdicionarATMButton)))
                .addContainerGap(201, Short.MAX_VALUE))
        );
        jATMManagerPanelLayout.setVerticalGroup(
            jATMManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jATMManagerPanelLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jATMManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jATMManagerPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8))
                    .addGroup(jATMManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jSpinner6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel97)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jAdicionarATMButton)
                .addGap(34, 34, 34)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jATMManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jVenderATMButton)
                    .addComponent(actualizarListaMaquinas))
                .addContainerGap(206, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Gestão Máquinas", jATMManagerPanel);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        jLabel9.setText("Estatísticas:");

        jCheckBox1.setText("Empregados");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("Contabilidade");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setText("Filmes");

        jCheckBox4.setText("Máquinas");

        jLabel10.setText("Data Início:");

        dateBegin.setText("00/00/00");

        jLabel11.setText("Data Fim");

        dateEnd.setText("00/00/00");

        jButton5.setText("Reset");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        dataInit.setText("Escolher Data Início");
        dataInit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataInitActionPerformed(evt);
            }
        });

        dataEnd.setText("Escolher Data Fim");
        dataEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataEndActionPerformed(evt);
            }
        });

        jCheckBox5.setText("Clientes");

        jButton6.setText("Consultar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jEstatisticasPanelLayout = new javax.swing.GroupLayout(jEstatisticasPanel);
        jEstatisticasPanel.setLayout(jEstatisticasPanelLayout);
        jEstatisticasPanelLayout.setHorizontalGroup(
            jEstatisticasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jEstatisticasPanelLayout.createSequentialGroup()
                .addGroup(jEstatisticasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jEstatisticasPanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addGroup(jEstatisticasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox3)
                            .addComponent(jCheckBox4)
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox5)))
                    .addGroup(jEstatisticasPanelLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateBegin, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(dateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jEstatisticasPanelLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(dataInit)
                        .addGap(18, 18, 18)
                        .addComponent(dataEnd))
                    .addGroup(jEstatisticasPanelLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jEstatisticasPanelLayout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jButton5))
                    .addGroup(jEstatisticasPanelLayout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(jButton6)))
                .addContainerGap(217, Short.MAX_VALUE))
        );
        jEstatisticasPanelLayout.setVerticalGroup(
            jEstatisticasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jEstatisticasPanelLayout.createSequentialGroup()
                .addGroup(jEstatisticasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jEstatisticasPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox5)
                        .addGap(7, 7, 7)
                        .addComponent(jCheckBox3)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox4)
                        .addGap(18, 18, 18)
                        .addGroup(jEstatisticasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(dateBegin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(dateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jEstatisticasPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jEstatisticasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataInit)
                    .addComponent(dataEnd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        jTabbedPane2.addTab("Estatísticas", jEstatisticasPanel);

        jScrollPane6.setViewportView(pagamentosAtraso);

        jLabel23.setText("Clientes com pagamentos em atraso:");

        jPesquisarClientesButton.setText("Pesquisar Clientes");
        jPesquisarClientesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPesquisarClientesButtonActionPerformed(evt);
            }
        });

        jAdicionarClientesButton.setText("Adicionar Clientes");
        jAdicionarClientesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAdicionarClientesButtonActionPerformed(evt);
            }
        });

        jEliminarClientesButton.setText("Eliminar Clientes");
        jEliminarClientesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEliminarClientesButtonActionPerformed(evt);
            }
        });

        jNotificarClientesButton.setText("Notificar Clientes");
        jNotificarClientesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNotificarClientesButtonActionPerformed(evt);
            }
        });

        jVerificarPagamentosAtrasoButton.setText("Verificar");
        jVerificarPagamentosAtrasoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVerificarPagamentosAtrasoButtonActionPerformed(evt);
            }
        });

        jLabel31.setText("Clientes com requesições:");

        verificarRequesicoes.setText("Verificar");
        verificarRequesicoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificarRequesicoesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jClientesManagerPanelLayout = new javax.swing.GroupLayout(jClientesManagerPanel);
        jClientesManagerPanel.setLayout(jClientesManagerPanelLayout);
        jClientesManagerPanelLayout.setHorizontalGroup(
            jClientesManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jClientesManagerPanelLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jClientesManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jClientesManagerPanelLayout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addGroup(jClientesManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPesquisarClientesButton)
                            .addComponent(jAdicionarClientesButton)
                            .addComponent(jNotificarClientesButton)
                            .addComponent(jEliminarClientesButton)))
                    .addGroup(jClientesManagerPanelLayout.createSequentialGroup()
                        .addGroup(jClientesManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel31))
                        .addGap(38, 38, 38)
                        .addGroup(jClientesManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(verificarRequesicoes)
                            .addComponent(jVerificarPagamentosAtrasoButton))))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jClientesManagerPanelLayout.setVerticalGroup(
            jClientesManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jClientesManagerPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jClientesManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(verificarRequesicoes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jClientesManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jVerificarPagamentosAtrasoButton))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPesquisarClientesButton)
                .addGap(18, 18, 18)
                .addComponent(jAdicionarClientesButton)
                .addGap(9, 9, 9)
                .addComponent(jNotificarClientesButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jEliminarClientesButton)
                .addContainerGap(187, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Gestão Clientes", jClientesManagerPanel);

        jLabel12.setText("Adicionar Empregado:");

        jLabel13.setText("Eliminar Empregado:");

        listaEmpregados.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listaEmpregados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(listaEmpregados);

        jDespedirEmpregadoButton.setText("Eliminar");
        jDespedirEmpregadoButton.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jDespedirEmpregadoButtonComponentResized(evt);
            }
        });
        jDespedirEmpregadoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDespedirEmpregadoButtonActionPerformed(evt);
            }
        });

        jLabel14.setText("Nome:");

        jLabel15.setText("BI:");

        jLabel16.setText("Password:");

        jLabel17.setText("E-mail:");

        jLabel18.setText("Morada:");

        jLabel19.setText("Telefone:");

        jLabel20.setText("Privilégios:");

        adminRadio.setText("Administrador");

        opRadio.setText("Operador");

        jLabel21.setText("Salário:");

        jLabel22.setText("Confirm Password:");

        jAdicionarEmpregadoButton.setText("Adicionar/Actualizar");
        jAdicionarEmpregadoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAdicionarEmpregadoButtonActionPerformed(evt);
            }
        });

        outEmpregados.setColumns(20);
        outEmpregados.setRows(5);
        jScrollPane5.setViewportView(outEmpregados);

        actualzarListaEmpregados.setText("Actualizar Lista");
        actualzarListaEmpregados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualzarListaEmpregadosActionPerformed(evt);
            }
        });

        telefoneEmpregados.setText("239000000");

        salarioEmpregados.setText("2000");

        biEmpregados.setText("");

        obterDadosEmpregadoActualizacao.setText("Obter dados para actualzação");
        obterDadosEmpregadoActualizacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obterDadosEmpregadoActualizacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jEmpregadosManagerPanelLayout = new javax.swing.GroupLayout(jEmpregadosManagerPanel);
        jEmpregadosManagerPanel.setLayout(jEmpregadosManagerPanelLayout);
        jEmpregadosManagerPanelLayout.setHorizontalGroup(
            jEmpregadosManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jEmpregadosManagerPanelLayout.createSequentialGroup()
                .addGroup(jEmpregadosManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jEmpregadosManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jEmpregadosManagerPanelLayout.createSequentialGroup()
                            .addGroup(jEmpregadosManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jEmpregadosManagerPanelLayout.createSequentialGroup()
                                    .addGap(7, 7, 7)
                                    .addGroup(jEmpregadosManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel15)
                                        .addComponent(jLabel16)
                                        .addComponent(jLabel14))
                                    .addGap(53, 53, 53)
                                    .addGroup(jEmpregadosManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(nomeEmpregados, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jEmpregadosManagerPanelLayout.createSequentialGroup()
                                            .addGroup(jEmpregadosManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(biEmpregados, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(passwordEmpregados, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                            .addGap(27, 27, 27)
                                            .addGroup(jEmpregadosManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jEmpregadosManagerPanelLayout.createSequentialGroup()
                                                    .addComponent(jLabel22)
                                                    .addGap(15, 15, 15)
                                                    .addComponent(passwordEmpregados2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(obterDadosEmpregadoActualizacao)))
                                        .addComponent(telefoneEmpregados, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jEmpregadosManagerPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel18))
                                .addGroup(jEmpregadosManagerPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel17)))
                            .addGap(766, 766, 766))
                        .addGroup(jEmpregadosManagerPanelLayout.createSequentialGroup()
                            .addGap(158, 158, 158)
                            .addComponent(actualzarListaEmpregados)
                            .addGap(18, 18, 18)
                            .addComponent(jDespedirEmpregadoButton))
                        .addGroup(jEmpregadosManagerPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel19)
                            .addGap(8, 8, 8)
                            .addGroup(jEmpregadosManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                                .addGroup(jEmpregadosManagerPanelLayout.createSequentialGroup()
                                    .addGap(38, 38, 38)
                                    .addGroup(jEmpregadosManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(salarioEmpregados, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(moradaEmpregados, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(emailEmpregados, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE))
                                .addComponent(jLabel13)
                                .addComponent(jScrollPane4)))
                        .addGroup(jEmpregadosManagerPanelLayout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addComponent(jLabel12)))
                    .addGroup(jEmpregadosManagerPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel21))
                    .addGroup(jEmpregadosManagerPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adminRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(opRadio))
                    .addGroup(jEmpregadosManagerPanelLayout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jAdicionarEmpregadoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jEmpregadosManagerPanelLayout.setVerticalGroup(
            jEmpregadosManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jEmpregadosManagerPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addGroup(jEmpregadosManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeEmpregados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jEmpregadosManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(biEmpregados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(obterDadosEmpregadoActualizacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jEmpregadosManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordEmpregados2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jEmpregadosManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(passwordEmpregados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)
                        .addComponent(jLabel22)))
                .addGroup(jEmpregadosManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jEmpregadosManagerPanelLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel19))
                    .addGroup(jEmpregadosManagerPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(telefoneEmpregados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jEmpregadosManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(emailEmpregados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jEmpregadosManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(moradaEmpregados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jEmpregadosManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(salarioEmpregados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jEmpregadosManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(adminRadio)
                    .addComponent(opRadio))
                .addGap(18, 18, 18)
                .addComponent(jAdicionarEmpregadoButton)
                .addGap(11, 11, 11)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jEmpregadosManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actualzarListaEmpregados)
                    .addComponent(jDespedirEmpregadoButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Gestão Empregados", jEmpregadosManagerPanel);

        jAdicionarFilmesToggleButton.setText("Adicionar Filmes");
        jAdicionarFilmesToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAdicionarFilmesToggleButtonActionPerformed(evt);
            }
        });

        jActualizarStockButton.setText("Actualizar Stock");
        jActualizarStockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jActualizarStockButtonActionPerformed(evt);
            }
        });

        jEliminarFilmeButton.setText("Eliminar Filme");
        jEliminarFilmeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEliminarFilmeButtonActionPerformed(evt);
            }
        });

        jPesquisarButton.setText("Pesquisar Filme");
        jPesquisarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPesquisarButtonActionPerformed(evt);
            }
        });

        jGeneroButton.setText("Adicionar novo Género");
        jGeneroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGeneroButtonActionPerformed(evt);
            }
        });

        jFormatosFrameButton.setText("Adicionar novo Formato");
        jFormatosFrameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormatosFrameButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jFilmesManagerPanelLayout = new javax.swing.GroupLayout(jFilmesManagerPanel);
        jFilmesManagerPanel.setLayout(jFilmesManagerPanelLayout);
        jFilmesManagerPanelLayout.setHorizontalGroup(
            jFilmesManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFilmesManagerPanelLayout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addGroup(jFilmesManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jFormatosFrameButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jGeneroButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPesquisarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jActualizarStockButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addComponent(jAdicionarFilmesToggleButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jEliminarFilmeButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(220, Short.MAX_VALUE))
        );
        jFilmesManagerPanelLayout.setVerticalGroup(
            jFilmesManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFilmesManagerPanelLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jAdicionarFilmesToggleButton)
                .addGap(18, 18, 18)
                .addComponent(jActualizarStockButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jEliminarFilmeButton)
                .addGap(26, 26, 26)
                .addComponent(jGeneroButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormatosFrameButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPesquisarButton)
                .addContainerGap(277, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Gestão de Filmes", jFilmesManagerPanel);

        jSairButton.setText("Sair");
        jSairButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSairButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jMenuAdministradorPanelLayout = new javax.swing.GroupLayout(jMenuAdministradorPanel);
        jMenuAdministradorPanel.setLayout(jMenuAdministradorPanelLayout);
        jMenuAdministradorPanelLayout.setHorizontalGroup(
            jMenuAdministradorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jMenuAdministradorPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jMenuAdministradorPanelLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(jSairButton)
                .addGap(32, 32, 32))
        );
        jMenuAdministradorPanelLayout.setVerticalGroup(
            jMenuAdministradorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jMenuAdministradorPanelLayout.createSequentialGroup()
                .addGroup(jMenuAdministradorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jSairButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 24));
        jLabel7.setText("Operador");

        jScrollPane12.setViewportView(jList6);

        jLabel41.setText("Clientes com pagamentos em atraso:");

        pesquisarClientes.setText("Pesquisar Clientes");
        pesquisarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarClientesActionPerformed(evt);
            }
        });

        adicionarClientes.setText("Adicionar Clientes");
        adicionarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarClientesActionPerformed(evt);
            }
        });

        eliminarClientes.setText("Eliminar Clientes");
        eliminarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarClientesActionPerformed(evt);
            }
        });

        notificarClientes.setText("Notificar Clientes");
        notificarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notificarClientesActionPerformed(evt);
            }
        });

        jVerificarPagamentosAtrasoButton1.setText("Verificar");
        jVerificarPagamentosAtrasoButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVerificarPagamentosAtrasoButton1ActionPerformed(evt);
            }
        });

        verificarRequesicoes1.setText("Verificar");
        verificarRequesicoes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificarRequesicoes1ActionPerformed(evt);
            }
        });

        jLabel32.setText("Clientes com requesições:");

        javax.swing.GroupLayout jClientesManagerPanel1Layout = new javax.swing.GroupLayout(jClientesManagerPanel1);
        jClientesManagerPanel1.setLayout(jClientesManagerPanel1Layout);
        jClientesManagerPanel1Layout.setHorizontalGroup(
            jClientesManagerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jClientesManagerPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jClientesManagerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jClientesManagerPanel1Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addGroup(jClientesManagerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pesquisarClientes)
                            .addComponent(adicionarClientes)
                            .addComponent(eliminarClientes)
                            .addComponent(notificarClientes)))
                    .addGroup(jClientesManagerPanel1Layout.createSequentialGroup()
                        .addGroup(jClientesManagerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addComponent(jLabel32))
                        .addGap(45, 45, 45)
                        .addGroup(jClientesManagerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(verificarRequesicoes1)
                            .addComponent(jVerificarPagamentosAtrasoButton1))))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jClientesManagerPanel1Layout.setVerticalGroup(
            jClientesManagerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jClientesManagerPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jClientesManagerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(verificarRequesicoes1)
                    .addComponent(jLabel32))
                .addGap(5, 5, 5)
                .addGroup(jClientesManagerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jVerificarPagamentosAtrasoButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(pesquisarClientes)
                .addGap(18, 18, 18)
                .addComponent(adicionarClientes)
                .addGap(18, 18, 18)
                .addComponent(notificarClientes)
                .addGap(18, 18, 18)
                .addComponent(eliminarClientes)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Gestão Clientes", jClientesManagerPanel1);

        jToggleButton17.setText("Adicionar Filmes");
        jToggleButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton17ActionPerformed(evt);
            }
        });

        jToggleButton18.setText("Actualizar Stock");
        jToggleButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton18ActionPerformed(evt);
            }
        });

        eliminaFilmes2.setText("Eliminar Filme");
        eliminaFilmes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminaFilmes2ActionPerformed(evt);
            }
        });

        pesquisarFilmes2.setText("Pesquisar Filme");
        pesquisarFilmes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarFilmes2ActionPerformed(evt);
            }
        });

        adicionaGenero2.setText("Adicionar novo Género");
        adicionaGenero2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionaGenero2ActionPerformed(evt);
            }
        });

        jFormatosFrameButton1.setText("Adicionar novo Formato");
        jFormatosFrameButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormatosFrameButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jFilmesManagerPanel1Layout = new javax.swing.GroupLayout(jFilmesManagerPanel1);
        jFilmesManagerPanel1.setLayout(jFilmesManagerPanel1Layout);
        jFilmesManagerPanel1Layout.setHorizontalGroup(
            jFilmesManagerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFilmesManagerPanel1Layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addGroup(jFilmesManagerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jFormatosFrameButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addComponent(adicionaGenero2, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addComponent(eliminaFilmes2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jFilmesManagerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pesquisarFilmes2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToggleButton18, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                        .addComponent(jToggleButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(220, 220, 220))
        );
        jFilmesManagerPanel1Layout.setVerticalGroup(
            jFilmesManagerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFilmesManagerPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jToggleButton17)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton18)
                .addGap(18, 18, 18)
                .addComponent(eliminaFilmes2)
                .addGap(29, 29, 29)
                .addComponent(adicionaGenero2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormatosFrameButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pesquisarFilmes2)
                .addContainerGap(250, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Gestão de Filmes", jFilmesManagerPanel1);

        jSairButton2.setText("Sair");
        jSairButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSairButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jMenuOperatorPanelLayout = new javax.swing.GroupLayout(jMenuOperatorPanel);
        jMenuOperatorPanel.setLayout(jMenuOperatorPanelLayout);
        jMenuOperatorPanelLayout.setHorizontalGroup(
            jMenuOperatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jMenuOperatorPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jMenuOperatorPanelLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(jSairButton2)
                .addGap(32, 32, 32))
        );
        jMenuOperatorPanelLayout.setVerticalGroup(
            jMenuOperatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jMenuOperatorPanelLayout.createSequentialGroup()
                .addGroup(jMenuOperatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jSairButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ficheirosFrameLayout = new javax.swing.GroupLayout(ficheirosFrame.getContentPane());
        ficheirosFrame.getContentPane().setLayout(ficheirosFrameLayout);
        ficheirosFrameLayout.setHorizontalGroup(
            ficheirosFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFileChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
        );
        ficheirosFrameLayout.setVerticalGroup(
            ficheirosFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFileChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
        );

        adicionarFilmeFrame.setAlwaysOnTop(true);
        adicionarFilmeFrame.setMinimumSize(new java.awt.Dimension(800, 600));

        jLabel53.setText("Género:");

        listaGenerosAdicionaFilmes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel55.setText("Ano:");

        jLabel56.setText("Realizador:");

        jLabel57.setText("Produtor:");

        jLabel58.setText("Título:");

        jLabel60.setText("IMDB RATING: ");

        jLabel61.setText("Adicionar Filme:");

        jLabel54.setText("País:");

        textDescricaoAdicionaFilme.setColumns(20);
        textDescricaoAdicionaFilme.setRows(5);
        jScrollPane14.setViewportView(textDescricaoAdicionaFilme);

        jLabel59.setText("Descrição:");

        jLabel62.setText("Capa:");

        jEscolherFicheiroButton.setText("Escolher Ficheiro");
        jEscolherFicheiroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEscolherFicheiroButtonActionPerformed(evt);
            }
        });

        adicionarFilme.setText("Adicionar Filme");
        adicionarFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarFilmeActionPerformed(evt);
            }
        });

        jLabel63.setText("Adicionar Stock");

        jTextArea11.setColumns(20);
        jTextArea11.setRows(5);
        jScrollPane15.setViewportView(jTextArea11);

        jLabel64.setText("ID:");

        listaFormatosAdicionaFilme.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Blu-Ray", "DVD", "UMD"}));

        jLabel65.setText("Formato:");

        jLabel66.setText("Custo:");

        jLabel67.setText("Custo Aluguer:");

        adicionarStock.setText("Adicionar Stock");
        adicionarStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarStockActionPerformed(evt);
            }
        });

        jTextArea12.setColumns(20);
        jTextArea12.setRows(5);
        jScrollPane16.setViewportView(jTextArea12);

        voltarAdcionaFilmes.setText("Voltar");
        voltarAdcionaFilmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarAdcionaFilmesActionPerformed(evt);
            }
        });

        countriesList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Afghanistan",
            "Albania",
            "Algeria",
            "Andorra",
            "Angola",
            "Antigua",
            "Argentina",
            "Armenia",
            "Australia",
            "Austria",
            "Azerbaijan",
            "Bahamas",
            "Bahrain",
            "Bangladesh",
            "Barbados",
            "Belarus",
            "Belgium",
            "Belize",
            "Benin",
            "Bhutan",
            "Bolivia",
            "Bosnia Herzegovina",
            "Botswana",
            "Brazil",
            "Brunei",
            "Bulgaria",
            "Burkina",
            "Burundi",
            "Cambodia",
            "Cameroon",
            "Canada",
            "Cape Verde",
            "Central African Rep",
            "Chad",
            "Chile",
            "China",
            "Colombia",
            "Comoros",
            "Congo",
            "Costa Rica",
            "Croatia",
            "Cuba",
            "Cyprus",
            "Czech Republic",
            "Denmark",
            "Djibouti",
            "Dominica",
            "Dominican Republic",
            "East Timor",
            "Ecuador",
            "Egypt",
            "El Salvador",
            "Equatorial Guinea",
            "Eritrea",
            "Estonia",
            "Ethiopia",
            "Fiji",
            "Finland",
            "France",
            "Gabon",
            "Gambia",
            "Georgia",
            "Germany",
            "Ghana",
            "Greece",
            "Grenada",
            "Guatemala",
            "Guinea",
            "Guinea-Bissau",
            "Guyana",
            "Haiti",
            "Honduras",
            "Hungary",
            "Iceland",
            "India",
            "Indonesia",
            "Iran",
            "Iraq",
            "Ireland",
            "Israel",
            "Italy",
            "Ivory Coast",
            "Jamaica",
            "Japan",
            "Jordan",
            "Kazakhstan",
            "Kenya",
            "Kiribati",
            "Korea North",
            "Korea South",
            "Kosovo",
            "Kuwait",
            "Kyrgyzstan",
            "Laos",
            "Latvia",
            "Lebanon",
            "Lesotho",
            "Liberia",
            "Libya",
            "Liechtenstein",
            "Lithuania",
            "Luxembourg",
            "Macedonia",
            "Madagascar",
            "Malawi",
            "Malaysia",
            "Maldives",
            "Mali",
            "Malta",
            "Marshall Islands",
            "Mauritania",
            "Mauritius",
            "Mexico",
            "Micronesia",
            "Moldova",
            "Monaco",
            "Mongolia",
            "Montenegro",
            "Morocco",
            "Mozambique",
            "Myanmar",
            "Namibia",
            "Nauru",
            "Nepal",
            "Netherlands",
            "New Zealand",
            "Nicaragua",
            "Niger",
            "Nigeria",
            "Norway",
            "Oman",
            "Pakistan",
            "Palau",
            "Panama",
            "Papua New Guinea",
            "Paraguay",
            "Peru",
            "Philippines",
            "Poland",
            "Portugal",
            "Qatar",
            "Romania",
            "Russian Federation",
            "Rwanda",
            "St Kitts & Nevis",
            "St Lucia",
            "Saint Vincent & the Grenadines",
            "Samoa",
            "San Marino",
            "Sao Tome & Principe",
            "Saudi Arabia",
            "Senegal",
            "Serbia",
            "Seychelles",
            "Sierra Leone",
            "Singapore",
            "Slovakia",
            "Slovenia",
            "Solomon Islands",
            "Somalia",
            "South Africa",
            "Spain",
            "Sri Lanka",
            "Sudan",
            "Suriname",
            "Swaziland",
            "Sweden",
            "Switzerland",
            "Syria",
            "Taiwan",
            "Tajikistan",
            "Tanzania",
            "Thailand",
            "Togo",
            "Tonga",
            "Trinidad & Tobago",
            "Tunisia",
            "Turkey",
            "Turkmenistan",
            "Tuvalu",
            "Uganda",
            "Ukraine",
            "United Arab Emirates",
            "United Kingdom",
            "United States",
            "Uruguay",
            "Uzbekistan",
            "Vanuatu",
            "Vatican City",
            "Venezuela",
            "Vietnam",
            "Yemen",
            "Zambia",
            "Zimbabwe" }));

javax.swing.GroupLayout jAdicionarFilmePanelLayout = new javax.swing.GroupLayout(jAdicionarFilmePanel);
jAdicionarFilmePanel.setLayout(jAdicionarFilmePanelLayout);
jAdicionarFilmePanelLayout.setHorizontalGroup(
    jAdicionarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(jAdicionarFilmePanelLayout.createSequentialGroup()
        .addGap(43, 43, 43)
        .addGroup(jAdicionarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jAdicionarFilmePanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel61))
            .addComponent(jLabel63)
            .addGroup(jAdicionarFilmePanelLayout.createSequentialGroup()
                .addGroup(jAdicionarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jAdicionarFilmePanelLayout.createSequentialGroup()
                        .addGroup(jAdicionarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel64)
                            .addComponent(jLabel65))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jAdicionarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(listaFormatosAdicionaFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jAdicionarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(adicionarStock)
                    .addGroup(jAdicionarFilmePanelLayout.createSequentialGroup()
                        .addGroup(jAdicionarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jAdicionarFilmePanelLayout.createSequentialGroup()
                                .addComponent(jLabel67)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jAdicionarFilmePanelLayout.createSequentialGroup()
                                .addComponent(jLabel66)
                                .addGap(50, 50, 50)))
                        .addGroup(jAdicionarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField33)
                            .addComponent(jTextField34, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)))))
            .addGroup(jAdicionarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jAdicionarFilmePanelLayout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addGroup(jAdicionarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jAdicionarFilmePanelLayout.createSequentialGroup()
                            .addGroup(jAdicionarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel56)
                                .addComponent(jLabel53)
                                .addComponent(jLabel58)
                                .addComponent(jLabel54))
                            .addGap(18, 18, 18)
                            .addGroup(jAdicionarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(listaGenerosAdicionaFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textTituloAdicionaFilme, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                .addComponent(textRealizadorAdicionaFilme)
                                .addComponent(countriesList, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel59))
                    .addGap(127, 127, 127)
                    .addGroup(jAdicionarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jAdicionarFilmePanelLayout.createSequentialGroup()
                            .addComponent(jLabel60)
                            .addGap(18, 18, 18)
                            .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel62)
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jAdicionarFilmePanelLayout.createSequentialGroup()
                            .addGroup(jAdicionarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel57)
                                .addComponent(jLabel55))
                            .addGap(18, 18, 18)
                            .addGroup(jAdicionarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textProdutorAdicionaFilme, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                .addComponent(anoAdicionaFilmeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jAdicionarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jEscolherFicheiroButton)
                            .addComponent(adicionarFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(213, Short.MAX_VALUE))
    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jAdicionarFilmePanelLayout.createSequentialGroup()
        .addContainerGap(478, Short.MAX_VALUE)
        .addComponent(voltarAdcionaFilmes)
        .addGap(214, 214, 214))
    );
    jAdicionarFilmePanelLayout.setVerticalGroup(
        jAdicionarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jAdicionarFilmePanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel61)
            .addGap(18, 18, 18)
            .addGroup(jAdicionarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(textTituloAdicionaFilme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel55)
                .addComponent(anoAdicionaFilmeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel58))
            .addGap(18, 18, 18)
            .addGroup(jAdicionarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel53)
                .addComponent(listaGenerosAdicionaFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel57)
                .addComponent(textProdutorAdicionaFilme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jAdicionarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel56)
                .addComponent(textRealizadorAdicionaFilme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel60)
                .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jAdicionarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel54)
                .addComponent(jLabel62)
                .addComponent(jEscolherFicheiroButton)
                .addComponent(countriesList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jAdicionarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(adicionarFilme)
                .addComponent(jLabel59))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jAdicionarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jScrollPane15, 0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jAdicionarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jAdicionarFilmePanelLayout.createSequentialGroup()
                    .addComponent(jLabel63)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jAdicionarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel64)
                        .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel66)
                        .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jAdicionarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(listaFormatosAdicionaFilme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel65)
                        .addComponent(jLabel67)
                        .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jAdicionarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(adicionarStock))
                    .addGap(37, 37, 37))
                .addGroup(jAdicionarFilmePanelLayout.createSequentialGroup()
                    .addComponent(voltarAdcionaFilmes)
                    .addContainerGap())))
    );

    javax.swing.GroupLayout adicionarFilmeFrameLayout = new javax.swing.GroupLayout(adicionarFilmeFrame.getContentPane());
    adicionarFilmeFrame.getContentPane().setLayout(adicionarFilmeFrameLayout);
    adicionarFilmeFrameLayout.setHorizontalGroup(
        adicionarFilmeFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 753, Short.MAX_VALUE)
        .addGroup(adicionarFilmeFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adicionarFilmeFrameLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jAdicionarFilmePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)))
    );
    adicionarFilmeFrameLayout.setVerticalGroup(
        adicionarFilmeFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 540, Short.MAX_VALUE)
        .addGroup(adicionarFilmeFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adicionarFilmeFrameLayout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jAdicionarFilmePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE)))
    );

    eliminarFilmesFrame.setAlwaysOnTop(true);
    eliminarFilmesFrame.setMinimumSize(new java.awt.Dimension(800, 600));

    textEliminaFilmes.setColumns(20);
    textEliminaFilmes.setRows(5);
    jScrollPane17.setViewportView(textEliminaFilmes);

    eliminaFilmes.setText("Eliminar Stock");
    eliminaFilmes.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            eliminaFilmesActionPerformed(evt);
        }
    });

    listaFormatos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Blu-Ray", "DVD", "UMD"}));

    jLabel68.setText("ID:");

    jLabel70.setText("Formato:");

    jLabel72.setText("Eliminar Stock");

    jLabel69.setText("Qtd.:");

    voltarEliminaFilmes.setText("Voltar");
    voltarEliminaFilmes.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            voltarEliminaFilmesActionPerformed(evt);
        }
    });

    listarFormatoEliminar.setText("Listar");
    listarFormatoEliminar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            listarFormatoEliminarActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jEliminarFilmePanelLayout = new javax.swing.GroupLayout(jEliminarFilmePanel);
    jEliminarFilmePanel.setLayout(jEliminarFilmePanelLayout);
    jEliminarFilmePanelLayout.setHorizontalGroup(
        jEliminarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jEliminarFilmePanelLayout.createSequentialGroup()
            .addGap(51, 51, 51)
            .addGroup(jEliminarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel72, javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jEliminarFilmePanelLayout.createSequentialGroup()
                    .addGroup(jEliminarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jEliminarFilmePanelLayout.createSequentialGroup()
                            .addGroup(jEliminarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel68)
                                .addComponent(jLabel70))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jEliminarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jEliminarFilmePanelLayout.createSequentialGroup()
                                    .addComponent(listaFormatos, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(33, 33, 33)
                                    .addComponent(listarFormatoEliminar))
                                .addComponent(idEliminaFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(15, 15, 15))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jEliminarFilmePanelLayout.createSequentialGroup()
                            .addComponent(jLabel69)
                            .addGap(18, 18, 18)
                            .addComponent(eliminaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)))
                    .addGroup(jEliminarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(voltarEliminaFilmes)
                        .addComponent(eliminaFilmes))))
            .addContainerGap(208, Short.MAX_VALUE))
    );
    jEliminarFilmePanelLayout.setVerticalGroup(
        jEliminarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jEliminarFilmePanelLayout.createSequentialGroup()
            .addGap(59, 59, 59)
            .addComponent(jLabel72)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jEliminarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel68)
                .addComponent(idEliminaFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jEliminarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(listaFormatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel70)
                .addComponent(listarFormatoEliminar))
            .addGap(18, 18, 18)
            .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(25, 25, 25)
            .addGroup(jEliminarFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(eliminaFilmes)
                .addComponent(eliminaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel69))
            .addGap(28, 28, 28)
            .addComponent(voltarEliminaFilmes)
            .addContainerGap(210, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout eliminarFilmesFrameLayout = new javax.swing.GroupLayout(eliminarFilmesFrame.getContentPane());
    eliminarFilmesFrame.getContentPane().setLayout(eliminarFilmesFrameLayout);
    eliminarFilmesFrameLayout.setHorizontalGroup(
        eliminarFilmesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 620, Short.MAX_VALUE)
        .addGroup(eliminarFilmesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eliminarFilmesFrameLayout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addComponent(jEliminarFilmePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE)))
    );
    eliminarFilmesFrameLayout.setVerticalGroup(
        eliminarFilmesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 530, Short.MAX_VALUE)
        .addGroup(eliminarFilmesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eliminarFilmesFrameLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jEliminarFilmePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)))
    );

    pesquisarFilmesFrame.setAlwaysOnTop(true);
    pesquisarFilmesFrame.setMinimumSize(new java.awt.Dimension(800, 600));
    pesquisarFilmesFrame.addWindowListener(new java.awt.event.WindowAdapter() {
        public void windowClosing(java.awt.event.WindowEvent evt) {
            pesquisarFilmesFrameWindowClosing(evt);
        }
    });

    jLabel85.setText("Pesquisar:");

    jLabel86.setText("Título:");

    jLabel87.setText("Produtora:");

    jLabel88.setText("País:");

    jLabel89.setText("ID:");

    jLabel90.setText("IMBD RATING: Between");

    jLabel91.setText("And");

    jLabel92.setText("Realizador:");

    pesquisarFilme.setText("Procurar");
    pesquisarFilme.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            pesquisarFilmeActionPerformed(evt);
        }
    });

    voltarPesquisarFilmes.setText("Voltar");
    voltarPesquisarFilmes.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            voltarPesquisarFilmesActionPerformed(evt);
        }
    });

    countriesList1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Afghanistan",
        "Albania",
        "Algeria",
        "Andorra",
        "Angola",
        "Antigua",
        "Argentina",
        "Armenia",
        "Australia",
        "Austria",
        "Azerbaijan",
        "Bahamas",
        "Bahrain",
        "Bangladesh",
        "Barbados",
        "Belarus",
        "Belgium",
        "Belize",
        "Benin",
        "Bhutan",
        "Bolivia",
        "Bosnia Herzegovina",
        "Botswana",
        "Brazil",
        "Brunei",
        "Bulgaria",
        "Burkina",
        "Burundi",
        "Cambodia",
        "Cameroon",
        "Canada",
        "Cape Verde",
        "Central African Rep",
        "Chad",
        "Chile",
        "China",
        "Colombia",
        "Comoros",
        "Congo",
        "Costa Rica",
        "Croatia",
        "Cuba",
        "Cyprus",
        "Czech Republic",
        "Denmark",
        "Djibouti",
        "Dominica",
        "Dominican Republic",
        "East Timor",
        "Ecuador",
        "Egypt",
        "El Salvador",
        "Equatorial Guinea",
        "Eritrea",
        "Estonia",
        "Ethiopia",
        "Fiji",
        "Finland",
        "France",
        "Gabon",
        "Gambia",
        "Georgia",
        "Germany",
        "Ghana",
        "Greece",
        "Grenada",
        "Guatemala",
        "Guinea",
        "Guinea-Bissau",
        "Guyana",
        "Haiti",
        "Honduras",
        "Hungary",
        "Iceland",
        "India",
        "Indonesia",
        "Iran",
        "Iraq",
        "Ireland",
        "Israel",
        "Italy",
        "Ivory Coast",
        "Jamaica",
        "Japan",
        "Jordan",
        "Kazakhstan",
        "Kenya",
        "Kiribati",
        "Korea North",
        "Korea South",
        "Kosovo",
        "Kuwait",
        "Kyrgyzstan",
        "Laos",
        "Latvia",
        "Lebanon",
        "Lesotho",
        "Liberia",
        "Libya",
        "Liechtenstein",
        "Lithuania",
        "Luxembourg",
        "Macedonia",
        "Madagascar",
        "Malawi",
        "Malaysia",
        "Maldives",
        "Mali",
        "Malta",
        "Marshall Islands",
        "Mauritania",
        "Mauritius",
        "Mexico",
        "Micronesia",
        "Moldova",
        "Monaco",
        "Mongolia",
        "Montenegro",
        "Morocco",
        "Mozambique",
        "Myanmar",
        "Namibia",
        "Nauru",
        "Nepal",
        "Netherlands",
        "New Zealand",
        "Nicaragua",
        "Niger",
        "Nigeria",
        "Norway",
        "Oman",
        "Pakistan",
        "Palau",
        "Panama",
        "Papua New Guinea",
        "Paraguay",
        "Peru",
        "Philippines",
        "Poland",
        "Portugal",
        "Qatar",
        "Romania",
        "Russian Federation",
        "Rwanda",
        "St Kitts & Nevis",
        "St Lucia",
        "Saint Vincent & the Grenadines",
        "Samoa",
        "San Marino",
        "Sao Tome & Principe",
        "Saudi Arabia",
        "Senegal",
        "Serbia",
        "Seychelles",
        "Sierra Leone",
        "Singapore",
        "Slovakia",
        "Slovenia",
        "Solomon Islands",
        "Somalia",
        "South Africa",
        "Spain",
        "Sri Lanka",
        "Sudan",
        "Suriname",
        "Swaziland",
        "Sweden",
        "Switzerland",
        "Syria",
        "Taiwan",
        "Tajikistan",
        "Tanzania",
        "Thailand",
        "Togo",
        "Tonga",
        "Trinidad & Tobago",
        "Tunisia",
        "Turkey",
        "Turkmenistan",
        "Tuvalu",
        "Uganda",
        "Ukraine",
        "United Arab Emirates",
        "United Kingdom",
        "United States",
        "Uruguay",
        "Uzbekistan",
        "Vanuatu",
        "Vatican City",
        "Venezuela",
        "Vietnam",
        "Yemen",
        "Zambia",
        "Zimbabwe" }));

jLabel94.setText("Ano: Between");

jLabel95.setText("And");

javax.swing.GroupLayout jPesqisaFilmesPanelLayout = new javax.swing.GroupLayout(jPesqisaFilmesPanel);
jPesqisaFilmesPanel.setLayout(jPesqisaFilmesPanelLayout);
jPesqisaFilmesPanelLayout.setHorizontalGroup(
jPesqisaFilmesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(jPesqisaFilmesPanelLayout.createSequentialGroup()
    .addGap(58, 58, 58)
    .addGroup(jPesqisaFilmesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabel85)
        .addGroup(jPesqisaFilmesPanelLayout.createSequentialGroup()
            .addGroup(jPesqisaFilmesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPesqisaFilmesPanelLayout.createSequentialGroup()
                    .addGroup(jPesqisaFilmesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel87)
                        .addComponent(jLabel88))
                    .addGap(18, 18, 18)
                    .addGroup(jPesqisaFilmesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(countriesList1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textProdutorPesquisaFilmes, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)))
                .addGroup(jPesqisaFilmesPanelLayout.createSequentialGroup()
                    .addGroup(jPesqisaFilmesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel86)
                        .addComponent(jLabel89))
                    .addGap(40, 40, 40)
                    .addGroup(jPesqisaFilmesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(textIdPesquisaFilmes, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                        .addComponent(textTituloPesquisaFilmes, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))))
            .addGap(77, 77, 77)
            .addGroup(jPesqisaFilmesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(jPesqisaFilmesPanelLayout.createSequentialGroup()
                    .addComponent(jLabel92)
                    .addGap(18, 18, 18)
                    .addComponent(textRealizadorPesquisaFilmes))
                .addGroup(jPesqisaFilmesPanelLayout.createSequentialGroup()
                    .addGroup(jPesqisaFilmesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPesqisaFilmesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(voltarPesquisarFilmes)
                            .addComponent(pesquisarFilme))
                        .addGroup(jPesqisaFilmesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPesqisaFilmesPanelLayout.createSequentialGroup()
                                .addComponent(jLabel94)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel90)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPesqisaFilmesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel95)
                        .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPesqisaFilmesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPesqisaFilmesPanelLayout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(jLabel91)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jSpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPesqisaFilmesPanelLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
    .addGap(132, 132, 132))
    );
    jPesqisaFilmesPanelLayout.setVerticalGroup(
        jPesqisaFilmesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPesqisaFilmesPanelLayout.createSequentialGroup()
            .addGap(30, 30, 30)
            .addComponent(jLabel85)
            .addGap(16, 16, 16)
            .addGroup(jPesqisaFilmesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel89)
                .addComponent(jLabel92)
                .addComponent(textRealizadorPesquisaFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(textIdPesquisaFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPesqisaFilmesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel86)
                .addComponent(jLabel90)
                .addComponent(jLabel91)
                .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jSpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(textTituloPesquisaFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPesqisaFilmesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPesqisaFilmesPanelLayout.createSequentialGroup()
                    .addGroup(jPesqisaFilmesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel87)
                        .addComponent(textProdutorPesquisaFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPesqisaFilmesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel88)
                        .addComponent(pesquisarFilme)
                        .addComponent(countriesList1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(26, 26, 26)
                    .addComponent(voltarPesquisarFilmes))
                .addGroup(jPesqisaFilmesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel94)
                    .addComponent(jLabel95)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(220, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout pesquisarFilmesFrameLayout = new javax.swing.GroupLayout(pesquisarFilmesFrame.getContentPane());
    pesquisarFilmesFrame.getContentPane().setLayout(pesquisarFilmesFrameLayout);
    pesquisarFilmesFrameLayout.setHorizontalGroup(
        pesquisarFilmesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pesquisarFilmesFrameLayout.createSequentialGroup()
            .addGap(0, 29, Short.MAX_VALUE)
            .addComponent(jPesqisaFilmesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 30, Short.MAX_VALUE))
    );
    pesquisarFilmesFrameLayout.setVerticalGroup(
        pesquisarFilmesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pesquisarFilmesFrameLayout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jPesqisaFilmesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );

    generosFrame.setAlwaysOnTop(true);
    generosFrame.setMinimumSize(new java.awt.Dimension(800, 600));
    generosFrame.addWindowListener(new java.awt.event.WindowAdapter() {
        public void windowClosing(java.awt.event.WindowEvent evt) {
            generosFrameWindowClosing(evt);
        }
    });

    listaGeneros.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    jScrollPane21.setViewportView(listaGeneros);

    jLabel71.setText("Géneros Existentes:");

    jLabel73.setText("Adicionar Género:");

    jLabel93.setText("Nome:");

    adicionaGenero.setText("Adicionar");
    adicionaGenero.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            adicionaGeneroActionPerformed(evt);
        }
    });

    voltarGeneros.setText("Voltar");
    voltarGeneros.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            voltarGenerosActionPerformed(evt);
        }
    });

    eliminaGenero.setText("Eliminar");
    eliminaGenero.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            eliminaGeneroActionPerformed(evt);
        }
    });

    outGenero.setColumns(20);
    outGenero.setEditable(false);
    outGenero.setRows(5);
    jScrollPane13.setViewportView(outGenero);

    javax.swing.GroupLayout jGenerosPanelLayout = new javax.swing.GroupLayout(jGenerosPanel);
    jGenerosPanel.setLayout(jGenerosPanelLayout);
    jGenerosPanelLayout.setHorizontalGroup(
        jGenerosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jGenerosPanelLayout.createSequentialGroup()
            .addGroup(jGenerosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jGenerosPanelLayout.createSequentialGroup()
                    .addGap(48, 48, 48)
                    .addGroup(jGenerosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel73)
                        .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel71)))
                .addGroup(jGenerosPanelLayout.createSequentialGroup()
                    .addGroup(jGenerosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jGenerosPanelLayout.createSequentialGroup()
                            .addGap(75, 75, 75)
                            .addComponent(jLabel93)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(textGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jGenerosPanelLayout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addGroup(jGenerosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(voltarGeneros)
                        .addComponent(adicionaGenero)))
                .addGroup(jGenerosPanelLayout.createSequentialGroup()
                    .addGap(152, 152, 152)
                    .addComponent(eliminaGenero)))
            .addContainerGap(193, Short.MAX_VALUE))
    );
    jGenerosPanelLayout.setVerticalGroup(
        jGenerosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jGenerosPanelLayout.createSequentialGroup()
            .addGap(34, 34, 34)
            .addComponent(jLabel71)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(eliminaGenero)
            .addGap(9, 9, 9)
            .addComponent(jLabel73)
            .addGap(18, 18, 18)
            .addGroup(jGenerosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel93)
                .addComponent(textGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(adicionaGenero))
            .addGroup(jGenerosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jGenerosPanelLayout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(voltarGeneros))
                .addGroup(jGenerosPanelLayout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(63, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout generosFrameLayout = new javax.swing.GroupLayout(generosFrame.getContentPane());
    generosFrame.getContentPane().setLayout(generosFrameLayout);
    generosFrameLayout.setHorizontalGroup(
        generosFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 542, Short.MAX_VALUE)
        .addGroup(generosFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generosFrameLayout.createSequentialGroup()
                .addGap(0, 29, Short.MAX_VALUE)
                .addComponent(jGenerosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE)))
    );
    generosFrameLayout.setVerticalGroup(
        generosFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 414, Short.MAX_VALUE)
        .addGroup(generosFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generosFrameLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jGenerosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)))
    );

    resultadosFrame.setAlwaysOnTop(true);
    resultadosFrame.setMinimumSize(new java.awt.Dimension(800, 600));

    paisResultadosFilme.setEditable(false);

    jLabel74.setText("País:");

    jTextArea14.setColumns(20);
    jTextArea14.setRows(5);
    jScrollPane18.setViewportView(jTextArea14);

    jLabel75.setText("Descrição:");

    imdbResultadosFilme.setEditable(false);

    anoResultadosFilme.setEditable(false);

    jLabel77.setText("Resultados:");

    jScrollPane19.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

    jList4.setModel(new javax.swing.AbstractListModel() {
        String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
        public int getSize() { return strings.length; }
        public Object getElementAt(int i) { return strings[i]; }
    });
    jList4.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    jList4.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jList4MouseClicked(evt);
        }
    });
    jScrollPane19.setViewportView(jList4);

    jButton15.setText("Voltar");

    jLabel78.setFont(new java.awt.Font("Tahoma", 0, 24));
    jLabel78.setText("Resultados Filme");

    jLabel79.setText("Título:");

    jLabel80.setText("Género:");

    tituloResultadosFilme.setEditable(false);

    jLabel81.setText("Ano:");

    jLabel82.setText("Realizador:");

    realizadorResultadosFilme.setEditable(false);

    jLabel83.setText("Produtor:");

    produtorResultadosFilme.setEditable(false);

    jLabel84.setText("IMDB RATING: ");

    jList5.setModel(new javax.swing.AbstractListModel() {
        String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
        public int getSize() { return strings.length; }
        public Object getElementAt(int i) { return strings[i]; }
    });
    jScrollPane20.setViewportView(jList5);

    listaFormatosResultadosFilmes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Blu-Ray", "DVD", "UMD"}));

    jLabel98.setText("Formato:");

    jLabel99.setText("ID do Cliente:");

    jFormattedTextField4.setText("");

    alugar.setText("Alugar");
    alugar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            alugarActionPerformed(evt);
        }
    });

    jTextField1.setEditable(false);

    javax.swing.GroupLayout jResultadosFilmePanelLayout = new javax.swing.GroupLayout(jResultadosFilmePanel);
    jResultadosFilmePanel.setLayout(jResultadosFilmePanelLayout);
    jResultadosFilmePanelLayout.setHorizontalGroup(
        jResultadosFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jResultadosFilmePanelLayout.createSequentialGroup()
            .addGap(30, 30, 30)
            .addGroup(jResultadosFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jResultadosFilmePanelLayout.createSequentialGroup()
                    .addGap(490, 490, 490)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE))
                .addGroup(jResultadosFilmePanelLayout.createSequentialGroup()
                    .addGroup(jResultadosFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jResultadosFilmePanelLayout.createSequentialGroup()
                            .addGap(280, 280, 280)
                            .addComponent(jLabel78))
                        .addGroup(jResultadosFilmePanelLayout.createSequentialGroup()
                            .addGap(81, 81, 81)
                            .addGroup(jResultadosFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel77)
                                .addGroup(jResultadosFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jResultadosFilmePanelLayout.createSequentialGroup()
                                        .addGroup(jResultadosFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel82)
                                            .addComponent(jLabel80)
                                            .addComponent(jLabel79)
                                            .addComponent(jLabel74)
                                            .addComponent(jLabel75))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jResultadosFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jResultadosFilmePanelLayout.createSequentialGroup()
                                                .addGroup(jResultadosFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jResultadosFilmePanelLayout.createSequentialGroup()
                                                        .addGroup(jResultadosFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                                            .addComponent(realizadorResultadosFilme)
                                                            .addComponent(tituloResultadosFilme)
                                                            .addComponent(paisResultadosFilme))
                                                        .addGap(52, 52, 52)
                                                        .addGroup(jResultadosFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel83)
                                                            .addComponent(jLabel81)
                                                            .addComponent(jLabel84))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jResultadosFilmePanelLayout.createSequentialGroup()
                                                        .addComponent(alugar)
                                                        .addGap(13, 13, 13)))
                                                .addGroup(jResultadosFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(imdbResultadosFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(produtorResultadosFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jResultadosFilmePanelLayout.createSequentialGroup()
                                                        .addComponent(anoResultadosFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(71, 71, 71)
                                                        .addGroup(jResultadosFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel76)))))
                                            .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jResultadosFilmePanelLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(jResultadosFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jResultadosFilmePanelLayout.createSequentialGroup()
                                                .addComponent(jLabel98)
                                                .addGap(18, 18, 18)
                                                .addComponent(listaFormatosResultadosFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jResultadosFilmePanelLayout.createSequentialGroup()
                                                .addComponent(jLabel99)
                                                .addGap(18, 18, 18)
                                                .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
                                        .addGap(378, 378, 378)))
                                .addGroup(jResultadosFilmePanelLayout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGap(631, 631, 631)))
            .addGap(283, 283, 283))
    );
    jResultadosFilmePanelLayout.setVerticalGroup(
        jResultadosFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jResultadosFilmePanelLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel78)
            .addGap(9, 9, 9)
            .addComponent(jLabel77)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jResultadosFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(tituloResultadosFilme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel81)
                .addComponent(jLabel79)
                .addComponent(anoResultadosFilme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel76))
            .addGap(18, 18, 18)
            .addGroup(jResultadosFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jResultadosFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel80)
                    .addComponent(jLabel83)
                    .addComponent(produtorResultadosFilme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jResultadosFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel82)
                .addComponent(realizadorResultadosFilme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel84)
                .addComponent(imdbResultadosFilme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jResultadosFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel74)
                .addComponent(paisResultadosFilme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jResultadosFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jResultadosFilmePanelLayout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addComponent(jLabel75))
                .addGroup(jResultadosFilmePanelLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jResultadosFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel98)
                .addComponent(listaFormatosResultadosFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jResultadosFilmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel99)
                .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addComponent(alugar))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(321, 321, 321)
            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(135, 135, 135))
    );

    javax.swing.GroupLayout resultadosFrameLayout = new javax.swing.GroupLayout(resultadosFrame.getContentPane());
    resultadosFrame.getContentPane().setLayout(resultadosFrameLayout);
    resultadosFrameLayout.setHorizontalGroup(
        resultadosFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resultadosFrameLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jResultadosFilmePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );
    resultadosFrameLayout.setVerticalGroup(
        resultadosFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resultadosFrameLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jResultadosFilmePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    adicionarClienteFrame.setAlwaysOnTop(true);
    adicionarClienteFrame.setMinimumSize(new java.awt.Dimension(800, 600));
    adicionarClienteFrame.addWindowListener(new java.awt.event.WindowAdapter() {
        public void windowClosing(java.awt.event.WindowEvent evt) {
            adicionarClienteFrameWindowClosing(evt);
        }
    });

    jLabel24.setText("Confirm Password:");

    jLabel29.setText("BI:");

    jLabel33.setText("Adicionar Novo Cliente ( para actualização marcar campos a modificar com V ):");

    outputAdicionaClientes.setColumns(20);
    outputAdicionaClientes.setRows(5);
    jScrollPane7.setViewportView(outputAdicionaClientes);

    jVoltarACFButton.setText("Voltar");
    jVoltarACFButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jVoltarACFButtonActionPerformed(evt);
        }
    });

    biAdicionaClientes.setText("");

    telefoneAdicionaClientes.setText("239000000");

    adicionarCliente.setText("Adicionar/Actualizar");
    adicionarCliente.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            adicionarClienteActionPerformed(evt);
        }
    });

    obterDadosAdicionarClientes.setText("Obter Dados Para Actualização");
    obterDadosAdicionarClientes.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            obterDadosAdicionarClientesActionPerformed(evt);
        }
    });

    jLabel25.setText("Nome:");

    jLabel26.setText("Telefone:");

    jLabel27.setText("Password:");

    jLabel28.setText("Morada:");

    jLabel30.setText("E-mail:");

    javax.swing.GroupLayout jAdicionarClientePanelLayout = new javax.swing.GroupLayout(jAdicionarClientePanel);
    jAdicionarClientePanel.setLayout(jAdicionarClientePanelLayout);
    jAdicionarClientePanelLayout.setHorizontalGroup(
        jAdicionarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jAdicionarClientePanelLayout.createSequentialGroup()
            .addGroup(jAdicionarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jAdicionarClientePanelLayout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addGroup(jAdicionarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jAdicionarClientePanelLayout.createSequentialGroup()
                            .addGroup(jAdicionarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel27)
                                .addComponent(jLabel28)
                                .addComponent(jLabel30))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jAdicionarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jAdicionarClientePanelLayout.createSequentialGroup()
                                    .addGap(98, 98, 98)
                                    .addComponent(jLabel24)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(passwordAdicionaClientes2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(emailAdicionaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(moradaAdicionaClientes)))
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel33)
                        .addGroup(jAdicionarClientePanelLayout.createSequentialGroup()
                            .addGroup(jAdicionarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel26)
                                .addComponent(jLabel29)
                                .addComponent(jLabel25))
                            .addGap(18, 18, 18)
                            .addGroup(jAdicionarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jAdicionarClientePanelLayout.createSequentialGroup()
                                    .addComponent(biAdicionaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(46, 46, 46)
                                    .addComponent(obterDadosAdicionarClientes))
                                .addComponent(nomeAdicionaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(telefoneAdicionaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(passwordAdicionaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jAdicionarClientePanelLayout.createSequentialGroup()
                    .addGap(388, 388, 388)
                    .addComponent(jVoltarACFButton))
                .addGroup(jAdicionarClientePanelLayout.createSequentialGroup()
                    .addGap(183, 183, 183)
                    .addComponent(adicionarCliente)))
            .addContainerGap(427, Short.MAX_VALUE))
    );
    jAdicionarClientePanelLayout.setVerticalGroup(
        jAdicionarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jAdicionarClientePanelLayout.createSequentialGroup()
            .addGap(42, 42, 42)
            .addComponent(jLabel33)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jAdicionarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel25)
                .addComponent(nomeAdicionaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jAdicionarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jAdicionarClientePanelLayout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jLabel29)
                    .addGap(4, 4, 4)
                    .addGroup(jAdicionarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(telefoneAdicionaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jAdicionarClientePanelLayout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jAdicionarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(biAdicionaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(obterDadosAdicionarClientes))))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jAdicionarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel24)
                .addComponent(passwordAdicionaClientes2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel27)
                .addComponent(passwordAdicionaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(11, 11, 11)
            .addGroup(jAdicionarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(moradaAdicionaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel28))
            .addGap(18, 18, 18)
            .addGroup(jAdicionarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(emailAdicionaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel30))
            .addGap(42, 42, 42)
            .addComponent(adicionarCliente)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jVoltarACFButton)
            .addContainerGap(141, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout adicionarClienteFrameLayout = new javax.swing.GroupLayout(adicionarClienteFrame.getContentPane());
    adicionarClienteFrame.getContentPane().setLayout(adicionarClienteFrameLayout);
    adicionarClienteFrameLayout.setHorizontalGroup(
        adicionarClienteFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 1305, Short.MAX_VALUE)
        .addGroup(adicionarClienteFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adicionarClienteFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jAdicionarClientePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
    );
    adicionarClienteFrameLayout.setVerticalGroup(
        adicionarClienteFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 638, Short.MAX_VALUE)
        .addGroup(adicionarClienteFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adicionarClienteFrameLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jAdicionarClientePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)))
    );

    eliminarClienteFrame.setAlwaysOnTop(true);
    eliminarClienteFrame.setMinimumSize(new java.awt.Dimension(800, 600));
    eliminarClienteFrame.addWindowListener(new java.awt.event.WindowAdapter() {
        public void windowClosing(java.awt.event.WindowEvent evt) {
            eliminarClienteFrameWindowClosing(evt);
        }
    });

    jLabel50.setText("Eliminar Clientes:");

    jLabel51.setText("BI:");

    outEliminaClientes.setColumns(20);
    outEliminaClientes.setEditable(false);
    outEliminaClientes.setRows(5);
    jScrollPane11.setViewportView(outEliminaClientes);

    jButton14.setText("Voltar");
    jButton14.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton14ActionPerformed(evt);
        }
    });

    eliminarClienteBI.setText("Eliminar");
    eliminarClienteBI.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            eliminarClienteBIActionPerformed(evt);
        }
    });

    jScrollPane8.setViewportView(listaEliminarClientes);

    eliminarClientesLista.setText("Eliminar da Lista de Clientes");
    eliminarClientesLista.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            eliminarClientesListaActionPerformed(evt);
        }
    });

    biEliminaClientes.setText(" ");

    javax.swing.GroupLayout jEliminarClientePanelLayout = new javax.swing.GroupLayout(jEliminarClientePanel);
    jEliminarClientePanel.setLayout(jEliminarClientePanelLayout);
    jEliminarClientePanelLayout.setHorizontalGroup(
        jEliminarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jEliminarClientePanelLayout.createSequentialGroup()
            .addGap(43, 43, 43)
            .addGroup(jEliminarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jEliminarClientePanelLayout.createSequentialGroup()
                    .addComponent(jLabel51)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(biEliminaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(jEliminarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(eliminarClientesLista)
                        .addComponent(eliminarClienteBI))
                    .addGap(349, 349, 349))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jEliminarClientePanelLayout.createSequentialGroup()
                    .addGroup(jEliminarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jEliminarClientePanelLayout.createSequentialGroup()
                            .addGap(206, 206, 206)
                            .addComponent(jButton14))
                        .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGap(209, 209, 209))))
    );
    jEliminarClientePanelLayout.setVerticalGroup(
        jEliminarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jEliminarClientePanelLayout.createSequentialGroup()
            .addGap(49, 49, 49)
            .addComponent(jLabel50)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
            .addGap(18, 18, 18)
            .addComponent(eliminarClientesLista)
            .addGap(18, 18, 18)
            .addGroup(jEliminarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel51)
                .addComponent(biEliminaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(eliminarClienteBI))
            .addGap(18, 18, 18)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jButton14)
            .addGap(22, 22, 22))
    );

    javax.swing.GroupLayout eliminarClienteFrameLayout = new javax.swing.GroupLayout(eliminarClienteFrame.getContentPane());
    eliminarClienteFrame.getContentPane().setLayout(eliminarClienteFrameLayout);
    eliminarClienteFrameLayout.setHorizontalGroup(
        eliminarClienteFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 678, Short.MAX_VALUE)
        .addGroup(eliminarClienteFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eliminarClienteFrameLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jEliminarClientePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)))
    );
    eliminarClienteFrameLayout.setVerticalGroup(
        eliminarClienteFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 439, Short.MAX_VALUE)
        .addGroup(eliminarClienteFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eliminarClienteFrameLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jEliminarClientePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)))
    );

    notificarClientesFrame.setAlwaysOnTop(true);
    notificarClientesFrame.setMinimumSize(new java.awt.Dimension(800, 600));
    notificarClientesFrame.addWindowListener(new java.awt.event.WindowAdapter() {
        public void windowClosing(java.awt.event.WindowEvent evt) {
            notificarClientesFrameWindowClosing(evt);
        }
    });

    jLabel35.setText("Notificar Cliente:");

    jLabel42.setText("BI :");

    mensagem.setColumns(20);
    mensagem.setRows(5);
    jScrollPane9.setViewportView(mensagem);

    jLabel52.setText("Mensagem:");

    jToggleButton34.setText("Voltar");
    jToggleButton34.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jToggleButton34ActionPerformed(evt);
        }
    });

    enviarEmail.setText("Enviar E-Mail");
    enviarEmail.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            enviarEmailActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jNotificarClientePanelLayout = new javax.swing.GroupLayout(jNotificarClientePanel);
    jNotificarClientePanel.setLayout(jNotificarClientePanelLayout);
    jNotificarClientePanelLayout.setHorizontalGroup(
        jNotificarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jNotificarClientePanelLayout.createSequentialGroup()
            .addGroup(jNotificarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jNotificarClientePanelLayout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addGroup(jNotificarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel35)
                        .addGroup(jNotificarClientePanelLayout.createSequentialGroup()
                            .addComponent(jLabel42)
                            .addGap(18, 18, 18)
                            .addComponent(biNotificarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel52)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jNotificarClientePanelLayout.createSequentialGroup()
                    .addGap(244, 244, 244)
                    .addComponent(enviarEmail)
                    .addGap(18, 18, 18)
                    .addComponent(jToggleButton34)))
            .addContainerGap(92, Short.MAX_VALUE))
    );
    jNotificarClientePanelLayout.setVerticalGroup(
        jNotificarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jNotificarClientePanelLayout.createSequentialGroup()
            .addGap(51, 51, 51)
            .addComponent(jLabel35)
            .addGap(18, 18, 18)
            .addGroup(jNotificarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel42)
                .addComponent(biNotificarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(24, 24, 24)
            .addComponent(jLabel52)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(24, 24, 24)
            .addGroup(jNotificarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jToggleButton34)
                .addComponent(enviarEmail))
            .addContainerGap(23, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout notificarClientesFrameLayout = new javax.swing.GroupLayout(notificarClientesFrame.getContentPane());
    notificarClientesFrame.getContentPane().setLayout(notificarClientesFrameLayout);
    notificarClientesFrameLayout.setHorizontalGroup(
        notificarClientesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(notificarClientesFrameLayout.createSequentialGroup()
            .addGap(22, 22, 22)
            .addComponent(jNotificarClientePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(23, Short.MAX_VALUE))
    );
    notificarClientesFrameLayout.setVerticalGroup(
        notificarClientesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, notificarClientesFrameLayout.createSequentialGroup()
            .addContainerGap(48, Short.MAX_VALUE)
            .addComponent(jNotificarClientePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(25, 25, 25))
    );

    pesquisarClienteFrame.setAlwaysOnTop(true);
    pesquisarClienteFrame.setMinimumSize(new java.awt.Dimension(800, 600));
    pesquisarClienteFrame.addWindowListener(new java.awt.event.WindowAdapter() {
        public void windowClosing(java.awt.event.WindowEvent evt) {
            pesquisarClienteFrameWindowClosing(evt);
        }
    });

    jLabel43.setText("ID:");

    jLabel44.setText("BI:");

    jLabel45.setText("Morada:");

    jLabel46.setText("E-mail:");

    jLabel47.setText("Telefone:");

    jLabel48.setText("Nome:");

    jLabel49.setText("Pesquisar Cliente:");

    pesquisarClientesButton.setText("Pesquisar Clientes");
    pesquisarClientesButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            pesquisarClientesButtonActionPerformed(evt);
        }
    });

    jList7.setModel(new javax.swing.AbstractListModel() {
        String[] strings = { ""};
        public int getSize() { return strings.length; }
        public Object getElementAt(int i) { return strings[i]; }
    });
    jScrollPane10.setViewportView(jList7);

    outPesquisarClientes.setColumns(20);
    outPesquisarClientes.setEditable(false);
    outPesquisarClientes.setRows(5);
    jScrollPane22.setViewportView(outPesquisarClientes);

    voltarPesquisarCliente.setText("Voltar");
    voltarPesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            voltarPesquisarClienteActionPerformed(evt);
        }
    });

    jLabel96.setText("Lista de Clientes:");

    pesquisarPorBI.setText("Pesquisar por BI");
    pesquisarPorBI.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            pesquisarPorBIActionPerformed(evt);
        }
    });

    pesquisarPorID.setText("Pesquisar por ID");
    pesquisarPorID.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            pesquisarPorIDActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPesquisarClientePanelLayout = new javax.swing.GroupLayout(jPesquisarClientePanel);
    jPesquisarClientePanel.setLayout(jPesquisarClientePanelLayout);
    jPesquisarClientePanelLayout.setHorizontalGroup(
        jPesquisarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPesquisarClientePanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPesquisarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPesquisarClientePanelLayout.createSequentialGroup()
                    .addComponent(jLabel96)
                    .addContainerGap())
                .addGroup(jPesquisarClientePanelLayout.createSequentialGroup()
                    .addGroup(jPesquisarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel49)
                        .addGroup(jPesquisarClientePanelLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                            .addGroup(jPesquisarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pesquisarClientesButton)
                                .addGroup(jPesquisarClientePanelLayout.createSequentialGroup()
                                    .addGroup(jPesquisarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel48)
                                        .addComponent(jLabel45))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPesquisarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(moradaPesquisarClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                        .addComponent(nomePesquisarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPesquisarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPesquisarClientePanelLayout.createSequentialGroup()
                                        .addComponent(jLabel44)
                                        .addGap(18, 18, 18)
                                        .addComponent(biPesquisarClientes))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPesquisarClientePanelLayout.createSequentialGroup()
                                        .addComponent(jLabel43)
                                        .addGap(18, 18, 18)
                                        .addComponent(idPesquisarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(27, 27, 27)
                            .addGroup(jPesquisarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPesquisarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPesquisarClientePanelLayout.createSequentialGroup()
                                        .addComponent(jLabel47)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(telefonePesquisarClientes))
                                    .addComponent(pesquisarPorBI)
                                    .addGroup(jPesquisarClientePanelLayout.createSequentialGroup()
                                        .addComponent(jLabel46)
                                        .addGap(18, 18, 18)
                                        .addComponent(emailPesquisarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(pesquisarPorID))
                            .addGap(94, 94, 94))
                        .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
                .addGroup(jPesquisarClientePanelLayout.createSequentialGroup()
                    .addGroup(jPesquisarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(voltarPesquisarCliente)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())))
    );
    jPesquisarClientePanelLayout.setVerticalGroup(
        jPesquisarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPesquisarClientePanelLayout.createSequentialGroup()
            .addGap(41, 41, 41)
            .addGroup(jPesquisarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPesquisarClientePanelLayout.createSequentialGroup()
                    .addComponent(jLabel49)
                    .addGap(17, 17, 17)
                    .addGroup(jPesquisarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel43)
                        .addComponent(idPesquisarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(pesquisarPorID))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPesquisarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel44)
                .addComponent(biPesquisarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(pesquisarPorBI))
            .addGap(18, 18, 18)
            .addGroup(jPesquisarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(emailPesquisarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel48)
                .addComponent(nomePesquisarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel46))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPesquisarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel45)
                .addComponent(moradaPesquisarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel47)
                .addComponent(telefonePesquisarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(10, 10, 10)
            .addComponent(pesquisarClientesButton)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(26, 26, 26)
            .addComponent(jLabel96)
            .addGap(2, 2, 2)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(voltarPesquisarCliente)
            .addContainerGap(24, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout pesquisarClienteFrameLayout = new javax.swing.GroupLayout(pesquisarClienteFrame.getContentPane());
    pesquisarClienteFrame.getContentPane().setLayout(pesquisarClienteFrameLayout);
    pesquisarClienteFrameLayout.setHorizontalGroup(
        pesquisarClienteFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pesquisarClienteFrameLayout.createSequentialGroup()
            .addComponent(jPesquisarClientePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    pesquisarClienteFrameLayout.setVerticalGroup(
        pesquisarClienteFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pesquisarClienteFrameLayout.createSequentialGroup()
            .addComponent(jPesquisarClientePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(12, Short.MAX_VALUE))
    );

    formatosFrame.setAlwaysOnTop(true);
    formatosFrame.setMinimumSize(new java.awt.Dimension(800, 600));
    formatosFrame.addWindowListener(new java.awt.event.WindowAdapter() {
        public void windowClosing(java.awt.event.WindowEvent evt) {
            formatosFrameWindowClosing(evt);
        }
    });

    jScrollPane23.setViewportView(listaFormato);

    jLabel34.setText("Lista de Formatos:");

    jLabel36.setText("Nome:");

    adicionarFormato.setText("Adicionar");
    adicionarFormato.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            adicionarFormatoActionPerformed(evt);
        }
    });

    voltarFormatos.setText("Voltar");
    voltarFormatos.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            voltarFormatosActionPerformed(evt);
        }
    });

    eliminarFormato.setText("Eliminar");
    eliminarFormato.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            eliminarFormatoActionPerformed(evt);
        }
    });

    outFormato.setColumns(20);
    outFormato.setRows(5);
    jScrollPane24.setViewportView(outFormato);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel34)
                        .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(68, 68, 68)
                            .addComponent(eliminarFormato))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel36)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(textFormato, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(adicionarFormato))
                        .addComponent(jScrollPane24, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))))
            .addGap(51, 51, 51)
            .addComponent(voltarFormatos)
            .addGap(63, 63, 63))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(25, 25, 25)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(voltarFormatos)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel34)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(eliminarFormato)
                    .addGap(27, 27, 27)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textFormato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(adicionarFormato)
                        .addComponent(jLabel36))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout formatosFrameLayout = new javax.swing.GroupLayout(formatosFrame.getContentPane());
    formatosFrame.getContentPane().setLayout(formatosFrameLayout);
    formatosFrameLayout.setHorizontalGroup(
        formatosFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    formatosFrameLayout.setVerticalGroup(
        formatosFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(formatosFrameLayout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(31, Short.MAX_VALUE))
    );

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    mainPanel.setBackground(new java.awt.Color(204, 255, 153));
    mainPanel.setDoubleBuffered(false);
    mainPanel.setMaximumSize(new java.awt.Dimension(800, 600));
    mainPanel.setMinimumSize(new java.awt.Dimension(800, 600));
    mainPanel.setOpaque(false);
    mainPanel.setPreferredSize(new java.awt.Dimension(800, 600));
    mainPanel.setLayout(null);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
            .addContainerGap())
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jUsernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUsernameFieldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jUsernameFieldActionPerformed

    private void jVenderATMButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVenderATMButtonActionPerformed

        String idMaquina=((String)listaMaquinas.getSelectedValue()).split(" ")[0];
        outMaquinas.setText(gestorMaquinas.invalidaMaquinaATM(idMaquina));
        listaMaquinas.setModel(new OurListModel(gestorMaquinas.verListaMaquinasATM()));

    }//GEN-LAST:event_jVenderATMButtonActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jPesquisarClientesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPesquisarClientesButtonActionPerformed
        jList7.setModel(new OurListModel(gestorClientes.verListaClientes()));
        pesquisarClienteFrame.setVisible(true);
        transferFocus();
    }//GEN-LAST:event_jPesquisarClientesButtonActionPerformed

    private void jAdicionarClientesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAdicionarClientesButtonActionPerformed
        // TODO add your handling code here:
        adicionarClienteFrame.setVisible(true);
        transferFocus();
    }//GEN-LAST:event_jAdicionarClientesButtonActionPerformed

    private void jEliminarFilmeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEliminarFilmeButtonActionPerformed
        listaFormatos.setModel(new javax.swing.DefaultComboBoxModel(Utils.strArrayVectorToArray(gestorFilmes.verListaFormatos(), 1)));
       
        eliminarFilmesFrame.setVisible(true);
        transferFocus();
    }//GEN-LAST:event_jEliminarFilmeButtonActionPerformed

    private void pesquisarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarClientesActionPerformed
        // TODO add your handling code here:
        jList7.setModel(new OurListModel(gestorClientes.verListaClientes()));
        pesquisarClienteFrame.setVisible(true);
        transferFocus();
    }//GEN-LAST:event_pesquisarClientesActionPerformed

    private void adicionarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adicionarClientesActionPerformed

    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser1ActionPerformed
        //TODO : Código seleccionar fiheiro!
        filePath=jFileChooser1.getSelectedFile().getAbsolutePath();
        
        ficheirosFrame.setVisible(false);
        ficheirosFrame.transferFocusBackward();
    }//GEN-LAST:event_jFileChooser1ActionPerformed

    private void pesquisarFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarFilmeActionPerformed
        
        //Fazer a pesquisa
        //TODO fazer parsing do output do método
        String []lista;
        //procuraFilmes(String titulo, String anoLow, String anoHigh, String realizador, String ratingIMDBLow, String ratingIMDBHigh, String pais, String produtora, String[] generos)
        lista=gestorFilmes.procuraFilmes(
        		//textIdPesquisaFilmes.getText(),
                textTituloPesquisaFilmes.getText(),
                ""+(Integer)jSpinner1.getValue(),
                ""+(Integer)jSpinner3.getValue(),
                textRealizadorPesquisaFilmes.getText(),
                ""+(Double)jSpinner4.getValue(),
                ""+(Double)jSpinner5.getValue(),
                (String) countriesList1.getSelectedItem(),
                textProdutorPesquisaFilmes.getText(),
                new String[0]);

        String[] strings= new String[lista.length/2];
        String[] id= new String[lista.length/2];
        for(int i=0; i<lista.length/2;i++){
            strings[i]=lista[2*i+1];
            id[i]=lista[2*i];
        }
        jList4.setModel(new OurListModel(lista) );
        //Reset aos campos
         textRealizadorPesquisaFilmes.setText(null);
         textIdPesquisaFilmes.setText(null);
          textTituloPesquisaFilmes.setText(null);
           textProdutorPesquisaFilmes.setText(null);

        pesquisarFilmesFrame.setVisible(false);
      pesquisarFilmesFrame.transferFocusBackward();
      listaFormatosResultadosFilmes.setModel(new javax.swing.DefaultComboBoxModel(Utils.strArrayVectorToArray(gestorFilmes.verListaFormatos(), 1)));

      resultadosFrame.setVisible(true);
      transferFocus();
    }//GEN-LAST:event_pesquisarFilmeActionPerformed

    private void jSairButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSairButtonActionPerformed
        // TODO invalidar sessão
        //Set panel's visibility

        
        jLoginPanel.setVisible(true);
        
        jMenuOperatorPanel.setVisible(false);
        jMenuAdministradorPanel.setVisible(false);
        
    }//GEN-LAST:event_jSairButtonActionPerformed

    private void jSairButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSairButton2ActionPerformed
        // TODO invalidar sessão
        //Set panel's visibility

        jLoginPanel.setVisible(true);
       
        jMenuOperatorPanel.setVisible(false);
        jMenuAdministradorPanel.setVisible(false);
        
    }//GEN-LAST:event_jSairButton2ActionPerformed

    private void jEscolherFicheiroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEscolherFicheiroButtonActionPerformed
        // TODO add your handling code here:
        ficheirosFrame.setVisible(true);
        transferFocus();
    }//GEN-LAST:event_jEscolherFicheiroButtonActionPerformed

    private void jLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLoginButtonActionPerformed
        //TODO: descomentar
        /**
        String out=gestorUtilizadores.login(jUsernameField.getText(), jPasswordField.getText());
        if(!out.equals("FAIL")){
            if(out.equals("1")){
                //administrador
                jMenuAdministradorPanel.setVisible(true);
            }else{
                //empregado
                jMenuOperatorPanel.setVisible(true);
            }
            jLoginPanel.setVisible(false);
        }
        */
       jUsernameField.setText("");
       jPasswordField.setText("");
    }//GEN-LAST:event_jLoginButtonActionPerformed

    private void jAdicionarATMButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAdicionarATMButtonActionPerformed
        
        gestorMaquinas.adicionaMaquinaATM(""+((Double)jSpinner6.getValue()));
        outMaquinas.setText("Output");
        listaMaquinas.setModel(new OurListModel(gestorMaquinas.verListaMaquinasATM()));
    }//GEN-LAST:event_jAdicionarATMButtonActionPerformed

    private void jDespedirEmpregadoButtonComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jDespedirEmpregadoButtonComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_jDespedirEmpregadoButtonComponentResized

    private void jAdicionarEmpregadoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAdicionarEmpregadoButtonActionPerformed
        String isAdmin="0";
        if(!nomeEmpregados.getText().isEmpty()
             &&biEmpregados.isEditValid()
             &&salarioEmpregados.isEditValid()
             &&telefoneEmpregados.isEditValid()
             &&(passwordEmpregados.getText().equals(passwordEmpregados2.getText()))//TODO : Deprecated
               ){
               
            if(adminRadio.isSelected())
                isAdmin="1";
            gestorEmpregados.actualizaEmpregado(nomeEmpregados.getText(),
                    telefoneEmpregados.getText(),
                    biEmpregados.getText(),
                    isAdmin,
                    passwordEmpregados.getText(),
                    salarioEmpregados.getText(),
                    emailEmpregados.getText(),
                    moradaEmpregados.getText());
        }
    }//GEN-LAST:event_jAdicionarEmpregadoButtonActionPerformed

    private void jVerificarPagamentosAtrasoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVerificarPagamentosAtrasoButtonActionPerformed

        pagamentosAtraso.setModel(new OurListModel(gestorClientes.getClientesComEntregasForaDePrazo()));
    }//GEN-LAST:event_jVerificarPagamentosAtrasoButtonActionPerformed

    private void jEliminarClientesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEliminarClientesButtonActionPerformed
        listaEliminarClientes.setModel(new OurListModel(gestorClientes.verListaClientes()));
        eliminarClienteFrame.setVisible(true);
        transferFocus();
    }//GEN-LAST:event_jEliminarClientesButtonActionPerformed

    private void jNotificarClientesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNotificarClientesButtonActionPerformed
        notificarClientesFrame.setVisible(true);
        transferFocus();
    }//GEN-LAST:event_jNotificarClientesButtonActionPerformed

    private void jPesquisarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPesquisarButtonActionPerformed

        pesquisarFilmesFrame.setVisible(true);
        transferFocus();
    }//GEN-LAST:event_jPesquisarButtonActionPerformed

    private void jGeneroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGeneroButtonActionPerformed
        // TODO add your handling code here:
        //refresh à lista de géneros
        
       /* TODO: by Lobo: verListaGeneros() devolve um Vector com pares [id_genero, nome_genero].
        	 * eu percebi que aki tavam a usar os nomes s�, por isso pus a funcao strArrayVectorToArray()
        	 * para pegar so nos indices 1 de cada par (ou seja, o nome).
        	 * Se permitirem a gest�o de g�neros vao precisar do ID do genero
        	 * para lhe alterar o nome (o porqu� eu explico depois).
        	 * Ou seja, vao ter de guardar os pares e nao o nome, e isto tem de mudar.
        	 */
        listaGeneros.setModel(new OurListModel(Utils.strArrayVectorToArray(gestorFilmes.verListaGeneros(), 1)));

        jScrollPane21.setViewportView(listaGeneros);
        //mostrar a frame
        generosFrame.setVisible(true);
        transferFocus();
    }//GEN-LAST:event_jGeneroButtonActionPerformed

    private void jAdicionarFilmesToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAdicionarFilmesToggleButtonActionPerformed
        // TODO add your handling code here:
        //Set aos generos existentes
        listaFormatosAdicionaFilme.setModel(new javax.swing.DefaultComboBoxModel(Utils.strArrayVectorToArray(gestorFilmes.verListaFormatos(), 1)));
        listaGenerosAdicionaFilmes.setModel(new javax.swing.DefaultComboBoxModel(gestorFilmes.verListaGeneros()));
        adicionarFilmeFrame.setVisible(true);
        transferFocus();
    }//GEN-LAST:event_jAdicionarFilmesToggleButtonActionPerformed

    private void adicionarClienteFrameWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_adicionarClienteFrameWindowClosing
       adicionarClienteFrame.setVisible(false);
       adicionarClienteFrame.transferFocusBackward();
    }//GEN-LAST:event_adicionarClienteFrameWindowClosing

    private void jVoltarACFButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVoltarACFButtonActionPerformed
       adicionarClienteFrame.setVisible(false);
       adicionarClienteFrame.transferFocusBackward();
    }//GEN-LAST:event_jVoltarACFButtonActionPerformed

    private void voltarGenerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarGenerosActionPerformed
       outGenero.setText("");
       textGenero.setText("");
       generosFrame.setVisible(false);
       generosFrame.transferFocusBackward();
    }//GEN-LAST:event_voltarGenerosActionPerformed

    private void generosFrameWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_generosFrameWindowClosing
       outGenero.setText("");
       textGenero.setText("");
       generosFrame.setVisible(false);
       generosFrame.transferFocusBackward();
    }//GEN-LAST:event_generosFrameWindowClosing

    private void adicionaGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionaGeneroActionPerformed

        String output=gestorFilmes.adicionaGenero(textGenero.getText());
        textGenero.setText(null);
        outGenero.setText(output);
        /* TODO: by Lobo: ver o TODO gigante que escrevi em cima. Mesma coisa.
        	 */
        listaGeneros.setModel(new OurListModel(Utils.strArrayVectorToArray(gestorFilmes.verListaGeneros(), 1)));


        jScrollPane21.setViewportView(listaGeneros);
    }//GEN-LAST:event_adicionaGeneroActionPerformed

    private void adicionaGenero2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionaGenero2ActionPerformed
        // TODO add your handling code here:

        gestorFilmes.adicionaGenero(textGenero.getText());
        textGenero.setText(null);

        listaGeneros.setModel(new javax.swing.AbstractListModel() {
        	/* TODO: by Lobo: ver o TODO gigante que escrevi em cima. Mesma coisa.
        	 */
        	String[] strings = Utils.strArrayVectorToArray(gestorFilmes.verListaGeneros(), 1);
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });

        jScrollPane21.setViewportView(listaGeneros);
    }//GEN-LAST:event_adicionaGenero2ActionPerformed

    private void listarFormatoEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarFormatoEliminarActionPerformed
        textEliminaFilmes.setText(gestorFilmes.listarFormato(idEliminaFilmes.getText(), (String)listaFormatos.getSelectedItem()));
        
    }//GEN-LAST:event_listarFormatoEliminarActionPerformed

    private void eliminaFilmes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminaFilmes2ActionPerformed
        // TODO add your handling code here:
        listaFormatos.setModel(new javax.swing.DefaultComboBoxModel(Utils.strArrayVectorToArray(gestorFilmes.verListaFormatos(), 1)));
       
        eliminarFilmesFrame.setVisible(true);
        transferFocus();
    }//GEN-LAST:event_eliminaFilmes2ActionPerformed

    private void voltarEliminaFilmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarEliminaFilmesActionPerformed
        // TODO add your handling code here:
        textEliminaFilmes.setText(null);
        idEliminaFilmes.setText(null);
         eliminarFilmesFrame.setVisible(false);
       eliminarFilmesFrame.transferFocusBackward();
    }//GEN-LAST:event_voltarEliminaFilmesActionPerformed

    private void eliminaFilmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminaFilmesActionPerformed
        // TODO add your handling code here:
        gestorFilmes.deleteStock(idEliminaFilmes.getText(), (String)listaFormatos.getSelectedItem(),(Integer)eliminaSpinner.getValue());

    }//GEN-LAST:event_eliminaFilmesActionPerformed

    private void jToggleButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton17ActionPerformed
        // TODO add your handling code here:
        listaFormatosAdicionaFilme.setModel(new javax.swing.DefaultComboBoxModel(Utils.strArrayVectorToArray(gestorFilmes.verListaFormatos(), 1)));

        listaGenerosAdicionaFilmes.setModel(new javax.swing.DefaultComboBoxModel(gestorFilmes.verListaGeneros()));
        adicionarFilmeFrame.setVisible(true);
        transferFocus();
    }//GEN-LAST:event_jToggleButton17ActionPerformed

    private void jToggleButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton18ActionPerformed
        // TODO add your handling code here:
        listaFormatosAdicionaFilme.setModel(new javax.swing.DefaultComboBoxModel(Utils.strArrayVectorToArray(gestorFilmes.verListaFormatos(), 1)));

        listaGenerosAdicionaFilmes.setModel(new javax.swing.DefaultComboBoxModel(gestorFilmes.verListaGeneros()));
        adicionarFilmeFrame.setVisible(true);
        transferFocus();
    }//GEN-LAST:event_jToggleButton18ActionPerformed

    private void jActualizarStockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jActualizarStockButtonActionPerformed
        // TODO add your handling code here:
        listaFormatosAdicionaFilme.setModel(new javax.swing.DefaultComboBoxModel(Utils.strArrayVectorToArray(gestorFilmes.verListaFormatos(), 1)));

        listaGenerosAdicionaFilmes.setModel(new javax.swing.DefaultComboBoxModel(gestorFilmes.verListaGeneros()));
        adicionarFilmeFrame.setVisible(true);
        transferFocus();
    }//GEN-LAST:event_jActualizarStockButtonActionPerformed

    private void adicionarFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarFilmeActionPerformed
        // TODO : Só DA PARA ESCOLHER 1GENERO POR AGORA
        String output="";
        String []generos=new String[1];
        generos[0]=(String)listaGenerosAdicionaFilmes.getSelectedItem();
        //adicionaFilme(String titulo, String ano, String realizador, String ratingIMDB, String pais, String produtora, String descricao, String capa, String[] generos
        output=gestorFilmes.adicionaFilme(
        		textTituloAdicionaFilme.getText(),
                ""+(Integer)anoAdicionaFilmeSpinner.getValue(),
                textRealizadorAdicionaFilme.getText(),
                ""+(Double)jSpinner2.getValue(),
                (String)countriesList.getSelectedItem(),
                textProdutorAdicionaFilme.getText(),
                textDescricaoAdicionaFilme.getText(),
                filePath,
                generos);

        jTextArea11.setText(output);
    }//GEN-LAST:event_adicionarFilmeActionPerformed

    private void adicionarStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarStockActionPerformed
        // TODO add your handling code here:
        String output="";
        output=gestorFilmes.addStock(jTextField32.getText(), (String)listaFormatosAdicionaFilme.getSelectedItem(), jTextField33.getText(), jTextField34.getText());
        jTextArea12.setText(output);
    }//GEN-LAST:event_adicionarStockActionPerformed

    private void pesquisarFilmes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarFilmes2ActionPerformed
        // TODO add your handling code here:
        pesquisarFilmesFrame.setVisible(true);
        transferFocus();
    }//GEN-LAST:event_pesquisarFilmes2ActionPerformed

    private void voltarPesquisarFilmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarPesquisarFilmesActionPerformed
        // TODO add your handling code here:
        textRealizadorPesquisaFilmes.setText(null);
         textIdPesquisaFilmes.setText(null);
          textTituloPesquisaFilmes.setText(null);
           textProdutorPesquisaFilmes.setText(null);
            
        pesquisarFilmesFrame.setVisible(false);
      pesquisarFilmesFrame.transferFocusBackward();
    }//GEN-LAST:event_voltarPesquisarFilmesActionPerformed

    private void pesquisarFilmesFrameWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_pesquisarFilmesFrameWindowClosing
       //Reset aos campos
         textRealizadorPesquisaFilmes.setText(null);
         textIdPesquisaFilmes.setText(null);
          textTituloPesquisaFilmes.setText(null);
           textProdutorPesquisaFilmes.setText(null);

        pesquisarFilmesFrame.setVisible(false);
      pesquisarFilmesFrame.transferFocusBackward();
    }//GEN-LAST:event_pesquisarFilmesFrameWindowClosing

    private void jList4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList4MouseClicked
        // TODO add your handling code here:
        String idMovie=((String)jList4.getSelectedValue()).split(" ")[0];
        //"ID_FIL", "TITULO", "ANO", "REALIZADOR", "RANKIMDB", "PAIS", "PRODUTORA", "DESCRICAO", "CAPA", "VALIDO"
        String[] f = gestorFilmes.getFilme(idMovie);
        
        int i=1; // i=1 em vez de i=0 -> saltar campo ID_FIL
        tituloResultadosFilme.setText(f[i++]);
        anoResultadosFilme.setText(f[i++]);
        realizadorResultadosFilme.setText(f[i++]);
        imdbResultadosFilme.setText(f[i++]);
        paisResultadosFilme.setText(f[i++]);
        produtorResultadosFilme.setText(f[i++]);
        jTextArea14.setText(f[i++]);
        jLabel76.setIcon(new ImageIcon(f[i++]));
        // extrair os generos do fim do array
        jList5.setModel(new OurListModel(Utils.extract(f, i+1))); // i+1 em vez de i -> saltar campo VALIDO
    }//GEN-LAST:event_jList4MouseClicked

    private void pesquisarClienteFrameWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_pesquisarClienteFrameWindowClosing
        // TODO add your handling code here:
        pesquisarClienteFrame.setVisible(false);
      pesquisarClienteFrame.transferFocusBackward();
    }//GEN-LAST:event_pesquisarClienteFrameWindowClosing

    private void voltarPesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarPesquisarClienteActionPerformed
        // TODO add your handling code here:
        pesquisarClienteFrame.setVisible(false);
      pesquisarClienteFrame.transferFocusBackward();
    }//GEN-LAST:event_voltarPesquisarClienteActionPerformed

    private void pesquisarClientesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarClientesButtonActionPerformed
        String [] out=gestorClientes.procuraClientes(
                
                nomePesquisarClientes.getText(),
                moradaPesquisarClientes.getText(),
                emailPesquisarClientes.getText(),
                telefonePesquisarClientes.getText());
        if(out!=null&&out.length!=0){
            outPesquisarClientes.setText("Foram encontrados "+out.length+"resultados\n" +
                    "-------------------------------------\n");
            for(int i=0; i<out.length;i++)
                outPesquisarClientes.append(out[i]+"\n");
        }else{
            outPesquisarClientes.setText(
                "Não foram encontrados resultados");
        }
        
    }//GEN-LAST:event_pesquisarClientesButtonActionPerformed

    private void notificarClientesFrameWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_notificarClientesFrameWindowClosing
        // TODO add your handling code here:
        mensagem.setText(null);
        biNotificarClientes.setText(null);
        notificarClientesFrame.setVisible(false);
      notificarClientesFrame.transferFocusBackward();
    }//GEN-LAST:event_notificarClientesFrameWindowClosing

    private void jToggleButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton34ActionPerformed
        mensagem.setText(null);
        biNotificarClientes.setText(null);
        notificarClientesFrame.setVisible(false);
      notificarClientesFrame.transferFocusBackward();
    }//GEN-LAST:event_jToggleButton34ActionPerformed

    private void enviarEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarEmailActionPerformed
        
        gestorClientes.notificarCliente(biNotificarClientes.getText(), mensagem.getText());
    }//GEN-LAST:event_enviarEmailActionPerformed

    private void voltarAdcionaFilmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarAdcionaFilmesActionPerformed
        // TODO add your handling code here:
        //TODO: RESET
       adicionarFilmeFrame.setVisible(false);
      adicionarFilmeFrame.transferFocusBackward();
    }//GEN-LAST:event_voltarAdcionaFilmesActionPerformed

    private void jVerificarPagamentosAtrasoButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVerificarPagamentosAtrasoButton1ActionPerformed
        pagamentosAtraso.setModel(new OurListModel(gestorClientes.getClientesComEntregasForaDePrazo()));
    }//GEN-LAST:event_jVerificarPagamentosAtrasoButton1ActionPerformed

    private void actualizarListaMaquinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarListaMaquinasActionPerformed

        listaMaquinas.setModel(new OurListModel(gestorMaquinas.verListaMaquinasATM()));
    }//GEN-LAST:event_actualizarListaMaquinasActionPerformed

    private void actualzarListaEmpregadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualzarListaEmpregadosActionPerformed

        listaEmpregados.setModel(new OurListModel(gestorEmpregados.verListaEmpregados()));
    }//GEN-LAST:event_actualzarListaEmpregadosActionPerformed

    private void jDespedirEmpregadoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDespedirEmpregadoButtonActionPerformed
       String output="";
       String idEmpregado=((String)listaEmpregados.getSelectedValue()).split(" ")[0];
       output=gestorEmpregados.invalidaEmpregado(idEmpregado);
       //TODO: Output message
       outEmpregados.setText(output);
    }//GEN-LAST:event_jDespedirEmpregadoButtonActionPerformed

    private void eliminarClienteFrameWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_eliminarClienteFrameWindowClosing
        
        biEliminaClientes.setText("");
        outEliminaClientes.setText("");
        eliminarClienteFrame.setVisible(false);
        eliminarClienteFrame.transferFocusBackward();
    }//GEN-LAST:event_eliminarClienteFrameWindowClosing

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        biEliminaClientes.setText("");
        outEliminaClientes.setText("");
        eliminarClienteFrame.setVisible(false);
        eliminarClienteFrame.transferFocusBackward();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void dataInitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataInitActionPerformed
        JFrame date = new JFrame("Calendário");
	jCalendarBegin = new JCalendar();

	date.getContentPane().add(jCalendarBegin);
	date.pack();
	date.setVisible(true);
	jCalendarBegin.addPropertyChangeListener(this);

    }//GEN-LAST:event_dataInitActionPerformed

    private void dataEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataEndActionPerformed
        JFrame date = new JFrame("Calendário");
        jCalendarEnd = new JCalendar();

        date.getContentPane().add(jCalendarEnd);
        date.pack();
        date.setVisible(true);
        jCalendarEnd.addPropertyChangeListener(this);

    }//GEN-LAST:event_dataEndActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        resetDatas();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        jTextArea2.setText("");
        if(jCheckBox5.isSelected()){
            //Clientes
            jTextArea2.append(gestorEstatisticas.estatisticasClientes(calendarBegin, calendarEnd));
        }
         if(jCheckBox3.isSelected()){
            //Clientes
            jTextArea2.append(gestorEstatisticas.estatisticasFilmes(calendarBegin, calendarEnd));
        }
         if(jCheckBox1.isSelected()){
            //Clientes
            jTextArea2.append(gestorEstatisticas.estatisticasEmpregados(calendarBegin, calendarEnd));
        }
        if(jCheckBox4.isSelected()){
            //Clientes
            jTextArea2.append(gestorEstatisticas.estatisticasMaquinas(calendarBegin, calendarEnd));
        }
        if(jCheckBox5.isSelected()){
            //Clientes
            jTextArea2.append(gestorEstatisticas.getEstatisticas(calendarBegin, calendarEnd));
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void notificarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notificarClientesActionPerformed
        notificarClientesFrame.setVisible(true);
        transferFocus();
    }//GEN-LAST:event_notificarClientesActionPerformed

    private void eliminarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarClientesActionPerformed
        listaEliminarClientes.setModel(new OurListModel(gestorClientes.verListaClientes()));
        eliminarClienteFrame.setVisible(true);
        transferFocus();
    }//GEN-LAST:event_eliminarClientesActionPerformed

    private void alugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alugarActionPerformed
        String output="";
        String idMovie=((String)jList4.getSelectedValue()).split(" ")[0];
        if(jFormattedTextField4.isEditValid()){
            output=gestorFilmes.alugaFilme(idMovie,
                    (String) listaFormatosResultadosFilmes.getSelectedItem(),
                    jFormattedTextField4.getText(),
                    gestorUtilizadores.getIdEmpregado());
        }
       
        jTextField1.setText(output);
    }//GEN-LAST:event_alugarActionPerformed

    private void adicionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarClienteActionPerformed
        String output="";
        if(biAdicionaClientes.isEditValid()
                &&!biAdicionaClientes.getText().isEmpty()
                &&!passwordAdicionaClientes2.getText().isEmpty()
                &&(passwordAdicionaClientes2.getText().equals(passwordAdicionaClientes.getText()))){
                
            output=gestorClientes.actualizaCliente(nomeAdicionaClientes.getText(),
                    biAdicionaClientes.getText(),
                    passwordAdicionaClientes2.getText(),
                    moradaAdicionaClientes.getText(), 
                    emailAdicionaClientes.getText(),
                    telefoneAdicionaClientes.getText());
            outputAdicionaClientes.setText(output);
        }else{
            outputAdicionaClientes.setText("Introduza o BI.");
        }
    }//GEN-LAST:event_adicionarClienteActionPerformed

    private void obterDadosAdicionarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obterDadosAdicionarClientesActionPerformed
        String [] out=gestorClientes.procuraClienteBI(biAdicionaClientes.getText());
        
        if(out!=null){
            nomeAdicionaClientes.setText(out[1]);
            passwordAdicionaClientes.setText(out[3]);
            passwordAdicionaClientes2.setText(out[3]);
            moradaAdicionaClientes.setText(out[4]);
            emailAdicionaClientes.setText(out[5]);
            telefoneAdicionaClientes.setText(out[6]);
        }
    }//GEN-LAST:event_obterDadosAdicionarClientesActionPerformed

    private void eliminarClienteBIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarClienteBIActionPerformed

        if(biEliminaClientes.isEditValid()){
            outEliminaClientes.setText(
                    gestorClientes.invalidaClienteBI(biEliminaClientes.getText()));
        }else{
            outEliminaClientes.setText("Nao foi possível eliminar.");
        }
    }//GEN-LAST:event_eliminarClienteBIActionPerformed

    private void eliminarClientesListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarClientesListaActionPerformed
        // TODO add your handling code here:
        try{
            String idCliente=((String)listaEliminarClientes.getSelectedValue()).split(" ")[0];
            outEliminaClientes.setText(
                    gestorClientes.invalidaCliente(idCliente));
        }catch (NullPointerException e){
            outEliminaClientes.setText("Erro: Seleccione o cliente a eliminar.");
        }
    }//GEN-LAST:event_eliminarClientesListaActionPerformed

    private void pesquisarPorIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarPorIDActionPerformed
        String [] out;
        if(idPesquisarClientes!=null&&!idPesquisarClientes.getText().isEmpty()){
            try{
                Integer.parseInt(idPesquisarClientes.getText());
                out=gestorClientes.procuraCliente(idPesquisarClientes.getText());
                if(out!=null&&out.length!=0){
                    outPesquisarClientes.setText("");
                    for(int i=0; i<out.length;i++)
                        outPesquisarClientes.append(out[i]+"\n");
                }else{
                    outPesquisarClientes.setText(
                        "Não foram encontrados resultados");
                }
            }catch (NumberFormatException ex){
                outPesquisarClientes.setText("Erro: ID tem de ser um Número");
            }
        }
    }//GEN-LAST:event_pesquisarPorIDActionPerformed

    private void pesquisarPorBIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarPorBIActionPerformed
        String [] out;
        if(biPesquisarClientes!=null&&!biPesquisarClientes.getText().isEmpty()){
            try{
                Integer.parseInt(biPesquisarClientes.getText());
                out=gestorClientes.procuraCliente(biPesquisarClientes.getText());
                if(out!=null&&out.length!=0){
                    outPesquisarClientes.setText("");
                    for(int i=0; i<out.length;i++)
                        outPesquisarClientes.append(out[i]+"\n");
                }else{
                    outPesquisarClientes.setText(
                        "Não foram encontrados resultados");
                }
            }catch (NumberFormatException ex){
                outPesquisarClientes.setText("Erro: BI tem de ser um Número");
            }
        }
    }//GEN-LAST:event_pesquisarPorBIActionPerformed

    private void obterDadosEmpregadoActualizacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obterDadosEmpregadoActualizacaoActionPerformed
        // TODO add your handling code here:
        String []out;
        if(biEmpregados.isEditValid()){
            out=gestorEmpregados.procuraEmpregadoBI(biEmpregados.getText());
            if(out!=null&&out.length>0){
                if(out[1].equals("1")){
                    adminRadio.doClick();
                }else{
                    opRadio.doClick();
                }
                salarioEmpregados.setText(out[2]);
                nomeEmpregados.setText(out[3]);
                passwordEmpregados.setText(out[5]);
                passwordEmpregados2.setText(out[5]);
                moradaEmpregados.setText(out[6]);
                emailEmpregados.setText(out[7]);
                telefoneEmpregados.setText(out[8]);
            }

        }
        
    }//GEN-LAST:event_obterDadosEmpregadoActualizacaoActionPerformed

    private void verificarRequesicoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verificarRequesicoesActionPerformed
        pagamentosAtraso.setModel(new OurListModel(gestorClientes.getClientesComEntregasPorFazer()));
    }//GEN-LAST:event_verificarRequesicoesActionPerformed

    private void verificarRequesicoes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verificarRequesicoes1ActionPerformed
        pagamentosAtraso.setModel(new OurListModel(gestorClientes.getClientesComEntregasPorFazer()));
    }//GEN-LAST:event_verificarRequesicoes1ActionPerformed

    private void eliminaGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminaGeneroActionPerformed
        String nomeGenero=((String)listaGeneros.getSelectedValue());
        String output=gestorFilmes.removeGeneroNome(nomeGenero);
        outGenero.setText(output);
        if(!output.equals(Consts.GENERO_EM_USO))
            listaGeneros.setModel(new OurListModel(Utils.strArrayVectorToArray(gestorFilmes.verListaGeneros(), 1)));

    }//GEN-LAST:event_eliminaGeneroActionPerformed

    private void eliminarFormatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarFormatoActionPerformed
        String nomeFormato=((String)listaFormato.getSelectedValue());
        String output=gestorFilmes.removeFormatoNome(nomeFormato);
        outFormato.setText(output);
        if(!output.equals(Consts.FORMATO_EM_USO))
            listaFormato.setModel(new OurListModel(Utils.strArrayVectorToArray(gestorFilmes.verListaFormatos(), 1)));

    }//GEN-LAST:event_eliminarFormatoActionPerformed

    private void adicionarFormatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarFormatoActionPerformed
        String output=gestorFilmes.adicionaFormato(textFormato.getText());
        textFormato.setText(null);
        outFormato.setText(output);
        
        listaFormato.setModel(new OurListModel(Utils.strArrayVectorToArray(gestorFilmes.verListaFormatos(), 1)));
    }//GEN-LAST:event_adicionarFormatoActionPerformed

    private void voltarFormatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarFormatosActionPerformed
        textFormato.setText("");
        outFormato.setText("");
        formatosFrame.setVisible(false);
        formatosFrame.transferFocusBackward();
    }//GEN-LAST:event_voltarFormatosActionPerformed

    private void formatosFrameWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formatosFrameWindowClosing
        textFormato.setText("");
        outFormato.setText("");
        formatosFrame.setVisible(false);
        formatosFrame.transferFocusBackward();
    }//GEN-LAST:event_formatosFrameWindowClosing

    private void jFormatosFrameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormatosFrameButtonActionPerformed
        listaFormato.setModel(new OurListModel(Utils.strArrayVectorToArray(gestorFilmes.verListaFormatos(), 1)));
        formatosFrame.setVisible(true);
        transferFocus();
    }//GEN-LAST:event_jFormatosFrameButtonActionPerformed

    private void jFormatosFrameButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormatosFrameButton1ActionPerformed
        listaFormato.setModel(new OurListModel(Utils.strArrayVectorToArray(gestorFilmes.verListaFormatos(), 1)));
        formatosFrame.setVisible(true);
        transferFocus();
    }//GEN-LAST:event_jFormatosFrameButton1ActionPerformed

   
    //OUR GUI VARS
    private javax.swing.ButtonGroup bgroup;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarListaMaquinas;
    private javax.swing.JButton actualzarListaEmpregados;
    private javax.swing.JButton adicionaGenero;
    private javax.swing.JToggleButton adicionaGenero2;
    private javax.swing.JButton adicionarCliente;
    private javax.swing.JFrame adicionarClienteFrame;
    private javax.swing.JToggleButton adicionarClientes;
    private javax.swing.JButton adicionarFilme;
    private javax.swing.JFrame adicionarFilmeFrame;
    private javax.swing.JButton adicionarFormato;
    private javax.swing.JToggleButton adicionarStock;
    private javax.swing.JRadioButton adminRadio;
    private javax.swing.JButton alugar;
    private javax.swing.JSpinner anoAdicionaFilmeSpinner;
    private javax.swing.JTextField anoResultadosFilme;
    private javax.swing.JFormattedTextField biAdicionaClientes;
    private javax.swing.JFormattedTextField biEliminaClientes;
    private javax.swing.JFormattedTextField biEmpregados;
    private javax.swing.JTextField biNotificarClientes;
    private javax.swing.JTextField biPesquisarClientes;
    private javax.swing.JComboBox countriesList;
    private javax.swing.JComboBox countriesList1;
    private javax.swing.JButton dataEnd;
    private javax.swing.JButton dataInit;
    private javax.swing.JTextField dateBegin;
    private javax.swing.JTextField dateEnd;
    private javax.swing.JToggleButton eliminaFilmes;
    private javax.swing.JToggleButton eliminaFilmes2;
    private javax.swing.JButton eliminaGenero;
    private javax.swing.JSpinner eliminaSpinner;
    private javax.swing.JButton eliminarClienteBI;
    private javax.swing.JFrame eliminarClienteFrame;
    private javax.swing.JButton eliminarClientes;
    private javax.swing.JButton eliminarClientesLista;
    private javax.swing.JFrame eliminarFilmesFrame;
    private javax.swing.JButton eliminarFormato;
    private javax.swing.JTextField emailAdicionaClientes;
    private javax.swing.JTextField emailEmpregados;
    private javax.swing.JTextField emailPesquisarClientes;
    private javax.swing.JButton enviarEmail;
    private javax.swing.JFrame ficheirosFrame;
    private javax.swing.JFrame formatosFrame;
    private javax.swing.JFrame generosFrame;
    private javax.swing.JTextField idEliminaFilmes;
    private javax.swing.JTextField idPesquisarClientes;
    private javax.swing.JTextField imdbResultadosFilme;
    private javax.swing.JPanel jATMManagerPanel;
    private javax.swing.JToggleButton jActualizarStockButton;
    private javax.swing.JButton jAdicionarATMButton;
    private javax.swing.JPanel jAdicionarClientePanel;
    private javax.swing.JToggleButton jAdicionarClientesButton;
    private javax.swing.JToggleButton jAdicionarEmpregadoButton;
    private javax.swing.JPanel jAdicionarFilmePanel;
    private javax.swing.JToggleButton jAdicionarFilmesToggleButton;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JPanel jClientesManagerPanel;
    private javax.swing.JPanel jClientesManagerPanel1;
    private javax.swing.JToggleButton jDespedirEmpregadoButton;
    private javax.swing.JPanel jEliminarClientePanel;
    private javax.swing.JButton jEliminarClientesButton;
    private javax.swing.JToggleButton jEliminarFilmeButton;
    private javax.swing.JPanel jEliminarFilmePanel;
    private javax.swing.JPanel jEmpregadosManagerPanel;
    private javax.swing.JToggleButton jEscolherFicheiroButton;
    private javax.swing.JPanel jEstatisticasPanel;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JPanel jFilmesManagerPanel;
    private javax.swing.JPanel jFilmesManagerPanel1;
    private javax.swing.JButton jFormatosFrameButton;
    private javax.swing.JButton jFormatosFrameButton1;
    private javax.swing.JFormattedTextField jFormattedTextField4;
    private javax.swing.JToggleButton jGeneroButton;
    private javax.swing.JPanel jGenerosPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JList jList4;
    private javax.swing.JList jList5;
    private javax.swing.JList jList6;
    private javax.swing.JList jList7;
    private javax.swing.JButton jLoginButton;
    private javax.swing.JPanel jLoginPanel;
    private javax.swing.JPanel jMenuAdministradorPanel;
    private javax.swing.JPanel jMenuOperatorPanel;
    private javax.swing.JPanel jNotificarClientePanel;
    private javax.swing.JButton jNotificarClientesButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JPanel jPesqisaFilmesPanel;
    private javax.swing.JToggleButton jPesquisarButton;
    private javax.swing.JPanel jPesquisarClientePanel;
    private javax.swing.JToggleButton jPesquisarClientesButton;
    private javax.swing.JPanel jResultadosFilmePanel;
    private javax.swing.JButton jSairButton;
    private javax.swing.JButton jSairButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JSpinner jSpinner5;
    private javax.swing.JSpinner jSpinner6;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTextArea jTextArea11;
    private javax.swing.JTextArea jTextArea12;
    private javax.swing.JTextArea jTextArea14;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JToggleButton jToggleButton17;
    private javax.swing.JToggleButton jToggleButton18;
    private javax.swing.JToggleButton jToggleButton34;
    private javax.swing.JTextField jUsernameField;
    private javax.swing.JButton jVenderATMButton;
    private javax.swing.JButton jVerificarPagamentosAtrasoButton;
    private javax.swing.JButton jVerificarPagamentosAtrasoButton1;
    private javax.swing.JButton jVoltarACFButton;
    private javax.swing.JList listaEliminarClientes;
    private javax.swing.JList listaEmpregados;
    private javax.swing.JList listaFormato;
    private javax.swing.JComboBox listaFormatos;
    private javax.swing.JComboBox listaFormatosAdicionaFilme;
    private javax.swing.JComboBox listaFormatosResultadosFilmes;
    private javax.swing.JList listaGeneros;
    private javax.swing.JComboBox listaGenerosAdicionaFilmes;
    private javax.swing.JList listaMaquinas;
    private javax.swing.JButton listarFormatoEliminar;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextArea mensagem;
    private javax.swing.JTextField moradaAdicionaClientes;
    private javax.swing.JTextField moradaEmpregados;
    private javax.swing.JTextField moradaPesquisarClientes;
    private javax.swing.JTextField nomeAdicionaClientes;
    private javax.swing.JTextField nomeEmpregados;
    private javax.swing.JTextField nomePesquisarClientes;
    private javax.swing.JButton notificarClientes;
    private javax.swing.JFrame notificarClientesFrame;
    private javax.swing.JButton obterDadosAdicionarClientes;
    private javax.swing.JButton obterDadosEmpregadoActualizacao;
    private javax.swing.JRadioButton opRadio;
    private javax.swing.JTextArea outEliminaClientes;
    private javax.swing.JTextArea outEmpregados;
    private javax.swing.JTextArea outFormato;
    private javax.swing.JTextArea outGenero;
    private javax.swing.JTextArea outMaquinas;
    private javax.swing.JTextArea outPesquisarClientes;
    private javax.swing.JTextArea outputAdicionaClientes;
    private javax.swing.JList pagamentosAtraso;
    private javax.swing.JTextField paisResultadosFilme;
    private javax.swing.JPasswordField passwordAdicionaClientes;
    private javax.swing.JPasswordField passwordAdicionaClientes2;
    private javax.swing.JPasswordField passwordEmpregados;
    private javax.swing.JPasswordField passwordEmpregados2;
    private javax.swing.JFrame pesquisarClienteFrame;
    private javax.swing.JToggleButton pesquisarClientes;
    private javax.swing.JToggleButton pesquisarClientesButton;
    private javax.swing.JToggleButton pesquisarFilme;
    private javax.swing.JToggleButton pesquisarFilmes2;
    private javax.swing.JFrame pesquisarFilmesFrame;
    private javax.swing.JButton pesquisarPorBI;
    private javax.swing.JButton pesquisarPorID;
    private javax.swing.JTextField produtorResultadosFilme;
    private javax.swing.JTextField realizadorResultadosFilme;
    private javax.swing.JFrame resultadosFrame;
    private javax.swing.JFormattedTextField salarioEmpregados;
    private javax.swing.JFormattedTextField telefoneAdicionaClientes;
    private javax.swing.JFormattedTextField telefoneEmpregados;
    private javax.swing.JTextField telefonePesquisarClientes;
    private javax.swing.JTextArea textDescricaoAdicionaFilme;
    private javax.swing.JTextArea textEliminaFilmes;
    private javax.swing.JTextField textFormato;
    private javax.swing.JTextField textGenero;
    private javax.swing.JTextField textIdPesquisaFilmes;
    private javax.swing.JTextField textProdutorAdicionaFilme;
    private javax.swing.JTextField textProdutorPesquisaFilmes;
    private javax.swing.JTextField textRealizadorAdicionaFilme;
    private javax.swing.JTextField textRealizadorPesquisaFilmes;
    private javax.swing.JTextField textTituloAdicionaFilme;
    private javax.swing.JTextField textTituloPesquisaFilmes;
    private javax.swing.JTextField tituloResultadosFilme;
    private javax.swing.JButton verificarRequesicoes;
    private javax.swing.JButton verificarRequesicoes1;
    private javax.swing.JToggleButton voltarAdcionaFilmes;
    private javax.swing.JToggleButton voltarEliminaFilmes;
    private javax.swing.JButton voltarFormatos;
    private javax.swing.JButton voltarGeneros;
    private javax.swing.JToggleButton voltarPesquisarCliente;
    private javax.swing.JToggleButton voltarPesquisarFilmes;
    // End of variables declaration//GEN-END:variables

}
