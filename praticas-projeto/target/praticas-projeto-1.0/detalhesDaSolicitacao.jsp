<%-- 
    Document   : detalhesDoCliente
    Created on : 02/05/2017, 14:25:47
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
        <title>Resolvex - Detalhes da Solicitação de Servico</title>
    </head>
    <body>
        <div><jsp:include page="paginaDoPrestador.jsp"/></div>
        <br><br><br>
        <div class="container" style="width:70%">
            <div class="row">
                <img src="${solicitacao.cliente.foto}" style="width: 150px; height:150px; object-fit: cover" class="avatar img-responsive img-thumbnail"/>
                <h2><strong>${solicitacao.cliente.nome}</strong></h2>
                <p style="font-size:1.5em;"><strong>Email: </strong>${solicitacao.cliente.email}</p>
                <p style="font-size:1.5em;"><strong>Telefone: </strong>${solicitacao.cliente.telefone}</p>
                <p style="font-size:1.5em;"><strong>Endereço: </strong></p>
                <p style="font-size:1.5em;"><strong>Estado: </strong>${solicitacao.cliente.endereco.estado}</p>
                <p style="font-size:1.5em;"><strong>Cidade: </strong>${solicitacao.cliente.endereco.cidade}</p>
                <p style="font-size:1.5em;"><strong>Bairro: </strong>${solicitacao.cliente.endereco.bairro}</p>
                <p style="font-size:1.5em;"><strong>Rua: </strong>${solicitacao.cliente.endereco.rua}</p>
                <br>
                <p style="font-size:1.5em;"><strong>Faixa de datas: </strong>De ${solicitacao.data_inicial} à ${solicitacao.data_final}</p>
                <p style="font-size:1.5em;"><strong>Faixa de horários: </strong>De ${solicitacao.hora_inicial} à ${solicitacao.hora_final}</p>
                <div class="form-group col-md-6">
                    <a class="btn btn-primary btn-block" href="cadastroOrcamento.jsp?idSolicitacao=${solicitacao.id}">Enviar Orçamento</a>
                </div>
            </div>
        </div>
    </body>
</html>
