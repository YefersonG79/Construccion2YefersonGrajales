package app.dao.interfaces;

import app.dto.GuestDto;

public interface GuestDao{
    public void createGuest(GuestDto guestDto)throws Exception;
    public boolean existById(GuestDto guesDto) throws Exception;
    public void deleteGuest(GuestDto guestDto) throws Exception;
    public GuestDto findById(GuestDto guestDto) throws Exception;
}