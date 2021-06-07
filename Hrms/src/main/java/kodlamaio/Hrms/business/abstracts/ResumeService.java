package kodlamaio.Hrms.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Resume;

public interface ResumeService {
	DataResult<List<Resume>> getAll();
	Result add(Resume resume);
	DataResult<Resume> imageUpload(int resumeId, MultipartFile multipartFile) throws IOException;
	DataResult<Resume> getByCandidate_Id(int id);
}
