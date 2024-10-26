package ProyectoSprint.app.service.interfaces;

import ProyectoSprint.app.dto.PartnerDto;
import ProyectoSprint.app.dto.UserDto;

public interface AdminService {
    
	public void createPartner(PartnerDto PartnerDto) throws Exception;
}
