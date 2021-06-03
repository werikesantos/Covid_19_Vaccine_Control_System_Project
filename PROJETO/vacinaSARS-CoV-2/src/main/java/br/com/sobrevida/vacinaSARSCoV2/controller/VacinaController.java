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
       
    public void salvar(JLabel carregarPrincipal2, JLabel contadorCaracter, JLabel avisoDesenvolvedora, JLabel avisoProdutora, JLabel avisoParceira, 
        JLabel avisoDoses, JLabel avisoPeriodo, JLabel avisoDescricao, 
        JTextField vacinaDesenvolvedora, JTextField vacinaProdutora, JTextField vacinaParceira, 
        JComboBox vacinaDoses, JSpinner vacinaPeriodo, JTextArea vacinaDescricaoAreaTexto){
          
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
                            + "Por favor, verifique e tente novamente."
                            ,"Cadastro de Vacinas", JOptionPane.WARNING_MESSAGE
                        );
                        vacinaDoses.setSelectedIndex(0);
                        vacinaPeriodo.setValue(0);        
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
                        + "Por favor, verifique e tente novamente."
                        ,"Cadastro de Vacinas", JOptionPane.WARNING_MESSAGE
                    );
                    vacinaDoses.setSelectedIndex(0);
                    vacinaPeriodo.setValue(0);        
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
    
    public void limpar(JLabel carregarPrincipal2, JLabel contadorCaracter, JLabel avisoDesenvolvedora, JLabel avisoProdutora, JLabel avisoParceira, 
        JLabel avisoDoses, JLabel avisoPeriodo, JLabel avisoDescricao, 
        JTextField vacinaConsultar, JTextField vacinaIdCodigo, JTextField vacinaDesenvolvedora, 
        JTextField vacinaProdutora, JTextField vacinaParceira, JComboBox vacinaDoses, 
        JSpinner vacinaPeriodo, JTextArea vacinaDescricaoAreaTexto){
         
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
    
    public void deletar(JTable vacinaLista, JLabel avisoDesenvolvedora, JLabel avisoProdutora, JLabel avisoParceira, 
        JLabel avisoDoses, JLabel avisoPeriodo, JLabel avisoDescricao, 
        JTextField vacinaDesenvolvedora, JTextField vacinaProdutora, JTextField vacinaParceira, 
        JComboBox vacinaDoses, JSpinner vacinaPeriodo, JTextArea vacinaDescricao){
          
        int linhaSelecionada = vacinaLista.getSelectedRow();
        int id = (int) vacinaLista.getModel().getValueAt(linhaSelecionada, 0);
        String desenvolvedora = vacinaLista.getModel().getValueAt(linhaSelecionada, 1).toString();
        String produtora = vacinaLista.getModel().getValueAt(linhaSelecionada, 2).toString();
        String parceira = vacinaLista.getModel().getValueAt(linhaSelecionada, 3).toString();
        
        if((!"".equals(id))){
            
            vacinaModel.setId(id);
            
            JOptionPane.showMessageDialog(null, "A vacina será deletada:\nID: "+id+"\nDesenvolvedora: "+desenvolvedora+"\nProdutora: "+produtora+"\nParceira: "+parceira
                ,"Atenção", JOptionPane.WARNING_MESSAGE);
                    
            boolean result = vacinaDao.deletar(vacinaModel, false); 
            
            if(result = true){
                JOptionPane.showMessageDialog(null, "Usuário deletado com sucesso:", "Deletado", JOptionPane.WARNING_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possível deletar o usuário:\nID: "+id+"\nDesenvolvedora: "+desenvolvedora+"\nProdutora: "+produtora+"\nParceira: "+parceira
                    ,"Erro", JOptionPane.WARNING_MESSAGE);
            }
        }  
    }
    
    public void consultar(JTextField vacinaConsultar, JTextField vacinaIdCodigo, JLabel avisoDesenvolvedora, JLabel avisoProdutora, JLabel avisoParceira, 
        JLabel avisoDoses, JLabel avisoPeriodo, JLabel avisoDescricao, 
        JTextField vacinaDesenvolvedora, JTextField vacinaProdutora, JTextField vacinaParceira, 
        JComboBox vacinaDoses, JSpinner vacinaPeriodo, JTextArea vacinaDescricao){

        String converterID = vacinaConsultar.getText();
            
        if(!"".equals(converterID) && !"Consultar...".equals(converterID)){
                
            int id = Integer.parseInt(converterID);
            vacinaModel.setId(id);
            VacinaModel result = vacinaDao.consultar(vacinaModel); 

            id = result.getId();
            String resultID = Integer.toString(id);

            String desenvolvedora = result.getDesenvolvedora();
            String produtora = result.getProdutora();
            String parceira = result.getParceira();
            int doses = result.getQtd_Dose();
            String periodo = result.getPeriodo();
            String descricao = result.getDescicao();

            vacinaIdCodigo.setText(resultID);
            vacinaDesenvolvedora.setText(desenvolvedora);
            vacinaProdutora.setText(produtora);
            vacinaParceira.setText(parceira);
            
            if(doses == 1){
                vacinaDoses.setSelectedIndex(1);
            }else if(doses == 2){
                vacinaDoses.setSelectedIndex(2);
            }
            
            switch(doses){
                case 1:
                    vacinaDoses.setSelectedIndex(1);
                    break;
                case 2:
                    vacinaDoses.setSelectedIndex(2);
                    break;
                default:
                    break;
            }
            
            /*switch(periodo){
                case "14 a 28 dias":
                    vacinaPeriodo.setSelectedIndex(1);
                    break;
                case "28 a 42 dias":
                    vacinaPeriodo.setSelectedIndex(2);
                    break;
                case "03 meses":
                    vacinaPeriodo.setSelectedIndex(3);
                    break;
                default:
                    break;
            }*/
            vacinaDescricao.setText(descricao);
        }
    }
    
    public void pesquisar(JTable vacinaLista, String dado){     
        vacinaDao.pesquisar(vacinaLista, dado);    
    }
}
