import Model.Connexion;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Hello world!");

        String url = "jdbc:mysql://localhost:3306/immodb";
        Statement stmt = null;
        ResultSet resultat = null;
        Connection con = null;
        Properties props = null;

        try
        {
            con = Connexion.getConnexion(url,props);
            stmt = (Statement) con.createStatement();
            resultat = stmt.executeQuery("Select a_code, a_etat FROM appartement WHERE a_etat in('TBE','BON');");

            System.out.println(resultat);
            while(resultat.next())
            {
                System.out.println("Numero: "+resultat.getInt("a_code") + " " + "Etat: "+resultat.getString("a_etat") + " " );
            }
        }
        catch(SQLException e)
        {
            System.out.println("Erreur lors du chargement "+e.getMessage());
        }

    }
}