package br.com.sobrevida.vacinaSARSCoV2.view;

import static java.lang.Thread.sleep;
import javax.swing.JFrame;

/**
 *
 * @author WERIKE
 */
public class Carregar2 extends javax.swing.JFrame {

    public Carregar2() {
        initComponents();
        
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        carrega = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        imageFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sobrevida - Soluções Médicas");
        setMinimumSize(new java.awt.Dimension(763, 352));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo1.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(-60, 40, 420, 80);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/carregar1.gif"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(350, 150, 70, 70);

        carrega.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        carrega.setForeground(new java.awt.Color(153, 0, 0));
        carrega.setText("0%");
        jPanel1.add(carrega);
        carrega.setBounds(360, 230, 70, 47);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/transparente.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(-20, -20, 820, 400);

        imageFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/painel2.jpg"))); // NOI18N
        jPanel1.add(imageFundo);
        imageFundo.setBounds(-1130, -720, 1920, 1080);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 770, 350);

        getAccessibleContext().setAccessibleDescription("Sobrevida - Soluções Médicas");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        new Thread(){
            int i=0;
            
            public void run(){
                while(i<=100){
                    carrega.setText(String.valueOf(i)+"%");
                    i = i+5;   
                    
                try{
                    sleep(150);
                }catch (Exception e){    
                }
            }
            
            Carregar2.this.dispose();
            new Carregar2().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            TelaLogin telaLogin = new TelaLogin();
            telaLogin.setVisible(true);  
        }
        }.start(); 
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(Carregar2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Carregar2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Carregar2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Carregar2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Carregar2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel carrega;
    private javax.swing.JLabel imageFundo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
