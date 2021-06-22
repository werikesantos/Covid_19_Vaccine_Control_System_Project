package br.com.sobrevida.vacinaSARSCoV2.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author WERIKE
 */
public class ConnectionFactory{
    
    private final String URL = "jdbc:mysql://";
    private final String USUARIO = "usuario";//COLOQUE AQUI O USUARIO CRIADO NO BANCO DE DADOS
    private final String SENHA = "senha";//COLOQUE AQUI A SENHA CRIADA NO BANCO DE DADOS
    private final String HOST = "localhost:"; //COLOQUE AQUI O SEU LOCALHOST OU IP CONFORME O BANCO DE DADOS
    private final String PORTA = "3333/"; //COLOQUE AQUI A NUMERAÇÃO DA SUA PORTA INDICADA NO BANCO DE DADOS
    private final String BD = "bd_vacina_sars_cov_2";
    
    public Connection connection(){ 
        try{
            Connection connection = DriverManager.getConnection(URL+HOST+PORTA+BD,USUARIO,SENHA);
            return connection;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }  
}