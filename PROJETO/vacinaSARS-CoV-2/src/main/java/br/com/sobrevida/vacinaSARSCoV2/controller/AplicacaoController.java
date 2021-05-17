package br.com.sobrevida.vacinaSARSCoV2.controller;

import br.com.sobrevida.vacinaSARSCoV2.model.CidadaoModel;
import br.com.sobrevida.vacinaSARSCoV2.model.dao.AplicacaoDao;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
//import java.sql.Date; 
//import java.text.SimpleDateFormat;

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
        
        /** COMO PEGAR O DIA MÊS E ANO DO SISTEMA
         *
         *  Date data = new Date(System.currentTimeMillis()); 
         *  SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy");
         *  System.out.println(formatarDate.format(data));
        */
        
        int id = Integer.parseInt(aplicacaoConsultar.getText());
        cidadaoModel.setId(id);
        CidadaoModel cidadao = aplicacaoDao.consultar(cidadaoModel); 
        
        id = cidadao.getId();
        String resultID = Integer.toString(id);
        String nome = cidadao.getNome();
        String cpf = cidadao.getCpf();
        String email = cidadao.getEmail();
        String desenvolvedora = cidadao.getDesenvolvedora();
        int dose = cidadao.getDose();
        String primeiraDose = cidadao.getPrimeira();
        String segundaDose = cidadao.getSegunda();
            
        aplicacaoIdCodigo.setText(resultID);
        aplicacaoPacienteNome.setText(nome);
        aplicacaoPacienteCpf.setText(cpf);
        aplicacaoPacienteEmail.setText(email);
        
        if(!desenvolvedora.equals("")){
            switch(desenvolvedora){
                case "Universidade Oxford":
                    if(null != primeiraDose){
                        aplicacaoVacinaNome.setSelectedIndex(1);
                        aplicacaoVacinaUnica.setEnabled(false);
                        aplicacaoVacinaData.setText(primeiraDose);
                        aplicacaoVacinaDataRetorno.setText(segundaDose);

                        switch(dose){
                            case 0:
                                aplicacaoVacinaUnica.setEnabled(true);
                                aplicacaoVacinaUnica.setSelected(true);
                                aplicacaoVacinaPrimeira.setEnabled(false);
                                aplicacaoVacinaSegunda.setEnabled(false);
                                break;
                            case 1:
                                aplicacaoVacinaUnica.setEnabled(false);
                                aplicacaoVacinaUnica.setSelected(false);
                                aplicacaoVacinaPrimeira.setSelected(true);
                                aplicacaoVacinaSegunda.setSelected(false);
                                break;
                            case 2:
                                aplicacaoVacinaUnica.setEnabled(false);
                                aplicacaoVacinaUnica.setSelected(false);
                                aplicacaoVacinaPrimeira.setSelected(false);
                                aplicacaoVacinaSegunda.setSelected(true);
                                break;
                            default:
                                System.out.println("Entrar em contato com o suporte!");
                                break;
                        } 
                    }
                    break;
                case "Sinovac - CoronaVac":
                    if(null != primeiraDose){
                        aplicacaoVacinaNome.setSelectedIndex(2);
                        aplicacaoVacinaUnica.setEnabled(false);
                        aplicacaoVacinaData.setText(primeiraDose);
                        aplicacaoVacinaDataRetorno.setText(segundaDose);

                        switch(dose){
                            case 0:
                                aplicacaoVacinaUnica.setEnabled(true);
                                aplicacaoVacinaUnica.setSelected(true);
                                aplicacaoVacinaPrimeira.setEnabled(false);
                                aplicacaoVacinaSegunda.setEnabled(false);
                                break;
                            case 1:
                                aplicacaoVacinaUnica.setEnabled(false);
                                aplicacaoVacinaUnica.setSelected(false);
                                aplicacaoVacinaPrimeira.setSelected(true);
                                aplicacaoVacinaSegunda.setSelected(false);
                                break;
                            case 2:
                                aplicacaoVacinaUnica.setEnabled(false);
                                aplicacaoVacinaUnica.setSelected(false);
                                aplicacaoVacinaPrimeira.setSelected(false);
                                aplicacaoVacinaSegunda.setSelected(true);
                                break;
                            default:
                                System.out.println("Entrar em contato com o suporte!");
                                break;
                        }
                    }
                    break;
                case "Pfizer":
                    if(null != primeiraDose){
                        aplicacaoVacinaNome.setSelectedIndex(3);
                        aplicacaoVacinaUnica.setEnabled(false);
                        aplicacaoVacinaData.setText(primeiraDose);
                        aplicacaoVacinaDataRetorno.setText(segundaDose);

                        switch(dose){
                            case 0:
                                aplicacaoVacinaUnica.setEnabled(true);
                                aplicacaoVacinaUnica.setSelected(true);
                                aplicacaoVacinaPrimeira.setEnabled(false);
                                aplicacaoVacinaSegunda.setEnabled(false);
                                break;
                            case 1:
                                aplicacaoVacinaUnica.setEnabled(false);
                                aplicacaoVacinaUnica.setSelected(false);
                                aplicacaoVacinaPrimeira.setSelected(true);
                                aplicacaoVacinaSegunda.setSelected(false);
                                break;
                            case 2:
                                aplicacaoVacinaUnica.setEnabled(false);
                                aplicacaoVacinaUnica.setSelected(false);
                                aplicacaoVacinaPrimeira.setSelected(false);
                                aplicacaoVacinaSegunda.setSelected(true);
                                break;
                            default:
                                System.out.println("Entrar em contato com o suporte!");
                                break;
                        }  
                    }
                    break;
                case "Moderna":
                    if(null != primeiraDose){
                        aplicacaoVacinaNome.setSelectedIndex(4);
                        aplicacaoVacinaUnica.setEnabled(false);
                        aplicacaoVacinaData.setText(primeiraDose);
                        aplicacaoVacinaDataRetorno.setText(segundaDose);

                        switch(dose){
                            case 0:
                                aplicacaoVacinaUnica.setEnabled(true);
                                aplicacaoVacinaUnica.setSelected(true);
                                aplicacaoVacinaPrimeira.setEnabled(false);
                                aplicacaoVacinaSegunda.setEnabled(false);
                                break;
                            case 1:
                                aplicacaoVacinaUnica.setEnabled(false);
                                aplicacaoVacinaUnica.setSelected(false);
                                aplicacaoVacinaPrimeira.setSelected(true);
                                aplicacaoVacinaSegunda.setSelected(false);
                                break;
                            case 2:
                                aplicacaoVacinaUnica.setEnabled(false);
                                aplicacaoVacinaUnica.setSelected(false);
                                aplicacaoVacinaPrimeira.setSelected(false);
                                aplicacaoVacinaSegunda.setSelected(true);
                                break;
                            default:
                                System.out.println("Entrar em contato com o suporte!");
                                break;
                        }
                    }
                    break;
                case "Instituto Gamaleya - Sputnik V":
                    if(null != primeiraDose){
                        aplicacaoVacinaNome.setSelectedIndex(5);
                        aplicacaoVacinaUnica.setEnabled(false);
                        aplicacaoVacinaData.setText(primeiraDose);
                        aplicacaoVacinaDataRetorno.setText(segundaDose);

                        switch(dose){
                            case 0:
                                aplicacaoVacinaUnica.setEnabled(true);
                                aplicacaoVacinaUnica.setSelected(true);
                                aplicacaoVacinaPrimeira.setEnabled(false);
                                aplicacaoVacinaSegunda.setEnabled(false);
                                break;
                            case 1:
                                aplicacaoVacinaUnica.setEnabled(false);
                                aplicacaoVacinaUnica.setSelected(false);
                                aplicacaoVacinaPrimeira.setSelected(true);
                                aplicacaoVacinaSegunda.setSelected(false);
                                break;
                            case 2:
                                aplicacaoVacinaUnica.setEnabled(false);
                                aplicacaoVacinaUnica.setSelected(false);
                                aplicacaoVacinaPrimeira.setSelected(false);
                                aplicacaoVacinaSegunda.setSelected(true);
                                break;
                            default:
                                System.out.println("Entrar em contato com o suporte!");
                                break;
                        }
                    }
                    break;
                case "Janssen":
                    if(null != primeiraDose){
                        aplicacaoVacinaNome.setSelectedIndex(6);
                        aplicacaoVacinaPrimeira.setEnabled(false);
                        aplicacaoVacinaSegunda.setEnabled(false);
                        aplicacaoVacinaData.setText(primeiraDose);
                        aplicacaoVacinaDataRetorno.setText(segundaDose);

                        switch(dose){
                            case 0:
                                aplicacaoVacinaUnica.setEnabled(true);
                                aplicacaoVacinaUnica.setSelected(true);
                                aplicacaoVacinaPrimeira.setEnabled(false);
                                aplicacaoVacinaSegunda.setEnabled(false);
                                break;
                            case 1:
                                aplicacaoVacinaUnica.setEnabled(false);
                                aplicacaoVacinaUnica.setSelected(false);
                                aplicacaoVacinaPrimeira.setSelected(true);
                                aplicacaoVacinaSegunda.setSelected(false);
                                break;
                            case 2:
                                aplicacaoVacinaUnica.setEnabled(false);
                                aplicacaoVacinaUnica.setSelected(false);
                                aplicacaoVacinaPrimeira.setSelected(false);
                                aplicacaoVacinaSegunda.setSelected(true);
                                break;
                            default:
                                System.out.println("Entrar em contato com o suporte!");
                                break;
                        } 
                    }
                    break;
                default:
                    break;
            }
        }else{
            System.out.println("Fora");
        }        
    }
}

