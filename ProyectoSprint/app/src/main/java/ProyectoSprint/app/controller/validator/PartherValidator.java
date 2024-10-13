package ProyectoSprint.app.controller.validator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Getter
@Setter
public class PartherValidator extends CommonsValidator{
   
    public long validAvailableFunds(String availableFunds) throws Exception{
        return super.isValidLong("Los fondos disponibles ", availableFunds);
    }
    public void validSubscriptionType(String subscriptionType ) throws Exception {
		super.isValidString("El tipo de suscripcion ", subscriptionType);
	}

    //Falta validador para los tipos de datos Date, para el atributo membersphipDate
}