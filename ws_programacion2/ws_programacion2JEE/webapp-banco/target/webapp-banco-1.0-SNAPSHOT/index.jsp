<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Banco-Formulario de transacciones</title>
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
                <h3>Información basica de la transacción</h3>
                <div class="row mb-3">
                    <label for="codigoTransacion" class="col-form-label col-sm-2">Codigo de la transacción</label>
                    <div class="col-sm-4"><input type="text" name="codigoTransacion" id="codigoTransacion"></div>
                </div>
                <div class="row mb-3">
                    <label for="fecha" class="col-form-label col-sm-2">Fecha</label>
                    <div class="col-sm-4"><input type="text" name="fecha" id="fecha"></div>
                </div>
                <div class="row mb-3">
                    <label for="hora" class="col-form-label col-sm-2">Hora</label>
                    <div class="col-sm-4"><input type="text" name="hora" id="hora"></div>
                </div>
                <div class="row mb-3">
                    <label for="valor" class="col-form-label col-sm-2">Valor</label>
                    <div class="col-sm-4"><input type="text" name="valor" id="valor"></div>
                </div>
                <div class="row mb-3">
                    <label class="col-form-label col-sm-2">Tipo de transacción</label>
                    <div>
                        <input type="radio" name="tipoTransaccion" value="retiro" class="form-check-input">
                        <label class="form-check-label">Retiro</label>
                    </div>
                    <div>
                        <input type="radio" name="tipoTransaccion" value="deposito" class="form-check-input">
                        <label class="form-check-label">Deposito</label>
                    </div>
                </div>
            </div>

            <div class="container-form container-data-cliente-cuenta">
                <h3>Información del cliente y la cuenta</h3>

                <label for="cliente">Cliente</label>
                <div>
                    <select name="cliente" id="cliente">
                        <option value="" selected>--seleccione el cliente--</option>
                        <option value="juan-1094">Juan manuel</option>
                        <option value="ana-1095">Ana maria</option>
                        <option value="carlos-1096">Carlos bermudez</option>
                    </select>
                </div>
                <div>
                    <label>Tipo de cuenta</label>
                    <div>
                        <input type="radio" name="tipoCuenta" value="ahorro">
                        <label>Cta. Ahorros</label>
                    </div>
                    <div>
                        <input type="radio" name="tipoCuenta" value="corriente">
                        <label>Cta. Corriente</label>
                    </div>
                    <div>
                        <input type="radio" name="tipoCuenta" value="nomina">
                        <label>Cta. Nomina</label>
                    </div>
                </div>
                <div>
                    <label for="cuenta">Número de la cuenta</label>
                    <div><input type="text" name="cuenta" id="cuenta"></div>
                </div>

            </div>

            <div class="container-form container-data-empleado">
                <h3>Información del empleado</h3>

                <label for="empleado">Empleado</label>
                <div>
                    <select name="empleado" id="empleado">
                        <option value="" selected>--seleccione el empleado--</option>
                        <option value="maria-1097">Maria arias</option>
                        <option value="andres-1098">Andres lopez</option>
                        <option value="fabian-1099">Fabian arias</option>
                    </select>
                </div>
                <div>
                    <label>Roles</label>
                    <div>
                        <input type="checkbox" name="roles" value="gerente">
                        <label>Gerente</label>
                    </div>
                    <div>
                        <input type="checkbox" name="roles" value="cajero">
                        <label>Cajero</label>
                    </div>
                    <div>
                        <input type="checkbox" name="roles" value="auxiliarCajero">
                        <label>Auxiliar cajero</label>
                    </div>
                </div>
            </div>

            <div>
                <div>
                    <input type="submit" value="Registrar transacción" class="btn btn-primary">
                </div>
            </div>
        </form>

    </div>

</div>


</body>
</html>