package ProyectoSprint.app.dto;

import ProyectoSprint.app.dto.UserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class GuestDto {
	private long id;
	private UserDto userId;
	private PartherDto partherId;
	private Boolean guestStatus;
	
}