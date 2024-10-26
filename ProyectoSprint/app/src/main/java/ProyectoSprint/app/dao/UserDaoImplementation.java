
package ProyectoSprint.app.dao;

import ProyectoSprint.app.dao.interfaces.UserDao;
import ProyectoSprint.app.dto.UserDto;
import ProyectoSprint.app.dao.repositories.UserRepository;
import ProyectoSprint.app.helpers.Helpers;
import ProyectoSprint.app.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@NoArgsConstructor
public  class UserDaoImplementation implements UserDao {
        @Autowired
        UserRepository userRepository;
         public UserDto findByUsername(UserDto userDto) throws Exception {
             
		User user =userRepository.findByUsername(userDto.getUsername());
                if (user == null) {
        throw new Exception("Usuario no encontrado");
    }
                return Helpers.parse(user);
	}
    public boolean existsByUsername(UserDto userDto) throws Exception {
		return userRepository.existsByUsername(userDto.getUsername());
		}
    public void createUser(UserDto userDto) throws Exception {
		User user = Helpers.parse(userDto);
		userRepository.save(user);
                userDto.setId(user.getId());
    }
}


    
   