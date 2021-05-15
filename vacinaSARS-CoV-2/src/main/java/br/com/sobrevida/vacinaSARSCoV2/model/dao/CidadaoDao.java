package br.com.sobrevida.vacinaSARSCoV2.model.dao;

import br.com.sobrevida.vacinaSARSCoV2.model.CidadaoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
//BIBLIOTECA PARA PESQUISA AVANÇADA
import net.proteanit.sql.DbUtils;

/**
 *
 * @author WERIKE
 */
public class CidadaoDao{
    
    CidadaoModel cidadao = new CidadaoModel();
    
    public boolean salvar(CidadaoModel cidadaoModel, boolean resultado){
         
        boolean result = resultado;
        
        String sql = 
            "INSERT INTO "
                +"bd_vacina_sars_cov_2.cidadao(nome, nascimento, celular, cpf, endereco, n, email) "
            +"VALUES "
                +"(?, ?, ?, ?, ?, ?, ?)";
        
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try(Connection conn = connectionFactory.connection()){
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, cidadaoModel.getNome());
            ps.setString(2, cidadaoModel.getNascimento());
            ps.setString(3, cidadaoModel.getCelular());
            ps.setString(4, cidadaoModel.getCpf());
            ps.setString(5, cidadaoModel.getEndereco());
            ps.setString(6, cidadaoModel.getN());
            ps.setString(7, cidadaoModel.getEmail());
            
            ps.execute();
            ps.close();
            
            return resultado = true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    public CidadaoModel consulta(CidadaoModel cidadaoModel){

        cidadao = cidadaoModel;
                
        String sql = 
            "SELECT * FROM "
                +"bd_vacina_sars_cov_2.cidadao "
            +"WHERE "
                +"id = ?";
        
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try(Connection conn = connectionFactory.connection()){
            
            PreparedStatement ps = conn.prepareStatement(sql);
              
            ps.setInt(1, cidadao.getId());
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String nascimento = rs.getString("nascimento");
                String celular = rs.getString("celular");
                String cpf = rs.getString("cpf");
                String endereco = rs.getString("endereco");
                String n = rs.getString("n");
                String email = rs.getString("email");
                
                cidadaoModel.setId(id);
                cidadaoModel.setNome(nome);
                cidadaoModel.setNascimento(nascimento);
                cidadaoModel.setCelular(celular);
                cidadaoModel.setCpf(cpf);
                cidadaoModel.setEndereco(endereco);
                cidadaoModel.setN(n);
                cidadaoModel.setEmail(email);
                
                return cidadaoModel;
            }
            ps.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return cidadao;
    }
    
    public void pesquisa(JTable pacienteLista, String dado){

        String sql = 
            "SELECT * FROM "
                +"bd_vacina_sars_cov_2.cidadao "
            +"WHERE "
                +"cpf LIKE ?";
        
        ConnectionFactory connectionFactory = new ConnectionFactory();
        
        try(Connection conn = connectionFactory.connection()){

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, dado + "%");

            ResultSet rs = ps.executeQuery();

            pacienteLista.setModel(DbUtils.resultSetToTableModel(rs));
            
            ps.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean alterar(CidadaoModel cidadaoModel, boolean resultado){
         
        boolean result = resultado;

        String sql = 
            "UPDATE "
                +"bd_vacina_sars_cov_2.cidadao "
            +"SET "
                +"nome = ?, nascimento = ?, celular = ?, cpf = ?, endereco = ?, "
                +"n = ?, email = ? "
            +"WHERE id = ?";
        
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try(Connection conn = connectionFactory.connection()){
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, cidadaoModel.getNome());
            ps.setString(2, cidadaoModel.getNascimento());
            ps.setString(3, cidadaoModel.getCelular());
            ps.setString(4, cidadaoModel.getCpf());
            ps.setString(5, cidadaoModel.getEndereco());
            ps.setString(6, cidadaoModel.getN());
            ps.setString(7, cidadaoModel.getEmail());
            ps.setInt(8, cidadaoModel.getId());
            
            ps.execute();
            ps.close();
            
            return resultado = true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    public boolean deletar(CidadaoModel cidadaoModel, boolean resultado){
         
        boolean result = resultado;
        
        String sql = 
            "DELETE FROM "
                +"bd_vacina_sars_cov_2.cidadao "
            +"WHERE "
                +"id = ?";
        
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try(Connection conn = connectionFactory.connection()){
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, cidadaoModel.getId());
            
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
