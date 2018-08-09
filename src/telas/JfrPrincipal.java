package telas;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class JfrPrincipal extends javax.swing.JFrame {

    public JfrPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbUserLogged = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        registros = new javax.swing.JMenu();
        pedidos = new javax.swing.JMenuItem();
        clientes = new javax.swing.JMenuItem();
        produtos = new javax.swing.JMenuItem();
        adicionais = new javax.swing.JMenu();
        funcionarios = new javax.swing.JMenuItem();
        fianceiro = new javax.swing.JMenu();
        contasReceber = new javax.swing.JMenuItem();
        relatorios = new javax.swing.JMenu();
        relatorioClientes = new javax.swing.JMenu();
        miAllClients = new javax.swing.JMenuItem();
        relatorioFuncionarios = new javax.swing.JMenu();
        miAllWorkers = new javax.swing.JMenuItem();
        miWorkersPeriod = new javax.swing.JMenuItem();
        relatorioPedidos = new javax.swing.JMenu();
        miAllOrders = new javax.swing.JMenuItem();
        miOrdersPeriod = new javax.swing.JMenuItem();
        sistema = new javax.swing.JMenu();
        usuario = new javax.swing.JMenuItem();
        desconectar = new javax.swing.JMenuItem();
        sair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("iNFO-Ti");

        lbUserLogged.setBackground(new java.awt.Color(255, 255, 255));
        lbUserLogged.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        lbUserLogged.setText("Usuário");
        lbUserLogged.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        menu.setBackground(new java.awt.Color(255, 255, 255));
        menu.setBorder(null);
        menu.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        menu.setPreferredSize(new java.awt.Dimension(189, 50));

        registros.setBackground(new java.awt.Color(255, 255, 255));
        registros.setBorder(null);
        registros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Registry.png"))); // NOI18N
        registros.setText("Cadastros");
        registros.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        registros.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        registros.setPreferredSize(new java.awt.Dimension(170, 50));

        pedidos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        pedidos.setBackground(new java.awt.Color(255, 255, 255));
        pedidos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        pedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/OS.png"))); // NOI18N
        pedidos.setText("Pedidos");
        pedidos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        pedidos.setPreferredSize(new java.awt.Dimension(200, 50));
        pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidosActionPerformed(evt);
            }
        });
        registros.add(pedidos);

        clientes.setBackground(new java.awt.Color(255, 255, 255));
        clientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Client.png"))); // NOI18N
        clientes.setText("Clientes");
        clientes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        clientes.setPreferredSize(new java.awt.Dimension(200, 50));
        clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesActionPerformed(evt);
            }
        });
        registros.add(clientes);

        produtos.setBackground(new java.awt.Color(255, 255, 255));
        produtos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        produtos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/produto.png"))); // NOI18N
        produtos.setText("Produtos");
        produtos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        produtos.setPreferredSize(new java.awt.Dimension(200, 50));
        produtos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtosActionPerformed(evt);
            }
        });
        registros.add(produtos);

        adicionais.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        adicionais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Report.png"))); // NOI18N
        adicionais.setText("Adicionais");
        adicionais.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        adicionais.setOpaque(true);
        adicionais.setPreferredSize(new java.awt.Dimension(200, 50));

        funcionarios.setBackground(new java.awt.Color(255, 255, 255));
        funcionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        funcionarios.setText("Funcionários");
        funcionarios.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        funcionarios.setPreferredSize(new java.awt.Dimension(200, 50));
        funcionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                funcionariosActionPerformed(evt);
            }
        });
        adicionais.add(funcionarios);

        registros.add(adicionais);

        menu.add(registros);

        fianceiro.setBackground(new java.awt.Color(255, 255, 255));
        fianceiro.setBorder(null);
        fianceiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Finance.png"))); // NOI18N
        fianceiro.setText("Financeiro");
        fianceiro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        fianceiro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        fianceiro.setPreferredSize(new java.awt.Dimension(170, 50));

        contasReceber.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        contasReceber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Payment.png"))); // NOI18N
        contasReceber.setText("Contas a receber");
        contasReceber.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        contasReceber.setPreferredSize(new java.awt.Dimension(200, 50));
        contasReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contasReceberActionPerformed(evt);
            }
        });
        fianceiro.add(contasReceber);

        menu.add(fianceiro);

        relatorios.setBackground(new java.awt.Color(255, 255, 255));
        relatorios.setBorder(null);
        relatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Report.png"))); // NOI18N
        relatorios.setText("Relatórios");
        relatorios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        relatorios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        relatorios.setPreferredSize(new java.awt.Dimension(170, 50));

        relatorioClientes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        relatorioClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Client.png"))); // NOI18N
        relatorioClientes.setText("Clientes");
        relatorioClientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        relatorioClientes.setOpaque(true);
        relatorioClientes.setPreferredSize(new java.awt.Dimension(200, 50));

        miAllClients.setBackground(new java.awt.Color(255, 255, 255));
        miAllClients.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        miAllClients.setText("Todos os itens");
        miAllClients.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        miAllClients.setPreferredSize(new java.awt.Dimension(200, 50));
        miAllClients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAllClientsActionPerformed(evt);
            }
        });
        relatorioClientes.add(miAllClients);

        relatorios.add(relatorioClientes);

        relatorioFuncionarios.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        relatorioFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Worker.png"))); // NOI18N
        relatorioFuncionarios.setText("Funcionários");
        relatorioFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        relatorioFuncionarios.setOpaque(true);
        relatorioFuncionarios.setPreferredSize(new java.awt.Dimension(200, 50));

        miAllWorkers.setBackground(new java.awt.Color(255, 255, 255));
        miAllWorkers.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        miAllWorkers.setText("Todos os itens");
        miAllWorkers.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        miAllWorkers.setPreferredSize(new java.awt.Dimension(200, 50));
        miAllWorkers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAllWorkersActionPerformed(evt);
            }
        });
        relatorioFuncionarios.add(miAllWorkers);

        miWorkersPeriod.setBackground(new java.awt.Color(255, 255, 255));
        miWorkersPeriod.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        miWorkersPeriod.setText("Período (data)");
        miWorkersPeriod.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        miWorkersPeriod.setPreferredSize(new java.awt.Dimension(200, 50));
        miWorkersPeriod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miWorkersPeriodActionPerformed(evt);
            }
        });
        relatorioFuncionarios.add(miWorkersPeriod);

        relatorios.add(relatorioFuncionarios);

        relatorioPedidos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        relatorioPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/OS.png"))); // NOI18N
        relatorioPedidos.setText("Pedidos");
        relatorioPedidos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        relatorioPedidos.setOpaque(true);
        relatorioPedidos.setPreferredSize(new java.awt.Dimension(200, 50));

        miAllOrders.setBackground(new java.awt.Color(255, 255, 255));
        miAllOrders.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        miAllOrders.setText("Todos os itens");
        miAllOrders.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        miAllOrders.setPreferredSize(new java.awt.Dimension(200, 50));
        miAllOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAllOrdersActionPerformed(evt);
            }
        });
        relatorioPedidos.add(miAllOrders);

        miOrdersPeriod.setBackground(new java.awt.Color(255, 255, 255));
        miOrdersPeriod.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        miOrdersPeriod.setText("Período (data)");
        miOrdersPeriod.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        miOrdersPeriod.setPreferredSize(new java.awt.Dimension(200, 50));
        miOrdersPeriod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miOrdersPeriodActionPerformed(evt);
            }
        });
        relatorioPedidos.add(miOrdersPeriod);

        relatorios.add(relatorioPedidos);

        menu.add(relatorios);

        sistema.setBackground(new java.awt.Color(255, 255, 255));
        sistema.setBorder(null);
        sistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/System.png"))); // NOI18N
        sistema.setText("Sistema");
        sistema.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        sistema.setPreferredSize(new java.awt.Dimension(150, 50));

        usuario.setBackground(new java.awt.Color(255, 255, 255));
        usuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/User.png"))); // NOI18N
        usuario.setText("Usuários");
        usuario.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        usuario.setPreferredSize(new java.awt.Dimension(200, 50));
        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });
        sistema.add(usuario);

        desconectar.setBackground(new java.awt.Color(255, 255, 255));
        desconectar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        desconectar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Logout.png"))); // NOI18N
        desconectar.setText("Desconectar");
        desconectar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        desconectar.setPreferredSize(new java.awt.Dimension(200, 50));
        desconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desconectarActionPerformed(evt);
            }
        });
        sistema.add(desconectar);

        sair.setBackground(new java.awt.Color(255, 255, 255));
        sair.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Exit.png"))); // NOI18N
        sair.setText("Sair");
        sair.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        sair.setPreferredSize(new java.awt.Dimension(200, 50));
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });
        sistema.add(sair);

        menu.add(sistema);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbUserLogged, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(465, Short.MAX_VALUE)
                .addComponent(lbUserLogged))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidosActionPerformed
//        os = new dlServiceOrders(this, false);
//        os.setVisible(true);
    }//GEN-LAST:event_pedidosActionPerformed

    private void clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesActionPerformed
        JdlClientes clientes = new JdlClientes(this, false);
        clientes.setVisible(true);
    }//GEN-LAST:event_clientesActionPerformed

    private void funcionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_funcionariosActionPerformed
//        workers = new dlWorkers(this, false);
//        workers.setVisible(true);

          JdlFuncionarios jdlFuncionarios = new JdlFuncionarios(this, rootPaneCheckingEnabled);
          jdlFuncionarios.setVisible(true);

    }//GEN-LAST:event_funcionariosActionPerformed

    private void produtosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtosActionPerformed
//        parts = new dlParts(this, false);
//        parts.setVisible(true);
    }//GEN-LAST:event_produtosActionPerformed

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
//        users = new dlUsers(this, false);
//        users.setVisible(true);
    }//GEN-LAST:event_usuarioActionPerformed

    private void desconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desconectarActionPerformed
        int disconnect = JOptionPane.showConfirmDialog(null, "Deseja desconectar-se do sistema?", "Desconectar", 0);
        if (disconnect == JOptionPane.YES_OPTION) {
            this.dispose();
            try {
                JfrLogin login = new JfrLogin();
                login.setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(JfrPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    }//GEN-LAST:event_desconectarActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        int exit = JOptionPane.showConfirmDialog(null, "Deseja fechar o sistema?", "Encerrar", 0);
        if (exit == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_sairActionPerformed

    private void contasReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contasReceberActionPerformed
//        payment = new dlPayment(this, false);
//        payment.setVisible(true);
    }//GEN-LAST:event_contasReceberActionPerformed

    private void miOrdersPeriodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miOrdersPeriodActionPerformed
//        orderParameters = new popupOrderParameters(this, true);
//        orderParameters.setVisible(true);
    }//GEN-LAST:event_miOrdersPeriodActionPerformed

    private void miAllOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAllOrdersActionPerformed
//        try {
//            JasperReport partsReport = JasperCompileManager.compileReport(getClass().getResourceAsStream("/logs/Orders_noparameters.jrxml"));
//            Map parameters = new HashMap();
//            JasperPrint print = JasperFillManager.fillReport(partsReport, parameters, DBConnect.getInstance().getConnection());
//            JasperViewer.viewReport(print, false);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }//GEN-LAST:event_miAllOrdersActionPerformed

    private void miWorkersPeriodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miWorkersPeriodActionPerformed
//        workerParameters = new popupWorkerParameters(this, true);
//        workerParameters.setVisible(true);
    }//GEN-LAST:event_miWorkersPeriodActionPerformed

    private void miAllWorkersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAllWorkersActionPerformed
//        try {
//            JasperReport partsReport = JasperCompileManager.compileReport(getClass().getResourceAsStream("/logs/Workers_noparameters.jrxml"));
//            Map parameters = new HashMap();
//            JasperPrint print = JasperFillManager.fillReport(partsReport, parameters, DBConnect.getInstance().getConnection());
//            JasperViewer.viewReport(print, false);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }//GEN-LAST:event_miAllWorkersActionPerformed

    private void miAllClientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAllClientsActionPerformed
//        try {
//            JasperReport partsReport = JasperCompileManager.compileReport(getClass().getResourceAsStream("/logs/Clients_noparameters.jrxml"));
//            Map parameters = new HashMap();
//            JasperPrint print = JasperFillManager.fillReport(partsReport, parameters, DBConnect.getInstance().getConnection());
//            JasperViewer.viewReport(print, false);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }//GEN-LAST:event_miAllClientsActionPerformed

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
            java.util.logging.Logger.getLogger(JfrPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfrPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfrPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfrPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfrPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu adicionais;
    private javax.swing.JMenuItem clientes;
    private javax.swing.JMenuItem contasReceber;
    private javax.swing.JMenuItem desconectar;
    private javax.swing.JMenu fianceiro;
    private javax.swing.JMenuItem funcionarios;
    private javax.swing.JLabel lbUserLogged;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenuItem miAllClients;
    private javax.swing.JMenuItem miAllOrders;
    private javax.swing.JMenuItem miAllWorkers;
    private javax.swing.JMenuItem miOrdersPeriod;
    private javax.swing.JMenuItem miWorkersPeriod;
    private javax.swing.JMenuItem pedidos;
    private javax.swing.JMenuItem produtos;
    private javax.swing.JMenu registros;
    private javax.swing.JMenu relatorioClientes;
    private javax.swing.JMenu relatorioFuncionarios;
    private javax.swing.JMenu relatorioPedidos;
    private javax.swing.JMenu relatorios;
    private javax.swing.JMenuItem sair;
    private javax.swing.JMenu sistema;
    private javax.swing.JMenuItem usuario;
    // End of variables declaration//GEN-END:variables
}
