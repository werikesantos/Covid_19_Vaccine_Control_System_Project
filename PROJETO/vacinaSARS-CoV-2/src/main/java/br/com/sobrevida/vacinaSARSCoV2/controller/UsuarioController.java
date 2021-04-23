/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sobrevida.vacinaSARSCoV2.controller;

import br.com.sobrevida.vacinaSARSCoV2.model.UsuarioModel;
import br.com.sobrevida.vacinaSARSCoV2.model.dao.ConnectionFactory;
import br.com.sobrevida.vacinaSARSCoV2.model.dao.UsuarioDao;
import br.com.sobrevida.vacinaSARSCoV2.view.Carregar1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


/**
 *
 * @author WERIKE
 */
public class UsuarioController{
    
    UsuarioDao usuarioDao = new UsuarioDao();
    UsuarioModel usuarioModel = new UsuarioModel();

    public UsuarioController() {
        
    }
    
    public UsuarioController(UsuarioModel usuarioModel) {
        String email = usuarioModel.getEmail();
        String senha = usuarioModel.getSenha();
    }
        
    /*public void logar(String email, String senha){
        
        //mandar para dao
        usuarioDao.logar(email, senha);
    }*/
    
    public boolean logar(String email, String senha, boolean resultado){
        
        boolean result = resultado;
        
        if((!"".equals(email)) && (!"".equals(senha))){
            
            UsuarioDao usuarioDao = new UsuarioDao();
            
            resultado = usuarioDao.logar(email, senha, false);
            
            if(resultado == true){
                JOptionPane.showMessageDialog(null, "Seja Bem-Vindo!" 
                    ,"Login aceito", JOptionPane.WARNING_MESSAGE);
            }else{
                
                return resultado;
                
            }

        }else{
            /*JOptionPane.showMessageDialog(null, "O nome de usuário e a senha "
                    + "que você digitou não\n batem com nossos registros. "
                    + "Por favor, verifique e\n tente novamente." 
                ,"Login Inválido", JOptionPane.WARNING_MESSAGE);*/
        }
        

        /*
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
                    Carregar1 carregar1 = new Carregar1();
                    carregar1.setVisible(true);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }*/
        
        //mandar para dao
        //usuarioDao.logar(email, senha);
        
        return result;
    }   
}
