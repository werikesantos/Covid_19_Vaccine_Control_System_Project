/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sobrevida.vacinaSARSCoV2.controller;

import br.com.sobrevida.vacinaSARSCoV2.model.dao.UsuarioDao;

/**
 *
 * @author WERIKE
 */
public class UsuarioController{

    public boolean tentarLogar(String email, String senha, boolean resultado){
            
        boolean result = resultado;
        
        if((!"".equals(email)) && (!"".equals(senha))){
            
            UsuarioDao usuarioDao = new UsuarioDao();
            resultado = usuarioDao.tentarLogar(email, senha, false);
            
            if(resultado == true){
                return resultado;
            } 
        }
        return result;
    }  
}
