/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sobrevida.vacinaSARSCoV2;

import javax.swing.JOptionPane;

/**
 *
 * @author WERIKE
 */
public class TelaLoginCadastro extends javax.swing.JFrame {

    /** Creates new form TelaLogin */
    public TelaLoginCadastro() {
        initComponents();
        setLocationRelativeTo(null);
        
        //ALTERANDO O ICONE PADRAO DO JAVA
        Utilitario utilitario = new Utilitario();
        utilitario.inserirIcone(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        loginSenha1 = new javax.swing.JPasswordField();
        mostraSenha1 = new javax.swing.JTextField();
        loginSenha = new javax.swing.JPasswordField();
        mostraSenha = new javax.swing.JTextField();
        boxMostraSenha = new javax.swing.JCheckBox();
        loginEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sign up");
        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(800, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(228, 229, 232));
        jPanel1.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\xampp\\htdocs\\Projeto_Vacina_Codiv19\\PROJETO\\vacinaSARS-CoV-2\\src\\main\\java\\images\\vacinaLogin1.png")); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(62, 10, 120, 120);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(220, 270));
        jPanel2.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setText("Sign up");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 11, 90, 40);

        jLabel5.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 135, 197));
        jLabel5.setText("Username");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 57, 60, 17);

        jLabel4.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 135, 197));
        jLabel4.setText("Confirm Password");
        jLabel4.setMaximumSize(new java.awt.Dimension(35, 17));
        jLabel4.setMinimumSize(new java.awt.Dimension(35, 17));
        jPanel2.add(jLabel4);
        jLabel4.setBounds(20, 160, 110, 20);

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 255));
        jButton1.setText("Sign up");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(125, 240, 80, 31);

        loginSenha1.setBackground(new java.awt.Color(204, 204, 255));
        loginSenha1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        loginSenha1.setOpaque(false);
        jPanel2.add(loginSenha1);
        loginSenha1.setBounds(20, 180, 180, 30);

        mostraSenha1.setBackground(new java.awt.Color(204, 204, 255));
        mostraSenha1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        mostraSenha1.setOpaque(false);
        mostraSenha1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostraSenha1ActionPerformed(evt);
            }
        });
        jPanel2.add(mostraSenha1);
        mostraSenha1.setBounds(20, 180, 180, 30);

        loginSenha.setBackground(new java.awt.Color(204, 204, 255));
        loginSenha.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        loginSenha.setOpaque(false);
        jPanel2.add(loginSenha);
        loginSenha.setBounds(20, 130, 180, 30);

        mostraSenha.setBackground(new java.awt.Color(204, 204, 255));
        mostraSenha.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        mostraSenha.setOpaque(false);
        mostraSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostraSenhaActionPerformed(evt);
            }
        });
        jPanel2.add(mostraSenha);
        mostraSenha.setBounds(20, 130, 180, 30);

        boxMostraSenha.setBackground(new java.awt.Color(204, 204, 255));
        boxMostraSenha.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        boxMostraSenha.setForeground(new java.awt.Color(0, 135, 197));
        boxMostraSenha.setText("Show password");
        boxMostraSenha.setMaximumSize(new java.awt.Dimension(35, 17));
        boxMostraSenha.setMinimumSize(new java.awt.Dimension(35, 17));
        boxMostraSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxMostraSenhaActionPerformed(evt);
            }
        });
        jPanel2.add(boxMostraSenha);
        boxMostraSenha.setBounds(20, 210, 110, 25);

        loginEmail.setBackground(new java.awt.Color(204, 204, 255));
        loginEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        loginEmail.setOpaque(false);
        loginEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginEmailActionPerformed(evt);
            }
        });
        jPanel2.add(loginEmail);
        loginEmail.setBounds(20, 80, 180, 30);

        jLabel7.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 135, 197));
        jLabel7.setText("Password");
        jLabel7.setMaximumSize(new java.awt.Dimension(35, 17));
        jLabel7.setMinimumSize(new java.awt.Dimension(35, 17));
        jPanel2.add(jLabel7);
        jLabel7.setBounds(20, 110, 60, 20);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(12, 150, 220, 280);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(540, 0, 260, 500);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\xampp\\htdocs\\Projeto_Vacina_Codiv19\\PROJETO\\vacinaSARS-CoV-2\\src\\main\\java\\images\\vacinaLogin2.png")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-370, -210, 2570, 710);

        getAccessibleContext().setAccessibleDescription("Login");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mostraSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostraSenhaActionPerformed
        //nome.setText("");
    }//GEN-LAST:event_mostraSenhaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String senha = new String(loginSenha.getPassword());
        
        if(boxMostraSenha.isSelected()){
            if(("user".equals(loginEmail.getText())) && (senha.equals("123"))){ 
                TelaLoginCadastro.this.dispose();
                Carregar1 carregar1 = new Carregar1();
                carregar1.setVisible(true);        
            }else{
                JOptionPane.showMessageDialog(null, "O nome de usuário e a senha "
                        + "que você digitou não\n batem com nossos registros. "
                        + "Por favor, verifique e\n tente novamente." 
                    ,"Login Inválido", JOptionPane.WARNING_MESSAGE);

                mostraSenha.setText("");
                loginSenha.setText("");
            }
        }
        
        if(("user".equals(loginEmail.getText())) && ("123".equals(senha))){    
            /* 
            COMANDO PARA TESTE!!!
            
            String email = loginEmail.getText();
            String senha = loginSenha.getText();
            
            JOptionPane.showMessageDialog(null, "E-Mail: "+email
                +"\nSenha: "+senha
                ,"Confirmação de cadastro", JOptionPane.PLAIN_MESSAGE
            );
            */
            
            TelaLoginCadastro.this.dispose();
            Carregar1 carregar1 = new Carregar1();
            carregar1.setVisible(true);            
        }else{
            JOptionPane.showMessageDialog(null, "O nome de usuário e a senha "
                    + "que você digitou não\n batem com nossos registros. "
                    + "Por favor, verifique e\n tente novamente." 
                ,"Login Inválido", JOptionPane.WARNING_MESSAGE);
            
            mostraSenha.setText("");
            loginSenha.setText("");
        }   
    }//GEN-LAST:event_jButton1ActionPerformed

    private void boxMostraSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxMostraSenhaActionPerformed
        String senha = new String(loginSenha.getPassword());
        if(boxMostraSenha.isSelected()){
            mostraSenha.setVisible(true);
            mostraSenha.setText(senha);
            loginSenha.setVisible(false);
        }else{
            mostraSenha.setVisible(false);
            loginSenha.setVisible(true);
        }
    }//GEN-LAST:event_boxMostraSenhaActionPerformed

    private void loginEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginEmailActionPerformed

    private void mostraSenha1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostraSenha1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mostraSenha1ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLoginCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLoginCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLoginCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLoginCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLoginCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox boxMostraSenha;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField loginEmail;
    private javax.swing.JPasswordField loginSenha;
    private javax.swing.JPasswordField loginSenha1;
    private javax.swing.JTextField mostraSenha;
    private javax.swing.JTextField mostraSenha1;
    // End of variables declaration//GEN-END:variables

}