<%-- 
    Document   : detalhesDoPrestador
    Created on : 28/04/2017, 16:29:37
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
        <title>Resolvex - Detalhes do Prestador de Servico</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${adm.tipo_usuario == 'ADMINISTRADOR'}">
                <div><jsp:include page="paginaDoAdministrador.jsp"/></div>
            </c:when>
            <c:when test="${cliente.tipo_usuario == 'CLIENTE'}">
                <div><jsp:include page="paginaDoCliente.jsp"/></div>
            </c:when>
        </c:choose>
        <br><br><br>
        <div class="container" style="width:70%">
            <div class="row">
                <img src="${pds.foto}" style="width: 150px; height:150px; object-fit: cover" class="avatar img-responsive img-thumbnail"/>
                <h2><strong>${pds.nome}</strong></h2>
                <p style="font-size:1.5em;"><strong>Email: </strong>${pds.email}</p>
                <p style="font-size:1.5em;"><strong>Tipo de Serviço: </strong>${pds.tipo_servico.descricao}</p>
                <c:if test="${adm.tipo_usuario == 'ADMINISTRADOR'}">
                    <p style="font-size:1.5em;"><strong>CPF: </strong>${pds.cpf}</p>
                    <p style="font-size:1.5em;"><strong>Documento: </strong></p>
                    <img src="${pds.documento}" style="width: 400px; height:400px; object-fit: cover" class="avatar img-responsive img-thumbnail"/>
                </c:if>
                <c:if test="${cliente.tipo_usuario == 'CLIENTE'}">
                    <form method="post" id="cadastroCliente" action="Controller?command=EnviarComentario&cliente=${cliente.id}&prestador=${pds.id}">
                        <p style="font-size:1.5em;"><strong>Deixe sua opinião sobre os serviços desse profissional:</strong></p>
                        <textarea class="form-control" rows="3" name="comentario" id="comentario" placeholder="Escreva seu comentário" required maxlength="255"></textarea>
                        <input id="btnEnviar" type="submit" value="Enviar" class="btn btn-primary col-md-2">
                    </form>
                        <br><br>
                    <c:forEach var="comentario" items="${pds.comentarios}">
                        <p><img src="${comentario.cliente.foto}" style="width: 50px; height:50px; object-fit: cover" class="avatar img-responsive img-thumbnail"/> <strong>${comentario.cliente.nome}: </strong>${comentario.comentario}</p>
                        </c:forEach>
                    </c:if>
            </div>
        </div>
    </body>
</html>
