/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function mention() {
    var mensagem = document.getElementsByName('formPostarMensagem')[0][0].value;
    var mentions = mensagem.match(/@[A-z0-9]*/g);
       
    for(var i = 0; i < mentions.length; i++) {
        var nomeParaPesquisa = mentions[i].replace('@', '');
        var mentionComHref = '<a href="/atividade-spring-mvc/pesquisar?nome='+ nomeParaPesquisa +'">' + mentions[i] + '</a>';
        mensagem = mensagem.replace(mentions[i], mentionComHref);
    }
    
    document.getElementsByName('formPostarMensagem')[0][0].value = mensagem;
    
}