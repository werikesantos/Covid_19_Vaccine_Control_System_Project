package br.com.sobrevida.vacinaSARSCoV2.controller;

import br.com.sobrevida.vacinaSARSCoV2.model.CidadaoModel;
import br.com.sobrevida.vacinaSARSCoV2.model.dao.CidadaoDao;

/**
 *
 * @author WERIKE
 */
public class CidadaoController {
    
    CidadaoModel cidadaoModel = new CidadaoModel();
    CidadaoDao cidadaoDao = new CidadaoDao();
            
    public boolean cadastrar(String nome, String nascimento, String celular,
        String cpf, String endereco, String numero, String email, boolean resultado){
            
        boolean result = resultado;
        
        if((!"".equals(nome)) && (!"".equals(nascimento)) && (!"".equals(celular)) 
                && (!"".equals(cpf)) && (!"".equals(endereco)) && (!"".equals(numero)) 
                && (!"".equals(email))){
            
            cidadaoModel.setNome(nome);
            cidadaoModel.setNascimento(nascimento);
            cidadaoModel.setCelular(celular);
            cidadaoModel.setCpf(cpf);
            cidadaoModel.setEndereco(endereco);
            cidadaoModel.setNumero(numero);
            cidadaoModel.setEmail(email);
            
            resultado = cidadaoDao.cadastrar(cidadaoModel, false);
                
            if(resultado == true){
                return resultado;
            }
        }
        return result;
    } 
    
    public CidadaoModel consultar(int id){
            
        cidadaoModel.setId(id);
        CidadaoModel resultCidadaoModel =cidadaoDao.consultar(cidadaoModel); 
        
        return resultCidadaoModel;
    } 
}