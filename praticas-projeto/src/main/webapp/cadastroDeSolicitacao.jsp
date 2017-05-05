<%-- 
    Document   : cadastroDeSolicitacao
    Created on : 29/04/2017, 18:48:14
    Author     : Edilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>
        <script src='//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js'></script>
        <script src="js/jquery.maskedinput.min.js" type="text/javascript"></script>
        <script src="js/funcoes.js"></script>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <title>Cadastro de Solicitação de Serviço</title>
    </head>
    <body>
        <div><jsp:include page="paginaDoCliente.jsp"/></div>
        <br><br><br>
        <div class="container text-center">
            <h2>Dados do Solicitação de Serviço</h2>
            <br>
        </div>
        <div class="container" style="width:60%">
            <div class="row">
                <form method="post" id="cadastroAdministrador" action="Controller?command=CadastrarSolicitacaoDeServico">
                    <div class="form-group col-md-12">
                        <label for="tipo_servico">Servico:</label>
                        <select class="form-control" name="tipo_servico" id="tipo_servico">
                            <c:forEach var="servico" items="${servicos}">
                                <option value="${servico}">${servico.descricao}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group col-md-12 text-center">
                        <strong>Faixa de Datas</strong>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="data_inicial">De:</label>
                        <input type="text" class="form-control" name="data_inicial" id="data_inicial" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" maxlength="10" title="dd/MM/aaaa" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="data_final">Até:</label>
                        <input type="text" class="form-control" name="data_final" id="data_final" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" maxlength="10" title="dd/MM/aaaa" required>
                    </div>
                    <div class="form-group col-md-12 text-center">
                        <strong>Faixa de Horários</strong>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="hora_inicial">De:</label>
                        <input type="text" class="form-control" name="hora_inicial" id="hora_inicial" pattern="[0-9]{2}:[0-9]{2}$" maxlength="5" title="HH:mm" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="hora_final">Até:</label>
                        <input type="text" class="form-control" name="hora_final" id="hora_final" pattern="[0-9]{2}:[0-9]{2}$" maxlength="5" title="HH:mm" required>
                    </div>
                    <div class="form-group col-md-6">
                        <input id="btnCadastrar" type="submit" value="Enviar" class="btn btn-primary btn-block">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
