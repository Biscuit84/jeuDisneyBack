package DAO;

import java.util.List;

public interface IDAO <T,K>{
	
	String url ="jdbc:mysql://localhost:3306/essai_jeu_disney?characterEncoding=UTF-8";
	 String loginbdd = "root";
	 String passwordbdd = "";
	
	
	
	public void insert(T o);
	public T findById(K id);
	public List<T> findAll();
	public void update(T o);
	public void delete(K id);
}
