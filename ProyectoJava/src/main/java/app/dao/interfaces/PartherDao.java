package app.dao.interfaces;

import app.dto.PartherDto;
import app.dto.UserDto;

public interface PartherDao{
    public void createrParther(PartherDto partherDto) throws Exception;
    public PartherDto existById (UserDto userDto) throws Exception;
    public void deleteParther (PartherDto partherDto) throws Exception;
}