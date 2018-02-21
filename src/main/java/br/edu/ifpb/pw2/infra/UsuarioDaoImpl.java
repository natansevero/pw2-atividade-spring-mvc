/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pw2.infra;

import br.edu.ifpb.pw2.interfaces.UsuarioDao;
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
public class UsuarioDaoImpl implements UsuarioDao {
    
    @Autowired
    private ConFactory con;

    @Override
    public boolean adicionar(Usuario usuario) {
       String sql = "insert into usuario (nome_usuario, senha, foto) values (?,?,?)";
       
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getFoto());
            
            return stmt.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false; 
    }

    @Override
    public Usuario buscarPorNomeUsuarioESenha(Usuario usuario) {
        String sql = "select id, nome_usuario, foto from usuario where nome_usuario = ? and senha = ?";
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setString(2, usuario.getSenha());
            
            ResultSet rs = stmt.executeQuery();
            
            Usuario u = new Usuario();
            
            rs.next();
            
            u.setId(rs.getInt(1));
            u.setNomeUsuario(rs.getString(2));
            u.setFoto(rs.getString(3));
            
            return u;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    @Override
    public Usuario buscarPorNome(String nome) {
        String sql = "select id, nome_usuario, foto from usuario where nome_usuario = ?";
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setString(1, nome);
            
            ResultSet rs = stmt.executeQuery();
            
            rs.next();
            
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt(1));
            usuario.setNomeUsuario(rs.getString(2));
            usuario.setFoto(rs.getString(3));
            
            return usuario;
            
        } catch (SQLException ex) {
            System.out.println("Usuario nao existe");
        }
        
        return null;
    }

    @Override
    public List<Usuario> buscarTodos() {
        String sql = "select * from usuario";
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            List<Usuario> usuarios = new ArrayList<>();
            
            while(rs.next()) {
                Usuario usuario = new Usuario();
                
                usuario.setId(rs.getInt(1));
                usuario.setNomeUsuario(rs.getString(2));
                usuario.setSenha(rs.getString(3));
                usuario.setFoto(rs.getString(4));
                
                usuarios.add(usuario);
            }
            
            return usuarios;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Collections.EMPTY_LIST;
    }
}
