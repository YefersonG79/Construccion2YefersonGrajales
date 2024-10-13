package ProyectoSprint.app.dao.interfaces;

import ProyectoSprint.app.dto.PartherDto;
import ProyectoSprint.app.dto.UserDto;

public interface PartherDao{
    public void createrParther(PartherDto partherDto) throws Exception;
    public PartherDto findByPartherId (UserDto userDto) throws Exception;
    public void deleteParther (PartherDto partherDto) throws Exception;
}