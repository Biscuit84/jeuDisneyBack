package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import model.Admin;
import model.Compte;
import model.Historique;
import model.Joueur;
import java.time.*;

public class DAOHistorique implements IDAO<Historique,Integer>{

	@Override
	public void insert(Historique h) {
		try {
			Class.forName("com.mysql.jdbc.Driver");	

			Connection conn = DriverManager.getConnection(url,loginbdd,passwordbdd);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO historique_parties (id_compte,date,heure_debut_partie,temps_partie,position,nb_etoiles_gagnees) VALUES (?,?,?,?,?,?)");

			ps.setInt(1, h.getPartie().getJ().getId());
			ps.setObject(2, h.getDateHeurePartie());
			ps.setObject(3, h.getTempsPartie() );
			ps.setInt(4, h.getPositionArrivee() );
			ps.setInt(5, h.getNbEtoilesGagnees());
			ps.setString(6, "joueur");


			ps.executeUpdate();	

			ps.close();

			conn.close();
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}


	@Override
	public Historique findById(Integer id) {
		Historique historique= null;
		try {
			Class.forName("com.mysql.jdbc.Driver");	
			Connection conn = DriverManager.getConnection(url,loginbdd,passwordbdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from historique_parties Jwhere id=?");
			ps.setInt(1,id);
			ResultSet rs  = ps.executeQuery();

			while(rs.next())
			{

				historique = new Historique((LocalDateTime)rs.getObject("heure_debut_partie"),(LocalTime)rs.getObject("temps_partie"),rs.getInt("position"),rs.getInt("nb_etoiles_gagnees"));

			}

			rs.close();
			ps.close();
			conn.close();
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return historique;
	}

	@Override
	public List<Historique> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Historique o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}






}
