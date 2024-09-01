package app.controller.validator;

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