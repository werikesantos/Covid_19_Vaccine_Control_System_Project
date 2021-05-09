package br.com.sobrevida.vacinaSARSCoV2.controller;

import br.com.sobrevida.vacinaSARSCoV2.model.VacinaModel;
import br.com.sobrevida.vacinaSARSCoV2.model.dao.VacinaDao;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author WERIKE
 */
public class VacinaController{
    
    VacinaModel vacinaModel = new VacinaModel();
    VacinaDao vacinaDao = new VacinaDao();
       
    public void salvar(JLabel avisoDesenvolvedora, JLabel avisoProdutora, JLabel avisoParceira, 
            JLabel avisoDoses, JLabel avisoPeriodo, JLabel avisoDescricao, 
            JTextField vacinaDesenvolvedora, JTextField vacinaProdutora, JTextField vacinaParceira, 
            JComboBox vacinaDoses, JComboBox vacinaPeriodo, JTextArea vacinaDescricao){
          
        String desenvolvedora = (vacinaDesenvolvedora.getText());
        String produtora = (vacinaProdutora.getText());
        String parceira = (vacinaParceira.getText());  
        String doses = (vacinaDoses.getSelectedItem().toString());
        String periodo = (vacinaPeriodo.getSelectedItem().toString());
        String descricao = (vacinaDescricao.getText());
        
        if((!"".equals(desenvolvedora)) && (!"".equals(produtora)) && (!"".equals(parceira)) 
            && (!"".equals(doses)) && (!"".equals(periodo)) && (!"".equals(descricao))){
            
            vacinaModel.setDesenvolvedora(desenvolvedora);
            vacinaModel.setProdutora(produtora);
            vacinaModel.setParceira(parceira);
            
            int indiceDoses = vacinaDoses.getSelectedIndex();
            vacinaModel.setQtd_Dose(indiceDoses);
            
            vacinaModel.setPeriodo(periodo);
            vacinaModel.setDescicao(descricao);
            
            boolean result = vacinaDao.salvar(vacinaModel, false);
            
            
            if(result == true){
                JOptionPane.showMessageDialog(null, "Vacina cadastrado com sucesso!"
                    ,"Cadastro de Vacinas", JOptionPane.WARNING_MESSAGE);
                
                avisoDesenvolvedora.setVisible(false);
                avisoProdutora.setVisible(false);
                avisoParceira.setVisible(false);
                avisoDoses.setVisible(false);
                avisoPeriodo.setVisible(false);
                avisoDescricao.setVisible(false);
                
                vacinaDesenvolvedora.setText("");
                vacinaProdutora.setText("");
                vacinaParceira.setText("");
                vacinaDoses.setSelectedIndex(0);
                vacinaPeriodo.setSelectedIndex(0);
                vacinaDescricao.setText("");
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar!\n"
                    + "Por favor, verifique e tente novamente."
                    ,"Cadastro de Vacinas", JOptionPane.WARNING_MESSAGE
                );
                vacinaDesenvolvedora.setText("");
                vacinaProdutora.setText("");
                vacinaParceira.setText("");
                vacinaDoses.setSelectedIndex(0);
                vacinaPeriodo.setSelectedIndex(0);
                vacinaDescricao.setText("");        
            }       
        }else{
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!\n"
                + "Por favor, preencher todos os campos marcados."
                ,"Cadastro de Vacinas", JOptionPane.WARNING_MESSAGE
             );
            
            avisoDesenvolvedora.setVisible(true);
            avisoProdutora.setVisible(true);
            avisoParceira.setVisible(true);
            avisoDoses.setVisible(true);
            avisoPeriodo.setVisible(true);
            avisoDescricao.setVisible(true);
        }
    }
}
