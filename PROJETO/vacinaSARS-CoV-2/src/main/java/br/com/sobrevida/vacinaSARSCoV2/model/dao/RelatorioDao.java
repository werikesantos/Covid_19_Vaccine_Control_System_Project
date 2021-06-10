package br.com.sobrevida.vacinaSARSCoV2.model.dao;

import br.com.sobrevida.vacinaSARSCoV2.model.CidadaoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WERIKE
 */
public class RelatorioDao{
    
    ConnectionFactory connectionFactory = new ConnectionFactory();
    PreparedStatement ps; 
    ResultSet result;
            
    public List<CidadaoModel> gerarPDF(){

        List<CidadaoModel> relatorioAplicacao = new ArrayList<>();
                
        String sql = 
            "SELECT ap.idCidadao, ci.nome, ci.email, ci.celular, ap.segunda "
            +"FROM aplicacao ap "
            +"INNER JOIN cidadao ci "
            +"ON ap.idCidadao = ci.id "
            +"WHERE ap.segunda != 'null' ORDER BY nome ASC";
        
        try(Connection conn = connectionFactory.connection()){
            
            ps = conn.prepareStatement(sql);
            
            result = ps.executeQuery();
            
            while(result.next()){
                
                CidadaoModel cidadaoModel = new CidadaoModel();
                
                cidadaoModel.setIdCidadao(result.getInt("idcidadao"));
                cidadaoModel.setNome(result.getString("nome"));
                cidadaoModel.setEmail(result.getString("email"));
                cidadaoModel.setCelular(result.getString("celular"));
                //cidadaoModel.setSegunda(result.getString("segunda"));
                
                relatorioAplicacao.add(cidadaoModel);
            }
            ps.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return relatorioAplicacao;
    }
}