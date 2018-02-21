
package br.edu.ifpb.pw2.controller;

import br.edu.ifpb.pw2.interfaces.PostagemDao;
import br.edu.ifpb.pw2.model.Postagem;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author natan
 */
@Controller
@RequestMapping("/postagem")
public class PostagemController {
    
    @Autowired
    private PostagemDao postagemDao;
    
    @RequestMapping(value = "/adicionar", method = RequestMethod.POST)
    public String adicionarPostagem(@RequestParam String mensagem, @Autowired HttpSession session) {
        int idUsuarioLogado = (int) session.getAttribute("id_usuario");
        
        Postagem postagem = new Postagem();
        postagem.setId_usuario(idUsuarioLogado);
        postagem.setMensagem(mensagem);
        
        if(postagemDao.adicionar(postagem)) {
            postagemDao.buscarTodoas().stream().forEach(p -> {
                System.out.println(p);
            });
            return "redirect:/feed";
        }
        
        return "redirect:/feed";
    }
    
}
