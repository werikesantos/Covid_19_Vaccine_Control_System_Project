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
    
    ConnectionFactory connectionFactory = new ConnectionFactory();
    PreparedStatement ps; 
    ResultSet result;
    CidadaoModel cidadao = new CidadaoModel();
    
    public boolean salvar(CidadaoModel cidadaoModel, boolean resultado){
         
        boolean result = resultado;
        
        String sql = 
            "INSERT INTO "
                +"bd_vacina_sars_cov_2.cidadao(nome, nascimento, celular, cpf, endereco, n, email) "
            +"VALUES "
                +"(?, ?, ?, ?, ?, ?, ?)";
        
        try(Connection conn = connectionFactory.connection()){
            
            ps = conn.prepareStatement(sql);
            
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
        
        try(Connection conn = connectionFactory.connection()){
            
            ps = conn.prepareStatement(sql);
              
            ps.setInt(1, cidadao.getId());
            
            result = ps.executeQuery();
            
            while(result.next()){
                int id = result.getInt("id");
                String nome = result.getString("nome");
                String nascimento = result.getString("nascimento");
                String celular = result.getString("celular");
                String cpf = result.getString("cpf");
                String endereco = result.getString("endereco");
                String n = result.getString("n");
                String email = result.getString("email");
                
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
        
        try(Connection conn = connectionFactory.connection()){

            ps = conn.prepareStatement(sql);

            ps.setString(1, dado + "%");

            result = ps.executeQuery();

            pacienteLista.setModel(DbUtils.resultSetToTableModel(result));
            
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

        try(Connection conn = connectionFactory.connection()){
            
            ps = conn.prepareStatement(sql);
            
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

        try(Connection conn = connectionFactory.connection()){
            
            ps = conn.prepareStatement(sql);
            
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
