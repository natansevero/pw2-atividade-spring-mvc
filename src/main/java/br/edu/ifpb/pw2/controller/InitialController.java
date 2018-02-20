/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pw2.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    
    @RequestMapping(method = RequestMethod.GET)
    public String redenizarPaginaLogin() {
        return "/login.jsp";
    }
    
    @RequestMapping(value = "/entrar", method = RequestMethod.POST)
    public String realizarLogin(@Autowired HttpSession session, @RequestParam String usuario, @RequestParam String senha) {
        return "feed.jsp";
    }
}
