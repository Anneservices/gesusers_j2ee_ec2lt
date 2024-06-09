package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Utilisateur;

public class UtilisateurDao
{
	private static int LastId = 0;
	
	private final static ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
	
//	static
//	{
//		utilisateurs.add(new Utilisateur(1, "Ndiaye", "Fatou", "fafa", "passer"));
//		utilisateurs.add(new Utilisateur(2, "Mar", "ElHadji", "aladji", "partir"));
//		utilisateurs.add(new Utilisateur(3, "Mendy", "Ismail", "iso", "repasser"));
//		utilisateurs.add(new Utilisateur(4, "Mbaye", "Momar", "momo", "aller"));
//	}
	
	public static ArrayList<Utilisateur> lister()
	{
		ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		try
		{
			Connection connexion = ConnexionManager.getConnection();
			Statement requete = connexion.createStatement();
			ResultSet resultat = requete.executeQuery("SELECT * FROM Utilisateur");
			
			int id;
			String nom, prenom, login, password;
			
			while (resultat.next()) {
				id = resultat.getInt("id");
				nom = resultat.getString("nom");
				prenom = resultat.getString("prenom");
				login = resultat.getString("login");
				password = resultat.getString("password");
				
				utilisateurs.add(new Utilisateur(id, nom, prenom, login, password));
			}
			
			resultat.close();
			connexion.close();
			
		} catch (Exception e)
		{
			System.err.println("Erreur durant la récupération de la liste des utilisateurs :" + e.getMessage());
		}
		return utilisateurs;
	}
	
	public static boolean ajouter(Utilisateur utilisateur)
	{
		try {
				Connection connexion = ConnexionManager.getConnection();
				String requete = "INSERT INTO Utilisateur(nom, prenom, login, password) VALUES (?, ?, ?, SHA1(?))";
				PreparedStatement preparedStatement = connexion.prepareStatement(requete);
				preparedStatement.setString(1, utilisateur.getNom());
				preparedStatement.setString(2, utilisateur.getPrenom());
				preparedStatement.setString(3, utilisateur.getLogin());
				preparedStatement.setString(4, utilisateur.getPassword());
				
				int insertedRows = preparedStatement.executeUpdate();
				
				if (insertedRows == 1)
				{
					return true;
				}
				
				preparedStatement.close();
				connexion.close();
		}
		catch (Exception e)
		{
			System.err.println("Erreur durant l'insertion de l'utilisateur");
		}
		return false;
	}
	
	public static boolean supprimer(int id)
	{
		try {
			Connection connexion = ConnexionManager.getConnection();
			String requete = "DELETE FROM Utilisateur WHERE id = ?";
			PreparedStatement preparedStatement = connexion.prepareStatement(requete);
			preparedStatement.setInt(1, id);
			
			int deletedRows = preparedStatement.executeUpdate();
			
			if (deletedRows == 1)
			{
				return true;
			}
			
			preparedStatement.close();
			connexion.close();
	}
	catch (Exception e)
	{
		System.err.println("Echec de la suppression de l'utilisateur");
	}
	return false;
	}
	
	public static Utilisateur get(int id)
	{
		Utilisateur utilisateur = null;
		try
		{
			Connection connexion = ConnexionManager.getConnection();
			PreparedStatement requete = connexion.prepareStatement("SELECT * FROM Utilisateur WHERE id = ?");
			requete.setInt(1, id);
			ResultSet resultat = requete.executeQuery();
	
			String nom, prenom, login, password;
			
			if (resultat.next()) {
				id = resultat.getInt("id");
				nom = resultat.getString("nom");
				prenom = resultat.getString("prenom");
				login = resultat.getString("login");
				password = resultat.getString("password");
				
				utilisateur = new Utilisateur(id, nom, prenom, login, password);
				
			}
			
			resultat.close();
			connexion.close();
			
		} catch (Exception e)
		{
			System.err.println("Erreur durant la récupération de l'utilisateur :" + e.getMessage());
		}
		return utilisateur;
	}

	public static boolean modifier(Utilisateur utilisateur)
	{
		try {
			Connection connexion = ConnexionManager.getConnection();
			String requete = "UPDATE Utilisateur SET nom = ?, prenom = ?, login = ?, password = SHA1(?) WHERE id = ?";
			PreparedStatement preparedStatement = connexion.prepareStatement(requete);
			preparedStatement.setString(1, utilisateur.getNom());
			preparedStatement.setString(2, utilisateur.getPrenom());
			preparedStatement.setString(3, utilisateur.getLogin());
			preparedStatement.setString(4, utilisateur.getPassword());
			preparedStatement.setInt(5, utilisateur.getId());
			
			int updatedRows = preparedStatement.executeUpdate();
			
			if (updatedRows == 1)
			{
				return true;
			}
			
			preparedStatement.close();
			connexion.close();
	}
	catch (Exception e)
	{
		System.err.println("Erreur durant l'insertion de l'utilisateur");
	}	
	return false;
		
	}
}
