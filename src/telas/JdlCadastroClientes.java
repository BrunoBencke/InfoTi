package telas;
import apoio.ComboItens;
import apoio.CombosDAO;
import dao.Dao;
import apoio.HibernateUtil;
import dao.ClienteDao;
import dao.EnderecoDao;
import entidades.Cliente;
import entidades.Endereco;
import entidades.Estado;
import entidades.Municipio;
import entidades.PessoaFisica;
import entidades.PessoaJuridica;
import static java.awt.event.KeyEvent.VK_ENTER;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class JdlCadastroClientes extends javax.swing.JDialog {
    
    Dao dao = new Dao();
    CombosDAO comboDao = new CombosDAO();
    ComboItens comboItens = new ComboItens();
    JTable tblClientes;
    HibernateUtil hibernate = new HibernateUtil();
    EnderecoDao enderecoDao = new EnderecoDao();
    ClienteDao cDao = new ClienteDao();
    Endereco endereco = new Endereco();
    Endereco endereco_old;
    PessoaFisica pf;
    PessoaFisica pfAux;
    PessoaFisica pf_old;
    PessoaJuridica pj;
    PessoaJuridica pjAux;
    PessoaJuridica pj_old;
    MaskFormatter mask;
    String botaopressionado;
    String tipoCadastro;
    Cliente c;
    Cliente cliente_old;

    public JdlCadastroClientes(java.awt.Frame parent, boolean modal,JTable tblClientes) {
        super(parent, modal);
        initComponents();
        botaopressionado = "novo";
        this.tblClientes = tblClientes;
        jcbCidade.setMaximumRowCount(15);
        jcbEstado.setMaximumRowCount(15);
        new CombosDAO().popularCombo("Estado", jcbEstado);
        new CombosDAO().popularComboComComplemento("Municipio", "Uf", jcbEstado.getSelectedItem().toString(), jcbCidade);
    }
    
    public JdlCadastroClientes(java.awt.Frame parent, boolean modal, Cliente c, JTable tblClientes) throws ParseException {
        super(parent, modal);
        initComponents();
        jcbTipo.setEnabled(false);
        botaopressionado = "editar";
        this.tblClientes = tblClientes;
        this.c = c;
        jcbCidade.setMaximumRowCount(15);
        jcbEstado.setMaximumRowCount(15);
        new CombosDAO().popularCombo("Estado", jcbEstado);
        new CombosDAO().popularComboComComplemento("Municipio", "Uf", jcbEstado.getSelectedItem().toString(), jcbCidade);
        carregarDados(c);
    }

    public void mascaraEmpresa(){
        lblNome.setText("Razão Social :");
        lblCpf.setText("CNPJ :");
        lblData.setText("   Data de Abertura :");
        lblRg.setText("IE :");
        try {
            txfCpf.setText("");
            mask = new MaskFormatter("##.###.###/####-##");
            txfCpf.setFormatterFactory(new DefaultFormatterFactory(mask));
        } catch (ParseException ex) {
            Logger.getLogger(JdlCadastroClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void mascaraPessoa() {
        lblNome.setText("Nome :");
        lblCpf.setText("CPF :");
        lblData.setText("Data de Nascimento :");
        lblRg.setText("RG :");
        try {
            txfCpf.setText("");
            mask = new MaskFormatter("###.###.###-##");
            txfCpf.setFormatterFactory(new DefaultFormatterFactory(mask));
        } catch (ParseException ex) {
            Logger.getLogger(JdlCadastroClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void carregarDados(Cliente c) throws ParseException{
        endereco = cDao.retornaObjetoEndereco(c.getIdendereco().getIdendereco());
        this.cliente_old = c;
        if (cDao.retornaPf(c) == null) {
            mascaraEmpresa();
            pjAux = cDao.retornaPj(c);
            jcbTipo.setSelectedIndex(1);
            txfCpf.setText(pjAux.getCnpj());
            txfRg.setText(pjAux.getInscricaoEstadual());
            txfData.setText(cDao.data_sistema(pjAux.getDataAbertura().toString()));
            tipoCadastro = "juridica";
        }else{
            mascaraPessoa();            
            pfAux = cDao.retornaPf(c);
            jcbTipo.setSelectedIndex(0);
            txfCpf.setText(pfAux.getCpf());
            txfRg.setText(pfAux.getRg());
            txfData.setText(cDao.data_sistema(pfAux.getDataNascimento().toString()));
            tipoCadastro = "fisica";
        }
        if (c.getSituacao()) {
            cbStatus.setSelected(true);
        } else {
            cbStatus.setSelected(false);
        }
        comboItens.setCodigo(endereco.getIdmunicipio().getIdmunicipio());
        System.out.println("cod endereco"+endereco.getIdmunicipio().getIdmunicipio());
        comboItens.setDescricao(endereco.getIdmunicipio().getNome());
        System.out.println("nome municipio "+endereco.getIdmunicipio().getNome());
        comboDao.definirItemCombo(jcbCidade, comboItens);
        txfNome.setText(c.getNome());
        txfSexo.setText(c.getSexo());
        txfInformacao.setText(c.getObservacao());
        txfTelefone.setText(c.getTelefone());
        txfRua.setText(endereco.getRua());
        txfNumero.setText(endereco.getNumero());
        txfBairro.setText(endereco.getBairro());
        txfCep.setText(endereco.getCep());
        txfComplemento.setText(endereco.getComplemento());
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jcbTipo = new javax.swing.JComboBox<>();
        lblNome = new javax.swing.JLabel();
        txfNome = new javax.swing.JTextField();
        lblTelefone = new javax.swing.JLabel();
        txfTelefone = new javax.swing.JTextField();
        lblSexo = new javax.swing.JLabel();
        cbStatus = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txfInformacao = new javax.swing.JTextArea();
        btnSalvar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        txfCpf = new javax.swing.JFormattedTextField();
        txfData = new javax.swing.JFormattedTextField();
        lblData = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        lblRg = new javax.swing.JLabel();
        lblCidade = new javax.swing.JLabel();
        jcbCidade = new javax.swing.JComboBox<>();
        lblEstado = new javax.swing.JLabel();
        jcbEstado = new javax.swing.JComboBox<>();
        lblRua = new javax.swing.JLabel();
        txfRua = new javax.swing.JTextField();
        lblNumero = new javax.swing.JLabel();
        txfNumero = new javax.swing.JTextField();
        lblBairro = new javax.swing.JLabel();
        txfBairro = new javax.swing.JTextField();
        lblCep = new javax.swing.JLabel();
        txfCep = new javax.swing.JTextField();
        lblComplemento = new javax.swing.JLabel();
        txfComplemento = new javax.swing.JTextField();
        txfSexo = new javax.swing.JTextField();
        txfRg = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Clientes");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Tipo do Cadastro:");

        jcbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pessoa Física", "Pessoa Jurídica" }));
        jcbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTipoActionPerformed(evt);
            }
        });

        lblNome.setText("Nome*  :");

        txfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfNomeActionPerformed(evt);
            }
        });

        lblTelefone.setText("Telefone :");

        lblSexo.setText("Sexo :");

        cbStatus.setSelected(true);
        cbStatus.setText("Ativo");
        cbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStatusActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações"));

        txfInformacao.setColumns(20);
        txfInformacao.setRows(5);
        jScrollPane1.setViewportView(txfInformacao);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/salvar.png"))); // NOI18N
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/sair.png"))); // NOI18N
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        try {
            txfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txfCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCpfActionPerformed(evt);
            }
        });
        txfCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfCpfKeyPressed(evt);
            }
        });

        try {
            txfData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txfData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfDataKeyPressed(evt);
            }
        });

        lblData.setText("Data de Nascimento :");

        lblCpf.setText("CPF :");

        lblRg.setText("RG : ");

        lblCidade.setText("Cidade :");

        jcbCidade.setMaximumRowCount(500);
        jcbCidade.setMaximumSize(new java.awt.Dimension(300, 300));
        jcbCidade.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbCidadeItemStateChanged(evt);
            }
        });
        jcbCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCidadeActionPerformed(evt);
            }
        });

        lblEstado.setText("UF:");

        jcbEstado.setMaximumRowCount(1000);
        jcbEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbEstadoItemStateChanged(evt);
            }
        });
        jcbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEstadoActionPerformed(evt);
            }
        });

        lblRua.setText("Rua :");

        lblNumero.setText("Nº :");

        lblBairro.setText("Bairro :");

        lblCep.setText("CEP :");

        lblComplemento.setText("Complemento:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblCidade)
                                    .addComponent(lblRua)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(15, 15, 15)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(lblSexo)
                                                .addComponent(lblNome)
                                                .addComponent(jLabel4)))
                                        .addComponent(lblData))
                                    .addComponent(lblBairro)
                                    .addComponent(lblComplemento))
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jcbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbStatus))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txfData, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txfSexo)
                                            .addComponent(txfCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblRg)
                                                .addGap(31, 31, 31))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(lblTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txfTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                    .addComponent(txfRg)))
                            .addComponent(txfNome)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txfBairro)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblCep))
                                    .addComponent(txfRua))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblNumero)
                                        .addGap(18, 18, 18)
                                        .addComponent(txfNumero))
                                    .addComponent(txfCep, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txfComplemento)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jcbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbStatus))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRg, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRua)
                    .addComponent(txfRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumero)
                    .addComponent(txfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBairro)
                    .addComponent(txfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCep)
                    .addComponent(txfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblComplemento)
                    .addComponent(txfComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar)
                    .addComponent(btnSair))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jcbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTipoActionPerformed
        if (jcbTipo.getSelectedIndex() == 1) {
            mascaraEmpresa();
            tipoCadastro = "juridica";
        }
        if (jcbTipo.getSelectedIndex() == 0) {
            mascaraPessoa();
            tipoCadastro = "fisica";
        }
    }//GEN-LAST:event_jcbTipoActionPerformed

    private void txfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfNomeActionPerformed

    private void cbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbStatusActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataAtual = null;
        if (jcbTipo.getSelectedIndex() == 1) {
            mascaraEmpresa();
            tipoCadastro = "juridica";
        }
        if (jcbTipo.getSelectedIndex() == 0) {
            mascaraPessoa();
            tipoCadastro = "fisica";
        }
        if (botaopressionado.equals("novo")) {
            if (tipoCadastro.equals("fisica")) {
                c = new Cliente();
                pf = new PessoaFisica();
                endereco = new Endereco();
                if (cbStatus.isSelected()) {
                    c.setSituacao(true);
                } else {
                    c.setSituacao(false);
                }
                if (txfNome.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Campo Obrigatório Vazio");
                } else {
                    c.setNome(txfNome.getText());
                }
                c.setSexo(txfSexo.getText());
                c.setTelefone(txfTelefone.getText());
                c.setObservacao(txfInformacao.getText());
                pf.setCpf(txfCpf.getText());
                pf.setRg(txfRg.getText());
                if (txfData.getText().equals("  /  /    ")) {
                    pf.setDataNascimento(new java.sql.Date(0000, 00, 00));
                } else {
                    try {
                        dataAtual = sdf.parse(txfData.getText());
                    } catch (ParseException ex) {
                        Logger.getLogger(JdlCadastroClientes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    pf.setDataNascimento(dataAtual);
                }
                endereco.setRua(txfRua.getText());
                endereco.setBairro(txfBairro.getText());
                endereco.setNumero(txfNumero.getText());
                endereco.setComplemento(txfComplemento.getText());
                endereco.setCep(txfCep.getText());
                ComboItens item = (ComboItens) jcbCidade.getSelectedItem();
                Municipio cidade = enderecoDao.retornaObjetoMunicipio(item.getCodigo());
                item = (ComboItens) jcbEstado.getSelectedItem();
                endereco.setIdmunicipio(cidade);
                dao.salvar(endereco);
                c.setIdendereco(endereco);
                dao.salvar(c);
                pf.setIdcliente(c);
                dao.salvar(pf);
                JOptionPane.showMessageDialog(this, "Cliente Cadastrado!");
                this.dispose();
            } else if (tipoCadastro.equals("juridica")) {
                c = new Cliente();
                pj = new PessoaJuridica();
                endereco = new Endereco();
                if (cbStatus.isSelected()) {
                    c.setSituacao(true);
                } else {
                    c.setSituacao(false);
                }
                if (txfNome.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Campo Obrigatório Vazio");
                } else {
                    c.setNome(txfNome.getText());
                }
                c.setSexo(txfSexo.getText());
                c.setTelefone(txfTelefone.getText());
                c.setObservacao(txfInformacao.getText());
                pj.setCnpj(txfCpf.getText());
                pj.setInscricaoEstadual(txfRg.getText());
                if (txfData.getText().equals("  /  /    ")) {
                    pj.setDataAbertura(new java.sql.Date(0000, 00, 00));
                } else {
                    try {
                        dataAtual = sdf.parse(txfData.getText());
                    } catch (ParseException ex) {
                        Logger.getLogger(JdlCadastroClientes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    pj.setDataAbertura(dataAtual);
                }
                endereco.setRua(txfRua.getText());
                endereco.setBairro(txfBairro.getText());
                endereco.setNumero(txfNumero.getText());
                endereco.setComplemento(txfComplemento.getText());
                endereco.setCep(txfCep.getText());
                ComboItens item = (ComboItens) jcbCidade.getSelectedItem();
                Municipio cidade = enderecoDao.retornaObjetoMunicipio(item.getCodigo());
                item = (ComboItens) jcbEstado.getSelectedItem();
                endereco.setIdmunicipio(cidade);
                dao.salvar(endereco);
                c.setIdendereco(endereco);
                dao.salvar(c);
                pj.setIdcliente(c);
                dao.salvar(pj);
                JOptionPane.showMessageDialog(this, "Empresa Cadastrada!");
                this.dispose();
            }
            cDao.populaClientes(tblClientes);
        } else if (botaopressionado.equals("editar")) {     
            if (tipoCadastro.equals("fisica")) {
                endereco = c.getIdendereco();
                String dado_antigo_cliente = c.toString();
                String dado_antigo_pf = pfAux.toString();
                String dado_antigo_endereco = endereco.toString();
                if (cbStatus.isSelected()) {
                    c.setSituacao(true);
                } else {
                    c.setSituacao(false);
                }
                if (txfNome.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Campo Obrigatório Vazio");
                } else {
                    c.setNome(txfNome.getText());
                }
                c.setSexo(txfSexo.getText());
                c.setTelefone(txfTelefone.getText());
                c.setObservacao(txfInformacao.getText());
                pfAux.setCpf(txfCpf.getText());
                pfAux.setRg(txfRg.getText());
                if (txfData.getText().equals("  /  /    ")) {
                    pfAux.setDataNascimento(new java.sql.Date(0000, 00, 00));
                } else {
                    try {
                        dataAtual = sdf.parse(txfData.getText());
                    } catch (ParseException ex) {
                        Logger.getLogger(JdlCadastroClientes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    pfAux.setDataNascimento(dataAtual);
                }
                endereco.setRua(txfRua.getText());
                endereco.setBairro(txfBairro.getText());
                endereco.setNumero(txfNumero.getText());
                endereco.setComplemento(txfComplemento.getText());
                endereco.setCep(txfCep.getText());
                ComboItens item = (ComboItens) jcbCidade.getSelectedItem();
                Municipio cidade = enderecoDao.retornaObjetoMunicipio(item.getCodigo());
                item = (ComboItens) jcbEstado.getSelectedItem();                
                endereco.setIdmunicipio(cidade);
                endereco.setIdendereco(c.getIdendereco().getIdendereco());                
                dao.atualizar(endereco,dado_antigo_endereco);                
                c.setIdendereco(endereco);                
                dao.atualizar(c, dado_antigo_cliente);
                pfAux.setIdcliente(c);
                dao.atualizar(pfAux, dado_antigo_pf);
                JOptionPane.showMessageDialog(this, "Cliente Atualizado!");
                this.dispose();
            } else if (tipoCadastro.equals("juridica")) { 
                endereco = c.getIdendereco();
                String dado_antigo_cliente = c.toString();
                String dado_antigo_pj = pjAux.toString();
                String dado_antigo_endereco = endereco.toString();
                if (txfNome.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Campo Obrigatório Vazio");
                } else {
                    endereco = new Endereco();
                    c.setNome(txfNome.getText());
                    if (cbStatus.isSelected()) {
                        c.setSituacao(true);
                    } else {
                        c.setSituacao(false);
                    }
                    c.setSexo(txfSexo.getText());
                    c.setTelefone(txfTelefone.getText());
                    c.setObservacao(txfInformacao.getText());
                    pjAux.setCnpj(txfCpf.getText());
                    pjAux.setInscricaoEstadual(txfRg.getText());
                    if (txfData.getText().equals("  /  /    ")) {
                        pjAux.setDataAbertura(new java.sql.Date(0000, 00, 00));
                    } else {
                        try {
                            dataAtual = sdf.parse(txfData.getText());
                        } catch (ParseException ex) {
                            Logger.getLogger(JdlCadastroClientes.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        pjAux.setDataAbertura(dataAtual);
                    }
                    endereco.setRua(txfRua.getText());
                    endereco.setBairro(txfBairro.getText());
                    endereco.setNumero(txfNumero.getText());
                    endereco.setComplemento(txfComplemento.getText());
                    endereco.setCep(txfCep.getText());
                    ComboItens item = (ComboItens) jcbCidade.getSelectedItem();
                    Municipio cidade = enderecoDao.retornaObjetoMunicipio(item.getCodigo());
                    item = (ComboItens) jcbEstado.getSelectedItem();
                    endereco.setIdmunicipio(cidade);
                    endereco.setIdendereco(c.getIdendereco().getIdendereco());
                    dao.atualizar(endereco,dado_antigo_endereco);
                    c.setIdendereco(endereco);
                    dao.atualizar(c,dado_antigo_cliente);
                    pjAux.setIdcliente(c);
                    dao.atualizar(pjAux,dado_antigo_pj);
                    JOptionPane.showMessageDialog(this, "Empresa Atualizada!");
                    this.dispose();
                }                
            }
            cDao.populaClientes(tblClientes);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void txfCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCpfActionPerformed

    private void txfCpfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCpfKeyPressed
        if (evt.getKeyChar() == VK_ENTER) {
            txfCpf.setText(null);
        }
    }//GEN-LAST:event_txfCpfKeyPressed

    private void txfDataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfDataKeyPressed
        if (evt.getKeyChar() == VK_ENTER) {
            txfData.setText(null);
        }
    }//GEN-LAST:event_txfDataKeyPressed

    private void jcbCidadeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbCidadeItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbCidadeItemStateChanged

    private void jcbCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbCidadeActionPerformed

    private void jcbEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbEstadoItemStateChanged

    }//GEN-LAST:event_jcbEstadoItemStateChanged

    private void jcbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEstadoActionPerformed
            jcbCidade.removeAllItems();
            new CombosDAO().popularComboComComplemento("Municipio", "Uf", jcbEstado.getSelectedItem().toString(), jcbCidade);
    }//GEN-LAST:event_jcbEstadoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JdlCadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdlCadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdlCadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdlCadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JTable tblClientes = null;
                JdlCadastroClientes dialog = new JdlCadastroClientes(new javax.swing.JFrame(), true, tblClientes);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox cbStatus;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbCidade;
    public javax.swing.JComboBox<String> jcbEstado;
    private javax.swing.JComboBox<String> jcbTipo;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCep;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblComplemento;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblRg;
    private javax.swing.JLabel lblRua;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JTextField txfBairro;
    private javax.swing.JTextField txfCep;
    private javax.swing.JTextField txfComplemento;
    private javax.swing.JFormattedTextField txfCpf;
    private javax.swing.JFormattedTextField txfData;
    private javax.swing.JTextArea txfInformacao;
    private javax.swing.JTextField txfNome;
    private javax.swing.JTextField txfNumero;
    private javax.swing.JTextField txfRg;
    private javax.swing.JTextField txfRua;
    private javax.swing.JTextField txfSexo;
    private javax.swing.JTextField txfTelefone;
    // End of variables declaration//GEN-END:variables
}
