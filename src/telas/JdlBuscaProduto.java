package telas;
import dao.Dao;
import dao.ProdutosDao;
import entidades.Produto;
import entidades.ProdutoVenda;
import entidades.Venda;
import static java.awt.event.KeyEvent.VK_ENTER;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author Bruno Bencke
 */
public class JdlBuscaProduto extends javax.swing.JDialog {
    
    private int produtoExistente;
    private int codPedido;
    private int codProd;
    private String descricao;
    private double precoVenda;
    private double precoTotal;
    private double quantidade;
    private String unidade;
    Dao dao = new Dao();
    ProdutosDao produtoDao = new ProdutosDao();
    ProdutoVenda item = new ProdutoVenda();
    Venda venda = new Venda();
    Produto p = new Produto();
    
    public JdlBuscaProduto(java.awt.Frame parent, boolean modal, Venda venda) {
        super(parent, modal);
        initComponents();
        this.venda = venda;
        item.setIdvenda(venda);
        this.produtoExistente = 0;
        produtoDao.populaProduto(tblProdutos);
    }
    
    public double getTotalItem(){
        return this.precoTotal;
    }
    
    public void limpaSelecao(){
        tblProdutos.getSelectionModel().clearSelection();
        produtoExistente = 0;
        txfPrecoVenda.setText("");
        txfQtd.setText("");
        txfTotal.setText("");
        produtoDao.populaProduto(tblProdutos);
    }
    
    
    //se retornar false ele já esta no pedido / se for true não está
    public boolean verificaProdutoExistente() {
//        ArrayList<ItemPedido> produtos = pDao.produtosDoPedido(codPedido);
//        for (int i = 0; i < produtos.size(); i++) {
//            ItemPedido item = produtos.get(i);
//            if (item.getCod_produto() == codProd) {
//                this.produtoExistente = 1;
//                return false;                
//            }
//        }
//        if (produtoExistente == 1) {
//            JOptionPane.showMessageDialog(this, "Este Produto Já Pertence ao Pedido!");
//            limpaSelecao();
//        }
        return true;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnFechar = new javax.swing.JButton();
        btnAceitar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        jtfNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txfTotal = new javax.swing.JTextField();
        txfQtd = new javax.swing.JTextField();
        txfPrecoVenda = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Produtos");

        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/cancelar.png"))); // NOI18N
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        btnAceitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Add.png"))); // NOI18N
        btnAceitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceitarActionPerformed(evt);
            }
        });
        btnAceitar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAceitarKeyPressed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Search.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome :");

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
        tblProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdutosMouseClicked(evt);
            }
        });
        tblProdutos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblProdutosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblProdutosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblProdutos);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Preço de Venda* :");

        jLabel3.setText("Quantidade* :");

        jLabel4.setText("Total :");

        txfTotal.setEditable(false);

        txfQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfQtdActionPerformed(evt);
            }
        });
        txfQtd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfQtdKeyPressed(evt);
            }
        });

        txfPrecoVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfPrecoVendaActionPerformed(evt);
            }
        });
        txfPrecoVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfPrecoVendaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txfPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addGap(29, 29, 29)
                .addComponent(txfQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNome)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfNome, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceitar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAceitar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceitarActionPerformed
        int linha = tblProdutos.getSelectedRow();
        if (linha > -1) {
            this.codProd = Integer.valueOf(String.valueOf(tblProdutos.getValueAt(linha, 0)));
            p = produtoDao.procurarPorId(codProd);
            this.dispose();
//            if (verificaProdutoExistente()) {                
//                descricao = String.valueOf(tblProdutos.getValueAt(linha, 1));                
//                this.dispose();
//            } else {
//                JOptionPane.showMessageDialog(null, "Produto já Pertence ao Pedido!", "Informação", JOptionPane.INFORMATION_MESSAGE);
//                limpaSelecao();
//            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Produto!", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAceitarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        //new ProdutoDao().popularTabela(tblProdutos, jtfNome.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.produtoExistente = 1;
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void txfPrecoVendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfPrecoVendaKeyPressed
        if (evt.getKeyChar() == VK_ENTER) {
            if (txfPrecoVenda.getText().length() < 1) {
                //JOptionPane.showMessageDialog(this, "Informe o Preço de Venda!");    
            } else {
                precoVenda = Double.parseDouble(txfPrecoVenda.getText());
                txfQtd.requestFocus();
            }
        }
    }//GEN-LAST:event_txfPrecoVendaKeyPressed

    private void txfQtdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfQtdKeyPressed
        if (evt.getKeyChar() == VK_ENTER) {
            DecimalFormat formato = new DecimalFormat("#.##");
            if (txfQtd.getText().length() < 1) {
                JOptionPane.showMessageDialog(this, "Informe a Quantidade!");
            } else {
                quantidade = Double.parseDouble(txfQtd.getText());
                //precoTotal = Double.valueOf(formato.format(precoVenda * quantidade));
                precoTotal = precoVenda*quantidade;
                System.out.println(precoTotal);
                txfTotal.setText(String.valueOf(precoTotal));
                btnAceitar.requestFocus();
            }
        }
    }//GEN-LAST:event_txfQtdKeyPressed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        if (evt.getKeyChar() == VK_ENTER) {
            txfPrecoVenda.requestFocus();
        }
    }//GEN-LAST:event_jPanel1KeyPressed

    private void tblProdutosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblProdutosKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tblProdutosKeyReleased

    private void tblProdutosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblProdutosKeyPressed
        if (evt.getKeyChar() == VK_ENTER) {
            txfPrecoVenda.requestFocus();
        }
    }//GEN-LAST:event_tblProdutosKeyPressed

    private void txfPrecoVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfPrecoVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfPrecoVendaActionPerformed

    private void txfQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfQtdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfQtdActionPerformed

    private void btnAceitarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAceitarKeyPressed

    }//GEN-LAST:event_btnAceitarKeyPressed

    private void tblProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutosMouseClicked
        int linha = tblProdutos.getSelectedRow();
        if (linha > -1) {
            this.codProd = Integer.valueOf(String.valueOf(tblProdutos.getValueAt(linha, 0)));
            //Produto p = produtoDao.select(codProd);
            //unidade = p.getUnidade();
            //txfPrecoVenda.setText("" + p.getPrecoVenda());
            if (txfPrecoVenda.getText().length() < 1) {
                //JOptionPane.showMessageDialog(this, "Informe o Preço de Venda!");
            } else {
                precoVenda = Double.parseDouble(txfPrecoVenda.getText());
                txfQtd.requestFocus();
            }            
        }
    }//GEN-LAST:event_tblProdutosMouseClicked

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
            java.util.logging.Logger.getLogger(JdlBuscaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdlBuscaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdlBuscaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdlBuscaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JdlBuscaProduto dialog = new JdlBuscaProduto(new javax.swing.JFrame(), true, new Venda());
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
    private javax.swing.JButton btnAceitar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txfPrecoVenda;
    private javax.swing.JTextField txfQtd;
    private javax.swing.JTextField txfTotal;
    // End of variables declaration//GEN-END:variables

    public Venda getIdVenda() {
        return venda;
    }

    public Produto getIdProd() {
        return p;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPrecoUnitario() {
        return precoVenda;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public int getProdutoExistente() {
        return produtoExistente;
    }
}
