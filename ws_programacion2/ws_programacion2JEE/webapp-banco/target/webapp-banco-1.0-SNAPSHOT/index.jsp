<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%Map<String,String> errores = (Map<String,String>)request.getAttribute("errores");%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario de transacciones</title>
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet">

</head>
<body>
<h1>Aplicación Web del Banco</h1>
<h2>Formulario de transacciones bancarias</h2>
<div class="px-5">
<div class="container-transacciones">
    <form action="/webapp-banco/transaccion" method="post">


        <div class="container-form container-data-transaccion">
         <h3>1. Información basica de la transacción</h3>
            <div class="row mb-3">
                <label for="codigoTransaccion" class="col-form-label col-sm-2">Codigo de la transaccion:</label>
                <div class="col-sm-4"><input type="text" name="codigoTransaccion" id="codigoTransaccion" class="form-control" value="${param.codigoTransaccion}"></div>

                <%
                if(errores != null && errores.containsKey("codigoTransaccion")){
                    out.println("<div class='row mb-3 alert alert-danger col-sm-4' style='color:red;'>"+errores.get("codigoTransaccion")+"</div>");
                }
                %>
            </div>
            <div class="row mb-3">
                <label for="fecha" class="col-form-label col-sm-2">Fecha:</label>
                <div class="col-sm-4"><input type="text" name="fecha" id="fecha" class="form-control" value="${param.fecha}"></div>
            </div>
            <div class="row mb-3">
                <label for="hora" class="col-form-label col-sm-2">Hora:</label>
                <div class="col-sm-4"><input type="text" name="hora" id="hora" class="form-control" value="${param.hora}"></div>
            </div>
            <div class="row mb-3">
                <label for="valor" class="col-form-label col-sm-2">Valor:</label>
                <div class="col-sm-4"><input type="text" name="valor" id="valor" class="form-control" value="${param.valor}"></div>
            </div>
            <div class="row mb-3">
                <label class="col-form-label col-sm-2">Tipo de transacción:</label>
                <div class="form-check col-sm-2">
                    <input type="radio" name="tipoTransaccion" value="retiro" class="form-check-input" ${param.tipoTransaccion.equals("retiro")? "checked": ""}>
                    <label class="form-check-label">Retiro</label>
                </div>
                <div class="form-check col-sm-2">
                    <input type="radio" name="tipoTransaccion" value="deposito" class="form-check-input" ${param.tipoTransaccion.equals("deposito")? "checked": ""}>
                    <label class="form-check-label">Deposito</label>
                </div>
                <%
                if(errores != null && errores.containsKey("tipoTransaccion")){
                    out.println("<div class='row mb-3 alert alert-danger col-sm-4' style='color:red;'>"+errores.get("tipoTransaccion")+"</div>");
                }
                %>
            </div>
        </div>


        <div class="container-form container-data-cliente-cuenta">
            <h3>2. Información  del cliente y la cuenta</h3>
            <label for="cliente" class="col-form-label col-sm-2">Cliente</label>
            <div class="col-sm-4">
                <select name="cliente" id="cliente" class="form-select">
                    <option value="" selected>--seleccione cliente--</option>
                    <option value="juan-1094" ${param.cliente.equals("juan-1094")? "selected":""}>Juan manuel</option>
                    <option value="ana-1095"  ${param.cliente.equals("ana-1095")? "selected": ""}>Ana maria</option>
                    <option value="carlos-1096" ${param.cliente.equals("carlos-1096")? "selected": ""}>Carlos alberto</option>
                </select>
              <%
                if(errores != null && errores.containsKey("cliente")){
                    out.println("<div class='row mb-3 alert alert-danger col-sm-4' style='color:red;'>"+errores.get("cliente")+"</div>");
                }
                %>
            </div>
            <div class="row mb-3">
                <label class="col-form-label col-sm-2">Tipo de cuenta:</label>
                <div class="form-check col-sm-2">
                    <input type="radio" name="tipoCuenta" value="ahorro" class="form-check-input" ${param.tipoCuenta.equals("ahorro")? "checked": ""} >
                    <label>Cta. Ahorros</label>
                </div>
                <div class="form-check col-sm-2">
                    <input type="radio" name="tipoCuenta" value="corriente" class="form-check-input" ${param.tipoCuenta.equals("corriente")? "checked": ""}>
                    <label>Cta. Corriente</label>
                </div>
                <div class="form-check col-sm-2">
                    <input type="radio" name="tipoCuenta" value="nomina" class="form-check-input" ${param.tipoCuenta.equals("nomina")? "checked": ""}>
                    <label>Cta. Nomina</label>
                </div>
            </div>
            <div class="row mb-3">
                <label for="cuenta" class="col-form-label col-sm-2">Número de la cuenta:</label>
                <div class="col-sm-4"><input type="text" name="cuenta" id="cuenta" class="form-control" value="${param.cuenta}"></div>
            </div>
        </div>

        <div class="container-form container-data-empleado">
           <h3>3. Información  del empleado</h3>
            <label for="empleado" class="col-form-label col-sm-2">Empleado</label>
            <div class="col-sm-4">
                <select name="empleado" id="empleado" class="form-select">
                    <option value="" selected>--seleccione empleado--</option>
                    <option value="fabian-1096" ${param.empleado.equals("fabian-1096")?"selected": ""}>Fabian andres</option>
                    <option value="ana-1097"    ${param.empleado.equals("ana-1097")?"selected": ""}>Ana maria</option>
                    <option value="carlos-1098" ${param.empleado.equals("carlos-1098")?"selected": ""}>Carlos alberto</option>
                </select>
            </div>
            <div class="row mb-3">
                <label class="col-form-label col-sm-2">Roles</label>
                <div class="form-check col-sm-2" >
                    <input type="checkbox" name="roles" value="gerente" class="form-check-input" ${paramValues.roles.stream().anyMatch(v->v.equals("gerente")).get()?"checked":""}>
                    <label class="form-check-label">Gerente</label>
                </div>
                <div class="form-check col-sm-2">
                    <input type="checkbox" name="roles" value="cajero" class="form-check-input" ${paramValues.roles.stream().anyMatch(v->v.equals("cajero")).get()?"checked":""}>
                    <label class="form-check-label">Cajero</label>
                </div>
                <div class="form-check col-sm-2">
                    <input type="checkbox" name="roles" value="auxiliarCajero" class="form-check-input" ${paramValues.roles.stream().anyMatch(v->v.equals("auxiliarCajero")).get()?"checked":""}>
                    <label class="form-check-label">Auxiliar de caja</label>
                </div>
            </div>
        </div>

        <div class="row mb-3">
            <div>
                <input type="submit" value="Registrar transacción" class="btn btn-primary">
            </div>

        </div>

    </form>
</div>
</div>

</body>
</html>