/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package authForm;

/**
 *
 * @author SORE Ben Amed
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login {

    private static final String DB_URL = "jdbc:mysql://localhost/gestion_devoir_epo";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static boolean checkCredentialsInDatabase(String email, String password) throws ClassNotFoundException {
        boolean valid = false;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Établir la connexion à la base de données
                    Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Préparer la requête SQL
            String query = "SELECT * FROM utilisateurs WHERE email = ? AND passe = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, password);

            // Exécuter la requête
            rs = stmt.executeQuery();

            // Si une ligne est retournée, les identifiants sont valides
            valid = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermer les ressources JDBC pour éviter les fuites de ressources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
           if (valid)
        {
            System.out.println("CONNECTION ETABLIE AVEC SUCCES");
    }
           return valid;
    }
}

