package kodlamaio.Hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.EmployerService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.Hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İş verenler listelendi");
	}

	@Override
	public Result add(Employer employer) {
		if(checkMail(employer)&&checkDomain(employer)) {
			this.employerDao.save(employer);
			return new SuccessResult("İş veren kaydı yapıldı");
		}
		return new ErrorResult("Girdiğiniz email kullanılmakta yada domaininiz web adresinizle aynı değil.");
	}
	
	private boolean checkMail(Employer employer) {
		List<Employer> result = employerDao.findAll();
		for(Employer employer2:result) {
			if(employer2.getEmail().equals(employer.getEmail())) {
				return false;
			}
		}
		return true;
	}
	
	public boolean checkDomain(Employer employer) {
		String regex = "^[A-Za-z0-9._%+-]+@" + employer.getWebAdress() +"$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(employer.getEmail());
		if(matcher.matches()) {
			return true;
		}
		else {
			return false;
		}
	}

}
