package br.com.sobrevida.vacinaSARSCoV2.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author WERIKE
 */
public class ConnectionFactory{
    
    private final String URL = "jdbc:mysql://";
    private final String USUARIO = "root";
    private final String SENHA = "";
    private final String HOST = "localhost:";
    private final String PORTA = "3306/";
    private final String BD = "bd_vacinasars_cov_2";
    
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
