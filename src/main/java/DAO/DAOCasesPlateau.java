package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


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
import plateau.CasesPlateau;

public class DAOCasesPlateau implements IDAO<CasesPlateau,Integer> {

	@Override
	public void insert(CasesPlateau o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CasesPlateau findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public CasesPlateau findByIdPlateauAndIdCase() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<CasesPlateau>  findAllByIdPlateau(int idPlateau) {
		List<CasesPlateau> listCasesPlateau= new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");	
			Connection conn = DriverManager.getConnection(url,loginbdd,passwordbdd);
			
			PreparedStatement ps = conn.prepareStatement("SELECT * from cases_plateau where id_plateau=?");
			ps.setInt(1,idPlateau);
			ResultSet rs  = ps.executeQuery();
			
			while(rs.next())
			{CasesPlateau c=null;
				
					c = new CasesPlateau(rs.getInt("id_plateau"),rs.getInt("id_case"),rs.getInt("ordre_case"));
												
					listCasesPlateau.add(c);
			}
			
			rs.close();
			ps.close();
			conn.close();
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return listCasesPlateau;
	}
	
	
	public CasesPlateau findByOrdreAndIdPlateau(int ordre_case, int idPlateau) {
		CasesPlateau casePlateau= null;
		try {
			Class.forName("com.mysql.jdbc.Driver");	
			Connection conn = DriverManager.getConnection(url,loginbdd,passwordbdd);
			
			PreparedStatement ps = conn.prepareStatement("SELECT * from cases_plateau where ordre_case=? and id_plateau=?");
			ps.setInt(1,ordre_case);
			ps.setInt(2,idPlateau);
			ResultSet rs  = ps.executeQuery();
			
			while(rs.next())
			{
				
				casePlateau = new CasesPlateau(rs.getInt("id_plateau"),rs.getInt("id_case"),rs.getInt("ordre_case"));
				

			}
			
			rs.close();
			ps.close();
			conn.close();
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return casePlateau;
	}
	

	@Override
	public List<CasesPlateau> findAll() {
			
		return null;
	}

	@Override
	public void update(CasesPlateau o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
