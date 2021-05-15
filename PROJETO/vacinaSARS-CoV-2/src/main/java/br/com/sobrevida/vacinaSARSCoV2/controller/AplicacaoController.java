package br.com.sobrevida.vacinaSARSCoV2.controller;

import br.com.sobrevida.vacinaSARSCoV2.model.dao.AplicacaoDao;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

/**
 *
 * @author WERIKE
 */
public class AplicacaoController {

    public void buscar(JComboBox vacinasBuscar){
        AplicacaoDao aplicacaoDao = new AplicacaoDao();
        
        aplicacaoDao.buscar().forEach(vacinaModel -> {
            vacinasBuscar.addItem(vacinaModel.toString());
        });
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
