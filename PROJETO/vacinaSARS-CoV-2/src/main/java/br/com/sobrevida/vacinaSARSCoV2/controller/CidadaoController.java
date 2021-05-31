package br.com.sobrevida.vacinaSARSCoV2.controller;

import br.com.sobrevida.vacinaSARSCoV2.model.CidadaoModel;
import br.com.sobrevida.vacinaSARSCoV2.model.dao.CidadaoDao;
import static java.lang.Thread.sleep;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author WERIKE
 */
public class CidadaoController {
    
    CidadaoModel cidadaoModel = new CidadaoModel();
    CidadaoDao cidadaoDao = new CidadaoDao();
       
    public void salvar(JLabel carregarPrincipal1, JLabel avisoNome, JLabel avisoNascimento, JLabel avisoCelular, 
        JLabel avisoCpf, JLabel avisoEndereco, JLabel avisoN, JLabel avisoEmail, 
        JTextField pacientePrimeiroNome, JTextField pacienteSobreNome, JTextField pacienteNascimento, 
        JTextField pacienteCelular, JTextField pacienteCpf, JTextField pacienteEndereco, 
        JTextField pacienteEnderecoNumero, JTextField pacienteEmail){
          
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
                                
                avisoNome.setVisible(false);
                avisoNascimento.setVisible(false);
                avisoCelular.setVisible(false);
                avisoCpf.setVisible(false);
                avisoEndereco.setVisible(false);
                avisoN.setVisible(false);
                avisoEmail.setVisible(false);
                
                pacientePrimeiroNome.setText("");
                pacienteSobreNome.setText("");
                pacienteNascimento.setText("");
                pacienteCelular.setText("");
                pacienteCpf.setText("");
                pacienteEndereco.setText("");
                pacienteEnderecoNumero.setText("");
                pacienteEmail.setText("");
            }else{
                carregarPrincipal1.setVisible(false);
                
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar!\n"
                    + "Por favor, verifique e tente novamente."
                    ,"Cadastro de Paciente", JOptionPane.WARNING_MESSAGE
                );
                pacientePrimeiroNome.setText("");
                pacienteSobreNome.setText("");
                pacienteNascimento.setText("");
                pacienteCelular.setText("");
                pacienteCpf.setText("");
                pacienteEndereco.setText("");
                pacienteEnderecoNumero.setText("");
                pacienteEmail.setText("");        
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
    } 

    public void consulta(JLabel carregarPrincipal1, JTextField pacienteConsultar, JTextField pacienteIdCodigo, 
        JTextField pacientePrimeiroNome, JTextField pacienteSobreNome, JTextField pacienteNascimento, 
        JTextField pacienteCelular, JTextField pacienteCpf, JTextField pacienteEndereco, 
        JTextField pacienteEnderecoNumero, JTextField pacienteEmail){

        String converterID = pacienteConsultar.getText();
            
        if(!"".equals(converterID) && !"Consultar...".equals(converterID)){
                
            int id = Integer.parseInt(converterID);
            cidadaoModel.setId(id);
            CidadaoModel result = cidadaoDao.consulta(cidadaoModel, carregarPrincipal1); 

            id = result.getId();
            String resultID = Integer.toString(id);
              
            String primeiro = "";
            String segundo = "";
                    
            String nome = result.getNome();
            String[] resultado = nome.split(" ");
            
            switch (resultado.length) {
                case 2:
                    primeiro = resultado[0];
                    segundo = resultado[1];
                    break;
                case 3:
                    {
                        primeiro = resultado[0];
                        String p1 = resultado[1];
                        String p2 = resultado[2];
                        segundo = p1+" "+p2;
                        break;
                    }
                case 4:
                    {
                        primeiro = resultado[0];
                        String p1 = resultado[1];
                        String p2 = resultado[2];
                        String p3 = resultado[3];
                        segundo = p1+" "+p2+" "+p3;
                        break;
                    }
                case 5:
                    {
                        primeiro = resultado[0];
                        String p1 = resultado[1];
                        String p2 = resultado[2];
                        String p3 = resultado[3];
                        String p4 = resultado[4];
                        segundo = p1+" "+p2+" "+p3+" "+p4;
                        break;
                    }
                case 6:
                    {
                        primeiro = resultado[0];
                        String p1 = resultado[1];
                        String p2 = resultado[2];
                        String p3 = resultado[3];
                        String p4 = resultado[4];
                        String p5 = resultado[5];
                        segundo = p1+" "+p2+" "+p3+" "+p4+" "+p5;
                        break;
                    }
                case 7:
                    {
                        primeiro = resultado[0];
                        String p1 = resultado[1];
                        String p2 = resultado[2];
                        String p3 = resultado[3];
                        String p4 = resultado[4];
                        String p5 = resultado[5];
                        String p6 = resultado[6];
                        segundo = p1+" "+p2+" "+p3+" "+p4+" "+p5+" "+p6;
                        break;
                    }
                    case 8:
                    {
                        primeiro = resultado[0];
                        String p1 = resultado[1];
                        String p2 = resultado[2];
                        String p3 = resultado[3];
                        String p4 = resultado[4];
                        String p5 = resultado[5];
                        String p6 = resultado[6];
                        String p7 = resultado[7];
                        segundo = p1+" "+p2+" "+p3+" "+p4+" "+p5+" "+p6+" "+p7;
                        break;
                    }
                default:
                    primeiro = resultado[0];
                    String p1 = resultado[1];
                    String p2 = resultado[2];
                    String p3 = resultado[3];
                    String p4 = resultado[4];
                    String p5 = resultado[5];
                    String p6 = resultado[6];
                    String p7 = resultado[7];
                    segundo = p1 + " " + p2 + " " + p3 + " " + p4 + " " + p5 + " " + p6 + " " + p7;
                    break;
            }
            
            String nascimento = result.getNascimento();
            String celular = result.getCelular();
            String cpf = result.getCpf();
            String endereco = result.getEndereco();
            String numero = result.getN();
            String email = result.getEmail();

            pacienteIdCodigo.setText(resultID);
            pacientePrimeiroNome.setText(primeiro);
            pacienteSobreNome.setText(segundo);
            pacienteNascimento.setText(nascimento);
            pacienteCelular.setText(celular);
            pacienteCpf.setText(cpf);
            pacienteEndereco.setText(endereco);
            pacienteEnderecoNumero.setText(numero);
            pacienteEmail.setText(email);
        }
    } 
    
    public void pesquisa(JTable pacienteLista, String dado){     
        cidadaoDao.pesquisa(pacienteLista, dado);    
    }
    
    public boolean alterar(int id, String nome, String nascimento, String celular,
        String cpf, String endereco, String n, String email, boolean resultado){
            
        boolean result = resultado;
        
        if((!"".equals(id)) && (!"".equals(nome)) && (!"".equals(nascimento)) && (!"".equals(celular)) 
            && (!"".equals(cpf)) && (!"".equals(endereco)) && (!"".equals(n)) 
            && (!"".equals(email))){
            
            cidadaoModel.setId(id);
            cidadaoModel.setNome(nome);
            cidadaoModel.setNascimento(nascimento);
            cidadaoModel.setCelular(celular);
            cidadaoModel.setCpf(cpf);
            cidadaoModel.setEndereco(endereco);
            cidadaoModel.setN(n);
            cidadaoModel.setEmail(email);
            
            resultado = cidadaoDao.alterar(cidadaoModel, false);
                
            if(resultado == true){
                return resultado;
            }
        }
        return result;
    } 
    
    public void alterar(JLabel carregarPrincipal1, JTextField pacienteConsultar, JTable pacienteLista, JTextField pacienteIdCodigo, JTextField pacientePrimeiroNome, 
        JTextField pacienteSobreNome, JTextField pacienteNascimento, JTextField pacienteCelular, 
        JTextField pacienteCpf, JTextField pacienteEndereco, JTextField pacienteEnderecoNumero,
        JTextField pacienteEmail){
        
        int linhaSelecionada = pacienteLista.getSelectedRow();
        
        int id = (int) pacienteLista.getModel().getValueAt(linhaSelecionada, 0);
        String nome = pacienteLista.getModel().getValueAt(linhaSelecionada, 1).toString();        
        String nascimento = pacienteLista.getModel().getValueAt(linhaSelecionada, 2).toString();
        String celular = pacienteLista.getModel().getValueAt(linhaSelecionada, 3).toString();
        String cpf = pacienteLista.getModel().getValueAt(linhaSelecionada, 4).toString();
        String endereco = pacienteLista.getModel().getValueAt(linhaSelecionada, 5).toString();
        String n = pacienteLista.getModel().getValueAt(linhaSelecionada, 6).toString();
        String email = pacienteLista.getModel().getValueAt(linhaSelecionada, 7).toString();

        if((!"".equals(id)) && (!"".equals(nome)) && (!"".equals(nascimento)) && (!"".equals(celular)) 
            && (!"".equals(cpf)) && (!"".equals(endereco)) && (!"".equals(n)) 
            && (!"".equals(email))){
            
            cidadaoModel.setId(id);
            cidadaoModel.setNome(nome);
            cidadaoModel.setNascimento(nascimento);
            cidadaoModel.setCelular(celular);
            cidadaoModel.setCpf(cpf);
            cidadaoModel.setEndereco(endereco);
            cidadaoModel.setN(n);
            cidadaoModel.setEmail(email);
            
            boolean result = cidadaoDao.alterar(cidadaoModel, false);
            
            if(result = true){
                carregarPrincipal1.setVisible(false);
                
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso.", 
                    "Atualização", JOptionPane.PLAIN_MESSAGE);
                
                pacienteIdCodigo.setText("");
                pacienteConsultar.setText("Consultar...");
                pacientePrimeiroNome.setText("");
                pacienteSobreNome.setText("");
                pacienteNascimento.setText("");
                pacienteCelular.setText("");
                pacienteCpf.setText("");
                pacienteEndereco.setText("");
                pacienteEnderecoNumero.setText("");
                pacienteEmail.setText("");               
            }
        }else{
            carregarPrincipal1.setVisible(false);
            
            JOptionPane.showMessageDialog(null, "Erro ao atualizar.", 
                "Erro", JOptionPane.WARNING_MESSAGE);
            
            pacienteIdCodigo.setText("");
            pacientePrimeiroNome.setText("");
            pacienteSobreNome.setText("");
            pacienteNascimento.setText("");
            pacienteCelular.setText("");
            pacienteCpf.setText("");
            pacienteEndereco.setText("");
            pacienteEnderecoNumero.setText("");
            pacienteEmail.setText("");
        }
    }

    public void deletar(JLabel carregarPrincipal1, JTable pacienteLista, JTextField pacienteIdCodigo, 
        JTextField pacientePrimeiroNome, JTextField pacienteSobreNome, JTextField pacienteNascimento, 
        JTextField pacienteCelular, JTextField pacienteCpf, JTextField pacienteEndereco, 
        JTextField pacienteEnderecoNumero, JTextField pacienteEmail){
                  
        int linhaSelecionada = pacienteLista.getSelectedRow();
        int id = (int) pacienteLista.getModel().getValueAt(linhaSelecionada, 0);
        String nomeCompleto = pacienteLista.getModel().getValueAt(linhaSelecionada, 1).toString();
        String cpf = pacienteLista.getModel().getValueAt(linhaSelecionada, 4).toString();
        
        if((!"".equals(id))){
 
            Object[] opcao = {"Sim", "Não"};
            int respostaUsuario = JOptionPane.showOptionDialog(null, "Deseja excluir esse usuário?\nCódigo: "+id+"\nNome: "+nomeCompleto+"\nCPF: "+cpf
                ,"Exclusão de usuário", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opcao, opcao[0]);
 
            if(respostaUsuario == JOptionPane.YES_OPTION){
                
                carregarPrincipal1.setVisible(true);
                
                new Thread() {
                    int i = 0;
                    public void run() {
                        while (i < 100) {
                            i = i + 5;
                            try {
                                sleep(100);
                            } catch (Exception e) {
                            }
                        }
                        cidadaoModel.setId(id);
                        boolean result = cidadaoDao.deletar(cidadaoModel, false);
                        
                        if (result = true) {
                            carregarPrincipal1.setVisible(false);

                            JOptionPane.showMessageDialog(null, "Usuário deletado com sucesso:", "Deletado", JOptionPane.PLAIN_MESSAGE);
                        } else {
                            carregarPrincipal1.setVisible(false);

                            JOptionPane.showMessageDialog(null, "Não foi possível deletar o usuário:\nID: " + id + "\nNome: " + nomeCompleto + "\nCPF: " + cpf,
                                "Erro", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }.start();
            }
        }  
    }
    
    public void limpar(JLabel carregarPrincipal1, JLabel avisoNome, JLabel avisoNascimento, JLabel avisoCelular, 
        JLabel avisoCpf, JLabel avisoEndereco, JLabel avisoN, JLabel avisoEmail, 
        JTextField pacienteIdCodigo, JTextField pacientePrimeiroNome, JTextField pacienteSobreNome, 
        JTextField pacienteNascimento, JTextField pacienteCelular, JTextField pacienteCpf, 
        JTextField pacienteEndereco, JTextField pacienteEnderecoNumero, JTextField pacienteEmail){
                    
        pacienteIdCodigo.setText("");
        pacientePrimeiroNome.setText("");
        pacienteSobreNome.setText("");
        pacienteNascimento.setText("");
        pacienteCelular.setText("");
        pacienteCpf.setText("");
        pacienteEndereco.setText("");
        pacienteEnderecoNumero.setText("");
        pacienteEmail.setText("");
        
        avisoNome.setVisible(false);
        avisoNascimento.setVisible(false);
        avisoCelular.setVisible(false);
        avisoCpf.setVisible(false);
        avisoEndereco.setVisible(false);
        avisoN.setVisible(false);
        avisoEmail.setVisible(false);
        
        carregarPrincipal1.setVisible(false);
    }
}