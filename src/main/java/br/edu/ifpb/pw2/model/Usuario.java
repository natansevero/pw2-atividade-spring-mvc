
package br.edu.ifpb.pw2.model;

import java.io.Serializable;

/**
 *
 * @author natan
 */
public class Usuario implements Serializable {
    
    private int id;
    private String nomeUsuario;
    private String senha;
    private String foto;

    public Usuario() { }
    
    public Usuario(String nomeUsuario, String senha, String foto) {
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nomeUsuario=" + nomeUsuario + ", senha=" + senha + ", foto=" + foto + '}';
    }

}
