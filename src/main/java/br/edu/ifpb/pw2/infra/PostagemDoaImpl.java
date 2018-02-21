/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pw2.infra;

import br.edu.ifpb.pw2.interfaces.PostagemDao;
import br.edu.ifpb.pw2.model.Postagem;
import br.edu.ifpb.pw2.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author natan
 */
@Repository
public class PostagemDoaImpl implements PostagemDao {

    @Autowired
    private ConFactory con;
    
    @Override
    public boolean adicionar(Postagem postagem) {
        String sql = "insert into postagem (id_usuario, mensagem) values (?,?)";
        try {
            PreparedStatement prepareStatement = con.getConnection().prepareStatement(sql);
            prepareStatement.setInt(1, postagem.getUsuario().getId());
            prepareStatement.setString(2, postagem.getMensagem());
            
            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PostagemDoaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public List<Postagem> buscarTodosPostsDoUsuario(Usuario usuario) {
        String sql = "select * from postagem where id_usuario = ?";
        
        try {
            PreparedStatement prepareStatement = con.getConnection().prepareStatement(sql);
            prepareStatement.setInt(1, usuario.getId());
            
            ResultSet rs = prepareStatement.executeQuery();
            
            List<Postagem> postagens = new ArrayList<>();
            
            while(rs.next()) {
                Postagem postagem = new Postagem();
                Usuario u = new Usuario();
                
                postagem.setId(rs.getInt(1));
                u.setId(rs.getInt(2));
                postagem.setUsuario(u);
                postagem.setMensagem(rs.getString(3));
                
                postagens.add(postagem);
            }
            
            return postagens;
            
        } catch (SQLException ex) {
            Logger.getLogger(PostagemDoaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return Collections.EMPTY_LIST;
    }

    @Override
    public Postagem buscarPorId(int id) {
        String sql = "select p.mensagem, u.nome_usuario, u.foto from postagem p, usuario u where p.id = ? and p.id_usuario = u.id";
        
        try {
            PreparedStatement prepareStatement = con.getConnection().prepareStatement(sql);
            prepareStatement.setInt(1, id);
            
            ResultSet rs = prepareStatement.executeQuery();
            
            rs.next();
            
            Postagem postagem = new Postagem();
            Usuario usuario = new Usuario();
            
            postagem.setMensagem(rs.getString(1));
            usuario.setNomeUsuario(rs.getString(2));
            usuario.setFoto(rs.getString(3));
            postagem.setUsuario(usuario);
            
            return postagem;
            
        } catch (SQLException ex) {
            Logger.getLogger(PostagemDoaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return null;
    }
    
}
