package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import plateau.Plateau;

public class DAOPlateau implements IDAO<Plateau,Integer> {

	@Override
	public void insert(Plateau p) {
		try {
			Class.forName("com.mysql.jdbc.Driver");	
			Connection conn = DriverManager.getConnection(url,loginbdd,passwordbdd);

			PreparedStatement ps = conn.prepareStatement("INSERT INTO plateau (nom,nb_cases) VALUES (?,?)");
			ps.setString(1, p.getNom());
			ps.setInt(2, p.getNbCases());

			ps.executeUpdate();	

			ps.close();
			conn.close();
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Plateau findById(Integer id) {
		Plateau plateau= null;
		try {
			Class.forName("com.mysql.jdbc.Driver");	
			Connection conn = DriverManager.getConnection(url,loginbdd,passwordbdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from plateau where id=?");
			ps.setInt(1,id);
			ResultSet rs  = ps.executeQuery();

			while(rs.next())
			{

				plateau = new Plateau(rs.getInt("id"),rs.getString("nom"),rs.getInt("nb_cases"));

			}

			rs.close();
			ps.close();
			conn.close();
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return plateau;
	}

	@Override
	public List<Plateau> findAll() {
		List<Plateau> plateau= new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");	
			Connection conn = DriverManager.getConnection(url,loginbdd,passwordbdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from plateau");
			ResultSet rs  = ps.executeQuery();

			while(rs.next())
			{Plateau p=null;

			p = new Plateau(rs.getInt("id"),rs.getString("nom"),rs.getInt("nb_cases"));

			plateau.add(p);
			}

			rs.close();
			ps.close();
			conn.close();
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return plateau;
	}

	@Override
	public void update(Plateau o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}




}
