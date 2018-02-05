<%-- 
    Document   : login
    Created on : 05/02/2018, 17:05:35
    Author     : natan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mini Twitter</title>
    </head>
    <body>
        <h1>Mini Twitter - Atividade Spring MVC</h1>
        <h2>Login</h2>
        
        <form name="login" method="POST">
            <label>Usuario: </label>
            <input type="text" name="usuario" /> <br>
            <label>Senha: </label>
            <input type="password" name="senha" /> <br>
            <input type="submit" value="Entrar" />
        </form>
        
        <br>
        
        Se ainda não possui conta, <a href="/atividade-spring-mvc/usuario/cadastro">Cadastre-se</a>
    </body>
</html>
