/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pw2.interfaces;

import br.edu.ifpb.pw2.model.Usuario;
import java.util.List;

/**
 *
 * @author natan
 */
public interface UsuarioDao {
    boolean adicionar(Usuario usuario);
    Usuario buscarPorUm(int id);
    List<Usuario> buscarTodos();
}
