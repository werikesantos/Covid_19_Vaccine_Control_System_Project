/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sobrevida.vacinaSARSCoV2.model;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author WERIKE
 */
public class Dao {
    
    private final String URL = "jdbc:mysql://";
    private final String USUARIO = "root";
    private final String SENHA = "";
    private final String HOST = "localhost:";
    private final String PORTA = "3306/";
    private final String BD = "db_pessoas";
    
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
