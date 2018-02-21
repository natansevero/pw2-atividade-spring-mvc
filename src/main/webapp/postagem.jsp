<%-- 
    Document   : postagem
    Created on : 05/02/2018, 21:45:03
    Author     : natan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Postagem</title>
    </head>
    <body align="center">
        <div>
            <p>@${postagem.usuario.nomeUsuario}</p>
            <p>
                <img src="${postagem.usuario.foto}" />
            </p>
            <p> ${postagem.mensagem} <p>
        </div>
    </body>
</html>
