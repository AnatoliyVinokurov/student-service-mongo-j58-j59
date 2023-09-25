package telran.java48.post.dao;

import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.MongoRepository;

import telran.java48.post.model.Post;

public interface PostRepository extends MongoRepository<Post, String> {
	Stream<Post> findByAuthorIgnoreCase(String author);

}
