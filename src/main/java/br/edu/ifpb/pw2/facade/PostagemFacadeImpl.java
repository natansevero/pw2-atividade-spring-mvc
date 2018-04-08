
package br.edu.ifpb.pw2.facade;

import br.edu.ifpb.pw2.interfaces.PostagemDao;
import org.springframework.stereotype.Service;
import br.edu.ifpb.pw2.interfaces.PostagemFacade;
import br.edu.ifpb.pw2.model.Postagem;
import br.edu.ifpb.pw2.model.Usuario;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author natan
 */
@Service
public class PostagemFacadeImpl implements PostagemFacade {

    @Autowired
    private PostagemDao postagemDao;
    
    @Override
    public List<Postagem> organizarPostagens(Usuario usuario) {
        List<Postagem> postsDoUsuario = postagemDao.buscarTodosPostsDoUsuario(usuario);
        List<Postagem> postsParaFeed = postagemDao.todosOsPostsParaFeed(usuario);
    
        postsDoUsuario.addAll(postsParaFeed);
        
//        System.out.println("\n");
//        postsParaFeed.forEach(action -> System.out.println(action));
        Collections.sort(postsDoUsuario);
        
        return postsDoUsuario;
    }
    
    
    
}
