
package br.edu.ifpb.praticas.projeto.services.impl;

import br.edu.ifpb.praticas.projeto.entidades.Comentario;
import br.edu.ifpb.praticas.projeto.factory.FactoryDao;
import br.edu.ifpb.praticas.projeto.services.interfaces.ComentarioService;
import java.util.List;

/**
 *
 * @author Edilva
 */
public class ComentarioServiceBD implements ComentarioService{

    @Override
    public boolean salvar(Comentario comentario, int idPrestador) {
        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaComentario().salvar(comentario, idPrestador);
    }

    @Override
    public boolean remover(int id) {
        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaComentario().remover(id);
    }

    @Override
    public boolean editar(Comentario comentario) {
        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaComentario().editar(comentario);
    }

    @Override
    public List<Comentario> listar() {
        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaComentario().listar();
    }

    @Override
    public Comentario getComentario(int id) {
        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaComentario().getComentario(id);
    }

    @Override
    public List<Comentario> listarComentariosPrestador(int idPrestador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public boolean salvar(Comentario comentario, int id) {
//        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaComentario().salvar(comentario, id);
//    }
//
//    @Override
//    public boolean remover(int id) {
//        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaComentario().remover(id);
//    }
//
//    @Override
//    public boolean editar(Comentario comentario) {
//        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaComentario().editar(comentario);
//    }
//
//    @Override
//    public Comentario getComentario(int id) {
//        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaComentario().getComentario(id);
//    }
//
//    @Override
//    public List<Comentario> listar() {
//        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaComentario().listar();
//    }
//
//    @Override
//    public List<Comentario> listarComentariosPrestador(int idPrestador) {
//        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaComentario().listarComentariosPrestador(idPrestador);
//    }
    
}
