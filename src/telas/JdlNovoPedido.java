package telas;

import dao.ClienteDao;
import dao.Dao;
import dao.ProdutosDao;
import entidades.Cliente;
import entidades.ProdutoVenda;
import entidades.Venda;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static telas.JfrPrincipal.user;

public class JdlNovoPedido extends javax.swing.JDialog {

    JTable tblPedidos = new JTable();
    Dao dao = new Dao();
    ClienteDao cDao = new ClienteDao();
    ProdutosDao pDao = new ProdutosDao();
    Cliente cliente = new Cliente();
    ProdutoVenda item = new ProdutoVenda();
    String cancelar = null;
    String editar = null;
    Venda venda = new Venda();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date dataAtual = new Date(); 
            
    //sdf.parse(txfDataAtual.getText());
    
    /**
     * Creates new form JdlNovoPedido
     */
    public JdlNovoPedido(java.awt.Frame parent, boolean modal,JTable tblPedidos) throws ParseException {
        super(parent, modal);
        initComponents();
        this.cancelar = "deletar";
        this.editar = "novo";
        this.tblPedidos = tblPedidos;
        cliente.setIdcliente(-1);
        txfDataAtual.setText(sdf.format(dataAtual));
        venda.setIdusuario(user);
        venda.setData(sdf.parse(txfDataAtual.getText()));
        venda.setIdcliente(cliente);
        dao.salvar(venda);
    }
    
    public JdlNovoPedido(java.awt.Frame parent, boolean modal, JTable tblPedidos, int codPedido) {
        super(parent, modal);
        initComponents();
        this.cancelar = "sair";
        this.editar = "editar"; 
        this.tblPedidos = tblPedidos;
    }

    public void limpaCampos() {
        txfNome.setText(null);
        txfTelefone.setText(null);
    }

    public void carregarDados(Cliente c) {
        txfNome.setText(cliente.getNome());
        txfTelefone.setText(cliente.getTelefone());
        venda.setIdcliente(c);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblNPedido = new javax.swing.JLabel();
        jpnCliente = new javax.swing.JPanel();
        txfNome = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        lblCelular = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txfTelefone = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txfDataAtual = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txfTotal = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btnFechar = new javax.swing.JButton();
        btnFaturar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novo Pedido");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Pedido");

        lblNPedido.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(4, 4, 4))
        );

        jpnCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpnCliente.setLayout(null);

        txfNome.setToolTipText("Digite ENTER para abrir os Clientes");
        txfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfNomeActionPerformed(evt);
            }
        });
        txfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfNomeKeyPressed(evt);
            }
        });
        jpnCliente.add(txfNome);
        txfNome.setBounds(60, 10, 290, 20);

        lblNome.setText("Nome*  :");
        jpnCliente.add(lblNome);
        lblNome.setBounds(10, 10, 100, 20);

        lblCelular.setText("Telefone :");
        jpnCliente.add(lblCelular);
        lblCelular.setBounds(370, 10, 90, 20);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Search.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jpnCliente.add(btnBuscar);
        btnBuscar.setBounds(840, 10, 50, 20);
        jpnCliente.add(txfTelefone);
        txfTelefone.setBounds(430, 10, 120, 20);

        jLabel9.setText("Data da Venda :");
        jpnCliente.add(jLabel9);
        jLabel9.setBounds(570, 10, 130, 20);

        txfDataAtual.setEditable(false);
        jpnCliente.add(txfDataAtual);
        txfDataAtual.setBounds(710, 10, 90, 20);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblProdutos);

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Add.png"))); // NOI18N
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Exit.png"))); // NOI18N
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 893, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jpnCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("TOTAL :");

        txfTotal.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(txfTotal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/cancelar.png"))); // NOI18N
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        btnFaturar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/aceitar.png"))); // NOI18N
        btnFaturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFaturarActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/salvar.png"))); // NOI18N
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFaturar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFaturar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfNomeActionPerformed

    }//GEN-LAST:event_txfNomeActionPerformed

    private void txfNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNomeKeyPressed
//        if (evt.getKeyChar() == VK_ENTER) {
//            JdlClientes telaClientes = new JdlClientes(this, rootPaneCheckingEnabled);
//            telaClientes.setVisible(true);
//            Cliente cliente = new ClienteDao().select(telaClientes.getCodCli());
//            try {
//                carregarDados(cliente);
//            } catch (ParseException ex) {
//                Logger.getLogger(JfrPedidos.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }//GEN-LAST:event_txfNomeKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        limpaCampos();
        JdlBuscaCliente buscaCliente = new JdlBuscaCliente(null, false);
        buscaCliente.setModal(true);
        buscaCliente.setVisible(true);
        cliente = cDao.procurarPorId(buscaCliente.getCodCli());
        if (cliente.getIdcliente() > 0) {
           carregarDados(cliente); 
        }                
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        if (editar.equalsIgnoreCase("editar")) {
            JdlBuscaProduto telaProdutos = new JdlBuscaProduto(null, rootPaneCheckingEnabled, venda);
            telaProdutos.setModal(true);
            telaProdutos.setVisible(true);
            item.setIdvenda(venda);
            item.setIdproduto(telaProdutos.getIdProd());
            item.setQuantidade(telaProdutos.getQuantidade());
            BigDecimal b = new BigDecimal(telaProdutos.getPrecoUnitario());
            item.setValorUnitario(b);
            dao.salvar(item);
            //totalPedido = totalPedido + item.getPrecoTotal();
            //pedido.setTotal(totalPedido);
            //pDao.update(pedido);
            //txfTotal.setText("" + totalPedido);
            //pDao.popularTabela(tblProdutos, (Integer.toString(pedido.getCod_pedido())));
        }
        if (editar.equalsIgnoreCase("novo")) {
            if (venda.getIdcliente().getIdcliente() == 0) {
                JOptionPane.showMessageDialog(this, "Verifique os campos Cliente/Vendedor");
            } else {
                venda.setIdcliente(cliente);
                lblNPedido.setText(" Nº: " + Integer.toString(venda.getIdvenda()));
                JdlBuscaProduto telaProdutos = new JdlBuscaProduto(null, rootPaneCheckingEnabled, venda);
                telaProdutos.setModal(true);
                telaProdutos.setVisible(true);                
                if (telaProdutos.getProdutoExistente() == 0) {
                    item.setCod_pedido(pedido.getCod_pedido());
                    item.setCod_produto(telaProdutos.getCodProd());
                    item.setDescricao(telaProdutos.getDescricao());
                    item.setPrecoTotal(telaProdutos.getPrecoTotal());
                    item.setPrecoVenda(telaProdutos.getPrecoVenda());
                    item.setQuantidade(telaProdutos.getQuantidade());
                    item.setUnidade(telaProdutos.getUnidade());
                    itemPedido.insert(item);
                    totalPedido = totalPedido + item.getPrecoTotal();
                    pedido.setTotal(totalPedido);
                    pDao.update(pedido);
                    txfTotal.setText(""+totalPedido);
                    pDao.populaProdutosVenda(tblPedidos, venda);
                }
            }
            this.editar = "editar";
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
//        int linha = tblProdutos.getSelectedRow();
//        if (linha > -1) {
//            int codItem = Integer.valueOf(String.valueOf(tblProdutos.getValueAt(linha, 0)));
//            pDao.deleteItemPedido(codItem);
//            totalPedido = totalPedido - item.getPrecoTotal();
//            txfTotal.setText("" + totalPedido);
//            pDao.popularTabela(tblProdutos, (Integer.toString(pedido.getCod_pedido())));
//            //aumentar estoque novamente
//        } else {
//            JOptionPane.showMessageDialog(null, "Selecione um Produto!", "Informação", JOptionPane.INFORMATION_MESSAGE);
//        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        if (cancelar == "deletar") {
            this.dispose();
        }
        if (cancelar == "sair") {
            this.dispose();
        }
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnFaturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFaturarActionPerformed
//        ArrayList<ItemPedido> produtos = pDao.produtosDoPedido(pedido.getCod_pedido());
//        if (produtos.size() < 1) {
//            JOptionPane.showMessageDialog(this, "Adicione Algum Produto Para Faturar!");
//        } else {
//            for (int i = 0; i < produtos.size(); i++) {
//                ItemPedido item = produtos.get(i);
//                pDao.baixarEstoque(item.getCod_produto(), item.getQuantidade());
//            }
//            JdlCrediario cred = new JdlCrediario(this, rootPaneCheckingEnabled, pedido,tblPedidos);
//            cred.setVisible(true);
//            this.dispose();
//        }
    }//GEN-LAST:event_btnFaturarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (venda.getIdcliente().getIdcliente() == -1) {
            JOptionPane.showMessageDialog(this, "Escolha um Cliente!");
        } else {
            venda.setIdcliente(cliente);
            venda.setIdusuario(user);        
            try {
                venda.setData(sdf.parse(txfDataAtual.getText()));
            } catch (ParseException ex) {
                Logger.getLogger(JdlNovoPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        dao.salvar(venda);
        //pDao.popularTabelaPedidos(tblPedidos, 0);
        this.dispose();
    }//GEN-LAST:event_btnSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(JdlNovoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdlNovoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdlNovoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdlNovoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JTable tabela = new JTable();
                JdlNovoPedido dialog = null;
                try {
                    dialog = new JdlNovoPedido(new javax.swing.JFrame(), true, tabela);
                } catch (ParseException ex) {
                    Logger.getLogger(JdlNovoPedido.class.getName()).log(Level.SEVERE, null, ex);
                }
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
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnFaturar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpnCliente;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblNPedido;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txfDataAtual;
    private javax.swing.JTextField txfNome;
    private javax.swing.JTextField txfTelefone;
    private javax.swing.JTextField txfTotal;
    // End of variables declaration//GEN-END:variables
}
