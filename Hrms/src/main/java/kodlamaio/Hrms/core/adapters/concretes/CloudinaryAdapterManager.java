package kodlamaio.Hrms.core.adapters.concretes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.Hrms.core.adapters.abstracts.CloudinaryAdapterService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;

@Service
public class CloudinaryAdapterManager implements CloudinaryAdapterService{
	
	Cloudinary cloudinary;
    private Map<String,String> valuesMap=new HashMap<>();
    
    @Autowired
    public CloudinaryAdapterManager(){
        valuesMap.put("cloud_name","dxsfyp8lj");
        valuesMap.put("api_key", "253486559789421");
        valuesMap.put("api_secret","UQ5RkM2lW3TUpH-FTxi5OZSNnpI");
        cloudinary=new Cloudinary(valuesMap);
    }
    
    @Override
    public DataResult<Map> upload(MultipartFile multipartFile) throws IOException{
        File file= convert(multipartFile);
        Map result=cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        file.delete();
        return new SuccessDataResult<>(result);
    }
    
    public File convert(MultipartFile multipartFile) throws IOException {
        File file=new File(multipartFile.getOriginalFilename());
        FileOutputStream stream=new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();
        return file;
    }
	
}
