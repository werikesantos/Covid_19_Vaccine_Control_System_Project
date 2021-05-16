package br.com.sobrevida.vacinaSARSCoV2.controller;

import br.com.sobrevida.vacinaSARSCoV2.model.CidadaoModel;
import br.com.sobrevida.vacinaSARSCoV2.model.dao.AplicacaoDao;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author WERIKE
 */
public class AplicacaoController {

    AplicacaoDao aplicacaoDao = new AplicacaoDao();
    CidadaoModel cidadaoModel = new CidadaoModel();
    
    public void buscar(JComboBox vacinasBuscar){

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
    
    public void consultar(JTextField aplicacaoConsultar, JTextField aplicacaoIdCodigo, 
        JTextField aplicacaoPacienteNome, JTextField aplicacaoPacienteCpf, JTextField aplicacaoPacienteEmail,
        JComboBox aplicacaoVacinaNome, JCheckBox aplicacaoVacinaUnica, JCheckBox aplicacaoVacinaPrimeira,
        JCheckBox aplicacaoVacinaSegunda, JTextField aplicacaoVacinaDataRetorno, JTextField aplicacaoVacinaData){
        
        int id = Integer.parseInt(aplicacaoConsultar.getText());
        cidadaoModel.setId(id);
        CidadaoModel cidadao = aplicacaoDao.consultar(cidadaoModel); 
        
        id = cidadao.getId();
        String resultID = Integer.toString(id);
        String nome = cidadao.getNome();
        String cpf = cidadao.getCpf();
        String email = cidadao.getEmail();
        
        aplicacaoIdCodigo.setText(resultID);
        aplicacaoPacienteNome.setText(nome);
        aplicacaoPacienteCpf.setText(cpf);
        aplicacaoPacienteEmail.setText(email);
        
    }
}
