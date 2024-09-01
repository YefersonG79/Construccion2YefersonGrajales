package app.controller;

import app.controller.validator.InvoiceValidator;
import app.controller.validator.PersonValidator;
import app.controller.validator.UserValidator;
import app.dto.GuestDto;
import app.dto.InvoiceDto;
import app.dto.PersonDto;
import app.dto.UserDto;



public class PartherController implements ControllerInterface{
	private PersonValidator personValidator;
	private UserValidator userValidator;
	private InvoiceValidator invoiceValidator;
	
	
	
	
	private static final String MENU= "ingrese la opcion que desea \n 1.Para consultar e incrementar fondos  \n 2. Para realizar pedidos\n 3. Para crear invitados \n 4. Desactivar invitados \n 5.cerrar sesion ";
	//private static final String MENU2= "Ingrese la opcion que desea \n 1. Para consultar fondos \n 2. Para incremento de fondos \n 3. Para volver al menu principal";
	public PartherController() {
		this.personValidator= new PersonValidator();
		this.userValidator = new UserValidator();
		this.invoiceValidator= new InvoiceValidator();
	}
	
	@Override 
	public void session() throws Exception {
		boolean session = true ;
		while(session) {
			session= menu();
		}
	}

	private boolean menu() {
		try {
			System.out.println(MENU);
			String option= Utils.getReader().nextLine();
			return options(option);	
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return true;
		}
	}

	private boolean options(String option) throws Exception {
		switch (option) {
		case "1":{
			//this.availableFunds();
			return true ;
		}
		case "2":{
			this.billing();
			return true;
		}
		case "3":{
			this.createGuest();
			return true;
		}
		case "4":{
			this.removerGuest();
		}
		case "5":{
			System.out.println("Se ha cerrado seccion");
			return false;
			}
		default :
			System.out.println("Ingrese una opcion valida");
			return true;	
		}	
		}
    
	
	public void createGuest() throws Exception {
		System.out.println("Ingrese el nombre del invitado");
		String name= Utils.getReader().nextLine();
		personValidator.validName(name);
		System.out.println("Ingrese el documento del invitado");
		long document= personValidator.validDocument(Utils.getReader().nextLine());
		
		System.out.println("Ingrese el nombre de usuario del invitado");
		String userName=Utils.getReader().nextLine();
		userValidator.validName(userName);
		System.out.println("Ingrese la contraseña del invitado");
		String password=Utils.getReader().nextLine();
		userValidator.validPassword(password);
		
		
		PersonDto personDto =new PersonDto();
		personDto.setName(userName);
		personDto.setDocument(document);
		
		UserDto userDto = new UserDto();
		userDto.setRole("invitado");
		userDto.setName(userName);
		userDto.setPassword(password);
		
		GuestDto guestDto = new GuestDto();
		guestDto.setGuestStatus(true);
	}
	
	public void billing () throws Exception{
		System.out.print("Descripcion de los productos");
		String validIntems= Utils.getReader().nextLine();
		invoiceValidator.validItems(validIntems);
		System.out.println("Ingrese el monto de la factura");
		double Total= invoiceValidator.validTotal(Utils.getReader().nextLine());
		
		
		InvoiceDto invoiceDto =new InvoiceDto();
		invoiceDto.setItems(validIntems);
		invoiceDto.setTotal(Total);	
	}

	public void removerGuest () throws Exception{
		System.out.print("Ingrese el documento del invitado: ");
		long document = personValidator.validDocument(Utils.getReader().nextLine());
		System.out.println("¿Desea desactivar el invitado? \n 1. Si \n 2.No");
		String option = Utils.getReader().nextLine();
		boolean removeMenu = true;
		while (removeMenu) { 
			switch (option) {
			case "1" : 
				//this.searchByDocument();
				
				break;
			case "2" : {
				System.out.println("El estado del invitado no se ha modificado");
				removeMenu= false;
				}
			default:
				System.out.println("Ingrese una option valida");
				throw new AssertionError();
		}
		}
	}
		
}