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
        
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
       
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-8" style="border: 1px solid black; margin: 20px; padding: 10px">
                    <div class="col-md-1">
                        <img src="${postagem.usuario.foto}" width="48" height="48" />
                    </div>
                    <div class="col-md-8">
                        <p>@${postagem.usuario.nomeUsuario}</p>
                        <p> ${postagem.mensagem} <p>
                    </div>
                </div>
            </div>
            
            <div class="row" style="text-align: center">
                <p><a href="javascript:history.back()" class="btn btn-primary">Voltar</a></p> 
            </div>
        </div>
        
    </body>
    
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
</html>
