/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pw2.controller;

import br.edu.ifpb.pw2.interfaces.UsuarioDao;
import br.edu.ifpb.pw2.model.Usuario;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author natan
 */
@Controller
@RequestMapping("/usuario")
public class UserController {   
    
    @Autowired
    private UsuarioDao dao;
    
    @RequestMapping(value = "/cadastro", method = RequestMethod.GET)
    public String redenizarPaginaCadastro() {
        return "/cadastro.jsp";
    }
    
    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public String cadastrarUsuario(@ModelAttribute Usuario usuario) throws IOException {
//        System.out.println(usuario.getNomeUsuario());
//        System.out.println(usuario.getSenha());
//        System.out.println(Arrays.toString(usuario.getFoto().getBytes()));
        
        if(dao.adicionar(usuario)) {
            
            dao.buscarTodos().stream().forEach(u -> {
                System.out.println(u);
            });
            
            return "redirect:/";
            
        } else {
            // render
            return "/cadastro.jsp";
        }
        
    }
}
