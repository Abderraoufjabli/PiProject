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

        Reclamation rec=new Reclamation(10,15,21,"c'est pas bon",StatutReclamation.EN_COURS);
        serviceReclamation.update(rec);









    }
}