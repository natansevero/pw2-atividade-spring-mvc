/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function teste() {
    var mensagem = document.getElementsByName('formPostarMensagem')[0][0].value;
    var mention = mensagem.match(/@[A-z0-9]*/g)[0];
    // array mensagemPartida
    var mensagemPartida = mensagem.split(mention);
    mention = '<a href="'+ mention +'">' + mention + '</a>';
    
    var novaMensagem = mensagemPartida.join(mention);
    
    document.getElementsByName('formPostarMensagem')[0][0].value = novaMensagem;
    console.log(document.getElementsByName('formPostarMensagem')[0][0].value)
}