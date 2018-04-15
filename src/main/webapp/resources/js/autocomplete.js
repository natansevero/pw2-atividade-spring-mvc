/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

async function fetchGetDatas(link) {
    let response = await fetch(link);
    let data = await response.json();
    // Promise
    return data;
}

$( function() {
    fetchGetDatas('http://localhost:8080/atividade-spring-mvc/usuario/listar').then(res => {
        $( "#nomePesquisa" ).autocomplete({
            source: res
        });
    }).catch(err => {
        console.log(err);
    });    
});
