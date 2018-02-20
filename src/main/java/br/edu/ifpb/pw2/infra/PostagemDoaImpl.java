/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pw2.infra;

import br.edu.ifpb.pw2.interfaces.PostagemDao;
import br.edu.ifpb.pw2.model.Postagem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author natan
 */
public class PostagemDoaImpl implements PostagemDao {

    @Autowired
    private ConFactory con;
    
    @Override
    public boolean adicionar(Postagem postagem) {
        String sql = "insert into usuario (id_usuario, mensagem) values (?,?)";
        try {
            PreparedStatement prepareStatement = con.getConnection().prepareStatement(sql);
            prepareStatement.setInt(1, postagem.id_usuario);
            prepareStatement.setString(2, postagem.getMensagem());
            
            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PostagemDoaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public List<Postagem> buscarTodoas() {
        String sql = "select * from postagem";
        
        try {
            PreparedStatement prepareStatement = con.getConnection().prepareStatement(sql);
            
            ResultSet rs = prepareStatement.executeQuery();
            
            List<Postagem> postagens = new ArrayList<>();
            
            while(rs.next()) {
                Postagem postagem = new Postagem();
                postagem.setId(rs.getInt(1));
                postagem.setId_usuario(rs.getInt(2));
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
    public Postagem buscarPorUm(int id) {
        String sql = "select * from postagem where id = ?";
        
        try {
            PreparedStatement prepareStatement = con.getConnection().prepareStatement(sql);
            prepareStatement.setInt(1, id);
            
            ResultSet rs = prepareStatement.executeQuery();
            
            rs.next();
            
            Postagem postagem = new Postagem();
            postagem.setId(rs.getInt(1));
            postagem.setId_usuario(rs.getInt(2));
            postagem.setMensagem(rs.getString(3));
            
        } catch (SQLException ex) {
            Logger.getLogger(PostagemDoaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return null;
    }
    
}
