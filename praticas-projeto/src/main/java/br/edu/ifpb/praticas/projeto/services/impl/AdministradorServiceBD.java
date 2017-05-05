
package br.edu.ifpb.praticas.projeto.services.impl;

import br.edu.ifpb.praticas.projeto.entidades.Usuario;
import br.edu.ifpb.praticas.projeto.factory.FactoryDao;
import br.edu.ifpb.praticas.projeto.services.interfaces.AdministradorService;
import java.util.List;

/**
 *
 * @author Edilva
 */
public class AdministradorServiceBD implements AdministradorService{

    @Override
    public boolean salvar(Usuario administrador) {
        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaAdministrador().salvar(administrador);
    }

    @Override
    public boolean remover(int id) {
        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaAdministrador().remover(id);
    }

    @Override
    public boolean editar(Usuario administrador) {
        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaAdministrador().editar(administrador);
    }

    @Override
    public List<Usuario> listar() {
        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaAdministrador().listar();
    }

    @Override
    public Usuario getAdministrador(int id) {
        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaAdministrador().getAdministrador(id);
    }

    @Override
    public Usuario autenticar(String email, String senha) {
        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaAdministrador().autenticar(email, senha);
    }
    
//    @Override
//    public void salvar(Usuario administrador){
//        FactoryDao.createFactory(FactoryDao.DAO_BD).criaAdministrador().salvar(administrador);
//    }
//    
//    @Override
//    public boolean remover(int id){
//        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaAdministrador().remover(id);
//    }
//    
//    @Override
//    public boolean editar(Usuario administrador){
//        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaAdministrador().editar(administrador);
//    }
//    
//    @Override
//    public Usuario getAdministrador(int id) {
//        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaAdministrador().getAdministrador(id);
//    }
//    
//    @Override
//    public List<Usuario> listar(){
//        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaAdministrador().listar();
//    }
//
//    @Override
//    public Usuario autenticar(String email, String senha) {
//        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaAdministrador().autenticar(email, senha);
//    }
}
