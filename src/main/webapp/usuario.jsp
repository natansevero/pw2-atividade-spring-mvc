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
  
        <div class="container" style="padding-top: 20px;">
            <div class="row">
                <div class="col-md-9">
                    <div class="row" style="border: 1px solid black;">
                        <c:if test="${not empty postagens}">
                            <c:forEach var="postagem" items="${postagens}">
                                <div class="row" style="border: 1px solid black; margin: 10px; padding: 10px">
                                    <div class="row">
                                        <div class="col-md-1">
                                            <img src="${usuario.foto}" width="48" height="48" />
                                        </div>
                                        <div class="col-md-8">
                                            <p>@${usuario.nomeUsuario}</p>
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
                            <img src="${usuario.foto}" height="190" class="col-md-12" /> <br>
                            <div class="col-md-12">@${usuario.nomeUsuario}</div>
                        </div>
                    </div>

                    <div class="row">
                        <div style="margin: 10px 10px 0 10px">
                            <a href="feed" class="btn btn-success col-md-12">Home</a>
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
