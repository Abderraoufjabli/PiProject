package set;

import entite.Livraison;
import entite.Reclamation;
import entite.StatutLivraison;
import entite.StatutReclamation;
import service.ServiceLivraison;
import service.ServiceReclamation;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {

        ServiceReclamation serviceReclamation=new ServiceReclamation();

        List<Reclamation> record=serviceReclamation.readAll();

        for(Reclamation r:record)
        {
            System.out.println(r);
        }









    }
}