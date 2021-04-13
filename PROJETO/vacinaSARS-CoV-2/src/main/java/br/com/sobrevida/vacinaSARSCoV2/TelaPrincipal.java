/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sobrevida.vacinaSARSCoV2;

import javax.swing.JFrame;

/**
 *
 * @author WERIKE
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        //SE ALTO AJUSTA AO TAMANHO DO MONITOR
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        //ALTERANDO O ICONE PADRAO DO JAVA
        Utilitario utilitario = new Utilitario();
        utilitario.inserirIcone(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktop = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnCidadaoCadastro = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        btnTiposVacinas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vacinação SARS-COV-2");
        setResizable(false);

        jDesktop.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jDesktop.setPreferredSize(new java.awt.Dimension(720, 480));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\xampp\\htdocs\\Projeto_Vacina_Codiv19\\PROJETO\\vacinaSARS-CoV-2\\src\\main\\java\\images\\painel1.jpg")); // NOI18N
        jDesktop.add(jLabel1);
        jLabel1.setBounds(-640, -10, 1920, 680);

        jMenu1.setText("Cadastro");

        btnCidadaoCadastro.setText("Cidadão");
        btnCidadaoCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCidadaoCadastroActionPerformed(evt);
            }
        });
        jMenu1.add(btnCidadaoCadastro);

        jMenuItem1.setText("Vacinação");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Vacinas");

        btnTiposVacinas.setText("Tipos de vacinas");
        btnTiposVacinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTiposVacinasActionPerformed(evt);
            }
        });
        jMenu2.add(btnTiposVacinas);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktop, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(1280, 721));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCidadaoCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCidadaoCadastroActionPerformed
        
        //CHAMANDO A CLASSE "CIDADAOCADASTRO.JAVA"
        CidadaoCadastro cidadaoCadastro = new CidadaoCadastro();
        
        //ADICIONANDO O OBJETO "cidadaoCadastro" AO OBJETO "jDesktop"
        jDesktop.add(cidadaoCadastro);
        
        //DEPOIS DE ADICIONAR, TORNAR A CLASSE VISIVEL
        cidadaoCadastro.setVisible(true);
        
    }//GEN-LAST:event_btnCidadaoCadastroActionPerformed

    private void btnTiposVacinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTiposVacinasActionPerformed
       
        //CHAMANDO A CLASSE "TipoVacinaCadastro.java"
        TipoVacinaCadastro tipoVacinaCadastro = new TipoVacinaCadastro();
        
        //ADICIONANDO O OBJETO "TipoVacinaCadastro" AO OBJETO "jDesktop"
        jDesktop.add(tipoVacinaCadastro);
        
        //DEPOIS DE ADICIONAR, TORNAR A CLASSE VISIVEL
        tipoVacinaCadastro.setVisible(true);
        
    }//GEN-LAST:event_btnTiposVacinasActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnCidadaoCadastro;
    private javax.swing.JMenuItem btnTiposVacinas;
    private javax.swing.JDesktopPane jDesktop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
