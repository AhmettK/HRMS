package kodlamaio.Hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.UserService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.dataAccess.abstracts.UserDao;
import kodlamaio.Hrms.entities.concretes.User;
import kodlamaio.Hrms.entities.dtos.LoginDto;

@Service
public class UserManager implements UserService{
	
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<LoginDto> login(LoginDto loginDto) {
		User user = userDao.findByEmail(loginDto.getEmail());
		if(user==null) {
			return new ErrorDataResult<LoginDto>("Hatalı email");
		}
		if(!user.getPassword().equals(loginDto.getPassword())) {
			return new ErrorDataResult<LoginDto>("Hatalı şifre");
		}
		return new SuccessDataResult<LoginDto>(loginDto,"Giriş başarılı");
	}

}
