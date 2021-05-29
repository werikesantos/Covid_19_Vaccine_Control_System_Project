package br.com.sobrevida.vacinaSARSCoV2.model.dao;

import br.com.sobrevida.vacinaSARSCoV2.model.AplicacaoModel;
import br.com.sobrevida.vacinaSARSCoV2.model.CidadaoModel;
import br.com.sobrevida.vacinaSARSCoV2.model.VacinaModel;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author WERIKE
 */
public class AplicacaoDao{
    
    ConnectionFactory connectionFactory = new ConnectionFactory();
    PreparedStatement ps; 
    ResultSet result;
    CidadaoModel cidadao = new CidadaoModel();
        
    public List<VacinaModel> buscarVacinaNome(){

        List<VacinaModel> vacinas = new ArrayList<>();
                
        String sql = 
            "SELECT "
                +"desenvolvedora "
            +"FROM "
                +"bd_vacina_sars_cov_2.vacina";
        
        try(Connection conn = connectionFactory.connection()){
            
            ps = conn.prepareStatement(sql);
            
            result = ps.executeQuery();
            
            while(result.next()){
                
                VacinaModel vacinaModel = new VacinaModel();

                vacinaModel.setDesenvolvedora(result.getString("desenvolvedora"));
                
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
               
        try(Connection conn = connectionFactory.connection()){
            
            ps = conn.prepareStatement(sql);
              
            ps.setInt(1, cidadao.getIdCidadao());
            
            result = ps.executeQuery();
                        
            while(result.next()){
                int id = result.getInt("id");
                String nome = result.getString("nome");
                String cpf = result.getString("cpf");
                String email = result.getString("email");
                String desenvolvedora = result.getString("desenvolvedora");
                int qtd_Dose = result.getInt("qtd_Dose");
                int dose = result.getInt("dose");
                String unica = result.getString("unica");
                String primeira = result.getString("primeira");
                String segunda = result.getString("segunda");
                 
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
               
        try(Connection conn = connectionFactory.connection()){
            
            ps = conn.prepareStatement(sql);
              
            ps.setInt(1, cidadao.getId());
            
            result = ps.executeQuery();
                     
            while(result.next()){
                int id = result.getInt("id");
                String nome = result.getString("nome");
                String cpf = result.getString("cpf");
                String email = result.getString("email");
                                 
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
        
        try(Connection conn = connectionFactory.connection()){
            
            ps = conn.prepareStatement(sql);
            
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
    
    public void pesquisar(JTable aplicacaoLista, String dado){

        String sql = 
            "SELECT ap.idCidadao AS CÓDIGO, ci.nome AS NOME, ci.cpf AS CPF, ci.email AS E_MAIL, va.desenvolvedora AS VACINA, ap.dose AS APLICAÇÃO, ap.unica AS ÚNICA_DOSE, ap.primeira AS 1ª_DOSE, ap.segunda AS RETORNO "
            +"FROM aplicacao ap "
            +"INNER JOIN cidadao ci "
            +"ON ap.idCidadao = ci.id "
            +"INNER JOIN vacina va "
            +"ON ap.idVacina = va.id "
            +"WHERE ci.cpf LIKE ?";
        
        try(Connection conn = connectionFactory.connection()){

            ps = conn.prepareStatement(sql);

            ps.setString(1, dado + "%");

            result = ps.executeQuery();

            aplicacaoLista.setModel(DbUtils.resultSetToTableModel(result));
            
            ps.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean alterar(AplicacaoModel aplicacaoModel, boolean resultado){
         
        boolean result = resultado;

        String sql = 
            "UPDATE "
                +"bd_vacina_sars_cov_2.aplicacao "
            +"SET "
                +"dose = ?, unica = ?, primeira = ?, segunda = ? "
            +"WHERE idCidadao = ?";
                        
        try(Connection conn = connectionFactory.connection()){
            
            ps = conn.prepareStatement(sql);
            
            ps.setInt(1, aplicacaoModel.getDose());
            ps.setString(2, aplicacaoModel.getUnica());
            ps.setString(3, aplicacaoModel.getPrimeira());
            ps.setString(4, aplicacaoModel.getSegunda());
            ps.setInt(5, aplicacaoModel.getIdCidadao());
            
            ps.execute();
            ps.close();
            
            return resultado = true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    public boolean deletar(AplicacaoModel aplicacaoModel, boolean resultado){
         
        boolean result = resultado;
        
        String sql = 
            "DELETE FROM "
                +"bd_vacina_sars_cov_2.aplicacao "
            +"WHERE "
                +"idCidadao = ?";
        
        try(Connection conn = connectionFactory.connection()){
            
            ps = conn.prepareStatement(sql);
            
            ps.setInt(1, aplicacaoModel.getIdCidadao());
            
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