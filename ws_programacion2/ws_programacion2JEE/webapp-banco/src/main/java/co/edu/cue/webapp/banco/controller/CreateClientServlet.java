package co.edu.cue.webapp.banco.controller;


import co.edu.cue.webapp.banco.entity.Cliente;
import co.edu.cue.webapp.banco.services.ClienteServiceImpl;
import co.edu.cue.webapp.banco.services.IClienteService;
import co.edu.cue.webapp.banco.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/client/create")
public class CreateClientServlet extends BaseServlet{

    EntityManager em;
    IClienteService clienteService;

    public CreateClientServlet() {
        this.em = JpaUtil.getEntityManager();
        this.clienteService = new ClienteServiceImpl(em);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cliente cliente = null;
        resp.setContentType("text/html");

        try {
            cliente = getDataClientRequest(cliente,req);
            clienteService.createCliente(cliente);
            responseView(req,resp,cliente);
        } catch (Exception e) {
            resp.sendError(501,"Información de error"+e.getMessage());
        }
    }
}
