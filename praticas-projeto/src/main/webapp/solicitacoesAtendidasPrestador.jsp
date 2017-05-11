<%-- 
    Document   : solicitacoesAtendidasPrestador
    Created on : 11/05/2017, 04:48:21
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
        <div><jsp:include page="paginaDoPrestador.jsp"/></div>
        <br><br><br>
        <div class="container text-center">
            <h2>Solicitações de Serviços Atendidas</h2>
            <br>
        </div>
        <div class="container" style="width:70%">
            <div class="row">
                <div class="form-group col-md-12">
                    <table class="table table-striped">
                        <tr class="row">
                            <td>SERVICO</td>
                            <td>DE</td>
                            <td>ATÉ</td>
                            <td>DE</td>
                            <td>ATÉ</td>
                        </tr>
                        <c:forEach var="orcamento" items="${listaOrcamentos.listar()}">
                            <c:if test="${orcamento.solicitacaoServico.status == 'CONFIRMADA' && orcamento.prestadorDeServico == pds}">
                                <tr class="row">
                                    <td>${orcamento.solicitacaoServico.servico}</td>
                                    <td>${orcamento.solicitacaoServico.data_inicial}</td>
                                    <td>${orcamento.solicitacaoServico.data_final}</td>
                                    <td>${orcamento.solicitacaoServico.hora_inicial}</td>
                                    <td>${orcamento.solicitacaoServico.hora_final}</td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
