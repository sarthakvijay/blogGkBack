package blog.geek1vision.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blog.geek1vision.service.EmailService;

@RestController
@RequestMapping("/api")
public class MailApis {

	@Autowired
	private EmailService emailService;

	public static class EmailBody{
		public Long mobile;
		public String email;
		public String message;
		public String name;
	}

	@PostMapping("/email/smtp")
	@CrossOrigin(origins = { "http://www.geek1vision.com", "http://d2rmczqy1xsdmr.cloudfront.net"})
	public String addBlog(@Valid @RequestBody EmailBody emailBody ) throws Exception {
		String to = "contact@geek1vision.com";
		return emailService.sendMail(to, emailBody.mobile, emailBody.email, emailBody.message, emailBody.name);
	}
}
