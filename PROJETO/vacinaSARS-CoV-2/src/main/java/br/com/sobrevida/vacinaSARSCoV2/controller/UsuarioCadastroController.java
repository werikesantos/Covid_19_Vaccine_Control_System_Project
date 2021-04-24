/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sobrevida.vacinaSARSCoV2.controller;

import br.com.sobrevida.vacinaSARSCoV2.model.dao.UsuarioCadastroDao;
import br.com.sobrevida.vacinaSARSCoV2.model.UsuarioModel;

/**
 *
 * @author WERIKE
 */
public class UsuarioCadastroController{
    
    UsuarioModel usuarioModel = new UsuarioModel();
    
    public boolean tentarLogar(String email, String senha, boolean resultado){
            
        boolean result = resultado;
        
        if((!"".equals(email)) && (!"".equals(senha))){
            
            usuarioModel.setEmail(email);
            usuarioModel.setSenha(senha);
            
            UsuarioCadastroDao usuarioCadastroDao = new UsuarioCadastroDao();
            resultado = usuarioCadastroDao.tentarLogar(usuarioModel, false);
                
            if(resultado == true){
                return resultado;
            }
            
            /*
            UsuarioDao usuarioDao = new UsuarioDao();
            resultado = usuarioDao.tentarLogar(email, senha, false);
            
            if(resultado == true){
                return resultado;
            } */
        }
        return result;
    }
}
