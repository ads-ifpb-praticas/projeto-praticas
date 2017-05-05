<%-- 
    Document   : cadastroOrcamento
    Created on : 03/05/2017, 07:43:01
    Author     : Edilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>
        <title>Resolvex - Cadastro de Orçamento</title>
    </head>
    <body>
        <div><jsp:include page="paginaDoPrestador.jsp"/></div>
        <br><br><br>
        <div class="container text-center">
            <h2>Cadastro de Orçamento</h2>
            <br>
        </div>
        <div class="container" style="width:60%">
            <div class="row">
                <form method="post" id="cadastroAdministrador" action="Controller?command=CadastrarOrcamento&idSolicitacao=${param.idSolicitacao}&idPrestador=${pds.id}">
                    <div class="form-group col-md-12">
                        <label for="descricao">Descrição: </label>
                        <textarea class="form-control" rows="3" name="descricao" id="descricao" required maxlength="200"></textarea>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="valor">Valor</label>
                        <input type="text" class="form-control" name="valor" id="valor" required>
                    </div>
                    <div class="form-group col-md-6">
                        <br>
                        <input id="btnCadastrar" type="submit" value="Enviar" class="btn btn-primary btn-block">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
