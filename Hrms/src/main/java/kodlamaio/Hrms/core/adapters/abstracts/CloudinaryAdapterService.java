package kodlamaio.Hrms.core.adapters.abstracts;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.Hrms.core.utilities.results.DataResult;

public interface CloudinaryAdapterService {
	DataResult<Map> upload(MultipartFile multipartFile) throws IOException;
}
