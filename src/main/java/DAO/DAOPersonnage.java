package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import IDAO.IDAO;
import model.Compte;
import model.Historique;
import model.Personnage;

public class DAOPersonnage implements IDAO<Personnage,Integer> {

	@Override
	public void insert(Personnage p) {
		try {
			Class.forName("com.mysql.jdbc.Driver");	

			Connection conn = DriverManager.getConnection(url,loginbdd,passwordbdd);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO personnages (nom,prince,mechant,pouvoir) VALUES (?,?,?,?)");

			ps.setString(1, p.getNom());
			ps.setString(2, p.getPrince());
			ps.setString(3, p.getMechant());
			ps.setString(4, p.getPouvoir() );

			ps.executeUpdate();	

			ps.close();

			conn.close();
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Personnage findById(Integer id) {
		Personnage personnage= null;
		try {
			Class.forName("com.mysql.jdbc.Driver");	
			Connection conn = DriverManager.getConnection(url,loginbdd,passwordbdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from personnages where id=?");
			ps.setInt(1,id);
			ResultSet rs  = ps.executeQuery();

			while(rs.next())
			{

				personnage = new Personnage(rs.getInt("id"),rs.getString("nom"),rs.getString("prince"),rs.getString("mechant"),rs.getString("pouvoir"));
			}

			rs.close();
			ps.close();
			conn.close();
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return personnage;

	}



	public List<Personnage> findByJoueurId(int id) {
		Personnage p = null;
		List<Personnage> listePersonnagesJoueur= new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");	
			Connection conn = DriverManager.getConnection(url,loginbdd,passwordbdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from personnages JOIN compte_personnages on personnages.id=compte_personnages.id_personnage Join compte ON compte_personnages.id_compte=compte.id WHERE compte_personnages.id_compte=?");
			ps.setInt(1,id);
			ResultSet rs  = ps.executeQuery();

			while(rs.next())
			{

				p = new Personnage(rs.getInt("id"),rs.getString("nom"),rs.getString("prince"),rs.getString("mechant"),rs.getString("pouvoir"));

				listePersonnagesJoueur.add(p);
			}

			rs.close();
			ps.close();
			conn.close();
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return listePersonnagesJoueur;
	}


	@Override
	public List<Personnage> findAll() {
		List<Personnage> personnages= new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");	
			Connection conn = DriverManager.getConnection(url,loginbdd,passwordbdd);
			
			PreparedStatement ps = conn.prepareStatement("SELECT * from personnages");
			ResultSet rs  = ps.executeQuery();
			
			while(rs.next())
			{Personnage p=null;
				
			p = new Personnage(rs.getInt("id"),rs.getString("nom"),rs.getString("prince"),rs.getString("mechant"),rs.getString("pouvoir"));
					
				
			personnages.add(p);
			}
			
			rs.close();
			ps.close();
			conn.close();
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return personnages;
	}

	@Override
	public void update(Personnage o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

}
