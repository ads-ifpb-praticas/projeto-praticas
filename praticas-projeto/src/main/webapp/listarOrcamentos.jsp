<%-- 
    Document   : listarOrcamentos
    Created on : 05/05/2017, 20:18:39
    Author     : Edilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="listaOrcamentos" class="br.edu.ifpb.praticas.projeto.services.impl.OrcamentoServiceBD" scope="page"/>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>
        <title>Resolvex - Solicitações de Servico</title>
    </head>
    <body>
        <div><jsp:include page="paginaDoCliente.jsp"/></div>
        <br><br><br>
        <div class="container text-center">
            <h2>Solicitações de Serviços</h2>
            <br>
        </div>
        <div class="container" style="width:70%">
            <div class="row">
                <div class="form-group col-md-12">
                    <table class="table table-striped">
                        <tr class="row">
                            <td>PRESTADOR</td>
                            <td>DESCRIÇÃO</td>
                            <td>VALOR</td>
                            <td>ACEITAR ORÇAMENTO</td>
                        </tr>
                        <c:forEach var="orcamento" items="${listaOrcamentos.listar()}">
                            <c:if test="${orcamento.status == 'ABERTO' && orcamento.solicitacaoServico.id == param.id}">
                                <tr class="row">
                                    <td>
                                        <a href="Controller?command=DetalharPrestador&id=${orcamento.prestadorDeServico.id}">${orcamento.prestadorDeServico.nome}</a>
                                    </td>
                                    <td>${orcamento.descricao}</td>
                                    <td>${orcamento.valor}</td>
                                    <td>
                                        <a class="btn btn-primary btn-block" href="Controller?command=AceitarOrcamento&id=${orcamento.id}">Aceitar</a>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
