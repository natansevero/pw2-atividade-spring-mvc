
package br.edu.ifpb.pw2.controller;

import br.edu.ifpb.pw2.interfaces.PostagemDao;
import br.edu.ifpb.pw2.model.Postagem;
import br.edu.ifpb.pw2.model.Usuario;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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
        Usuario usuario = new Usuario();
        usuario.setId(idUsuarioLogado);
        postagem.setUsuario(usuario);
        postagem.setMensagem(mensagem);
        
        if(postagemDao.adicionar(postagem)) {
            
            synchronized(session) {
                session.setAttribute("postagens", postagemDao.buscarTodosPostsDoUsuario(usuario));
            }
            
            return "redirect:/feed";
        }
        
        return "redirect:/feed";
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String visualizarUmPost(@PathVariable String id, ModelMap modelMap) {
        
        int idPostagem = Integer.parseInt(id);
        
//        System.out.println(idPostagem);
        
        Postagem postagem = postagemDao.buscarPorId(idPostagem);
//        
        modelMap.addAttribute("postagem", postagem);
        
        return "/postagem.jsp";
    }
    
}
