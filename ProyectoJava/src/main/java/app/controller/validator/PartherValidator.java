package app.controller.validator;

public class PartherValidator extends CommonsValidator{
    public PartherValidator(){
    }

    public long validAvailableFunds(String availableFunds) throws Exception{
        return super.isValidLong("Los fondos disponibles ", availableFunds);
    }
    public void validSubscriptionType(String subscriptionType ) throws Exception {
		super.isValidString("El tipo de suscripcion ", subscriptionType);
	}

    //Falta validador para los tipos de datos Date, para el atributo membersphipDate
}