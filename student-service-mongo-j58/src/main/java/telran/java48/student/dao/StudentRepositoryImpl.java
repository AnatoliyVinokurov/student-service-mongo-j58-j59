package telran.java48.student.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import telran.java48.student.model.Student;

@Component
public class StudentRepositoryImpl implements StudentRepository {
	Map<Long, Student> students = new ConcurrentHashMap<>();//так как нашей апликацией будут пользоваться несколько чел одновременнно, то исп потокобезопасную мапу

	@Override
	public Student save(Student student) {
		students.put(student.getId(), student);
		return student;
	}

	@Override
	public Student findById(long id) {
		return students.get(id);
	}

	@Override
	public Student deleteById(long id) {
		return students.remove(id);
	}

	@Override
	public List<Student> findAll() {
		return new ArrayList<Student>(students.values());
	}

}
