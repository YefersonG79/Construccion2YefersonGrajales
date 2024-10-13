package ProyectoSprint.app.service;

import java.sql.SQLException;

import ProyectoSprint.app.dao.GuestDaoImplementation;
import ProyectoSprint.app.dao.PartherDaoImplementation;
import ProyectoSprint.app.dao.PersonDaoImplementation;
import ProyectoSprint.app.dao.UserDaoImplementation;
import ProyectoSprint.app.dao.interfaces.GuestDao;
import ProyectoSprint.app.dao.interfaces.InvoiceDao;
import ProyectoSprint.app.dao.interfaces.PartherDao;
import ProyectoSprint.app.dao.interfaces.PersonDao;
import ProyectoSprint.app.dao.interfaces.UserDao;
import ProyectoSprint.app.dto.GuestDto;
import ProyectoSprint.app.dto.InvoiceDto;
import ProyectoSprint.app.dto.PartherDto;
import ProyectoSprint.app.dto.PersonDto;
import ProyectoSprint.app.dto.UserDto;
import ProyectoSprint.app.service.interfaces.AdminService;
import ProyectoSprint.app.service.interfaces.LoginService;
import ProyectoSprint.app.service.interfaces.PartherService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@NoArgsConstructor
@Getter
@Setter
public class ClubService implements LoginService,AdminService,PartherService{
	
    @Autowired
	private UserDao userDao;
    @Autowired
	private PersonDao personDao;
	private InvoiceDao invoiceDao;
	private static UserDto user;
	private PartherDao partherDao;
	private GuestDao guestDao;
	
		
	@Override
	public void createGuest(GuestDto guestDto) throws Exception {
		this.createUser(guestDto.getUserId());
		PartherDto partherDto = partherDao.findByPartherId(user);
		
		//seguir logica
	}

	@Override
	public void createInvoice(InvoiceDto invoiceDto) throws Exception {
		// TODO Auto-generated method stub	
	}

	@Override
	public void createParther(PartherDto partherDto) throws Exception{
		this.createUser(partherDto.getUserId());
		UserDto userDto= userDao.findByUserName(partherDto.getUserId());
		partherDto.setUserId(userDto);
		try {
            this.partherDao.createrParther(partherDto);
		
		}catch (SQLException e) {
			this.personDao.deletePerson(userDto.getPersonId());
			throw new Exception ("No se puedo crear el socio");
		}
	}
	private void createUser(UserDto userDto) throws Exception{
		this.createPerson(userDto.getPersonId());
                if(this.userDao.existsByUserName(userDto)){
                    this.personDao.deletePerson(userDto.getPersonId());
                    throw new Exception("Ya existe un usuario con ese username");
                }
                try{
                    this.userDao.createUser(userDto);
                }catch (SQLException e){
                    this.personDao.deletePerson(userDto.getPersonId());
                }
		

	}

	private void createPerson(PersonDto personDto)throws Exception{
		this.personDao.createPerson(personDto);
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