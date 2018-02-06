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
public class Postagem {
    
    public int id;
    public int id_usuario;
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

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return "Postagem{" + "id=" + id + ", id_usuario=" + id_usuario + ", mensagem=" + mensagem + '}';
    }

    
}
