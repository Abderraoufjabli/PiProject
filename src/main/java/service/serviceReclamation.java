package service;

import entite.Reclamation;
import entite.StatutReclamation;
import utilities.DataSource;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class serviceReclamation implements IService<Reclamation> {
    DataSource dataSource;
    Connection connection;


    public serviceReclamation()
    {
        try {
            dataSource=new DataSource();
            connection=dataSource.getConnexion();

        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void create(Reclamation reclamation) {
        String query = "INSERT INTO reclamations (utilsateur_id, commande_id,description, " +
                "statut, date_creation, date_resolution) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pst = connection.prepareStatement("query")) {
            pst.setInt(1,reclamation.getUtilisateurId());
            pst.setInt(2,reclamation.getCommandeId());
            pst.setString(3,reclamation.getDescription());
            pst.setString(4,reclamation.getStatut().toString());
            pst.setTimestamp(5,Timestamp.valueOf(reclamation.getDateCreation()));
            pst.setTimestamp(6,Timestamp.valueOf(reclamation.getDateResolution()));
//
            pst.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }







    @Override
    public void update(Reclamation reclamation) {
        String query="update reclamations SET utilisateur_id=?, commande_id=?," +
                " description=?, statut=?, date_creation=?, date_resolution=?" +
                " where reclamation_id=?";

        try {
            PreparedStatement pst=connection.prepareStatement(query);
            pst.setInt(1,reclamation.getUtilisateurId());
            pst.setInt(2,reclamation.getCommandeId());
            pst.setString(3,reclamation.getDescription());
            pst.setString(4,reclamation.getStatut().toString());
            pst.setTimestamp(5,Timestamp.valueOf(reclamation.getDateCreation()));
            pst.setTimestamp(6,Timestamp.valueOf(reclamation.getDateResolution()));
            pst.setInt(7,reclamation.getId());
            pst.executeUpdate();


        } catch (SQLException e) {
            e.getMessage();
        }

    }

    @Override
    public List<Reclamation> readAll() {
        List<Reclamation> recl=new ArrayList<Reclamation>();


        String query="select * from reclamations";
        try{
            PreparedStatement  pst=connection.prepareStatement(query);
            ResultSet rs=pst.executeQuery();

            while(rs.next())
            { Reclamation reclamation=new Reclamation(rs.getInt("utilisateur_id"),
                    rs.getInt("reclamation_id"),
                    rs.getInt("commande_id"),
                    rs.getString("description"),
                    StatutReclamation.valueOf(rs.getString("statut")),
                    rs.getTimestamp("date_creation").toLocalDateTime(),
                    rs.getTimestamp("date_resolution").toLocalDateTime());

                recl.add(reclamation);

            }

        }
        catch (SQLException e){e.getMessage();

        }
        return recl;
    }

    @Override
    public void delete(Reclamation reclamation) {
        String query="delete from Reclamations where reclamation_id=? ";

        try {
            PreparedStatement pst=connection.prepareStatement(query);
            pst.setInt(1,reclamation.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
