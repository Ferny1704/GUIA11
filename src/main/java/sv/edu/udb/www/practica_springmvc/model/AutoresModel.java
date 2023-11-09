package sv.edu.udb.www.practica_springmvc.model;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import sv.edu.udb.www.practica_springmvc.entities.AutoresEntity;
import java.util.List;
public class AutoresModel {
    SessionFactory factory = HibernateUtil.getSessionFactory();

    public List<AutoresEntity> listarAutores() {
        Session ses = factory.openSession();
        try {
            Query consulta = ses.createQuery("SELECT a FROM AutoresEntity a");
            List<AutoresEntity> lista = consulta.list();
            ses.close();

            return lista;
        } catch (Exception e) {
            ses.close();
            return null;
        }
    }
}