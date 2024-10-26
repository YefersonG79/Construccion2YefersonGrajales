package ProyectoSprint.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class PersonDto {
    private long id;
    private long Cedula;
    private String name;
    private long celphone;
}

