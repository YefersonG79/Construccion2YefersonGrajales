package app.controller.validator;

public class InvoiceValidator extends CommonsValidator{
    public InvoiceValidator(){
    }

    public void validItems(String items) throws Exception {
		super.isValidString("Los Items de la factura: ", items);
	}
    public double validTotal(String total) throws Exception{
        return super.isValidDouble("El total de la factura", total);
    }
}