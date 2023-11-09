package sv.edu.udb.www.practica_springmvc.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sv.edu.udb.www.practica_springmvc.entities.EditorialesEntity;
import sv.edu.udb.www.practica_springmvc.model.LibrosModel;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import sv.edu.udb.www.practica_springmvc.model.AutoresModel;
import sv.edu.udb.www.practica_springmvc.model.EditorialesModel;
import sv.edu.udb.www.practica_springmvc.model.GenerosModel;
import org.springframework.ui.Model;
import sv.edu.udb.www.practica_springmvc.entities.LibrosEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sv.edu.udb.www.practica_springmvc.validations.EditorialValidator;
import sv.edu.udb.www.practica_springmvc.validations.LibroValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("libros")
public class LibrosController {
    LibrosModel librosModel = new LibrosModel();
    EditorialesModel editorialesModel = new EditorialesModel();
    GenerosModel generosModel = new GenerosModel();
    AutoresModel autoresModel = new AutoresModel();

    @RequestMapping(value = "list", method = GET)
    public String listarLibros(ModelMap modelMap){
        //Pasando la lista de editoriales hacia la vista
        modelMap.addAttribute("listaLibros", librosModel.listarLibros());
        //Redireccionando a la página de libros.jsp
        return "libros/listar";
    }

    @RequestMapping(value = "create", method = GET)
    public String nuevoLibro(Model model){
        //Se le pasa a la vista el objeto que debe llenarse desde el formuario
        model.addAttribute("libro", new LibrosEntity());
        //Se le pasa a la vista las listas de autores, géneros y editoriales
        //Para llenar los campos select
        model.addAttribute("listaAutores",autoresModel.listarAutores());
        model.addAttribute("listaGeneros",generosModel.listarGeneros());
        model.addAttribute("listaEditoriales",editorialesModel.listarEditoriales());
        return "libros/nuevo";
    }
    @RequestMapping(value = "create", method = POST)
    public String insertarLibro(@Valid @ModelAttribute("libro") LibrosEntity libro, BindingResult result,
                                Model model, RedirectAttributes atributos) {
        LibroValidator libroValidator = new LibroValidator();
        libroValidator.validate(libro, result);

        if (result.hasErrors()){
            model.addAttribute("listaAutores",autoresModel.listarAutores());
            model.addAttribute("listaGeneros",generosModel.listarGeneros());
            model.addAttribute("listaEditoriales",editorialesModel.listarEditoriales());
            model.addAttribute("libro", libro);
            model.addAttribute("org.springframework.validation.BindingResult.libro", result);
            return "libros/nuevo";
        }

        if(librosModel.insertarLibro(libro)>0){
            //Si se insertó, se pasa el mensaje de éxito
            atributos.addFlashAttribute("exito","Libro registrado exitosamente");
            //Redirección en el cliente hacia el método listarLibros()
            return "redirect:/libros/list";
        }
        else {
            model.addAttribute("listaAutores",autoresModel.listarAutores());
            model.addAttribute("listaGeneros",generosModel.listarGeneros());
            model.addAttribute("listaEditoriales",editorialesModel.listarEditoriales());
            //Sí no se insertó regresamos al formulario de ingreso
            model.addAttribute("libro",libro);
            return "libros/nuevo";
        }
    }

    @RequestMapping(value = "edit/{codigo}", method = GET)
    public String obtenerLibro(@PathVariable("codigo") String codigo, Model
            model){
        model.addAttribute("libro",
                librosModel.obtenerLibro(codigo));
        model.addAttribute("listaAutores",autoresModel.listarAutores());
        model.addAttribute("listaGeneros",generosModel.listarGeneros());
        model.addAttribute("listaEditoriales",editorialesModel.listarEditoriales());
        return "libros/editar";
    }
    //Este método se ejecuta al enviar el formulario de edición
    @RequestMapping(value = "edit/{codigo}", method = POST)
    public String modificarLibro(@Valid @ModelAttribute("libro") LibrosEntity libro, Model model,
                                     BindingResult result, RedirectAttributes atributos) {
        LibroValidator libroValidator = new LibroValidator();
        libroValidator.validate(libro, result);

        if(result.hasErrors()){
            model.addAttribute("listaAutores",autoresModel.listarAutores());
            model.addAttribute("listaGeneros",generosModel.listarGeneros());
            model.addAttribute("listaEditoriales",editorialesModel.listarEditoriales());
            model.addAttribute("libro", libro);
            model.addAttribute("org.springframework.validation.BindingResult.libro", result);

            return "libros/editar";
        }
        if(librosModel.modificarLibro(libro)>0){
            atributos.addFlashAttribute("exito","Libro modificado exitosamente");
            return "redirect:/libros/list";
        }
        else {
            model.addAttribute("libro",libro);
            return "libros/editar";
        }
    }

    @RequestMapping(value = "delete/{codigo}")
    public String eliminarLibro(@PathVariable("codigo") String codigo, Model
            model, RedirectAttributes atributos){
            model.addAttribute("libro", librosModel.obtenerLibro(codigo));
        if(librosModel.eliminarLibro(codigo)>0){
            atributos.addFlashAttribute("exito","Libro eliminado exitosamente");
        }
        else {
            model.addAttribute("fracaso","no se puede eliminar este libro");
        }
        return "redirect:/libros/list";
    }
}