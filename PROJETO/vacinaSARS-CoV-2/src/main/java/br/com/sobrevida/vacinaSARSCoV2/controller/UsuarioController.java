package br.com.sobrevida.vacinaSARSCoV2.controller;

import br.com.sobrevida.vacinaSARSCoV2.model.UsuarioModel;
import br.com.sobrevida.vacinaSARSCoV2.model.dao.UsuarioDao;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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
    
    public boolean cadastrar(String email, String senha, String nomeUsuario, String apelidoUsuario, String cpfUsuario, 
        boolean resultado, JLabel carga, JTextField loginEmail, JTextField loginSenha, JTextField loginSenha1, 
        JTextField mostraSenha, JTextField mostraSenha1){
            
        boolean result = resultado;
        
        if((!"".equals(email)) && (!"".equals(nomeUsuario)) && (!"".equals(apelidoUsuario)) && (!"".equals(cpfUsuario)) 
            && (!"".equals(senha))){
            
            int contador = email.length();
            
            for(int i=0; i < contador; i++){
                if(email.charAt(i) == '@'){
                    usuarioModel.setEmail(email);
                }  
            }
            
            if((usuarioModel.getEmail()) != null){                
                
                usuarioModel.setSenha(senha);
                usuarioModel.setNomeCompleto(nomeUsuario);
                usuarioModel.setApelido(apelidoUsuario);
                usuarioModel.setCpfUsuario(cpfUsuario);

                    resultado = usuarioDao.cadastrar(usuarioModel, false);
                
                    if(resultado == true){
                        return resultado;
                    }
            }else{
                carga.setVisible(false);
                loginEmail.setText("");
                loginSenha.setText("");
                loginSenha1.setText("");
                mostraSenha.setText("");
                mostraSenha1.setText("");
                JOptionPane.showMessageDialog(null, "Este não é um E-mail válido!", "Atenção", 
                    JOptionPane.ERROR_MESSAGE
                );
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