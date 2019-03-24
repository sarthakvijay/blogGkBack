package blog.geek1vision.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import blog.geek1vision.modal.Email;

@Repository
@CrossOrigin(origins = {"http://d2rmczqy1xsdmr.cloudfront.net", "http://www.geek1vision.com/"})
public interface EmailRepository extends JpaRepository<Email, String> {

}