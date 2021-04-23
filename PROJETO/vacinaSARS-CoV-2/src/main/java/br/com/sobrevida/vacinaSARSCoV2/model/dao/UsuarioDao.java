/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sobrevida.vacinaSARSCoV2.model.dao;

import br.com.sobrevida.vacinaSARSCoV2.controller.UsuarioController;
import br.com.sobrevida.vacinaSARSCoV2.model.UsuarioModel;
import br.com.sobrevida.vacinaSARSCoV2.view.Carregar1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author WERIKE
 */
public class UsuarioDao{
        
    public boolean logar(String email, String senha, boolean resultado){
        
        boolean result = resultado;
        
        //1: Definir o comando SQL
        String sql = "SELECT email, senha FROM bd_vacinasars_cov_2.usuario";
        
        //2: Abrir uma conexão
        ConnectionFactory connectionFactory = new ConnectionFactory();
        
        try(Connection conn = connectionFactory.connection()){
        
            //3: Pré compila o comando
            PreparedStatement ps = conn.prepareStatement(sql);

            //4: Executa o comando e guarda
            //o resultado em um ResultSet
            ResultSet rs = ps.executeQuery();
            
            //5: itera sobre o resultado
            while(rs.next()){
                
                String bancoEmail = rs.getString("email");
                String bancoSenha = rs.getString("senha");
                                
                if((email.equals(bancoEmail)) && (senha.equals(bancoSenha))){
                    
                    UsuarioModel usuarioModel = new UsuarioModel();

                    usuarioModel.setEmail(bancoEmail);
                    usuarioModel.setSenha(bancoSenha);
                    
                    UsuarioController usuarioController = new UsuarioController(usuarioModel);
                    
                    
                    /*
                    resultado = true;
                    
                    Carregar1 carregar1 = new Carregar1();
                    carregar1.setVisible(true);*/
                }
                    
                resultado = false;
                    
                JOptionPane.showMessageDialog(null, "O nome de usuário e a senha "
                    + "que você digitou não\n batem com nossos registros. "
                    + "Por favor, verifique e\n tente novamente." 
                    ,"Login Inválido", JOptionPane.WARNING_MESSAGE);
                
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
        return result;
    }
    
    /*
    public void logar(String email, String senha){
        
        //1: Definir o comando SQL
        String sql = "SELECT email, senha FROM bd_vacinasars_cov_2.usuario WHERE(email=? and senha=?)";
        
        //2: Abrir uma conexão
        ConnectionFactory connectionFactory = new ConnectionFactory();
        
        try(Connection conn = connectionFactory.connection()){
            
            //3: Pré compila o comando
            PreparedStatement ps = conn.prepareStatement(sql);
            
            //4: Preenche os dados faltantes
            ps.setString(1, email);
            ps.setString(2, senha);
            
            //5: Executa o comando
            resultado = ps.executeQuery();
            
            if(resultado.next()){
                
                Carregar1 carregar1 = new Carregar1();
                carregar1.setVisible(true);
                        
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }*/
}
