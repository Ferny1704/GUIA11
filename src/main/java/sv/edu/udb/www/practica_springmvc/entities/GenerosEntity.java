package sv.edu.udb.www.practica_springmvc.entities;

import javax.persistence.*;

@Entity
@Table(name = "generos", schema = "inventario_libros", catalog = "")
public class GenerosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_genero", nullable = false)
    private int idGenero;
    @Basic
    @Column(name = "nombre_genero", nullable = false, length = 40)
    private String nombreGenero;
    @Basic
    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
