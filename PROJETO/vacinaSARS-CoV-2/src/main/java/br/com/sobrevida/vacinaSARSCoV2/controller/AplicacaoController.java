package br.com.sobrevida.vacinaSARSCoV2.controller;

import br.com.sobrevida.vacinaSARSCoV2.model.AplicacaoModel;
import br.com.sobrevida.vacinaSARSCoV2.model.CidadaoModel;
import br.com.sobrevida.vacinaSARSCoV2.model.VacinaModel;
import br.com.sobrevida.vacinaSARSCoV2.model.dao.AplicacaoDao;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
//import java.sql.Date; 
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author WERIKE
 */
public class AplicacaoController {

    AplicacaoDao aplicacaoDao = new AplicacaoDao();
    CidadaoModel cidadaoModel = new CidadaoModel();
    AplicacaoModel aplicacaoModel = new AplicacaoModel();
    List<VacinaModel> vacinas = new ArrayList<>();
    
    public void buscarVacinaNome(JComboBox vacinasBuscar){
        aplicacaoDao.buscarVacinaNome().forEach(vacinaModel -> {
            vacinasBuscar.addItem(vacinaModel.getDesenvolvedora());                 
            
            VacinaModel vacina = new VacinaModel();
            vacina.setId(vacinaModel.getId());
            vacina.setDesenvolvedora(vacinaModel.getDesenvolvedora());
            vacina.setQtd_Dose(vacinaModel.getQtd_Dose());
            vacina.setPeriodo(vacinaModel.getPeriodo());
            vacinas.add(vacina);
        });
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
            //int dose = cidadao.getDose();
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
    
    public void limpar(JLabel carregarPrincipal, JTable aplicacaoListaTabela, JTextField aplicacaoConsultar, 
        JTextField aplicacaoIdCodigo, JLabel avisoAplicacaoVacinaDataRetorno, JLabel avisoAplicacaoPacienteNome, 
        JLabel avisoAplicacaoPacienteCpf, JLabel avisoAplicacaoPacienteEmail, JLabel avisoAplicacaoVacinaNome, 
        JLabel avisoAplicacaoVacinaDose, JLabel avisoAplicacaoData, JTextField aplicacaoPacienteNome, 
        JTextField aplicacaoPacienteCpf, JTextField aplicacaoPacienteEmail, JComboBox aplicacaoVacinaNome, 
        JSpinner aplicacaoVacinaDose, JTextField aplicacaoVacinaDataRetorno, JTextField aplicacaoVacinaData){
 
        pesquisar(aplicacaoListaTabela);
        aplicacaoConsultar.setText("Consultar...");
        aplicacaoIdCodigo.setText(null);
        aplicacaoPacienteNome.setText(null);
        aplicacaoPacienteCpf.setText(null);
        aplicacaoPacienteEmail.setText(null);
        aplicacaoVacinaNome.setSelectedIndex(0);
        aplicacaoVacinaDose.setValue(0);
        aplicacaoVacinaDataRetorno.setText(null);
        aplicacaoVacinaData.setText(null);
        
        avisoAplicacaoVacinaDataRetorno.setVisible(false);
        avisoAplicacaoPacienteNome.setVisible(false);
        avisoAplicacaoPacienteCpf.setVisible(false);
        avisoAplicacaoPacienteEmail.setVisible(false);
        avisoAplicacaoVacinaNome.setVisible(false);
        avisoAplicacaoVacinaDose.setVisible(false);
        avisoAplicacaoData.setVisible(false);
        
        carregarPrincipal.setVisible(false);
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
    
    public void salvar(JLabel carregarPrincipal1, JTable aplicacaoListaTabela, JLabel avisoAplicacaoPacienteNome, 
        JLabel avisoAplicacaoPacienteCpf, JLabel avisoAplicacaoPacienteEmail, JLabel avisoAplicacaoVacinaNome, 
        JLabel avisoAplicacaoVacinaDose, JLabel avisoAplicacaoData, JTextField aplicacaoConsultar, JTextField aplicacaoIdCodigo, 
        JTextField aplicacaoPacienteNome, JTextField aplicacaoPacienteCpf, JTextField aplicacaoPacienteEmail, 
        JComboBox aplicacaoVacinaNome, JSpinner aplicacaoVacinaDose, JTextField aplicacaoVacinaDataRetorno, 
        JTextField aplicacaoVacinaData){
  
        vacinas.forEach(vacina -> {
            int idCidadao = Integer.parseInt(aplicacaoIdCodigo.getText()); 
            String vacinaNome = (aplicacaoVacinaNome.getSelectedItem().toString());
            int dose = Integer.parseInt((aplicacaoVacinaDose.getValue().toString()));
            String aplicacaoData = (aplicacaoVacinaData.getText());
            String retorno = aplicacaoVacinaDataRetorno.getText();

            int idVacina;
            int qtdDose;
            int periodoVacina = 0;
            int doseConfirmada = 0;
            
            if(vacinaNome.equals(vacina.getDesenvolvedora())){
                idVacina = vacina.getId();
                qtdDose = vacina.getQtd_Dose();
                periodoVacina = Integer.parseInt(vacina.getPeriodo());
                
                if(dose == qtdDose){
                    aplicacaoVacinaDataRetorno.setText(null);
                    retorno = null;
                    doseConfirmada = dose;

                    String[] resultado = aplicacaoData.split("/");

                    int dia = Integer.parseInt(resultado[0]); 
                    int mes = Integer.parseInt(resultado[1]); 
                    int ano = Integer.parseInt(resultado[2]); 

                    LocalDate hoje = LocalDate.of(ano, mes, dia);

                    DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd-MM-yyyy");

                    String data = formatarData.format(hoje);
                    
                    Object[] opcao = {"Sim", "Não"};
                    int respostaUsuario = JOptionPane.showOptionDialog(null, "Deseja continuar para salvar?\n\nDose que será aplicada: "+doseConfirmada+"ª dose\nData da aplicação: "+data+"\nData do retorno: SEM RETORNO\n"
                        ,"Confirmar", JOptionPane.YES_NO_OPTION,
                        JOptionPane.PLAIN_MESSAGE, null, opcao, opcao[0]);

                    if(respostaUsuario == JOptionPane.YES_OPTION){
                        cidadaoModel.setIdCidadao(idCidadao);
                        cidadaoModel.setIdVacina(idVacina);
                        cidadaoModel.setDoseAplicada(doseConfirmada);
                        cidadaoModel.setDataAplicacao(data);
                        cidadaoModel.setPrevisao(retorno);
                        boolean result = aplicacaoDao.salvar(cidadaoModel, false);
                    }
                    
                }else if((dose > 0) && (dose > qtdDose)){
                    JOptionPane.showMessageDialog(null, "Não ultrapasse o limite máximo de\n"+qtdDose+" dose(s) para essa Vacina!", 
                        "Atenção", JOptionPane.ERROR_MESSAGE);
                }else if((dose > 0) && (dose < qtdDose)){
                    doseConfirmada = dose;
                    
                    String[] resultado = aplicacaoData.split("/");

                    int dia = Integer.parseInt(resultado[0]); 
                    int mes = Integer.parseInt(resultado[1]); 
                    int ano = Integer.parseInt(resultado[2]); 

                    LocalDate hoje = LocalDate.of(ano, mes, dia);
                    DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    
                    String data = formatarData.format(hoje);
                    
                    LocalDate adicionar = hoje.plusDays(periodoVacina);
                    String retornar = formatarData.format(adicionar);

                    String[] res = retornar.split("-");

                    String diaMostrar = res[0]; 
                    String mesMostrar = res[1];
                    String anoMostrar = res[2];

                    String mostrar = diaMostrar+mesMostrar+anoMostrar;

                    aplicacaoVacinaDataRetorno.setText(mostrar);
                    
                    Object[] opcao = {"Sim", "Não"};
                    int respostaUsuario = JOptionPane.showOptionDialog(null, "Deseja continuar para salvar?\n\nDose que será aplicada: "+doseConfirmada+"ª dose\nData da aplicação: "+data+"\nData do retorno: "+retornar+"\n"
                        ,"Confirmar", JOptionPane.YES_NO_OPTION,
                        JOptionPane.PLAIN_MESSAGE, null, opcao, opcao[0]);

                    if(respostaUsuario == JOptionPane.YES_OPTION){
                        cidadaoModel.setIdCidadao(idCidadao);
                        cidadaoModel.setIdVacina(idVacina);
                        cidadaoModel.setDoseAplicada(doseConfirmada);
                        cidadaoModel.setDataAplicacao(data);
                        cidadaoModel.setPrevisao(retorno);
                        boolean result = aplicacaoDao.salvar(cidadaoModel, false);
                    }
                }  
            }
        }); 
        
        
 /*
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
        String primeiroNome = (pacientePrimeiroNome.getText());
        String segundoNome = (pacienteSobreNome.getText());
        String nomeCompleto = primeiroNome+" "+segundoNome;
        String nascimento = (pacienteNascimento.getText());
        String celular = (pacienteCelular.getText());
        String cpf = (pacienteCpf.getText());
        String endereco = (pacienteEndereco.getText());
        String n = (pacienteEnderecoNumero.getText());
        String email = (pacienteEmail.getText());
        if((!"".equals(nomeCompleto)) && (!"".equals(nascimento)) && (!"".equals(celular))
        && (!"".equals(cpf)) && (!"".equals(endereco)) && (!"".equals(n))
        && (!"".equals(email))){
        cidadaoModel.setNome(nomeCompleto);
        cidadaoModel.setNascimento(nascimento);
        cidadaoModel.setCelular(celular);
        cidadaoModel.setCpf(cpf);
        cidadaoModel.setEndereco(endereco);
        cidadaoModel.setN(n);
        cidadaoModel.setEmail(email);
        boolean result = cidadaoDao.salvar(cidadaoModel, false);
        if(result == true){
        carregarPrincipal1.setVisible(false);
        JOptionPane.showMessageDialog(null, "Paciente cadastrado com sucesso!"
        ,"Cadastro de Paciente", JOptionPane.PLAIN_MESSAGE);
        pesquisa(pacienteListaTabela);
        avisoNome.setVisible(false);
        avisoNascimento.setVisible(false);
        avisoCelular.setVisible(false);
        avisoCpf.setVisible(false);
        avisoEndereco.setVisible(false);
        avisoN.setVisible(false);
        avisoEmail.setVisible(false);
        //pacienteIdCodigo.setText("");
        //pacientePrimeiroNome.setText("");
        //pacienteSobreNome.setText("");
        //pacienteNascimento.setText("");
        //pacienteCelular.setText("");
        //pacienteCpf.setText("");
        //pacienteEndereco.setText("");
        //pacienteEnderecoNumero.setText("");
        //pacienteEmail.setText("");
        }else{
        carregarPrincipal1.setVisible(false);
        JOptionPane.showMessageDialog(null, "Erro ao cadastrar!\n"
        + "Usuário já possuí um cadastro."
        ,"Cadastro de Paciente", JOptionPane.WARNING_MESSAGE
        );
        //pacienteIdCodigo.setText("");
        //pacientePrimeiroNome.setText("");
        //pacienteSobreNome.setText("");
        //pacienteNascimento.setText("");
        //pacienteCelular.setText("");
        //pacienteCpf.setText("");
        //pacienteEndereco.setText("");
        //pacienteEnderecoNumero.setText("");
        //pacienteEmail.setText("");
        }
        }else{
        carregarPrincipal1.setVisible(false);
        JOptionPane.showMessageDialog(null, "Erro ao cadastrar!\n"
        + "Por favor, preencher todos os campos marcados."
        ,"Cadastro de Paciente", JOptionPane.WARNING_MESSAGE
        );
        avisoNome.setVisible(true);
        avisoNascimento.setVisible(true);
        avisoCelular.setVisible(true);
        avisoCpf.setVisible(true);
        avisoEndereco.setVisible(true);
        avisoN.setVisible(true);
        avisoEmail.setVisible(true);
        }
        */ 
      
    }

    public void pesquisar(JTable aplicacaoLista, String dado){     
        aplicacaoDao.pesquisar(aplicacaoLista, dado);    
    }
    
    public void pesquisar(JTable aplicacaoListaTabela){     
        aplicacaoDao.pesquisar(aplicacaoListaTabela);    
    }
    
    public void atualizarComboBox(JComboBox aplicacaoVacinaNome){     
        aplicacaoDao.atualizarComboBox(aplicacaoVacinaNome);    
    }
    
    //ALTERAR PELA TABELA
    public void alterar(JTable aplicacaoLista, JTextField aplicacaoIdCodigo, JSpinner aplicacaoVacinaDose, 
            JTextField aplicacaoVacinaData, JTextField aplicacaoVacinaDataRetorno){
        
        int linhaSelecionada = aplicacaoLista.getSelectedRow();
        
        int idCidadao = (int) aplicacaoLista.getModel().getValueAt(linhaSelecionada, 0);
        String dose = aplicacaoLista.getModel().getValueAt(linhaSelecionada, 5).toString();
        int qtd_Dose = Integer.parseInt(dose);
        
        if((!"".equals(idCidadao)) && (!"".equals(dose))){
            
            aplicacaoModel.setIdCidadao(idCidadao);
            //aplicacaoModel.setDose(qtd_Dose);
            
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
    
    public void alterar(JLabel carregarPrincipal, JTable aplicacaoListaTabela, JLabel avisoAplicacaoVacinaDataRetorno, 
        JLabel avisoAplicacaoPacienteNome, JLabel avisoAplicacaoPacienteCpf, JLabel avisoAplicacaoPacienteEmail, 
        JLabel avisoAplicacaoVacinaNome, JLabel avisoAplicacaoVacinaDose, JLabel avisoAplicacaoData, 
        JTextField aplicacaoConsultar, JTextField aplicacaoIdCodigo, JTextField aplicacaoPacienteNome, 
        JTextField aplicacaoPacienteCpf, JTextField aplicacaoPacienteEmail, JComboBox aplicacaoVacinaNome, 
        JSpinner aplicacaoVacinaDose, JTextField aplicacaoVacinaDataRetorno, JTextField aplicacaoVacinaData){
            
        String pegaId = aplicacaoIdCodigo.getText();
        if(!"".equals(pegaId)){
            int id = Integer.parseInt(pegaId); 
              
            String pacienteNome = (aplicacaoPacienteNome.getText());
            String pacienteCpf = (aplicacaoPacienteCpf.getText());
            String pacienteEmail = (aplicacaoPacienteEmail.getText());
            String vacinaNome = (aplicacaoVacinaNome.getSelectedItem().toString());
            
            String pacienteNomeTeste = pacienteNome;
            String pacienteCpfTeste = pacienteCpf;
            String pacienteEmailTeste = pacienteEmail;
            String vacinaNomeTeste = vacinaNome;
            
            String vacinaDose = (aplicacaoVacinaDose.getValue().toString());
            int vacinaDoses = Integer.parseInt(vacinaDose);
            
            String vacinaDataRetorno = (aplicacaoVacinaDataRetorno.getText());
            String vacinaData = (aplicacaoVacinaData.getText());
                
            if((pacienteNome.equals(pacienteNomeTeste)) && (pacienteCpf.equals(pacienteCpfTeste)) 
                && (pacienteEmail.equals(pacienteEmailTeste)) && (vacinaNome.equals(vacinaNomeTeste)) && (!"".equals(vacinaDose)) 
                && ((!"".equals(vacinaDataRetorno)) && (!"  /  /    ".equals(vacinaDataRetorno))) 
                && (!"".equals(vacinaData)) && (!"  /  /    ".equals(vacinaDataRetorno))){

                aplicacaoModel.setId(id);
                aplicacaoModel.setDoseAplicada(vacinaDoses);
                aplicacaoModel.setDataAplicacao(vacinaData);
                aplicacaoModel.setPrevisao(vacinaDataRetorno);

                boolean result = aplicacaoDao.alterar(aplicacaoModel, false);

                if(result = true){
                    carregarPrincipal.setVisible(false);

                    JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso.", 
                        "Atualização", JOptionPane.PLAIN_MESSAGE);
                    
                    pesquisar(aplicacaoListaTabela);
                    //pacienteIdCodigo.setText("");
                    aplicacaoConsultar.setText("Consultar...");
                    //pacientePrimeiroNome.setText("");
                    //pacienteSobreNome.setText("");
                    //pacienteNascimento.setText("");
                    //pacienteCelular.setText("");
                    //pacienteCpf.setText("");
                    //pacienteEndereco.setText("");
                    //pacienteEnderecoNumero.setText("");
                    //pacienteEmail.setText("");               
                }
            }else{
                carregarPrincipal.setVisible(false);

                JOptionPane.showMessageDialog(null, "Somente os campos marcados\n podem ser alterados!", 
                    "Atenção", JOptionPane.WARNING_MESSAGE);
                
                avisoAplicacaoVacinaDataRetorno.setVisible(true);
                avisoAplicacaoVacinaDose.setVisible(true);
                avisoAplicacaoData.setVisible(true);
                /*aplicacaoConsultar.setText("Consultar...");
                aplicacaoIdCodigo.setText(null);
                aplicacaoPacienteNome.setText(null);
                aplicacaoPacienteCpf.setText(null);
                aplicacaoPacienteEmail.setText(null);
                aplicacaoVacinaNome.setSelectedIndex(0);
                aplicacaoVacinaDose.setValue(0);
                aplicacaoVacinaDataRetorno.setText(null);
                aplicacaoVacinaData.setText(null);*/
            }
        }else{
            carregarPrincipal.setVisible(false);
            JOptionPane.showMessageDialog(null, "Código de usuário não localizado.", 
                "Atualização", JOptionPane.ERROR_MESSAGE);
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