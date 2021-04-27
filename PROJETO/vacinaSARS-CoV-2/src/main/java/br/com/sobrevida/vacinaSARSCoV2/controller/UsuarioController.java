package br.com.sobrevida.vacinaSARSCoV2.controller;

import br.com.sobrevida.vacinaSARSCoV2.model.UsuarioModel;
import br.com.sobrevida.vacinaSARSCoV2.model.dao.UsuarioDao;

/**
 *
 * @author WERIKE
 */
public class UsuarioController{
    
    UsuarioModel usuarioModel = new UsuarioModel();
    UsuarioDao usuarioDao = new UsuarioDao();
    
    public boolean logar(String email, String senha, boolean resultado){
            
        boolean result = resultado;
        
        if((!"".equals(email)) && (!"".equals(senha))){
            
            usuarioModel.setEmail(email);
            usuarioModel.setSenha(senha);
            
            resultado = usuarioDao.logar(usuarioModel, false);
            
            if(resultado == true){
                return resultado;
            } 
        }
        return result;
    } 
    
    public boolean cadastrar(String email, String senha, boolean resultado){
            
        boolean result = resultado;
        
        if((!"".equals(email)) && (!"".equals(senha))){
            
            usuarioModel.setEmail(email);
            usuarioModel.setSenha(senha);
            
            resultado = usuarioDao.cadastrar(usuarioModel, false);
                
            if(resultado == true){
                return resultado;
            }
        }
        return result;
    }
    
    public boolean trocarSenha(String email, String newSenha, boolean resultado){
            
        boolean result = resultado;
        
        if((!"".equals(email)) && (newSenha != null)){
            
            usuarioModel.setEmail(email);
            usuarioModel.setSenha(newSenha);
            
            resultado = usuarioDao.trocarSenha(usuarioModel, false);
                
            if(resultado == true){
                return resultado;
            }
        }
        return result;
    }
}
