package br.com.sobrevida.vacinaSARSCoV2.model.dao;

import br.com.sobrevida.vacinaSARSCoV2.model.PessoaModel;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author WERIKE
 */
public class PessoaDao{
    
    public void inserir(PessoaModel pessoaModel){
        
        String sql = "INSERT INTO tb_pessoa(nome, fone, email) VALUES (?, ?, ?)";
        
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try(Connection conn = connectionFactory.connection()){
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, pessoaModel.getNome());
            ps.setString(2, pessoaModel.getFone());
            ps.setString(3, pessoaModel.getEmail());
            
            ps.execute();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    } 
}
