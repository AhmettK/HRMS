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
@Table(name="employers")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Employer extends User{
	
	@Column(name="company_name")
	@NotEmpty(message = "Boş bırakılamaz")
	private String companyName;
	
	@Column(name="web_adress")
	@NotEmpty(message = "Boş bırakılamaz")
	private String webAdress;
	
	@Column(name="phone_number")
	@NotEmpty(message = "Boş bırakılamaz")
	private String phoneNumber;
}
