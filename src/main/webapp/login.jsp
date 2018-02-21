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
        <title>Microblog</title>
        
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <div class="col-md-12" style="text-align: center">
                <h1>Microblog</h1>
                <h2>Login</h2>
            </div>
            
            <form name="login" method="POST" action="entrar">
                <div class="form-group">
                    <label>Usuario: </label>
                    <input type="text" name="usuario" class="form-control" />    
                </div>
                <div class="form-group">
                    <label>Senha: </label>
                    <input type="password" name="senha" class="form-control" />    
                </div>
                <br>
                <input type="submit" value="Entrar" class="btn btn-default" />
            </form>

            <br>

            Se ainda não possui conta, <a href="usuario/cadastro">Cadastre-se</a>
        </div>
        
    </body>
    
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
