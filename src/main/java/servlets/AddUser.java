package servlets;

import java.io.IOException;

import beans.Utilisateur;
import dao.UtilisateurDao;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddUser extends HttpServlet
{
	private static final String VUE_AJOUT_UTILISATEUR = "/WEB-INF/ajoutUtilisateur.jsp";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(VUE_AJOUT_UTILISATEUR);
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		Utilisateur utilisateur = new Utilisateur(nom, prenom, login, password);
		
		UtilisateurDao.ajouter(utilisateur);
		
		response.sendRedirect("list");
	}
}
