package br.com.sobrevida.vacinaSARSCoV2.controller;

import br.com.sobrevida.vacinaSARSCoV2.model.AplicacaoModel;
import br.com.sobrevida.vacinaSARSCoV2.model.CidadaoModel;
import br.com.sobrevida.vacinaSARSCoV2.model.VacinaModel;
import br.com.sobrevida.vacinaSARSCoV2.model.dao.AplicacaoDao;
import static java.lang.Thread.sleep;
import java.text.ParseException;
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
import java.sql.Date; 
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WERIKE
 */
public class AplicacaoController {

    AplicacaoDao aplicacaoDao = new AplicacaoDao();
    CidadaoModel cidadaoModel = new CidadaoModel();
    AplicacaoModel aplicacaoModel = new AplicacaoModel();
    List<VacinaModel> vacinas = new ArrayList<>();
    
    public void buscarVacinaNome(JComboBox aplicacaoVacinaNome){
        aplicacaoDao.buscarVacinaNome().forEach(vacinaModel -> {
            aplicacaoVacinaNome.addItem(vacinaModel.getDesenvolvedora());                 
            
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
    
    public boolean consultar(JLabel carregarPrincipal, JLabel avisoAplicacaoPacienteNome, JLabel avisoAplicacaoPacienteCpf, 
        JLabel avisoAplicacaoPacienteEmail, JLabel avisoAplicacaoVacinaNome, JLabel avisoAplicacaoVacinaDose, 
        JLabel avisoAplicacaoData, JTextField aplicacaoConsultar, JTextField aplicacaoIdAplicacao, JTextField aplicacaoIdCodigo, 
        JTextField aplicacaoPacienteNome, JTextField aplicacaoPacienteCpf, JTextField aplicacaoPacienteEmail,
        JComboBox aplicacaoVacinaNome, JSpinner aplicacaoVacinaDose, JTextField aplicacaoVacinaDataRetorno, 
        JTextField aplicacaoVacinaData, JTextField aplicacaoPesquisar, JTextField aplicacaoAplicacao){

        avisoAplicacaoPacienteNome.setVisible(false);
        avisoAplicacaoPacienteCpf.setVisible(false);
        avisoAplicacaoPacienteEmail.setVisible(false);
        avisoAplicacaoVacinaNome.setVisible(false);
        avisoAplicacaoVacinaDose.setVisible(false);
        avisoAplicacaoData.setVisible(false);
        
        boolean result = true;

        int id = Integer.parseInt(aplicacaoConsultar.getText());
        cidadaoModel.setIdCidadao(id);
        CidadaoModel cidadao = aplicacaoDao.consultar(cidadaoModel); 
           
        if(cidadao.getIdCidadao() == 0){

            aplicacaoIdCodigo.setText("");
            aplicacaoPacienteNome.setText(null);
            aplicacaoPacienteCpf.setText(null);
            aplicacaoPacienteEmail.setText(null);
            aplicacaoVacinaNome.setSelectedIndex(0);
            aplicacaoVacinaDose.setValue(0);
            aplicacaoVacinaDataRetorno.setText(null);
            aplicacaoVacinaData.setText(null);
           
           result = false;
           return result;
        }else{
            aplicacaoConsultar.setText("Pacientes...");
            aplicacaoPesquisar.setText("Pesquisar...");
            aplicacaoAplicacao.setText("Aplicações...");
            aplicacaoIdCodigo.setText(null);
            aplicacaoPacienteNome.setText(null);
            aplicacaoPacienteCpf.setText(null);
            aplicacaoPacienteEmail.setText(null);
            aplicacaoVacinaNome.setSelectedIndex(0);
            aplicacaoVacinaDose.setValue(0);
            aplicacaoVacinaDataRetorno.setText(null);
            aplicacaoVacinaData.setText(null);
            
            int idAplicacao = cidadao.getId();
            String resultIdAplicacao = Integer.toString(idAplicacao);
            id = cidadao.getIdCidadao();
            String resultID = Integer.toString(id);
            String nome = cidadao.getNome();
            String cpf = cidadao.getCpf();
            String email = cidadao.getEmail();
            int doseAplicada = cidadao.getDoseAplicada();
            String dataAplicacao = cidadao.getDataAplicacao();
            String previsao = cidadao.getPrevisao();
            
            String previsaoFormat;
            if(!("").equals(previsao)){
                String[] dPrevisao = previsao.split("-");
                
                int diaPrevisao = Integer.parseInt(dPrevisao[0]);
                int mesPrevisao = Integer.parseInt(dPrevisao[1]);
                int anoPrevisao = Integer.parseInt(dPrevisao[2]);
                
                LocalDate hojePrevisao = LocalDate.of(anoPrevisao, mesPrevisao, diaPrevisao);
                DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("ddMMyyyy");
                previsaoFormat = formatarData.format(hojePrevisao);
            }else{
                previsaoFormat = "";
            }
            
            String[] dAplicacao = dataAplicacao.split("-");

            int diaAplicacao = Integer.parseInt(dAplicacao[0]);
            int mesAplicacao = Integer.parseInt(dAplicacao[1]);
            int anoAplicacao = Integer.parseInt(dAplicacao[2]);

            LocalDate hojeAplicacao = LocalDate.of(anoAplicacao, mesAplicacao, diaAplicacao);
            
            DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("ddMMyyyy");
            String aplicacaoFormat = formatarData.format(hojeAplicacao);
                
            aplicacaoIdAplicacao.setText(resultIdAplicacao);
            aplicacaoIdCodigo.setText(resultID);
            aplicacaoPacienteNome.setText(nome);
            aplicacaoPacienteCpf.setText(cpf);
            aplicacaoPacienteEmail.setText(email);
            aplicacaoVacinaNome.setSelectedItem(cidadao.getDesenvolvedora());
            aplicacaoVacinaDose.setValue(doseAplicada);
            aplicacaoVacinaData.setText(aplicacaoFormat);
            aplicacaoVacinaDataRetorno.setText(previsaoFormat); 
            
            carregarPrincipal.setVisible(false);
        }
        return result;        
    }
    
    public void aplicacao(JLabel carregarPrincipal, JLabel avisoAplicacaoPacienteNome, JLabel avisoAplicacaoPacienteCpf, 
        JLabel avisoAplicacaoPacienteEmail, JLabel avisoAplicacaoVacinaNome, JLabel avisoAplicacaoVacinaDose, 
        JLabel avisoAplicacaoData, JTextField aplicacaoConsultar, JTextField aplicacaoAplicacao, 
        JTextField aplicacaoIdAplicacao, JTextField aplicacaoIdCodigo, JTextField aplicacaoPacienteNome, 
        JTextField aplicacaoPacienteCpf, JTextField aplicacaoPacienteEmail, JComboBox aplicacaoVacinaNome, 
        JSpinner aplicacaoVacinaDose, JTextField aplicacaoVacinaDataRetorno, JTextField aplicacaoVacinaData, 
        JTextField aplicacaoPesquisar){

        avisoAplicacaoPacienteNome.setVisible(false);
        avisoAplicacaoPacienteCpf.setVisible(false);
        avisoAplicacaoPacienteEmail.setVisible(false);
        avisoAplicacaoVacinaNome.setVisible(false);
        avisoAplicacaoVacinaDose.setVisible(false);
        avisoAplicacaoData.setVisible(false);
        
        int id = Integer.parseInt(aplicacaoAplicacao.getText());
        cidadaoModel.setId(id);
        CidadaoModel cidadao = aplicacaoDao.aplicacao(cidadaoModel); 
           
        if(cidadao.getIdCidadao() == 0){
            aplicacaoConsultar.setText("Pacientes...");
            aplicacaoPesquisar.setText("Pesquisar...");
            aplicacaoAplicacao.setText("Aplicações...");
            aplicacaoIdCodigo.setText("");
            aplicacaoPacienteNome.setText(null);
            aplicacaoPacienteCpf.setText(null);
            aplicacaoPacienteEmail.setText(null);
            aplicacaoVacinaNome.setSelectedIndex(0);
            aplicacaoVacinaDose.setValue(0);
            aplicacaoVacinaDataRetorno.setText(null);
            aplicacaoVacinaData.setText(null);
            
            carregarPrincipal.setVisible(false);
            JOptionPane.showMessageDialog(null, "Aplicação não localizada!"
                ,"Aplicações", JOptionPane.ERROR_MESSAGE
            );
        }else{
            aplicacaoConsultar.setText("Pacientes...");
            aplicacaoPesquisar.setText("Pesquisar...");
            aplicacaoAplicacao.setText("Aplicações...");
            aplicacaoIdCodigo.setText(null);
            aplicacaoIdAplicacao.setText(null);
            aplicacaoPacienteNome.setText(null);
            aplicacaoPacienteCpf.setText(null);
            aplicacaoPacienteEmail.setText(null);
            aplicacaoVacinaNome.setSelectedIndex(0);
            aplicacaoVacinaDose.setValue(0);
            aplicacaoVacinaDataRetorno.setText(null);
            aplicacaoVacinaData.setText(null);
        
            int idAplicacao = cidadao.getId();
            String resultIdAplicacao = Integer.toString(idAplicacao);
            int idCidadao = cidadao.getIdCidadao();
            String resultIdCidadao = Integer.toString(idCidadao);
            
            String nome = cidadao.getNome();
            String cpf = cidadao.getCpf();
            String email = cidadao.getEmail();
            int doseAplicada = cidadao.getDoseAplicada();
            String dataAplicacao = cidadao.getDataAplicacao();
            String previsao = cidadao.getPrevisao();
            
            String previsaoFormat;
            if(!("").equals(previsao)){
                String[] dPrevisao = previsao.split("-");
                
                int diaPrevisao = Integer.parseInt(dPrevisao[0]);
                int mesPrevisao = Integer.parseInt(dPrevisao[1]);
                int anoPrevisao = Integer.parseInt(dPrevisao[2]);
                
                LocalDate hojePrevisao = LocalDate.of(anoPrevisao, mesPrevisao, diaPrevisao);
                DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("ddMMyyyy");
                previsaoFormat = formatarData.format(hojePrevisao);
            }else{
                previsaoFormat = "";
            }
            
            String[] dAplicacao = dataAplicacao.split("-");
            
            int diaAplicacao = Integer.parseInt(dAplicacao[0]);
            int mesAplicacao = Integer.parseInt(dAplicacao[1]);
            int anoAplicacao = Integer.parseInt(dAplicacao[2]);
            
            LocalDate hojeAplicacao = LocalDate.of(anoAplicacao, mesAplicacao, diaAplicacao);
            
            DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("ddMMyyyy");
            String aplicacaoFormat = formatarData.format(hojeAplicacao);
                          
            aplicacaoIdCodigo.setText(resultIdCidadao);
            aplicacaoIdAplicacao.setText(resultIdAplicacao);
            aplicacaoPacienteNome.setText(nome);
            aplicacaoPacienteCpf.setText(cpf);
            aplicacaoPacienteEmail.setText(email);
            aplicacaoVacinaNome.setSelectedItem(cidadao.getDesenvolvedora());
            aplicacaoVacinaDose.setValue(doseAplicada);
            aplicacaoVacinaData.setText(aplicacaoFormat);
            aplicacaoVacinaDataRetorno.setText(previsaoFormat); 
            
            carregarPrincipal.setVisible(false);
        }      
    }
    
    public void limpar(JLabel carregarPrincipal, JTable aplicacaoListaTabela, JTextField aplicacaoConsultar, 
        JTextField aplicacaoIdCodigo, JLabel avisoAplicacaoVacinaDataRetorno, JLabel avisoAplicacaoPacienteNome, 
        JLabel avisoAplicacaoPacienteCpf, JLabel avisoAplicacaoPacienteEmail, JLabel avisoAplicacaoVacinaNome, 
        JLabel avisoAplicacaoVacinaDose, JLabel avisoAplicacaoData, JTextField aplicacaoPacienteNome, 
        JTextField aplicacaoPacienteCpf, JTextField aplicacaoPacienteEmail, JComboBox aplicacaoVacinaNome, 
        JSpinner aplicacaoVacinaDose, JTextField aplicacaoVacinaDataRetorno, JTextField aplicacaoVacinaData,
        JTextField aplicacaoPesquisar, JTextField aplicacaoIdAplicacao)
    {
 
        aplicacaoIdAplicacao.setText(null);
        pesquisar(aplicacaoListaTabela);
        aplicacaoPesquisar.setText("Pesquisar...");
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
    
    public void buscar(JLabel carregarPrincipal, JLabel avisoAplicacaoPacienteNome, JLabel avisoAplicacaoPacienteCpf, 
        JLabel avisoAplicacaoPacienteEmail, JLabel avisoAplicacaoVacinaNome, JLabel avisoAplicacaoVacinaDose, 
        JLabel avisoAplicacaoData, JTextField aplicacaoConsultar, JTextField aplicacaoIdAplicacao, JTextField aplicacaoIdCodigo, 
        JTextField aplicacaoPacienteNome, JTextField aplicacaoPacienteCpf, JTextField aplicacaoPacienteEmail,
        JComboBox aplicacaoVacinaNome, JSpinner aplicacaoVacinaDose, JTextField aplicacaoVacinaDataRetorno, JTextField aplicacaoVacinaData){
        
        aplicacaoIdAplicacao.setText(null);
        aplicacaoIdCodigo.setText(null);
        aplicacaoPacienteNome.setText(null);
        aplicacaoPacienteCpf.setText(null);
        aplicacaoPacienteEmail.setText(null);
        aplicacaoVacinaNome.setSelectedIndex(0);
        aplicacaoVacinaDose.setValue(0);
        aplicacaoVacinaDataRetorno.setText(null);
        aplicacaoVacinaData.setText(null);
        
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
        
        carregarPrincipal.setVisible(false);
    }
    
    public void salvar(JLabel carregarPrincipal, JTable aplicacaoListaTabela, JLabel avisoAplicacaoPacienteNome, 
        JLabel avisoAplicacaoPacienteCpf, JLabel avisoAplicacaoPacienteEmail, JLabel avisoAplicacaoVacinaNome, 
        JLabel avisoAplicacaoVacinaDose, JLabel avisoAplicacaoData, JLabel avisoAplicacaoVacinaDataRetorno, 
        JTextField aplicacaoConsultar, JTextField aplicacaoIdCodigo, JTextField aplicacaoPacienteNome, 
        JTextField aplicacaoPacienteCpf, JTextField aplicacaoPacienteEmail, JComboBox aplicacaoVacinaNome, 
        JSpinner aplicacaoVacinaDose, JTextField aplicacaoVacinaDataRetorno, 
        JTextField aplicacaoVacinaData, JTextField aplicacaoPesquisar, JTextField aplicacaoAplicacao,
        JTextField aplicacaoIdAplicacao){
  
        String pacienteNome = (aplicacaoPacienteNome.getText());
        String pacienteCpf = (aplicacaoPacienteCpf.getText());
        String pacienteEmail = (aplicacaoPacienteEmail.getText());
        String vaNome = (aplicacaoVacinaNome.getSelectedItem().toString());

        String pacienteNomeTeste = pacienteNome;
        String pacienteCpfTeste = pacienteCpf;
        String pacienteEmailTeste = pacienteEmail;
        String vacinaNomeTeste = vaNome;

        String vacinaDose = (aplicacaoVacinaDose.getValue().toString());
        int vacinaDoses = Integer.parseInt(vacinaDose);

        String vacinaDataRetorno = (aplicacaoVacinaDataRetorno.getText());
        String vacinaData = (aplicacaoVacinaData.getText());

        if((pacienteNome.equals(pacienteNomeTeste)) && (pacienteCpf.equals(pacienteCpfTeste)) 
            && (pacienteEmail.equals(pacienteEmailTeste)) && (vaNome.equals(vacinaNomeTeste)) && (vacinaDose.equals(vacinaDose)) 
            && (!"  /  /    ".equals(vacinaData))){

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
                        retorno = "NÃO";
                        doseConfirmada = dose;

                        String[] resultado = aplicacaoData.split("/");

                        int dia = Integer.parseInt(resultado[0]); 
                        int mes = Integer.parseInt(resultado[1]); 
                        int ano = Integer.parseInt(resultado[2]); 

                        LocalDate hoje = LocalDate.of(ano, mes, dia);

                        DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd-MM-yyyy");

                        String data = formatarData.format(hoje);
                        
                        carregarPrincipal.setVisible(false);
                        
                        Object[] opcao = {"Sim", "Não"};
                        int respostaUsuario = JOptionPane.showOptionDialog(null, "Deseja continuar para salvar?\n\nVacina: "+vacinaNome+"\nDose que será aplicada: "+doseConfirmada+"ª dose\nData da aplicação: "+data+"\nData do retorno: SEM RETORNO\n"
                            ,"Confirmar", JOptionPane.YES_NO_OPTION,
                            JOptionPane.PLAIN_MESSAGE, null, opcao, opcao[0]);

                        if(respostaUsuario == JOptionPane.YES_OPTION){
                            
                            carregarPrincipal.setVisible(true);
                            
                            if((!"".equals(vacinaNome)) && (!"".equals(doseConfirmada)) && (!"".equals(data))){

                                cidadaoModel.setIdCidadao(idCidadao);
                                cidadaoModel.setIdVacina(idVacina);
                                cidadaoModel.setDoseAplicada(doseConfirmada);
                                cidadaoModel.setDataAplicacao(data);
                                cidadaoModel.setPrevisao(retorno);

                                carregarPrincipal.setVisible(true);
                                new Thread(){
                                    int i=0;
                                    public void run(){
                                        while(i<100){
                                            i = i+5;
                                            try{
                                                sleep(100);
                                            }catch (Exception e){  
                                            }
                                        }
                                        boolean result = false;
                                        try {
                                            result = aplicacaoDao.salvar(cidadaoModel, false);
                                        } catch (ParseException ex) {
                                            Logger.getLogger(AplicacaoController.class.getName()).log(Level.SEVERE, null, ex);
                                        }

                                        if(result == true){
                                            pesquisar(aplicacaoListaTabela);
                                            carregarPrincipal.setVisible(false);

                                            aplicacaoConsultar.setText("Pacientes...");
                                            aplicacaoPesquisar.setText("Pesquisar...");
                                            aplicacaoAplicacao.setText("Aplicações...");
                                            aplicacaoIdCodigo.setText(null);
                                            aplicacaoPacienteNome.setText(null);
                                            aplicacaoPacienteCpf.setText(null);
                                            aplicacaoPacienteEmail.setText(null);
                                            aplicacaoVacinaNome.setSelectedIndex(0);
                                            aplicacaoVacinaDose.setValue(0);
                                            aplicacaoVacinaDataRetorno.setText(null);
                                            aplicacaoVacinaData.setText(null);
                                            aplicacaoIdAplicacao.setText(null);

                                            avisoAplicacaoVacinaDataRetorno.setVisible(false);
                                            avisoAplicacaoPacienteNome.setVisible(false);
                                            avisoAplicacaoPacienteCpf.setVisible(false);
                                            avisoAplicacaoPacienteEmail.setVisible(false);
                                            avisoAplicacaoVacinaNome.setVisible(false);
                                            avisoAplicacaoVacinaDose.setVisible(false);
                                            avisoAplicacaoData.setVisible(false);

                                            JOptionPane.showMessageDialog(null, "Aplicação cadastrada com sucesso!"
                                                ,"Cadastro de Aplicações", JOptionPane.PLAIN_MESSAGE
                                            );
                                        }else{
                                            carregarPrincipal.setVisible(false);
                                            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!\n"
                                                + "Por favor, verifique e tente novamente.",
                                                "Aplicação de Vacinas", JOptionPane.WARNING_MESSAGE
                                            );  
                                        }    
                                    }
                                }.start();
                            }else{
                                carregarPrincipal.setVisible(false);

                                JOptionPane.showMessageDialog(null, "Erro ao cadastrar!\n"
                                    + "Por favor, preencher todos os campos marcados."
                                    ,"Cadastro de Paciente", JOptionPane.WARNING_MESSAGE
                                 );
                                avisoAplicacaoVacinaNome.setVisible(true);
                                avisoAplicacaoVacinaDose.setVisible(true);
                                avisoAplicacaoData.setVisible(true);
                            }
                        } 
                    }else if((dose > 0) && (dose > qtdDose)){
                        JOptionPane.showMessageDialog(null, "Não ultrapasse o limite máximo de\n"+qtdDose+" dose(s) para essa Vacina!", 
                            "Atenção", JOptionPane.ERROR_MESSAGE
                        );
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
                        int respostaUsuario = JOptionPane.showOptionDialog(null, "Deseja continuar para salvar?\n\nVacina: "+vacinaNome+"\nDose que será aplicada: "+doseConfirmada+"ª dose\nData da aplicação: "+data+"\nData do retorno: "+retornar+"\n"
                            ,"Confirmar", JOptionPane.YES_NO_OPTION,
                            JOptionPane.PLAIN_MESSAGE, null, opcao, opcao[0]);

                        if(respostaUsuario == JOptionPane.YES_OPTION){

                            if((!"".equals(vacinaNome)) && (!"".equals(doseConfirmada)) && (!"  /  /    ".equals(data)) && 
                                (!"  /  /    ".equals(retornar))){

                                cidadaoModel.setIdCidadao(idCidadao);
                                cidadaoModel.setIdVacina(idVacina);
                                cidadaoModel.setDoseAplicada(doseConfirmada);
                                cidadaoModel.setDataAplicacao(data);
                                cidadaoModel.setPrevisao(retornar);

                                carregarPrincipal.setVisible(true);
                                new Thread(){
                                    int i=0;
                                    public void run(){
                                        while(i<100){
                                            i = i+5;
                                            try{
                                                sleep(100);
                                            }catch (Exception e){  
                                            }
                                        }
                                        boolean result = false;
                                        try {
                                            result = aplicacaoDao.salvar(cidadaoModel, false);
                                        } catch (ParseException ex) {
                                            Logger.getLogger(AplicacaoController.class.getName()).log(Level.SEVERE, null, ex);
                                        }

                                        if(result == true){
                                            pesquisar(aplicacaoListaTabela);
                                            carregarPrincipal.setVisible(false);

                                            aplicacaoConsultar.setText("Pacientes...");
                                            aplicacaoPesquisar.setText("Pesquisar...");
                                            aplicacaoAplicacao.setText("Aplicações...");
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
                                            aplicacaoIdAplicacao.setText(null);

                                            JOptionPane.showMessageDialog(null, "Aplicação cadastrada com sucesso!"
                                                ,"Cadastro de Aplicações", JOptionPane.PLAIN_MESSAGE);
                                        }else{
                                            carregarPrincipal.setVisible(false);
                                            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!\n"
                                                + "Por favor, verifique e tente novamente.",
                                                "Aplicação de Vacinas", JOptionPane.WARNING_MESSAGE
                                            ); 
                                        }    
                                    }
                                }.start();
                            }else{
                                carregarPrincipal.setVisible(false);

                                JOptionPane.showMessageDialog(null, "Erro ao cadastrar!\n"
                                    + "Por favor, preencher todos os campos marcados."
                                    ,"Cadastro de Paciente", JOptionPane.WARNING_MESSAGE
                                 );
                                avisoAplicacaoVacinaNome.setVisible(true);
                                avisoAplicacaoVacinaDose.setVisible(true);
                                avisoAplicacaoData.setVisible(true);
                            }
                        }
                    }  
                }
            }); 
        }else{
            carregarPrincipal.setVisible(false);

            JOptionPane.showMessageDialog(null, "Por favor, preencher todos os campos marcados!", 
                "Atenção", JOptionPane.WARNING_MESSAGE);
                
            avisoAplicacaoVacinaDataRetorno.setVisible(true);
            avisoAplicacaoVacinaDose.setVisible(true);
            avisoAplicacaoData.setVisible(true);
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
    
    public void pesquisar(JTable aplicacaoListaTabela){     
        aplicacaoDao.pesquisar(aplicacaoListaTabela);    
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
        JSpinner aplicacaoVacinaDose, JTextField aplicacaoVacinaDataRetorno, JTextField aplicacaoVacinaData,
        JTextField aplicacaoPesquisar, JTextField aplicacaoAplicacao){
            
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
                    aplicacaoConsultar.setText("Pacientes...");
                    aplicacaoPesquisar.setText("Pesquisar...");
                    aplicacaoAplicacao.setText("Aplicações...");
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
    
    public void deletar(JLabel carregarPrincipal, JTable aplicacaoListaTabela, JTextField aplicacaoIdCodigo, JTextField aplicacaoPacienteNome, 
        JTextField aplicacaoPacienteCpf, JTextField aplicacaoPacienteEmail, JComboBox aplicacaoVacinaNome, 
        JSpinner aplicacaoVacinaDose, JFormattedTextField aplicacaoVacinaData, 
        JFormattedTextField aplicacaoVacinaDataRetorno, JTextField aplicacaoIdAplicacao){
          
        int linhaSelecionada = aplicacaoListaTabela.getSelectedRow();
        int idAplicacao = (int) aplicacaoListaTabela.getModel().getValueAt(linhaSelecionada, 0);
        String nome = aplicacaoListaTabela.getModel().getValueAt(linhaSelecionada, 2).toString();
        String cpf = aplicacaoListaTabela.getModel().getValueAt(linhaSelecionada, 3).toString();
        String nomeVacina = aplicacaoListaTabela.getModel().getValueAt(linhaSelecionada, 5).toString();
        String dose = aplicacaoListaTabela.getModel().getValueAt(linhaSelecionada, 6).toString();
        String aplicacao = aplicacaoListaTabela.getModel().getValueAt(linhaSelecionada, 7).toString();
        
        if((!"".equals(idAplicacao))){
            
            Object[] opcao = {"Sim", "Não"};
            int respostaUsuario = JOptionPane.showOptionDialog(null, "Deseja excluir essa Aplicação?\nCódigo: "+idAplicacao+"\nNome: "+nome+"\nCPF: "+cpf+"\nVacina: "+nomeVacina+"\nDose: "+dose+"\nAplicação: "+aplicacao
                ,"Exclusão de aplicações", JOptionPane.YES_NO_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null, opcao, opcao[0]
                );
            
            if(respostaUsuario == JOptionPane.YES_OPTION){
                
                carregarPrincipal.setVisible(true);

                new Thread(){
                    int i = 0;
                    public void run() {
                        while (i < 100) {
                            i = i + 5;
                            try {
                                sleep(100);
                            } catch (Exception e) {
                            }
                        }
                        aplicacaoModel.setId(idAplicacao);
                        boolean result = aplicacaoDao.deletar(aplicacaoModel, false); 
            
                        if(result = true){
                            
                            aplicacaoIdAplicacao.setText(null);
                            aplicacaoIdCodigo.setText(null);
                            aplicacaoPacienteNome.setText(null);
                            aplicacaoPacienteCpf.setText(null);
                            aplicacaoPacienteEmail.setText(null);
                            aplicacaoVacinaNome.setSelectedIndex(0);
                            aplicacaoVacinaDose.setValue(0);
                            aplicacaoVacinaDataRetorno.setText(null);
                            aplicacaoVacinaData.setText(null);
                            
                            pesquisar(aplicacaoListaTabela);
                            carregarPrincipal.setVisible(false);
                            
                            JOptionPane.showMessageDialog(null, "Registro de aplicação deletado com sucesso!", "Deletar", JOptionPane.WARNING_MESSAGE);
                        }else{
                            carregarPrincipal.setVisible(false);
                            //vacinaDao.deletar(vacinaModel, false);
                            JOptionPane.showMessageDialog(null, "Não foi possível deletar o registro de aplicação\nCódigo: "+idAplicacao+"\nNome: "+nome+"\nCPF: "+cpf+"\nVacina: "+nomeVacina+"\nDose: "+dose+"\nAplicação: "+aplicacao
                                ,"Erro", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }.start();
            }
        } 
    }
}