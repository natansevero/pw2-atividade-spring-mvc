<%-- 
    Document   : inicial
    Created on : 05/02/2018, 21:44:53
    Author     : natan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Feed</title>
        
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    </head>
    <body align="center">
        <div>
            <p><a href="sair">SAIR</a></p>
        </div>
        <div class="user">   
            <p><img src="${sessionScope.foto}" /></p>
            <p>@${sessionScope.nome_usuario}</p>
        </div>
        <div>
            <form action="postagem/adicionar" method="post">
                <textarea name="mensagem" cols="30" rows="10" placeholder="O que você está tramando?"></textarea>
                <br>
                <input type="submit" value="enviar" />
            </form>
        </div>
            
        <hr>
        
        <h3>Posts</h3>
        
        <c:if test="${not empty sessionScope.postagens}">
            <c:forEach var="postagem" items="${sessionScope.postagens}">
                <div>
                    <p><img src="${sessionScope.foto}" /></p>
                    <p>@${sessionScope.nome_usuario}</p>
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
