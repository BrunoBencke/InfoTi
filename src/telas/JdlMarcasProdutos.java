package telas;

import dao.MarcasProdutosDao;
import entidades.MarcaProduto;
import javax.swing.JOptionPane;

public class JdlMarcasProdutos extends javax.swing.JDialog {

    MarcasProdutosDao d = new MarcasProdutosDao();
    MarcaProduto obj = new MarcaProduto();
    String botaopressionado = "novo";

    public JdlMarcasProdutos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txfnome.setEditable(false);
        btsalvar.setEnabled(false);
        btexcluir.setEnabled(true);
        d.populaMarcaProduto(tblMarcaProduto);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btexcluir = new javax.swing.JButton();
        btsalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMarcaProduto = new javax.swing.JTable();
        btnSair = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txfnome = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Marcas De Produtos");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/adicionar.png"))); // NOI18N
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/editar.png"))); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btexcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/cancelar.png"))); // NOI18N
        btexcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btexcluirActionPerformed(evt);
            }
        });

        btsalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/salvar.png"))); // NOI18N
        btsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsalvarActionPerformed(evt);
            }
        });

        tblMarcaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Marcas"
            }
        ));
        jScrollPane1.setViewportView(tblMarcaProduto);

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/sair.png"))); // NOI18N
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel6.setText("Marca :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(txfnome, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(227, 227, 227))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btsalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btexcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btsalvar)
                    .addComponent(btexcluir)
                    .addComponent(btnEditar)
                    .addComponent(btnNovo)
                    .addComponent(btnSair))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsalvarActionPerformed
        if (botaopressionado.equals("novo")) {
            obj = new MarcaProduto();
            obj.setNome(txfnome.getText());
            obj.setSituacao(true);
            d.salvar(obj);
            JOptionPane.showMessageDialog(this, "Marca Cadastrada!");
            txfnome.setText("");
        } else if (botaopressionado.equals("editar")) {
            obj.setNome(txfnome.getText());
            d.atualizar(obj);
            JOptionPane.showMessageDialog(this, "Marca Editada!");
            txfnome.setText("");
        }
        d.populaMarcaProduto(tblMarcaProduto);
    }//GEN-LAST:event_btsalvarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        txfnome.setText("");
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed

        txfnome.setEditable(true);
        btsalvar.setEnabled(true);
        btnEditar.setEnabled(false);
        btexcluir.setEnabled(false);

    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        txfnome.setEditable(true);
        btsalvar.setEnabled(true);
        btnEditar.setEnabled(false);
        btexcluir.setEnabled(true);
        int linha = tblMarcaProduto.getSelectedRow();
        if (linha > -1) {
            botaopressionado = "editar";
            int codMarca = Integer.valueOf(String.valueOf(tblMarcaProduto.getValueAt(linha, 0)));
            obj = d.procurarPorId(codMarca);
            txfnome.setText(obj.getNome());
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma Marca !", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btexcluirActionPerformed
        int linha = tblMarcaProduto.getSelectedRow();
        if (linha > -1) {
            int resposta = 0;
            int codUsuario = Integer.valueOf(String.valueOf(tblMarcaProduto.getValueAt(tblMarcaProduto.getSelectedRow(), 0)));
            resposta = JOptionPane.showConfirmDialog(this, "Deseja Realmente Excluir?");
            if (resposta == JOptionPane.YES_OPTION) {
                obj = d.procurarPorId(codUsuario);
                d.excluir(obj);
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um Marca!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            }
            d.populaMarcaProduto(tblMarcaProduto);
        }
    }//GEN-LAST:event_btexcluirActionPerformed

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
            java.util.logging.Logger.getLogger(JdlMarcasProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdlMarcasProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdlMarcasProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdlMarcasProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JdlMarcasProdutos dialog = new JdlMarcasProdutos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btexcluir;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btsalvar;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMarcaProduto;
    private javax.swing.JTextField txfnome;
    // End of variables declaration//GEN-END:variables
}
