package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.Hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	
	List<JobAdvertisement> getByEmployerIdAndIsActive(int id,boolean result);
	
	List<JobAdvertisement> getByIsActive(boolean result);
	
	@Query("From JobAdvertisement WHERE is_active=true ORDER BY deadline ASC")
	List<JobAdvertisement> getByIsActiveSorted();
}
