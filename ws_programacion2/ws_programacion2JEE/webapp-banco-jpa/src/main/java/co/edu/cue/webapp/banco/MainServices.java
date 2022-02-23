package co.edu.cue.webapp.banco;

import co.edu.cue.webapp.banco.entity.Cliente;
import co.edu.cue.webapp.banco.entity.Cuenta;
import co.edu.cue.webapp.banco.services.ClienteServiceImpl;
import co.edu.cue.webapp.banco.services.IClienteService;
import co.edu.cue.webapp.banco.util.DateUtil;
import co.edu.cue.webapp.banco.util.JpaUtil;
import jakarta.persistence.EntityManager;

import javax.swing.*;
import java.util.Date;
import java.util.List;

public class MainServices {

    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();

        IClienteService clienteService = new ClienteServiceImpl(em);


        int idCliente = 4;
        Cliente cliente = setDataCliente();

        listarClientes(clienteService);
        crearCliente(clienteService,cliente);

        listarClientes(clienteService);

        //editarCliente(clienteService,idCliente);
        //eliminarCliente(clienteService,idCliente);


        Cuenta cuenta = new Cuenta();

        cuenta.setCliente(cliente);

        em.close();
    }

    private static void crearCliente(IClienteService clienteService, Cliente cliente) {
        clienteService.guardar(cliente);
    }

    private static void listarClientes(IClienteService clienteService) {
        List<Cliente> listaCientes = clienteService.listar();
        imprimirListaClientes(listaCientes);
    }

    private static Cliente setDataCliente() {

        Cliente cliente = null;
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido:");
        String cedula = JOptionPane.showInputDialog("Ingrese la cedula:");
        String fechaNacimiento = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento:");
        int edad = Integer.valueOf(JOptionPane.showInputDialog("Ingrese la edad:"));

        cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setCedula(cedula);

        Date fechaNacimientoDate = DateUtil.formatearFecha(fechaNacimiento);
        cliente.setFechaNacimiento(fechaNacimientoDate);
        cliente.setEdad(edad);

        return cliente;
    }


    private static void imprimirListaClientes(List<Cliente> listaClientes) {
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente.toString());
        }
    }
}
