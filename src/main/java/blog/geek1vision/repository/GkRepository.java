package blog.geek1vision.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import blog.geek1vision.modal.GkModal;

@Repository
@CrossOrigin(origins = { "http://www.geek1vision.com", "http://d2rmczqy1xsdmr.cloudfront.net"})
public interface GkRepository extends JpaRepository<GkModal, Long> {

}
