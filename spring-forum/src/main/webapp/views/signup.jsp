<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="row">
	<div class="four columns">
		<h4>Bem vindo(a) ao Spring F&oacute;rum</h4>
		<p>Esperamos poder lhe ajudar a dominar o m&aacute;ximo poss&iacute;vel todos os conceitos por tr&aacute;s do Spring Framework e seus projetos relacionados</p>
	</div>
	<div class="eight columns">
	<sf:form modelAttribute="usuario" action="executarRegistro" enctype="multipart/form-data">
		<label for="nome">Nome:<sf:errors path="nome" cssClass="erro"/></label>
		<sf:input path="nome" class="four"/>
		
		<label for="email">Email:<sf:errors path="email" cssClass="erro"/></label>
		<sf:input path="email" class="four"/>
		
		
		<label for="login">Nome do usu&aacute;rio (login):<sf:errors path="login" cssClass="erro"/></label>
		<sf:input path="login" class="three"/>
		<label for="senha">Senha:</label>
		<sf:password path="senha" class="three"/>
		<label for="avatar">Avatar:</label>
		<input type="file" name="avatar"/>
		
		
		<input type="submit" value="Fa&ccedil;a parte!" class="tiny button success"/>
	</sf:form>
	</div>
</div>