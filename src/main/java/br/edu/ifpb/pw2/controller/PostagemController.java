
package br.edu.ifpb.pw2.controller;

import br.edu.ifpb.pw2.interfaces.FavoritarDao;
import br.edu.ifpb.pw2.interfaces.PostagemDao;
import br.edu.ifpb.pw2.model.Postagem;
import br.edu.ifpb.pw2.model.Usuario;
import java.util.List;
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
    
    @Autowired
    private FavoritarDao favoritarDao;
    
    @RequestMapping(value = "/adicionar", method = RequestMethod.POST)
    public String adicionarPostagem(@RequestParam String mensagem, @Autowired HttpSession session) {
        int idUsuarioLogado = (int) session.getAttribute("id_usuario");
        
        Postagem postagem = new Postagem();
        Usuario usuario = new Usuario();
        usuario.setId(idUsuarioLogado);
        postagem.setUsuario(usuario);
        postagem.setMensagem(mensagem);
        
        if(postagemDao.adicionar(postagem)) {
            return "redirect:/feed";
        }
        
        return "redirect:/feed";
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String visualizarUmPost(@PathVariable String id, ModelMap modelMap, @Autowired HttpSession session) {
        
        int idPostagem = Integer.parseInt(id);
        
        int idUsuario = (int) session.getAttribute("id_usuario");
        
//        System.out.println(idPostagem);
        
        Postagem postagem = postagemDao.buscarPorId(idPostagem);
        
        modelMap.addAttribute("postagem", postagem);
        modelMap.addAttribute("isFavorito", favoritarDao.verificarSePostFavorito(idUsuario, idPostagem));
        
        return "postagem";
    }
    
    @RequestMapping(value = "/favoritar/{id_postagem}", method = RequestMethod.GET)
    public String favoritarPost(@PathVariable String id_postagem, @Autowired HttpSession session) {
        
        int idUsuario = (int) session.getAttribute("id_usuario");
        
        if(favoritarDao.adicionar(idUsuario, Integer.parseInt(id_postagem))) {
            return "redirect:/feed";
        }
        
        return "redirect:/feed";
    }
    
    @RequestMapping(value = "/desfavoritar/{id_postagem}", method = RequestMethod.GET)
    public String desfavoritarPost(@PathVariable String id_postagem, @Autowired HttpSession session) {
        
        int idUsuario = (int) session.getAttribute("id_usuario");
        
        if(favoritarDao.remover(idUsuario, Integer.parseInt(id_postagem))) {
            return "redirect:/feed";
        }
        
        return "redirect:/feed";
    }
    
    @RequestMapping(value = "/favoritos", method = RequestMethod.GET)
    public String postsFavoritos(@Autowired HttpSession session, ModelMap modelMap) {
        int idUsuario = (int) session.getAttribute("id_usuario");
        
        List<Postagem> postagens = favoritarDao.listarPostagensFavoritas(idUsuario);
        
        modelMap.addAttribute("postagens", postagens);
        
        return "favoritos";
    }
    
}
