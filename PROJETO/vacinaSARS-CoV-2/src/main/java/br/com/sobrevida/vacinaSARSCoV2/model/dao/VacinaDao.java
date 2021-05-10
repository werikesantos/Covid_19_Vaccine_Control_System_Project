package br.com.sobrevida.vacinaSARSCoV2.model.dao;

import br.com.sobrevida.vacinaSARSCoV2.model.VacinaModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author WERIKE
 */
public class VacinaDao{
    
    VacinaModel vacina = new VacinaModel();
    
    public boolean salvar(VacinaModel vacinaModel, boolean resultado){
         
        boolean result = resultado;
        
        String sql = 
            "INSERT INTO "
                +"bd_vacina_sars_cov_2.vacina(desenvolvedora, produtora, parceira, qtd_Dose, periodo, descricao) "
            +"VALUES "
                +"(?, ?, ?, ?, ?, ?)";
        
        ConnectionFactory connectionFactory = new ConnectionFactory();
        
        try(Connection conn = connectionFactory.connection()){
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, vacinaModel.getDesenvolvedora());
            ps.setString(2, vacinaModel.getProdutora());
            ps.setString(3, vacinaModel.getParceira());
            ps.setInt(4, vacinaModel.getQtd_Dose());
            ps.setString(5, vacinaModel.getPeriodo());
            ps.setString(6, vacinaModel.getDescicao());
            
            ps.execute();
            ps.close();
            
            return resultado = true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    public boolean alterar(VacinaModel vacinaModel, boolean resultado){
         
        boolean result = resultado;

        String sql = 
            "UPDATE "
                +"bd_vacina_sars_cov_2.vacina "
            +"SET "
                +"desenvolvedora = ?, produtora = ?, parceira = ?, qtd_Dose = ?, periodo = ?, "
                +"descricao = ? "
            +"WHERE id = ?";
        
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try(Connection conn = connectionFactory.connection()){
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, vacinaModel.getDesenvolvedora());
            ps.setString(2, vacinaModel.getProdutora());
            ps.setString(3, vacinaModel.getParceira());
            ps.setInt(4, vacinaModel.getQtd_Dose());
            ps.setString(5, vacinaModel.getPeriodo());
            ps.setString(6, vacinaModel.getDescicao());
            ps.setInt(7, vacinaModel.getId());
            
            ps.execute();
            ps.close();
            
            return resultado = true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    public boolean deletar(VacinaModel vacinaModel, boolean resultado){
         
        boolean result = resultado;
        
        String sql = 
            "DELETE FROM "
                +"bd_vacina_sars_cov_2.vacina "
            +"WHERE "
                +"id = ?";
        
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try(Connection conn = connectionFactory.connection()){
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, vacinaModel.getId());
            
            ps.execute();
            ps.close();
            
            return resultado = true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    public VacinaModel consultar(VacinaModel vacinaModel){

        vacina = vacinaModel;
                
        String sql = 
            "SELECT * FROM "
                +"bd_vacina_sars_cov_2.vacina "
            +"WHERE "
                +"id = ?";
        
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try(Connection conn = connectionFactory.connection()){
            
            PreparedStatement ps = conn.prepareStatement(sql);
              
            ps.setInt(1, vacina.getId());
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String desenvolvedora = rs.getString("desenvolvedora");
                String produtora = rs.getString("produtora");
                String parceira = rs.getString("parceira");
                int qtd_dose = rs.getInt("qtd_dose");
                String periodo = rs.getString("periodo");
                String descricao = rs.getString("descricao");
                
                vacinaModel.setId(id);
                vacinaModel.setDesenvolvedora(desenvolvedora);
                vacinaModel.setProdutora(produtora);
                vacinaModel.setParceira(parceira);
                vacinaModel.setQtd_Dose(qtd_dose);
                vacinaModel.setPeriodo(periodo);
                vacinaModel.setDescicao(descricao);
                
                return vacinaModel;
            }
            ps.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return vacina;
    }
    
    public void pesquisar(JTable vacinaLista, String dado){

        String sql = 
            "SELECT * FROM "
                +"bd_vacina_sars_cov_2.vacina "
            +"WHERE "
                +"id LIKE ?";
        
        ConnectionFactory connectionFactory = new ConnectionFactory();
        
        try(Connection conn = connectionFactory.connection()){

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, dado + "%");

            ResultSet rs = ps.executeQuery();

            vacinaLista.setModel(DbUtils.resultSetToTableModel(rs));
            
            ps.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
