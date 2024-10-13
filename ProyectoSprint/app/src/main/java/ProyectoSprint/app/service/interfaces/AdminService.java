package ProyectoSprint.app.service.interfaces;

import ProyectoSprint.app.dto.PartherDto;

public interface AdminService {
	public void createParther(PartherDto partherDto) throws Exception;
	public void createPromotion() throws Exception;
	
	}