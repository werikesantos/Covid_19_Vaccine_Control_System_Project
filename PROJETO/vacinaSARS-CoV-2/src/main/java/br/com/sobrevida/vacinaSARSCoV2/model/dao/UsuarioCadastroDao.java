/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sobrevida.vacinaSARSCoV2.model.dao;

import br.com.sobrevida.vacinaSARSCoV2.model.UsuarioModel;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author WERIKE
 */
public class UsuarioCadastroDao {
    
    public boolean tentarLogar(UsuarioModel usuarioModel, boolean resultado){
         
        boolean result = resultado;
        
        //1: Definir o comando SQL
        String sql = "INSERT INTO bd_vacinasars_cov_2.usuario(idPerfil, email, senha) VALUES (3, ?, ?)";
        
        //2: Abrir uma conexão
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try(Connection conn = connectionFactory.connection()){
            
            //3: Pré compila o comando
            PreparedStatement ps = conn.prepareStatement(sql);
            
            //4: Preenche os dados faltantes
            ps.setString(1, usuarioModel.getEmail());
            ps.setString(2, usuarioModel.getSenha());
            
            //5: Executa o comando
            ps.execute();
            
            return resultado = true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    public boolean trocarSenha(UsuarioModel usuarioModel, boolean resultado){
         
        boolean result = resultado;
        
        //1: Definir o comando SQL
        String sql = "UPDATE bd_vacinasars_cov_2.usuario SET senha = ? WHERE (email = ?)";
        
        //2: Abrir uma conexão
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try(Connection conn = connectionFactory.connection()){
            
            //3: Pré compila o comando
            PreparedStatement ps = conn.prepareStatement(sql);
            
            //4: Preenche os dados faltantes
            ps.setString(1, usuarioModel.getSenha());
            ps.setString(2, usuarioModel.getEmail());
            
            //5: Executa o comando
            ps.execute();
            
            return resultado = true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
