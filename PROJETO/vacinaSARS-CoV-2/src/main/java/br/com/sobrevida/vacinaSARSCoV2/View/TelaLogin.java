package br.com.sobrevida.vacinaSARSCoV2.view;

import br.com.sobrevida.vacinaSARSCoV2.controller.UsuarioController;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author WERIKE
 */
public class TelaLogin extends javax.swing.JFrame {

    public TelaLogin() {
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

        imageFundo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Icon = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        loginBotao = new javax.swing.JButton();
        loginSenha = new javax.swing.JPasswordField();
        mostraSenha = new javax.swing.JTextField();
        boxMostraSenha = new javax.swing.JCheckBox();
        loginEmail = new javax.swing.JTextField();
        linkResetCadastro = new javax.swing.JLabel();
        linkCadastroUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setMaximumSize(new java.awt.Dimension(800, 510));
        setMinimumSize(new java.awt.Dimension(800, 510));
        setPreferredSize(new java.awt.Dimension(800, 510));
        setResizable(false);
        getContentPane().setLayout(null);

        imageFundo.setIcon(new javax.swing.ImageIcon("C:\\xampp\\htdocs\\Projeto_Vacina_Codiv19\\PROJETO\\vacinaSARS-CoV-2\\src\\main\\java\\br\\com\\sobrevida\\vacinaSARSCoV2\\View\\Image\\vacinaLogin2.png")); // NOI18N
        getContentPane().add(imageFundo);
        imageFundo.setBounds(260, -180, 2570, 710);

        jPanel1.setBackground(new java.awt.Color(228, 229, 232));
        jPanel1.setLayout(null);

        Icon.setIcon(new javax.swing.ImageIcon("C:\\xampp\\htdocs\\Projeto_Vacina_Codiv19\\PROJETO\\vacinaSARS-CoV-2\\src\\main\\java\\br\\com\\sobrevida\\vacinaSARSCoV2\\View\\Image\\vacinaLogin1.png")); // NOI18N
        jPanel1.add(Icon);
        Icon.setBounds(70, 10, 120, 120);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setText("LOGIN");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 11, 90, 40);

        jLabel5.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 135, 197));
        jLabel5.setText("Email address");
        jLabel5.setMaximumSize(new java.awt.Dimension(35, 17));
        jLabel5.setMinimumSize(new java.awt.Dimension(35, 17));
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 57, 80, 20);

        jLabel4.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 135, 197));
        jLabel4.setText("Password");
        jLabel4.setMaximumSize(new java.awt.Dimension(35, 17));
        jLabel4.setMinimumSize(new java.awt.Dimension(35, 17));
        jPanel2.add(jLabel4);
        jLabel4.setBounds(20, 130, 60, 20);

        loginBotao.setBackground(new java.awt.Color(204, 204, 255));
        loginBotao.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        loginBotao.setForeground(new java.awt.Color(51, 51, 255));
        loginBotao.setText("Login");
        loginBotao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginBotaoMouseClicked(evt);
            }
        });
        loginBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBotaoActionPerformed(evt);
            }
        });
        jPanel2.add(loginBotao);
        loginBotao.setBounds(120, 220, 75, 31);

        loginSenha.setBackground(new java.awt.Color(204, 204, 255));
        loginSenha.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        loginSenha.setForeground(new java.awt.Color(0, 102, 102));
        loginSenha.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        loginSenha.setOpaque(false);
        loginSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginSenhaKeyPressed(evt);
            }
        });
        jPanel2.add(loginSenha);
        loginSenha.setBounds(20, 150, 180, 30);

        mostraSenha.setBackground(new java.awt.Color(204, 204, 255));
        mostraSenha.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        mostraSenha.setForeground(new java.awt.Color(0, 102, 102));
        mostraSenha.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        mostraSenha.setOpaque(false);
        mostraSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostraSenhaActionPerformed(evt);
            }
        });
        mostraSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mostraSenhaKeyPressed(evt);
            }
        });
        jPanel2.add(mostraSenha);
        mostraSenha.setBounds(20, 150, 180, 30);

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
        boxMostraSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                boxMostraSenhaKeyPressed(evt);
            }
        });
        jPanel2.add(boxMostraSenha);
        boxMostraSenha.setBounds(20, 180, 110, 25);

        loginEmail.setBackground(new java.awt.Color(204, 204, 255));
        loginEmail.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        loginEmail.setForeground(new java.awt.Color(0, 102, 102));
        loginEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        loginEmail.setOpaque(false);
        loginEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginEmailActionPerformed(evt);
            }
        });
        loginEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginEmailKeyPressed(evt);
            }
        });
        jPanel2.add(loginEmail);
        loginEmail.setBounds(20, 80, 180, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 150, 220, 270);

        linkResetCadastro.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        linkResetCadastro.setForeground(new java.awt.Color(51, 51, 255));
        linkResetCadastro.setText("Reset password");
        linkResetCadastro.setPreferredSize(new java.awt.Dimension(35, 17));
        linkResetCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                linkResetCadastroMouseClicked(evt);
            }
        });
        jPanel1.add(linkResetCadastro);
        linkResetCadastro.setBounds(20, 420, 110, 40);

        linkCadastroUsuario.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        linkCadastroUsuario.setForeground(new java.awt.Color(51, 51, 255));
        linkCadastroUsuario.setText("Create free account");
        linkCadastroUsuario.setPreferredSize(new java.awt.Dimension(35, 17));
        linkCadastroUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                linkCadastroUsuarioMouseClicked(evt);
            }
        });
        jPanel1.add(linkCadastroUsuario);
        linkCadastroUsuario.setBounds(135, 420, 110, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 260, 530);

        getAccessibleContext().setAccessibleDescription("Login");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mostraSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostraSenhaActionPerformed

    }//GEN-LAST:event_mostraSenhaActionPerformed

    private void loginBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBotaoActionPerformed
        String email = (loginEmail.getText());
        String senha = new String(loginSenha.getPassword());
        
        UsuarioController usuarioController = new UsuarioController();  
        boolean logar = usuarioController.logar(email, senha, false);
        
        if(logar == true){
            TelaLogin.this.dispose();
            new TelaLogin().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Carregar1 carregar1 = new Carregar1();
            carregar1.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "O nome de usuário e a senha "
                + "que você digitou não\n batem com nossos registros. "
                + "Por favor, verifique e\n tente novamente." 
                ,"Login Inválido", JOptionPane.WARNING_MESSAGE
            );
            loginEmail.setText("");
            loginSenha.setText("");
            mostraSenha.setText("");
        }
    }//GEN-LAST:event_loginBotaoActionPerformed

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

    }//GEN-LAST:event_loginEmailActionPerformed

    private void linkCadastroUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_linkCadastroUsuarioMouseClicked
        TelaLogin.this.dispose();
        new TelaLogin().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TelaLoginCadastro telaLoginCadastro = new TelaLoginCadastro();
        telaLoginCadastro.setVisible(true);
    }//GEN-LAST:event_linkCadastroUsuarioMouseClicked
    private void loginBotaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBotaoMouseClicked

    }//GEN-LAST:event_loginBotaoMouseClicked

    private void loginSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginSenhaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            String email = (loginEmail.getText());
            String senha = new String(loginSenha.getPassword());

            UsuarioController usuarioController = new UsuarioController();  
            boolean logar = usuarioController.logar(email, senha, false);

            if(logar == true){
                TelaLogin.this.dispose();
                new TelaLogin().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Carregar1 carregar1 = new Carregar1();
                carregar1.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "O nome de usuário e a senha "
                    + "que você digitou não\n batem com nossos registros. "
                    + "Por favor, verifique e\n tente novamente." 
                    ,"Login Inválido", JOptionPane.WARNING_MESSAGE
                );
                loginEmail.setText("");
                loginSenha.setText("");
                mostraSenha.setText("");
            }
        }
    }//GEN-LAST:event_loginSenhaKeyPressed

    private void mostraSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mostraSenhaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            String email = (loginEmail.getText());
            String senha = new String(loginSenha.getPassword());

            UsuarioController usuarioController = new UsuarioController();  
            boolean logar = usuarioController.logar(email, senha, false);

            if(logar == true){
                TelaLogin.this.dispose();
                new TelaLogin().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Carregar1 carregar1 = new Carregar1();
                carregar1.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "O nome de usuário e a senha "
                    + "que você digitou não\n batem com nossos registros. "
                    + "Por favor, verifique e\n tente novamente." 
                    ,"Login Inválido", JOptionPane.WARNING_MESSAGE
                );
                loginEmail.setText("");
                loginSenha.setText("");
                mostraSenha.setText("");
            }
        }
    }//GEN-LAST:event_mostraSenhaKeyPressed

    private void boxMostraSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxMostraSenhaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            String email = (loginEmail.getText());
            String senha = new String(loginSenha.getPassword());

            UsuarioController usuarioController = new UsuarioController();  
            boolean logar = usuarioController.logar(email, senha, false);

            if(logar == true){
                TelaLogin.this.dispose();
                new TelaLogin().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Carregar1 carregar1 = new Carregar1();
                carregar1.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "O nome de usuário e a senha "
                    + "que você digitou não\n batem com nossos registros. "
                    + "Por favor, verifique e\n tente novamente." 
                    ,"Login Inválido", JOptionPane.WARNING_MESSAGE
                );
                loginEmail.setText("");
                loginSenha.setText("");
                mostraSenha.setText("");
            }
        }
    }//GEN-LAST:event_boxMostraSenhaKeyPressed

    private void loginEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginEmailKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            String email = (loginEmail.getText());
            String senha = new String(loginSenha.getPassword());

            UsuarioController usuarioController = new UsuarioController();  
            boolean logar = usuarioController.logar(email, senha, false);

            if(logar == true){
                TelaLogin.this.dispose();
                new TelaLogin().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Carregar1 carregar1 = new Carregar1();
                carregar1.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "O nome de usuário e a senha "
                    + "que você digitou não\n batem com nossos registros. "
                    + "Por favor, verifique e\n tente novamente." 
                    ,"Login Inválido", JOptionPane.WARNING_MESSAGE
                );
                loginEmail.setText("");
                loginSenha.setText("");
                mostraSenha.setText("");
            }
        }
    }//GEN-LAST:event_loginEmailKeyPressed

    private void linkResetCadastroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_linkResetCadastroMouseClicked
        TelaLogin.this.dispose();
        new TelaLogin().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TelaLoginReset telaLoginReset = new TelaLoginReset();
        telaLoginReset.setVisible(true);
    }//GEN-LAST:event_linkResetCadastroMouseClicked
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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Icon;
    private javax.swing.JCheckBox boxMostraSenha;
    private javax.swing.JLabel imageFundo;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel linkCadastroUsuario;
    private javax.swing.JLabel linkResetCadastro;
    private javax.swing.JButton loginBotao;
    private javax.swing.JTextField loginEmail;
    private javax.swing.JPasswordField loginSenha;
    private javax.swing.JTextField mostraSenha;
    // End of variables declaration//GEN-END:variables
}
