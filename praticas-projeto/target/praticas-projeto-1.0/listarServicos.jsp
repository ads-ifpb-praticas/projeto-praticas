<%-- 
    Document   : listarServicos
    Created on : 28/04/2017, 21:40:07
    Author     : Edilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="listaPrestadores" class="br.edu.ifpb.praticas.projeto.services.impl.PrestadorDeServicoServiceBD" scope="page"/>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>
        <title>Resolvex - Prestadores de Serviço</title>
    </head>
    <body>
        <div><jsp:include page="paginaDoCliente.jsp"/></div>
        <br><br><br>
        <div class="container text-center">
            <h2>Prestadores de Serviços</h2>
            <br>
        </div>
        <div class="container" style="width:95%">
            <div class="row">
                <div class="form-group col-md-12">
                    <table class="table table-striped">
                        <tr class="row">
                            <td>FOTO</td>
                            <td>NOME</td>
                            <td>TIPO DE SERVIÇO</td>
                            <td>EMAIL</td>
                            <td>DETALHAR PRESTADOR</td>
                        </tr>
                        <c:forEach var="prestador" items="${listaPrestadores.listar()}">
                            <c:if test="${prestador.acesso == true && prestador.tipo_servico == param.servico}">
                                <tr class="row">
                                    <td><img src="${prestador.foto}" style="width: 110px; height:110px; object-fit: cover" class="avatar img-responsive img-thumbnail"/></td>
                                    <td>${prestador.nome}</td>
                                    <td>${prestador.tipo_servico.descricao}</td>
                                    <td>${prestador.email}</td>
                                    <td>
                                        <a class="btn btn-primary btn-block" href="Controller?command=DetalharPrestador&id=${prestador.id}">Detalhar</a>
                                    </td>
                                </c:if>
                            </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>