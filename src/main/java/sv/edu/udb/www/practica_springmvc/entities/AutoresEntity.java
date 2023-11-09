package sv.edu.udb.www.practica_springmvc.entities;

import javax.persistence.*;

@Entity
@Table(name = "autores", schema = "inventario_libros", catalog = "")
public class AutoresEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codigo_autor", nullable = false, length = 6)
    private String codigoAutor;
    @Basic
    @Column(name = "nombre_autor", nullable = false, length = 50)
    private String nombreAutor;
    @Basic
    @Column(name = "nacionalidad", nullable = false, length = 50)
    private String nacionalidad;

    public String getCodigoAutor() {
        return codigoAutor;
    }

    public void setCodigoAutor(String codigoAutor) {
        this.codigoAutor = codigoAutor;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
