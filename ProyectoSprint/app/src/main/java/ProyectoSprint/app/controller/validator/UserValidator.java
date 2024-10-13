package ProyectoSprint.app.controller.validator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Getter
@Setter
public class UserValidator extends CommonsValidator{
    public void validName(String name) throws Exception{
        super.isValidString("El nombre de usuario", name);
    }
    public void validPassword(String password) throws Exception{
        super.isValidString("La contraseña: ", password);
    }
    public void validRole(String role) throws Exception{
        super.isValidString("El rol: ", role);
    }
}