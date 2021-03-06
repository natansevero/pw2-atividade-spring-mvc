/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pw2.interfaces;

import br.edu.ifpb.pw2.model.Postagem;
import br.edu.ifpb.pw2.model.Usuario;
import java.util.List;

/**
 *
 * @author natan
 */
public interface PostagemDao {
    boolean adicionar(Postagem postagem);
    List<Postagem> buscarTodosPostsDoUsuario(Usuario usuario);
    Postagem buscarPorId(int id);
    List<Postagem> todosOsPostsParaFeed(Usuario usuario);
    boolean excluir(int id);
    List<Postagem> listarPostsDoUsuario(int id);
}
