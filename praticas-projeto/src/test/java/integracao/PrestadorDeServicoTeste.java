/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracao;

import br.edu.ifpb.praticas.projeto.entidades.PrestadorDeServico;
import br.edu.ifpb.praticas.projeto.entidades.TipoServico;
import br.edu.ifpb.praticas.projeto.entidades.TipoUsuario;
import br.edu.ifpb.praticas.projeto.services.impl.PrestadorDeServicoServiceBD;
import br.edu.ifpb.praticas.projeto.services.interfaces.PrestadorDeServicoService;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Edilva
 */
public class PrestadorDeServicoTeste{

    private PrestadorDeServicoService service;
    
    @Before
    public void setUp() {
        this.service = new PrestadorDeServicoServiceBD();
    }
    
    @Test
    public void salvarPrestadorDeServicoTeste() {
        PrestadorDeServico pds = new PrestadorDeServico("874.687.204-36", "foto", TipoServico.HIDRAULICA, "documento", 0, "Arnaldo Alencar", "arnaldo@gmail.com", "12345", TipoUsuario.ADMINISTRADOR, false);
        pds.setId(60);
        service.salvar(pds);
    }
    
    @Test
    public void exibirPrestadorDeServicoTeste() {
        PrestadorDeServico pds = service.getPrestadorDeServico(60);
        System.out.println(pds.toString());
    }

    @Test
    public void editarPrestadorDeServicoTeste() {
        PrestadorDeServico pds = service.getPrestadorDeServico(60);
        pds.setNome("Arnaldo Alencar Abreu");
        service.editar(pds);
    }
    
    @Test
    public void listarPrestadorDeServicoTeste() {
        List<PrestadorDeServico> prestadores = service.listar();
        for (PrestadorDeServico prestador : prestadores) {
            System.out.println(prestador.toString());
        }
    }
    
//    @Test
//    public void removerPrestadorDeServicoTeste() {
//        service.remover(60);
//    }
    
}
