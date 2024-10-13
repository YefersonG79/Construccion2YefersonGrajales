/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoSprint.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author HP 14 CM
 */
@Getter
@Setter
@NoArgsConstructor
public class InvoiceDetailsDto {
    
    private long id;
    private InvoiceDto invoiceId;
    private int item;
    private String description;
    private double amount;
}
