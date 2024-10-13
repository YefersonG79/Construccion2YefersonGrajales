package ProyectoSprint.app.dao;

import ProyectoSprint.app.dao.repositories.UserRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ProyectoSprint.app.dao.interfaces.UserDao;
import ProyectoSprint.app.dto.UserDto;
import ProyectoSprint.app.helpers.Helper;
import ProyectoSprint.app.model.Person;
import ProyectoSprint.app.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@Getter
@Setter
public class UserDaoImplementation implements UserDao {
    
    @Autowired
    UserRepository userRepository;
    @Override 
	public UserDto findByUserName(UserDto userDto) throws Exception {
            User user = userRepository.findByUsername(userDto.getName());
            return Helper.parse(user);
            }
	@Override 
	public boolean existsByUserName(UserDto userDto) throws Exception {
		return userRepository.existsByUsername(userDto.getName());
	}
	
	@Override 
	public void createUser(UserDto useDto) throws Exception{
		User user = Helper.parse(useDto);
		userRepository.save(user);
	}
}