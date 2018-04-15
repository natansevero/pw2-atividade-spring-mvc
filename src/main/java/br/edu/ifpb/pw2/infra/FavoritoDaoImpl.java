/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pw2.infra;

import br.edu.ifpb.pw2.interfaces.FavoritarDao;
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
public class FavoritoDaoImpl implements FavoritarDao {

    @Autowired
    private ConFactory con;
    
    @Override
    public boolean adicionar(int idUsuario, int idPostagem) {
        String sql = "insert into favorito(id_usuario, id_postagem) values (?,?)";
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setInt(1, idUsuario);
            stmt.setInt(2, idPostagem);
            
            return stmt.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(FavoritoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public boolean remover(int idUsuario, int idPostagem) {
        String sql = "delete from favorito where id_usuario = ? and id_postagem = ?";
        
         try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setInt(1, idUsuario);
            stmt.setInt(2, idPostagem);
            
            return stmt.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false; 
    }

    @Override
    public List<Postagem> listarPostagensFavoritas(int idUsuario) {
        String sql = "select p.id, p.id_usuario, u.nome_usuario, u.foto, p.mensagem from postagem p, favorito f, usuario u " +
                     "where f.id_usuario = ? and " +
                     "p.id = f.id_postagem and " + 
                     "u.id = p.id_usuario";

        try {
            PreparedStatement prepareStatement = con.getConnection().prepareStatement(sql);
            prepareStatement.setInt(1, idUsuario);
            
            ResultSet rs = prepareStatement.executeQuery();
            
            List<Postagem> postagens = new ArrayList<>();
            
            while(rs.next()) {
                Postagem postagem = new Postagem();
                Usuario u = new Usuario();
                
                postagem.setId(rs.getInt(1));
                u.setId(rs.getInt(2));
                u.setNomeUsuario(rs.getString(3));
                u.setFoto(rs.getString(4));
                postagem.setUsuario(u);
                postagem.setMensagem(rs.getString(5));
                
                postagens.add(postagem);
            }
            
            return postagens;
            
        } catch (SQLException ex) {
            Logger.getLogger(PostagemDoaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return Collections.EMPTY_LIST;
    }

    @Override
    public boolean verificarSePostFavorito(int idUsuario, int idPostagem) {
        String sql = "select count(*) from favorito where id_usuario = ? and id_postagem = ?";
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setInt(1, idUsuario);
            stmt.setInt(2, idPostagem);
            
            ResultSet rs = stmt.executeQuery();
            
            rs.next();
            
            if(rs.getInt(1) == 1) return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false; 
    }
    
    
    
}
