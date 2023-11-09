package sv.edu.udb.www.practica_springmvc.model;
import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.edu.udb.www.practica_springmvc.entities.LibrosEntity;
public class LibrosModel {
    SessionFactory factory = HibernateUtil.getSessionFactory();

    public int insertarLibro(LibrosEntity libro) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();
            ses.save(libro);
            tran.commit();
            ses.close();
            return 1;
        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }

    public int modificarLibro(LibrosEntity libro) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();
            ses.update(libro);
            tran.commit();
            ses.close();
            return 1;
        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }

    public int eliminarLibro(String codigo) {
        Session ses = factory.openSession();
        try {
            LibrosEntity libro = (LibrosEntity) ses.get(LibrosEntity.class, codigo);
            if (libro != null) {
                Transaction tran = ses.beginTransaction();
                ses.delete(libro);
                tran.commit();
                ses.close();
                return 1;
            }
            ses.close();
            return 0;
        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }

    public LibrosEntity obtenerLibro(String codigo) {
        Session ses = factory.openSession();
        try {
            LibrosEntity libro = (LibrosEntity) ses.get(LibrosEntity.class, codigo);
            ses.close();
            return libro;
        } catch (Exception e) {
            ses.close();
            return null;
        }
    }

    public List<LibrosEntity> listarLibros() {
        Session ses = factory.openSession();
        try {
            Query consulta = ses.createQuery("SELECT l FROM LibrosEntity l");
            List<LibrosEntity> lista = consulta.list();
            ses.close();
            return lista;
        } catch (Exception e) {
            ses.close();
            return null;
        }
    }
}