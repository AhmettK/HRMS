package kodlamaio.Hrms.business.concretes;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.Hrms.business.abstracts.ResumeService;
import kodlamaio.Hrms.core.adapters.abstracts.CloudinaryAdapterService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.Hrms.entities.concretes.Resume;
import lombok.var;

@Service
public class ResumeManager implements ResumeService{
	
	private ResumeDao resumeDao;
	private CloudinaryAdapterService cloudinaryAdapterService;
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao,CloudinaryAdapterService cloudinaryAdapterService) {
		super();
		this.resumeDao = resumeDao;
		this.cloudinaryAdapterService = cloudinaryAdapterService;
	}

	@Override
	public DataResult<List<Resume>> getAll() {
		return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll(),"CV'ler listelendi");
	}

	@Override
	public Result add(Resume resume) {
		this.resumeDao.save(resume);
		return new SuccessResult("CV eklendi");
	}

	@Override
	public DataResult<Resume> imageUpload(int resumeId, MultipartFile multipartFile) throws IOException {
		Resume resume = this.resumeDao.findById(resumeId).get();
		var result = this.cloudinaryAdapterService.upload(multipartFile);
		resume.setPhoto(result.getData().get("url").toString());
		this.resumeDao.save(resume);
		return new SuccessDataResult<>("Foto eklendi");
	}

	@Override
	public DataResult<Resume> getByCandidate_Id(int id) {
		return new SuccessDataResult<Resume>(this.resumeDao.getByCandidate_Id(id));
	}
}
