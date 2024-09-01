package app.controller.validator;

public class AvailableFunds extends CommonsValidator{
    public AvailableFunds(){
    }

    public long validAvailableFunds(String availableFunds) throws Exception{
        return super.isValidLong("Los fondos ", availableFunds);
    }
}