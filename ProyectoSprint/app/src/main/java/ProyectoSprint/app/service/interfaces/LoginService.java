package ProyectoSprint.app.service.interfaces;
import ProyectoSprint.app.dto.UserDto;
public interface LoginService {
	public void Login(UserDto userDto) throws Exception;
	public void logout ();

}