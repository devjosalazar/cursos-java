package co.edu.cue.webapp.banco.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/transaccion")
public class TransaccionServlet extends HttpServlet {

    String codigoTransaccion = "";
    String fecha = "";
    String hora = "";
    Double valor = 0.0;
    String tipoTransaccion = "";
    String cliente = "";
    String tipoCuenta = "";
    String cuenta = "";
    String empleado = "";
    String[] listaRoles = null;
    Map<String,String> listaErrores = new HashMap<>();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        getDataRequest(req);
        validarParametros();


        if(listaErrores.isEmpty()){
            try( PrintWriter out = resp.getWriter()) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("   <head>");
                out.println("       <meta  chartset=\"UTF-8\">");
                out.println("       <title>Resultados de la transacción</title>");
                out.println("   </head>");
                out.println("   <body>");
                out.println("       <h1>Información de la transacción realizada</h1>");
                out.println("         <ul>");
                out.println("   <li>Codigo de la transacción " + codigoTransaccion + "</li>");
                out.println("   <li>Fecha: " + fecha + "</li>");
                out.println("   <li>Hora: " + hora + "</li>");
                out.println("   <li>Valor: " + valor + "</li>");
                out.println("   <li>Tipo de transacción: " + tipoTransaccion + "</li>");
                out.println("   <li>Cliente: " + cliente + "</li>");
                out.println("   <li>Tipo de cuenta: " + tipoCuenta + "</li>");
                out.println("   <li>Cuenta: " + cuenta + "</li>");
                out.println("   <li>Empleado: " + empleado +"</li>");
                out.println("   <li>Roles: <ul>");
     
                for (String rol: listaRoles) {
                    out.println("            <li>"+ rol+"</li>");
                }
                out.println("           </ul></li>");
                out.println("         </ul>");
                out.println("   </body>");
                out.println("</html>");
            }
        }else{
            req.setAttribute("errores",listaErrores);
            getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
        }

    }

    private void getDataRequest(HttpServletRequest req) {
        this.codigoTransaccion = req.getParameter("codigoTransacion");
        this.fecha = req.getParameter("fecha");
        this.hora = req.getParameter("hora");
        this.valor = Double.parseDouble(req.getParameter("valor"));
        this.tipoTransaccion = req.getParameter("tipoTransaccion");
        this.cliente = req.getParameter("cliente");
        this.tipoCuenta = req.getParameter("tipoCuenta");
        this.cuenta = req.getParameter("cuenta");
        this.empleado = req.getParameter("empleado");
        this.listaRoles = req.getParameterValues("roles");
    }

    private void validarParametros() {

        if (codigoTransaccion == null || codigoTransaccion.isBlank()) {
            listaErrores.put("codigoTransaccion","Codigo de la transacción no ingresado");
        }

        if (fecha == null || fecha.isBlank()) {
            listaErrores.put("fecha","Fecha de la transacción no ingresada");
        }

        if (hora == null || hora.isBlank()) {
            listaErrores.put("hora","Hora de la transacción no ingresada");
        }

        if (valor == null || valor == 0.0) {
            listaErrores.put("valor","Valor de la transacción no ingresado");
        }

        if (tipoTransaccion == null) {
            listaErrores.put("tipoTransaccion","Tipo de transacción requerido");
        }

        if (cliente == null || cliente.equals("") || cliente.equals("--seleccione cliente--")) {
            listaErrores.put("cliente","Cliente asociado a la transacción es requerido");
        }

        if (tipoCuenta == null) {
            listaErrores.put("tipoCuenta","Tipo de cuenta requerido");
        }

        if (cuenta == null || cuenta.isBlank()) {
            listaErrores.put("cuenta","Numero de cuenta no ingresado");
        }

        if (empleado == null || empleado.equals("") || empleado.equals("--seleccione empleado--")) {
            listaErrores.put("empleado","Empleado asociado a la transacción es requerido");
        }

        if (listaRoles == null || listaRoles.length == 0) {
            listaErrores.put("roles","Debe seleccionar al menos un rol!");
        }


    }
}
