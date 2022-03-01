<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%Map<String,String> errores= (Map<String,String>)request.getAttribute("errores");%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Clientes</title>
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet">

</head>
<body>
<h1>Aplicación Web del Banco</h1>
<h2>Gestion de clientes</h2>
<%if(errores != null && errores.size() > 0){%>
<ul class="alert alert-danger mx-5">
    <%for(String error: errores.values()){%>
    <li><%=error%></li>
    <%}%>
</ul>
<%}%>
<div class="px-5">
<div class="container-transacciones">
    <form action="/webapp-banco/client/create" method="post">


        <div class="container-form container-data-clientes">
         <h3> Información del cliente</h3>
            <div class="row mb-3">
                <label for="nombreCliente" class="col-form-label col-sm-2">Nombre(s):</label>
                <div class="col-sm-4"><input type="text" name="nombreCliente" id="nombreCliente" class="form-control" value="${param.nombreCliente}"></div>
                <%
                    if(errores != null && errores.containsKey("nombreCliente")){
                        out.println("<div class='row mb-3 alert alert-danger col-sm-4' style='color:red;'>"+errores.get("nombreCliente")+"</div>");
                    }
                %>
            </div>
            <div class="row mb-3">
                <label for="apellidoCliente" class="col-form-label col-sm-2">Apellido(s):</label>
                <div class="col-sm-4"><input type="text" name="apellidoCliente" id="apellidoCliente" class="form-control" value="${param.apellidoCliente}"></div>
                <%
                    if(errores != null && errores.containsKey("apellidoCliente")){
                        out.println("<div class='row mb-3 alert alert-danger col-sm-4' style='color:red;'>"+errores.get("apellidoCliente")+"</div>");
                    }
                %>
            </div>
            <div class="row mb-3">
                <label for="cedulaCliente" class="col-form-label col-sm-2">Cedula:</label>
                <div class="col-sm-4"><input type="text" name="cedulaCliente" id="cedulaCliente" class="form-control" value="${param.cedulaCliente}"></div>
                <%
                    if(errores != null && errores.containsKey("cedulaCliente")){
                        out.println("<div class='row mb-3 alert alert-danger col-sm-4' style='color:red;'>"+errores.get("cedulaCliente")+"</div>");
                    }
                %>
            </div>
            <div class="row mb-3">
                <label for="fechaNacimiento" class="col-form-label col-sm-2">Fecha nacimiento:</label>
                <div class="col-sm-4"><input type="text" name="fechaNacimiento" id="fechaNacimiento" class="form-control" value="${param.fechaNacimiento}"></div>
                <%
                    if(errores != null && errores.containsKey("fechaNacimiento")){
                        out.println("<div class='row mb-3 alert alert-danger col-sm-4' style='color:red;'>"+errores.get("fechaNacimiento")+"</div>");
                    }
                %>
            </div>
            <div class="row mb-3">
                <label for="edadCliente" class="col-form-label col-sm-2">Cedula:</label>
                <div class="col-sm-4"><input type="text" name="edadCliente" id="edadCliente" class="form-control" value="${param.edadCliente}"></div>
                <%
                    if(errores != null && errores.containsKey("edadCliente")){
                        out.println("<div class='row mb-3 alert alert-danger col-sm-4' style='color:red;'>"+errores.get("edadCliente")+"</div>");
                    }
                %>
            </div>
            <hr>

            <div class="row">
                <div class="col">
                    <input type="submit" value="Crear cliente" class="btn btn-primary">
                </div>

                <div class="col">
                    <input type="submit"  formaction="/webapp-banco/client/update"   formmethod="post"  value="Actualizar cliente" class="btn btn-primary">
                </div>

                <div class="col">
                    <input type="submit"  formaction="/webapp-banco/clients"   formmethod="get"  value="Consultar clientes" class="btn btn-primary">
                </div>

                <div class="col">
                    <input type="submit"  formaction="/webapp-banco/client/delete"   formmethod="post"  value="Eliminar cliente" class="btn btn-danger">
                </div>
    
            </div>

        </div>      



    </form>
</div>
</div>

</body>
</html>