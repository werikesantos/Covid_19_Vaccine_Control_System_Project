package br.com.sobrevida.vacinaSARSCoV2.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author WERIKE
 */
public class ConnectionFactory{
    
    private final String URL = "jdbc:mysql://";
    private final String USUARIO = "covid";
    private final String SENHA = "Covid2021";
    private final String HOST = "localhost:";
    private final String PORTA = "3306/";
    private final String BD = "bd_vacina_sars_cov_2";
    
    /* REAJUSTAR E TESTAR:
     * 
     * Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_pessoas?useTimezone=true&serverTimezone=UTC&user=root&password=fluminense");
     *
    */
    
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