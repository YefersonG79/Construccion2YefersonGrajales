
package ProyectoSprint.app.dao;


import ProyectoSprint.app.dto.GuestDto;
import ProyectoSprint.app.helpers.Helpers;
import ProyectoSprint.app.model.Guest;
import ProyectoSprint.app.dao.interfaces.GuestDao;
import ProyectoSprint.app.dao.repositories.GuestRepository;
import java.util.Optional;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@NoArgsConstructor
public class Guestdaoimplementation  implements GuestDao{
    @Autowired
    GuestRepository guestrepository;
    
    @Override
     public boolean existsById(GuestDto GuestDto) throws Exception {
         return guestrepository.existsById(GuestDto.getId());
                
	}
    @Override
      public void createGuest(GuestDto GuestDto) throws Exception {	
	Guest guest = Helpers.parse(GuestDto);
        guestrepository.save(guest);
        GuestDto.setId(guest.getId());
	}
      @Override
     public GuestDto getGuestById(long guestId) throws Exception{
         Optional<Guest> optionalGuest = guestrepository.findById(guestId);
               return Helpers.parse(optionalGuest.get());
             
     }
     
     public void ActivateStatus(GuestDto guestDto) throws Exception{
         Guest  guest= Helpers.parse(guestDto);
         guestrepository.save(guest);
     }
}
