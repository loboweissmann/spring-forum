<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="row">
	<div class="four columns">
		<h4>Bem vindo(a) ao Spring Forum</h4>
		<p>Esperamos poder lhe ajudar a dominar o m&aacute;ximo poss&iacute;vel todos os conceitos por tr&aacute;s do Spring Framework e seus projetos relacionados</p>
	</div>
	<div class="eight columns">
	<form:form modelAttribute="usuario" action="register">
		
		<label for="nome">Nome:<form:errors path="nome"/></label>
		<form:input path="nome" class="four"/>
		
		<label for="email">Email:<form:errors path="email"/></label>
		<form:input path="email" class="four"/>
		<label for="login">Nome do usu&aacute;rio (login):<form:errors path="login"/></label>
		<form:input path="login" class="three"/>
		<label for="senha">Senha:</label>
		<form:password path="senha" class="three"/>
		<input type="submit" value="Fa&ccedil;a parte!" class="tiny button success"/>
	</form:form>
	</div>
</div>