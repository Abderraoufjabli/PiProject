package service;

import entite.Reclamation;
import entite.StatutReclamation;
import utilities.DataSource;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ServiceReclamation implements IService<Reclamation> {
    DataSource dataSource;
    Connection connection;


    public ServiceReclamation() {
        try {
            dataSource = new DataSource();
            connection = dataSource.getConnexion();

        } catch (SQLException e) {
            e.getMessage();
        }
    }

//    @Override
//    public void create(Reclamation reclamation) {
//        String query = "INSERT INTO reclamations (utilisateur_id, commande_id,description, " +
//                "statut, date_creation, date_resolution) VALUES (?, ?, ?, ?, ?, ?)";
//
//        PreparedStatement pst = null;
//        try {
//            pst = connection.prepareStatement(query);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        try {
//            pst.setInt(1,reclamation.getUtilisateurId());
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            pst.setInt(2,reclamation.getCommandeId());
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            pst.setString(3,reclamation.getDescription());
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            pst.setString(4,reclamation.getStatut().toString());
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            pst.setTimestamp(5,Timestamp.valueOf(reclamation.getDateCreation()));
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            pst.setTimestamp(6,Timestamp.valueOf(reclamation.getDateResolution()));
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        int rowsInserted= 0;
//        try {
//            rowsInserted = pst.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        if(rowsInserted>0){
//                System.out.println("A new reclamationis inerted ");
//            }
//            else{
//                System.out.println("no reclamation was inserted");
//                System.out.println();
//            }
//
//    }
    @Override
    public void create(Reclamation reclamation) {
        String query = "INSERT INTO reclamations (utilisateur_id, commande_id, description) " +
                "VALUES (?, ?, ?)";

        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            pst.setInt(1, reclamation.getUtilisateurId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            pst.setInt(2, reclamation.getCommandeId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            pst.setString(3, reclamation.getDescription());
        } catch (SQLException e) {
            throw new RuntimeException(e);}

//    }
//    try {
//        pst.setString(4,reclamation.getStatut().toString());
//    } catch (SQLException e) {
//        throw new RuntimeException(e);
//    }
//    try {
//        pst.setTimestamp(4,Timestamp.valueOf(reclamation.getDateCreation()));
//    } catch (SQLException e) {
//        throw new RuntimeException(e);
//    }
//    try {
//        pst.setTimestamp(5, LocalDateTime.now());
//    } catch (SQLException e) {
//        throw new RuntimeException(e);
//    }

            int rowsInserted=0;
            try {
                rowsInserted = pst.executeUpdate();
            } catch (SQLException e1) {
                System.out.println(e1.getMessage());;
            }
            if (rowsInserted > 0) {
                System.out.println("A new reclamationis inerted ");
            } else {
                System.out.println("no reclamation was inserted");
                System.out.println();
            }

        }
///////////////////debut methode update //////////////////////////

        @Override
        public void update(Reclamation reclamation) {
            String query = "UPDATE reclamations SET commande_id=?, utilisateur_id=?, reponse=?, statut=? WHERE reclamation_id=?";

            try {
                PreparedStatement pst = connection.prepareStatement(query);

                pst.setInt(1, reclamation.getCommandeId());
                pst.setInt(2, reclamation.getUtilisateurId());
                pst.setString(3, reclamation.getReponse());
                pst.setString(4, reclamation.getStatut().toString());
                pst.setInt(5, reclamation.getId());
                System.out.println(reclamation.getStatut().toString());

                int rowsUpdated = pst.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Réclamation mise à jour avec succès.");
                } else {
                    System.out.println("Échec de la mise à jour de la réclamation.");
                }
            } catch (SQLException e) {
                System.err.println("Erreur lors de la mise à jour de la réclamation : " + e.getMessage());
                e.printStackTrace();
            }
        }


    ///////////////////////////////////debut methode readAll/////////////////

        @Override
        public List<Reclamation> readAll () {
            List<Reclamation> recl = new ArrayList<>();
            String query = "select * from reclamations";
            try {
                PreparedStatement pst = connection.prepareStatement(query);
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    // handle potentional null value for timestamps
                    Timestamp dateCreationTimeStamp=rs.getTimestamp("date_creation");
                    LocalDateTime dateCreation=null;
                    if(dateCreationTimeStamp !=null){dateCreation=dateCreationTimeStamp.toLocalDateTime();};

                    Timestamp dateResolutionTimestamp=rs.getTimestamp("date_resolution");
                    LocalDateTime dateResolution=null;
                    if(dateResolutionTimestamp !=null){dateResolution=dateResolutionTimestamp.toLocalDateTime();};

                    Reclamation reclamation = new Reclamation(
                            rs.getInt("reclamation_id"),
                            rs.getInt("utilisateur_id"),
                            rs.getInt("commande_id"),
                            rs.getString("description"),
                            StatutReclamation.valueOf(rs.getString("statut")),
                            dateCreation,
                            dateResolution
                    );

                    recl.add(reclamation);

                }

            } catch (SQLException e) {
                e.printStackTrace();

            }
            return recl;
        }
//////////////////////debut delete /////////////////////////////////////
        @Override
        public void delete (Reclamation reclamation){
            String query = "delete from Reclamations where reclamation_id=? ";

            try {
                PreparedStatement pst = connection.prepareStatement(query);
                pst.setInt(1, reclamation.getId());
                pst.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }


        /////fin delete

}


