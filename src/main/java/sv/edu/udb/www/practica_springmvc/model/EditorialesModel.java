package sv.edu.udb.www.practica_springmvc.model;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.edu.udb.www.practica_springmvc.entities.EditorialesEntity;


public class EditorialesModel {
    SessionFactory factory = HibernateUtil.getSessionFactory();
    public int insertarEditorial(EditorialesEntity editorial) {

        Session ses = factory.openSession();
    try {
        Transaction tran = ses.beginTransaction();
        ses.save(editorial);
        tran.commit();
        ses.close();
        return 1;
    } catch (Exception e) {
        ses.close();
        return 0;
    }
}
    public List<EditorialesEntity> listarEditoriales(){
        SessionFactory sesFac = HibernateUtil.getSessionFactory();
        Session ses = sesFac.openSession();
        ArrayList<EditorialesEntity> listaEditoriales = new ArrayList<EditorialesEntity>();
        String sql = "from EditorialesEntity ";
        listaEditoriales = (ArrayList<EditorialesEntity>)
                ses.createQuery(sql).list();
        return listaEditoriales;
    }
    public EditorialesEntity obtenerEditorial(String codigo) {
        Session ses= factory.openSession();
        try{
            EditorialesEntity editorial= (EditorialesEntity) ses.get(EditorialesEntity.class,
                    codigo);
        ses.close();
        return editorial;
        }
        catch(Exception e){
            ses.close();
            return null;
        }
    }
    public int modificarEditorial(EditorialesEntity editorial) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();
            ses.update(editorial);
            tran.commit();
            ses.close();
            return 1;
        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }
    public int eliminarEditorial(String id){
        int filasAfectadas=0;
        Session ses= factory.openSession();
        try{
            EditorialesEntity editorial= (EditorialesEntity) ses.get(EditorialesEntity.class,
                    id);
            if(editorial!=null){
                Transaction tran= ses.beginTransaction();
                ses.delete(editorial);
                tran.commit();
                filasAfectadas=1;
            }
            ses.close();
            return filasAfectadas;
        }
        catch(Exception e){
            ses.close();
            return filasAfectadas;
        }
    }

}
