package app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import app.config.MYSQLConnection;
import app.dao.interfaces.GuestDao;
import app.dto.GuestDto;
import app.helpers.Helper;
import app.model.Guest;
import app.model.User;

public class GuestDaoImplementation implements GuestDao{
    @Override
    public void createGuest(GuestDto guestDto)throws Exception{
        Guest guest = Helper.parse(guestDto);
        String query = "INSERT INTO GUEST (USERID, PARTHERID, STATUS) VALUES (?,?,?)";
        PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
        preparedStatement.setLong(1, guest.getUserId().getId());
        preparedStatement.setLong(2, guest.getPartherId().getId());
        preparedStatement.setBoolean(3, guest.getGuestStatus());
        preparedStatement.execute();
        preparedStatement.close();
    }	

    @Override
    public boolean existById(GuestDto guestDto) throws Exception {
		String query = "SELECT 1 FROM GUEST WHERE USERID = ?";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setLong(1, guestDto.getId());
		ResultSet resulSet = preparedStatement.executeQuery();
		boolean exists= resulSet.next();
		resulSet.close();
		preparedStatement.close();
		return exists;
	}
	
    @Override
	public void deleteGuest (GuestDto guestDto) throws Exception{
		Guest guest = Helper.parse(guestDto);
		String query= "DELETE FROM GUEST WHERE IDUSER = ?";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setLong(1, guest.getUserId().getId());
		preparedStatement.execute();
		preparedStatement.close();
	}

    @Override
    public GuestDto findByGuestId(GuestDto guestDto) throws Exception{
        String query = "SELECT ID,USERID,PARTHERID,STATUS FROM GUEST WHERE USERID =?";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setLong(1, guestDto.getId());
		ResultSet resulSet = preparedStatement.executeQuery();
		if(resulSet.next()) {
			Guest guest = new Guest();
			guest .setId(resulSet.getLong("ID"));
			guest.setGuestStatus(resulSet.getBoolean("STATUS"));
			User user = new User();
			user.setId(resulSet.getLong("USERID"));
			guest.setUserId(user);
			resulSet.close();
			preparedStatement.close();
			return Helper.parse(guest);
		}
		resulSet.close();
		preparedStatement.close();
		return null;
    }
	
}