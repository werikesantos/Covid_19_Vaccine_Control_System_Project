package br.com.sobrevida.vacinaSARSCoV2.model.dao;

import br.com.sobrevida.vacinaSARSCoV2.model.VacinaModel;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author WERIKE
 */
public class AplicacaoDao{
    
    public List<VacinaModel> buscar(){

        List<VacinaModel> vacinas = new ArrayList<>();
                
        String sql = 
            "SELECT "
                +"desenvolvedora "
            +"FROM "
                +"bd_vacina_sars_cov_2.vacina";
        
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try(Connection conn = connectionFactory.connection()){
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                VacinaModel vacinaModel = new VacinaModel();

                vacinaModel.setDesenvolvedora(rs.getString("desenvolvedora"));
                
                vacinas.add(vacinaModel);
            }
            ps.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return vacinas;
    }
}
