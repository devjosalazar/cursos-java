package co.edu.cue.webapp.banco.controller;

import co.edu.cue.webapp.banco.entity.Cliente;
import co.edu.cue.webapp.banco.exceptions.ClienteException;
import co.edu.cue.webapp.banco.util.DateUtil;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;


public class BaseServlet extends HttpServlet {

    public void responseView(HttpServletRequest req, HttpServletResponse resp, List<Cliente> listaClientes){

        try (PrintWriter out = resp.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("   <head>");
            out.println("       <meta  chartset=\"UTF-8\">");
            out.println("       <title>Parametros Get de la Url</title>");
            out.println("   </head>");
            out.println("   <body>");
            out.println("       <h1>Lista de cientes</h1>");

            for (Cliente cliente:listaClientes) {
                out.println("       <h2>Cliente: "+cliente.getNombre() +" "+cliente.getApellido()+"</h2>");
            }
            out.println("   </body>");
            out.println("</html>");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void responseView(HttpServletRequest req, HttpServletResponse resp, Cliente cliente){

        try (PrintWriter out = resp.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("   <head>");
            out.println("       <meta  chartset=\"UTF-8\">");
            out.println("       <title>Parametros Get de la Url</title>");
            out.println("   </head>");
            out.println("   <body>");
            out.println("       <h1>Transaccion realizada con éxito</h1>");
            out.println("       <h2>Cliente creado: "+cliente.getNombre() +" "+cliente.getApellido()+"</h2>");
            out.println("   </body>");
            out.println("</html>");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public Cliente getDataClientRequest(Cliente cliente, HttpServletRequest req) throws  Exception, ClienteException {
        cliente = new Cliente();
        cliente.setNombre(req.getParameter("nombreCliente"));
        cliente.setApellido(req.getParameter("apellidoCliente"));
        cliente.setCedula(req.getParameter("cedulaCliente"));
        Date fechaNacimientoDate = DateUtil.formatearFecha(req.getParameter("fechaNacimiento"));
        cliente.setFechaNacimiento(fechaNacimientoDate);
        cliente.setEdad(Integer.parseInt(req.getParameter("edadCliente")));
        return  cliente;
    }


}
