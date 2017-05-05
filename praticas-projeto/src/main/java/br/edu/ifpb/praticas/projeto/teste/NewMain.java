package br.edu.ifpb.praticas.projeto.teste;

import br.edu.ifpb.praticas.projeto.entidades.Cliente;
import br.edu.ifpb.praticas.projeto.entidades.Comentario;
import br.edu.ifpb.praticas.projeto.entidades.PrestadorDeServico;
import br.edu.ifpb.praticas.projeto.entidades.TipoServico;
import br.edu.ifpb.praticas.projeto.entidades.TipoUsuario;
import br.edu.ifpb.praticas.projeto.entidades.Usuario;
import br.edu.ifpb.praticas.projeto.services.impl.AdministradorServiceBD;
import br.edu.ifpb.praticas.projeto.services.impl.ClienteServiceBD;
import br.edu.ifpb.praticas.projeto.services.impl.ComentarioServiceBD;
import br.edu.ifpb.praticas.projeto.services.impl.PrestadorDeServicoServiceBD;
import br.edu.ifpb.praticas.projeto.services.impl.SolicitacaoServicoServiceBD;
import br.edu.ifpb.praticas.projeto.services.interfaces.AdministradorService;
import br.edu.ifpb.praticas.projeto.services.interfaces.ClienteService;
import br.edu.ifpb.praticas.projeto.services.interfaces.ComentarioService;
import br.edu.ifpb.praticas.projeto.services.interfaces.PrestadorDeServicoService;
import br.edu.ifpb.praticas.projeto.services.interfaces.SolicitacaoServicoService;
import java.util.List;

/**
 *
 * @author Edilva
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PrestadorDeServico pds;
//        pds.setEmail("edilva@gmail.com");
//        pds.setNome("Edilva");
//        pds.setSenha("1234");
//        pds.setCpf("111111");
//        pds.setTipoUsuario(TipoUsuario.PRESTADOR_DE_SERVICO);
//        pds.setTipoServico(TipoServico.HIDRAULICA);
//        PrestadorDeServicoService service = new PrestadorDeServicoServiceBD();
//        pds = service.autenticar("carla@gmail.com", "12345");
//        System.out.println(pds.toString());

//        ClienteService clienteService = new ClienteServiceBD();
//        Cliente cliente = clienteService.getCliente(20);
//
//        ComentarioService comentarioService = new ComentarioServiceBD();
//
//        Comentario c = new Comentario(cliente, "muito bom");
//        comentarioService.salvar(c, 3);
//          Usuario u = new Usuario("Edilva", "edilva@gmaiil.com", "12345", TipoUsuario.ADMINISTRADOR);;
//          
//          AdministradorService service = new AdministradorServiceBD();
//          
//          service.salvar(u);
        PrestadorDeServicoService service = new PrestadorDeServicoServiceBD();
        PrestadorDeServico p = service.getPrestadorDeServico(8);
        SolicitacaoServicoService service2 = new SolicitacaoServicoServiceBD();
        System.out.println(service2.solicitacoesDisponiveis(p));

//        PrestadorDeServicoService service = new PrestadorDeServicoServiceBD();
//        PrestadorDeServico p = service.getPrestadorDeServico(8);
//        System.out.println(p.toString());
//        List<Comentario> c = p.getComentarios();
//        System.out.println(c.toString());
//        for (Comentario comentario : c) {
//            System.out.println(comentario);
//        }
    }

}
