package co.edu.cue.webapp.banco;

import co.edu.cue.webapp.banco.entity.Cliente;
import co.edu.cue.webapp.banco.util.DateUtil;
import co.edu.cue.webapp.banco.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import javax.swing.*;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        //obtenerClientes();
        //obtenerClientePorId();
        //obtenerClientesWhere();
        //obtenerClientesWhereV2();

        //CRUD
        crearCliente();
        editarCliente();
        eliminarCliente();
    }

    private static void obtenerClientes() {

        EntityManager em = JpaUtil.getEntityManager();
        List<Cliente> listaClientes = em.createQuery("select c from Cliente c", Cliente.class).getResultList();

        imprimirListaClientes(listaClientes);
        em.close();
    }

    private static void obtenerClientePorId() {
        EntityManager em = JpaUtil.getEntityManager();
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el Id");
        int id = s.nextInt();

        Cliente cliente = em.find(Cliente.class, id);
        System.out.println("Cliente obtenido = "+ cliente.toString());
        em.close();


    }

    private static void obtenerClientesWhere() {

        EntityManager em = JpaUtil.getEntityManager();
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el Id");
        int id = s.nextInt();

        Query query = em.createQuery("select c from Cliente c where c.idCliente="+id,Cliente.class);

        List<Cliente> listaClientes = query.getResultList();
        imprimirListaClientes(listaClientes);
        em.close();
    }

    private static void obtenerClientesWhereV2() {

        EntityManager em = JpaUtil.getEntityManager();
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el Id");
        int id = s.nextInt();

        Query query = em.createQuery("select c from Cliente c where c.idCliente=?1", Cliente.class);
        query.setParameter(1,id);

        List<Cliente> listaClientes = query.getResultList();
        imprimirListaClientes(listaClientes);
        em.close();
    }

    private static void crearCliente() {

        EntityManager em = JpaUtil.getEntityManager();
        try {

            String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
            String apellido = JOptionPane.showInputDialog("Ingrese el apellido:");
            String cedula = JOptionPane.showInputDialog("Ingrese la cedula:");
            String fechaNacimiento = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento:");
            int edad = Integer.valueOf(JOptionPane.showInputDialog("Ingrese la edad:"));

            em.getTransaction().begin();

            Cliente cliente = new Cliente();
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setCedula(cedula);

            Date fechaNacimientoDate = DateUtil.formatearFecha(fechaNacimiento);
            cliente.setFechaNacimiento(fechaNacimientoDate);
            cliente.setEdad(edad);

            em.persist(cliente);
            em.getTransaction().commit();

            System.out.println("el id del cliente registrado es " + cliente.getIdCliente());
            cliente = em.find(Cliente.class, cliente.getIdCliente());
            System.out.println(cliente);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    private static void eliminarCliente() {

        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el id del cliente a eliminar:");
        int id = s.nextInt();
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Cliente cliente = em.find(Cliente.class, id);
            em.getTransaction().begin();
            em.remove(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    private static void editarCliente() {

        EntityManager em = JpaUtil.getEntityManager();
        try {

            int id = Integer.valueOf(JOptionPane.showInputDialog("Ingrese el id del cliente a modificar:"));
            Cliente cliente = em.find(Cliente.class, id);

            String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
            String apellido = JOptionPane.showInputDialog("Ingrese el apellido:");
            String cedula = JOptionPane.showInputDialog("Ingrese la cedula:");
            String fechaNacimiento = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento:");
            int edad = Integer.valueOf(JOptionPane.showInputDialog("Ingrese la edad:"));

            em.getTransaction().begin();
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setCedula(cedula);
            Date fechaNacimientoDate = DateUtil.formatearFecha(fechaNacimiento);

            cliente.setFechaNacimiento(fechaNacimientoDate);
            cliente.setEdad(edad);

            em.merge(cliente);
            em.getTransaction().commit();

            System.out.println(cliente);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

    }

    private static void imprimirListaClientes(List<Cliente> listaClientes) {
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente.toString());
        }
    }


}
