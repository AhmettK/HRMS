package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Experience;

public interface ExperienceService {
	DataResult<List<Experience>> getAll();
	Result add(Experience experience);
	
	DataResult<List<Experience>> getAllSorted();
	DataResult<List<Experience>> getByResumeId(int id);
}
