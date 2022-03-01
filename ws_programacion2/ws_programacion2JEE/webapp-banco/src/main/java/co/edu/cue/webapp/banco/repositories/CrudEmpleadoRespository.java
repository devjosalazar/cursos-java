package co.edu.cue.webapp.banco.repositories;

import co.edu.cue.webapp.banco.entity.Empleado;

import java.util.List;

public class CrudEmpleadoRespository implements CrudRepository<Empleado>{


    @Override
    public List<Empleado> listar() {
        return null;
    }

    @Override
    public Empleado obtenerPorId(int id) {
        return null;
    }

    @Override
    public void guardar(Empleado empleado) {

    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public void create(Empleado empleado) {

    }
}
