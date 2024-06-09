<%@page import="beans.Utilisateur"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
final String APP_ROOT = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
<link rel="stylesheet" type="text/css"
	href="<%=APP_ROOT%>/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" />
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<a class="navbar-brand" href="<%=APP_ROOT%>">Gestion Utilisateurs</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="<%=APP_ROOT%>">Accueil</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=APP_ROOT%>/list">Lister</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=APP_ROOT%>/add">Ajouter</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="card py-3 my-3">
			<div class="card-header">
				<h1 id="titre-principal">Lister des utilisateurs</h1>	
			</div>
		
			<div class="card-body">
				<%
				ArrayList<Utilisateur> users = (ArrayList<Utilisateur>) request.getAttribute("utilisateurs");

				if (users.isEmpty()) {
					out.print("Désolé, la liste des utilisateurs est vide !");
				} else {
				%>
				<table class="table table-hover table-bordered">
					<tr>
						<th>ID</th>
						<th>Nom</th>
						<th>Prénom</th>
						<th>Login</th>
						<th>Password</th>
						<th colspan="2">Actions</th>
					</tr>
					<%
					for (Utilisateur user : users) {
					%>
					<tr>
						<td><%=user.getId()%></td>
						<td><%=user.getNom()%></td>
						<td><%=user.getPrenom()%></td>
						<td><%=user.getLogin()%></td>
						<td><%=user.getPassword()%></td>
						<td><a class="btn btn-warning"
							href="update?id=<%=user.getId()%>"> <i class="bi-pen"></i></a></td>
						<td><a class="btn btn-danger"
							href="delete?id=<%=user.getId()%>"
							onclick="return confirm('En êtes-vous sûr ?')"> <i
								class="bi-trash"></i></a></td>
					</tr>
					<%
					}
					%>
				</table>
				<%
				}
				%>
			</div>
			<div class="card-footer">
				<p>M2 EC2LT &copy; Avril 2024</p>
			</div>
		</div>
	</div>
</body>
</html>