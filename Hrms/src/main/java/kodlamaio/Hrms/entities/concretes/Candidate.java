package kodlamaio.Hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="candidates")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Candidate extends User{
	
	@Column(name="first_name")
	@NotEmpty(message = "Boş bırakılamaz")
	private String firstName;
	
	@Column(name="last_name")
	@NotEmpty(message = "Boş bırakılamaz")
	private String lastName;
	
	@Column(name="identity_number")
	@NotEmpty(message = "Boş bırakılamaz")
	private String identityNumber;
	
	@Column(name="birth_date")
	@NotEmpty(message = "Boş bırakılamaz")
	private int birthDate;
}
