
package integracao;

import br.edu.ifpb.praticas.projeto.entidades.TipoUsuario;
import br.edu.ifpb.praticas.projeto.entidades.Usuario;
import br.edu.ifpb.praticas.projeto.services.impl.AdministradorServiceBD;
import br.edu.ifpb.praticas.projeto.services.interfaces.AdministradorService;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Edilva
 */
public class AdministradorTest {
    
    private AdministradorService service;
    
    @Before
    public void setUp() {
        this.service = new AdministradorServiceBD();
    }
    
    @Test
    public void salvarAdministradorTeste() {
        Usuario admin = new Usuario("Laura", "laura@gmail.com", "12345", TipoUsuario.ADMINISTRADOR);
        admin.setId(40);
        service.salvar(admin);
    }
    
    @Test
    public void exibirAdministradorTeste() {
        Usuario admin = service.getAdministrador(40);
        System.out.println(admin.toString());
    }

    @Test
    public void editarAdministradorTeste() {
        Usuario admin = service.getAdministrador(40);
        admin.setNome("Laura Pedrosa");
        service.editar(admin);
    }
    
    @Test
    public void listarAdministradorTeste() {
        List<Usuario> administradores = service.listar();
        for (Usuario administrador : administradores) {
            System.out.println(administrador.toString());
        }
    }
    
    @Test
    public void removerAdministradorTeste() {
        service.remover(40);
    }  
    
}
