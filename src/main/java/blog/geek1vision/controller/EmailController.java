package blog.geek1vision.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blog.geek1vision.modal.Email;
import blog.geek1vision.modal.GkModal;
import blog.geek1vision.repository.EmailRepository;

@RestController
@RequestMapping("/api")
public class EmailController {

	@Autowired
	EmailRepository emailRepository;

	@CrossOrigin(origins = { "http://www.geek1vision.com", "http://d2rmczqy1xsdmr.cloudfront.net"})
	@GetMapping("/email/subscription")
	public List<Email> getAllEmail() {
		return emailRepository.findAll();
	}
	
	public class EmailObject {
		String message;
		String to;
	}

	@PostMapping("/email")
	@CrossOrigin(origins = { "http://www.geek1vision.com", "http://d2rmczqy1xsdmr.cloudfront.net"})
	public Email addEmail(@Valid @RequestBody Email email) {
		return emailRepository.save(email);
	}

	@DeleteMapping("/email/{email}")
	@CrossOrigin(origins = { "http://www.geek1vision.com", "http://d2rmczqy1xsdmr.cloudfront.net"})
	public ResponseEntity<?> deleteEmail(@PathVariable(value = "email") String email) {
		emailRepository.deleteById(email);
		return ResponseEntity.ok().build();
	}
	
//	@GetMapping("/email/testing")
//	public List<Email> testingFun(){
//		return emailRepository.findByEmail();
//	}

}
