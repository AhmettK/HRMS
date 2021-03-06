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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_advertisements")
public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name="job_position_id")
	private JobPosition jobPosition;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="city")
	private String city;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="quota")
	private int quota;
	
	@Column(name="deadline")
	private Date deadline;
	
	@Column(name="release_date")
	private Date releaseDate;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="work_type")
	private String workType;
	
	@Column(name="work_time")
	private String workTime;
	
	@Column(name="is_confirmed")
	private boolean isConfirmed;
}
