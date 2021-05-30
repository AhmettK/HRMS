package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	DataResult<List<JobAdvertisement>> getAll();
	Result add(JobAdvertisement jobAdvertisement);
	Result update(int id);
	DataResult<JobAdvertisement> getById(int id);
	
	DataResult<List<JobAdvertisement>> getByEmployerId(int id,boolean result);
	DataResult<List<JobAdvertisement>> getByIsActive(boolean result);
	DataResult<List<JobAdvertisement>> getByIsActiveSorted();
}
