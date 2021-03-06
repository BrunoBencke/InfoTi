package telas;

import apoio.ComboItens;
import apoio.CombosDAO;
import dao.Dao;
import dao.ProdutosDao;
import entidades.ContaPagar;
import entidades.MarcaProduto;
import entidades.Produto;
import java.math.BigDecimal;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class JdlCadastroProdutos extends javax.swing.JDialog {

    ProdutosDao produtosDao = new ProdutosDao();
    MarcaProduto marcaProduto = new MarcaProduto();
    Produto produto = new Produto();
    String botaopressionado = "novo";
    Dao d = new Dao();
    JTable tblProdutos;

    public JdlCadastroProdutos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jcbProduto.removeAllItems();
        jcbProduto.setMaximumRowCount(15);
        new CombosDAO().popularCombo("MarcaProduto", jcbProduto);
    }

//    JdlCadastroProdutos(Object object, JTable JtlProdutos, Produto c) {
//
//        initComponents();
//        jcbProduto.removeAllItems();
//        jcbProduto.setMaximumRowCount(15);
//        new CombosDAO().popularCombo("MarcaProduto", jcbProduto);
//        produtosDao.populaProduto(JtlProdutos);
//
//    }

//    JdlCadastroProdutos(Object object, boolean b, Produto produto, JTable JtlProdutos, Produto c) {
//
//        initComponents();
//        jcbProduto.removeAllItems();
//        jcbProduto.setMaximumRowCount(15);
//        new CombosDAO().popularCombo("MarcaProduto", jcbProduto);
//        produtosDao.populaProduto(JtlProdutos);
//
//    }

    public JdlCadastroProdutos(java.awt.Frame parent, boolean modal, Produto produto, JTable JtlProdutos) {
        super(parent, modal);
        initComponents();
        this.produto = produto;
        this.tblProdutos = JtlProdutos;
        jcbProduto.removeAllItems();
        jcbProduto.setMaximumRowCount(15);
        this.botaopressionado = "editar";
        new CombosDAO().popularCombo("MarcaProduto", jcbProduto); 
        carregarDados(produto);
    }



    public void carregarDados(Produto p) {
        txfCod.setText(String.valueOf(p.getIdproduto()));
        txfNome.setText(p.getNome());
        txfPrecoCusto.setText(p.getValor().toString());
        txfEstoque.setText(Double.valueOf(p.getEstoque()).toString());
        txfDescricao.setText(p.getDescricao());
        new CombosDAO().popularCombo("MarcaProduto", jcbProduto);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txfCod = new javax.swing.JTextField();
        txfNome = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txfPrecoCusto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txfEstoque = new javax.swing.JTextField();
        dtnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txfDescricao = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jcbProduto = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Produto");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Produto"));

        jLabel6.setText("Código do Produto :");

        txfCod.setEditable(false);

        txfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfNomeActionPerformed(evt);
            }
        });

        jLabel10.setText("Nome*  :");

        jLabel11.setText("Valor :");

        jLabel4.setText("Estoque :");

        dtnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/salvar.png"))); // NOI18N
        dtnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/cancelar.png"))); // NOI18N
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jLabel12.setText("Descrição :");

        txfDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfDescricaoActionPerformed(evt);
            }
        });

        jLabel13.setText("Marca :");

        jcbProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(37, 37, 37)
                        .addComponent(txfCod, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel10)
                            .addComponent(jLabel4)
                            .addComponent(jLabel11))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(118, 118, 118)
                                        .addComponent(dtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txfPrecoCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txfEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(20, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txfCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfPrecoCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtnSalvar)
                    .addComponent(btnExcluir))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(389, 410));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfNomeActionPerformed

    private void txfDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfDescricaoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        this.dispose();

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jcbProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbProdutoActionPerformed

        jcbProduto.removeAllItems();
        new CombosDAO().popularCombo("MarcaProduto", jcbProduto);
    }//GEN-LAST:event_jcbProdutoActionPerformed

    private void dtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtnSalvarActionPerformed
        MarcaProduto marcaProduto = new MarcaProduto();
        if (botaopressionado.equals("novo")) {
            produto.setNome(txfNome.getText());
            produto.setValor(BigDecimal.valueOf(Double.parseDouble(txfPrecoCusto.getText())));
            produto.setEstoque(Double.parseDouble(txfEstoque.getText()));
            produto.setDescricao(txfDescricao.getText());
            ComboItens item = (ComboItens) jcbProduto.getSelectedItem();
            marcaProduto.setIdmarcaProduto(item.getCodigo());
            marcaProduto.setNome(item.getDescricao());
            produto.setIdmarcaProduto(marcaProduto);
            produto.setSituacao(true);
            d.salvar(produto);
            JOptionPane.showMessageDialog(this, "Produto Cadastrado!");
            txfNome.setText("");
            txfEstoque.setText("");
            txfPrecoCusto.setText("");
            txfDescricao.setText("");            
            this.dispose();
            
        } else if (botaopressionado.equals("editar")) {
            produto.setIdproduto(Integer.valueOf(txfCod.getText()));
            produto.setNome(txfNome.getText());
            produto.setValor(BigDecimal.valueOf(Double.parseDouble(txfPrecoCusto.getText())));
            produto.setEstoque(Double.valueOf(txfEstoque.getText()));
            produto.setDescricao(txfDescricao.getText());
            ComboItens item = (ComboItens) jcbProduto.getSelectedItem();
            marcaProduto.setIdmarcaProduto(item.getCodigo());
            marcaProduto.setNome(item.getDescricao());
            produto.setIdmarcaProduto(marcaProduto);
            produto.setSituacao(true);
            d.atualizar(produto, produto.toString());
            JOptionPane.showMessageDialog(this, "Produto Editado!");
            txfNome.setText("");
            txfEstoque.setText("");
            txfPrecoCusto.setText("");
            txfDescricao.setText("");
            this.dispose();
        }
        produtosDao.populaProduto(tblProdutos);
    }//GEN-LAST:event_dtnSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(JdlCadastroProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdlCadastroProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdlCadastroProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdlCadastroProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JdlCadastroProdutos dialog = new JdlCadastroProdutos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton dtnSalvar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jcbProduto;
    private javax.swing.JTextField txfCod;
    private javax.swing.JTextField txfDescricao;
    private javax.swing.JTextField txfEstoque;
    private javax.swing.JTextField txfNome;
    private javax.swing.JTextField txfPrecoCusto;
    // End of variables declaration//GEN-END:variables
}
