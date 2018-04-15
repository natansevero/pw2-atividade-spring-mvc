
package br.edu.ifpb.pw2.controller;

import br.edu.ifpb.pw2.interfaces.FavoritarDao;
import br.edu.ifpb.pw2.interfaces.PostagemDao;
import br.edu.ifpb.pw2.model.Postagem;
import br.edu.ifpb.pw2.model.Usuario;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    
    @RequestMapping(value = "/excluir/{id}", method = RequestMethod.GET)
    public String excluirPostagem(@PathVariable String id) {
        
        if(postagemDao.excluir(Integer.parseInt(id))) {
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
    
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public HttpEntity<InputStreamResource> downloadPosts(HttpServletResponse response, @Autowired HttpSession session) throws IOException {
        
        int idUsuaurio = (int) session.getAttribute("id_usuario");
        
        File arquivo = new File("postagem.csv");
        if(!arquivo.exists()) arquivo.createNewFile();
        
        List<Postagem> postagens = postagemDao.listarPostsDoUsuario(idUsuaurio);
        Collections.sort(postagens);
        if(postagens.isEmpty()) return null;
        
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(arquivo));
        CSVPrinter writer = new CSVPrinter(bufferedWriter,
                CSVFormat.DEFAULT.withHeader("id", "nome_usuario", "mensagem"));

        for (Postagem postagem : postagens) {
            writer.printRecord(postagem.getId(), postagem.getUsuario().getNomeUsuario(), postagem.getMensagem());
        }

        writer.flush();

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.parseMediaType("application/ms-excel"));
        header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + arquivo);
        header.setContentLength(arquivo.length());
        InputStreamResource inputStreamResource = new InputStreamResource(new FileInputStream(arquivo));
        return new ResponseEntity<>(inputStreamResource, header, HttpStatus.OK);
        
    }
    
}
