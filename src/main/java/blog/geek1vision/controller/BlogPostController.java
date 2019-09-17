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
import blog.geek1vision.modal.BlogPost;
import blog.geek1vision.repository.BlogPostRepository;
import blog.geek1vision.service.ScoreCalculation;

@RestController
@RequestMapping("/api/rated")
public class BlogPostController {

	@Autowired
	BlogPostRepository blogPostRepository;
	
	@Autowired
	ScoreCalculation scoreCal;

	@CrossOrigin(origins = { "http://www.geek1vision.com", "http://d2rmczqy1xsdmr.cloudfront.net"})
	@GetMapping("/blog")
	public List<BlogPost> getAll() {
		return scoreCal.score(blogPostRepository.findAll());
	}

	@CrossOrigin(origins = { "http://www.geek1vision.com", "http://d2rmczqy1xsdmr.cloudfront.net"})
	@GetMapping("/blog/{id}")
	public BlogPost getOneBlog(@PathVariable(value = "id") Long blogId) {
		return blogPostRepository.findById(blogId)
				.orElseThrow(() -> new ResourceNotFoundException("blog", "id", blogId));
	}

//	@GetMapping("/blog/image/{id}")
//	public String postImage(@PathVariable(value="id") Long blogId) {
//		BlogPost blogOne = blogPostRepository.findById(blogId)
//				.orElseThrow(() -> new ResourceNotFoundException("blog", "id", blogId));
//		String all = blogOne.getContent();
//		String s = "<img src=\"";
//		int ix = all.indexOf(s)+s.length();
//		String finall = all.substring(ix, all.indexOf("\"", ix+1));
//		System.out.println(finall);
//		return finall;
//	}

	@CrossOrigin(origins = { "http://www.geek1vision.com", "http://d2rmczqy1xsdmr.cloudfront.net"})
	@PostMapping("/blog")
	public BlogPost addBlog(@Valid @RequestBody BlogPost blogPost) {
		return blogPostRepository.save(blogPost);
	}

	@CrossOrigin(origins = { "http://www.geek1vision.com", "http://d2rmczqy1xsdmr.cloudfront.net"})
	@DeleteMapping("/blog/{id}")
	public ResponseEntity<?> deleteBlog(@PathVariable(value = "id") Long blogId) {
		blogPostRepository.deleteById(blogId);
		return ResponseEntity.ok().build();
	}

	@CrossOrigin(origins = { "http://www.geek1vision.com", "http://d2rmczqy1xsdmr.cloudfront.net"})
	@PutMapping("/blog/{id}")
	public BlogPost updateBlog(@PathVariable(value = "id") Long blogId, @RequestBody @Valid BlogPost blogPost) {
		BlogPost blogOne = blogPostRepository.findById(blogId)
				.orElseThrow(() -> new ResourceNotFoundException("blog", "id", blogId));

		blogOne.setTags(blogPost.getTags());
		blogOne.setContent(blogPost.getContent());
		blogOne.setImage(blogPost.getImage());
		blogOne.setAuthor(blogPost.getAuthor());
		blogOne.setAboutAuthor(blogPost.getAboutAuthor());
		blogOne.setTitle(blogPost.getTitle());
		blogOne.setSubject(blogPost.getSubject());
		blogOne.setStream(blogPost.getStream());
		blogOne.setDays(blogPost.getDays());

		return blogOne;
	}
}
