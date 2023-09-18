 
package sys.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sys.dao.EmpleadoDAO;
import sys.modelo.Empleado;
import sys.util.HibernateUtil;

/**
 *
 * @author Alex
 */
public class EmpleadoDAOImpl implements EmpleadoDAO{

    @Override
    public List<Empleado> select() {
        List<Empleado> empleados = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        String hql = "FROM Empleado";
        try {
            empleados = session.createQuery(hql).list();
            trans.commit();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            trans.rollback();
        }
        return empleados;
        
    }

    @Override
    public void insert(Empleado empleado) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(empleado);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Override
    public void update(Empleado empleado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Empleado empleado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
