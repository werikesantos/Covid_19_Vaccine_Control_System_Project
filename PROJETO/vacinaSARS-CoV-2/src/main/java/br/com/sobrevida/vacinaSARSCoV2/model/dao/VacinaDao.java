package br.com.sobrevida.vacinaSARSCoV2.model.dao;

import br.com.sobrevida.vacinaSARSCoV2.model.VacinaModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author WERIKE
 */
public class VacinaDao{
    
    ConnectionFactory connectionFactory = new ConnectionFactory();
    PreparedStatement ps; 
    ResultSet result;
    VacinaModel vacina = new VacinaModel();
    
    public boolean salvar(VacinaModel vacinaModel, boolean resultado){
         
        boolean result = resultado;
        
        String sql = 
            "INSERT INTO "
                +"bd_vacina_sars_cov_2.vacina(desenvolvedora, produtora, parceira, qtd_Dose, periodo, descricao) "
            +"VALUES "
                +"(?, ?, ?, ?, ?, ?)";

        try(Connection conn = connectionFactory.connection()){
            
            ps = conn.prepareStatement(sql);
            
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

        try(Connection conn = connectionFactory.connection()){
            
            ps = conn.prepareStatement(sql);
            
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

        try(Connection conn = connectionFactory.connection()){
            
            ps = conn.prepareStatement(sql);
            
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
    
    public VacinaModel consultar(VacinaModel vacinaModel, JLabel carregarPrincipal2){

        vacina = vacinaModel;
                
        String sql = 
            "SELECT * FROM "
                +"bd_vacina_sars_cov_2.vacina "
            +"WHERE "
                +"id = ?";

        try(Connection conn = connectionFactory.connection()){
            
            ps = conn.prepareStatement(sql);
              
            ps.setInt(1, vacina.getId());
            
            result = ps.executeQuery();
            
            while(result.next()){
                int id = result.getInt("id");
                String desenvolvedora = result.getString("desenvolvedora");
                String produtora = result.getString("produtora");
                String parceira = result.getString("parceira");
                int qtd_dose = result.getInt("qtd_dose");
                String periodo = result.getString("periodo");
                String descricao = result.getString("descricao");
                
                vacinaModel.setId(id);
                vacinaModel.setDesenvolvedora(desenvolvedora);
                vacinaModel.setProdutora(produtora);
                vacinaModel.setParceira(parceira);
                vacinaModel.setQtd_Dose(qtd_dose);
                vacinaModel.setPeriodo(periodo);
                vacinaModel.setDescicao(descricao);
                
                carregarPrincipal2.setVisible(false);
                
                return vacinaModel;
            }
            ps.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return vacina;
    }
    
    public void pesquisar(JTable vacinaListaTabela, String dado){

        String sql = 
            "SELECT id AS CÓDIGO, desenvolvedora AS DESENVOLVEDOR, produtora AS PRODUTORA, parceira AS PARCEIRA, qtd_Dose AS QTD_DOSE, periodo AS PERÍODO, descricao AS DESCRIÇÃO FROM "
                +"bd_vacina_sars_cov_2.vacina "
            +"WHERE "
                +"desenvolvedora LIKE ?";

        try(Connection conn = connectionFactory.connection()){

            ps = conn.prepareStatement(sql);

            ps.setString(1, dado + "%");

            result = ps.executeQuery();

            vacinaListaTabela.setModel(DbUtils.resultSetToTableModel(result));
            
            ps.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void pesquisar(JTable vacinaListaTabela){

        String sql = 
            "SELECT id AS CÓDIGO, desenvolvedora AS DESENVOLVEDOR, produtora AS PRODUTORA, parceira AS PARCEIRA, qtd_Dose AS QTD_DOSE, periodo AS PERÍODO, descricao AS DESCRIÇÃO FROM "
                +"bd_vacina_sars_cov_2.vacina";

        try(Connection conn = connectionFactory.connection()){

            ps = conn.prepareStatement(sql);

            result = ps.executeQuery();

            vacinaListaTabela.setModel(DbUtils.resultSetToTableModel(result));
            
            ps.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
