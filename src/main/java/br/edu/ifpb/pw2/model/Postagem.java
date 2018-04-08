
package br.edu.ifpb.pw2.model;

import java.io.Serializable;

/**
 *
 * @author natan
 */
public class Postagem implements Serializable, Comparable<Postagem> {
    
    public int id;
    public Usuario usuario;
    public String mensagem;

    public Postagem() {  };
    
    public Postagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    @Override
    public String toString() {
        return "Postagem{" + "id=" + id + ", id_usuario=" + usuario.toString() + ", mensagem=" + mensagem + '}';
    }

    @Override
    public int compareTo(Postagem p) {
        return p.getId() - this.getId();
    }

    
}
