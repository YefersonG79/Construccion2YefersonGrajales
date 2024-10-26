package ProyectoSprint.app.dao.interfaces;

import ProyectoSprint.app.dto.GuestDto;

public interface GuestDao {
   public boolean existsById(GuestDto GuestDto) throws Exception;
   public void createGuest(GuestDto GuestDto) throws Exception;
   public GuestDto getGuestById(long guestId) throws Exception;
   public void ActivateStatus(GuestDto guestDto) throws Exception;
}