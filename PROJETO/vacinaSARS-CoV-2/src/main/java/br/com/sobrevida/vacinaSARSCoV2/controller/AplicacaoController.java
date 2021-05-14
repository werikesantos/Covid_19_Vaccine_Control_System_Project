package br.com.sobrevida.vacinaSARSCoV2.controller;

import javax.swing.JCheckBox;

/**
 *
 * @author WERIKE
 */
public class AplicacaoController {

    public void vacinaAplicada(JCheckBox fiocruz, JCheckBox coronavac, 
        JCheckBox pfizer, JCheckBox moderna, JCheckBox sputnik, JCheckBox janssen){
        
        if(janssen.isSelected()){
            coronavac.setSelected(false);
            pfizer.setSelected(false);
            moderna.setSelected(false);
            sputnik.setSelected(false);
            janssen.setSelected(false);
        }else if(coronavac.isSelected()){
            fiocruz.setSelected(false);
            pfizer.setSelected(false);
            moderna.setSelected(false);
            sputnik.setSelected(false);
            janssen.setSelected(false);
        }else if(pfizer.isSelected()){
            coronavac.setSelected(false);
            fiocruz.setSelected(false);
            moderna.setSelected(false);
            sputnik.setSelected(false);
            janssen.setSelected(false);
        }else if(moderna.isSelected()){
            pfizer.setSelected(false);
            coronavac.setSelected(false);
            fiocruz.setSelected(false);
            sputnik.setSelected(false);
            janssen.setSelected(false);
        }else if(sputnik.isSelected()){
            moderna.setSelected(false);
            pfizer.setSelected(false);
            coronavac.setSelected(false);
            fiocruz.setSelected(false);
            janssen.setSelected(false);
        }else if(janssen.isSelected()){
            sputnik.setSelected(false);
            moderna.setSelected(false);
            pfizer.setSelected(false);
            coronavac.setSelected(false);
            fiocruz.setSelected(false);
        }        
    }
    
    public void tipoDose(JCheckBox unica, JCheckBox primeiraDose, JCheckBox segundaDose){
        
        if(unica.isSelected()){
            primeiraDose.setSelected(false);
            segundaDose.setSelected(false);
        }else if(primeiraDose.isSelected()){
            segundaDose.setSelected(false);
            unica.setSelected(false);
        }else if(segundaDose.isSelected()){
            unica.setSelected(false);
            primeiraDose.setSelected(false);
        }     
    }
}
