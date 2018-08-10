package telas;

import apoio.Criptografia;
import apoio.HibernateUtil;
import entidades.Usuario;
import static java.awt.event.KeyEvent.VK_ENTER;
import static java.awt.event.KeyEvent.VK_TAB;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.hibernate.Session;

public class JfrLogin extends javax.swing.JFrame {
    
    Session sessao = HibernateUtil.getSessionFactory().openSession(); 
     List resultado = null;

    public JfrLogin() throws ClassNotFoundException {
        initComponents();           
    }
    
    public void login(){
        JfrPrincipal tela = new JfrPrincipal();
        tela.setVisible(true);
        this.setVisible(false);
        Criptografia c = new Criptografia();

        if (jtfUsuario.getText() == null || jtfSenha.getText() == null) {
            JOptionPane.showMessageDialog(this, "Preencha os dois campos!");
        } else {
            org.hibernate.Query q = sessao.createQuery("select nome,senha from Usuario");
            resultado = q.list();
            System.out.println(resultado.toString());
            for (Object o : resultado) {
                Usuario user = (Usuario) o;
                if (jtfUsuario.getText() == user.getNome() && c.criptografa(jtfSenha.getText()) == user.getSenha()) {
                    JfrPrincipal telaPrincipal = new JfrPrincipal();
                    telaPrincipal.setVisible(true);
                }
            }

        }
//        String sql = "Select * from login where usuario = ? and senha = ?";
//        try{            
//            pst = con.prepareStatement(sql);
//            pst.setString(1,jtfUsuario.getText());
//            String senha = lDao.criptografa(jtfSenha.getText());
//            pst.setString(2,senha);            
//            rs = pst.executeQuery();
//            if (rs.next()) {
//                    FrmPrincipal tela = new FrmPrincipal();
//                    tela.setVisible(true);
//                    this.dispose();
//            } else {
//                JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!");
//                jtfUsuario.setText("");
//                jtfSenha.setText("");
//                jtfUsuario.requestFocus();
//            }
//        }catch(SQLException erro){
//            JOptionPane.showMessageDialog(null, "Erro no Banco de Dados!");
//        }          
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSair = new javax.swing.JButton();
        btnAcessar = new javax.swing.JButton();
        jtfUsuario = new javax.swing.JTextField();
        jtfSenha = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fundo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        getContentPane().setLayout(null);

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Exit.png"))); // NOI18N
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair);
        btnSair.setBounds(200, 200, 80, 60);

        btnAcessar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/aceitar.png"))); // NOI18N
        btnAcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcessarActionPerformed(evt);
            }
        });
        btnAcessar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAcessarKeyPressed(evt);
            }
        });
        getContentPane().add(btnAcessar);
        btnAcessar.setBounds(100, 200, 80, 60);

        jtfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfUsuarioActionPerformed(evt);
            }
        });
        jtfUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfUsuarioKeyPressed(evt);
            }
        });
        getContentPane().add(jtfUsuario);
        jtfUsuario.setBounds(100, 100, 190, 20);

        jtfSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfSenhaKeyPressed(evt);
            }
        });
        getContentPane().add(jtfSenha);
        jtfSenha.setBounds(100, 150, 190, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Client.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 70, 50, 60);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/senha.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 140, 50, 50);

        fundo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(fundo);
        fundo.setBounds(10, 10, 330, 290);

        jLabel3.setFont(new java.awt.Font("Segoe UI Historic", 2, 24)); // NOI18N
        jLabel3.setText("iNFO-Ti");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(130, 30, 90, 40);

        setSize(new java.awt.Dimension(369, 351));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcessarActionPerformed
        login();
    }//GEN-LAST:event_btnAcessarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void jtfUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfUsuarioKeyPressed
        if (evt.getKeyChar() == VK_ENTER) {
            jtfSenha.requestFocus();
        }
        if (evt.getKeyChar() == VK_TAB){
            jtfSenha.requestFocus();
        }
    }//GEN-LAST:event_jtfUsuarioKeyPressed

    private void jtfSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfSenhaKeyPressed
        if (evt.getKeyChar() == VK_ENTER) {
            btnAcessar.requestFocus();
        }
        if (evt.getKeyChar() == VK_TAB) {
            btnAcessar.requestFocus();
        }
    }//GEN-LAST:event_jtfSenhaKeyPressed

    private void btnAcessarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAcessarKeyPressed
        if (evt.getKeyChar() == VK_ENTER) {
            login();
        }
    }//GEN-LAST:event_btnAcessarKeyPressed

    private void jtfUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(JfrLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfrLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfrLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfrLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JfrLogin().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JfrLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcessar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel fundo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jtfSenha;
    private javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables
}