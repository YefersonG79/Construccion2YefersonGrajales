
package ProyectoSprint.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class invoiceDetailDto {
    private long id;
    private invoiceDto invoice;
    private int item;
    private String description;
    private double amount;

}
