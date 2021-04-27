package br.com.sobrevida.vacinaSARSCoV2.model.dao;

import br.com.sobrevida.vacinaSARSCoV2.model.UsuarioModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author WERIKE
 */
public class UsuarioDao{
      
    public boolean logar(UsuarioModel usuarioModel, boolean resultado){
         
        boolean result = resultado;
        
        String email = usuarioModel.getEmail();
        String senha = usuarioModel.getSenha();
        
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
    
    public boolean cadastrar(UsuarioModel usuarioModel, boolean resultado){
         
        boolean result = resultado;
        
        String sql = "INSERT INTO bd_vacinasars_cov_2.usuario(idPerfil, email, senha) VALUES (3, ?, ?)";
        
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try(Connection conn = connectionFactory.connection()){
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, usuarioModel.getEmail());
            ps.setString(2, usuarioModel.getSenha());
            
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
        
        String sql = "UPDATE bd_vacinasars_cov_2.usuario SET senha = ? WHERE (email = ?)";
        
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try(Connection conn = connectionFactory.connection()){
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, usuarioModel.getSenha());
            ps.setString(2, usuarioModel.getEmail());
            
            ps.execute();
            
            return resultado = true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}