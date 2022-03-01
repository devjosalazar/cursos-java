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
import java.util.List;

@WebServlet("/clients")
public class GetClientsServlet extends  BaseServlet{

    EntityManager em;
    IClienteService clienteService;

    public GetClientsServlet() {
        this.em = JpaUtil.getEntityManager();
        this.clienteService = new ClienteServiceImpl(em);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        List<Cliente> listaClientes = clienteService.listar();


        if(!listaClientes.isEmpty()){
            responseView(req,resp,listaClientes);
        }else{
            resp.sendError(501,"No existe información de clientes");
        }
    }
}
