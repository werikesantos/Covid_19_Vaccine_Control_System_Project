package br.com.sobrevida.vacinaSARSCoV2.controller;

import br.com.sobrevida.vacinaSARSCoV2.model.VacinaModel;
import br.com.sobrevida.vacinaSARSCoV2.model.dao.VacinaDao;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author WERIKE
 */
public class VacinaController{
    
    VacinaModel vacinaModel = new VacinaModel();
    VacinaDao vacinaDao = new VacinaDao();
       
    public void salvar(JLabel carregarPrincipal2, JTable vacinaListaTabela, JLabel contadorCaracter, 
        JLabel avisoDesenvolvedora, JLabel avisoProdutora, JLabel avisoParceira, 
        JLabel avisoDoses, JLabel avisoPeriodo, JLabel avisoDescricao, JTextField vacinaDesenvolvedora, 
        JTextField vacinaProdutora, JTextField vacinaParceira, JComboBox vacinaDoses, JSpinner vacinaPeriodo, 
        JTextArea vacinaDescricaoAreaTexto){
          
        String desenvolvedora = (vacinaDesenvolvedora.getText());
        String produtora = (vacinaProdutora.getText());
        String parceira = (vacinaParceira.getText());  
        String doses = (vacinaDoses.getSelectedItem().toString());
        String periodo = (vacinaPeriodo.getValue().toString());
        String descricao = (vacinaDescricaoAreaTexto.getText());
        
        if((!"".equals(desenvolvedora)) && (!"".equals(produtora)) && (!"".equals(parceira)) 
            && (!" -".equals(doses)) && (!"".equals(periodo)) && (!"".equals(descricao))){
            
            vacinaModel.setDesenvolvedora(desenvolvedora);
            vacinaModel.setProdutora(produtora);
            vacinaModel.setParceira(parceira);
            
            int indiceDoses = Integer.parseInt(doses);
            
            if(indiceDoses > 1){
                int indicePeriodo = Integer.parseInt(periodo);
                if(indicePeriodo != 0){
                    vacinaModel.setQtd_Dose(indiceDoses);
                    vacinaModel.setPeriodo(periodo);
                    vacinaModel.setDescicao(descricao);
                    
                    boolean result = vacinaDao.salvar(vacinaModel, false);
                    
                    if(result == true){
                        JOptionPane.showMessageDialog(null, "Vacina cadastrada com sucesso!"
                            ,"Cadastro de Vacinas", JOptionPane.PLAIN_MESSAGE);
                
                        pesquisar(vacinaListaTabela);
                        avisoDesenvolvedora.setVisible(false);
                        avisoProdutora.setVisible(false);
                        avisoParceira.setVisible(false);
                        avisoDoses.setVisible(false);
                        avisoPeriodo.setVisible(false);
                        avisoDescricao.setVisible(false);

                        contadorCaracter.setText("0/4000");
                        vacinaDesenvolvedora.setText("");
                        vacinaProdutora.setText("");
                        vacinaParceira.setText("");
                        vacinaDoses.setSelectedIndex(0);
                        vacinaPeriodo.setValue(0);
                        vacinaDescricaoAreaTexto.setText("");
                    }else{
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar!\n"
                            + "Essa vacina já possuí cadastro."
                            ,"Cadastro de Vacinas", JOptionPane.WARNING_MESSAGE
                        );
                        //vacinaDoses.setSelectedIndex(0);
                        //vacinaPeriodo.setValue(0);        
                    }   
                }else{
                    JOptionPane.showMessageDialog(null, "Será necessário cadastrar um período,\npara a próxima dose!"
                        ,"Cadastro de Vacinas", JOptionPane.INFORMATION_MESSAGE);
                }
            }else{
                vacinaModel.setQtd_Dose(indiceDoses);
                vacinaModel.setPeriodo(periodo);
                vacinaModel.setDescicao(descricao);
                
                boolean result = vacinaDao.salvar(vacinaModel, false);
                    
                if(result == true){
                    JOptionPane.showMessageDialog(null, "Vacina cadastrada com sucesso!"
                        ,"Cadastro de Vacinas", JOptionPane.PLAIN_MESSAGE);
                
                    pesquisar(vacinaListaTabela);
                    avisoDesenvolvedora.setVisible(false);
                    avisoProdutora.setVisible(false);
                    avisoParceira.setVisible(false);
                    avisoDoses.setVisible(false);
                    avisoPeriodo.setVisible(false);
                    avisoDescricao.setVisible(false);

                    contadorCaracter.setText("0/4000");
                    vacinaDesenvolvedora.setText("");
                    vacinaProdutora.setText("");
                    vacinaParceira.setText("");
                    vacinaDoses.setSelectedIndex(0);
                    vacinaPeriodo.setValue(0);
                    vacinaDescricaoAreaTexto.setText("");
                }else{
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar!\n"
                        + "Essa vacina já possuí cadastro."
                        ,"Cadastro de Vacinas", JOptionPane.WARNING_MESSAGE
                    );
                    //vacinaDoses.setSelectedIndex(0);
                    //vacinaPeriodo.setValue(0);        
                }    
            }      
        }else{
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!\n"
                +"Por favor, preencher todos os campos marcados."
                ,"Cadastro de Vacinas", JOptionPane.WARNING_MESSAGE
            );
            
            vacinaDoses.setSelectedIndex(0);
            vacinaPeriodo.setValue(0);
            
            avisoDesenvolvedora.setVisible(true);
            avisoProdutora.setVisible(true);
            avisoParceira.setVisible(true);
            avisoDoses.setVisible(true);
            avisoPeriodo.setVisible(true);
            avisoDescricao.setVisible(true);
        }
    }
    
    public void limpar(JLabel carregarPrincipal2, JTable vacinaListaTabela, JLabel contadorCaracter, 
        JLabel avisoDesenvolvedora, JLabel avisoProdutora, JLabel avisoParceira, JLabel avisoDoses, JLabel avisoPeriodo, 
        JLabel avisoDescricao, JTextField vacinaConsultar, JTextField vacinaIdCodigo, JTextField vacinaDesenvolvedora, 
        JTextField vacinaProdutora, JTextField vacinaParceira, JComboBox vacinaDoses, 
        JSpinner vacinaPeriodo, JTextArea vacinaDescricaoAreaTexto){
         
        pesquisar(vacinaListaTabela);
        contadorCaracter.setText("0/4000");
        vacinaConsultar.setText("Consultar...");
        vacinaIdCodigo.setText("");
        vacinaDesenvolvedora.setText("");
        vacinaProdutora.setText("");
        vacinaParceira.setText("");
        vacinaDoses.setSelectedIndex(0);
        vacinaPeriodo.setValue(0);
        vacinaDescricaoAreaTexto.setText("");

        avisoDesenvolvedora.setVisible(false);
        avisoProdutora.setVisible(false);
        avisoParceira.setVisible(false);
        avisoDoses.setVisible(false);
        avisoPeriodo.setVisible(false);
        avisoDescricao.setVisible(false);
        
        carregarPrincipal2.setVisible(false);
    }
    
    
    //ALETAR PELA TABELA
    public void alterar(JTable vacinaLista, JTextField vacinaIdCodigo, JTextField vacinaDesenvolvedora, 
        JTextField vacinaProdutora, JTextField vacinaParceira, JComboBox vacinaDoses, 
        JSpinner vacinaPeriodo, JTextArea vacinaDescricao){
        
        int linhaSelecionada = vacinaLista.getSelectedRow();
        
        int id = (int) vacinaLista.getModel().getValueAt(linhaSelecionada, 0);
        String desenvolvedora = vacinaLista.getModel().getValueAt(linhaSelecionada, 1).toString();        
        String produtora = vacinaLista.getModel().getValueAt(linhaSelecionada, 2).toString();
        String parceira = vacinaLista.getModel().getValueAt(linhaSelecionada, 3).toString();
        int doses = (int) vacinaLista.getModel().getValueAt(linhaSelecionada, 4);
        String periodo = vacinaLista.getModel().getValueAt(linhaSelecionada, 5).toString();
        String descricao = vacinaLista.getModel().getValueAt(linhaSelecionada, 6).toString();
        
        if((!"".equals(id)) && (!"".equals(desenvolvedora)) && (!"".equals(produtora)) && (!"".equals(parceira)) 
            && (!"".equals(doses)) && (!"".equals(periodo)) && (!"".equals(descricao))){
            
            vacinaModel.setId(id);
            vacinaModel.setDesenvolvedora(desenvolvedora);
            vacinaModel.setProdutora(produtora);
            vacinaModel.setParceira(parceira);
            vacinaModel.setQtd_Dose(doses);
            vacinaModel.setPeriodo(periodo);
            vacinaModel.setDescicao(descricao);
            
            boolean resultado = vacinaDao.alterar(vacinaModel, false);
            
            if(resultado == true){
                JOptionPane.showMessageDialog(null, "Vacina alterada com sucesso!"
                    ,"Alterar vacina cadastrada", JOptionPane.WARNING_MESSAGE);
            }  
        }
    }
    
    public void alterar(JLabel carregarPrincipal2, JTable vacinaListaTabela, JTextField vacinaConsultar, 
        JLabel avisoDesenvolvedora, JLabel avisoProdutora, JLabel avisoParceira, JLabel avisoDoses, 
        JLabel avisoPeriodo, JLabel avisoDescricao, JTextField vacinaIdCodigo, JTextField vacinaDesenvolvedora, 
        JTextField vacinaProdutora, JTextField vacinaParceira, JComboBox vacinaDoses, JSpinner vacinaPeriodo, 
        JTextArea vacinaDescricaoAreaTexto){
            
        String pegaId = vacinaIdCodigo.getText();
        if(!"".equals(pegaId)){
            int id = Integer.parseInt(pegaId); 
            String desenvolvedora = (vacinaDesenvolvedora.getText());
            String produtora = (vacinaProdutora.getText());
            String parceira = (vacinaParceira.getText());  
            String doses = (vacinaDoses.getSelectedItem().toString());
            String periodo = (vacinaPeriodo.getValue().toString());
            String descricao = (vacinaDescricaoAreaTexto.getText());       
            
            if((!"".equals(desenvolvedora)) && (!"".equals(produtora)) && (!"".equals(parceira)) 
                && (!" -".equals(doses)) && (!"".equals(periodo)) && (!"".equals(descricao))){

                vacinaModel.setId(id);
                vacinaModel.setDesenvolvedora(desenvolvedora);
                vacinaModel.setProdutora(produtora);
                vacinaModel.setParceira(parceira);
                
                int indiceDoses = Integer.parseInt(doses);
                vacinaModel.setQtd_Dose(indiceDoses);
                
                vacinaModel.setPeriodo(periodo);
                vacinaModel.setDescicao(descricao);

                boolean result = vacinaDao.alterar(vacinaModel, false);

                if(result = true){
                    carregarPrincipal2.setVisible(false);

                    JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso.", 
                        "Atualização", JOptionPane.PLAIN_MESSAGE);
                    
                    pesquisar(vacinaListaTabela);
                    //pacienteIdCodigo.setText("");
                    vacinaConsultar.setText("Consultar...");
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
                carregarPrincipal2.setVisible(false);

                JOptionPane.showMessageDialog(null, "Erro ao cadastrar!\n"
                    +"Por favor, preencher todos os campos marcados."
                    ,"Cadastro de Vacinas", JOptionPane.WARNING_MESSAGE
                );
            
                vacinaDoses.setSelectedIndex(0);
                vacinaPeriodo.setValue(0);

                avisoDesenvolvedora.setVisible(true);
                avisoProdutora.setVisible(true);
                avisoParceira.setVisible(true);
                avisoDoses.setVisible(true);
                avisoPeriodo.setVisible(true);
                avisoDescricao.setVisible(true);
            }
        }else{
            carregarPrincipal2.setVisible(false);
            JOptionPane.showMessageDialog(null, "Código de vacina não localizado.", 
                "Atualização", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void deletar(JLabel carregarPrincipal2, JTable vacinaListaTabela, JTextField vacinaIdCodigo, 
        JLabel contadorCaracter, JTextField vacinaDesenvolvedora, JTextField vacinaProdutora, JTextField vacinaParceira, 
        JComboBox vacinaDoses, JSpinner vacinaPeriodo, JTextArea vacinaDescricaoAreaTexto){
        
        int linhaSelecionada = vacinaListaTabela.getSelectedRow();
        int id = (int) vacinaListaTabela.getModel().getValueAt(linhaSelecionada, 0);
        String desenvolvedora = vacinaListaTabela.getModel().getValueAt(linhaSelecionada, 1).toString();
        String produtora = vacinaListaTabela.getModel().getValueAt(linhaSelecionada, 2).toString();
        String parceira = vacinaListaTabela.getModel().getValueAt(linhaSelecionada, 3).toString();
        
        if((!"".equals(id))){
            
            Object[] opcao = {"Sim", "Não"};
            int respostaUsuario = JOptionPane.showOptionDialog(null, "Deseja excluir essa vacina?\nCódigo: "+id+"\nDesenvolvedora: "+desenvolvedora+"\nProdutora: "+produtora+"\nParceira: "+parceira
                ,"Exclusão de Vacina", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opcao, opcao[0]);
            
            if(respostaUsuario == JOptionPane.YES_OPTION){
                
                carregarPrincipal2.setVisible(true);

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
                            vacinaModel.setId(id);
                            boolean result = vacinaDao.deletar(vacinaModel, false); 

                        if(result = true){ 
                            carregarPrincipal2.setVisible(false);
                            
                            vacinaIdCodigo.setText("");
                            contadorCaracter.setText("0/4000");
                            vacinaDesenvolvedora.setText("");
                            vacinaProdutora.setText("");
                            vacinaParceira.setText("");
                            vacinaDoses.setSelectedIndex(0);
                            vacinaPeriodo.setValue(0);
                            vacinaDescricaoAreaTexto.setText("");
                            
                            pesquisar(vacinaListaTabela);
                            
                            JOptionPane.showMessageDialog(null, "Vacina deletada com sucesso!", "Deletar", JOptionPane.PLAIN_MESSAGE);
                        }else{
                            carregarPrincipal2.setVisible(false);
                            vacinaDao.deletar(vacinaModel, false);
                            JOptionPane.showMessageDialog(null, "Não foi possível deletar a vacina:\nCódigo: " +id+"\nDesenvolvedora: "+desenvolvedora+"\nProdutora: "+produtora+"\nParceira: "+parceira
                                ,"Erro", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }.start();
            }
        }
    }
    
    public void consultar(JLabel carregarPrincipal2, JTextField vacinaConsultar, JTextField vacinaIdCodigo, 
        JLabel avisoDesenvolvedora, JLabel avisoProdutora, JLabel avisoParceira, JLabel avisoDoses, 
        JLabel avisoPeriodo, JLabel avisoDescricao, JTextField vacinaDesenvolvedora, 
        JTextField vacinaProdutora, JTextField vacinaParceira, JComboBox vacinaDoses, JSpinner vacinaPeriodo, 
        JTextArea vacinaDescricaoAreaTexto){

        String converterID = vacinaConsultar.getText();
            
        if(!"".equals(converterID) && !"Consultar...".equals(converterID)){
                
            int id = Integer.parseInt(converterID);
            vacinaModel.setId(id);
            VacinaModel result = vacinaDao.consultar(vacinaModel, carregarPrincipal2); 

            if(((result.getDesenvolvedora()) != null) && ((result.getProdutora()) != null) && 
                ((result.getParceira()) != null)){
                
                id = result.getId();
                String resultID = Integer.toString(id);
                String desenvolvedora = result.getDesenvolvedora();
                String produtora = result.getProdutora();
                String parceira = result.getParceira();
                int doses = result.getQtd_Dose();//é inteiro
                
                String periodo = result.getPeriodo();// é uma string
                if(periodo.equals("-")){
                    periodo = "0";
                }
                //int periodos = Integer.parseInt(periodo);
                String descricao = result.getDescicao();

                vacinaIdCodigo.setText(resultID);
                vacinaDesenvolvedora.setText(desenvolvedora);
                vacinaProdutora.setText(produtora);
                vacinaParceira.setText(parceira);
                switch(doses){
                    case 1:
                        vacinaDoses.setSelectedIndex(1);
                        break;
                    case 2:
                        vacinaDoses.setSelectedIndex(2);
                        break;
                    case 3:
                        vacinaDoses.setSelectedIndex(3);
                        break;
                    case 4:
                        vacinaDoses.setSelectedIndex(4);
                        break;
                    case 5:
                        vacinaDoses.setSelectedIndex(5);
                        break;
                    case 6:
                        vacinaDoses.setSelectedIndex(6);
                        break;
                    case 7:
                        vacinaDoses.setSelectedIndex(7);
                        break;
                    case 8:
                        vacinaDoses.setSelectedIndex(8);
                        break;
                    case 9:
                        vacinaDoses.setSelectedIndex(9);
                        break;
                    case 10:
                        vacinaDoses.setSelectedIndex(10);
                        break;
                    default:
                        break;
                }
                vacinaPeriodo.setValue(Integer.valueOf(periodo));
                vacinaDescricaoAreaTexto.setText(descricao); 
            }else{
                vacinaConsultar.setText("Consultar...");
                carregarPrincipal2.setVisible(false);
                JOptionPane.showMessageDialog(null, "Código da vacina não localzada!", 
                    "Consultar", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void pesquisar(JTable vacinaListaTabela, String dado){     
        vacinaDao.pesquisar(vacinaListaTabela, dado);    
    }
    
    public void pesquisar(JTable vacinaListaTabela){     
        vacinaDao.pesquisar(vacinaListaTabela);    
    }
}
