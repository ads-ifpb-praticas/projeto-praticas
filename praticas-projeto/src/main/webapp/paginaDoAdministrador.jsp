<%-- 
    Document   : paginaDoAdministrador
    Created on : 27/04/2017, 21:18:47
    Author     : Edilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Resolvex</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/estilo.css" rel="stylesheet">
        <script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>
        <script src='//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js'></script>
    </head>
    <body>
        <header>
            <nav class="navbar navbar-default navbar-fixed-top">
                <div class="container">

                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> 
                            <span class="sr-only">Toggle navigation</span> 
                        </button> 
                        <a class="navbar-brand" href="paginaDoAdministrador.jsp">Resolvex - Adminstrador - ${adm.nome}</a>
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li><a href="cadastroAdministrador.jsp">Cadastrar Administrador</a></li>
                            <li class="dropdown">
                                <a href="" class="dropdown-toggle" data-toggle="dropdown">Prestadores de Serviço</a>
                                <ul class="nav dropdown-menu">
                                    <li><a href="listarPrestadores.jsp">Listar Prestadores de Serviços</a></li>
                                    <li><a href="solicitacoesDePrestadores.jsp">Solicitações</a></li>
                                </ul>
                            </li>
                            <li><a href="Controller?command=Sair">Sair</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container -->
            </nav>
        </header>
        <footer>
            <h4>Resolvex 2016. Todos os direitos reservados</h4>
        </footer>
    </body>
</html>
