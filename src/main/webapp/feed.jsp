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
    <body>
        <div class="container" style="padding-top: 20px;">
            <div class="row">
                <div class="col-md-9">
                    <div class="row" style="border: 1px solid black; padding: 10px">
                        <form action="postagem/adicionar" method="post">
                            
                            <textarea name="mensagem" class="form-control" style="resize: none" cols="30" rows="5" placeholder="O que está tramando?"></textarea>
                            
                            <input type="submit" value="enviar" class="btn btn-default" style="margin-top: 10px" />
                        </form>
                    </div>
                    
                    <div class="row" style="border: 1px solid black;">
                        <c:if test="${not empty sessionScope.postagens}">
                            <c:forEach var="postagem" items="${sessionScope.postagens}">
                                <div class="row" style="border: 1px solid black; margin: 10px; padding: 10px">
                                    <div class="row">
                                        <div class="col-md-1">
                                            <img src="${sessionScope.foto}" width="48" height="48" />
                                        </div>
                                        <div class="col-md-8">
                                            <p>@${sessionScope.nome_usuario}</p>
                                            <p>${postagem.mensagem}<p>
                                        </div>
                                    </div>
                                    
                                    <div class="row" style="text-align: center">
                                        <a href="postagem/${postagem.id}">Link do post</a>
                                    </div>    
            
                                </div>
                            </c:forEach>      
                        </c:if> 
                    </div>
                    
                </div>

                <div class="col-md-3" >
                    <div class="row">
                        <div style="padding: 0 10px 0 10px">
                            <img src="${sessionScope.foto}" height="190" class="col-md-12" /> <br>
                            <div class="col-md-12">@${sessionScope.nome_usuario}</div>
                        </div>
                    </div>

                    <div class="row">
                        <div style="margin: 10px 10px 0 10px">
                            <a href="sair" class="btn btn-danger col-md-12">SAIR</a>
                        </div>
                    </div>
                </div>

            </div> <!-- row -->
        </div> <!-- container -->
            
        
        
    </body>
    
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
