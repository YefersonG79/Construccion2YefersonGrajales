package ProyectoSprint.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="invoice")
@NoArgsConstructor
@Getter
@Setter
public class Invoice {
        @Id
        @Column(name="id")
        @GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
        @JoinColumn(name="personid")
        @ManyToOne
	private Person personId;
        @ManyToOne
        @JoinColumn(name="partnerid")
	private Parther partherId;
        @Column(name="creationdate")
	private Date consumptionDate;
        @Column(name="amount")
	private double total;
        @Column(name="status")
	private boolean status;

}