package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import model.Admin;
import model.Compte;
import model.Joueur;

public class DAOCompte implements IDAO<Compte,Integer> {
	
	
	public  Compte connectSecure(String login,String password) 
	{
		Compte c = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");	
			Connection conn = DriverManager.getConnection(url,loginbdd,passwordbdd);
			
		
			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where login=? and password=?");
			ps.setString(1, login);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next())
			{
				if(rs.getString("type").equals("admin")) 
				{
					c = new Admin(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"),rs.getString("mail"));
				}
				else if(rs.getString("type").equals("joueur")) 
				{
					c = new Joueur(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"),rs.getString("pseudo"),rs.getString("mail"));
				}
				
			}
			
			rs.close();
			ps.close();
			conn.close();
		}
			catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return c;
		}

	@Override
	public void insert(Compte o) {
		try {
			Class.forName("com.mysql.jdbc.Driver");	
			Connection conn = DriverManager.getConnection(url,loginbdd,passwordbdd);
			
			if(o instanceof Admin) 
			{
				
				PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (login,password,nom,prenom,mail,type) VALUES (?,?,?,?,?,?)");
				ps.setString(1, o.getLogin());
				ps.setString(2, o.getPassword());
				ps.setString(3, o.getNom() );
				ps.setString(4, o.getPrenom() );
				ps.setString(5, o.getMail());
				ps.setString(6, "admin");
				
				ps.executeUpdate();	

				ps.close();
			}
			else if(o instanceof Joueur) 
			{
				
				
				PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (login,password,nom,prenom,mail,type) VALUES (?,?,?,?,?,?)");
				ps.setString(1, o.getLogin());
				ps.setString(2, o.getPassword());
				ps.setString(3, o.getNom() );
				ps.setString(4, o.getPrenom() );
				ps.setString(5, o.getMail());
				ps.setString(6, "joueur");
						
				ps.executeUpdate();	

				ps.close();
				
				
				
				PreparedStatement ps2 = conn.prepareStatement("INSERT INTO joueur (id_compte,niveau,etoiles,life) VALUES (?,?,?,?)");
				ps2.setInt(1, o.getId());
				ps2.setString(2, "noob");
				ps2.setInt(3, 100);
				ps2.setInt(4, 3 );
				
						
				ps2.executeUpdate();	

				ps2.close();
				
			}

			

			
			conn.close();
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Compte findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compte> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Compte o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
