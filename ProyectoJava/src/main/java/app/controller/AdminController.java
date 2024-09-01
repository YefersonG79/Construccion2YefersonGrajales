package app.controller;

import java.sql.Date;

import app.controller.validator.PersonValidator;
import app.controller.validator.UserValidator;
import app.dto.PartherDto;
import app.dto.PersonDto;
import app.dto.UserDto;
import app.service.Service;
import app.service.interfaces.AdminService;


public class AdminController implements ControllerInterface {
	private PersonValidator personValidator;
	private UserValidator userValidator;
	private AdminService service;
	
	private static final String MENU ="ingrese la opcion que desea \n 1.Crear socio \n 2. Visualizar facturas  \n 3. Promocion VIP \n  4. Cerrar sesion";

	public AdminController() {
		this.personValidator = new PersonValidator();
		this.userValidator = new UserValidator();
		this.service = new Service();
	}
	@Override
	public void session() throws Exception {
		boolean session = true;
		while (session) {
			session= menu();
		}
	}
	private boolean options(String option) throws Exception {
		switch (option) {
		case "1" :{
			this.createParther();
			return true;
		}
		case "2":{
			//this.invoiceDisplay();
			return true;
		}
		case"3":{
			//this.createPromotion();
			return true;
		}
		case"4":{
			System.out.println("Se ha cerrado sesion");
			return false;
		}
		default:{
			System.out.println("Ingrese una opcion valida");
			return true;
		}
		
		}
	}
		
	private boolean menu() {
			try {
				System.out.print(MENU);
				String option= Utils.getReader().nextLine();
				return options(option);
				
				
			}catch (Exception e) {
				System.out.println(e.getMessage());		
				return true;
				}	
		}
	private void createParther() throws Exception {
		System.out.println("Ingrese el nombre del socio");
		String name= Utils.getReader().nextLine();
		personValidator.validName(name);
		System.out.println("Ingrese la cedula del socio");
		long document= personValidator.validDocument(Utils.getReader().nextLine());
		System.out.println("Ingrese el numero de telefono del socio");
		long phoneNumber= personValidator.validPhoneNumber(Utils.getReader().nextLine());
		System.out.println("Ingrese el nombre de usuario del socio");
		String userName= Utils.getReader().nextLine();
		userValidator.validName(userName);
		System.out.println("Ingrese la contraseña del socio");
		String password= Utils.getReader().nextLine();
		userValidator.validPassword(password);
		
		PersonDto personDto = new PersonDto();
		personDto.setName(name);
		personDto.setDocument(document);
        personDto.setPhoneNumbre(phoneNumber);
		
		UserDto userDto= new UserDto();
		userDto.setRole("parther");
		userDto.setPassword(password);
		userDto.setName(userName);
	
		userDto.setPersonid(personDto);
		PartherDto partherDto = new PartherDto();
		partherDto.setMembersphipDate(new Date(System.currentTimeMillis()));
		partherDto.setUserId(userDto);
		partherDto.setAvailableFunds(50000);
		partherDto.setSubscriptionType("Regular");	
	}

}