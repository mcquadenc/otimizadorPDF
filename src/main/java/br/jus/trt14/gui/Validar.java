/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jus.trt14.gui;

import br.jus.trt14.constant.Constant;
import br.jus.trt14.converter.security.ValidacaoDocumento;
import br.jus.trt14.events.DragableTextField;
import br.jus.trt14.model.DefaultOptionPane;
import br.jus.trt14.model.OptionPane;
import br.jus.trt14.model.Signatario;
import br.jus.trt14.tools.Utils;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.concurrent.Callable;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * 
 */
public class Validar extends FrameBasico {

    /**
     * Creates new form Validar
     */
    private String[] columnNames = {"PDF/A", "Assinado", "Validade", "Resultado"};

    private Object[][] data = {};

    private DefaultTableModel model = new DefaultTableModel(data, columnNames);

    public JFileChooser fc = new JFileChooser();
    public static OptionPane optionPane = new DefaultOptionPane();

    public Validar() {
        initComponents();
        jTValidacao.setRowHeight(40);
        this.position();
        this.setVisible(true);

        final JTextField field = jTFEntradaPath;        
        final Validar v = this;
        DragableTextField dragableTextField = new DragableTextField(field, true, new Callable<Void>() {
            @Override
            public Void call() throws Exception {     
                v.setArquivo(field.getText());
                return null;
            }
        });

        jTFEntradaPath.setDropTarget(dragableTextField);
        jPEntrada.setDropTarget(dragableTextField);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPEntrada = new javax.swing.JPanel();
        jLEInforme = new javax.swing.JLabel();
        jTFEntradaPath = new javax.swing.JTextField();
        jBAbrirDocumentoPDFEntrada = new javax.swing.JButton();
        jPEntrada1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTValidacao = new JTable(model) {
            //  Returning the Class of each column will allow different
            //  renderers to be used based on Class
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
            public String getToolTipText(MouseEvent e) {
                String tip = "";
                java.awt.Point p = e.getPoint();
                int rowIndex = rowAtPoint(p);
                int colIndex = columnAtPoint(p);

                try {
                    switch (colIndex) {
                        case 0:
                        tip = "<html>Verifica se o documento está no formato PDF/A.<br>O PDF/A é um formato padronizado (ISO 19005/1995), criado para arquivamento <br>"
                        + "e ideal para para sistemas eletrônicos diversos.</html>";
                        break;
                        case 1:
                        tip = "<html>Verifica se o documento foi assinado digitalmente.<br>"
                        + "A assinatura digital permite adicionar autenticidade e integridade.<br>"
                        + "Autenticidade significa que o signatário realmente assinou esse documento(e não alguém se passando por ele)<br>"
                        + "Integridade significa que o documento não foi alterado desde que foi assinado.</html>";
                        break;
                        case 2:
                        tip = "<html>Verifica 3 critérios:<br>1-Os certificados foram emitidos pela ICP-Brasil ou pelo TRT 14?<br>"
                        + "2-O certificado é válido atualmente?<br>"
                        + "3-A assinatura é íntegra? </html>";
                        break;
                        case 3:
                        tip = "<html>Verifica se as condições anteriores foram atendidas</html>";
                        break;

                    }

                } catch (RuntimeException e1) {
                    //catch null pointer exception if mouse is over an empty line
                }

                return tip;
            }
        };
        jPEntrada2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTSignatarios = new javax.swing.JTable();
        jLSuperior = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("JT - Validador de documentos");

        jPEntrada.setBorder(javax.swing.BorderFactory.createTitledBorder("Entrada"));

        jLEInforme.setText("Informe o arquivo (arraste ou solte) que você deseja validar.");

        jTFEntradaPath.setEditable(false);
        jTFEntradaPath.setToolTipText("Você pode arrastar e soltar um PDF aqui");
        jTFEntradaPath.setDragEnabled(true);

        jBAbrirDocumentoPDFEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gnome_folder_open_16.png"))); // NOI18N
        jBAbrirDocumentoPDFEntrada.setText("Abrir");
        jBAbrirDocumentoPDFEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAbrirDocumentoPDFEntradaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPEntradaLayout = new javax.swing.GroupLayout(jPEntrada);
        jPEntrada.setLayout(jPEntradaLayout);
        jPEntradaLayout.setHorizontalGroup(
            jPEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEntradaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPEntradaLayout.createSequentialGroup()
                        .addComponent(jLEInforme, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                        .addGap(67, 67, 67))
                    .addGroup(jPEntradaLayout.createSequentialGroup()
                        .addComponent(jTFEntradaPath)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBAbrirDocumentoPDFEntrada)
                        .addContainerGap())))
        );
        jPEntradaLayout.setVerticalGroup(
            jPEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEntradaLayout.createSequentialGroup()
                .addComponent(jLEInforme)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFEntradaPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBAbrirDocumentoPDFEntrada))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPEntrada1.setBorder(javax.swing.BorderFactory.createTitledBorder("Validação"));

        jTValidacao.setModel(model
        );
        jTValidacao.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(jTValidacao);

        javax.swing.GroupLayout jPEntrada1Layout = new javax.swing.GroupLayout(jPEntrada1);
        jPEntrada1.setLayout(jPEntrada1Layout);
        jPEntrada1Layout.setHorizontalGroup(
            jPEntrada1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEntrada1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPEntrada1Layout.setVerticalGroup(
            jPEntrada1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEntrada1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPEntrada2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalhes (clique duplo para detalhes do signatário)"));

        jTSignatarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Signatário", "CPF/CNPJ", "Data", "Certificado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTSignatarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTSignatariosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTSignatarios);
        if (jTSignatarios.getColumnModel().getColumnCount() > 0) {
            jTSignatarios.getColumnModel().getColumn(1).setMinWidth(100);
            jTSignatarios.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTSignatarios.getColumnModel().getColumn(1).setMaxWidth(100);
            jTSignatarios.getColumnModel().getColumn(2).setMinWidth(100);
            jTSignatarios.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTSignatarios.getColumnModel().getColumn(2).setMaxWidth(100);
            jTSignatarios.getColumnModel().getColumn(3).setMinWidth(0);
            jTSignatarios.getColumnModel().getColumn(3).setPreferredWidth(0);
            jTSignatarios.getColumnModel().getColumn(3).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPEntrada2Layout = new javax.swing.GroupLayout(jPEntrada2);
        jPEntrada2.setLayout(jPEntrada2Layout);
        jPEntrada2Layout.setHorizontalGroup(
            jPEntrada2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEntrada2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPEntrada2Layout.setVerticalGroup(
            jPEntrada2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEntrada2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLSuperior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trt14_logo_small.png"))); // NOI18N
        jLSuperior.setAlignmentX(0.5F);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("PDF");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Otimizador");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(0, 365, Short.MAX_VALUE))
                    .addComponent(jPEntrada1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPEntrada2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel4)))
                .addGap(41, 41, 41)
                .addComponent(jPEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPEntrada1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPEntrada2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPEntrada1.getAccessibleContext().setAccessibleName("Validação do documento");
        jPEntrada2.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAbrirDocumentoPDFEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAbrirDocumentoPDFEntradaActionPerformed
        FileFilter ff = new FileNameExtensionFilter("PDF (Portable Document Format)", "pdf");
        fc.setFileFilter(ff);
        fc.setAcceptAllFileFilterUsed(false);
        int opt = fc.showOpenDialog(this);
        if (opt == 0) {
            File f = fc.getSelectedFile();
            setArquivo(f.getPath());
        }


    }//GEN-LAST:event_jBAbrirDocumentoPDFEntradaActionPerformed

    private void jTSignatariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTSignatariosMouseClicked
        JTable table = (JTable) evt.getSource();
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        model.getRowCount();

        Point p = evt.getPoint();
        int row = table.rowAtPoint(p);
        int selectedRow = table.convertRowIndexToModel(row);

        if (evt.getClickCount() == 2) {
            X509Certificate certificate = (X509Certificate) model.getValueAt(selectedRow, model.getColumnCount() - 1);
            try {
                byte[] buf = certificate.getEncoded();
                String cerOutput = Constant.PATH_BASE_FILE + System.nanoTime() + ".cer";
                FileOutputStream os = new FileOutputStream(cerOutput);

                Writer wr = new OutputStreamWriter(os, Charset.forName("UTF-8"));
                wr.write(new sun.misc.BASE64Encoder().encode(buf));
                wr.flush();
                os.close();
                Utils.openFolder(cerOutput);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_jTSignatariosMouseClicked

    public void setArquivo(String file) {
        DefaultTableModel sigs = (DefaultTableModel) jTSignatarios.getModel();
        sigs.setRowCount(0);
        model.setRowCount(0);

        jTFEntradaPath.setText(file);

        try {
            int numberOfPages = Utils.getPageCount(jTFEntradaPath.getText());
            if (numberOfPages > 0) {
                ValidacaoDocumento documento = new ValidacaoDocumento(jTFEntradaPath.getText());
                // {"PDF/A", "Assinado", "Íntegro", "Resultado"};
                model.addRow(new Object[]{Utils.getIcon(documento.isPdfa()), Utils.getIcon(documento.isAssinado()), Utils.getIcon(documento.isIntegro()), Utils.getIcon(documento.isResultado())});
                List<Signatario> signatarios = documento.getSignatarios();
                for (Signatario signatario : signatarios) {
                    sigs.addRow(new Object[]{signatario.getName(), signatario.getCpfCnpj(), signatario.getDate(), signatario.getCertificate()});
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Validar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAbrirDocumentoPDFEntrada;
    private javax.swing.JLabel jLEInforme;
    private javax.swing.JLabel jLSuperior;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPEntrada;
    private javax.swing.JPanel jPEntrada1;
    private javax.swing.JPanel jPEntrada2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTFEntradaPath;
    private javax.swing.JTable jTSignatarios;
    private javax.swing.JTable jTValidacao;
    // End of variables declaration//GEN-END:variables

    public void iniciarArgumentos(List<String> listaArquivos) {
        String arq = listaArquivos.get(0);
        setArquivo(arq);
        this.setVisible(true);
    }
}
