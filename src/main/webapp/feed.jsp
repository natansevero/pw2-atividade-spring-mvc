<%-- 
    Document   : inicial
    Created on : 05/02/2018, 21:44:53
    Author     : natan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body align="center">
        <div>
            <p><a href="sair">SAIR</a></p>
        </div>
        <div class="user">   
            <p><img src="data:image/jpeg;base64,${sessionScope.foto}" /></p>
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
        
        <div>
            <p>foto - @hajkd</p>
            <p> Lorem ipsum dolor sit amet, consectetur adipisicing elit. Fuga quos in quaerat eum commodi eligendi laboriosam error maiores incidunt provident officiis exercitationem debitis vero ipsum ducimus, repellat porro optio nobis! <p>
            <a href="">Link do post</a>
        </div>
        <br><br>
        <div>
            <p>foto - @hajkd</p>
            <p> Lorem ipsum dolor sit amet, consectetur adipisicing elit. Fuga quos in quaerat eum commodi eligendi laboriosam error maiores incidunt provident officiis exercitationem debitis vero ipsum ducimus, repellat porro optio nobis! <p>
            <a href="">Link do post</a>
        </div>
        
    </body>
</html>
