package br.com.sobrevida.vacinaSARSCoV2.controller;

import br.com.sobrevida.vacinaSARSCoV2.model.CidadaoModel;
import br.com.sobrevida.vacinaSARSCoV2.model.dao.AplicacaoDao;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.sql.Date; 
import java.text.SimpleDateFormat;

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
        
        Date data = new Date(System.currentTimeMillis()); 
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy");
        //System.out.println(formatarDate.format(data));
        
        int id = Integer.parseInt(aplicacaoConsultar.getText());
        cidadaoModel.setId(id);
        CidadaoModel cidadao = aplicacaoDao.consultar(cidadaoModel); 
        
        id = cidadao.getId();
        String resultID = Integer.toString(id);
        String nome = cidadao.getNome();
        String cpf = cidadao.getCpf();
        String email = cidadao.getEmail();
        String desenvolvedora = cidadao.getDesenvolvedora();
        int qtd_Dose = cidadao.getQtd_Dose();
        String primeiraDose = cidadao.getPrimeira();
        String segundaDose = cidadao.getSegunda();
            
        aplicacaoIdCodigo.setText(resultID);
        aplicacaoPacienteNome.setText(nome);
        aplicacaoPacienteCpf.setText(cpf);
        aplicacaoPacienteEmail.setText(email);
        
        switch(desenvolvedora){
            case "Universidade Oxford":
                if(null != primeiraDose){
                    aplicacaoVacinaNome.setSelectedIndex(1);
                    aplicacaoVacinaUnica.setEnabled(false);
                    aplicacaoVacinaData.setText(primeiraDose);
                    aplicacaoVacinaPrimeira.setSelected(true);
                    aplicacaoVacinaDataRetorno.setText(segundaDose);
                }
                break;
            case "Sinovac - CoronaVac":
                aplicacaoVacinaNome.setSelectedIndex(2);
                aplicacaoVacinaUnica.setEnabled(false);
                break;
            case "Pfizer":
                aplicacaoVacinaNome.setSelectedIndex(3);
                aplicacaoVacinaUnica.setEnabled(false);
                break;
            case "Moderna":
                aplicacaoVacinaNome.setSelectedIndex(4);
                aplicacaoVacinaUnica.setEnabled(false);
                break;
            case "Instituto Gamaleya - Sputnik V":
                aplicacaoVacinaNome.setSelectedIndex(5);
                aplicacaoVacinaUnica.setEnabled(false);
                break;
            case "Janssen":
                aplicacaoVacinaNome.setSelectedIndex(6);
                aplicacaoVacinaPrimeira.setEnabled(false);
                aplicacaoVacinaSegunda.setEnabled(false);
                break;
            default:
                break;
        }        
    }
}

