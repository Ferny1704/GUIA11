package sv.edu.udb.www.practica_springmvc.validations;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import sv.edu.udb.www.practica_springmvc.entities.EditorialesEntity;
import sv.edu.udb.www.practica_springmvc.entities.LibrosEntity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class LibroValidator implements Validator {

    @Override
    public boolean supports(Class clazz) {
        return LibrosEntity.class.equals(clazz); // clase del bean al que da soporte este validador
    }
    @Override
    public void validate(Object target, Errors errors) {
        Pattern patCod = Pattern.compile("LIB[0-9]{6}");
        LibrosEntity libro = (LibrosEntity) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codigoLibro",
                "field.codigoLibro.required","El código es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombreLibro",
                "field.nombreLibro.required","El nombre es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "existencias",
                "field.existencias.required","Las existencias son obligatorias");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "precio",
                "field.precio.required","El precio es obligatorio");
        Matcher mat = patCod.matcher(libro.getCodigoLibro());
        if (!mat.matches()) {
            errors.rejectValue("codigoLibro", "field.codigoLibro.invalid", "No coincide el formato de código de libro: LIBXXXXXX");
        }
    }
}