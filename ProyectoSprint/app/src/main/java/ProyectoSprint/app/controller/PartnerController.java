
package ProyectoSprint.app.controller;


import ProyectoSprint.app.dto.GuestDto;
import java.sql.Date;
import ProyectoSprint.app.Controllervalidator.PersonValidator;
import ProyectoSprint.app.Controllervalidator.UserValidator;
import ProyectoSprint.app.dto.PersonDto;
import ProyectoSprint.app.dto.UserDto;
import ProyectoSprint.app.service.interfaces.PartnerService;
import ProyectoSprint.app.dao.interfaces.PartnerDao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ProyectoSprint.app.dao.interfaces.PersonDao;


@Controller
@Getter
@Setter
@NoArgsConstructor
public class PartnerController implements ControllerInterface{
    @Autowired
    private PersonValidator personValidator;
    @Autowired
    private UserValidator userValidador;
    @Autowired
    private PartnerService service;
    @Autowired
    private PartnerDao partnerDao;
    @Autowired 
    private PersonDao persondao;
    private static final String MENU = "Ingrese la opcion la accion que desea hacer \n 1..Crear invitado\n 2. para cerrar sesion \n 3.Activar invitado \n 4.Desactivar invitado \n 5.Agregar Fondos  \n 6.Realizar Consumo ";

   
    
    
    public void session() throws Exception {
		boolean session = true;
		while (session) {
			session = PartnerSession();
		}

	}
    private boolean PartnerSession() {
		try {
			System.out.println(MENU);
			String option = utils.getReader().nextLine();
			return menu(option);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return true;
		}
	}
     private boolean menu(String option) throws Exception {
		switch (option) {
		case "1": {
			this.CreateGuest();
			return true;
		}
		case "2": {
			System.out.println("se ha cerrado sesion");
			return false;
		}
                case "3": {
                    this.activateguest();
                    return true;
                }
                case "4":{
                    this.desactivateguest();
                    return true;
                }
                case "5":{
                    this.addfunds();
                    return true;
                }
                case "6":{
                    this.createinvoice();
                    return true;
                }
		default: {
			System.out.println("opcion invalida");
			return true;
		}
		}

	}
     public void CreateGuest() throws Exception{
       System.out.println("ingrese el nombre del Invitado");
		String name = utils.getReader().nextLine();
		personValidator.validName(name);
		System.out.println("ingrese la cedula del Invitado");
		long document = personValidator.validDocument(utils.getReader().nextLine());
                System.out.println("ingrese el telefono del Invitado");
                long Cellphone = personValidator.validCellphone(utils.getReader().nextLine());
		System.out.println("ingrese el nombre de usuario del Invitado");
		String userName = utils.getReader().nextLine();
		userValidador.validUserName(userName);
                System.out.println("ingrese la contraseña del Invitado");
		String password =utils.getReader().nextLine();
		
                
                
                
                
		PersonDto personDto = new PersonDto();
		personDto.setName(name);
		personDto.setCedula(document);
		personDto.setCelphone(Cellphone);
		UserDto userDto = new UserDto();
		userDto.setPersonId(personDto);
		userDto.setUsername(userName);
		userDto.setPassword(password);
		userDto.setRol("Guest");
                GuestDto guestDto = new GuestDto();
                guestDto.setUser(userDto);

		this.service.createGuest(guestDto);
         
		System.out.println("se ha creado el usuario exitosamente");
	}
     
    public void activateguest() throws Exception {
         
         System.out.println("Ingrese el ID del invitado para activar");
         long id = Long.parseLong(utils.getReader().nextLine());
         GuestDto guestDto = service.getGuestById(id);
         guestDto.setStatus("Activo");
         
         service.updateGuestStatus(guestDto);
         System.out.println("Se ha activado el usuario exitosamente");
       
         
    }
    
    public void desactivateguest() throws Exception{
        System.out.println("Ingrese el ID del invitado para desactivar");
        long id= Long.parseLong(utils.getReader().nextLine());
        GuestDto guestdto = service.getGuestById(id);
        guestdto.setStatus("Inactivo");
        service.updateGuestStatus(guestdto);
        System.out.println("Se ha desactivado exitosamente");
        
    }
   public void addfunds () throws Exception {
       this.service.addfunds();
   }
   public void createinvoice() throws Exception {
       this.service.createinvoice();
       
   }
}
