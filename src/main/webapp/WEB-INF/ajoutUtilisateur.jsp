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
			<div class="card-body">
				<h1 id="titre-principal">Ajout d'un utilisateur</h1>
				<form method="post">
					<div class="form-group">
						<label class="form-label">Nom</label> <input class="form-control"
							type="text" name="nom">
					</div>
					<div class="form-group">
						<label class="form-label">Prénom</label> <input
							class="form-control" type="text" name="prenom">
					</div>
					<div class="form-group">
						<label class="form-label">Login</label> <input
							class="form-control" type="text" name="login">
					</div>
					<div class="form-group">
						<label class="form-label">Mot de Passe</label> <input
							class="form-control" type="password" name="password">
					</div>
					<div class="form-group">
						<input class="btn btn-info my-2" type="submit" value="Ajouter">
					</div>
				</form>
			</div>
			<div class="card-footer">
				<p>M2 EC2LT &copy; Avril 2024</p>
			</div>
		</div>
	</div>
</body>
</html>