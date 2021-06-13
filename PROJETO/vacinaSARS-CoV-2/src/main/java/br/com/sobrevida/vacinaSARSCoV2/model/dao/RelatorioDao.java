package br.com.sobrevida.vacinaSARSCoV2.model.dao;

import br.com.sobrevida.vacinaSARSCoV2.model.CidadaoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.sql.Date;

/**
 *
 * @author WERIKE
 */
public class RelatorioDao{
    
    ConnectionFactory connectionFactory = new ConnectionFactory();
    PreparedStatement ps; 
    ResultSet result;
            
    public List<CidadaoModel> gerarPDF(Date deData, Date paraData){
        
        List<CidadaoModel> relatorioAplicacao = new ArrayList<>();
                
        String sql = 
            "SELECT ap.id, ci.nome, ci.email, ci.celular, ap.data_aplicacao, ap.previsao "
            +"FROM aplicacao ap "
            +"INNER JOIN cidadao ci "
            +"ON ap.idCidadao = ci.id "
            +"WHERE ap.previsao BETWEEN ? AND ?";
        
        try(Connection conn = connectionFactory.connection()){
            
            ps = conn.prepareStatement(sql);
            
            ps.setDate(1, deData);
            ps.setDate(2, paraData);
            
            result = ps.executeQuery();
            
            while(result.next()){
                
                CidadaoModel cidadaoModel = new CidadaoModel();
                
                cidadaoModel.setId(result.getInt("ap.id"));
                cidadaoModel.setNome(result.getString("ci.nome"));
                cidadaoModel.setEmail(result.getString("ci.email"));
                cidadaoModel.setCelular(result.getString("ci.celular"));

                String previsaoFormatada;
                Date previsao = result.getDate("ap.previsao");
                DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
                previsaoFormatada = dateFormat1.format(previsao);
                
                cidadaoModel.setPrevisao(previsaoFormatada);
                
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