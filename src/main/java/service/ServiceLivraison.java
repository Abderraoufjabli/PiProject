package service;

import entite.Livraison;
import entite.StatutLivraison;
import utilities.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceLivraison implements IService<Livraison>{
    Connection connection;
    DataSource dataSource;
    public ServiceLivraison() {
        try {
            DataSource dataSource=new DataSource();
            connection=dataSource.getConnexion();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override

    public void create(Livraison livraison) {
        String query="insert into livraisons (commande_id,livreur_id,statut,date_creation," +
                "date_mise_a_jour) values (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt=connection.prepareStatement(query);
            stmt.setInt(1,livraison.getCommandeId());
            stmt.setInt(2,livraison.getLivreurId());
            stmt.setString(3,livraison.getStatut().toString());
            stmt.setTimestamp(4, Timestamp.valueOf(livraison.getDateLivraison()));
            stmt.setTimestamp(5,Timestamp.valueOf(livraison.getDateMiseAJour()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void update(Livraison livraison) {
        String query="update livraisons set commande_id=?,livreur_id=? " +
                ",statut=? ,date_creation=? ,date_mise_a_jour=? where livraison_id=?";

        try {
            PreparedStatement pstmt=connection.prepareStatement(query);
            pstmt.setInt(1,livraison.getCommandeId());
            pstmt.setInt(2,livraison.getLivreurId());
            pstmt.setString(3,livraison.getStatut().toString());
            pstmt.setTimestamp(4,Timestamp.valueOf(livraison.getDateLivraison()));
            pstmt.setTimestamp(5,Timestamp.valueOf(livraison.getDateMiseAJour()));
            pstmt.setInt(6,livraison.getId());
           pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Livraison> readAll() {
        String query="select * from livraisons";
        List<Livraison>  liv= new ArrayList<Livraison>();

        try {
            PreparedStatement pst=connection.prepareStatement(query);
            ResultSet rs=pst.executeQuery();
            while (rs.next())
            {
                Livraison livraison=new Livraison(rs.getInt("livraison_id"),
                        rs.getInt("commande_id"),
                        rs.getInt("livreur_id"),
                        StatutLivraison.valueOf(rs.getString("statut")),
                        rs.getTimestamp("date_creation").toLocalDateTime(),
                        rs.getTimestamp("date_mise_a_jour").toLocalDateTime());
                        liv.add(livraison);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return liv;


    }

    @Override
    public void delete(Livraison livraison) {

        String query="delete from livraisons where livraison_id=?";
        try {
            PreparedStatement pst=connection.prepareStatement(query);
            pst.setInt(1,livraison.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
