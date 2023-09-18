 
package sys.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import sys.dao.EmpleadoDAO;
import sys.impl.EmpleadoDAOImpl;
import sys.modelo.Empleado;

/**
 *
 * @author Alex
 */
@ManagedBean
@Named(value = "empleadoBean")
@ViewScoped
public class EmpleadoBean {

    private Empleado empleado = null;
    private List<Empleado> empleados=null;
    
    public EmpleadoBean() {
        
    }
    
    public List<Empleado> getEmpleados() {
        EmpleadoDAO datos = new EmpleadoDAOImpl();
        this.empleados= datos.select();
        return empleados;
    }
    public void prepareEmpleado(){
        empleado = new Empleado();
    }
    public void insertEmpleado(){
        EmpleadoDAO datos = new EmpleadoDAOImpl();
        datos.insert(empleado);
    }
    public void updateEmpleado(){
        EmpleadoDAO datos = new EmpleadoDAOImpl();
        datos.update(empleado);
        this.empleado=new Empleado();
        
    }
    public void deleteEmpleado(){
        EmpleadoDAO datos = new EmpleadoDAOImpl();
        datos.delete(empleado);
        this.empleado=new Empleado();
    }
    

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
    
}
