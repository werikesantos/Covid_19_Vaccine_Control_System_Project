package br.com.sobrevida.vacinaSARSCoV2.controller;

import br.com.sobrevida.vacinaSARSCoV2.model.CidadaoModel;
import br.com.sobrevida.vacinaSARSCoV2.model.dao.CidadaoDao;
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
       
    public void salvar(JLabel avisoNome, JLabel avisoNascimento, JLabel avisoCelular, 
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
                JOptionPane.showMessageDialog(null, "Paciente cadastrado com sucesso!"
                    ,"Cadastro de Paciente", JOptionPane.WARNING_MESSAGE);
                
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

    public void consulta(JTextField pacienteConsultar, JTextField pacienteIdCodigo, 
        JTextField pacientePrimeiroNome, JTextField pacienteSobreNome, JTextField pacienteNascimento, 
        JTextField pacienteCelular, JTextField pacienteCpf, JTextField pacienteEndereco, 
        JTextField pacienteEnderecoNumero, JTextField pacienteEmail){

        String converterID = pacienteConsultar.getText();
            
        if(!"".equals(converterID) && !"Consultar...".equals(converterID)){
                
            int id = Integer.parseInt(converterID);
            cidadaoModel.setId(id);
            CidadaoModel result = cidadaoDao.consulta(cidadaoModel); 

            id = result.getId();
            String resultID = Integer.toString(id);

            String nome = result.getNome();
            String[] resultado = nome.split(" ");
            String primeiro = resultado[0];
            String segundo = resultado[1];

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
    
    public void pesquisa(JTable listaPacientes, String dado){     
        cidadaoDao.pesquisa(listaPacientes, dado);    
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
    
    public boolean deletar(int id, String nome, boolean resultado){
            
        boolean result = resultado;
        
        JOptionPane.showMessageDialog(null, "O usuário será deletado.\nID: "+id+"\nNome: "+nome
            ,"Atenção", JOptionPane.WARNING_MESSAGE);
        
        if((!"".equals(id))){
            
            cidadaoModel.setId(id);
            
            resultado = cidadaoDao.deletar(cidadaoModel, false);
                
            if(resultado == true){
                return resultado;
            }
        }
        return result;
    }
    
    public void limpar(JLabel avisoNome, JLabel avisoNascimento, JLabel avisoCelular, 
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
    }
}