package set;

import entite.Livraison;
import entite.Reclamation;
import entite.StatutLivraison;
import entite.StatutReclamation;
import service.EmailSender;
import service.ServiceLivraison;
import service.ServiceReclamation;

import javax.mail.MessagingException;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException, MessagingException {

        EmailSender emailSender=new EmailSender("idetectt@gmail.com","mmzm bzki tflr evos");
        emailSender.sendEmail("idetectt@gmail.com","reponse a la reclamation","this the first api");









    }
}