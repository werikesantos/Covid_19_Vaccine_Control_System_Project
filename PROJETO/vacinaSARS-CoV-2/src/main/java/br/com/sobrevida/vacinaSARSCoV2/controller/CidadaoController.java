package br.com.sobrevida.vacinaSARSCoV2.controller;

import br.com.sobrevida.vacinaSARSCoV2.model.CidadaoModel;
import br.com.sobrevida.vacinaSARSCoV2.model.dao.CidadaoDao;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author WERIKE
 */
public class CidadaoController {
    
    CidadaoModel cidadaoModel = new CidadaoModel();
    CidadaoDao cidadaoDao = new CidadaoDao();
            
    public boolean salvar(String nome, String nascimento, String celular,
        String cpf, String endereco, String n, String email, boolean resultado){
            
        boolean result = resultado;
        
        if((!"".equals(nome)) && (!"".equals(nascimento)) && (!"".equals(celular)) 
            && (!"".equals(cpf)) && (!"".equals(endereco)) && (!"".equals(n)) 
            && (!"".equals(email))){
            
            cidadaoModel.setNome(nome);
            cidadaoModel.setNascimento(nascimento);
            cidadaoModel.setCelular(celular);
            cidadaoModel.setCpf(cpf);
            cidadaoModel.setEndereco(endereco);
            cidadaoModel.setN(n);
            cidadaoModel.setEmail(email);
            
            resultado = cidadaoDao.salvar(cidadaoModel, false);
                
            if(resultado == true){
                return resultado;
            }
        }
        return result;
    } 
    
    public CidadaoModel consultar(int id){
            
        cidadaoModel.setId(id);
        CidadaoModel resultCidadaoModel = cidadaoDao.consultar(cidadaoModel); 
        
        return resultCidadaoModel;
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
}