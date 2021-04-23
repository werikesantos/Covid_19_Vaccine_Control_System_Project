/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sobrevida.vacinaSARSCoV2.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author WERIKE
 */
public class UsuarioDao{
        
    public boolean tentarLogar(String email, String senha, boolean resultado){
         
        boolean result = resultado;
        
        String sql = "SELECT email, senha FROM bd_vacinasars_cov_2.usuario";
        
        ConnectionFactory connectionFactory = new ConnectionFactory();
        
        try(Connection conn = connectionFactory.connection()){
        
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String bancoEmail = rs.getString("email");
                String bancoSenha = rs.getString("senha");
                                
                if((email.equals(bancoEmail)) && (senha.equals(bancoSenha))){
                    resultado = true;
                    return resultado;
                }  
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
