<%-- 
    Document   : paginaDeResposta
    Created on : 26/04/2017, 13:00:34
    Author     : Edilva
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de Resposta</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${adm.tipo_usuario == 'ADMINISTRADOR'}">
                <div><jsp:include page="paginaDoAdministrador.jsp"/></div>
            </c:when>
            <c:when test="${cliente.tipo_usuario == 'CLIENTE'}">
                <div><jsp:include page="paginaDoCliente.jsp"/></div>
            </c:when>
            <c:otherwise>
                <div><jsp:include page="index.html"/></div>
            </c:otherwise>
        </c:choose>
        <div>
            <br><br><br>
            <div class="container text-center">
                <h3>${mensagem}</h3>
                <div class="col-md-12 text-center">
                    <a href="${pagina}" class="btn btn-primary">Voltar</a>
                </div>
            </div>
        </div>
    </body>
</html>
