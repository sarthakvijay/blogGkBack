package blog.geek1vision.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import blog.geek1vision.modal.Email;

@Repository
@CrossOrigin(origins = { "http://www.geek1vision.com", "http://d2rmczqy1xsdmr.cloudfront.net"})
public interface EmailRepository extends JpaRepository<Email, String> {
	
	@Query(value = "SELECT * FROM emails t WHERE t.email = 'sarthakvijay@gmail.com'",
            nativeQuery=true
    )
    public List<Email> findByEmail();
}
