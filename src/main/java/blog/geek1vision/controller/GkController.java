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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blog.geek1vision.exception.ResourceNotFoundException;
import blog.geek1vision.modal.GkModal;
import blog.geek1vision.repository.GkRepository;

@RestController
@RequestMapping("/api")
public class GkController {

	@Autowired
	GkRepository repository;

	@GetMapping("/blog")
	@CrossOrigin(origins = { "http://d2rmczqy1xsdmr.cloudfront.net", "http://www.geek1vision.com/" })
	public List<GkModal> getAllBlog() {
		return repository.findAll();
	}

	@PostMapping("/blog")
	@CrossOrigin(origins = { "http://d2rmczqy1xsdmr.cloudfront.net", "http://www.geek1vision.com/" })
	public GkModal addBlog(@Valid @RequestBody GkModal blog) {
		return repository.save(blog);
	}

	@GetMapping("/blog/{id}")
	@CrossOrigin(origins = { "http://d2rmczqy1xsdmr.cloudfront.net", "http://www.geek1vision.com/" })
	public GkModal getOneBlog(@PathVariable(value = "id") Long blogId) {
		return repository.findById(blogId).orElseThrow(() -> new ResourceNotFoundException("Blog", "id", blogId));
	}

	@PutMapping("/blog/{id}")
	@CrossOrigin(origins = { "http://d2rmczqy1xsdmr.cloudfront.net", "http://www.geek1vision.com/" })
	public GkModal editBlog(@Valid @RequestBody GkModal blog, @PathVariable(value = "id") Long blogId) {
		GkModal blogOne = repository.findById(blogId)
				.orElseThrow(() -> new ResourceNotFoundException("Blog", "id", blogId));

		blogOne.setTags(blog.getTags());
		blogOne.setContent(blog.getContent());
		blogOne.setAuthor(blog.getAuthor());
		blogOne.setAboutAuthor(blog.getAboutAuthor());
		blogOne.setTitle(blog.getTitle());
		blogOne.setSubject(blog.getSubject());
		blogOne.setStream(blog.getStream());
		return blogOne;
	}

	@DeleteMapping("blog/{id}")
	@CrossOrigin(origins = { "http://d2rmczqy1xsdmr.cloudfront.net", "http://www.geek1vision.com/" })
	public ResponseEntity<?> deleteBlog(@PathVariable(value = "id") Long blogId) {
		repository.deleteById(blogId);
		return ResponseEntity.ok().build();
	}

}
