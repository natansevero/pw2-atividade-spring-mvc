/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pw2.controller;

import br.edu.ifpb.pw2.interfaces.PostagemDao;
import br.edu.ifpb.pw2.interfaces.UsuarioDao;
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
 * 
 */
@Controller
@RequestMapping("/")
public class InitialController {
    
    @Autowired
    private UsuarioDao usuarioDao;
    
    @Autowired
    private PostagemDao postagemDao;
    
    @RequestMapping(method = RequestMethod.GET)
    public String redenizarPaginaLogin() {
        return "/login.jsp";
    }
    
    @RequestMapping(value = "/entrar", method = RequestMethod.POST)
    public String realizarLogin(@Autowired HttpSession session, @RequestParam String usuario, @RequestParam String senha) {
        Usuario u = new Usuario();
        u.setNomeUsuario(usuario);
        u.setSenha(senha);
        
//        System.out.println(usuarioDao.buscarPorNomeUsuarioESenha(u).toString());
        
        Usuario usuarioConsultado = usuarioDao.buscarPorNomeUsuarioESenha(u);
        
        if(usuarioConsultado == null) {
            return "redirect:/";
        } else {     
            List<Postagem> postagens = postagemDao.buscarTodosPostsDoUsuario(usuarioConsultado);
            
            synchronized(session) {
               session.setAttribute("id_usuario", usuarioConsultado.getId());
               session.setAttribute("nome_usuario", usuarioConsultado.getNomeUsuario());
               session.setAttribute("foto", usuarioConsultado.getFoto());
               session.setAttribute("postagens", postagens);
            }
            
            return "redirect:/feed";
        } 
    }
    
    @RequestMapping(value = "/sair", method = RequestMethod.GET)
    public String realizarLogout(@Autowired HttpSession session) {
        session.invalidate();
        
        return "redirect:/";
    }
    
    @RequestMapping(value = "/feed", method = RequestMethod.GET)
    public String redenizarPaginaFeed() {
        return "/feed.jsp";
    }
    
    @RequestMapping(value = "@{nome}", method = RequestMethod.GET)
    public String visualizarUmUsuario(@PathVariable String nome, ModelMap modelMap) {
        
        Usuario usuario = usuarioDao.buscarPorNome(nome);
        
        if(usuario == null) return "/404.jsp";
        else {
            List<Postagem> postagens = postagemDao.buscarTodosPostsDoUsuario(usuario);
            
            modelMap.addAttribute("usuario", usuario);
            modelMap.addAttribute("postagens", postagens);
                    
            return "/usuario.jsp";
        }
        
        
    }
}
