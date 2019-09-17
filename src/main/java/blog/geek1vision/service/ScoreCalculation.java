package blog.geek1vision.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import blog.geek1vision.modal.BlogPost;

@Service
public class ScoreCalculation {

	@Autowired
	@Qualifier(value = "ScoreCalculation")
	BlogPost blogPost;

	public List<BlogPost> score(List<BlogPost> blogData) {
		int n = blogData.size();
		IntStream.range(0, n).forEach(key -> {
			BlogPost blogPost = blogData.get(key);
			double rating = blogPost.getRating();
			double days = blogPost.getDays();
			Date dateC = blogPost.getCreatedAt();
			Date dateN = new Date();
			long diff = Math.abs(dateC.getTime() - dateN.getTime());
			long diffHours = diff / (60 * 60 * 1000);

			if (diffHours / 24 > days) {
				rating = rating - Math.ceil(Math.log10(diffHours / 24 - days));
			}
			double v = Math.random();
			double views = v * 100;
			long score = (long) ((views * rating / (4 * diffHours)) * 1000);
			blogPost.setScore(score);
		});

		IntStream.range(0, n - 1).forEach(i -> {
			IntStream.range(0, n - i - 1).forEach(j -> {
				BlogPost a = blogData.get(j);
				BlogPost b = blogData.get(j + 1);
				if (b.getScore() > a.getScore()) {
					blogData.set(j, b);
					blogData.set(j + 1, a);
				}
			});
		});

		Collections.sort(blogData);

		return blogData;
	}

}
