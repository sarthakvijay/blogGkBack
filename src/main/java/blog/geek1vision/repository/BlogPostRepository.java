package blog.geek1vision.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import blog.geek1vision.modal.BlogPost;

@CrossOrigin(origins = { "http://www.geek1vision.com", "http://d2rmczqy1xsdmr.cloudfront.net"})
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {

}
