<%-- 
    Document   : cadastroAdministrador
    Created on : 27/04/2017, 21:12:08
    Author     : Edilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>
        <title>Cadastro do Prestador de Servico</title>
    </head>
    <body>
        <div><jsp:include page="paginaDoAdministrador.jsp"/></div>
        <br><br><br>
        <div class="container text-center">
            <h2>Dados do Administrador</h2>
            <br>
        </div>
        <div class="container" style="width:60%">
            <div class="row">
                <form method="post" id="cadastroAdministrador" action="Controller?command=CadastrarAdministrador">
                    <div class="form-group col-md-6">
                        <label for="nome">Nome: </label>
                        <input type="text" class="form-control" name="nome" id="nome" autofocus required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" name="email" id="email" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="senha">Senha</label>
                        <input type="password" class="form-control" name="senha" id="senha" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label> </label>
                        <input id="btnCadastrar" type="submit" value="Cadastrar" class="btn btn-primary btn-block">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
