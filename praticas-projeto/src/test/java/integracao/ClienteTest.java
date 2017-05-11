
package integracao;

import br.edu.ifpb.praticas.projeto.entidades.Cliente;
import br.edu.ifpb.praticas.projeto.entidades.Endereco;
import br.edu.ifpb.praticas.projeto.entidades.TipoUsuario;
import br.edu.ifpb.praticas.projeto.services.impl.ClienteServiceBD;
import br.edu.ifpb.praticas.projeto.services.interfaces.ClienteService;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Edilva
 */
public class ClienteTest {
    
    private ClienteService service;
    
    @Before
    public void setUp() {
        this.service = new ClienteServiceBD();
    }
    
    @Test
    public void salvarClienteTeste() {
        Endereco endereco = new Endereco("Fulano de Tal", "Centro", "Cajazeiras", "PB");
        Cliente cliente = new Cliente("559.868.803-40", "(83) 99122-2222", "foto", endereco, "João Paulo Ferreira", "joaop@gmail.com", "12345", TipoUsuario.CLIENTE);
        cliente.setId(10);
        service.salvar(cliente);
    }
    
    @Test
    public void exibirClienteTeste() {
        Cliente cliente = service.getCliente(10);
        System.out.println(cliente.toString());
    }

    @Test
    public void editarClienteTeste() {
        Cliente cliente = service.getCliente(10);
        cliente.setNome("João P. Ferreira");
        cliente.setSenha("443332");
        service.editar(cliente);
    }
    
    @Test
    public void listarClienteTeste() {
        List<Cliente> clientes = service.listar();
        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());
        }
    }
    
//    @Test
//    public void removerClienteTeste() {
//        service.remover(10);
//    }
    
}
