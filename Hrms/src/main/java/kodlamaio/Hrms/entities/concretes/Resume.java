package kodlamaio.Hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="resumes")
public class Resume {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	@Column(name="github_link")
	private String githubLink;
	
	@Column(name="linkedin_link")
	private String linkedinLink;
	
	@Column(name="photo")
	private String photo;
	
	@OneToMany(mappedBy = "resume")
	private List<School> schools;
	
	@OneToMany(mappedBy = "resume")
	private List<Experience> experiences;
	
	@OneToMany(mappedBy = "resume")
	private List<Language> languages;
	
	@OneToMany(mappedBy = "resume")
	private List<Technology> technologies;
	
	@OneToMany(mappedBy = "resume")
	private List<Picture> pictures;
}
