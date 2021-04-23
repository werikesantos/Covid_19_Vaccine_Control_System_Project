/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sobrevida.vacinaSARSCoV2.controller;

import br.com.sobrevida.vacinaSARSCoV2.model.UsuarioModel;
import br.com.sobrevida.vacinaSARSCoV2.model.dao.UsuarioDao;


/**
 *
 * @author WERIKE
 */
public class UsuarioController{
    
    UsuarioDao usuarioDao = new UsuarioDao();
    UsuarioModel usuarioModel = new UsuarioModel();
        
    public void logar(String email, String senha){
        
        //mandar para dao
        usuarioDao.logar(email, senha);
    }

}
