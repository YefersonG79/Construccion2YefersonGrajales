package ProyectoSprint.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class UserDto {
    private long id;
    private PersonDto personId;
    private String Username;
    private String Rol;
    private String password;
  
}
