package ProyectoSprint.app.controller.validator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Getter
@Setter
public class InvoiceValidator extends CommonsValidator{
    
    public void validItems(String items) throws Exception {
		super.isValidString("Los Items de la factura: ", items);
	}
    public double validTotal(String total) throws Exception{
        return super.isValidDouble("El total de la factura", total);
    }
    
    public int validItem(String items)throws Exception {
		return super.isValidInteger("items de la factura", items);
	}
    
}