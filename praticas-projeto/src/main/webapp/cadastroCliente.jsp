<%-- 
    Document   : cadastroCliente
    Created on : 21/04/2017, 10:25:03
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
        <title>Cadastro do Cliente</title>
    </head>
    <body>
        <div><jsp:include page="index.html"/></div>
        <br><br><br>
        <div class="container text-center">
            <h2>Dados do Cliente</h2>
            <br>
        </div>
        <div class="container" style="width:60%">
            <div class="row">
                <form method="post" id="cadastroCliente" action="Controller?command=CadastrarCliente" enctype = "multipart/form-data">
                    <div class="form-group col-md-6">
                        <label for="nome">Nome: </label>
                        <input type="text" class="form-control" name="nome" id="nome" autofocus required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="cpf">CPF: </label>
                        <input type="text" class="form-control" name="cpf" id="cpf" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="estado">Estado: </label>
                        <select class="form-control" name="estado" id="estado">
                            <option value="AC">Acre</option>
                            <option value="AL">Alagoas</option>
                            <option value="AM">Amazonas</option>
                            <option value="AM">Amapá</option>
                            <option value="BA">Bahia</option>
                            <option value="DF">Brasília</option>
                            <option value="CE">Ceará</option>
                            <option value="ES">Espírito Santo</option>
                            <option value="GO">Goiás</option>
                            <option value="MA">Maranhão</option>
                            <option value="MT">Mato Grosso</option>
                            <option value="MS">Mato Gosso do Sul</option>
                            <option value="MG">Minas Gerais</option>
                            <option value="PA">Pará</option>
                            <option value="PB" selected>Paraíba</option>
                            <option value="PR">Paraná</option>
                            <option value="PE">Pernambuco</option>
                            <option value="PI">Piauí</option>
                            <option value="RJ">Rio de Janeiro</option>
                            <option value="RN">Rio Grande do Norte</option>
                            <option value="RS">Rio Grande do Sul</option>
                            <option value="RO">Rondônia</option>
                            <option value="RR">Roraima</option>
                            <option value="SC">Santa Catarina</option>
                            <option value="SC">São Paulo</option>
                            <option value="SE">Sergipe</option>
                            <option value="TO">Tocantins</option>
                        </select>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="cidade">Cidade: </label>
                        <input type="text" class="form-control" name="cidade" id="cidade" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="bairro">Bairro: </label>
                        <input type="text" class="form-control" name="bairro" id="bairro" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="rua">Rua: </label>
                        <input type="text" class="form-control" name="rua" id="rua" required>
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
                        <label for="telefone">Telefone: </label>
                        <input type="text" class="form-control" name="telefone" id="telefone" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="foto">Foto</label>
                        <input type="file" class="form-control" name="foto" id="foto" required>
                    </div>
                    <div class="form-group col-md-6">
                        <input id="btnCadastrar" type="submit" value="Cadastrar" class="btn btn-primary btn-block">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
