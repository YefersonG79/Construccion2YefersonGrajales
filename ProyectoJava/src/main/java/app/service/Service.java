package app.service;

import java.sql.SQLException;

import app.dao.GuestDaoImplementation;
import app.dao.PartherDaoImplementation;
import app.dao.PersonDaoImplementation;
import app.dao.UserDaoImplementation;
import app.dao.interfaces.GuestDao;
import app.dao.interfaces.InvoiceDao;
import app.dao.interfaces.PartherDao;
import app.dao.interfaces.PersonDao;
import app.dao.interfaces.UserDao;
import app.dto.GuestDto;
import app.dto.InvoiceDto;
import app.dto.PartherDto;
import app.dto.UserDto;
import app.service.interfaces.AdminService;
import app.service.interfaces.LoginService;
import app.service.interfaces.PartherService;
public class Service implements LoginService,AdminService,PartherService{
	
	private UserDao userDao;
	private PersonDao personDao;
	private InvoiceDao invoiceDao;
	private static UserDto user;
	private PartherDao partherDao;
	private GuestDao guestDao;
	
	
	public Service() {
		this.userDao= new UserDaoImplementation();
		this.personDao= new PersonDaoImplementation();
		this.guestDao= new GuestDaoImplementation();
		this.partherDao= new PartherDaoImplementation();
		
		
	}
	
	@Override
	public void createGuest(GuestDto guestDto) throws Exception {
		this.createGuest(guestDto);
	}

	@Override
	public void createInvoice(InvoiceDto invoiceDto) throws Exception {
		// TODO Auto-generated method stub	
	}

	@Override
	public void createParther(PartherDto partherDto) throws Exception{
		this.userDao.createUser(partherDto.getUserId());
		UserDto userDto= userDao.findByUserName(partherDto.getUserId());
		partherDto.setUserId(userDto);
		try {
            this.partherDao.createrParther(partherDto);
		
		}catch (SQLException e) {
			this.personDao.deletePerson(userDto.getPersonId());
			throw new Exception ("No se puedo crear el socio");
		}
	}

	@Override
	public void createPromotion() throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void Login(UserDto userDto) throws Exception {
		UserDto validateDto= userDao.findByUserName(userDto);
		if (validateDto ==null) {
			throw new Exception  ("No existe usuario registrado");
			
		}
		if (!userDto.getPassword().equals(validateDto.getPassword())) {
			throw new Exception ("Usuario o contraseña inconrrecto");
			
		}
		userDto.setRole(validateDto.getRole());
		user =validateDto;
	}
	@Override
	public void logout() {
		user = null;
		System.out.println("se ha cerrado sesion");
	}
	
}