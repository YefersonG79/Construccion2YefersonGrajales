package ProyectoSprint.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.sql.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="partner")
@Setter
@Getter
@NoArgsConstructor
public class Parther {
        @Id
        @Column(name="id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
        //No exite en la DB personId en la tabla Partner entonces para que se puso????????????¡
        @OneToOne
        @JoinColumn(name="userid")
	private User userId;
        @Column(name="amount")
	private long availableFunds;
        @Column(name="type")
	private String subscriptionType;
        @Column(name="creationdate")
	private Date membersphipDate;
	
}