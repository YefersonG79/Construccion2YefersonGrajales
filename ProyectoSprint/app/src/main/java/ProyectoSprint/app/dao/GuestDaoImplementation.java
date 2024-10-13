package ProyectoSprint.app.dao;

import ProyectoSprint.app.dao.repositories.GuestRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ProyectoSprint.app.dao.interfaces.GuestDao;
import ProyectoSprint.app.dto.GuestDto;
import ProyectoSprint.app.helpers.Helper;
import ProyectoSprint.app.model.Guest;
import ProyectoSprint.app.model.User;

public class GuestDaoImplementation implements GuestDao{
    
    GuestRepository guestRepository;
    @Override
    public void createGuest(GuestDto guestDto)throws Exception{
        Guest guest = Helper.parse(guestDto);
        guestRepository.save(guest);
    }	

    @Override
    public boolean existById(GuestDto guestDto) throws Exception {
	return guestRepository.existsById(guestDto.getId());
	}
	
    @Override
	public void deleteGuest (GuestDto guestDto) throws Exception{
		Guest guest = Helper.parse(guestDto);
		guestRepository.delete(guest);
	}

    @Override
    public GuestDto findByGuestId(GuestDto guestDto) throws Exception{
        Guest guest = guestRepository.findById(guestDto.getId());
        return Helper.parse(guest);
    }
	
}