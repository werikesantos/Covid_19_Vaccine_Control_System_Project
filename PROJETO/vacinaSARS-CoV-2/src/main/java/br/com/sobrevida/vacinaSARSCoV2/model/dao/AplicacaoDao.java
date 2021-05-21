package br.com.sobrevida.vacinaSARSCoV2.model.dao;

import br.com.sobrevida.vacinaSARSCoV2.model.CidadaoModel;
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
    
    CidadaoModel cidadao = new CidadaoModel();
        
    public List<VacinaModel> buscarVacinaNome(){

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

    public CidadaoModel consultar(CidadaoModel cidadaoModel){
            
        cidadao = cidadaoModel;
        
        String sql = 
            "SELECT ci.id, ci.nome, ci.cpf, ci.email, va.desenvolvedora, va.qtd_Dose, ap.dose, ap.unica, ap.primeira, ap.segunda "
            +"FROM aplicacao ap "
            +"INNER JOIN cidadao ci "
            +"ON ap.idCidadao = ci.id "
            +"INNER JOIN vacina va "
            +"ON ap.idVacina = va.id "
            +"WHERE ci.id = ?";
               
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try(Connection conn = connectionFactory.connection()){
            
            PreparedStatement ps = conn.prepareStatement(sql);
              
            ps.setInt(1, cidadao.getIdCidadao());
            
            ResultSet rs = ps.executeQuery();
                        
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");
                String desenvolvedora = rs.getString("desenvolvedora");
                int qtd_Dose = rs.getInt("qtd_Dose");
                int dose = rs.getInt("dose");
                String unica = rs.getString("unica");
                String primeira = rs.getString("primeira");
                String segunda = rs.getString("segunda");
                 
                cidadaoModel.setId(id);
                cidadaoModel.setNome(nome);
                cidadaoModel.setCpf(cpf);
                cidadaoModel.setEmail(email);
                cidadaoModel.setDesenvolvedora(desenvolvedora);
                cidadaoModel.setQtd_Dose(qtd_Dose);
                cidadaoModel.setDose(dose);
                cidadaoModel.setUnica(unica);
                cidadaoModel.setPrimeira(primeira);
                cidadaoModel.setSegunda(segunda);
                
                return cidadaoModel;
            }
            ps.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        cidadao.setIdCidadao(0);
        return cidadao;
    }
    
    public CidadaoModel buscar(CidadaoModel cidadaoModel){
            
        cidadao = cidadaoModel;
        
        String sql = 
            "SELECT * "
            +"FROM bd_vacina_sars_cov_2.cidadao "
            +"WHERE id = ?";
               
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try(Connection conn = connectionFactory.connection()){
            
            PreparedStatement ps = conn.prepareStatement(sql);
              
            ps.setInt(1, cidadao.getId());
            
            ResultSet rs = ps.executeQuery();
                     
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");
                                 
                cidadaoModel.setId(id);
                cidadaoModel.setNome(nome);
                cidadaoModel.setCpf(cpf);
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
    
    public boolean salvar(CidadaoModel cidadaoModel, boolean resultado){
         
        boolean result = resultado;
        
        String sql = 
            "INSERT INTO "
                +"bd_vacina_sars_cov_2.aplicacao(idCidadao, idVacina, dose, unica, primeira, segunda) "
            +"VALUES "
                +"(?, ?, ?, ?, ?, ?)";
        
        ConnectionFactory connectionFactory = new ConnectionFactory();
        
        try(Connection conn = connectionFactory.connection()){
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, cidadaoModel.getIdCidadao());
            ps.setInt(2, cidadaoModel.getIdVacina());
            ps.setInt(3, cidadaoModel.getDose());
            ps.setString(4, cidadaoModel.getUnica());
            ps.setString(5, cidadaoModel.getPrimeira());
            ps.setString(6, cidadaoModel.getSegunda());
            
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