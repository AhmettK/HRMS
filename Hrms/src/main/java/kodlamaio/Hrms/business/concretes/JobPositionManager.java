package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.JobPositionService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.Hrms.entities.concretes.JobPosition;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;

@Service
public class JobPositionManager implements JobPositionService{
	
	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"Meslekler listelendi");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		if(check(jobPosition)) {
			this.jobPositionDao.save(jobPosition);
			return new SuccessResult("Meslek eklendi");
		}
		return new ErrorResult("Ekleme yapılmadı lütfen daha önceden girilmemiş bir meslek kolu seçin");
	}
	
	private boolean check(JobPosition job) {
		
		List<JobPosition> result=jobPositionDao.findAll();
		for (JobPosition jobPosition : result) {
			if (jobPosition.getTitle().equals(job.getTitle())) {
				return false;
			}
		}
		return true;
	}

	

}
