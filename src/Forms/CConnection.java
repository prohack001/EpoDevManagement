/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Forms;

import java.sql.DriverManager;

/**
 *
 * @author HP
 */
public class CConnection {
    java.sql.Connection cn;
    
     public CConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost/gestion_devoir_epo","root","");
            System.out.println("Connexion établie avec succès");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public java.sql.Connection maConnexion(){
        return cn;
    }
    
}
