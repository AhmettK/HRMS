package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.CandidateService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.Hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{
	
	private CandidateDao candidateDao;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"İş arayanlar listelendi");
	}

	@Override
	public Result add(Candidate candidate) {
		if(checkMail(candidate)&&checkIdentity(candidate)) {
			this.candidateDao.save(candidate);
			return new SuccessResult("İş arayan kaydı yapıldı");
		}
		return new ErrorResult("Girdiğiniz email veya tc kullanılmakta");
	}
	
	private boolean checkMail(Candidate candidate) {
		List<Candidate> result = candidateDao.findAll();
		for(Candidate candidate2:result) {
			if(candidate2.getEmail().equals(candidate.getEmail())) {
				return false;
			}
		}
		return true;
	}
	
	private boolean checkIdentity(Candidate candidate) {
		List<Candidate> result = candidateDao.findAll();
		for(Candidate candidate2:result) {
			if(candidate2.getIdentityNumber().equals(candidate.getIdentityNumber())) {
				return false;
			}
		}
		return true;
	}

}
