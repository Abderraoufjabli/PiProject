package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {


    private Connection connexion;
    private String url="jdbc:mysql://localhost:3306/easyhealth";
    private String login="root";
    private String password="";


    public DataSource() throws SQLException
    {
        connexion= DriverManager.getConnection(url,login,password);
        System.out.println("connexion etablie");


    }

    public Connection getConnexion()
    {
        return connexion;
    }
}
