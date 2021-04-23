/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sobrevida.vacinaSARSCoV2.controller;

import br.com.sobrevida.vacinaSARSCoV2.model.dao.ConnectionFactory;
import br.com.sobrevida.vacinaSARSCoV2.model.PessoaModel;
import br.com.sobrevida.vacinaSARSCoV2.model.dao.PessoaDao;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author WERIKE
 */
public class PessoaController{
    
    PessoaDao pessoaDao = new PessoaDao();
    PessoaModel pessoaModel = new PessoaModel();
    
    public void inserir(String nome, String fone, String email){
        //FAÇO VALIDAÇÕES DOS DADOS
        pessoaModel.setNome(nome);
        
        pessoaDao.inserir(pessoaModel);
    }
    
    /*
    public void inserir(PessoaModel pm){
        //1: Definir o comando SQL
        String sql = "INSERT INTO tb_pessoa(nome, fone, email) VALUES (?, ?, ?)";
        
        //2: Abrir uma conexão
        Dao dao = new Dao();
        try(Connection conn = dao.connection()){
            
            //3: Pré compila o comando
            PreparedStatement ps = conn.prepareStatement(sql);
            
            //4: Preenche os dados faltantes
            ps.setString(1, pm.getNome());
            ps.setString(2, pm.getFone());
            ps.setString(3, pm.getEmail());
            
            //5: Executa o comando
            ps.execute();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    
    }*/
    
}
