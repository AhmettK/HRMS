package kodlamaio.Hrms.business.abstracts;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.entities.dtos.LoginDto;

public interface UserService {
	DataResult<LoginDto> login(LoginDto loginDto);
}
