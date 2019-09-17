package blog.geek1vision.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import blog.geek1vision.modal.Email;
import blog.geek1vision.modal.Josaa;

@CrossOrigin(origins = { "http://www.geek1vision.com", "http://d2rmczqy1xsdmr.cloudfront.net" })
public interface JosaaRepository extends JpaRepository<Josaa, Long> {

	@Query(value = "SELECT DISTINCT Institute_Name FROM iit_ranks", nativeQuery = true)
	public List findIitInstitutesName();

	@Query(value = "SELECT DISTINCT Institute_Name FROM ranking_datavalue1", nativeQuery = true)
	public List findNitInstitutesName();

}
