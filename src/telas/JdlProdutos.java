package telas;

import dao.Dao;
import dao.PermissaoDao;
import dao.ProdutosDao;
import entidades.Produto;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import static telas.JfrPrincipal.permissao;

public class JdlProdutos extends javax.swing.JDialog {

    ProdutosDao produtosDao = new ProdutosDao();
    PermissaoDao permissaoDao = new PermissaoDao();
    Produto produto = new Produto();
    Dao d = new Dao();
    ProdutosDao pDao = new ProdutosDao();
    NodeList listaProdutos;
    int tamanhoLista;

    public JdlProdutos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        String botaopressionado = "novo";
        produtosDao.populaProduto(tblProdutos);
        permissaoDao.aplicaPermissao(this, permissao, botoes(),1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Botoes = new javax.swing.JPanel();
        btnSair = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnXml = new javax.swing.JButton();
        btnImportarXml = new javax.swing.JButton();
        Cadastro1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txfBuscar1 = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Produtos");

        Botoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/sair.png"))); // NOI18N
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/editar.png"))); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/adicionar.png"))); // NOI18N
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/cancelar.png"))); // NOI18N
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnXml.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/exporta_32.png"))); // NOI18N
        btnXml.setText("Exportar XML");
        btnXml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXmlActionPerformed(evt);
            }
        });

        btnImportarXml.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/importar_32.png"))); // NOI18N
        btnImportarXml.setText("Importar XML");
        btnImportarXml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarXmlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BotoesLayout = new javax.swing.GroupLayout(Botoes);
        Botoes.setLayout(BotoesLayout);
        BotoesLayout.setHorizontalGroup(
            BotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnXml)
                .addGap(18, 18, 18)
                .addComponent(btnImportarXml)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        BotoesLayout.setVerticalGroup(
            BotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnXml)
                        .addComponent(btnImportarXml))
                    .addComponent(btnExcluir)
                    .addComponent(btnEditar)
                    .addComponent(btnNovo)
                    .addComponent(btnSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Cadastro1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("Buscar :");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Search.png"))); // NOI18N

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblProdutos);

        javax.swing.GroupLayout Cadastro1Layout = new javax.swing.GroupLayout(Cadastro1);
        Cadastro1.setLayout(Cadastro1Layout);
        Cadastro1Layout.setHorizontalGroup(
            Cadastro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Cadastro1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Cadastro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Cadastro1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txfBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        Cadastro1Layout.setVerticalGroup(
            Cadastro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Cadastro1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(Cadastro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Cadastro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txfBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Botoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Cadastro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(Botoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cadastro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(789, 666));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public ArrayList<JButton> botoes() {
        ArrayList<JButton> botoes = new ArrayList<JButton>();
        botoes.add(btnNovo);
        botoes.add(btnEditar);
        botoes.add(btnExcluir);
        botoes.add(btnBuscar);
        return botoes;
    }

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed

        JdlCadastroProdutos jdlCadastroProdutos = new JdlCadastroProdutos(null, true);
        jdlCadastroProdutos.setVisible(true);

    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linha = tblProdutos.getSelectedRow();
        if (linha > -1) {
            int resposta = 0;
            int codProduto = Integer.valueOf(String.valueOf(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 0)));
            resposta = JOptionPane.showConfirmDialog(this, "Deseja Realmente Excluir?");
            if (resposta == JOptionPane.YES_OPTION) {
                produto = produtosDao.procurarPorId(codProduto);
                d.excluir(produto, produto.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um Produto!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            }
            produtosDao.populaProduto(tblProdutos);
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int linha = tblProdutos.getSelectedRow();
        if (linha > -1) {
            String botaopressionado = "editar";
            int codProd = Integer.valueOf(String.valueOf(tblProdutos.getValueAt(linha, 0)));
            Produto produto = produtosDao.procurarPorId(codProd);
            JdlCadastroProdutos telaProdutos = new JdlCadastroProdutos(null, false, produto, tblProdutos);
            telaProdutos.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Produto!", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnXmlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXmlActionPerformed
        int linha = tblProdutos.getSelectedRow();
        if (linha > -1) {
            int codProd = Integer.valueOf(String.valueOf(tblProdutos.getValueAt(linha, 0)));
            Produto p = produtosDao.procurarPorId(codProd);
            //criar XML           
            try {
                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                Document documentoXml = documentBuilder.newDocument();
                Element root = documentoXml.createElement("root");
                documentoXml.appendChild(root);                
                Element produto = documentoXml.createElement("produto");
                //criar e setar um atributo
                Attr id = documentoXml.createAttribute("id");
                id.setValue(String.valueOf(codProd));
                produto.setAttributeNode(id);
                root.appendChild(produto);
                
                Element nome = documentoXml.createElement("nome");
                //<nome> Mouse </nome>
                nome.appendChild(documentoXml.createTextNode(p.getNome()));
                produto.appendChild(nome);

                Element valor = documentoXml.createElement("valor");
                valor.appendChild(documentoXml.createTextNode(p.getValor().toPlainString()));
                produto.appendChild(valor);

                Element estoque = documentoXml.createElement("estoque");
                estoque.appendChild(documentoXml.createTextNode(String.valueOf(p.getEstoque())));
                produto.appendChild(estoque);

                Element descricao = documentoXml.createElement("descricao");
                descricao.appendChild(documentoXml.createTextNode(p.getDescricao()));
                produto.appendChild(descricao);

                Element marcaProduto = documentoXml.createElement("marcaProduto");
                marcaProduto.appendChild(documentoXml.createTextNode(String.valueOf(p.getIdmarcaProduto().getId())));
                produto.appendChild(marcaProduto);
                
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                
                //System.out.println(System.getProperty("user.home"));
                DOMSource documentoFonte = new DOMSource(documentoXml);
                StreamResult documentoFinal = new StreamResult(new File("C:\\Users\\bruno.bencke\\Desktop\\produto.xml"));
                transformer.transform(documentoFonte, documentoFinal);
                JOptionPane.showMessageDialog(null, "Exportado Com Sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);
                produtosDao.populaProduto(tblProdutos);
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(JdlProdutos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TransformerConfigurationException ex) {
                Logger.getLogger(JdlProdutos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TransformerException ex) {
                Logger.getLogger(JdlProdutos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Produto!", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnXmlActionPerformed

    private void btnImportarXmlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarXmlActionPerformed
        JFileChooser fc = new JFileChooser();
        DefaultTableModel tabelaProdutos = (DefaultTableModel) tblProdutos.getModel();
        int res = fc.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            File arquivo = fc.getSelectedFile();
            if (!arquivo.getName().endsWith(".xml")) {
                JOptionPane.showMessageDialog(null, "Apenas arquivos no formato .xml");
            } else {
                try {
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = factory.newDocumentBuilder();

                    Document doc = builder.parse(fc.getSelectedFile().getPath());
                    this.listaProdutos = doc.getElementsByTagName("produto");
                    this.tamanhoLista = listaProdutos.getLength();

                    for (int i = 0; i < tamanhoLista; i++) {
                        Node noProdutos = listaProdutos.item(i);

                        if (noProdutos.getNodeType() == Node.ELEMENT_NODE) {//caso for um elemento
                            Element elementoProduto = (Element) noProdutos;
                            Produto p = new Produto();
                            NodeList listaAtributos = elementoProduto.getChildNodes();
                            int tamanhoAtributos = listaAtributos.getLength();
                            for (int j = 0; j < tamanhoAtributos; j++) {
                                Node atributo = listaAtributos.item(j);

                                if (atributo.getNodeType() == Node.ELEMENT_NODE) {
                                    Element elementoAtributo = (Element) atributo;

                                    switch (elementoAtributo.getTagName()) {
                                        case "id":
                                            int id = Integer.parseInt(elementoAtributo.getTextContent());
                                            if (pDao.procurarPorId(id) != null) {
                                                p = pDao.procurarPorId(id);
                                            }
                                            p.setSituacao(true);
                                            break;

                                        case "estoque":
                                            double estoque = Double.parseDouble(elementoAtributo.getTextContent());
                                            p.setEstoque(p.getEstoque() + estoque);
                                            break;

                                        case "nome":
                                            p.setNome(elementoAtributo.getTextContent());
                                            break;

                                        case "descricao":
                                            p.setDescricao(elementoAtributo.getTextContent());
                                            break;

                                        case "valor":
                                            BigDecimal b = new BigDecimal(elementoAtributo.getTextContent());
                                            p.setValor(b);
                                            break;

                                        case "marcaProduto":
                                            p.setIdmarcaProduto(pDao.retornaObjetoMarcaProduto(Integer.parseInt(elementoAtributo.getTextContent())));
                                            break;
                                    }
                                }
                            }
                            pDao.saveOrUpdate(p, "Produto Lançado Por XML");
                            JOptionPane.showMessageDialog(null, "Importado Com Sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);
                            produtosDao.populaProduto(tblProdutos);
                        }
                    }
                } catch (ParserConfigurationException ex) {
                    Logger.getLogger(JdlProdutos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SAXException ex) {
                    Logger.getLogger(JdlProdutos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(JdlProdutos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    
    }//GEN-LAST:event_btnImportarXmlActionPerformed

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
            java.util.logging.Logger.getLogger(JdlProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdlProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdlProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdlProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JdlProdutos dialog = new JdlProdutos(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel Botoes;
    private javax.swing.JPanel Cadastro1;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnImportarXml;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnXml;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txfBuscar1;
    // End of variables declaration//GEN-END:variables
}
