package kodlamaio.Hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="schools")
public class School {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="resume_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Resume resume;
	
	@NotBlank
	@NotNull
	@Column(name="school_name")
	private String schoolName;
	
	@NotBlank
	@NotNull
	@Column(name="school_department")
	private String schoolDepartment;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="finish_date")
	private Date finishDate;
	
}
