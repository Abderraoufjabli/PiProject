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

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
//
//        Livraison liv=new Livraison(2,200,StatutLivraison.EN_COURS,
//                LocalDateTime.now(),LocalDateTime.now());
//        ServiceLivraison serviceLivraison=new ServiceLivraison();
////        serviceLivraison.create(liv);
//        Livraison liv1=new Livraison(1,200,5,StatutLivraison.ANNULEE,
//                LocalDateTime.now(),LocalDateTime.now());
////        serviceLivraison.create(liv1);
//////        serviceLivraison.update(liv1);
////        ArrayList<Livraison> listLivraison = new ArrayList<Livraison>();
////        listLivraison= (ArrayList<Livraison>) serviceLivraison.readAll();
////
////        for(Livraison e:listLivraison)
////        {
////            System.out.println(e);
////        }
//        serviceLivraison.delete(liv1);

        Reclamation rec=new Reclamation(5,10,"la commande pizza n'espt comme j'ai commnda",
                StatutReclamation.OUVERTE,LocalDateTime.now(),LocalDateTime.now());
        System.out.println(rec);

        ServiceReclamation serviceReclamation=new ServiceReclamation();


        serviceReclamation.create(rec);





    }
}