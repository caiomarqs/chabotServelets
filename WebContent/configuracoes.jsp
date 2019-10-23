<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	session = request.getSession(false);

	String sessionID = (String) session.getAttribute("userEmail");
	
	if(sessionID == null){
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>JadeChatbot - Assistente Virtual</title>

	<link rel="shortcut icon" href="images/jade_logo_x32.png" sizes="16x16 32x32" type="image/png">

	<!-- bootstrap core -->
	<link rel="stylesheet" href="css/compiler/bootstrap/bootstrap.css">

	<!-- FontAwesome -->
	<link rel="stylesheet" href="node_modules/@fortawesome/fontawesome-free/css/all.css">

	<!-- estilo proprio -->
	<link rel="stylesheet" href="css/compiler/bootstrap/style.css">
	<link rel="stylesheet" href="css/compiler/bootstrap/configuracoes.css">


</head>

<body>
	<!-- Navgation -->
	<header>
		<nav id="navbar" class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
			<div class="container">

				<!-- logo -->
				<a href="index.jsp" class="navbar-brand"> <img src="images/logoBold-SfV.png" alt="Logo Fiap">
				</a>
				<!-- logo -->

				<!-- botão hambuger -->
				<div class="d-flex ml-auto">
					<button class="navbar-toggler collapsed" type="button" data-toggle="collapse"
						data-target="#navbarItens" aria-controls="navbarItens" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
				</div>
				<!-- botão hambuger -->


				<!-- itens menu -->
				<div class="navbar-collapse collapse" id="navbarItens">

					<!-- itens ao meio -->
					<ul class="navbar-nav mx-auto order-1">
						<!-- não exite itens mas é esencial para a formatação do nav -->
					</ul>
					<!-- itens ao meio -->


					<!-- cadastro e login -->
					<ul class="navbar-nav d-none d-lg-flex ml-2 order-3">
						<c:if test="${not empty userName}">
							<li class="nav-item"><a class="nav-link" href="#" id="btn-nav-nome">${userName}</a></li>
						</c:if>

						<li class="nav-item"><a class="nav-link" href="./ConfiguracaoServlet" id="btn-nav-config"
								data-toggle="modal" data-target=".bd-login">Configurações</a></li>
					</ul>
					<!-- cadastro e login -->


					<!-- cadatro e login para mobile -->
					<ul class="navbar-nav d-lg-none">
						<li class="dropdown-divider"></li>
						<c:if test="${not empty userName}">
							<li class="nav-item"><a class="nav-link" href="#" id="btn-nav">${userName}</a></li>
						</c:if>
						<li class="nav-item"><a class="nav-link" href="" id="btn-nav" data-toggle="modal" data-target=".bd-login">Configurações</a></li>
					</ul>
					<!-- cadatro e login para mobile -->


				</div>
				<!-- itens menu -->


			</div>
		</nav>
	</header>
	<!-- Navgation -->



	<!-- Corpo do Site -->
	<main>
		<!-- Section 1 -- Main -->
		<section id="main">
			<div class="vh-100 conteudo-configuracoes">
				<div class="row h-100">
					<div class="col"></div>
					<div class="col-lg-10 col-md-10 principal-configuracoes flex-wrap">
						<c:if test = "${empty userNivelAcesso}">
						<h1>Olá, ${userName}</h1>
						<ul>
							<li>Nome: ${userName}</li>
							<li>Email: ${userEmail}</li>
							<li>Telefone: ${userTel}</li>
							<li>Data de Nascimento ${userDate}</li>
						</ul>
						<form action="DeletarUsuarioServlet" method="post">
							<input type="email" class="form-control" maxlength="120" id="email" placeholder="Email"
								name="tx_email">
							<button type="submit" class="btn btn-primary btn-configuracoes">Deletar Usuario</button>
						</form>
						<c:if test="">
						<p style="color: #c60822;"><b>${error}</b></p>
						</c:if>
						</c:if>
						<c:if test = "${not empty userNivelAcesso}">
						<h1>Olá, ${userName}</h1>
						<ul>
							<li>Nome: ${userName}</li>
							<li>Email: ${userEmail}</li>
							<li>Telefone: ${userTel}</li>
							<li>Data de Nascimento ${userDate}</li>
						</ul>
						</c:if>
					</div>
					<div class="col"></div>
				</div>
			</div>
		</section>
		<!-- Section 1 -- Main -->
	</main>
	<!-- Corpo do Site -->




	<!-- footer -->
	<footer>
		<div vw class="enabled">
			<div vw-access-button class="active"></div>
			<div vw-plugin-wrapper>
				<div class="vw-plugin-top-wrapper"></div>
			</div>
		</div>
	</footer>
	<!-- footer -->


</body>





<script src="node_modules/jquery/dist/jquery.js"></script>
<script src="node_modules/jquery-mask-plugin/dist/jquery.mask.js"></script>
<script src="node_modules/popper.js/dist/umd/popper.js"></script>
<script src="node_modules/bootstrap/dist/js/bootstrap.js"></script>
<script src="node_modules/jquery-mask-plugin/dist/jquery.mask.js"></script>

<!-- import do js de animações proprias -->
<!-- isso está bugando o menu -->
<script src="js/index.js"></script>


<!-- libras -->
<!-- <script src="https://vlibras.gov.br/app/vlibras-plugin.js"></script>
<script>
	new window.VLibras.Widget('https://vlibras.gov.br/app');
</script> -->

</html>