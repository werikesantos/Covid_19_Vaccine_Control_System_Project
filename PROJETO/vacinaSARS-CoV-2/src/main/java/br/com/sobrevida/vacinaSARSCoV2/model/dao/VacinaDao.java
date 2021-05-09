package br.com.sobrevida.vacinaSARSCoV2.model.dao;

import br.com.sobrevida.vacinaSARSCoV2.model.VacinaModel;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author WERIKE
 */
public class VacinaDao{
    
    VacinaModel vacinaModel = new VacinaModel();
    
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
    
}
