package br.com.sobrevida.vacinaSARSCoV2.model.dao;

import br.com.sobrevida.vacinaSARSCoV2.model.AplicacaoModel;
import br.com.sobrevida.vacinaSARSCoV2.model.CidadaoModel;
import br.com.sobrevida.vacinaSARSCoV2.model.VacinaModel;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
                +"id, desenvolvedora, qtd_Dose, periodo "
            +"FROM "
                +"bd_vacina_sars_cov_2.vacina";
        
        try(Connection conn = connectionFactory.connection()){
            
            ps = conn.prepareStatement(sql);
            
            result = ps.executeQuery();
            
            while(result.next()){
                
                VacinaModel vacinaModel = new VacinaModel();

                vacinaModel.setId(result.getInt("id"));
                vacinaModel.setDesenvolvedora(result.getString("desenvolvedora"));
                vacinaModel.setQtd_Dose(result.getInt("qtd_Dose"));
                vacinaModel.setPeriodo(result.getString("periodo"));
                
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
            "SELECT ci.id, ap.id, ci.nome, ci.cpf, ci.email, va.desenvolvedora, ap.dose_aplicada, ap.data_aplicacao, ap.previsao "
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
                int id = result.getInt("ci.id");
                int idAplicacao = result.getInt("ap.id");
                String nome = result.getString("nome");
                String cpf = result.getString("cpf");
                String email = result.getString("email");
                String desenvolvedora = result.getString("desenvolvedora");
                int doseAplicada = result.getInt("dose_aplicada");
                String dataAplicacao = result.getString("data_aplicacao");
                
                String previsaoFormatada;
                Date previsao = result.getDate("ap.previsao");
                if(previsao == null){
                    previsaoFormatada = "";
                }else{
                    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    previsaoFormatada = dateFormat.format(previsao);
                }
                 
                cidadaoModel.setIdCidadao(id);
                cidadaoModel.setId(idAplicacao);
                cidadaoModel.setNome(nome);
                cidadaoModel.setCpf(cpf);
                cidadaoModel.setEmail(email);
                cidadaoModel.setDesenvolvedora(desenvolvedora);
                cidadaoModel.setDoseAplicada(doseAplicada);
                cidadaoModel.setDataAplicacao(dataAplicacao);
                cidadaoModel.setPrevisao(previsaoFormatada);
                
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
    
    public CidadaoModel aplicacao(CidadaoModel cidadaoModel){
            
        cidadao = cidadaoModel;
        
        String sql = 
            "SELECT ap.id, ap.idCidadao, ci.nome, ci.cpf, ci.email, va.desenvolvedora, ap.dose_aplicada, ap.data_aplicacao, ap.previsao "
            +"FROM aplicacao ap "
            +"INNER JOIN cidadao ci "
            +"ON ap.idCidadao = ci.id "
            +"INNER JOIN vacina va "
            +"ON ap.idVacina = va.id "
            +"WHERE ap.id = ?";
               
        try(Connection conn = connectionFactory.connection()){
            
            ps = conn.prepareStatement(sql);
              
            ps.setInt(1, cidadao.getId());
            
            result = ps.executeQuery();
                        
            while(result.next()){
                int idAplicacao = result.getInt("ap.id");
                int idCidadao = result.getInt("ap.idCidadao");
                
                if(idCidadao == 0){
                    cidadao.setIdCidadao(0);
                    return cidadao;
                }
                
                String nome = result.getString("ci.nome");
                String cpf = result.getString("ci.cpf");
                String email = result.getString("ci.email");
                String desenvolvedora = result.getString("va.desenvolvedora");
                int doseAplicada = result.getInt("ap.dose_aplicada");
                String dataAplicacao = result.getString("ap.data_aplicacao");
                
                String previsaoFormatada;
                Date previsao = result.getDate("ap.previsao");
                if(previsao == null){
                    previsaoFormatada = "";
                }else{
                    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    previsaoFormatada = dateFormat.format(previsao);
                }

                cidadaoModel.setId(idAplicacao);
                cidadaoModel.setIdCidadao(idCidadao);
                cidadaoModel.setNome(nome);
                cidadaoModel.setCpf(cpf);
                cidadaoModel.setEmail(email);
                cidadaoModel.setDesenvolvedora(desenvolvedora);
                cidadaoModel.setDoseAplicada(doseAplicada);
                cidadaoModel.setDataAplicacao(dataAplicacao);
                cidadaoModel.setPrevisao(previsaoFormatada);
                
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
    
    public boolean salvar(CidadaoModel cidadaoModel, boolean resultado) throws ParseException{
         
        boolean result = resultado;
        
        String previsao = cidadaoModel.getPrevisao();
        
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date previsaoFormatada = new Date(format.parse(previsao).getTime());

        String sql = 
            "INSERT INTO "
                +"bd_vacina_sars_cov_2.aplicacao(idCidadao, idVacina, dose_aplicada, data_aplicacao, previsao) "
            +"VALUES "
                +"(?, ?, ?, ?, ?)";
        
        try(Connection conn = connectionFactory.connection()){
            
            ps = conn.prepareStatement(sql);
            
            ps.setInt(1, cidadaoModel.getIdCidadao());
            ps.setInt(2, cidadaoModel.getIdVacina());
            ps.setInt(3, cidadaoModel.getDoseAplicada());
            ps.setString(4, cidadaoModel.getDataAplicacao());
            ps.setDate(5, previsaoFormatada);
            
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
            "SELECT ap.id AS CÓDIGO, ap.idCidadao AS PACIENTE, ci.nome AS NOME, ci.cpf AS CPF, ci.email AS E_MAIL, va.desenvolvedora AS VACINA, ap.dose_aplicada AS APLICAÇÃO, ap.data_aplicacao AS DATA, ap.previsao AS PREVISÃO "
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
    
    public void pesquisar(JTable aplicacaoListaTabela){

        String sql = 
            "SELECT ap.id AS CÓDIGO, ap.idCidadao AS PACIENTE, ci.nome AS NOME, ci.cpf AS CPF, ci.email AS E_MAIL, va.desenvolvedora AS VACINA, ap.dose_aplicada AS APLICAÇÃO, ap.data_aplicacao AS DATA, ap.previsao AS PREVISÃO "
                +"FROM aplicacao ap "
                +"INNER JOIN cidadao ci "
                +"ON ap.idCidadao = ci.id "
                +"INNER JOIN vacina va "
                +"ON ap.idVacina = va.id ";
               
        try(Connection conn = connectionFactory.connection()){

            ps = conn.prepareStatement(sql);

            result = ps.executeQuery();

            aplicacaoListaTabela.setModel(DbUtils.resultSetToTableModel(result));
                        
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
                +"dose_aplicada = ?, data_aplicacao = ?, previsao = ? "
            +"WHERE id = ?";
                        
        try(Connection conn = connectionFactory.connection()){
            
            ps = conn.prepareStatement(sql);
            
            ps.setInt(1, aplicacaoModel.getDoseAplicada());
            ps.setString(2, aplicacaoModel.getDataAplicacao());
            ps.setString(3, aplicacaoModel.getPrevisao());
            ps.setInt(4, aplicacaoModel.getId());
            
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
                +"id = ?";
        
        try(Connection conn = connectionFactory.connection()){
            
            ps = conn.prepareStatement(sql);
            
            ps.setInt(1, aplicacaoModel.getId());
            
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