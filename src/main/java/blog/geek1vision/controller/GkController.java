package controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exception.ResourceNotFoundException;
import modal.GkModal;
import repository.GkRepository;

@RestController
@RequestMapping("/api")
public class GkController {

	@Autowired
	GkModal blog;
	
	@Autowired
	GkRepository repository;
	
	@GetMapping("/blog")
	public List<GkModal> getAllBlog(){
		return repository.findAll();
	}
	
	@PostMapping("/blog")
	public GkModal addBlog(@Valid @RequestBody GkModal blog) {
		return repository.save(blog);
	}
	
	@GetMapping("/blog/{id}")
	public GkModal getOneBlog(@PathVariable Long blogId) {
		return repository.findById(blogId)
				.orElseThrow(()-> new ResourceNotFoundException("Blog", "id", blogId));
	}
	
	@PutMapping("/blog/{id}")
	public GkModal editBlog(@Valid @RequestBody GkModal blog, @PathVariable(value="id") Long blogId ) {
		GkModal blogOne = repository.findById(blogId)
				.orElseThrow(() -> new ResourceNotFoundException("Blog", "id", blogId));
		
		blogOne.setStar(blog.getStar());
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
	public ResponseEntity<?> deleteBlog(@PathVariable(value = "id") Long blogId){
		repository.deleteById(blogId);
		return ResponseEntity.ok().build();
	}
	
	
}
