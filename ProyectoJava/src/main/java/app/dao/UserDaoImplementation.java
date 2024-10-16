package app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import app.config.MYSQLConnection;
import app.dao.interfaces.UserDao;
import app.dto.UserDto;
import app.helpers.Helper;
import app.model.Person;
import app.model.User;

public class UserDaoImplementation implements UserDao {
	@Override 
	public UserDto findByUserName(UserDto userDto) throws Exception {
		String query = "SELECT ID,USERNAME,PASSWORD,ROLE,PERSONNID FROM USER WHERE USERNAME = ?";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setString(1, userDto.getName());
		ResultSet resulSet = preparedStatement.executeQuery();
		if (resulSet.next()) {
			User user = new User();
			user.setId(resulSet.getLong("ID"));
			user.setName(resulSet.getString("USERNAME"));
			user.setPassword(resulSet.getString("PASSWORD"));
			user.setRole(resulSet.getString("ROLE"));
			Person person = new Person();
			person.setDocument(resulSet.getLong("PERSONNID"));
			user.setPersonid(person);
			resulSet.close();
			preparedStatement.close();
			return Helper.parse(user);
		}
		resulSet.close();
		preparedStatement.close();
		return null;

	}
	@Override 
	public boolean existsByUserName(UserDto userDto) throws Exception {
		String query ="SELECT 1 FROM USER WHERE USERNAME = ?";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setString(1, userDto.getName());
		ResultSet resulSet = preparedStatement.executeQuery();
		boolean exists= resulSet.next();
		resulSet.close();
		preparedStatement.close();
		return exists;
	}
	
	@Override 
	public void createUser(UserDto useDto) throws Exception{
		User user = Helper.parse(useDto);
		String query = "INSERT INTO USER(USERNAME,PASSWORD,PERSONNID,ROLE) VALUES (?,?,?,?)";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setString(1,user.getName());
		preparedStatement.setString(2, user.getPassword());
		preparedStatement.setLong(3, user.getPersonid().getId());
		preparedStatement.setString(4, user.getRole());
		preparedStatement.execute();
		preparedStatement.close();
	}
}