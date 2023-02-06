package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connexion
{
    public void connexion()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }

        catch(ClassNotFoundException e)
        {
            System.out.println("Erreur lors du chargement "+e.getMessage());
        }

        String url = "jdbc:mysql://localhost:3306/immodb";
        Connection connexion = null;
    }

}
