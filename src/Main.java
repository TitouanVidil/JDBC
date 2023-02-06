import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Hello world!");

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
        Statement stmt = null;
        ResultSet resultat = null;

        try
        {
            connexion = DriverManager.getConnection(url,"root","");
            stmt = (Statement) connexion.createStatement();
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