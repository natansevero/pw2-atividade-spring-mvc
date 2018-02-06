/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pw2.controller;

import br.edu.ifpb.pw2.model.Usuario;
import java.util.Arrays;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author natan
 */
@Controller
@RequestMapping("/usuario")
public class UserController {
    
    @RequestMapping(value = "/cadastro", method = RequestMethod.GET)
    public String redenizarPaginaCadastro() {
        return "/cadastro.jsp";
    }
    
//    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
//    public String cadastrarUsuario(Usuario usuario) {
//        System.out.println(Arrays.toString(usuario.getFoto()));
//        
//        return "/cadastro.jsp";
//    }
    
    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public String cadastrarUsuario(@RequestParam("nomeUsuario") String nomeUsuario, @RequestParam("senha") String senha, @RequestParam("foto") MultipartFile foto) {
        System.out.println(nomeUsuario);
        System.out.println(senha);
        System.out.println(foto);
        return "/cadastro.jsp";
    }
    
}
