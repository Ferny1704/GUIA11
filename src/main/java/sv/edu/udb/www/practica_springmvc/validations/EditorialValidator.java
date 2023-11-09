package sv.edu.udb.www.practica_springmvc.validations;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import sv.edu.udb.www.practica_springmvc.entities.EditorialesEntity;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditorialValidator implements Validator {
    @Override
    public boolean supports(Class clazz) {
        return EditorialesEntity.class.equals(clazz); // clase del bean al que da soporte este validador
    }
    @Override
    public void validate(Object target, Errors errors) {
        Pattern patTelefono = Pattern.compile("[267][0-9]{3}-[0-9]{4}");
        EditorialesEntity editorial = (EditorialesEntity) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codigoEditorial",
                "field.codigoEditorial.required","El código es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombreEditorial",
                "field.nombreEditorial.required","El nombre es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contacto",
                "field.contacto.required","El contacto es obligatorio");
        Matcher mat = patTelefono.matcher(editorial.getTelefono());
        if (!mat.matches()) {
            errors.rejectValue("telefono", "field.telefono.invalid", "No coincide el formato de número telefónico");
        }
    }
}