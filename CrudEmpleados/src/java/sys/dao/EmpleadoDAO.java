 
package sys.dao;

import java.util.List;
import sys.modelo.Empleado;

/**
 *
 * @author Alex
 */
public interface EmpleadoDAO {
    public List<Empleado> select();
    public void insert(Empleado empleado);
    public void update(Empleado empleado);
    public void delete(Empleado empleado);
}
