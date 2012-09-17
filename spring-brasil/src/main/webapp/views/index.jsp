<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>
<html>
<head>
	<link rel="stylesheet" href="recursos/stylesheets/foundation.min.css" />
	<title>Spring Brasil</title>
</head>
<body>

	<!-- Header and Nav -->

	<div class="row">
		<div class="three columns">
			<h1>
				<a href="/"><img src="recursos/images/logotipo.png" /></a>
			</h1>
		</div>
		<div class="five columns right">
			<c:if test="${sessionScope.usuario == null}">
			<form style="margin-top: 1.0em;" action="login" method="post">
				<div class="row">
					<input type="text" name="login" placeholder="Usu&aacute;rio" class="three columns right"/>
					<input type="password" name="senha" placeholder="Senha" class="three columns right"/>
					<input type="submit" value="Entrar" class="tiny button success" class="three columns right"/>
				</div>
				
			</form>
			</c:if>
			<c:if test="${sessionScope.usuario != null}">
				<br/>
				Bem vindo(a) ${sessionScope.usuario.nome} - <a href="logout">Sair</a>
			</c:if>
			
		</div>

	</div>

	<!-- End Header and Nav -->


	<!-- First Band (Image) -->
	<div style="background: #48762A;">
		<div class="row">
			<div class="twelve columns">
				<img src="recursos/images/chamada.png" />
			</div>
		</div>
	</div>
	
	
	
	<div class="row">
		<div class="two columns">
			<h5>Assuntos</h5>
			<ul class="side-nav">
			<c:forEach items="${assuntos}" var="assunto">
				<li><a href="assunto/${assunto.id}">${assunto.nome}</a></li>
			</c:forEach>
			</ul>
		</div>
		
		<div class="eight columns">
			<h5>O que &eacute; isto?</h5>
			<p>O projeto Spring Brasil &eacute; um gerenciador de comunidades virtuais (a la GUJ) baseado nos conceitos apresentados no livro <i>Virando o Jogo com Spring Framework</i> de <i>Henrique Lobo Weissmann</i>.</p>
			<p>Seu c&oacute;digo fonte &eacute; totalmente aberto e voc&ecirc; &eacute; livre para explor&aacute;-lo da maneira que achar melhor.</p>
		</div>
		<div class="two columns">
			<h5>&Uacute;ltimos membros</h5>
			<ul class="side-nav">
			<c:forEach items="${usuarios}" var="usuario">
				<li><a href="usuario/${usuario.id}">${usuario.nome}</a></li>
			</c:forEach>
			</ul>
		</div>
		
	</div>

</body>
</html>