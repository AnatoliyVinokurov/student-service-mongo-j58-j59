package telran.java48.student.dao;

import java.util.List;

import telran.java48.student.model.Student;

public interface StudentRepository {
	Student save(Student student);

	Student findById(long id);

	Student deleteById(long id);
	
	List<Student> findAll();
}
