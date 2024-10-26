
package ProyectoSprint.app.service.interfaces;

import ProyectoSprint.app.dto.GuestDto;
import ProyectoSprint.app.dto.PartnerDto;
import ProyectoSprint.app.dto.UserDto;

public interface PartnerService {
    public void createGuest(GuestDto GuestDto) throws Exception;
    
     GuestDto getGuestById(long guestId) throws Exception;
     
     public void updateGuestStatus(GuestDto guestDto) throws Exception;
     
      public void addfunds () throws Exception;
      
      public void createinvoice() throws Exception;
}
