package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import IDAO.IDAO;
import model.Compte;
import plateau.Case;
import plateau.CaseArrivee;
import plateau.CaseDepart;
import plateau.CaseDeplacement;
import plateau.CaseDuel;
import plateau.CaseMechant;
import plateau.CasePioche;
import plateau.CasePrince;
import plateau.CasePrison;
import plateau.CaseVide;

public class DAOCase implements IDAO <Case,Integer>{

	@Override
	public void insert(Case o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Case findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Case> findAll() {
		List<Case> cases= new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");	
			Connection conn = DriverManager.getConnection(url,loginbdd,passwordbdd);
			
			PreparedStatement ps = conn.prepareStatement("SELECT * from cases");
			ResultSet rs  = ps.executeQuery();
			
			while(rs.next())
			{Case c=null;
				if (rs.getString("nom").equalsIgnoreCase("mechant")) {
					c = new CaseMechant(rs.getInt("id"),rs.getString("nom"));
				}
				if (rs.getString("nom").equalsIgnoreCase("prince")) {
					c = new CasePrince(rs.getInt("id"),rs.getString("nom"));
				}
				if (rs.getString("nom").equalsIgnoreCase("duel")) {
					c = new CaseDuel(rs.getInt("id"),rs.getString("nom"));
				}
				if (rs.getString("nom").equalsIgnoreCase("prison")) {
					c = new CasePrison(rs.getInt("id"),rs.getString("nom"));
				}
				if (rs.getString("nom").equalsIgnoreCase("pioche")) {
					c = new CasePioche(rs.getInt("id"),rs.getString("nom"));
				}
				if (rs.getString("nom").equalsIgnoreCase("vide")) {
					c = new CaseVide(rs.getInt("id"),rs.getString("nom"));
				}
				if (rs.getString("nom").equalsIgnoreCase("deplacement")) {
					c = new CaseDeplacement(rs.getInt("id"),rs.getString("nom"));
				}
				if (rs.getString("nom").equalsIgnoreCase("depart")) {
					c = new CaseDepart(rs.getInt("id"),rs.getString("nom"));
				}
				if (rs.getString("nom").equalsIgnoreCase("arrivee")) {
					c = new CaseArrivee(rs.getInt("id"),rs.getString("nom"));
				}
				
				
					cases.add(c);
			}
			
			rs.close();
			ps.close();
			conn.close();
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return cases;
	}

	@Override
	public void update(Case o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
