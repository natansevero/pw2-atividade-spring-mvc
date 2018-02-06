/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pw2.model;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author natan
 */
public class Usuario {
    
    private int id;
    private String nomeUsuario;
    private String senha;
    private MultipartFile foto;

    public Usuario() { }
    
    public Usuario(String nomeUsuario, String senha, MultipartFile foto) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public MultipartFile getFoto() {
        return foto;
    }

    public void setFoto(MultipartFile foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        try {
            return "Usuario{" + "id=" + id + ", nomeUsuario=" + nomeUsuario + ", senha=" + senha + ", foto=" + Arrays.toString(foto.getBytes()) + '}';
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
