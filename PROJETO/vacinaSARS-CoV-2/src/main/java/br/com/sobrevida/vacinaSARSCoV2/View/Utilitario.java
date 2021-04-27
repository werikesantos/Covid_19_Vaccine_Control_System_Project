package br.com.sobrevida.vacinaSARSCoV2.view;

import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author WERIKE
 */
public class Utilitario {
    
    public void inserirIcone(JFrame frm){
        try{
            frm.setIconImage(Toolkit.getDefaultToolkit().getImage(
                "src/main/java/br/com/sobrevida/vacinaSARSCoV2/view/image/vacinaLogin1.png"));
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
}
