/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pw2.controller;

import br.edu.ifpb.pw2.interfaces.PostagemDao;
import br.edu.ifpb.pw2.interfaces.UsuarioDao;
import br.edu.ifpb.pw2.model.Usuario;
import java.io.IOException;
import java.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    private UsuarioDao usuarioDao;
    
    @RequestMapping(value = "/cadastro", method = RequestMethod.GET)
    public String redenizarPaginaCadastro() {
        return "/cadastro.jsp";
    }
    
    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public String cadastrarUsuario(@RequestParam String nomeUsuario, @RequestParam String senha, @RequestParam MultipartFile foto) throws IOException {
//        System.out.println(nomeUsuario);
//        System.out.println(senha);
//        System.out.println(Arrays.toString(foto.getBytes()));
        
        byte[] encoded = null;
        try {
            encoded = Base64.getEncoder().encode(foto.getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Usuario usuario = new Usuario();
        usuario.setNomeUsuario(nomeUsuario);
        usuario.setSenha(senha);
        usuario.setFoto("data:image/jpeg;base64," + new String(encoded));
        
        if(usuarioDao.adicionar(usuario)) {
            
//            dao.buscarTodos().stream().forEach(u -> {
//                System.out.println(u);
//            });
            
            return "redirect:/";
            
        } else {
            // render
            return "/cadastro.jsp";
        }   

    }
    
    
}
