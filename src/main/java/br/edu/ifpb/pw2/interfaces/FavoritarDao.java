/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pw2.interfaces;

import br.edu.ifpb.pw2.model.Postagem;
import java.util.List;

/**
 *
 * @author natan
 */
public interface FavoritarDao {
    boolean adicionar(int idUsuario, int idPostagem);
    boolean remover(int idUsuario, int idPostagem);
    List<Postagem> listarPostagensFavoritas(int idUsuario);
    boolean verificarSePostFavorito(int idUsuario, int idPostagem);
}
