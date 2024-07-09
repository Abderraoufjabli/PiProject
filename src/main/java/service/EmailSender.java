package service;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {

    private final String username; // Votre adresse Gmail
    private final String password; // Votre mot de passe Gmail

    public EmailSender(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void sendEmail(String toEmail, String subject, String body) throws MessagingException {
        // Configuration des propriétés pour Gmail
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Création d'une session avec authentification OAuth2
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        // Création du message
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
        message.setSubject(subject);
        message.setText(body);

        // Envoi du message
        Transport.send(message);
        System.out.println("Email envoyé avec succès à " + toEmail);
    }

    public static void main(String[] args) {
        // Exemple d'utilisation
        String senderEmail = "idetectt@gmail.com";
        String senderPassword = "IUiu1308855639$&";
        EmailSender emailSender = new EmailSender(senderEmail, senderPassword);

        String recipientEmail = "logistique@jablitech.tn";
        String emailSubject = "Sujet de l'email";
        String emailBody = "Contenu de l'email.";

        try {
            emailSender.sendEmail(recipientEmail, emailSubject, emailBody);
        } catch (MessagingException e) {
            e.printStackTrace();
            System.err.println("Erreur lors de l'envoi de l'email : " + e.getMessage());
        }
    }
}
