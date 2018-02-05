/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pw2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    
}
