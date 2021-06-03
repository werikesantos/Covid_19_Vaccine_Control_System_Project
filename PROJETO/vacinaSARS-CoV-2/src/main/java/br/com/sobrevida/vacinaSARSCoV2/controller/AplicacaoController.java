package br.com.sobrevida.vacinaSARSCoV2.controller;

import br.com.sobrevida.vacinaSARSCoV2.model.AplicacaoModel;
import br.com.sobrevida.vacinaSARSCoV2.model.CidadaoModel;
import br.com.sobrevida.vacinaSARSCoV2.model.dao.AplicacaoDao;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
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
    AplicacaoModel aplicacaoModel = new AplicacaoModel();
    
    public void buscarVacinaNome(JComboBox vacinasBuscar){

        aplicacaoDao.buscarVacinaNome().forEach(vacinaModel -> {
            vacinasBuscar.addItem(vacinaModel.toString());
        });
    }
    
    public void tipoDose(JCheckBox aplicacaoVacinaUnica, JCheckBox aplicacaoVacinaPrimeira, 
        JCheckBox aplicacaoVacinaSegunda){
                
        if(aplicacaoVacinaUnica.isSelected()){
            aplicacaoVacinaPrimeira.setSelected(false);
            aplicacaoVacinaSegunda.setSelected(false);
        }else if(aplicacaoVacinaPrimeira.isSelected()){
            aplicacaoVacinaSegunda.setSelected(false);
            aplicacaoVacinaUnica.setSelected(false);
        }else if(aplicacaoVacinaSegunda.isSelected()){
            aplicacaoVacinaUnica.setSelected(false);
            aplicacaoVacinaPrimeira.setSelected(false);
        }     
    }
    
    public void validarVacina(JSpinner aplicacaoVacinaDose, JComboBox aplicacaoVacinaNome){
        
        String vacina = (aplicacaoVacinaNome.getSelectedItem().toString());
        
        if(vacina.equals("Universidade Oxford") || vacina.equals("Sinovac - CoronaVac") 
            || vacina.equals("Pfizer") || vacina.equals("Moderna") || vacina.equals("Instituto Gamaleya - Sputnik V")){
            //aplicacaoVacinaUnica.setEnabled(false);
        }else if(vacina.equals("-")){
            //aplicacaoVacinaUnica.setEnabled(true);
            //aplicacaoVacinaPrimeira.setEnabled(true);
            //aplicacaoVacinaSegunda.setEnabled(true);
        }else{
            //aplicacaoVacinaUnica.setEnabled(true);
            //aplicacaoVacinaPrimeira.setEnabled(false);
            //aplicacaoVacinaSegunda.setEnabled(false);
        }    
    }
    
    public boolean consultar(JLabel avisoAplicacaoPacienteNome, JLabel avisoAplicacaoPacienteCpf, 
        JLabel avisoAplicacaoPacienteEmail, JLabel avisoAplicacaoVacinaNome, JLabel avisoAplicacaoVacinaDose, 
        JLabel avisoAplicacaoData, JTextField aplicacaoConsultar, JTextField aplicacaoIdCodigo, 
        JTextField aplicacaoPacienteNome, JTextField aplicacaoPacienteCpf, JTextField aplicacaoPacienteEmail,
        JComboBox aplicacaoVacinaNome, JSpinner aplicacaoVacinaDose, JTextField aplicacaoVacinaDataRetorno, JTextField aplicacaoVacinaData){

        avisoAplicacaoPacienteNome.setVisible(false);
        avisoAplicacaoPacienteCpf.setVisible(false);
        avisoAplicacaoPacienteEmail.setVisible(false);
        avisoAplicacaoVacinaNome.setVisible(false);
        avisoAplicacaoVacinaDose.setVisible(false);
        avisoAplicacaoData.setVisible(false);
        
        boolean result = true;
        
        /** COMO PEGAR O DIA MÊS E ANO DO SISTEMA
         *
         *  Date data = new Date(System.currentTimeMillis()); 
         *  SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy");
         *  System.out.println(formatarDate.format(data));
        */

        int id = Integer.parseInt(aplicacaoConsultar.getText());
        cidadaoModel.setIdCidadao(id);
        CidadaoModel cidadao = aplicacaoDao.consultar(cidadaoModel); 
           
        if(cidadao.getIdCidadao() == 0){

           aplicacaoIdCodigo.setText("");
           aplicacaoPacienteNome.setText(null);
           aplicacaoPacienteCpf.setText(null);
           aplicacaoPacienteEmail.setText(null);
           aplicacaoVacinaNome.setSelectedIndex(0);
           //aplicacaoVacinaUnica.setEnabled(true);
           //aplicacaoVacinaUnica.setSelected(false);
           //aplicacaoVacinaPrimeira.setSelected(false);
           //aplicacaoVacinaSegunda.setSelected(false);
           aplicacaoVacinaDataRetorno.setText("");
           aplicacaoVacinaData.setText("");
           
           result = false;
           return result;
        }else{
            id = cidadao.getIdCidadao();
            String resultID = Integer.toString(id);
            String nome = cidadao.getNome();
            String cpf = cidadao.getCpf();
            String email = cidadao.getEmail();
        
            String desenvolvedora = cidadao.getDesenvolvedora();
            int dose = cidadao.getDose();
            //String primeiraDose = cidadao.getPrimeira();
            //String segundaDose = cidadao.getSegunda();
            
            //if(primeiraDose.equals("null") && segundaDose.equals("null")){
            //    primeiraDose = cidadao.getUnica();
            //    segundaDose = "SEM RETORNO";
            //}
            
            aplicacaoIdCodigo.setText(resultID);
            aplicacaoPacienteNome.setText(nome);
            aplicacaoPacienteCpf.setText(cpf);
            aplicacaoPacienteEmail.setText(email);

            switch(desenvolvedora){
                case "Universidade Oxford":
                    //if(null != primeiraDose){
                        //aplicacaoVacinaNome.setSelectedIndex(1);
                        //aplicacaoVacinaUnica.setEnabled(false);
                        //aplicacaoVacinaData.setText(primeiraDose);
                        //aplicacaoVacinaDataRetorno.setText(segundaDose);

                        /*switch(dose){
                            case 0:
                               // aplicacaoVacinaUnica.setEnabled(true);
                                //aplicacaoVacinaUnica.setSelected(true);
                                //aplicacaoVacinaPrimeira.setEnabled(false);
                                //aplicacaoVacinaSegunda.setEnabled(false);
                                break;
                            case 1:
                                System.out.println("Entrar em contato com o suporte!");
                                //aplicacaoVacinaUnica.setEnabled(false);
                                //aplicacaoVacinaUnica.setSelected(false);
                               // aplicacaoVacinaPrimeira.setSelected(true);
                                //aplicacaoVacinaSegunda.setSelected(false);
                                break;
                            case 2:
                                //aplicacaoVacinaUnica.setEnabled(false);
                                //aplicacaoVacinaUnica.setSelected(false);
                                //aplicacaoVacinaPrimeira.setSelected(false);
                                //aplicacaoVacinaSegunda.setSelected(true);
                                break;
                            default:
                                System.out.println("Entrar em contato com o suporte!");
                                break;
                        } 
                    }*/
                    break;
                case "":
                    /*if(null != primeiraDose){
                        aplicacaoVacinaNome.setSelectedIndex(2);
                        //aplicacaoVacinaUnica.setEnabled(false);
                        aplicacaoVacinaData.setText(primeiraDose);
                        aplicacaoVacinaDataRetorno.setText(segundaDose);

                        /*switch(dose){
                            case 0:
                                //aplicacaoVacinaUnica.setEnabled(true);
                                //aplicacaoVacinaUnica.setSelected(true);
                                //aplicacaoVacinaPrimeira.setEnabled(false);
                                //aplicacaoVacinaSegunda.setEnabled(false);
                                break;
                            case 1:
                                //aplicacaoVacinaUnica.setEnabled(false);
                                //aplicacaoVacinaUnica.setSelected(false);
                                //aplicacaoVacinaPrimeira.setSelected(true);
                                //aplicacaoVacinaSegunda.setSelected(false);
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
                    break;*/
                case "Pfizer":
                    /*if(null != primeiraDose){
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
                    break;*/
                case "Moderna":
                    /*if(null != primeiraDose){
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
                    break;*/
                case "Instituto Gamaleya - Sputnik V":
                    /*if(null != primeiraDose){
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
                    break;*/
                case "Janssen":
                   /* if(null != primeiraDose){
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
                    }*/
                    break;
                default:
                    break;
            }            
        }
        return result;        
    }
    
    public void limpar(JTextField aplicacaoConsultar, JTextField aplicacaoIdCodigo, JTextField aplicacaoPacienteNome, 
        JTextField aplicacaoPacienteCpf, JTextField aplicacaoPacienteEmail, JComboBox aplicacaoVacinaNome, 
        JSpinner aplicacaoVacinaDose, JTextField aplicacaoVacinaDataRetorno, JTextField aplicacaoVacinaData){
           
        aplicacaoConsultar.setText("Consultar...");
        aplicacaoIdCodigo.setText(null);
        aplicacaoPacienteNome.setText(null);
        aplicacaoPacienteCpf.setText(null);
        aplicacaoPacienteEmail.setText(null);
        aplicacaoVacinaNome.setSelectedIndex(0);
        aplicacaoVacinaDose.setValue("0");
        aplicacaoVacinaDataRetorno.setText(null);
        aplicacaoVacinaData.setText(null);
    }
    
    public void buscar(JLabel avisoAplicacaoPacienteNome, JLabel avisoAplicacaoPacienteCpf, 
        JLabel avisoAplicacaoPacienteEmail, JLabel avisoAplicacaoVacinaNome, JLabel avisoAplicacaoVacinaDose, 
        JLabel avisoAplicacaoData, JTextField aplicacaoConsultar, JTextField aplicacaoIdCodigo, 
        JTextField aplicacaoPacienteNome, JTextField aplicacaoPacienteCpf, JTextField aplicacaoPacienteEmail,
        JComboBox aplicacaoVacinaNome, JSpinner aplicacaoVacinaDose, JTextField aplicacaoVacinaDataRetorno, JTextField aplicacaoVacinaData){
        
        avisoAplicacaoPacienteNome.setVisible(false);
        avisoAplicacaoPacienteCpf.setVisible(false);
        avisoAplicacaoPacienteEmail.setVisible(false);
        avisoAplicacaoVacinaNome.setVisible(false);
        avisoAplicacaoVacinaDose.setVisible(false);
        avisoAplicacaoData.setVisible(false);
        
        int id = Integer.parseInt(aplicacaoConsultar.getText());
        cidadaoModel.setId(id);
        CidadaoModel cidadao = aplicacaoDao.buscar(cidadaoModel);
            
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
    
    public void salvar(JLabel avisoAplicacaoPacienteNome, JLabel avisoAplicacaoPacienteCpf, 
        JLabel avisoAplicacaoPacienteEmail, JLabel avisoAplicacaoVacinaNome, JLabel avisoAplicacaoVacinaDose, 
        JLabel avisoAplicacaoData, JTextField aplicacaoConsultar, JTextField aplicacaoIdCodigo, 
        JTextField aplicacaoPacienteNome, JTextField aplicacaoPacienteCpf, JTextField aplicacaoPacienteEmail, 
        JComboBox aplicacaoVacinaNome, JSpinner aplicacaoVacinaDose, JTextField aplicacaoVacinaDataRetorno, 
        JTextField aplicacaoVacinaData){
          
        int idCidadao = Integer.parseInt(aplicacaoIdCodigo.getText());
        String nome = (aplicacaoPacienteNome.getText());
        String cpf = (aplicacaoPacienteCpf.getText());
        String email = (aplicacaoPacienteEmail.getText());  
        
        String vacina = (aplicacaoVacinaNome.getSelectedItem().toString());
        //boolean unica = aplicacaoVacinaUnica.isSelected();
        //boolean primeira = aplicacaoVacinaPrimeira.isSelected();
        //boolean segunda = aplicacaoVacinaSegunda.isSelected();

        int idVacina = 0;
        int dose = 0;
        //String dataUnica = "null";
        //String dataPrimeira = "null";
        //String dataSegunda = "31/05/2021"; 
        //aplicacaoVacinaDataRetorno.setText(dataSegunda);   
        
        switch(vacina){
            case "Universidade Oxford":
                idVacina = 1;
            break;
            case "Sinovac - CoronaVac":
                idVacina = 2;
            break;
            case "Pfizer":
                idVacina = 3;
            break;
            case "Moderna":
                idVacina = 4;
            break;
            case "Instituto Gamaleya - Sputnik V":
                idVacina = 5;
            break;
            case "Janssen":
                idVacina = 6;
            break;
        }
        
        /*if(unica == true){
            dose = 0;
            dataUnica = (aplicacaoVacinaData.getText());
            dataPrimeira = "null";
            dataSegunda = "null";
        }else if(primeira == true){
            dose = 1;
            dataUnica = "null";
            dataPrimeira = (aplicacaoVacinaData.getText());
            dataSegunda = "31/05/2021";
        }else if(segunda == true){
            dose = 2;
            dataUnica = "null";
            dataPrimeira = (aplicacaoVacinaData.getText());
            dataSegunda = "31/05/2021";
        }*/
        
        /*System.out.println(idCidadao + "\n" + nome + "\n" + cpf + "\n" + email
            + "\n" + idVacina + "\n" + dose + "\n" + dataUnica + "\n" + dataPrimeira + "\n" + dataSegunda);*/
        
        if((!"".equals(nome)) && (!"".equals(cpf)) && (!"".equals(email)) && (!"".equals(idCidadao)) 
            && (!"".equals(idVacina)) && (!"".equals(dose)) ){
            
            cidadaoModel.setIdCidadao(idCidadao);
            cidadaoModel.setIdVacina(idVacina);
            cidadaoModel.setDose(dose);
            //cidadaoModel.setUnica(dataUnica);
            //cidadaoModel.setPrimeira(dataPrimeira);
            //cidadaoModel.setSegunda(dataSegunda);
            
            boolean result = aplicacaoDao.salvar(cidadaoModel, false);
            
            if(result == true){
                JOptionPane.showMessageDialog(null, "Cadastro de aplicação realizada com sucesso!"
                    ,"Aplicação de Vacinas", JOptionPane.WARNING_MESSAGE);
                
                avisoAplicacaoPacienteNome.setVisible(false);
                avisoAplicacaoPacienteCpf.setVisible(false);
                avisoAplicacaoPacienteEmail.setVisible(false);
                avisoAplicacaoVacinaNome.setVisible(false);
                avisoAplicacaoVacinaDose.setVisible(false);
                avisoAplicacaoData.setVisible(false);
                
                aplicacaoConsultar.setText("Consultar...");
                aplicacaoPacienteNome.setText("");
                aplicacaoIdCodigo.setText("");
                aplicacaoPacienteCpf.setText("");
                aplicacaoPacienteEmail.setText("");
                aplicacaoVacinaNome.setSelectedIndex(0);
                //aplicacaoVacinaUnica.setSelected(false);
                //aplicacaoVacinaPrimeira.setSelected(false);
                //aplicacaoVacinaSegunda.setSelected(false);
                aplicacaoVacinaData.setText("");
                aplicacaoVacinaDataRetorno.setText("");
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar!\n"
                    + "Por favor, verifique e tente novamente."
                    ,"Aplicação de Vacinas", JOptionPane.WARNING_MESSAGE
                );  
            }       
        }else{
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!\n"
                + "Por favor, preencher todos os campos marcados."
                ,"Aplicação de Vacinas", JOptionPane.WARNING_MESSAGE
             );
            
            aplicacaoVacinaDataRetorno.setText("");
            avisoAplicacaoPacienteNome.setVisible(true);
            avisoAplicacaoPacienteCpf.setVisible(true);
            avisoAplicacaoPacienteEmail.setVisible(true);
            avisoAplicacaoVacinaNome.setVisible(true);
            avisoAplicacaoVacinaDose.setVisible(true);
            avisoAplicacaoData.setVisible(true);
        }
    }
    
    public void pesquisar(JTable aplicacaoLista, String dado){     
        aplicacaoDao.pesquisar(aplicacaoLista, dado);    
    }
    
    public void alterar(JTable aplicacaoLista, JTextField aplicacaoIdCodigo, JSpinner aplicacaoVacinaDose, 
            JTextField aplicacaoVacinaData, JTextField aplicacaoVacinaDataRetorno){
        
        int linhaSelecionada = aplicacaoLista.getSelectedRow();
        
        int idCidadao = (int) aplicacaoLista.getModel().getValueAt(linhaSelecionada, 0);
        String dose = aplicacaoLista.getModel().getValueAt(linhaSelecionada, 5).toString();
        int qtd_Dose = Integer.parseInt(dose);
        
        if((!"".equals(idCidadao)) && (!"".equals(dose))){
            
            aplicacaoModel.setIdCidadao(idCidadao);
            aplicacaoModel.setDose(qtd_Dose);
            
            boolean resultado = aplicacaoDao.alterar(aplicacaoModel, false);
            
            if(resultado == true){
                JOptionPane.showMessageDialog(null, "Controle de aplicação alterada com sucesso!"
                    ,"Controle de aplicação", JOptionPane.WARNING_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao alterar dados da aplicação!"
                    ,"Controle de aplicação", JOptionPane.WARNING_MESSAGE);
            }  
        }
    }
    
    public void deletar(JTable aplicacaoLista, JTextField aplicacaoIdCodigo, JTextField aplicacaoPacienteNome, 
        JTextField aplicacaoPacienteCpf, JTextField aplicacaoPacienteEmail){
          
        int linhaSelecionada = aplicacaoLista.getSelectedRow();
        int idCidadao = (int) aplicacaoLista.getModel().getValueAt(linhaSelecionada, 0);
        String nome = aplicacaoLista.getModel().getValueAt(linhaSelecionada, 1).toString();
        String cpf = aplicacaoLista.getModel().getValueAt(linhaSelecionada, 2).toString();
        String email = aplicacaoLista.getModel().getValueAt(linhaSelecionada, 3).toString();
        
        if((!"".equals(idCidadao))){
            
            aplicacaoModel.setIdCidadao(idCidadao);
            
            JOptionPane.showMessageDialog(null, "Esse registro será deletado:\nID: "+idCidadao+"\nPaciente: "+nome+"\nCPF: "+cpf+"\nE-Mail: "+email
                ,"Atenção", JOptionPane.WARNING_MESSAGE);
                    
            boolean result = aplicacaoDao.deletar(aplicacaoModel, false); 
            
            if(result = true){
                JOptionPane.showMessageDialog(null, "Registro de aplicação deletado com sucesso", "Deletado", JOptionPane.WARNING_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possível deletar o registro de aplicação\nID: "+idCidadao+"\nDesenvolvedora: "+nome+"\nProdutora: "+cpf+"\nParceira: "+email
                    ,"Erro", JOptionPane.WARNING_MESSAGE);
            }
        }  
    }
}