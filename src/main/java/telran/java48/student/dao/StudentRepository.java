package telran.java48.student.dao;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import telran.java48.student.model.Student;

public interface StudentRepository extends MongoRepository<Student, Long> {
	Stream<Student> findByNameIgnoreCase(String name);
	
	long countByNameInIgnoreCase(List<String> names);
	
	@Query("{'scores.?0': {'$gt': ?1}}")
	Stream<Student> findByExamAndScoreGreaterThan(String exam, int score);
}
