package co.edu.cue.webapp.banco;

import co.edu.cue.webapp.banco.entity.Cliente;
import co.edu.cue.webapp.banco.exceptions.ClienteException;
import co.edu.cue.webapp.banco.services.IClienteService;
import co.edu.cue.webapp.banco.services.ClienteServiceImpl;
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

        int idCliente = 1;

        Cliente cliente = setDatosCliente();

        listarClientes(clienteService);
        obtenerPorId(clienteService,idCliente);

        listarClientes(clienteService);
        insertarCliente(clienteService, cliente);

        listarClientes(clienteService);
        editarCliente(clienteService, idCliente);
        eliminarCliente(clienteService,idCliente);
        em.close();
    }

    private static void listarClientes(IClienteService clienteService) {
        System.out.println("========== Listar clientes ==========");
        List<Cliente> listaClientes = clienteService.listar();
        imprimirListaClientes(listaClientes);
    }

    private static void obtenerPorId(IClienteService clienteService, int idCliente) {
        System.out.println("========== Obtener por ID ==========");
        Cliente cliente = clienteService.obtenerPorId(1);
        System.out.println(cliente.toString());
    }

    private static void insertarCliente(IClienteService clienteService, Cliente cliente) {
        System.out.println("========== Insertar Cliente ==========");
        clienteService.guardar(cliente);
        System.out.println("Cliente guardado con éxito");
    }

    private static void editarCliente(IClienteService clienteService, int idCliente ) {
        System.out.println("========== Editar Cliente ==========");

        Cliente cliente = null;
        int id = Integer.valueOf(JOptionPane.showInputDialog("Ingrese el id del cliente a modificar:"));
        cliente = clienteService.obtenerPorId(idCliente);
        updateDatosClientes(cliente);
        clienteService.guardar(cliente);
    }

    private static void eliminarCliente(IClienteService clienteService, int idCliente) {
        System.out.println("========== Eliminar Cliente ==========");

        Cliente cliente = null;
        cliente = clienteService.obtenerPorId(idCliente);
        clienteService.eliminar(cliente.getIdCliente());

    }

    private static void imprimirListaClientes(List<Cliente> listaClientes) {
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente.toString());
        }
    }


    private static Cliente setDatosCliente() {
        Cliente cliente = new Cliente();
        String nombre = "Juan alberto";
        String apellido = "Arias perdomo";
        String cedula = "890613";
        String fechaNacimiento = "15-06-1995";
        int edad = 25;
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setCedula(cedula);
        Date fechaNacimientoDate = DateUtil.formatearFecha(fechaNacimiento);
        cliente.setFechaNacimiento(fechaNacimientoDate);
        cliente.setEdad(edad);
        return cliente;
    }


    private static void updateDatosClientes(Cliente cliente) {

        String nombre = "Juan alberto";
        String apellido = "Arias perdomo";
        String cedula = "10949058888";
        String fechaNacimiento = "11-06-1990";
        int edad = 27;

        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setCedula(cedula);
        Date fechaNacimientoDate = DateUtil.formatearFecha(fechaNacimiento);
        cliente.setFechaNacimiento(fechaNacimientoDate);
        cliente.setEdad(edad);
    }

}
