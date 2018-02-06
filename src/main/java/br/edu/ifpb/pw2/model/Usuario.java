/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pw2.model;

/**
 *
 * @author natan
 */
public class Usuario {
    
    private int id;
    private String nomeUsuario;
    private String senha;
    private byte[] foto;

    public Usuario() { }
    
    public Usuario(String nomeUsuario, String senha, byte[] foto) {
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

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nomeUsuario=" + nomeUsuario + ", senha=" + senha + ", foto=" + foto + '}';
    }

}
