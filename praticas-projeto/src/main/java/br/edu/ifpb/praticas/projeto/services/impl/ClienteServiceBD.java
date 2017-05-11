
package br.edu.ifpb.praticas.projeto.services.impl;

import br.edu.ifpb.praticas.projeto.entidades.Cliente;
import br.edu.ifpb.praticas.projeto.factory.FactoryDao;
import br.edu.ifpb.praticas.projeto.services.interfaces.ClienteService;
import java.util.List;

/**
 *
 * @author Edilva
 */
public class ClienteServiceBD implements ClienteService{

    @Override
    public boolean salvar(Cliente cliente) {
        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaCliente().salvar(cliente);
    }

    @Override
    public boolean remover(int id) {
        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaCliente().remover(id);
    }

    @Override
    public boolean editar(Cliente cliente) {
        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaCliente().editar(cliente);
    }

    @Override
    public List<Cliente> listar() {
        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaCliente().listar();
    }

    @Override
    public Cliente getCliente(int id) {
        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaCliente().getCliente(id);
    }

    @Override
    public Cliente autenticar(String email, String senha) {
        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaCliente().autenticar(email, senha);
    }

    
}
