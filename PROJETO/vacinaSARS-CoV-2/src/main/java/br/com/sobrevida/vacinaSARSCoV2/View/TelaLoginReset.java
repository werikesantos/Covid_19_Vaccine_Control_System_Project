package br.com.sobrevida.vacinaSARSCoV2.view;

import br.com.sobrevida.vacinaSARSCoV2.controller.UsuarioController;
import java.awt.event.KeyEvent;
import static java.lang.Thread.sleep;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author WERIKE
 */
public class TelaLoginReset extends javax.swing.JFrame {

    UsuarioController usuarioController = new UsuarioController();
    TelaLogin telaLogin = new TelaLogin();
    
    public TelaLoginReset() {
        initComponents();
        setLocationRelativeTo(null);
        
        //ALTERANDO O ICONE PADRAO DO JAVA
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/image/sobrevidaIcone1.png")).getImage());

        carga.setVisible(false);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        signUP = new javax.swing.JButton();
        loginSenha1 = new javax.swing.JPasswordField();
        mostraSenha1 = new javax.swing.JTextField();
        loginSenha = new javax.swing.JPasswordField();
        mostraSenha = new javax.swing.JTextField();
        boxMostraSenha = new javax.swing.JCheckBox();
        loginEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        carga = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sobrevida - Reset Password");
        setMaximumSize(new java.awt.Dimension(800, 510));
        setMinimumSize(new java.awt.Dimension(800, 510));
        setPreferredSize(new java.awt.Dimension(800, 510));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(228, 229, 232));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(231, 214, 214), 1, true));
        jPanel2.setMinimumSize(new java.awt.Dimension(220, 270));
        jPanel2.setLayout(null);

        jLabel5.setBackground(new java.awt.Color(116, 116, 134));
        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(70, 66, 85));
        jLabel5.setText("Email address");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(30, 20, 120, 16);

        jLabel4.setBackground(new java.awt.Color(116, 116, 134));
        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(70, 66, 85));
        jLabel4.setText("New password");
        jLabel4.setMaximumSize(new java.awt.Dimension(35, 17));
        jLabel4.setMinimumSize(new java.awt.Dimension(35, 17));
        jPanel2.add(jLabel4);
        jLabel4.setBounds(30, 140, 140, 20);

        signUP.setBackground(new java.awt.Color(226, 226, 235));
        signUP.setFont(new java.awt.Font("Dubai Medium", 1, 14)); // NOI18N
        signUP.setForeground(new java.awt.Color(75, 75, 91));
        signUP.setText("Sign up");
        signUP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUPActionPerformed(evt);
            }
        });
        jPanel2.add(signUP);
        signUP.setBounds(165, 200, 90, 40);

        loginSenha1.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        loginSenha1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        loginSenha1.setOpaque(false);
        loginSenha1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginSenha1KeyPressed(evt);
            }
        });
        jPanel2.add(loginSenha1);
        loginSenha1.setBounds(30, 160, 230, 30);

        mostraSenha1.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        mostraSenha1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        mostraSenha1.setOpaque(false);
        mostraSenha1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostraSenha1ActionPerformed(evt);
            }
        });
        mostraSenha1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mostraSenha1KeyPressed(evt);
            }
        });
        jPanel2.add(mostraSenha1);
        mostraSenha1.setBounds(30, 160, 230, 30);

        loginSenha.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        loginSenha.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        loginSenha.setOpaque(false);
        loginSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginSenhaKeyPressed(evt);
            }
        });
        jPanel2.add(loginSenha);
        loginSenha.setBounds(30, 100, 230, 30);

        mostraSenha.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
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
        mostraSenha.setBounds(30, 100, 230, 30);

        boxMostraSenha.setBackground(new java.awt.Color(255, 255, 255));
        boxMostraSenha.setFont(new java.awt.Font("Serif", 0, 13)); // NOI18N
        boxMostraSenha.setForeground(new java.awt.Color(113, 113, 122));
        boxMostraSenha.setText("Show password");
        boxMostraSenha.setMaximumSize(new java.awt.Dimension(35, 17));
        boxMostraSenha.setMinimumSize(new java.awt.Dimension(35, 17));
        boxMostraSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxMostraSenhaActionPerformed(evt);
            }
        });
        jPanel2.add(boxMostraSenha);
        boxMostraSenha.setBounds(32, 200, 120, 27);

        loginEmail.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
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
        loginEmail.setBounds(30, 40, 230, 30);

        jLabel7.setBackground(new java.awt.Color(116, 116, 134));
        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(70, 66, 85));
        jLabel7.setText("Password");
        jLabel7.setMaximumSize(new java.awt.Dimension(35, 17));
        jLabel7.setMinimumSize(new java.awt.Dimension(35, 17));
        jPanel2.add(jLabel7);
        jLabel7.setBounds(30, 80, 80, 20);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(260, 140, 300, 270);

        jLabel3.setBackground(new java.awt.Color(51, 44, 52));
        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(95, 101, 110));
        jLabel3.setText("FORGOT YOUR PASSWORD?");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(260, 100, 300, 40);

        jLabel6.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(48, 47, 61));
        jLabel6.setText("Return page");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6);
        jLabel6.setBounds(280, 410, 130, 40);

        carga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/carga1.gif"))); // NOI18N
        jPanel1.add(carga);
        carga.setBounds(635, 34, 40, 40);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo1.png"))); // NOI18N
        jPanel1.add(jLabel12);
        jLabel12.setBounds(28, 21, 450, 90);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/transparente.png"))); // NOI18N
        jPanel1.add(jLabel13);
        jLabel13.setBounds(110, 15, 600, 440);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/vacina.jpeg"))); // NOI18N
        jPanel1.add(jLabel14);
        jLabel14.setBounds(0, 0, 810, 510);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 800, 500);

        getAccessibleContext().setAccessibleDescription("Sobrevida - Reset Password");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void mostraSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostraSenhaActionPerformed
    }//GEN-LAST:event_mostraSenhaActionPerformed
    private void signUPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUPActionPerformed
        
        new Thread(){
            int i=0;
            
            public void run(){
                
                while(i<100){
                    i = i+5;
                    try{
                        carga.setVisible(true);
                        sleep(200);//600
                    }catch (Exception e){
                        
                    }
                }
        
                String email = (loginEmail.getText());
                String senha = new String(loginSenha.getPassword());
                String newSenha = new String(loginSenha1.getPassword());

                boolean logar = usuarioController.logar(email, senha, false);

                if(logar == true){
                    carga.setVisible(false);
                    if((newSenha.length() >= 8) && (newSenha.length() <= 16)){  

                        boolean trocarSenha = usuarioController.trocarSenha(email, newSenha, false);

                        if(trocarSenha == true){
                            loginEmail.setText("");
                            loginSenha.setText("");
                            loginSenha1.setText("");
                            mostraSenha.setText("");
                            mostraSenha1.setText("");
                            JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!", 
                                "Reset de senha", JOptionPane.PLAIN_MESSAGE
                            );
                        }
                    } 
                }else{
                    carga.setVisible(false);
                    loginEmail.setText("");
                    loginSenha.setText("");
                    loginSenha1.setText("");
                    mostraSenha.setText("");
                    mostraSenha1.setText("");
                    JOptionPane.showMessageDialog(null, "Utilizar somente letras e números.\n"
                        +"Mínimo de oito e máximo de dezesseis caracteres.\n"
                        +"O sistema diferencia letras maiúsculas de minúsculas.", "Cadastro de usuário", 
                        JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
        }.start();
    }//GEN-LAST:event_signUPActionPerformed

    private void boxMostraSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxMostraSenhaActionPerformed
        String senha = new String(loginSenha.getPassword());
        if(boxMostraSenha.isSelected()){
            mostraSenha.setVisible(true);
            mostraSenha.setText(senha);
            mostraSenha1.setVisible(true);
            mostraSenha1.setText(senha);
            loginSenha.setVisible(false);
            loginSenha1.setVisible(false);
        }else{
            mostraSenha.setVisible(false);
            mostraSenha1.setVisible(false);
            loginSenha.setVisible(true);
            loginSenha1.setVisible(true);
        }
    }//GEN-LAST:event_boxMostraSenhaActionPerformed
    private void loginEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginEmailActionPerformed
    }//GEN-LAST:event_loginEmailActionPerformed
    private void mostraSenha1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostraSenha1ActionPerformed
    }//GEN-LAST:event_mostraSenha1ActionPerformed
    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        TelaLoginReset.this.dispose();
        new TelaLoginReset().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaLogin.setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void loginEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginEmailKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            new Thread(){
            int i=0;
            
                public void run(){

                    while(i<100){
                        i = i+5;
                        try{
                            carga.setVisible(true);
                            sleep(200);//600
                        }catch (Exception e){

                        }
                    }

                    String email = (loginEmail.getText());
                    String senha = new String(loginSenha.getPassword());
                    String newSenha = new String(loginSenha1.getPassword());

                    boolean logar = usuarioController.logar(email, senha, false);

                    if(logar == true){
                        carga.setVisible(false);
                        if((newSenha.length() >= 8) && (newSenha.length() <= 16)){  

                            boolean trocarSenha = usuarioController.trocarSenha(email, newSenha, false);

                            if(trocarSenha == true){
                                loginEmail.setText("");
                                loginSenha.setText("");
                                loginSenha1.setText("");
                                mostraSenha.setText("");
                                mostraSenha1.setText("");
                                JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!", 
                                    "Reset de senha", JOptionPane.PLAIN_MESSAGE
                                );
                            }
                        } 
                    }else{
                        carga.setVisible(false);
                        loginEmail.setText("");
                        loginSenha.setText("");
                        loginSenha1.setText("");
                        mostraSenha.setText("");
                        mostraSenha1.setText("");
                        JOptionPane.showMessageDialog(null, "Utilizar somente letras e números.\n"
                            +"Mínimo de oito e máximo de dezesseis caracteres.\n"
                            +"O sistema diferencia letras maiúsculas de minúsculas.", "Cadastro de usuário", 
                            JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                }
            }.start();
        }
    }//GEN-LAST:event_loginEmailKeyPressed

    private void loginSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginSenhaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            new Thread(){
            int i=0;
            
                public void run(){

                    while(i<100){
                        i = i+5;
                        try{
                            carga.setVisible(true);
                            sleep(200);//600
                        }catch (Exception e){

                        }
                    }

                    String email = (loginEmail.getText());
                    String senha = new String(loginSenha.getPassword());
                    String newSenha = new String(loginSenha1.getPassword());

                    boolean logar = usuarioController.logar(email, senha, false);

                    if(logar == true){
                        carga.setVisible(false);
                        if((newSenha.length() >= 8) && (newSenha.length() <= 16)){  

                            boolean trocarSenha = usuarioController.trocarSenha(email, newSenha, false);

                            if(trocarSenha == true){
                                loginEmail.setText("");
                                loginSenha.setText("");
                                loginSenha1.setText("");
                                mostraSenha.setText("");
                                mostraSenha1.setText("");
                                JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!", 
                                    "Reset de senha", JOptionPane.PLAIN_MESSAGE
                                );
                            }
                        } 
                    }else{
                        carga.setVisible(false);
                        loginEmail.setText("");
                        loginSenha.setText("");
                        loginSenha1.setText("");
                        mostraSenha.setText("");
                        mostraSenha1.setText("");
                        JOptionPane.showMessageDialog(null, "Utilizar somente letras e números.\n"
                            +"Mínimo de oito e máximo de dezesseis caracteres.\n"
                            +"O sistema diferencia letras maiúsculas de minúsculas.", "Cadastro de usuário", 
                            JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                }
            }.start();
        }
    }//GEN-LAST:event_loginSenhaKeyPressed

    private void loginSenha1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginSenha1KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            new Thread(){
            int i=0;
            
                public void run(){

                    while(i<100){
                        i = i+5;
                        try{
                            carga.setVisible(true);
                            sleep(200);//600
                        }catch (Exception e){

                        }
                    }

                    String email = (loginEmail.getText());
                    String senha = new String(loginSenha.getPassword());
                    String newSenha = new String(loginSenha1.getPassword());

                    boolean logar = usuarioController.logar(email, senha, false);

                    if(logar == true){
                        carga.setVisible(false);
                        if((newSenha.length() >= 8) && (newSenha.length() <= 16)){  

                            boolean trocarSenha = usuarioController.trocarSenha(email, newSenha, false);

                            if(trocarSenha == true){
                                loginEmail.setText("");
                                loginSenha.setText("");
                                loginSenha1.setText("");
                                mostraSenha.setText("");
                                mostraSenha1.setText("");
                                JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!", 
                                    "Reset de senha", JOptionPane.PLAIN_MESSAGE
                                );
                            }
                        } 
                    }else{
                        carga.setVisible(false);
                        loginEmail.setText("");
                        loginSenha.setText("");
                        loginSenha1.setText("");
                        mostraSenha.setText("");
                        mostraSenha1.setText("");
                        JOptionPane.showMessageDialog(null, "Utilizar somente letras e números.\n"
                            +"Mínimo de oito e máximo de dezesseis caracteres.\n"
                            +"O sistema diferencia letras maiúsculas de minúsculas.", "Cadastro de usuário", 
                            JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                }
            }.start();
        }
    }//GEN-LAST:event_loginSenha1KeyPressed

    private void mostraSenha1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mostraSenha1KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            new Thread(){
            int i=0;
            
                public void run(){

                    while(i<100){
                        i = i+5;
                        try{
                            carga.setVisible(true);
                            sleep(200);//600
                        }catch (Exception e){

                        }
                    }

                    String email = (loginEmail.getText());
                    String senha = new String(loginSenha.getPassword());
                    String newSenha = new String(loginSenha1.getPassword());

                    boolean logar = usuarioController.logar(email, senha, false);

                    if(logar == true){
                        carga.setVisible(false);
                        if((newSenha.length() >= 8) && (newSenha.length() <= 16)){  

                            boolean trocarSenha = usuarioController.trocarSenha(email, newSenha, false);

                            if(trocarSenha == true){
                                loginEmail.setText("");
                                loginSenha.setText("");
                                loginSenha1.setText("");
                                mostraSenha.setText("");
                                mostraSenha1.setText("");
                                JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!", 
                                    "Reset de senha", JOptionPane.PLAIN_MESSAGE
                                );
                            }
                        } 
                    }else{
                        carga.setVisible(false);
                        loginEmail.setText("");
                        loginSenha.setText("");
                        loginSenha1.setText("");
                        mostraSenha.setText("");
                        mostraSenha1.setText("");
                        JOptionPane.showMessageDialog(null, "Utilizar somente letras e números.\n"
                            +"Mínimo de oito e máximo de dezesseis caracteres.\n"
                            +"O sistema diferencia letras maiúsculas de minúsculas.", "Cadastro de usuário", 
                            JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                }
            }.start();
        }
    }//GEN-LAST:event_mostraSenha1KeyPressed

    private void mostraSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mostraSenhaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            new Thread(){
            int i=0;
            
                public void run(){

                    while(i<100){
                        i = i+5;
                        try{
                            carga.setVisible(true);
                            sleep(200);//600
                        }catch (Exception e){

                        }
                    }

                    String email = (loginEmail.getText());
                    String senha = new String(loginSenha.getPassword());
                    String newSenha = new String(loginSenha1.getPassword());

                    boolean logar = usuarioController.logar(email, senha, false);

                    if(logar == true){
                        carga.setVisible(false);
                        if((newSenha.length() >= 8) && (newSenha.length() <= 16)){  

                            boolean trocarSenha = usuarioController.trocarSenha(email, newSenha, false);

                            if(trocarSenha == true){
                                loginEmail.setText("");
                                loginSenha.setText("");
                                loginSenha1.setText("");
                                mostraSenha.setText("");
                                mostraSenha1.setText("");
                                JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!", 
                                    "Reset de senha", JOptionPane.PLAIN_MESSAGE
                                );
                            }
                        } 
                    }else{
                        carga.setVisible(false);
                        loginEmail.setText("");
                        loginSenha.setText("");
                        loginSenha1.setText("");
                        mostraSenha.setText("");
                        mostraSenha1.setText("");
                        JOptionPane.showMessageDialog(null, "Utilizar somente letras e números.\n"
                            +"Mínimo de oito e máximo de dezesseis caracteres.\n"
                            +"O sistema diferencia letras maiúsculas de minúsculas.", "Cadastro de usuário", 
                            JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                }
            }.start();
        }
    }//GEN-LAST:event_mostraSenhaKeyPressed

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
            java.util.logging.Logger.getLogger(TelaLoginReset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLoginReset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLoginReset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLoginReset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLoginReset().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox boxMostraSenha;
    private javax.swing.JLabel carga;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField loginEmail;
    private javax.swing.JPasswordField loginSenha;
    private javax.swing.JPasswordField loginSenha1;
    private javax.swing.JTextField mostraSenha;
    private javax.swing.JTextField mostraSenha1;
    private javax.swing.JButton signUP;
    // End of variables declaration//GEN-END:variables
}
