package ProyectoSprint.app.controller;

import ProyectoSprint.app.Controllervalidator.PersonValidator;
import ProyectoSprint.app.Controllervalidator.UserValidator;
import ProyectoSprint.app.dto.PersonDto;
import ProyectoSprint.app.dto.UserDto;
import ProyectoSprint.app.dto.PartnerDto;
import ProyectoSprint.app.service.ClubService;
import ProyectoSprint.app.service.interfaces.AdminService;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@Getter
@Setter
@NoArgsConstructor
public class AdminController implements ControllerInterface {

    @Autowired
    private PersonValidator personValidator;
    @Autowired
    private UserValidator userValidador;
    @Autowired
    private AdminService service;
    private static final String MENU = "ingrese la opcion que desea \n 1.Crear Socio \n 2. para cerrar sesion \n";

    public void session() throws Exception {
        boolean session = true;
        while (session) {
            session = menu();
        }

    }

    private boolean menu() {
        try {
            System.out.println("bienvenido " + ClubService.user.getUsername());
            System.out.print(MENU);
            String option = utils.getReader().nextLine();
            return options(option);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    private boolean options(String option) throws Exception {
        switch (option) {
            case "1": {
                this.createPartner();
                return true;
            }
            case "2": {

            }
            case "3": {
                System.out.println("se ha cerrado sesion");
                return false;
            }
            default: {
                System.out.println("ingrese una opcion valida");
                return true;
            }
        }
    }

    private void createPartner() throws Exception {
        System.out.println("ingrese el nombre del Socio");
        String name = utils.getReader().nextLine();
        personValidator.validName(name);
        System.out.println("ingrese la cedula del Socio");
        long document = personValidator.validDocument(utils.getReader().nextLine());
        System.out.println("ingrese el telefono del Socio");
        long Cellphone = personValidator.validCellphone(utils.getReader().nextLine());
        System.out.println("ingrese el nombre de usuario del socio");
        String userName = utils.getReader().nextLine();
        userValidador.validUserName(userName);
        System.out.println("ingrese la contraseña del socio");
        String password = utils.getReader().nextLine();
        PersonDto personDto = new PersonDto();
        personDto.setName(name);
        personDto.setCedula(document);
        personDto.setCelphone(Cellphone);
        UserDto userDto = new UserDto();
        userDto.setPersonId(personDto);
        userDto.setUsername(userName);
        userDto.setPassword(password);
        userDto.setRol("Partner");
        PartnerDto partnerDto = new PartnerDto();
        partnerDto.setUserId(userDto);
        partnerDto.setDatecreated(new Timestamp(System.currentTimeMillis()));
        partnerDto.setMoney(50000);
        partnerDto.setType("regular");
        partnerDto.setUserId(userDto);

        this.service.createPartner(partnerDto);

        System.out.println("se ha creado el usuario exitosamente");
    }

}
