<%-- 
    Document   : cadastroPrestadorDeServico
    Created on : 21/04/2017, 11:16:36
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
        <div><jsp:include page="index.html"/></div>
        <br><br><br>
        <div class="container text-center">
            <h2>Dados do Prestador de Servico</h2>
            <br>
        </div>
        <div class="container" style="width:60%">
            <div class="row">
                <form method="post" id="cadastroPrestador" action="Controller?command=CadastrarPrestadorDeServico" enctype = "multipart/form-data">
                    <div class="form-group col-md-6">
                        <label for="nome">Nome: </label>
                        <input type="text" class="form-control" name="nome" id="nome" autofocus required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="cpf">CPF: </label>
                        <input type="text" class="form-control" name="cpf" id="cpf" required>
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
                        <label for="tipo_servico">Tipo de Serviço: </label>
                        <select class="form-control" name="tipo_servico" id="tipo" required>
                            <option value="PINTURA">Pintura</option>
                            <option value="HIDRAULICA">Hidráulica</option>
                            <option value="MECANICA">Mecânica</option>
                            <option value="MARCENARIA">Marcenaria</option>
                            <option value="MONTAGEM">Montagem</option>
                            <option value="ALVENARIA">Alvenaria</option>
                            <option value="ELETRICA">Elétrica</option>
                            <option value="REPAROS">Reparos</option>
                            <option value="LIMPEZA">Limpeza</option>
                        </select>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="foto">Foto</label>
                        <input type="file" class="form-control" name="foto" id="foto" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="documento">Documento com foto: </label>
                        <input type="file" class="form-control" name="documento" id="documento" required>
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
