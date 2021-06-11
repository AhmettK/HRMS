package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.ExperienceService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.ExperienceDao;
import kodlamaio.Hrms.entities.concretes.Experience;

@Service
public class ExperienceManager implements ExperienceService{
	
	private ExperienceDao experienceDao;
	
	@Autowired
	public ExperienceManager(ExperienceDao experienceDao) {
		super();
		this.experienceDao = experienceDao;
	}

	@Override
	public DataResult<List<Experience>> getAll() {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.findAll(),"Tecrübeler getirildi");
	}

	@Override
	public Result add(Experience experience) {
		this.experienceDao.save(experience);
		return new SuccessResult("Tecrübe kaydedildi");
	}

	@Override
	public DataResult<List<Experience>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"finishDate");
		return new SuccessDataResult<List<Experience>>(this.experienceDao.findAll(sort));
	}

	@Override
	public DataResult<List<Experience>> getByResumeId(int id) {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.getByResume_Id(id));
	}

}
