package sv.edu.udb.www.practica_springmvc.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "libros", schema = "inventario_libros", catalog = "")
public class LibrosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codigo_libro", nullable = false, length = 9)
    private String codigoLibro;
    @Basic
    @Column(name = "nombre_libro", nullable = false, length = 50)
    private String nombreLibro;
    @Basic
    @Column(name = "existencias", nullable = false)
    private int existencias;
    @Basic
    @Column(name = "precio", nullable = false, precision = 2)
    private BigDecimal precio;
    @Basic
    @Column(name = "codigo_autor", nullable = false, length = 6)
    private String codigoAutor;
    @Basic
    @Column(name = "codigo_editorial", nullable = false, length = 6)
    private String codigoEditorial;
    @Basic
    @Column(name = "id_genero", nullable = false)
    private int idGenero;
    @Basic
    @Column(name = "descripcion", nullable = true, length = -1)
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "codigo_autor", referencedColumnName = "codigo_autor", nullable = false)
    private AutoresEntity autoresByCodigoAutor;
    @ManyToOne
    @JoinColumn(name = "codigo_editorial", referencedColumnName = "codigo_editorial", nullable = false)
    private EditorialesEntity editorialesByCodigoEditorial;
    @ManyToOne
    @JoinColumn(name = "id_genero", referencedColumnName = "id_genero", nullable = false)
    private GenerosEntity generosByIdGenero;

    public String getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(String codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getCodigoAutor() {
        return codigoAutor;
    }

    public void setCodigoAutor(String codigoAutor) {
        this.codigoAutor = codigoAutor;
    }

    public String getCodigoEditorial() {
        return codigoEditorial;
    }

    public void setCodigoEditorial(String codigoEditorial) {
        this.codigoEditorial = codigoEditorial;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public AutoresEntity getAutoresByCodigoAutor() {
        return autoresByCodigoAutor;
    }

    public void setAutoresByCodigoAutor(AutoresEntity autoresByCodigoAutor) {
        this.autoresByCodigoAutor = autoresByCodigoAutor;
    }

    public EditorialesEntity getEditorialesByCodigoEditorial() {
        return editorialesByCodigoEditorial;
    }

    public void setEditorialesByCodigoEditorial(EditorialesEntity editorialesByCodigoEditorial) {
        this.editorialesByCodigoEditorial = editorialesByCodigoEditorial;
    }

    public GenerosEntity getGenerosByIdGenero() {
        return generosByIdGenero;
    }

    public void setGenerosByIdGenero(GenerosEntity generosByIdGenero) {
        this.generosByIdGenero = generosByIdGenero;
    }
}
