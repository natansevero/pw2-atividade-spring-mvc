<%-- 
    Document   : cadastro
    Created on : 05/02/2018, 17:27:23
    Author     : natan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Usuario</title>
    </head>
    <body>
        <h1>Cadastre-se no mini twitter</h1>
        <form name="cadastrar" action="usuario/cadastrar" method="POST" enctype="multipart/form-data">
            <label>Nome de Usuario</label>
            <input type="text" name="nomeUsuario" /><br>
            <label>Senha</label>
            <input type="password" name="senha" /><br>
            <label>Foto de perfil</label>
            <input type="file" name="foto" /><br>
            <input type="submit" value="Cadastrar" />
        </form>
        
        <br>
        <p><a href="javascript:history.back()">Voltar</a></p>
    </body>
</html>
