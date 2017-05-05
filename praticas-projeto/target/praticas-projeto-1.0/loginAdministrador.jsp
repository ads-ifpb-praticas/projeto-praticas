<%-- 
    Document   : login
    Created on : 20/04/2017, 10:29:46
    Author     : Edilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login do Administrador</title>
    </head>
    <body>
        <div><jsp:include page="index.html"/></div>
        <br><br><br>
        <div class="container text-center">
            <h2>Login do Administrador</h2>
            <br>
        </div>
        <div class="container" style="width:30%">
            <div class="row">
                <form method="post" id="login" action="Controller?command=AutenticarAdministrador">
                    <div class="form-group col-md-12">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" name="email" id="email" required>
                    </div>
                    <div class="form-group col-md-12">
                        <label for="senha">Senha</label>
                        <input type="password" class="form-control" name="senha" id="senha" required>
                    </div>
                    <div class="form-group col-md-12">
                        <input id="btnCadastrar" type="submit" value="Entrar" class="btn btn-primary btn-block">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
