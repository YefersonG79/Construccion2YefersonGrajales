package ProyectoSprint.app.controller.validator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Getter
@Setter
public class AvailableFunds extends CommonsValidator{
    

    public long validAvailableFunds(String availableFunds) throws Exception{
        return super.isValidLong("Los fondos ", availableFunds);
    }
}