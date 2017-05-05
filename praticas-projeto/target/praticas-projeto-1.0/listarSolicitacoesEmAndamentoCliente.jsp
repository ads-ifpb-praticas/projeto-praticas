<%-- 
    Document   : listarSolicitacoesDeServicos
    Created on : 02/05/2017, 10:10:17
    Author     : Edilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="listaSolicitacoes" class="br.edu.ifpb.praticas.projeto.services.impl.SolicitacaoServicoServiceBD" scope="page"/>
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
                            <td>SERVICO</td>
                            <td>DE</td>
                            <td>ATÉ</td>
                            <td>DE</td>
                            <td>ATÉ</td>
                            <td>VER ORÇAMENTOS</td>
                        </tr>
                        <c:forEach var="solicitacao" items="${listaSolicitacoes.listar()}">
                            <c:if test="${solicitacao.status == 'DISPONIVEL' && solicitacao.cliente.id == cliente.id}">
                                <tr class="row">
                                    <td>${solicitacao.servico}</td>
                                    <td>${solicitacao.data_inicial}</td>
                                    <td>${solicitacao.data_final}</td>
                                    <td>${solicitacao.hora_inicial}</td>
                                    <td>${solicitacao.hora_final}</td>
                                    <td>
                                        <a class="btn btn-primary btn-block" href="Controller?command=">Orçamentos</a>
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