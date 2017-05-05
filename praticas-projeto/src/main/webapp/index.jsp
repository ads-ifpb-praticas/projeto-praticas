<%-- 
    Document   : index
    Created on : 27/04/2017, 19:12:11
    Author     : Edilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
<!--        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/estilo.css" rel="stylesheet">
        <script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>-->
        <title>JSP Page</title>
    </head>
    <body>
        <div><jsp:include page="index.html"/></div>
        <div class="container" style="width:50%">
            <div class="row" style="padding: 200px 0 0 0; text-align: center;">
                <a href="loginCliente.jsp" style="font-size:3em;" class="btn btn-primary btn-block">Cliente</a>
                <br>
                <a href="loginPrestadorDeServico.jsp" style="font-size:3em;" class="btn btn-primary btn-block">Prestador de Serviço</a>
            </div>
        </div>
    </body>
</html>
