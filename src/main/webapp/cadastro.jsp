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
        
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <div class="col-md-12" style="text-align: center">
                <h1>Cadastre-se no mini twitter</h1>            
            </div>
            
            <form action="cadastrar" method="POST" enctype="multipart/form-data">
                <div class="form-group">
                    <label>Nome de Usuario</label>
                    <input type="text" name="nomeUsuario" class="form-control" />    
                </div>
                <div clas="form-group">
                    <label>Senha</label>
                    <input type="password" name="senha" class="form-control" />    
                </div>
                <br />
                <div class="form-group">
                    <label>Foto de perfil</label>
                    <input type="file" name="foto" />
                </div>
                <br />
                <input type="submit" value="Cadastrar" class="btn btn-default" />
            </form>

            <br>
            <p><a href="javascript:history.back()" class="btn btn-primary">Voltar</a></p>    
        </div>
        
    </body>
    
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
