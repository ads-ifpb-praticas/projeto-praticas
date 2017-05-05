
package br.edu.ifpb.praticas.projeto.services.impl;

import br.edu.ifpb.praticas.projeto.entidades.PrestadorDeServico;
import br.edu.ifpb.praticas.projeto.factory.FactoryDao;
import br.edu.ifpb.praticas.projeto.services.interfaces.PrestadorDeServicoService;
import java.util.List;

/**
 *
 * @author Edilva
 */
public class PrestadorDeServicoServiceBD implements PrestadorDeServicoService{

    @Override
    public boolean salvar(PrestadorDeServico prestadorDeServico) {
        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaPrestadorDeServico().salvar(prestadorDeServico);
    }

    @Override
    public boolean remover(int id) {
        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaPrestadorDeServico().remover(id);
    }

    @Override
    public boolean editar(PrestadorDeServico prestadorDeServico) {
        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaPrestadorDeServico().editar(prestadorDeServico);
    }

    @Override
    public List<PrestadorDeServico> listar() {
        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaPrestadorDeServico().listar();
    }

    @Override
    public PrestadorDeServico getPrestadorDeServico(int id) {
        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaPrestadorDeServico().getPrestadorDeServico(id);
    }

    @Override
    public PrestadorDeServico autenticar(String email, String senha) {
        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaPrestadorDeServico().autenticar(email, senha);
    }

//    @Override
//    public boolean salvar(PrestadorDeServico prestadorDeServico) {
//        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaPrestadorDeServico().salvar(prestadorDeServico);
//    }
//
//    @Override
//    public boolean remover(int id) {
//        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaPrestadorDeServico().remover(id);
//    }
//
//
//    @Override
//    public boolean editar(PrestadorDeServico prestadorDeServico) {
//        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaPrestadorDeServico().editar(prestadorDeServico);
//    }
//
//    @Override
//    public PrestadorDeServico getPrestadorDeServico(int id) {
//        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaPrestadorDeServico().getPrestadorDeServico(id);
//    }
//
//    @Override
//    public List<PrestadorDeServico> listar() {
//        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaPrestadorDeServico().listar();
//    }
//
//    @Override
//    public PrestadorDeServico autenticar(String email, String senha) {
//        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaPrestadorDeServico().autenticar(email, senha);
//    }
    
}
