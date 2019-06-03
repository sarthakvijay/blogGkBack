package blog.geek1vision.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blog.geek1vision.modal.Josaa;
import blog.geek1vision.repository.JosaaRepository;
import blog.geek1vision.service.DatabaseService;

@RestController
@RequestMapping("/api")
public class DatabaseQuery {

	@Autowired
	JosaaRepository josaaRepo;

	@Autowired
	DatabaseService databaseService;
	
	public static class QueryBody{
		public String category;
		public String institute;
		public String gender;
		public Long higherRank;
		public Long lowerRank;	
		public String quote;
	}

	@CrossOrigin(origins = { "http://www.geek1vision.com", "http://d2rmczqy1xsdmr.cloudfront.net"})
	@PostMapping("/databaseQuery/calculated")
	public List<Josaa> getAll(@Valid @RequestBody QueryBody query) {
		return databaseService.databaseQuery(query.category, query.institute, query.gender, query.higherRank, query.lowerRank, query.quote);
	}

	@CrossOrigin(origins = { "http://www.geek1vision.com", "http://d2rmczqy1xsdmr.cloudfront.net"})
	@GetMapping("/databaseQuery/instituteNames")
	public List getInstituteNames() {
		return josaaRepo.findNitInstitutesName();
	}
	
	@CrossOrigin(origins = { "http://www.geek1vision.com", "http://d2rmczqy1xsdmr.cloudfront.net"})
	@GetMapping("/databaseQuery/iitInstituteNames")
	public List getIitInstituteNames() {
		return josaaRepo.findIitInstitutesName();
	}
	
	@CrossOrigin(origins = { "http://www.geek1vision.com", "http://d2rmczqy1xsdmr.cloudfront.net"})
	@PostMapping("/databaseQuery/iitCalculated")
	public List<Josaa> getAllIit(@Valid @RequestBody QueryBody query) {
		return databaseService.databaseIitQuery(query.category, query.institute, query.gender, query.higherRank, query.lowerRank, query.quote);
	}
}
