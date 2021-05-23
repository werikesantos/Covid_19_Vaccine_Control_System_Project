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
    
    ConnectionFactory connectionFactory = new ConnectionFactory();
    PreparedStatement ps; 
    ResultSet result;
    
    public boolean logar(UsuarioModel usuarioModel, boolean resultado){
         
        boolean re = resultado;
        
        String email = usuarioModel.getEmail();
        String senha = usuarioModel.getSenha();
        
        String sql = "SELECT email, senha FROM bd_vacina_sars_cov_2.usuario";
        
        try(Connection conn = connectionFactory.connection()){
        
            ps = conn.prepareStatement(sql);

            result = ps.executeQuery();
            
            while(result.next()){
                String bancoEmail = result.getString("email");
                String bancoSenha = result.getString("senha");
                                
                if((email.equals(bancoEmail)) && (senha.equals(bancoSenha))){
                    ps.close();
                    resultado = true;
                    return resultado;
                }  
            }
            ps.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return re;
    }
    
    public boolean cadastrar(UsuarioModel usuarioModel, boolean resultado){
         
        boolean result = resultado;
        
        String sql = "INSERT INTO bd_vacina_sars_cov_2.usuario(idPerfil, email, senha) VALUES (3, ?, ?)";
        
        try(Connection conn = connectionFactory.connection()){
            
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, usuarioModel.getEmail());
            ps.setString(2, usuarioModel.getSenha());
            
            ps.execute();
            
            ps.close();
            
            return resultado = true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    public boolean trocarSenha(UsuarioModel usuarioModel, boolean resultado){
         
        boolean result = resultado;
        
        String sql = "UPDATE bd_vacina_sars_cov_2.usuario SET senha = ? WHERE (email = ?)";

        try(Connection conn = connectionFactory.connection()){
            
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, usuarioModel.getSenha());
            ps.setString(2, usuarioModel.getEmail());
            
            ps.execute();
            
            ps.close();
            
            return resultado = true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}