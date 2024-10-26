package ProyectoSprint.app.dto;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PartnerDto {
    private long id;
    private UserDto userId;
    private double money;
    private String type;
    private Timestamp datecreated;
    
}
