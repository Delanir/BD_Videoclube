package gui_atm;

import bd.DBHandler;
import gestores.*;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import outros.OurListModel;
import outros.Utils;

/**
 *
 * @author Daniela
 */
public class Frame_ATM  extends JFrame{
    
    /**
    * @param args the command line arguments
    */
    private String idMaquina =""+(1+(int)(Math.random()*5));
    private DBHandler bd;
    private javax.swing.ButtonGroup bgroup;
    GestorUtilizadores gerir_users = new GestorUtilizadores();
    GestorFilmes gestorFilmes = new GestorFilmes();
    GestorClientes gestorClientes = new GestorClientes();

    public static void main(String args[]) {
        
                Utils.dbg("Here");
                new Frame_ATM().setVisible(true);
                //adds the panels to the interface
                
                Scanner sc = new Scanner(System.in);
                sc.next();
         
    }
    
    
    
    /** Creates new form Frame_ATM */
    public Frame_ATM() {

        try{
            bd=new DBHandler();
        }catch (Exception e){
            System.exit(-1);
        }


        //initializes all the componentes needed in the GUI
       
        setSize(800, 600);
	setTitle("ATM");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        initComponents();
        add(mainPanel);
        mainPanel.setLayout(null);
        mainPanel.setVisible(true);
        init();
        Utils.dbg("WHY");

    }

      public void init(){

        mainPanel.setLayout(null);
        mainPanel.add(jDadosPanel);
        mainPanel.add(jPaga);
        mainPanel.add(jEntregaPanel);
        mainPanel.add(jLoginPanel);
        mainPanel.add(jHistoricoPanel);
        mainPanel.add(jMenuPanel);
        mainPanel.add(jResultadosPanel);
        mainPanel.add(jPesquisarPanel);

        //Set panel's visibility
        jDadosPanel.setVisible(false);
        jPaga.setVisible(false);
        jEntregaPanel.setVisible(false);
        jLoginPanel.setVisible(true);
        jHistoricoPanel.setVisible(false);
        jMenuPanel.setVisible(false);
        jResultadosPanel.setVisible(false);
        jPesquisarPanel.setVisible(false);
        //Alignes the panels in the frame

        jDadosPanel.setBounds(0, -1, 800, 600);
        jPaga.setBounds(0, -1, 800, 600);
        jEntregaPanel.setBounds(0, -1, 800, 600);
        jLoginPanel.setBounds(0, -1, 800, 600);
        jHistoricoPanel.setBounds(0, -1, 800, 600);
        jMenuPanel.setBounds(0, -1, 800, 600);
        jResultadosPanel.setBounds(0, -1, 800, 600);
        jPesquisarPanel.setBounds(0, -1, 800, 600);

        menuResultados_listaFilmes.addListSelectionListener((ListSelectionListener) new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent evento) {
            if (evento.getValueIsAdjusting())
            //ainda selecionando
            return;
            JList list = (JList)evento.getSource();
            if (list.isSelectionEmpty()) {
                    Utils.dbg("nenhuma seleção");
            } else {
                String idMovie=((String)menuResultados_listaFilmes.getSelectedValue()).split(" ")[0];
                String[] f = gestorFilmes.getFilme(idMovie);
                DefaultListModel modeloDados = new DefaultListModel();
                int i=1,j=0;
                String file;
                menuResultados_titulo.setText(f[i++]);
                menuResultados_ano.setText(f[i++]);
                menuResultados_realizador.setText(f[i++]);
                menuResultados_imdb.setText(f[i++]);
                menuResultados_pais.setText(f[i++]);
                menuResultados_produtor.setText(f[i++]);
                menuResultados_descricao.setText(f[i++]);
                 try{
                    file=f[i++];
                    File ficheiro= new File(file);
                    if(ficheiro.exists())
                        menuResultados_imagem.setIcon(new ImageIcon(file));
                }catch (Exception e){
                    Utils.dbg("Não foi encontrada a capa do filme!");
                }
                menuResultados_generos.setModel(new OurListModel(Utils.extract(f, i+1)));
                String[] formato = gestorFilmes.verListaStocksFilme(idMovie);
                for(j=0;j<formato.length;j++){
                    modeloDados.addElement(formato[j]);
                    //System.out.println("cenassss222222 "+formato[j].split(" : ")[0]);
                }
                menuResultados_formatos.setModel(modeloDados);

            }
        }});

        menuEntregar_filme.addListSelectionListener((ListSelectionListener) new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent evento) {
                if (evento.getValueIsAdjusting())
                //ainda selecionando
                return;
                JList list = (JList)evento.getSource();
                if (list.isSelectionEmpty()) {
                        Utils.dbg("nenhuma seleção");
                } else {
                    String idReq=((String)menuEntregar_filme.getSelectedValue()).split(" ")[0];
                    valorapagar.setText(gestorFilmes.calcularPrecoRequisicao(idReq));
                }
            }
        });

        /*menuResultados_formatos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            System.out.println("EXPERIENCIA");
            }
        });*/


    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuPanel = new javax.swing.JPanel();
        jPesquisarButton = new javax.swing.JToggleButton();
        jEntregarButton = new javax.swing.JToggleButton();
        jHistoricoButton = new javax.swing.JToggleButton();
        jSairButton = new javax.swing.JButton();
        jDadosButton = new javax.swing.JToggleButton();
        jPesquisarPanel = new javax.swing.JPanel();
        jSairButton2 = new javax.swing.JButton();
        jVoltarButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        menuPesquisar_generos = new javax.swing.JComboBox();
        menuPesquisar_produtor = new javax.swing.JTextField();
        menuPesquisar_imdbLow = new javax.swing.JSpinner();
        menuPesquisar_imdbLow.setModel(new SpinnerNumberModel(1.0,1,10,0.1));
        menuPesquisar_realizador = new javax.swing.JTextField();
        menuPesquisar_titulo = new javax.swing.JTextField();
        menuPesquisar_imdbHigh = new javax.swing.JSpinner();
        menuPesquisar_imdbHigh.setModel(new SpinnerNumberModel(10.0,1,10,0.1));
        menuPesquisar_anoLow = new javax.swing.JSpinner();
        menuPesquisar_anoLow.setModel(new SpinnerNumberModel(1900,1900,2050,1));
        jSearchButton = new javax.swing.JToggleButton();
        menuPesquisar_anoHigh = new javax.swing.JSpinner();
        menuPesquisar_anoHigh.setModel(new SpinnerNumberModel(2011,1900,2050,1));
        menuPesquisar_pais = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPaga = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel41 = new javax.swing.JLabel();
        menuPaga_dataEntrega = new javax.swing.JFormattedTextField();
        menuPaga_preco = new javax.swing.JTextField();
        menuPaga_titulo = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jVoltarButton1 = new javax.swing.JButton();
        jSairButton1 = new javax.swing.JButton();
        jResultadosPanel = new javax.swing.JPanel();
        jSairButton3 = new javax.swing.JButton();
        jVoltarPesquisaButton = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        menuResultados_titulo = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        menuResultados_realizador = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        menuResultados_produtor = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menuResultados_listaFilmes = new javax.swing.JList();
        jLabel22 = new javax.swing.JLabel();
        menuResultados_ano = new javax.swing.JTextField();
        menuResultados_imdb = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        menuResultados_imagem = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        menuResultados_descricao = new javax.swing.JTextArea();
        jLabel23 = new javax.swing.JLabel();
        menuResultados_pais = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        menuResultados_generos = new javax.swing.JList();
        jScrollPane6 = new javax.swing.JScrollPane();
        menuResultados_formatos = new javax.swing.JList();
        jLabel36 = new javax.swing.JLabel();
        jHistoricoPanel = new javax.swing.JPanel();
        jSairButton4 = new javax.swing.JButton();
        jVoltarButton4 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jLabel48 = new javax.swing.JLabel();
        jLoginPanel = new javax.swing.JPanel();
        jLoginButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jUsernameField = new javax.swing.JTextField();
        jUsernameField.setText("Insert Username Here");
        jLabel5 = new javax.swing.JLabel();
        jEntregaPanel = new javax.swing.JPanel();
        jSairButton5 = new javax.swing.JButton();
        jMenuButton5 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        valorapagar = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        num_cartao = new javax.swing.JTextField();
        num_css = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jPagarButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        menuEntregar_filme = new javax.swing.JList();
        jDadosPanel = new javax.swing.JPanel();
        jSairButton6 = new javax.swing.JButton();
        jVoltarButton6 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        menuDados_nome = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        menuDados_morada = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        menuDados_mail = new javax.swing.JTextField();
        menuDados_BI = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        menuDados_tel = new javax.swing.JTextField();
        mainPanel = new javax.swing.JPanel();

        jPesquisarButton.setText("Pesquisar Filmes");
        jPesquisarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPesquisarButtonActionPerformed(evt);
            }
        });

        jEntregarButton.setText("Entregar Filme");
        jEntregarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEntregarButtonActionPerformed(evt);
            }
        });

        jHistoricoButton.setText("Ver Histórico");
        jHistoricoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHistoricoButtonActionPerformed(evt);
            }
        });

        jSairButton.setText("SAIR");
        jSairButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSairButtonActionPerformed(evt);
            }
        });

        jDadosButton.setText("Ver Dados Pessoais");
        jDadosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDadosButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jMenuPanelLayout = new javax.swing.GroupLayout(jMenuPanel);
        jMenuPanel.setLayout(jMenuPanelLayout);
        jMenuPanelLayout.setHorizontalGroup(
            jMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jMenuPanelLayout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addGroup(jMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jHistoricoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPesquisarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jEntregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDadosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(718, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jMenuPanelLayout.createSequentialGroup()
                .addContainerGap(632, Short.MAX_VALUE)
                .addComponent(jSairButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(554, 554, 554))
        );
        jMenuPanelLayout.setVerticalGroup(
            jMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jMenuPanelLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jPesquisarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jEntregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jHistoricoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jDadosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSairButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPesquisarPanel.setMaximumSize(new java.awt.Dimension(800, 600));
        jPesquisarPanel.setMinimumSize(new java.awt.Dimension(800, 600));

        jSairButton2.setText("SAIR");
        jSairButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSairButton2ActionPerformed(evt);
            }
        });

        jVoltarButton.setText("Voltar");
        jVoltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVoltarButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel3.setText("Pesquisar Filme");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel4.setText("Título:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel6.setText("Género:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel7.setText("Ano:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel8.setText("Realizador:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel9.setText("Produtor:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel11.setText("Entre");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel12.setText("e");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel10.setText("IMDB RATING: ");

        menuPesquisar_generos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jSearchButton.setText("PESQUISAR");
        jSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSearchButtonActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel29.setText("País:");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel31.setText("Entre");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel32.setText("e");

        javax.swing.GroupLayout jPesquisarPanelLayout = new javax.swing.GroupLayout(jPesquisarPanel);
        jPesquisarPanel.setLayout(jPesquisarPanelLayout);
        jPesquisarPanelLayout.setHorizontalGroup(
            jPesquisarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPesquisarPanelLayout.createSequentialGroup()
                .addGroup(jPesquisarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPesquisarPanelLayout.createSequentialGroup()
                        .addGap(318, 318, 318)
                        .addComponent(jLabel3))
                    .addGroup(jPesquisarPanelLayout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addGroup(jPesquisarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPesquisarPanelLayout.createSequentialGroup()
                                .addGroup(jPesquisarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPesquisarPanelLayout.createSequentialGroup()
                                        .addGroup(jPesquisarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel29))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPesquisarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(menuPesquisar_pais, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                                            .addComponent(menuPesquisar_realizador, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPesquisarPanelLayout.createSequentialGroup()
                                        .addGroup(jPesquisarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPesquisarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(menuPesquisar_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                                            .addComponent(menuPesquisar_produtor, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE))))
                                .addGap(33, 33, 33)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(menuPesquisar_generos, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPesquisarPanelLayout.createSequentialGroup()
                                .addComponent(jSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                                .addComponent(jVoltarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jSairButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73))
                            .addGroup(jPesquisarPanelLayout.createSequentialGroup()
                                .addGroup(jPesquisarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPesquisarPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel31))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPesquisarPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel11)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPesquisarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(menuPesquisar_imdbLow, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(menuPesquisar_anoLow, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addGroup(jPesquisarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel32)
                                    .addComponent(jLabel12))
                                .addGap(40, 40, 40)
                                .addGroup(jPesquisarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(menuPesquisar_imdbHigh, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(menuPesquisar_anoHigh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(296, 296, 296)))))
                .addContainerGap())
        );
        jPesquisarPanelLayout.setVerticalGroup(
            jPesquisarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPesquisarPanelLayout.createSequentialGroup()
                .addGroup(jPesquisarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPesquisarPanelLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(jPesquisarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(menuPesquisar_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(menuPesquisar_generos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPesquisarPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3)))
                .addGroup(jPesquisarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(menuPesquisar_produtor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPesquisarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(menuPesquisar_realizador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPesquisarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menuPesquisar_pais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(jPesquisarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPesquisarPanelLayout.createSequentialGroup()
                        .addGroup(jPesquisarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel31)
                            .addComponent(menuPesquisar_anoLow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPesquisarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(menuPesquisar_imdbLow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(61, 61, 61)
                        .addGroup(jPesquisarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSairButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jVoltarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPesquisarPanelLayout.createSequentialGroup()
                        .addGroup(jPesquisarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(menuPesquisar_anoHigh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPesquisarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(menuPesquisar_imdbHigh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(47, 47, 47))
        );

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel38.setText("Título:");

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel39.setText("Preço:");

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel40.setText("Data Limite de Entrega:");

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel41.setText("Videoclube Lumière. O melhor do cinema perto de si!");

        menuPaga_dataEntrega.setEditable(false);
        menuPaga_dataEntrega.setText("jFormattedTextField1");

        menuPaga_preco.setEditable(false);
        menuPaga_preco.setText("jTextField20");

        menuPaga_titulo.setEditable(false);
        menuPaga_titulo.setText("jTextField21");

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel49.setText("Entrega realizada com sucesso!");

        jVoltarButton1.setText("Voltar");
        jVoltarButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVoltarButton1ActionPerformed(evt);
            }
        });

        jSairButton1.setText("SAIR");
        jSairButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSairButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPagaLayout = new javax.swing.GroupLayout(jPaga);
        jPaga.setLayout(jPagaLayout);
        jPagaLayout.setHorizontalGroup(
            jPagaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPagaLayout.createSequentialGroup()
                .addGroup(jPagaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPagaLayout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addGroup(jPagaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel49)
                            .addGroup(jPagaLayout.createSequentialGroup()
                                .addGroup(jPagaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel40)
                                    .addComponent(jLabel39)
                                    .addComponent(jLabel38))
                                .addGap(18, 18, 18)
                                .addGroup(jPagaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(menuPaga_dataEntrega)
                                    .addComponent(menuPaga_preco)
                                    .addComponent(menuPaga_titulo)))
                            .addComponent(jLabel41)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPagaLayout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jVoltarButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSairButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPagaLayout.setVerticalGroup(
            jPagaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPagaLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel41)
                .addGap(27, 27, 27)
                .addGroup(jPagaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel38)
                    .addComponent(menuPaga_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPagaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(menuPaga_preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPagaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(menuPaga_dataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPagaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jVoltarButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSairButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jSairButton3.setText("SAIR");
        jSairButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSairButton3ActionPerformed(evt);
            }
        });

        jVoltarPesquisaButton.setText("Voltar");
        jVoltarPesquisaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVoltarPesquisaButtonActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel13.setText("Resultados Filme");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel14.setText("Título:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel15.setText("Género:");

        menuResultados_titulo.setEditable(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel16.setText("Ano:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel17.setText("Realizador:");

        menuResultados_realizador.setEditable(false);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel18.setText("Produtor:");

        menuResultados_produtor.setEditable(false);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel19.setText("IMDB RATING: ");

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        menuResultados_listaFilmes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(menuResultados_listaFilmes);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Resultados (seleccione o que pretender alugar):");

        menuResultados_ano.setEditable(false);

        menuResultados_imdb.setEditable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setForeground(new java.awt.Color(255, 153, 153));

        menuResultados_imagem.setText("CAPA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(menuResultados_imagem)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(menuResultados_imagem)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel21.setText("Descrição:");

        menuResultados_descricao.setColumns(20);
        menuResultados_descricao.setRows(5);
        jScrollPane2.setViewportView(menuResultados_descricao);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel23.setText("País:");

        menuResultados_pais.setEditable(false);

        jButton10.setText("ALUGAR");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jScrollPane4.setViewportView(menuResultados_generos);

        jScrollPane6.setViewportView(menuResultados_formatos);

        jLabel36.setText("Escolha o formato do filme pretendido:");

        javax.swing.GroupLayout jResultadosPanelLayout = new javax.swing.GroupLayout(jResultadosPanel);
        jResultadosPanel.setLayout(jResultadosPanelLayout);
        jResultadosPanelLayout.setHorizontalGroup(
            jResultadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jResultadosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jResultadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jResultadosPanelLayout.createSequentialGroup()
                        .addGroup(jResultadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jResultadosPanelLayout.createSequentialGroup()
                                .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
                                .addGap(130, 130, 130))
                            .addGroup(jResultadosPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jResultadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(jResultadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jResultadosPanelLayout.createSequentialGroup()
                                        .addComponent(jVoltarPesquisaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSairButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(15, 15, 15))
                    .addGroup(jResultadosPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jResultadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel14)
                            .addComponent(jLabel21)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addGroup(jResultadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jResultadosPanelLayout.createSequentialGroup()
                                .addGroup(jResultadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(menuResultados_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                    .addComponent(menuResultados_pais)
                                    .addComponent(menuResultados_realizador))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jResultadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel19))
                                .addGap(18, 18, 18)
                                .addGroup(jResultadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(menuResultados_ano, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                    .addComponent(menuResultados_produtor)
                                    .addComponent(menuResultados_imdb))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(396, 396, 396)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
            .addGroup(jResultadosPanelLayout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addGroup(jResultadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addGroup(jResultadosPanelLayout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel13))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(734, Short.MAX_VALUE))
        );
        jResultadosPanelLayout.setVerticalGroup(
            jResultadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jResultadosPanelLayout.createSequentialGroup()
                .addGroup(jResultadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jResultadosPanelLayout.createSequentialGroup()
                        .addGap(484, 484, 484)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jResultadosPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jResultadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jResultadosPanelLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jResultadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jResultadosPanelLayout.createSequentialGroup()
                                        .addGroup(jResultadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(menuResultados_ano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel15))
                                        .addGap(18, 18, 18)
                                        .addComponent(menuResultados_produtor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(menuResultados_imdb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jResultadosPanelLayout.createSequentialGroup()
                                        .addGroup(jResultadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(menuResultados_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel16)
                                            .addComponent(jLabel14))
                                        .addGap(18, 18, 18)
                                        .addGroup(jResultadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel18)
                                            .addComponent(jLabel23)
                                            .addComponent(menuResultados_pais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jResultadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel17)
                                            .addComponent(menuResultados_realizador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel19)))
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jResultadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jResultadosPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jResultadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jResultadosPanelLayout.createSequentialGroup()
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jResultadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jVoltarPesquisaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSairButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jResultadosPanelLayout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane6, 0, 0, Short.MAX_VALUE)))
                        .addGap(71, 71, 71)))
                .addContainerGap(60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jSairButton4.setText("SAIR");
        jSairButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSairButton4ActionPerformed(evt);
            }
        });

        jVoltarButton4.setText("Voltar");
        jVoltarButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVoltarButton4ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel24.setText("Histórico");

        jList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList2);

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel48.setText("Filmes anteriormente Requisitados:");

        javax.swing.GroupLayout jHistoricoPanelLayout = new javax.swing.GroupLayout(jHistoricoPanel);
        jHistoricoPanel.setLayout(jHistoricoPanelLayout);
        jHistoricoPanelLayout.setHorizontalGroup(
            jHistoricoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jHistoricoPanelLayout.createSequentialGroup()
                .addGroup(jHistoricoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jHistoricoPanelLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jHistoricoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jHistoricoPanelLayout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jVoltarButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jSairButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jHistoricoPanelLayout.setVerticalGroup(
            jHistoricoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jHistoricoPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel24)
                .addGap(34, 34, 34)
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addGroup(jHistoricoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jVoltarButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSairButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jLoginPanel.setMaximumSize(new java.awt.Dimension(800, 600));
        jLoginPanel.setMinimumSize(new java.awt.Dimension(800, 600));
        jLoginPanel.setPreferredSize(new java.awt.Dimension(800, 600));

        jLoginButton.setText("Login");
        jLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLoginButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel1.setText("Username:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel2.setText("Password:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel5.setText("Videoclube Lumière");

        javax.swing.GroupLayout jLoginPanelLayout = new javax.swing.GroupLayout(jLoginPanel);
        jLoginPanel.setLayout(jLoginPanelLayout);
        jLoginPanelLayout.setHorizontalGroup(
            jLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLoginPanelLayout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addGroup(jLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLoginPanelLayout.createSequentialGroup()
                        .addGroup(jLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addGroup(jLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPasswordField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jUsernameField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jLoginPanelLayout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(173, 173, 173))
        );
        jLoginPanelLayout.setVerticalGroup(
            jLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLoginPanelLayout.createSequentialGroup()
                .addGap(110, 110, 110)
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
                .addContainerGap(205, Short.MAX_VALUE))
        );

        jSairButton5.setText("SAIR");
        jSairButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSairButton5ActionPerformed(evt);
            }
        });

        jMenuButton5.setText("Voltar");
        jMenuButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuButton5ActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel33.setText("Entregar Filme");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("Filme a Entregar:");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText("1. Escolha o filme a entregar.");

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel42.setText("2. Método de Pagamento:");

        jRadioButton3.setFont(new java.awt.Font("Tahoma", 0, 12));
        jRadioButton3.setText("Dinheiro");

        jRadioButton4.setFont(new java.awt.Font("Tahoma", 0, 12));
        jRadioButton4.setText("Multibanco");

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel43.setText("3. Introduza o dinheiro na máquina (dá troco)");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        valorapagar.setEditable(false);
        valorapagar.setText("jTextField11");

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel44.setText("Valor a Pagar:");

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel45.setText("3. Introduzir Nº");

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel46.setText("CSS:");

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel47.setText("Nº Cartão:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46)
                            .addComponent(jLabel47))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(num_css)
                            .addComponent(num_cartao, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel45)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(num_cartao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(num_css, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPagarButton.setText("Pagar");
        jPagarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPagarButtonActionPerformed(evt);
            }
        });

        menuEntregar_filme.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(menuEntregar_filme);

        javax.swing.GroupLayout jEntregaPanelLayout = new javax.swing.GroupLayout(jEntregaPanel);
        jEntregaPanel.setLayout(jEntregaPanelLayout);
        jEntregaPanelLayout.setHorizontalGroup(
            jEntregaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jEntregaPanelLayout.createSequentialGroup()
                .addGroup(jEntregaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jEntregaPanelLayout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jLabel33))
                    .addGroup(jEntregaPanelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jEntregaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jEntregaPanelLayout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(jPagarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addComponent(jMenuButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(jSairButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jEntregaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jEntregaPanelLayout.createSequentialGroup()
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(40, 40, 40)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jEntregaPanelLayout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addGroup(jEntregaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jEntregaPanelLayout.createSequentialGroup()
                                            .addGroup(jEntregaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jRadioButton3)
                                                .addComponent(jRadioButton4))
                                            .addGap(21, 21, 21))
                                        .addGroup(jEntregaPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel42)
                                            .addGap(16, 16, 16))
                                        .addComponent(jLabel35))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jEntregaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jEntregaPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel34)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                                            .addComponent(jLabel44)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(valorapagar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)))))))
                .addGap(189, 189, 189))
        );
        jEntregaPanelLayout.setVerticalGroup(
            jEntregaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jEntregaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33)
                .addGap(43, 43, 43)
                .addGroup(jEntregaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jEntregaPanelLayout.createSequentialGroup()
                        .addGroup(jEntregaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(valorapagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44)
                            .addComponent(jLabel34))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(jEntregaPanelLayout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton4)
                        .addGap(31, 31, 31)))
                .addGroup(jEntregaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jEntregaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPagarButton, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(jSairButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMenuButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );

        jSairButton6.setText("SAIR");
        jSairButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSairButton6ActionPerformed(evt);
            }
        });

        jVoltarButton6.setText("Voltar");
        jVoltarButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVoltarButton6ActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel25.setText("Dados Pessoais");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel26.setText("Nome:");

        menuDados_nome.setEditable(false);
        menuDados_nome.setText("jTextField11");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel27.setText("Morada:");

        menuDados_morada.setEditable(false);
        menuDados_morada.setText("jTextField12");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel28.setText("E-mail:");

        menuDados_mail.setEditable(false);
        menuDados_mail.setText("jTextField13");

        menuDados_BI.setEditable(false);
        menuDados_BI.setText("jTextField1");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel20.setText("BI:");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel30.setText("Telefone:");

        menuDados_tel.setEditable(false);
        menuDados_tel.setText("jTextField2");

        javax.swing.GroupLayout jDadosPanelLayout = new javax.swing.GroupLayout(jDadosPanel);
        jDadosPanel.setLayout(jDadosPanelLayout);
        jDadosPanelLayout.setHorizontalGroup(
            jDadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDadosPanelLayout.createSequentialGroup()
                .addContainerGap(355, Short.MAX_VALUE)
                .addComponent(jVoltarButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jSairButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
            .addGroup(jDadosPanelLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(jLabel25)
                .addContainerGap(335, Short.MAX_VALUE))
            .addGroup(jDadosPanelLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(jDadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel30)
                    .addGroup(jDadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jDadosPanelLayout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(jLabel26))
                        .addGroup(jDadosPanelLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(jDadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel28)
                                .addComponent(jLabel27))))
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(menuDados_tel)
                    .addComponent(menuDados_BI)
                    .addComponent(menuDados_morada, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(menuDados_mail)
                    .addComponent(menuDados_nome))
                .addGap(276, 276, 276))
        );
        jDadosPanelLayout.setVerticalGroup(
            jDadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDadosPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel25)
                .addGap(55, 55, 55)
                .addGroup(jDadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menuDados_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addGroup(jDadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menuDados_morada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(18, 18, 18)
                .addGroup(jDadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(menuDados_mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menuDados_BI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(jDadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(menuDados_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jDadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jVoltarButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSairButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));

        mainPanel.setBackground(new java.awt.Color(255, 204, 204));
        mainPanel.setMaximumSize(new java.awt.Dimension(800, 600));
        mainPanel.setMinimumSize(new java.awt.Dimension(800, 600));
        mainPanel.setPreferredSize(new java.awt.Dimension(800, 600));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
     * Botões _______________Botões___________________Botões__________Botões
     *
     */
    private void jPesquisarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPesquisarButtonActionPerformed
        //Set panel's visibility acordingly
        String [] generos = gestorFilmes.verListaGeneros();
        int i;
        DefaultComboBoxModel modeloDados = new DefaultComboBoxModel();
        for(i=0;i<generos.length;i++){
            modeloDados.addElement(generos[i]);
        }
        menuPesquisar_generos.setModel(modeloDados);
        menuPesquisar_generos.setSelectedIndex(-1);
        jDadosPanel.setVisible(false);
        jPaga.setVisible(false);
        jEntregaPanel.setVisible(false);
        jLoginPanel.setVisible(false);
        jHistoricoPanel.setVisible(false);
        jMenuPanel.setVisible(false);
        jResultadosPanel.setVisible(false);
        jPesquisarPanel.setVisible(true);
    }//GEN-LAST:event_jPesquisarButtonActionPerformed

    private void jEntregarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEntregarButtonActionPerformed
        //Set panel's visibility acordingly
        String [] requisicoes = gestorFilmes.verListaRequisicoesPorEntregarClienteBI(gerir_users.getUsername());
        int i;
        DefaultListModel modeloDados = new DefaultListModel();
        for(i=0;i<requisicoes.length;i++){
            modeloDados.addElement(requisicoes[i]);
        }
        menuEntregar_filme.setModel(modeloDados);
        bgroup=new ButtonGroup();
        bgroup.add(jRadioButton3);
        bgroup.add(jRadioButton4);

        valorapagar.setText("");
        menuEntregar_filme.setSelectedIndex(-1);
        jDadosPanel.setVisible(false);
        jPaga.setVisible(false);
        jEntregaPanel.setVisible(true);
        jLoginPanel.setVisible(false);
        jHistoricoPanel.setVisible(false);
        jMenuPanel.setVisible(false);
        jResultadosPanel.setVisible(false);
        jPesquisarPanel.setVisible(false);
    }//GEN-LAST:event_jEntregarButtonActionPerformed

    private void jHistoricoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHistoricoButtonActionPerformed
        //Set panel's visibility acordingly
        String[] historico = gestorFilmes.verListaRequisicoesClienteBI(gerir_users.getUsername());
        DefaultListModel modeloDados = new DefaultListModel();
        int i;

        for(i=0;i<historico.length;i++){
            modeloDados.addElement(historico[i]);
        }
        jList2.setModel(modeloDados);
        jDadosPanel.setVisible(false);
        jPaga.setVisible(false);
        jEntregaPanel.setVisible(false);
        jLoginPanel.setVisible(false);
        jHistoricoPanel.setVisible(true);
        jMenuPanel.setVisible(false);
        jResultadosPanel.setVisible(false);
        jPesquisarPanel.setVisible(false);
    }//GEN-LAST:event_jHistoricoButtonActionPerformed

    private void jDadosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDadosButtonActionPerformed
        //Set panel's visibility acordingly
        
        jDadosPanel.setVisible(true);
        jPaga.setVisible(false);
        jEntregaPanel.setVisible(false);
        jLoginPanel.setVisible(false);
        jHistoricoPanel.setVisible(false);
        jMenuPanel.setVisible(false);
        jResultadosPanel.setVisible(false);
        jPesquisarPanel.setVisible(false);
    }//GEN-LAST:event_jDadosButtonActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        // Botão Alugar na frame esultados de pesquisa, pega no ID e formato do video.
        Component frame = new Component() {};
        String verifica_aluguer=null;
        try{
            Utils.dbg("idMaquina: "+idMaquina+"ola "+menuResultados_listaFilmes.getSelectedValue().toString().split(" :")[0]+" formato "+menuResultados_formatos.getSelectedValue().toString().split(" :")[0]);
            verifica_aluguer=gestorFilmes.adicionaRequisicao(idMaquina,null,gerir_users.getUsername()
                    ,menuResultados_listaFilmes.getSelectedValue().toString().split(" :")[0]
                    , menuResultados_formatos.getSelectedValue().toString().split(" :")[0]);
            
            if(verifica_aluguer==null){
                JOptionPane.showMessageDialog(frame,
                    "Aluguer sem sucesso",
                    "Aviso!",
                    JOptionPane.WARNING_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(frame,
                    "Aluguer com sucesso",
                    "Obrigado!",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(NullPointerException e){
            JOptionPane.showMessageDialog(frame,
                    "Tem de seleccionar um filme e o seu formato",
                    "Aviso!",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton10ActionPerformed


    private void jSairButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSairButton3ActionPerformed
        // TODO: Invalidar a sessão
        //Set panel's visibility acordingly
        jDadosPanel.setVisible(false);
        jPaga.setVisible(false);
        jEntregaPanel.setVisible(false);
        jLoginPanel.setVisible(true);
        jHistoricoPanel.setVisible(false);
        jMenuPanel.setVisible(false);
        jResultadosPanel.setVisible(false);
        jPesquisarPanel.setVisible(false);
    }//GEN-LAST:event_jSairButton3ActionPerformed

    private void jSairButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSairButton6ActionPerformed
        // TODO: Invalidar a sessão
        //Set panel's visibility
        jDadosPanel.setVisible(false);
        jPaga.setVisible(false);
        jEntregaPanel.setVisible(false);
        jLoginPanel.setVisible(true);
        jHistoricoPanel.setVisible(false);
        jMenuPanel.setVisible(false);
        jResultadosPanel.setVisible(false);
        jPesquisarPanel.setVisible(false);
    }//GEN-LAST:event_jSairButton6ActionPerformed

    private void jSairButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSairButton5ActionPerformed
        // TODO: Invalidar a sessão
        //Set panel's visibility
        jDadosPanel.setVisible(false);
        jPaga.setVisible(false);
        jEntregaPanel.setVisible(false);
        jLoginPanel.setVisible(true);
        jHistoricoPanel.setVisible(false);
        jMenuPanel.setVisible(false);
        jResultadosPanel.setVisible(false);
        jPesquisarPanel.setVisible(false);
    }//GEN-LAST:event_jSairButton5ActionPerformed

    private void jSairButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSairButton4ActionPerformed
        // TODO: Invalidar a sessão
        //Set panel's visibility
        jDadosPanel.setVisible(false);
        jPaga.setVisible(false);
        jEntregaPanel.setVisible(false);
        jLoginPanel.setVisible(true);
        jHistoricoPanel.setVisible(false);
        jMenuPanel.setVisible(false);
        jResultadosPanel.setVisible(false);
        jPesquisarPanel.setVisible(false);
    }//GEN-LAST:event_jSairButton4ActionPerformed

    private void jSairButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSairButton2ActionPerformed
        // TODO: Invalidar a sessão
        //Set panel's visibility
        jDadosPanel.setVisible(false);
        jPaga.setVisible(false);
        jEntregaPanel.setVisible(false);
        jLoginPanel.setVisible(true);
        jHistoricoPanel.setVisible(false);
        jMenuPanel.setVisible(false);
        jResultadosPanel.setVisible(false);
        jPesquisarPanel.setVisible(false);
    }//GEN-LAST:event_jSairButton2ActionPerformed

    private void jSairButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSairButtonActionPerformed
        // TODO: Invalidar a sessão
        //Set panel's visibility
        jDadosPanel.setVisible(false);
        jPaga.setVisible(false);
        jEntregaPanel.setVisible(false);
        jLoginPanel.setVisible(true);
        jHistoricoPanel.setVisible(false);
        jMenuPanel.setVisible(false);
        jResultadosPanel.setVisible(false);
        jPesquisarPanel.setVisible(false);
    }//GEN-LAST:event_jSairButtonActionPerformed

    private void jVoltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVoltarButtonActionPerformed
        //Set panel's visibility
        menuPesquisar_titulo.setText("");
        menuPesquisar_anoLow.setValue(1900);
        menuPesquisar_anoHigh.setValue(2011);
        menuPesquisar_realizador.setText("");
        menuPesquisar_imdbLow.setValue(1);
        menuPesquisar_imdbHigh.setValue(10);
        menuPesquisar_pais.setText("");
        menuPesquisar_produtor.setText("");
        menuPesquisar_generos.setSelectedIndex(-1);
        jDadosPanel.setVisible(false);
        jPaga.setVisible(false);
        jEntregaPanel.setVisible(false);
        jLoginPanel.setVisible(false);
        jHistoricoPanel.setVisible(false);
        jMenuPanel.setVisible(true);
        jResultadosPanel.setVisible(false);
        jPesquisarPanel.setVisible(false);
    }//GEN-LAST:event_jVoltarButtonActionPerformed

    private void jSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSearchButtonActionPerformed
        // TODO: reunir dados para fazer a mega query e fazê-la . reset variáveis de pesquisa?
        //o k ta comentado e pra nao dar merda
        //so esta a ir buscar um genero
        String [] generos={""};
        String [] filmesPesquisados;
        String maiorAno, menorAno,  maiorImdb, menorImdb;
        if(Integer.parseInt(menuPesquisar_anoHigh.getValue().toString())>Integer.parseInt(menuPesquisar_anoLow.getValue().toString())){
            maiorAno=menuPesquisar_anoHigh.getValue().toString();
            menorAno=menuPesquisar_anoLow.getValue().toString();
        }
        else{
            menorAno=menuPesquisar_anoHigh.getValue().toString();
            maiorAno=menuPesquisar_anoLow.getValue().toString();
        }
        if(Double.parseDouble(menuPesquisar_imdbHigh.getValue().toString())>Double.parseDouble(menuPesquisar_imdbLow.getValue().toString())){
            maiorImdb=menuPesquisar_imdbHigh.getValue().toString();
            menorImdb=menuPesquisar_imdbLow.getValue().toString();
        }
        else{
            menorImdb=menuPesquisar_imdbHigh.getValue().toString();
            maiorImdb=menuPesquisar_imdbLow.getValue().toString();
        }
        if(menuPesquisar_generos.getSelectedItem()!=null){
            generos[0]=menuPesquisar_generos.getSelectedItem().toString();
            filmesPesquisados = gestorFilmes.procuraFilmes(menuPesquisar_titulo.getText(), menorAno
                    , maiorAno, menuPesquisar_realizador.getText(), menorImdb, maiorImdb
                    , menuPesquisar_pais.getText(), menuPesquisar_produtor.getText(), generos);
        }else{
            filmesPesquisados = gestorFilmes.procuraFilmes(menuPesquisar_titulo.getText(), menorAno
                    , maiorAno, menuPesquisar_realizador.getText(), menorImdb, maiorImdb
                    , menuPesquisar_pais.getText(), menuPesquisar_produtor.getText(), null);
        }
        DefaultListModel modeloDados = new DefaultListModel();
        int i;
        for(i=0;i<filmesPesquisados.length;i++){
            modeloDados.addElement(filmesPesquisados[i]);
        }
        menuResultados_listaFilmes.setModel(modeloDados);
        menuResultados_formatos.setSelectedIndex(-1);
        jDadosPanel.setVisible(false);
        jPaga.setVisible(false);
        jEntregaPanel.setVisible(false);
        jLoginPanel.setVisible(false);
        jHistoricoPanel.setVisible(false);
        jMenuPanel.setVisible(false);
        jResultadosPanel.setVisible(true);
        jPesquisarPanel.setVisible(false);
    }//GEN-LAST:event_jSearchButtonActionPerformed

    private void jVoltarPesquisaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVoltarPesquisaButtonActionPerformed
        // TODO : reset variaveis de presquisa!
        //Set panel's visibility
        DefaultListModel modeloDados = new DefaultListModel();
        menuResultados_titulo.setText("");
        menuResultados_produtor.setText("");
        menuResultados_realizador.setText("");
        menuResultados_ano.setText("");
        menuResultados_pais.setText("");
        menuResultados_imdb.setText("");
        
        menuResultados_descricao.setText("");
        menuResultados_formatos.setModel(modeloDados);
        menuResultados_generos.setModel(modeloDados);
        menuPesquisar_titulo.setText("");
        menuPesquisar_anoLow.setValue(1900);
        menuPesquisar_anoHigh.setValue(2011);
        menuPesquisar_realizador.setText("");
        menuPesquisar_imdbLow.setValue(1);
        menuPesquisar_imdbHigh.setValue(10);
        menuPesquisar_pais.setText("");
        menuPesquisar_produtor.setText("");
        menuPesquisar_generos.setSelectedIndex(-1);
        jDadosPanel.setVisible(false);
        jPaga.setVisible(false);
        jEntregaPanel.setVisible(false);
        jLoginPanel.setVisible(false);
        jHistoricoPanel.setVisible(false);
        jMenuPanel.setVisible(false);
        jResultadosPanel.setVisible(false);
        jPesquisarPanel.setVisible(true);
    }//GEN-LAST:event_jVoltarPesquisaButtonActionPerformed

    private void jVoltarButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVoltarButton4ActionPerformed
        //Set panel's visibility
        jDadosPanel.setVisible(false);
        jPaga.setVisible(false);
        jEntregaPanel.setVisible(false);
        jLoginPanel.setVisible(false);
        jHistoricoPanel.setVisible(false);
        jMenuPanel.setVisible(true);
        jResultadosPanel.setVisible(false);
        jPesquisarPanel.setVisible(false);
    }//GEN-LAST:event_jVoltarButton4ActionPerformed

    private void jMenuButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuButton5ActionPerformed
        //Set panel's visibility
        bgroup.clearSelection();
        num_cartao.setText("");
        num_css.setText("");
        jDadosPanel.setVisible(false);
        jPaga.setVisible(false);
        jEntregaPanel.setVisible(false);
        jLoginPanel.setVisible(false);
        jHistoricoPanel.setVisible(false);
        jMenuPanel.setVisible(true);
        jResultadosPanel.setVisible(false);
        jPesquisarPanel.setVisible(false);
    }//GEN-LAST:event_jMenuButton5ActionPerformed

    private void jPagarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPagarButtonActionPerformed
        // TODO: Processar o pedido
        //Set panel's visibility
        String modo_pagamento = "null";
        String numero_cartao=num_cartao.getText();
        String numero_css=num_css.getText();
        int prosseguir=0;
        Component frame = new Component(){};
        try{
            if(jRadioButton3.isSelected()){
                modo_pagamento="dinheiro";
                prosseguir=1;
            }else if(jRadioButton4.isSelected()){
                modo_pagamento="multibanco";
                if(!numero_cartao.equals("") && !numero_css.equals("") && numero_css.length()>2){
                    prosseguir=1;
                }
            }
            if(prosseguir==1 && !modo_pagamento.equals("null") && !menuEntregar_filme.isSelectionEmpty()){
                modo_pagamento="null";
                prosseguir=0;
                //gerir_users.pagarAluguer(numero_cartao,numero_css,idMovie);
                jDadosPanel.setVisible(false);
                jPaga.setVisible(true);
                jEntregaPanel.setVisible(false);
                jLoginPanel.setVisible(false);
                jHistoricoPanel.setVisible(false);
                jMenuPanel.setVisible(false);
                jResultadosPanel.setVisible(false);
                jPesquisarPanel.setVisible(false);
                String res = ((String)menuEntregar_filme.getSelectedValue()).split(" : ", 3)[2];
		res = res.substring(res.indexOf(") ")+2);
		res = res.substring(0, res.lastIndexOf(" ["));
                menuPaga_titulo.setText(res);
                menuPaga_preco.setText(valorapagar.getText());
                menuPaga_dataEntrega.setText(((String)menuEntregar_filme.getSelectedValue()).split(" ")[5]);
                gestorFilmes.entregaRequisicao(((String)menuEntregar_filme.getSelectedValue()).split(" ")[0]);
                jProgressBar1.setMinimum(0);
                jProgressBar1.setMaximum(100);

                for(int i = 0; i<=100;i++){
                    int newValue = i;
                    /*try{
                      Thread.currentThread().sleep(10);
                    }
                    catch(Exception e){
                    }*/
                    jProgressBar1.setValue(newValue);
                    jProgressBar1.setStringPainted(true);

                }
            }else{
                JOptionPane.showMessageDialog(frame,
                "Tem de seleccionar um filme e escolher o método de pagamento",
                "Aviso!",
                JOptionPane.WARNING_MESSAGE);
            }

        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(frame,
                "Tem de seleccionar um filme e escolher o método de pagamento",
                "Aviso!",
                JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_jPagarButtonActionPerformed

    private void jVoltarButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVoltarButton6ActionPerformed
        //Set panel's visibility
        jDadosPanel.setVisible(false);
        jPaga.setVisible(false);
        jEntregaPanel.setVisible(false);
        jLoginPanel.setVisible(false);
        jHistoricoPanel.setVisible(false);
        jMenuPanel.setVisible(true);
        jResultadosPanel.setVisible(false);
        jPesquisarPanel.setVisible(false);
    }//GEN-LAST:event_jVoltarButton6ActionPerformed

    private void jLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLoginButtonActionPerformed
        // TODO logar o user!!!
        Utils.dbg("user: "+jUsernameField.getText()+" pass:"+jPasswordField.getText());
        String verificar_login = gerir_users.loginCliente(jUsernameField.getText(),jPasswordField.getText());
        Utils.dbg("resposta: "+verificar_login);
        Component frame = new Component() {};
        if(verificar_login==null){
            JOptionPane.showMessageDialog(frame,
            "Dados de login incorrectos",
            "Aviso!",
            JOptionPane.WARNING_MESSAGE);

        }else{
            
            jDadosPanel.setVisible(false);
            jPaga.setVisible(false);
            jEntregaPanel.setVisible(false);
            jLoginPanel.setVisible(false);
            jHistoricoPanel.setVisible(false);
            jMenuPanel.setVisible(true);
            jResultadosPanel.setVisible(false);
            jPesquisarPanel.setVisible(false);

            String[] dados = gestorClientes.procuraClienteBI(gerir_users.getUsername());
            menuDados_nome.setText(dados[1]);
            menuDados_BI.setText(dados[2]);
            menuDados_morada.setText(dados[4]);
            menuDados_mail.setText(dados[5]);
            menuDados_tel.setText(dados[6]);

            jUsernameField.setText("");
            jPasswordField.setText("");
        }
    }//GEN-LAST:event_jLoginButtonActionPerformed

    private void jVoltarButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVoltarButton1ActionPerformed
        // TODO add your handling code here:
        String [] requisicoes = gestorFilmes.verListaRequisicoesPorEntregarClienteBI(gerir_users.getUsername());
        int i;
        DefaultListModel modeloDados = new DefaultListModel();
        for(i=0;i<requisicoes.length;i++){
            modeloDados.addElement(requisicoes[i]);
        }
        menuEntregar_filme.setModel(modeloDados);
        bgroup.clearSelection();
        num_cartao.setText("");
        valorapagar.setText("");
        num_css.setText("");
        jDadosPanel.setVisible(false);
        jPaga.setVisible(false);
        jEntregaPanel.setVisible(true);
        jLoginPanel.setVisible(false);
        jHistoricoPanel.setVisible(false);
        jMenuPanel.setVisible(false);
        jResultadosPanel.setVisible(false);
        jPesquisarPanel.setVisible(false);
    }//GEN-LAST:event_jVoltarButton1ActionPerformed

    private void jSairButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSairButton1ActionPerformed
        // TODO: Invalidar a sessão
        //Set panel's visibility
        jDadosPanel.setVisible(false);
        jPaga.setVisible(false);
        jEntregaPanel.setVisible(false);
        jLoginPanel.setVisible(true);
        jHistoricoPanel.setVisible(false);
        jMenuPanel.setVisible(false);
        jResultadosPanel.setVisible(false);
        jPesquisarPanel.setVisible(false);
    }//GEN-LAST:event_jSairButton1ActionPerformed
/*
     * Botões _______________Botões___________________Botões__________Botões
     *
     */
    

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JToggleButton jDadosButton;
    private javax.swing.JPanel jDadosPanel;
    private javax.swing.JPanel jEntregaPanel;
    private javax.swing.JToggleButton jEntregarButton;
    private javax.swing.JToggleButton jHistoricoButton;
    private javax.swing.JPanel jHistoricoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList2;
    private javax.swing.JButton jLoginButton;
    private javax.swing.JPanel jLoginPanel;
    private javax.swing.JButton jMenuButton5;
    private javax.swing.JPanel jMenuPanel;
    private javax.swing.JPanel jPaga;
    private javax.swing.JButton jPagarButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JToggleButton jPesquisarButton;
    private javax.swing.JPanel jPesquisarPanel;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JPanel jResultadosPanel;
    private javax.swing.JButton jSairButton;
    private javax.swing.JButton jSairButton1;
    private javax.swing.JButton jSairButton2;
    private javax.swing.JButton jSairButton3;
    private javax.swing.JButton jSairButton4;
    private javax.swing.JButton jSairButton5;
    private javax.swing.JButton jSairButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JToggleButton jSearchButton;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jUsernameField;
    private javax.swing.JButton jVoltarButton;
    private javax.swing.JButton jVoltarButton1;
    private javax.swing.JButton jVoltarButton4;
    private javax.swing.JButton jVoltarButton6;
    private javax.swing.JButton jVoltarPesquisaButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField menuDados_BI;
    private javax.swing.JTextField menuDados_mail;
    private javax.swing.JTextField menuDados_morada;
    private javax.swing.JTextField menuDados_nome;
    private javax.swing.JTextField menuDados_tel;
    private javax.swing.JList menuEntregar_filme;
    private javax.swing.JFormattedTextField menuPaga_dataEntrega;
    private javax.swing.JTextField menuPaga_preco;
    private javax.swing.JTextField menuPaga_titulo;
    private javax.swing.JSpinner menuPesquisar_anoHigh;
    private javax.swing.JSpinner menuPesquisar_anoLow;
    private javax.swing.JComboBox menuPesquisar_generos;
    private javax.swing.JSpinner menuPesquisar_imdbHigh;
    private javax.swing.JSpinner menuPesquisar_imdbLow;
    private javax.swing.JTextField menuPesquisar_pais;
    private javax.swing.JTextField menuPesquisar_produtor;
    private javax.swing.JTextField menuPesquisar_realizador;
    private javax.swing.JTextField menuPesquisar_titulo;
    private javax.swing.JTextField menuResultados_ano;
    private javax.swing.JTextArea menuResultados_descricao;
    private javax.swing.JList menuResultados_formatos;
    private javax.swing.JList menuResultados_generos;
    private javax.swing.JLabel menuResultados_imagem;
    private javax.swing.JTextField menuResultados_imdb;
    private javax.swing.JList menuResultados_listaFilmes;
    private javax.swing.JTextField menuResultados_pais;
    private javax.swing.JTextField menuResultados_produtor;
    private javax.swing.JTextField menuResultados_realizador;
    private javax.swing.JTextField menuResultados_titulo;
    private javax.swing.JTextField num_cartao;
    private javax.swing.JTextField num_css;
    private javax.swing.JTextField valorapagar;
    // End of variables declaration//GEN-END:variables


}
