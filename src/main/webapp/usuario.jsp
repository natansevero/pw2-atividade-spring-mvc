<%-- 
    Document   : usuario
    Created on : Feb 21, 2018, 1:47:25 AM
    Author     : natan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${usuario.nomeUsuario}</title>
        
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    </head>
    <body>
        <body align="center">
        
        <div class="user">   
            <p><img src="${usuario.foto}" /></p>
            <p>@${usuario.nomeUsuario}</p>
        </div>
            
        <hr>
        
        <h3>Posts</h3>
        
        <c:if test="${not empty postagens}">
            <c:forEach var="postagem" items="${postagens}">
                <div>
                    <p><img src="${usuario.foto}" /></p>
                    <p>@${usuario.nomeUsuario}</p>
                    <p>${postagem.mensagem}<p>
                    <a href="postagem/${postagem.id}">Link do post</a>
                </div>

                <br><br>    
            </c:forEach>      
        </c:if>
    </body>
    
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
