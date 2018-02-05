/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pw2.infra;

import br.edu.ifpb.pw2.interfaces.PostagemDao;
import br.edu.ifpb.pw2.model.Postagem;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean buscarTodoas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean buscarPorUm(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
