package ProyectoSprint.app.dao.interfaces;

import ProyectoSprint.app.dto.UserDto;

public interface UserDao {
	public UserDto findByUsername(UserDto userDto) throws Exception;
	public boolean existsByUsername(UserDto userDto) throws Exception;
	public void createUser(UserDto userDto) throws Exception;
}
