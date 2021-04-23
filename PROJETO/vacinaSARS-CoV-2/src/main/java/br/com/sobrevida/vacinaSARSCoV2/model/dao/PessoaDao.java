/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sobrevida.vacinaSARSCoV2.model.dao;

import br.com.sobrevida.vacinaSARSCoV2.controller.PessoaController;
import br.com.sobrevida.vacinaSARSCoV2.model.PessoaModel;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author WERIKE
 */
public class PessoaDao {
    
    public void inserir(PessoaModel pessoaModel){
        
        //1: Definir o comando SQL
        String sql = "INSERT INTO tb_pessoa(nome, fone, email) VALUES (?, ?, ?)";
        
        //2: Abrir uma conexão
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try(Connection conn = connectionFactory.connection()){
            
            //3: Pré compila o comando
            PreparedStatement ps = conn.prepareStatement(sql);
            
            //4: Preenche os dados faltantes
            ps.setString(1, pessoaModel.getNome());
            ps.setString(2, pessoaModel.getFone());
            ps.setString(3, pessoaModel.getEmail());
            
            //5: Executa o comando
            ps.execute();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    
    }
    
}
