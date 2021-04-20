/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sobrevida.vacinaSARSCoV2.View;

import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author WERIKE
 */
public class Utilitario {
    
    public void inserirIcone(JFrame frm){
        try{
            //CAMINHO DA IMAGEM
            frm.setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/java/images/vacinaLogin1.png"));
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
}
